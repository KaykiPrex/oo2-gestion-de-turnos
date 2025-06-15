package datos.refactor;

import java.util.Set;

public class Specialty {
    private int id;
    private String name;
    private String description;
    private Set<ProfessionalSpecialty> professionalSpecialties;
    private Set<Service> services;
    private Category category;

    public Specialty() {
    }

    public Specialty(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Specialty(String name, String description, Category category) {
        this.name = name;
        this.description = description;
        this.category = category;
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

    public Set<ProfessionalSpecialty> getProfessionalSpecialties() {
        return professionalSpecialties;
    }

    public void setProfessionalSpecialties(Set<ProfessionalSpecialty> professionalSpecialties) {
        this.professionalSpecialties = professionalSpecialties;
    }

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Especialidad [idEspecialidad=" + id + ", name=" + name + ", description=" + description + "]";
    }
}
