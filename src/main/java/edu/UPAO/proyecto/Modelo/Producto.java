package edu.UPAO.proyecto.Modelo;

public class Producto {
    private int idProducto;
    private String codigo;
    private String nombre;
    private String categoria;
    private double precioVenta;
    private double precioCompra;
    private int stock;
    private int stockMinimo;
    private String fechaIngreso;
    private String fechaVencimiento;

    public Producto() {}

    public Producto(String categoria, String codigo, String fechaIngreso, String fechaVencimiento,
                    int idProducto, String nombre, double precioCompra, double precioVenta,
                    int stock, int stockMinimo) {
        this.categoria = categoria;
        this.codigo = codigo;
        this.fechaIngreso = fechaIngreso;
        this.fechaVencimiento = fechaVencimiento;
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.stock = stock;
        this.stockMinimo = stockMinimo;
    }

    // Getters y Setters
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getFechaIngreso() { return fechaIngreso; }
    public void setFechaIngreso(String fechaIngreso) { this.fechaIngreso = fechaIngreso; }

    public String getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(String fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }

    public int getIdProducto() { return idProducto; }
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPrecioCompra() { return precioCompra; }
    public void setPrecioCompra(double precioCompra) { this.precioCompra = precioCompra; }

    public double getPrecioVenta() { return precioVenta; }
    public void setPrecioVenta(double precioVenta) { this.precioVenta = precioVenta; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public int getStockMinimo() { return stockMinimo; }
    public void setStockMinimo(int stockMinimo) { this.stockMinimo = stockMinimo; }

    public boolean estaBajoStock() {
        return stock <= stockMinimo;
    }

    @Override
    public String toString() {
        return idProducto + " - " + nombre + " | Precio: S/ " + precioVenta + " | Stock: " + stock;
    }
    @Override public String toString() { return Nombre; }

}

