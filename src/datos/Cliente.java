package datos;


import java.util.ArrayList;
import java.util.List;


public class Cliente extends Persona{
	private List<Turno> turnos;
	public Cliente(String name, String password, Contacto contacto) {
		super(name,  password, contacto);
		this.turnos = new ArrayList<Turno>();
	}

	public Cliente() {
	}

	public List<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}

	@Override
	public String toString() {
		return "Cliente [" + super.toString() + "]";
	}
}
