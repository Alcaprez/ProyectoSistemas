package edu.UPAO.proyecto.Modelo;
import java.time.LocalTime;

public class Usuario {

    private String id;
    private String nombreComp;
    private String cargo;
    private String tienda;
    private LocalTime horaEntradaProg;
    private LocalTime horaSalidaProg;

    // --- Constructores ---
    public Usuario(String id, String nombreComp, String cargo, String tienda,
                   LocalTime horaEntradaProg, LocalTime horaSalidaProg) {
        this.id = id;
        this.nombreComp = nombreComp;
        this.cargo = cargo;
        this.tienda = tienda;
        this.horaEntradaProg = horaEntradaProg;
        this.horaSalidaProg = horaSalidaProg;
    }

    // --- Getters & Setters ---
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreComp() {
        return nombreComp;
    }

    public void setNombreComp(String nombreComp) {
        this.nombreComp = nombreComp;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTienda() {
        return tienda;
    }

    public void setTienda(String tienda) {
        this.tienda = tienda;
    }

    public LocalTime getHoraEntradaProg() {
        return horaEntradaProg;
    }

    public void setHoraEntradaProg(LocalTime horaEntradaProg) {
        this.horaEntradaProg = horaEntradaProg;
    }

    public LocalTime getHoraSalidaProg() {
        return horaSalidaProg;
    }

    public void setHoraSalidaProg(LocalTime horaSalidaProg) {
        this.horaSalidaProg = horaSalidaProg;
    }

    @Override
    public String toString() {
        return nombreComp + " (" + cargo + ") - " + tienda;
    }
}
