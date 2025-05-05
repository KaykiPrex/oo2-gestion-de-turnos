package datos;

import java.util.List;

public class Cliente extends Persona{
	private List<Turno> turnos;
	
	public Cliente(String name, String password, Contacto contacto) {
		super(name, password, contacto);
	}

}
