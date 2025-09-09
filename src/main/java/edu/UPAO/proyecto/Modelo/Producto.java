package edu.UPAO.proyecto.Modelo;

public class Producto {
    private int IdProducto;
    private String Codigo;
    private String Nombre;
    private String Categoria;
    private double precioVenta;
    private double precioCompra;
    private int Stock;
    private int StockMinimo;
    private String FechaIngreso;
    private String FechaVencimiento;

    public Producto(String categoria, String codigo, String fechaIngreso, String fechaVencimiento, int idProducto, String nombre, double precioCompra, double precioVenta, int stock, int stockMinimo) {
        Categoria = categoria;
        Codigo = codigo;
        FechaIngreso = fechaIngreso;
        FechaVencimiento = fechaVencimiento;
        IdProducto = idProducto;
        Nombre = nombre;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        Stock = stock;
        StockMinimo = stockMinimo;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }

    public String getFechaIngreso() {
        return FechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        FechaIngreso = fechaIngreso;
    }

    public String getFechaVencimiento() {
        return FechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        FechaVencimiento = fechaVencimiento;
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int idProducto) {
        IdProducto = idProducto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    public int getStockMinimo() {
        return StockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        StockMinimo = stockMinimo;
    }
}
