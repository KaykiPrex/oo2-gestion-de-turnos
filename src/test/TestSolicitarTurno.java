package test;

import java.time.LocalDateTime;

import datos.Cliente;
import datos.Profesional;
import datos.Servicio;
import negocio.ClienteABM;
import negocio.ProfesionalABM;
import negocio.ServicioABM;
import negocio.TurnoABM;

public class TestSolicitarTurno {
	
	public static void main(String[] args) {
		
		try {
			// Traemos cliente, profesional y servicio por nombre. Creamos una fecha y hora para el turno.
			// En caso de no existir el cliente, profesional o servicio, se lanzará una excepción.
			// Si la fecha y hora son inválidas o el profesional no tiene disponibilidad, también se lanzará una excepción.
			Cliente cliente = ClienteABM.getInstance().traer("Luca Lazarte");
			Profesional profesional = ProfesionalABM.getInstance().traer("Eric Boedo");
			Servicio servicio = ServicioABM.getInstance().traer("Masaje Relajante");
			LocalDateTime fechaHora = LocalDateTime.of(2025, 7, 4, 12, 00);
			
			Long exito = TurnoABM.getInstance().solicitarTurno(fechaHora, cliente, profesional, servicio);
			
			System.out.println("Turno solicitado exitosamente. ID del turno: " + exito);
			
		} catch (Exception e) {
			System.out.println("Error al solicitar el turno: " + e.getMessage());
		}
		
	}
	
}
