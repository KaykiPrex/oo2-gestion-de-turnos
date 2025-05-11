package datos;

public class Contacto {
    private long id;
    private String email;
    private String telefonoFijo;
    private String telefonoMovil;
    private Persona persona;

    public Contacto() {
    }

    public Contacto(String email, String telefonoFijo, String telefonoMovil, Persona persona) {
        this.email = email;
        this.telefonoFijo = telefonoFijo;
        this.telefonoMovil = telefonoMovil;
        this.persona = persona;
    }

    public long getId() {
        return id;
    }

    protected void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Contacto [id=" + id + ", email=" + email + ", telefonoFijo=" + telefonoFijo + ", telefonoMovil=" + telefonoMovil
                + "]";
    }
}
