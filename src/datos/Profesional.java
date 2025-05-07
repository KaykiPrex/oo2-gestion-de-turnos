package datos;

import java.util.List;

public class Profesional extends Persona{
	private Especialidad especialidad;
	private List<Disponibilidad> disponibilidades;

	public Profesional(String name, String password, Contacto contacto, Especialidad especialidad, List<Disponibilidad> disponibilidades) {
		super(name, password, contacto);
		this.especialidad = especialidad;
		this.disponibilidades = disponibilidades;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public List<Disponibilidad> getDisponibilidades() {
		return disponibilidades;
	}

	public void setDisponibilidades(List<Disponibilidad> disponibilidades) {
		this.disponibilidades = disponibilidades;
	}
}
