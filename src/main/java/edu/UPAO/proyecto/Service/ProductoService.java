package edu.UPAO.proyecto.Service;

import edu.UPAO.proyecto.Modelo.Producto;
import edu.UPAO.proyecto.DAO.ProductoDAO;

import java.util.List;

public class ProductoService {
    private ProductoDAO productoDAO = new ProductoDAO();

    // Listar todos los productos
    public List<Producto> listarProductos() {
        return productoDAO.listar();
    }

    // Buscar producto por ID
    public Producto buscarPorId(int id) {
        return productoDAO.buscarPorId(id);
    }

    // Buscar producto por código
    public Producto buscarPorCodigo(String codigo) {
        return productoDAO.buscarPorCodigo(codigo);
    }

    // Agregar producto validando duplicados por código
    public boolean agregarProducto(Producto producto) {
        Producto existente = productoDAO.buscarPorCodigo(producto.getCodigo());
        if (existente != null) {
            System.out.println("⚠️ Ya existe un producto con el código: " + producto.getCodigo());
            return false;
        }
        productoDAO.agregar(producto);
        System.out.println("✅ Producto agregado: " + producto.getNombre());
        return true;
    }

    // Eliminar producto por ID
    public void eliminarProducto(int id) {
        productoDAO.eliminar(id);
        System.out.println("🗑 Producto eliminado con ID: " + id);
    }

    // Verificar si un producto está en stock mínimo
    public boolean verificarStockMinimo(int id) {
        boolean bajoStock = productoDAO.estaBajoStock(id);
        if (bajoStock) {
            Producto p = productoDAO.buscarPorId(id);
            System.out.println("⚠️ El producto " + p.getNombre() + " está en stock mínimo (" + p.getStock() + ").");
        }
        return bajoStock;
    }
}
