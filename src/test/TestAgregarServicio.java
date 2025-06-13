package test;

import datos.Servicio;
import negocio.ServicioABM;

public class TestAgregarServicio {
	public static void main(String[] args) {
		
		// Test para agregar un nuevo servicio
		// En caso de querer probar con un servicio existente, se lanzará una excepción
		try {
			Servicio servicio = new Servicio("Masaje Relajante", "Un masaje para relajar los músculos y reducir el estrés",
					"1 hora", 8000.0);
			ServicioABM.getInstance().agregar(servicio);
			System.out.println("El servicio se ha agregado correctamente: " + servicio);
		} catch (Exception e) {
			System.out.println("Error al agregar el servicio: " + e.getMessage());
		}
		
	}
}
