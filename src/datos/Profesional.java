package datos;

import java.util.HashSet;
import java.util.Set;


public class Profesional extends Persona{
	
	private Especialidad especialidad;
	private Set<Disponibilidad> disponibilidades;
	
	public Profesional(String name, String password, Contacto contacto, Especialidad especialidad) {
		super(name, password, contacto);
		this.especialidad = especialidad;
		this.disponibilidades = new HashSet();
	}
	
	public Profesional() {
	}
	
	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public Set<Disponibilidad> getDisponibilidades() {
		return disponibilidades;
	}

	public void setDisponibilidades(Set<Disponibilidad> lstDisponibilidades) {
		this.disponibilidades = lstDisponibilidades;
	}

	@Override
	public String toString() {
		return "Profesional ["+ super.toString() + " especialidad= " + especialidad  + "]";
	}

}
