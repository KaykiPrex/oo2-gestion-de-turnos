package test;

import datos.Especialidad;
import negocio.EspecialidadABM;

public class TestAgregarEspecialidad {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Este test permite agregar una especialidad al sistema
		// Dando como excepcion si ya existe una especialidad con el mismo nombre
		
		Especialidad e1 = new Especialidad("Cardiología");
		EspecialidadABM especialidadABM = new EspecialidadABM();
		
		try {
			especialidadABM.agregar(e1);
			System.out.println("----> Se agrega la especialidad llamada: " + e1.getNombre());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error al agregar una Especialidad: " + e.getMessage());
		}
	}

}