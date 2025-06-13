package test;

import datos.Cliente;
import datos.Especialidad;
import datos.Profesional;
import negocio.EspecialidadABM;
import negocio.PersonaABM;

public class TestRegistro {

	public static void main(String[] args) {
		
		// ** Registro de un cliente **
		Cliente cliente = new Cliente("Luca Lazarte", "12345678", 46623965, 1234);
		try {
			PersonaABM.getInstance().registrar(cliente);
			System.out.println("Cliente registrado exitosamente: " + cliente.getNombre() +
					", Nro Cliente: " + cliente.getNroCliente());
		} catch (Exception e) {
			System.out.println("Error al registrar cliente: " + e.getMessage());
		}
		
		// ** Traigo una especialidad de la base de datos para el profesional **
		Especialidad especialidad = EspecialidadABM.getInstance().traer("Masajista");
		
		// ** Registro de un profesional con la especialidad creada **
		Profesional profesional = new Profesional("Eric Boedo", "87654321", 46234869, 1235, especialidad);
		try {
			PersonaABM.getInstance().registrar(profesional);
			System.out.println("Profesional registrado exitosamente: " + profesional.getNombre() +
					", Especialidad: " + profesional.getEspecialidad().getNombre() +
					", Matricula: " + profesional.getNroMatricula());
		} catch (Exception e) {
			System.out.println("Error al registrar profesional: " + e.getMessage());
		}
		
	}

}
