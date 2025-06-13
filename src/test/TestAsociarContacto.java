package test;

import datos.Cliente;
import datos.Contacto;
import datos.Persona;
import datos.Profesional;
import negocio.PersonaABM;

public class TestAsociarContacto {
	
	public static void main(String[] args) {
		
		try {
			Persona persona = PersonaABM.getInstance().login("Luca Lazarte", "12345678");
			
			Contacto nuevoContacto = new Contacto("luca.lazarte05@gmail.com", "12345678",
					"1123456789");
			nuevoContacto.setPersona(persona);
			
			PersonaABM.getInstance().agregarContacto(persona, nuevoContacto);
			
			if(persona instanceof Cliente) {
				Cliente cliente = (Cliente) persona;
				System.out.println("Cliente actualizado: " + cliente.getNombre() +
						", Contacto: " + cliente.getContacto().toString());
			} else if(persona instanceof Profesional) {
				Profesional profesional = (Profesional) persona;
				System.out.println("Profesional actualizado: " + profesional.getNombre() +
						", Contacto: " + profesional.getContacto().toString());
			}
		} catch (Exception e) {
			System.out.println("Error al asociar contacto: + e.getMessage()");
		}
		
	}
	
}
