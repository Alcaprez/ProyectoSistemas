package edu.UPAO.proyecto.Service;

import edu.UPAO.proyecto.Modelo.DetalleVenta;
import edu.UPAO.proyecto.DAO.ProductoDAO;
import edu.UPAO.proyecto.DAO.VentaDAO;

import java.util.List;

public class VentaService {
    private VentaDAO ventaDAO = new VentaDAO();
    private ProductoDAO productoDAO = new ProductoDAO();

    public void registrarVenta(int cajeroId, List<DetalleVenta> detalles, String metodoPago) {
        // Descontar stock antes de registrar
        for (DetalleVenta d : detalles) {
            productoDAO.actualizarStock(d.getProducto().getIdProducto(), d.getCantidad());
        }
        // Registrar venta en el DAO
        ventaDAO.registrarVenta(cajeroId, detalles, metodoPago);
    }
}