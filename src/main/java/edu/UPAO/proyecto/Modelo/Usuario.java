package edu.UPAO.proyecto.Modelo;

public class Usuario {
    private int IdUsuario;
    private String NombreComp;
    private String Usuario;
    private String Contrasena;
    private String Rol;
    private int DNI;
    private boolean Estado;

    public Usuario(String contrasena, int DNI, boolean estado, int idUsuario, String nombreComp, String rol, String usuario) {
        Contrasena = contrasena;
        this.DNI = DNI;
        Estado = estado;
        IdUsuario = idUsuario;
        NombreComp = nombreComp;
        Rol = rol;
        Usuario = usuario;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String contrasena) {
        Contrasena = contrasena;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean estado) {
        Estado = estado;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        IdUsuario = idUsuario;
    }

    public String getNombreComp() {
        return NombreComp;
    }

    public void setNombreComp(String nombreComp) {
        NombreComp = nombreComp;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String rol) {
        Rol = rol;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }
}
