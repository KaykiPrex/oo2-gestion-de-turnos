package test;

import datos.Cliente;
import datos.Persona;
import datos.Profesional;
import negocio.PersonaABM;

public class TestLogin {
	
	public static void main(String[] args) {
		
		try {	// ### Poner Nombre y Contraseña válidos / Poner Nombre y Contraseña inválidos para Excepción ###
			
			// Usar "Luca Lazarte" y "12345678" para un Cliente existente
			// o "Eric Boedo" y "87654321" para un Profesional existente
			Persona persona = PersonaABM.getInstance().login("Luca Lazarte", "12345678");
			
			if(persona instanceof Cliente) {
				Cliente cliente = (Cliente) persona;
				System.out.println("¡Bienvenido Cliente! Nombre: " + cliente.getNombre() + 
						", Nro Cliente: " + cliente.getNroCliente());
			} else if(persona instanceof Profesional) {
				Profesional profesional = (Profesional) persona;
				System.out.println("¡Bienvenido Profesional! Nombre: " + profesional.getNombre() + 
						", Especialidad: " + profesional.getEspecialidad().getNombre() + 
						", Matricula: " + profesional.getNroMatricula());
			}
		} catch (Exception e) {
			System.out.println("Error al iniciar sesión: " + e.getMessage());
		}
		
	}
	
}
