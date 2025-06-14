package datos;

import java.time.LocalDateTime;

public class Turno {

    private long id;
    private LocalDateTime fechaHora;
    private Cliente cliente;
    private Profesional profesional;
    private Servicio servicio;

    public Turno() {
    }

    public Turno(LocalDateTime fechaHora, Cliente cliente, Profesional profesional, Servicio servicio) {
        this.fechaHora = fechaHora;
        this.cliente = cliente;
        this.profesional = profesional;
        this.servicio = servicio;
    }

    public long getId() {
        return id;
    }

    protected void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    @Override
    public String toString() {
        return "Turno [fechaHora=" + fechaHora + ", cliente=" + cliente.getNombre() + ", profesional=" + profesional.getNombre()
                + ", servicio=" + servicio.getNombre() + "]";
    }

}
