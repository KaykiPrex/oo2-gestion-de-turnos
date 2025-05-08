package datos;

import java.time.LocalDate;
import java.time.LocalTime;

public class Disponibilidad {
    private long id;
    private LocalDate date;
    private LocalTime time;
    private boolean isBlocked;
    private Profesional profesional;

    public Disponibilidad() {
    }

    public Disponibilidad(LocalDate date, LocalTime time, boolean isBlocked, Profesional profesional) {
        this.date = date;
        this.time = time;
        this.isBlocked = isBlocked;
        this.profesional = profesional;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }
}
