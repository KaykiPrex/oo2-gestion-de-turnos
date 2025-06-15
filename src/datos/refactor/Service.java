package datos.refactor;

import java.util.Set;

public class Service {
    private int id;
    private String name;
    private String description;
    private String duration;
    private Set<ProfessionalService> professionalServices;
    private Specialty specialty;

    public Service() {
    }

    public Service(String name, String description, String duration ) {
        this.name = name;
        this.description = description;
        this.duration = duration;
    }

    public Service(String name, String description, String duration , Specialty specialty) {
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.specialty = specialty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Set<ProfessionalService> getProfessionalServices() {
        return professionalServices;
    }

    public void setProfessionalServices(Set<ProfessionalService> professionalServices) {
        this.professionalServices = professionalServices;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "Servicio [idServicio=" + id + ", name=" + name + ", description=" + description + "]";
    }
}
