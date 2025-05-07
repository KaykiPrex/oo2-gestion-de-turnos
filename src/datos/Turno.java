package datos;

import java.time.LocalDateTime;

public class Turno {
	private long id;
	private Disponibilidad disponibilidad;
	private Cliente cliente;
	private Profesional profesional;
	private Servicio servicio;

	public Turno(Servicio servicio, Profesional profesional, Cliente cliente, Disponibilidad disponibilidad) {
		this.servicio = servicio;
		this.profesional = profesional;
		this.cliente = cliente;
		this.disponibilidad = disponibilidad;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Disponibilidad getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(Disponibilidad disponibilidad) {
		this.disponibilidad = disponibilidad;
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
	
	

}
