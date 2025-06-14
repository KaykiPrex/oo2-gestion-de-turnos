package test;

import datos.Cliente;
import negocio.ClienteABM;
import negocio.TurnoABM;

public class TestCancelarTurno {

	public static void main(String[] args) {
		// TODO Auto-generated method stubç
		
		// Se cancela un turno de un cliente
		// Dando excepciones si el turno no le pertenece al cliente, si el turno no existe,
		// o si el cliente no existe.
		
		Cliente cliente = ClienteABM.getInstance().traer("Luca Lazarte");
		try {
			ClienteABM.getInstance().cancelarTurno(cliente, TurnoABM.getInstance().traer(1));
			System.out.println("El turno ha sido cancelado exitosamente.");
		} catch (Exception e) {
			System.out.println("ERROR al cancelar el turno: " + e.getMessage());
		}
	}

}
