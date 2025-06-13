package datos;

public abstract class Persona {
    private long id;
    private String nombre;
    private String contrasena;
    private long dni;
    private Contacto contacto;

    public Persona() {
    }

    public Persona(String nombre, String contrasena, long dni, Contacto contacto) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.dni = dni;
        this.contacto = contacto;
    }

    public long getId() {
        return id;
    }

    protected void setId(long id) {
        this.id = id;
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

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    @Override
    public String toString() {
        return "Persona [id=" + id + ", nombre=" + nombre + ", contacto=" + contacto + "]";
    }

}
