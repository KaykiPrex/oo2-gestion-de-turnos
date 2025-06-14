package test;

import java.util.Set;

import datos.Disponibilidad;
import datos.Profesional;
import negocio.DisponibilidadABM;
import negocio.ProfesionalABM;

public class TestVerDisponibilidades {

	public static void main(String[] args) {
		
		try {
			
			Profesional profesional = ProfesionalABM.getInstance().traer("Eric Boedo");
			Set<Disponibilidad> disponibilidades = DisponibilidadABM.getInstance().traerPosterior(profesional);
			
			for (Disponibilidad d : disponibilidades) {
				System.out.println(d.toString());
			}
		
		} catch (Exception e) {
			System.out.println("Error al traer las disponibilidades: " + e.getMessage());
		}
		
	}

}
