package datos;

import java.time.LocalDate;
import java.time.LocalTime;

public class Disponibilidad {
    private long id;
    private LocalDate fecha;
    private LocalTime hora;
    private boolean disponible;
    private Profesional profesional;

    public Disponibilidad() {
    }

    public Disponibilidad(LocalDate fecha, LocalTime hora, boolean disponible, Profesional profesional) {
        this.fecha = fecha;
        this.hora = hora;
        this.disponible = disponible;
        this.profesional = profesional;
    }

    public long getId() {
        return id;
    }

	protected void setId(long id) {
		this.id = id;
	}

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

	public Profesional getProfesional() {
		return profesional;
	}

	public void setProfesional(Profesional profesional) {
		this.profesional = profesional;
	}

	@Override
	public String toString() {
		return "Disponibilidad [id=" + id + ", Fecha=" + fecha + ", Hora=" + hora + ", Ocupado=" + disponible + "]";
	}

}

