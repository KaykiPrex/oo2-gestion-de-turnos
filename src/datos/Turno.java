package datos;

import java.time.LocalDateTime;

public class Turno {

	private long id;
	private LocalDateTime date;
	private Cliente cliente;
	private Profesional profesional;
	private Servicio  servicio;

	public Turno(LocalDateTime date, Cliente cliente, Profesional profesional, Servicio servicio) {
		this.date = date;
		this.cliente = cliente;
		this.profesional = profesional;
		this.servicio = servicio;
	}
	@Override
	public String toString() {
		return "Turno [id=" + id + ", fechaHora=" + fechaHora + ", cliente=" + cliente + ", profesional=" + profesional
				+ ", servicio=" + servicio + "]";
	}

	public long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
	}
	
	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
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
