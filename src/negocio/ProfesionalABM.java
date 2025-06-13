package negocio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;


import dao.DisponibilidadDao;
import dao.ProfesionalDao;
import datos.Disponibilidad;
import datos.Especialidad;
import datos.Profesional;

public class ProfesionalABM {
	ProfesionalDao dao = new ProfesionalDao();
	
	public long agregar(Profesional p) {
		return dao.agregar(p);
	}
	
	public void modificar(Profesional p) {
		dao.actualizar(p);
	}
	
	public void eliminar(long id) {
		Profesional p = dao.traer(id);
		dao.eliminar(p);
	}
	
	public Profesional traer(long id){
		return dao.traer(id);
	}
	
	public Profesional traer(String nombre){
		return dao.traer(nombre);
	}
	
	public Set<Disponibilidad> verDisponibilidad(Profesional p) {
		DisponibilidadDao disponibilidadDao = new DisponibilidadDao();
		Set<Disponibilidad> list = disponibilidadDao.traer(p);
		return list;
	}
	
	public void crearDisponibilidadesDesocupadas(LocalDate fechaDesde, LocalDate fechaHasta, LocalTime horaDesde, LocalTime horaHasta
			,  Long duracion, Profesional p) {
		DisponibilidadDao disponibilidadDao = new DisponibilidadDao();
		LocalTime horaActual = horaDesde;
		LocalDate fechaActual = fechaDesde;
		while(!fechaActual.isAfter(fechaHasta) ) {
			while(!horaActual.plusMinutes(duracion).isAfter(horaHasta)) {
				Disponibilidad d = new Disponibilidad(fechaActual, horaActual, false, p);
				disponibilidadDao.agregar(d);
				dao.actualizar(p);
				horaActual = horaActual.plusMinutes(duracion);
			}
			fechaActual = fechaActual.plusDays(1);
		}
	}

	public List<Profesional> traerPorEspecialidad(Especialidad e){
		return dao.traerPorEspecialidad(e);
	}

}
