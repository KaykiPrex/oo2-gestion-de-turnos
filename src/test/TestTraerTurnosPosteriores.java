package test;

import java.util.List;

import datos.Cliente;
import datos.Turno;
import negocio.ClienteABM;
import negocio.TurnoABM;

public class TestTraerTurnosPosteriores {

	public static void main(String[] args) {
		
		try {
			// Método para traer los turnos futuros de un cliente específico
			// Usar "Luca Lazarte" para un Cliente existente
			// En caso de error, se captura la excepción y se muestra un mensaje
			Cliente cliente = ClienteABM.getInstance().traer("Luca Lazarte");
			List<Turno> turnos = TurnoABM.getInstance().traerTurnosFuturos(cliente);
			
			for (Turno t : turnos) {
				System.out.println(t.toString());
			}
			
		} catch (Exception e) {
			System.out.println("Error al traer los turnos: " + e.getMessage());
		}

	}

}
