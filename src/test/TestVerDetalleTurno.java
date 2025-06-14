package test;

import java.time.LocalDateTime;

import datos.Persona;
import negocio.PersonaABM;
import negocio.TurnoABM;

public class TestVerDetalleTurno {

	public static void main(String[] args) {
		
		try {
			// Método para traer un turno específico por fecha y cliente o profesional
			// Usar "Ana Torres" y "Dr. Pablo García" para un Cliente y Profesional existentes
			// En caso de error, se captura la excepción y se muestra un mensaje
			LocalDateTime fechaHora = LocalDateTime.of(2025, 7, 3, 14, 0);
			
			Persona cliente = PersonaABM.getInstance().traer("Ana Torres");
			System.out.println("Utilizando Cliente: " + TurnoABM.getInstance().traerTurnoPorFecha(fechaHora, cliente).toString());
			
			Persona profesional = PersonaABM.getInstance().traer("Dr. Pablo Garcia");
			System.out.println("Utilizando Profesional: " + TurnoABM.getInstance().traerTurnoPorFecha(fechaHora, profesional).toString());
			
		} catch (Exception e) {
			System.out.println("Error al traer la persona: " + e.getMessage());
		}

	}

}
