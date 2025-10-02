package edu.UPAO.proyecto.Service;

import edu.UPAO.proyecto.DAO.VentaDAO;
import edu.UPAO.proyecto.Modelo.Venta;
import edu.UPAO.proyecto.Modelo.DetalleVenta;
import edu.UPAO.proyecto.DAO.*;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DashboardVentasService {

    private final VentaDAO ventaDAO = new VentaDAO();
    // Ajusta el patrón si tu campo Fecha NO tiene hora (por ejemplo "yyyy-MM-dd")
    private final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /** Punto único: devuelve todo lo que la UI necesita según filtros */
    public Map<String, Object> consultar(LocalDate desde, LocalDate hasta, Integer productoIdFiltro) {
        List<Venta> ventas = ventaDAO.listar(); // trae todas; si tu DAO ya filtra, usa su método

        // Filtro por fecha
        if (desde != null) ventas = ventas.stream()
                .filter(v -> toLocalDate(v.getFecha()).compareTo(desde) >= 0).toList();
        if (hasta != null) ventas = ventas.stream()
                .filter(v -> toLocalDate(v.getFecha()).compareTo(hasta) <= 0).toList();

        // Filtro por producto (si se pidió)
        if (productoIdFiltro != null) {
            int pid = productoIdFiltro;
            ventas = ventas.stream().filter(v ->
                    v.getDetalleVenta() != null &&
                    v.getDetalleVenta().stream().anyMatch(d ->
                            d.getProducto() != null && d.getProducto().getIdProducto() == pid)
            ).toList();
        }

        Map<String,Object> out = new HashMap<>();
        out.put("kpis", kpis(ventas));
        out.put("mensuales", ventasMensuales(ventas));
        out.put("diarias", ventasDiarias(ventas));
        out.put("porProducto", ventasPorProducto(ventas));
        out.put("mediosPago", mediosPago(ventas));
        return out;
    }

    // ---------- agregaciones ----------
    private KPI kpis(List<Venta> ventas) {
        int totalVentas = ventas.size();

        int productosVendidos = ventas.stream()
            .flatMap(v -> v.getDetalleVenta()==null ? Stream.<DetalleVenta>empty() : v.getDetalleVenta().stream())
            .mapToInt(DetalleVenta::getCantidad).sum();

        double gananciaTotal = ventas.stream().mapToDouble(Venta::getTotal).sum();
        // Si luego agregas costo real, reemplaza este 0.38 por margen real:
        double gananciaBruta = gananciaTotal * 0.38;

        return new KPI(totalVentas, productosVendidos, r2(gananciaTotal), r2(gananciaBruta));
    }

    private List<PuntoMensual> ventasMensuales(List<Venta> ventas) {
        return ventas.stream()
            .collect(Collectors.groupingBy(v -> YearMonth.from(toLocalDateTime(v.getFecha())),
                    Collectors.summingDouble(Venta::getTotal)))
            .entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .map(e -> new PuntoMensual(e.getKey(), r2(e.getValue())))
            .toList();
    }

    private List<PuntoDiario> ventasDiarias(List<Venta> ventas) {
        return ventas.stream()
            .collect(Collectors.groupingBy(v -> toLocalDate(v.getFecha()),
                    Collectors.summingDouble(Venta::getTotal)))
            .entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .map(e -> new PuntoDiario(e.getKey(), r2(e.getValue())))
            .toList();
    }

    private List<Barra> ventasPorProducto(List<Venta> ventas) {
        return ventas.stream()
            .flatMap(v -> v.getDetalleVenta()==null ? Stream.<DetalleVenta>empty() : v.getDetalleVenta().stream())
            .collect(Collectors.groupingBy(
                    d -> d.getProducto()!=null ? d.getProducto().getNombre() : "Producto",
                    Collectors.summingDouble(DetalleVenta::getSubtotal)
            ))
            .entrySet().stream()
            .sorted(Map.Entry.<String,Double>comparingByValue().reversed())
            .map(e -> new Barra(e.getKey(), r2(e.getValue()))).toList();
    }

    private List<Slice> mediosPago(List<Venta> ventas) {
        return ventas.stream()
            .collect(Collectors.groupingBy(Venta::getMetodoPago,
                    Collectors.summingDouble(Venta::getTotal)))
            .entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .map(e -> new Slice(e.getKey(), r2(e.getValue()))).toList();
    }

    // ---------- util ----------
    private LocalDateTime toLocalDateTime(String fecha) {
        try { return LocalDateTime.parse(fecha, FMT); }
        catch (Exception e) { // fallback por si viene "yyyy-MM-dd"
            return LocalDate.parse(fecha).atStartOfDay();
        }
    }
    private LocalDate toLocalDate(String fecha) { return toLocalDateTime(fecha).toLocalDate(); }
    private double r2(double v) { return Math.round(v*100.0)/100.0; }
}
