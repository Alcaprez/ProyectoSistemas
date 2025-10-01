package edu.UPAO.proyecto.DAO;

import edu.UPAO.proyecto.Modelo.Producto;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    private static List<Producto> productos = new ArrayList<>();

    static {
         // Datos iniciales simulando una BD
        productos.add(new Producto(
                1, "B001", "Gaseosa Inca Kola 500ml", "Bebidas",
                3.50, 20, 5, 0, "2025-01-01", "2026-01-01"
        ));
        productos.add(new Producto(
                2, "S001", "Galletas Oreo", "Snacks",
                2.00, 50, 10, 0, "2025-01-01", "2025-06-01"
        ));
        productos.add(new Producto(
                3, "H001", "Shampoo Sedal 200ml", "Higiene",
                7.50, 15, 3, 0, "2025-02-15", "2026-02-15"
        ));   
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
    public List<Producto> productosMasVendidos() {
        productos.sort((a, b) -> Integer.compare(b.getVendidos(), a.getVendidos()));
        return productos;
    }
}
