package test;

import datos.Cliente;
import datos.Contacto;
import datos.Especialidad;
import datos.Profesional;
import negocio.EspecialidadABM;
import negocio.PersonaABM;

public class TestRegistro {

	public static void main(String[] args) {
		
		// ** Registro de un cliente **
		Cliente cliente = new Cliente("Luca Lazarte", "12345678", 46623965, new Contacto(), 1234);
		try {
			PersonaABM.getInstance().registrar(cliente);
		} catch (Exception e) {
			System.out.println("Error al registrar persona: " + e.getMessage());
		}
		
		// ** Creo una especialidad para el profesional **
		Especialidad especialidad = new Especialidad("Cardiología");
		try {
			EspecialidadABM.getInstance().agregar(especialidad);
		} catch (Exception e) {
			System.out.println("Error al agregar especialidad: " + e.getMessage());
		}
		
		// ** Registro de un profesional con la especialidad creada **
		Profesional profesional = new Profesional("Eric Boedo", "87654321", 46234869, new Contacto(), 1235,
				especialidad);
		try {
			PersonaABM.getInstance().registrar(profesional);
		} catch (Exception e) {
			System.out.println("Error al registrar persona: " + e.getMessage());
		}
		
	}

}
