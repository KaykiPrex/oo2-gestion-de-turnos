package test;

import negocio.*;

import java.time.LocalDateTime;

import dao.*;
import datos.*;

public class TestModificarFHTurno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*/ PASO 1. Creo un Cliente y lo agrego
	 
		ClienteABM abmClien = new ClienteABM();
		Cliente cliente = new Cliente("Juan", "1234", null);
		abmClien.agregar(cliente);
	
*/
		
		
	
		//	PASO 2. Creo un Turno y lo agrego

		/*
		TurnoABM abmTurno = new TurnoABM();
	 	ClienteABM abmClien = new ClienteABM();
		ProfesionalABM abmProf = new ProfesionalABM();		
		ServicioABM servicio = new ServicioABM();

		Turno turno = new Turno(LocalDateTime.now(), abmClien.traer(3L), abmProf.traer(5L) , servicio.traer(1L));
		
		abmTurno.agregar(turno);
		*/

	
		// PASO 3. Modifico la fechaHora del turno

		/*
		ClienteABM abmClien = new ClienteABM();
		TurnoABM abmTurno = new TurnoABM();
		
		System.out.println(abmTurno.traer(1L));
		
		try {
			abmClien.modificarFHTurno(abmClien.traer(3L), 1L, LocalDateTime.of(2025, 5, 20, 14, 01));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(abmTurno.traer(1L));
		*/
	

	
	}

}
