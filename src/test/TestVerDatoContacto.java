package test;

import datos.Persona;
import negocio.PersonaABM;

public class TestVerDatoContacto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Este test permite ver la informacion de contacto de un cliente o profesional
		
		try {
			Persona persona = PersonaABM.getInstance().login("Luca Lazarte", "12345678");
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
