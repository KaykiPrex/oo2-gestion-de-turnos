package datos;

import java.time.LocalDate;
import java.time.LocalTime;

public class Agenda {
	private long id;
	private LocalDate date;
	private LocalTime time;
	private boolean blocked;
	
	public Agenda(LocalDate date, LocalTime time, boolean blocked) {
		super();
		this.date = date;
		this.time = time;
		this.blocked = blocked;
	}

	public long getId() {
		return id;
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
	
	

}
