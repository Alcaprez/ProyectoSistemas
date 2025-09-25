package edu.UPAO.proyecto.Modelo;

public class DetalleVenta {
    private int idDetalle;
    private int cantidad;
    private double precioUnitario;
    private Producto producto;

    // Constructor vacío
    public DetalleVenta() {}

    // Constructor con subtotal calculado automáticamente
    public DetalleVenta(int idDetalle, Producto producto, int cantidad, double precioUnitario) {
        this.idDetalle = idDetalle;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    // Getters y Setters
    public int getIdDetalle() { return idDetalle; }
    public void setIdDetalle(int idDetalle) { this.idDetalle = idDetalle; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public double getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(double precioUnitario) { this.precioUnitario = precioUnitario; }

    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }

    // Subtotal se calcula automáticamente
    public double getSubtotal() {
        return cantidad * precioUnitario;
    }

    @Override
    public String toString() {
        return producto.getNombre() + " x" + cantidad + " | Precio: S/ " + precioUnitario + " | Subtotal: S/ " + getSubtotal();
    }
}

