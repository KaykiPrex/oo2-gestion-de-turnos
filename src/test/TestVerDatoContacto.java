package test;

import datos.Persona;
import negocio.PersonaABM;

public class TestVerDatoContacto {

	public static void main(String[] args) {
		
		// Este test permite ver la informacion de contacto de un cliente o profesional
		// Dando excepciones si la persona no existe o si no hay datos de contacto asociados a esa persona.
		// Usar "Ana Torres" - "cliente1" para un Cliente existente
		try {
			Persona persona = PersonaABM.getInstance().login("Ana Torres", "cliente1");
			if (persona.getContacto() != null) {
				System.out.println("Datos de contacto de " + persona.getNombre() + ":");
				System.out.println("Email: " + persona.getContacto().getEmail());
				System.out.println("Telefono Fijo: " + persona.getContacto().getTelefonoFijo());
				System.out.println("Telefono Movil: " + persona.getContacto().getTelefonoMovil());
			} else {
				System.out.println("No hay datos de contacto asociados a " + persona.getNombre());
			}
		} catch (Exception e) {
			System.out.println("Error al ver datos de contacto: " + e.getMessage());
		}
		
	}

}
