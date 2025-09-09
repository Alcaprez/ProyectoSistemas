package edu.UPAO.proyecto.Modelo;
import java.util.*;
public class Venta {
    private int IdVenta;
    private String Fecha;
    private int CajeroId;
    private String MetodoPago;
    private double Total;
    private List<DetalleVenta> detalleVenta;

    public Venta() {
    }

    public Venta(int cajeroId, List<DetalleVenta> detalleVenta, String fecha, int idVenta, String metodoPago, double total) {
        CajeroId = cajeroId;
        this.detalleVenta = detalleVenta;
        Fecha = fecha;
        IdVenta = idVenta;
        MetodoPago = metodoPago;
        Total = total;
    }

    public int getCajeroId() {
        return CajeroId;
    }

    public void setCajeroId(int cajeroId) {
        CajeroId = cajeroId;
    }

    public List<DetalleVenta> getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(List<DetalleVenta> detalleVenta) {
        this.detalleVenta = detalleVenta;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public int getIdVenta() {
        return IdVenta;
    }

    public void setIdVenta(int idVenta) {
        IdVenta = idVenta;
    }

    public String getMetodoPago() {
        return MetodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        MetodoPago = metodoPago;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double total) {
        Total = total;
    }
}
