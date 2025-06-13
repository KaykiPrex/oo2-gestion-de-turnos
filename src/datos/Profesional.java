package datos;

import java.util.HashSet;
import java.util.Set;

public class Profesional extends Persona {
	private long nroMatricula;
    private Especialidad especialidad;
    private Set<Disponibilidad> disponibilidades;

    public Profesional() {
    }

    public Profesional(String name, String password, long dni, long nroMatricula, Especialidad especialidad) {
        super(name, password, dni);
        this.nroMatricula = nroMatricula;
        this.especialidad = especialidad;
        this.disponibilidades = new HashSet<>();
    }

	public long getNroMatricula() {
		return nroMatricula;
	}

	public void setNroMatricula(long nroMatricula) {
		this.nroMatricula = nroMatricula;
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

    public void setDisponibilidades(Set<Disponibilidad> disponibilidades) {
        this.disponibilidades = disponibilidades;
    }

    @Override
    public String toString() {
        return "Profesional [" + super.toString() + " especialidad= " + especialidad + "]";
    }
}
