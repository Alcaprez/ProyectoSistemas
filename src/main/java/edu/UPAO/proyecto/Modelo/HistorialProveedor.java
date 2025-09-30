package edu.UPAO.proyecto.Modelo;

import java.time.LocalDateTime;

/**
 *
 * @author Fabri
 */
public class HistorialProveedor {

    private int idProveedor;     // Referencia al Proveedor
    private String tipoEvento;   // "COMPRA", "ACTIVACION", "DESACTIVACION"
    private String detalle;      // Motivo o descripción
    private LocalDateTime fecha; // Cuándo pasó

    public HistorialProveedor(int idProveedor, String tipoEvento, String detalle) {
        this.idProveedor = idProveedor;
        this.tipoEvento = tipoEvento;
        this.detalle = detalle;
        this.fecha = LocalDateTime.now();
    }

    // Getters y Setters
    public int getIdProveedor() {
        return idProveedor;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public String getDetalle() {
        return detalle;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "HistorialProveedor{"
                + "idProveedor=" + idProveedor
                + ", tipoEvento='" + tipoEvento + '\''
                + ", detalle='" + detalle + '\''
                + ", fecha=" + fecha
                + '}';
    }
}
