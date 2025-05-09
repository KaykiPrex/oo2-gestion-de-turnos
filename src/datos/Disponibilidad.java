package datos;

import java.time.LocalDate;
import java.time.LocalTime;

public class Disponibilidad {
	private long id;
	private LocalDate date;
	private LocalTime time;
	private boolean blocked;
	private Profesional profesional;
	
	public Disponibilidad(LocalDate date, LocalTime time, boolean blocked, Profesional profesional) {
		super();
		this.date = date;
		this.time = time;
		this.blocked = blocked;
		this.profesional = profesional;
	}

	public Disponibilidad() {
		
	}
	
	public long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public Profesional getProfesional() {
		return profesional;
	}

	public void setProfesional(Profesional profesional) {
		this.profesional = profesional;
	}

	@Override
	public String toString() {
		return "Disponibilidad [id=" + id + ", Fecha=" + date + ", Hora=" + time + ", Ocupado=" + blocked + "]";
	}
	
}

