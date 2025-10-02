package edu.UPAO.proyecto.Modelo;

import java.time.LocalTime;

public class Usuario {

    private String Id;
    private String NombreComp;
    private String Usuario;
    private String Contrasena;
    private String Rol;
    private String tienda;
    private String cargo;
    private int DNI;
    private boolean Estado;
    private java.time.LocalTime horaEntradaProg;
    private java.time.LocalTime horaSalidaProg;

    public Usuario(String contrasena, int DNI, boolean estado, String id, String nombreComp, String rol, String usuario) {
        Contrasena = contrasena;
        this.DNI = DNI;
        Estado = estado;
        Id = id;
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

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
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

    public String getTienda() {
        return tienda;
    }

    public String getCargo() {
        return cargo;
    }

    public LocalTime getHoraEntradaProg() {
        return horaEntradaProg;
    }

    public LocalTime getHoraSalidaProg() {
        return horaSalidaProg;
    }

    public void setTienda(String t) {
        this.tienda = t;
    }

    public void setCargo(String c) {
        this.cargo = c;
    }

    public void setHoraEntradaProg(LocalTime t) {
        this.horaEntradaProg = t;
    }

    public void setHoraSalidaProg(LocalTime t) {
        this.horaSalidaProg = t;
    }
}
