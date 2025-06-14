package test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import datos.Cliente;
import negocio.ClienteABM;

public class TestModificarFechaHoraTurno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Se modifica la fecha y hora del turno de un cliente
		// Dando excepciones si el turno no le pertenece al cliente, si el profesional no cuenta 
		// con la disponibilidad, si la disponibilidad no se encuentra disponible o 
		// si la nueva fecha y hora del turno es la misma que la anterior.
		
		Cliente cliente = ClienteABM.getInstance().traer("Luca Lazarte");
		try {
			ClienteABM.getInstance().modificarFHTurno(cliente, 1L, LocalDateTime.of(LocalDate.of(2025, 7, 6), LocalTime.of(10, 00)));
			System.out.println("Fecha y hora del turno modificada correctamente.");
		} catch (Exception e) {
			System.out.println("ERROR al modificar la fecha y hora del turno: " + e.getMessage());
		}
	}

}
