package datos;

public class Especialidad {
	private long id;
	private String nombre;
	
	public Especialidad(String nombre) {
		this.nombre = nombre;
	}
	
	public Especialidad() {
	}

	protected void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String name) {
		this.nombre = name;
	}

	@Override
	public String toString() {
		return "Especialidad [id=" + id + ", name=" + nombre + "]";
	}
	
	
}
