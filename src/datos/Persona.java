package datos;

public class Persona {
    private long id;
    private String nombre;
    private String contrasena;
    private Contacto contacto;

    public Persona() {
    }

    public Persona(String nombre, String contrasena, Contacto contacto) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.contacto = contacto;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }


}
