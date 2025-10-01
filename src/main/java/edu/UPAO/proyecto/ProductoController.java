package edu.UPAO.proyecto;

import edu.UPAO.proyecto.Modelo.Producto;
import java.io.*;
import java.util.*;

public class ProductoController {

    private static final String FILE_NAME = "productos.txt";

    // Leer productos desde archivo
    public List<Producto> cargarProductos() {
        List<Producto> productos = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(";");
            Producto p = new Producto(); // Constructor vacío

            p.setNombre(data[0]);
            p.setPrecioVenta(Double.parseDouble(data[1]));
            p.setStock(Integer.parseInt(data[2]));
            p.setCodigo(data[3]);

            // Campo opcional → vendidos
            if (data.length >= 5) {
                p.setVendidos(Integer.parseInt(data[4]));
            } else {
                p.setVendidos(0);
            }

            productos.add(p);
        }
    } catch (IOException e) {
        System.out.println("Archivo vacío o no encontrado.");
    }
    return productos;
    }

    // Guardar todos los productos
    public void guardarProductos(List<Producto> productos) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Producto p : productos) {
                bw.write(p.toString());
                bw.newLine();
            }
        } catch (IOException e) {
        }
    }

    // Actualizar stock y vendidos tras una compra
    public void actualizarProducto(String codigo, int cantidadVendida) {
        List<Producto> productos = cargarProductos();
        for (Producto p : productos) {
            if (p.getCodigo().equals(codigo)) {
                p.setStock(p.getStock() - cantidadVendida);
                p.setVendidos(p.getVendidos() + cantidadVendida);
                break;
            }
        }
        guardarProductos(productos);
    }

    // Buscar producto por código
    public Producto buscarProducto(String codigo) {
        List<Producto> productos = cargarProductos();
        for (Producto p : productos) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null;
    }

    // Devolver productos ordenados por más vendidos
    public List<Producto> productosMasVendidos() {
        List<Producto> productos = cargarProductos();
        productos.sort((a, b) -> Integer.compare(b.getVendidos(), a.getVendidos())); // descendente
        return productos;
    }

    public void agregarProducto(Producto p) {
        List<Producto> productos = cargarProductos();
        productos.add(p);
        guardarProductos(productos);
    }
}
