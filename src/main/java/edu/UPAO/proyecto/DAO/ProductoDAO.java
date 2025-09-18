package edu.UPAO.proyecto.DAO;

import edu.UPAO.proyecto.Modelo.Producto;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    private static List<Producto> productos = new ArrayList<>();

    static {
        // Datos iniciales simulando una BD
        productos.add(new Producto("Bebidas", "B001", "2025-01-01", "2026-01-01",
                1, "Gaseosa Inca Kola 500ml", 2.00, 3.50, 20, 5));
        productos.add(new Producto("Snacks", "S001", "2025-01-01", "2025-06-01",
                2, "Galletas Oreo", 1.20, 2.00, 50, 10));
        productos.add(new Producto("Higiene", "H001", "2025-02-15", "2026-02-15",
                3, "Shampoo Sedal 200ml", 5.00, 7.50, 15, 3));
    }

    // Listar todos los productos
    public List<Producto> listar() {
        return productos;
    }

    // Buscar producto por ID
    public Producto buscarPorId(int id) {
        return productos.stream()
                .filter(p -> p.getIdProducto() == id)
                .findFirst()
                .orElse(null);
    }

    // Buscar producto por código
    public Producto buscarPorCodigo(String codigo) {
        return productos.stream()
                .filter(p -> p.getCodigo().equalsIgnoreCase(codigo))
                .findFirst()
                .orElse(null);
    }

    // Agregar un nuevo producto
    public void agregar(Producto producto) {
        productos.add(producto);
    }

    // Eliminar producto por ID
    public void eliminar(int id) {
        productos.removeIf(p -> p.getIdProducto() == id);
    }

    // Actualizar stock después de una venta
    public void actualizarStock(int id, int cantidadVendida) {
        Producto p = buscarPorId(id);
        if (p != null) {
            int nuevoStock = p.getStock() - cantidadVendida;
            p.setStock(Math.max(nuevoStock, 0)); // evita negativos
        }
    }

    // Verificar si un producto está por debajo del stock mínimo
    public boolean estaBajoStock(int id) {
        Producto p = buscarPorId(id);
        return p != null && p.getStock() <= p.getStockMinimo();
    }
}
