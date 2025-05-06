package datos;


import java.util.ArrayList;
import java.util.List;


public class Cliente extends Persona{
	private List<Turno> turnos;
	public Cliente(String name, String password, Contacto contacto) {
		super(name,  password, contacto);
		this.turnos = new ArrayList<Turno>();
	}

	public void pedirTurno(Turno turno) {
		turnos.add(turno);
		System.out.println("Turno agendado: " + turno);
	}


	public boolean cancelarTurno(Turno turno) {
		if (turnos.contains(turno)) {
			turnos.remove(turno);
			System.out.println("Turno cancelado: " + turno);
			return true;
		} else {
			System.out.println("El turno no existe.");
			return false;
		}
	}


	public List<Turno> traerHistorialTurnos() {
		return turnos;
	}

}
