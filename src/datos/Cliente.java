package datos;

import java.util.HashSet;
import java.util.Set;


public class Cliente extends Persona {
	private long nroCliente;
    private Set<Turno> turnos;

    public Cliente(String name, String password, long dni, long nroCliente) {
        super(name, password, dni);
        this.nroCliente = nroCliente;
        this.turnos = new HashSet<Turno>();
    }

	public long getNroCliente() {
		return nroCliente;
	}

	public void setNroCliente(long nroCliente) {
		this.nroCliente = nroCliente;
	}

    public Cliente() {
    }

    public Set<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(Set<Turno> turnos) {
        this.turnos = turnos;
    }

    @Override
    public String toString() {
        return "Cliente [" + super.toString() + "]";
    }
}
