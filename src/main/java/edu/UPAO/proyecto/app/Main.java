package edu.UPAO.proyecto.app;
import edu.UPAO.proyecto.Modelo.*;
import edu.UPAO.proyecto.Service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
        Scanner sc = new Scanner(System.in);

        UsuarioService usuarioService = new UsuarioService();
        ProductoService productoService = new ProductoService();
        VentaService ventaService = new VentaService();

        // === LOGIN ===
        System.out.println("===== LOGIN =====");
        System.out.print("Usuario: ");
        String user = sc.nextLine();
        System.out.print("Contraseña: ");
        String pass = sc.nextLine();

        Usuario cajero = usuarioService.login(user, pass);
        if (cajero == null) {
            System.out.println("Usuario o contraseña incorrectos, o cuenta inactiva.");
            return;
        }
        System.out.println("Bienvenido " + cajero.getNombreComp() + " (" + cajero.getRol() + ")");

        // === PROCESO DE VENTA ===
        List<DetalleVenta> detalles = new ArrayList<>();
        char continuar;

        do {
            System.out.println("\n=== PRODUCTOS DISPONIBLES ===");
            for (Producto p : productoService.listarProductos()) {
                System.out.println(p.getIdProducto() + " - " + p.getNombre()
                        + " | Precio: S/ " + p.getPrecioVenta()
                        + " | Stock: " + p.getStock());
            }

            System.out.print("Ingrese ID de producto: ");
            int idProd = sc.nextInt();
            System.out.print("Cantidad: ");
            int cantidad = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            Producto prod = productoService.buscarPorId(idProd);
            if (prod != null && prod.getStock() >= cantidad) {
                double subtotal = prod.getPrecioVenta() * cantidad;
                DetalleVenta det = new DetalleVenta(detalles.size() + 1, prod, cantidad, prod.getPrecioVenta(), subtotal);
                detalles.add(det);

                // Descontar stock en productoService
                prod.setStock(prod.getStock() - cantidad);

                System.out.println("Agregado: " + prod.getNombre() + " x" + cantidad + " | Subtotal: S/ " + subtotal);

                // Verificar stock mínimo
                productoService.verificarStockMinimo(prod.getIdProducto());
            } else {
                System.out.println("Producto no encontrado o stock insuficiente.");
            }

            System.out.print("¿Desea agregar otro producto? (s/n): ");
            continuar = sc.nextLine().charAt(0);

        } while (continuar == 's');

        System.out.print("\nMétodo de pago (EFECTIVO/TARJETA): ");
        String metodo = sc.nextLine();

        // Registrar venta usando el servicio
       ventaService.registrarVenta(Integer.parseInt(cajero.getId()), detalles, metodo);


        System.out.println("\n=== BOLETA DE VENTA ===");
        double total = 0;
        for (DetalleVenta d : detalles) {
            System.out.println(d.getProducto().getNombre() + " x" + d.getCantidad()
                    + " | Precio: S/ " + d.getPrecioUnitario()
                    + " | Subtotal: S/ " + d.getSubtotal());
            total += d.getSubtotal();
        }
        System.out.println("TOTAL: S/ " + total);
        System.out.println("Método de Pago: " + metodo);
        System.out.println("=======================");

        sc.close();
    }
}

