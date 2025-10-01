package edu.UPAO.proyecto;

import edu.UPAO.proyecto.Modelo.DetalleVenta;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VentasController {
    private static final String FILE_NAME = "ventas.txt";
    private static final List<DetalleVenta> VENTAS = new ArrayList<>();

    // método que estabas llamando: registrarVenta
    public static void registrarVenta(DetalleVenta v) {
        synchronized (VENTAS) {
            VENTAS.add(v);
        }
        // persistir en archivo (append)
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(v.toFileLine());
            bw.newLine();
        } catch (IOException e) {
        }
    }

    public static List<DetalleVenta> getVentas() {
        synchronized (VENTAS) {
            return Collections.unmodifiableList(new ArrayList<>(VENTAS));
        }
    }
}
