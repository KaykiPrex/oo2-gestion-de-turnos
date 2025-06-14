package test;

import java.util.List;

import datos.Especialidad;
import datos.Profesional;
import negocio.EspecialidadABM;
import negocio.ProfesionalABM;

public class TestVerProfesionalPorEspecialidad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Este test permite ver los profesionales asociados a una especialidad en el sistema
		// Dando excepciones si la especialidad no existe o si no hay profesionales asociados a esa especialidad.
		
		try {
			Especialidad especialidad = EspecialidadABM.getInstance().traer("Masajista");
			List<Profesional> profesionales = ProfesionalABM.getInstance().traerPorEspecialidad(especialidad);
			System.out.println("Los profesionales  del Sistema con Especialidad: "+ especialidad.getNombre() +" son los siguientes:");
			for(Profesional p : profesionales) {
				System.out.println(p.toString());
			}
			
			
		} catch (Exception e) {
			System.out.println("Error al buscar profesionales por especialidad: " + e.getMessage());
		}
		
		
		
	}

}
