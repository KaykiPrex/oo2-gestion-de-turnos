package test;

import negocio.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

import datos.*;


public class TestDisponibilidadProfesional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			
	/*  //PASO 1. Se crean las distintas Especialidades del sistema
	
		EspecialidadABM abmEspe = new EspecialidadABM();
	 
	 	Especialidad e1 = new Especialidad("Profesor");
	 	Especialidad e2 = new Especialidad("Medico");
	 	Especialidad e3 = new Especialidad("Enfermera");
	
		try {
			abmEspe.agregar(e1);
			abmEspe.agregar(e2);
			abmEspe.agregar(e3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	*/
		
		
	/* 	//PASO 2. Se crea un Profesional
	 	
	 	EspecialidadABM abmEspe = new EspecialidadABM();
	 	
		Especialidad e1 = abmEspe.traer("Medico");
		
		Profesional p = new Profesional("Luca", "123456", null, e1);
		
		ProfesionalABM abmProf = new ProfesionalABM();
			
		abmProf.agregar(p);
	*/		
		

	/* 	//PASO 3. Se crea la Disponibilidad de un Profesional
		
		ProfesionalABM abmProf = new ProfesionalABM();
		DisponibilidadABM abmDisp = new DisponibilidadABM();
		
		Profesional p = abmProf.traer(21L);
		
		abmProf.crearDisponibilidad(LocalDate.of(2025, 5, 18), LocalTime.now(), true, p);
		
	*/	
		
	/*	//PASO 4. Se muestran las Disponibilidades del Profesional
	
		ProfesionalABM abmProf = new ProfesionalABM();
		Profesional p = abmProf.traer(21L);

		Set<Disponibilidad> dispo = abmProf.verDisponibilidad(p);
	
		for(Disponibilidad dq: dispo) {
			System.out.println(dq.toString());
		}
	*/

	}

}
