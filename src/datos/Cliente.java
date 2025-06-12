package datos;


import java.util.ArrayList;
import java.util.List;


public class Cliente extends Persona {
	private long nroCliente;
    private List<Turno> turnos;

    public Cliente(String name, String password, long dni, Contacto contacto, long nroCliente) {
        super(name, password, dni, contacto);
        this.nroCliente = nroCliente;
        this.turnos = new ArrayList<Turno>();
    }

	public long getNroCliente() {
		return nroCliente;
	}

	public void setNroCliente(long nroCliente) {
		this.nroCliente = nroCliente;
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
