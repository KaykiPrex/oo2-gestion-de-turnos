package datos;

public class Servicio {
    private long id;
    private String nombre;
    private String descripcion;
    private String duracion;
    private Double precio;

    public Servicio(String nombre, String descripcion, String duracion, Double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.precio = precio;
    }

    public long getId() {
        return id;
    }
    protected void setId(long id) {this.id=id;}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

	@Override
	public String toString() {

		return "{nombre=" + nombre + ", descripcion=" + descripcion + ", duration=" + duracion + ", price=" + precio +'}';
	}

}
