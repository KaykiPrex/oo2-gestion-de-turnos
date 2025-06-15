package datos.refactor;

public class ProfessionalSpecialty {
    private int id;
    private String status;
    private Professional professional;
    private Specialty specialty;

    public ProfessionalSpecialty() {
    }

    public ProfessionalSpecialty(int id, Specialty specialty) {
        this.id = id;
        this.specialty = specialty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }
}
