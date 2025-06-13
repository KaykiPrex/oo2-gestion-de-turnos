package test;

import java.util.List;

import datos.Especialidad;
import datos.Profesional;
import negocio.EspecialidadABM;
import negocio.ProfesionalABM;

public class TestVerProfesionalPorEspecialidad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EspecialidadABM espeABM = new EspecialidadABM();
		ProfesionalABM profABM = new ProfesionalABM();
		
		Especialidad especialidad = espeABM.traer("Cardiología");
		if(especialidad != null) {
			System.out.println("Los profesionales  del Sistema con Especialidad: "+ especialidad.getNombre() +" son los siguientes:");
			List<Profesional> profesionales = profABM.traerPorEspecialidad(especialidad);
			if(profesionales.isEmpty() || profesionales == null) {
				System.out.println("ERROR: Esta especialidad no tiene profesionales asociados.");
			} else {
				for(Profesional p : profesionales) {
					System.out.println(p.toString());
				}
			}
		} else {
			System.out.println("Error: No existe la especialidad buscada.");
		}
		
		
	}

}
