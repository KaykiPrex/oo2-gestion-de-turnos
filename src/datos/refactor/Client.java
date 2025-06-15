package datos.refactor;

import java.util.List;

public class Client extends User{
    private String name;
    private String lastName;
    private String dni;
    private List<Appointment> appointments;

    public Client() {
    }

    public Client(String userName, String userPass, Contact contact, String name, String lastName, String dni, List<Appointment> appointments) {
        super(userName, userPass, contact);
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.appointments = appointments;
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

    public String getDni() {
        return dni;
    }

    public int getUserId(){return super.getId();}

    public void setDni(String dni) {
        this.dni = dni;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public String toString() {
        return "Cliente [" + super.toString()+ ", name=" + name + ", lastName=" + lastName
                + ", dni=" + dni + "]";
    }
}
