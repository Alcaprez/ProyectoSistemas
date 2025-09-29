
package edu.UPAO.proyecto.Modelo;

/**
 *
 * @author Fabri
 */
public class Proveedor {
    private int idProveedor;
    private String nombre;
    private String ruc;
    private String direccion;
    private String telefono;
    private String correo;      // <-- nuevo atributo
    private boolean activo;

    public Proveedor(int idProveedor, String nombre, String ruc, String direccion, String telefono, String correo, boolean activo) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.ruc = ruc;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.activo = activo;
    }

    public int getIdProveedor() { return idProveedor; }
    public void setIdProveedor(int idProveedor) { this.idProveedor = idProveedor; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getRuc() { return ruc; }
    public void setRuc(String ruc) { this.ruc = ruc; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getCorreo() { return correo; }         // getter para correo
    public void setCorreo(String correo) { this.correo = correo; }

    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }

    @Override
    public String toString() {
        return nombre + " (" + ruc + ")";
    }
}
