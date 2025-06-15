package datos.refactor;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;

public class ProfessionalService {
    private int id;
    private BigDecimal price;
    private Professional professional;
    private Service service;
    private LocalTime initWorkHour;
    private LocalTime endWorkHour;
    private String workDays;
    private List<Appointment> appointments;

    public ProfessionalService() {
    }

    public ProfessionalService(BigDecimal price, Professional professional, Service service) {
        this.price = price;
        this.professional = professional;
        this.service = service;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public LocalTime getInitWorkHour() {
        return initWorkHour;
    }

    public void setInitWorkHour(LocalTime initWorkHour) {
        this.initWorkHour = initWorkHour;
    }

    public LocalTime getEndWorkHour() {
        return endWorkHour;
    }

    public void setEndWorkHour(LocalTime endWorkHour) {
        this.endWorkHour = endWorkHour;
    }

    public String getWorkDays() {
        return workDays;
    }

    public void setWorkDays(String workDays) {
        this.workDays = workDays;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
