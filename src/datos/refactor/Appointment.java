package datos.refactor;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
    private int id;
    private LocalDate date;
    private LocalTime time;
    private boolean isBlocked;
    private Client client;
    private ProfessionalService professionalService;
    private String location;
    private String report;

    public Appointment() {
    }

    public Appointment(LocalDate date, LocalTime time, ProfessionalService professionalService) {
        this.date = date;
        this.time = time;
        this.professionalService = professionalService;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public boolean getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ProfessionalService getProfessionalService() {
        return professionalService;
    }

    public void setProfessionalService(ProfessionalService professionalService) {
        this.professionalService = professionalService;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void deleteClient() {
        setClient(null);
        setIsBlocked(false);
    }

    @Override
    public String toString() {
        return "Turno [idTurno=" + id + ", date=" + date + ", time=" + time + ", isBlocked=" + isBlocked
                + ", location=" + location + ", report=" + report + "]";
    }
}
