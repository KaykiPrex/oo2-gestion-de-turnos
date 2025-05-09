package datos;


import java.util.ArrayList;
import java.util.List;


public class Cliente extends Persona{
	private List<Turno> turnos;
	public Cliente() {}
	public Cliente(String name, String password, Contacto contacto) {
		super(name,  password, contacto);
		this.turnos = new ArrayList<Turno>();
	}
	public void mostrarCliente(){
		System.out.println(this.toString());
	}

	public List<Turno> traerHistorialTurnos() {
		return turnos;
	}
	public void setNombre(String nombre) {
		super.setNombre(nombre);
	}
	public void setContraseña(String password) {
		super.setcontrasena(password);
	}

	@Override
	public void setContacto(Contacto contacto) {
		super.setContacto(contacto);
	}

	@Override
	public Contacto getContacto() {
		return super.getContacto();
	}

}
