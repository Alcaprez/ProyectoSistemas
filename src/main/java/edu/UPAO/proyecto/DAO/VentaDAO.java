package edu.UPAO.proyecto.DAO;

import edu.UPAO.proyecto.Modelo.Venta;
import edu.UPAO.proyecto.Modelo.DetalleVenta;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VentaDAO {
    private static List<Venta> ventas = new ArrayList<>();
    private static int nextId = 1; // contador para ID de ventas

    // Registrar nueva venta
    public void registrarVenta(int cajeroId, List<DetalleVenta> detalles, String metodoPago) {
        double total = detalles.stream()
                .mapToDouble(DetalleVenta::getSubtotal)
                .sum();

        String fechaActual = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        Venta venta = new Venta(cajeroId, detalles, fechaActual, nextId++, metodoPago, total);
        ventas.add(venta);

        System.out.println("✅ Venta registrada con ID: " + venta.getIdVenta() + " | Total: S/ " + venta.getTotal());
    }

    // Listar todas las ventas
    public List<Venta> listar() {
        return ventas;
    }

    // Buscar una venta por su ID
    public Venta buscarPorId(int id) {
        return ventas.stream()
                .filter(v -> v.getIdVenta() == id)
                .findFirst()
                .orElse(null);
    }
}