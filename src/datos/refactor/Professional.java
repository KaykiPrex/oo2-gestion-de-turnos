package datos.refactor;

import java.util.Set;

public class Professional extends User{
    private String name;
    private String lastName;
    private String cuil;
    private Set<ProfessionalSpecialty> specialties;
    private Set<ProfessionalService> services;

    public Professional() {
    }

    public Professional(String userName, String userPass, Contact contact, String name, String lastName, String cuil) {
        super(userName, userPass, contact);
        this.name = name;
        this.lastName = lastName;
        this.cuil = cuil;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public Set<ProfessionalSpecialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<ProfessionalSpecialty> specialties) {
        this.specialties = specialties;
    }

    public Set<ProfessionalService> getServices() {
        return services;
    }

    public void setServices(Set<ProfessionalService> services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return "Profesional [" + super.toString()+ ", name=" + name + ", lastName=" + lastName
                + ", cuil=" + cuil + "]";
    }
}
