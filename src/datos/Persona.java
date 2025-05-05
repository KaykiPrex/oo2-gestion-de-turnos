package datos;

public class Persona {
	private long id;
	private String name;
	private String password;
	private Contacto contacto;

	public Persona(String name, String password, Contacto contacto) {
		this.name = name;
		this.password = password;
		this.contacto = contacto;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}
	
	
}
