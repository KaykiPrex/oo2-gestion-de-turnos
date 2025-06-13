package test;

import java.time.LocalDate;
import java.time.LocalTime;

import datos.Profesional;
import negocio.ProfesionalABM;

public class TestGenerarDisponibilidades {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProfesionalABM profAbm = new ProfesionalABM();
		
		Profesional profesional = profAbm.traer("Eric Boedo");
		

		/// SE DETERMINA LA FECHA DONDE SE EMPEZARAN A GENERAR LAS DISPONIBILIDADES 
		LocalDate fechaDesde = LocalDate.of(2025, 7, 4);

		/// SE DETERMINA LA FECHA DONDE SE TERMINARAN DE GENERAR LAS DISPONIBILIDADES
		LocalDate fechaHasta = LocalDate.of(2025, 7, 6);

		/// SE DETERMINA LA HORA DONDE SE EMPEZARAN A GENERAR LAS DISPONIBILIDADES DE CADA DIA
		LocalTime horaInicio = LocalTime.of(10, 30);
		
		/// SE DETERMINA LA HORA DONDE SE TERMINARAN DE GENERAR LAS DISPONIBILIDADES DE CADA DIA
		LocalTime horaFin = LocalTime.of(12, 30);
		
		/// SE DETERMINA LA DURACION DE CADA DISPONIBILIDAD EN MINUTOS
		Long duracionEnMinutos = 30L;
		
		System.out.println("Se le generaran disponibilidades desocupadas automaticamente al profesional llamado: " + profesional.getNombre() + " con Matricula: " + profesional.getNroMatricula());
		System.out.println("Las disponibilidades se generaran desde la fecha " + fechaDesde + " hasta " + fechaHasta + "\ny desde la hora " + horaInicio + " hasta " + horaFin + ", con una duracion de " + duracionEnMinutos + " minutos.");
		profAbm.crearDisponibilidadesDesocupadas(fechaDesde, fechaHasta, horaInicio, horaFin, duracionEnMinutos, profesional);
		
		System.out.println("Disponibilidades generadas correctamente!!");
		
	}

}
