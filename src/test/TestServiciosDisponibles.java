package test;

import java.util.List;

import datos.Servicio;
import negocio.ServicioABM;

public class TestServiciosDisponibles {
	
	public static void main(String[] args) {
		
		// Test para obtener y mostrar todos los servicios disponibles
		try {
			List<Servicio> servicios = ServicioABM.getInstance().traerTodos();
			for (Servicio s : servicios) {
				System.out.println(s.toString());
			}
		} catch (Exception e) {
			System.out.println("Error al obtener los servicios: " + e.getMessage());
		}
		
	}
	
}
