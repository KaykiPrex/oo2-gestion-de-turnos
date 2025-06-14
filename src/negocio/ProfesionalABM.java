package negocio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import dao.DisponibilidadDao;
import dao.ProfesionalDao;
import datos.Disponibilidad;
import datos.Especialidad;
import datos.Profesional;

public class ProfesionalABM {
	private static ProfesionalABM instancia = null;
	
	protected ProfesionalABM() {
	}
	
	public static ProfesionalABM getInstance() {
		if (instancia == null) 
			instancia = new ProfesionalABM();
		return instancia;
	}
	
	public long agregar(Profesional p) {
		return ProfesionalDao.getInstance().agregar(p);
	}
	
	public void modificar(Profesional p) {
		ProfesionalDao.getInstance().actualizar(p);
	}
	
	public void eliminar(long id) {
		Profesional p = ProfesionalDao.getInstance().traer(id);
		ProfesionalDao.getInstance().eliminar(p);
	}
	
	public Profesional traer(long id){
		return ProfesionalDao.getInstance().traer(id);
	}
	
	public Profesional traer(String nombre){
		return ProfesionalDao.getInstance().traer(nombre);
	}
	
	public List<Disponibilidad> verDisponibilidad(Profesional p) {
		List<Disponibilidad> list = DisponibilidadDao.getInstance().traerPosteriores(p);
		return list;
	}
	
	public void crearDisponibilidadesDesocupadas(LocalDate fechaDesde, LocalDate fechaHasta, LocalTime horaDesde, LocalTime horaHasta
			,  Long duracion, Profesional p) throws Exception{
		if(p==null) {
			throw new Exception("ERROR: No existe el profesional");
		}
		if(fechaDesde.isAfter(fechaHasta)) {
			throw new Exception("ERROR: La fecha de inicio no puede ser posterior a la fecha de fin");
		}
		if(fechaDesde.equals(fechaHasta) && horaDesde.isAfter(horaHasta)) {
			throw new Exception("ERROR: La hora de inicio no puede ser posterior a la hora de fin en el mismo dia");
		}
		LocalDate fechaActual = fechaDesde;
		while(!fechaActual.isAfter(fechaHasta) ) {
			LocalTime horaActual = horaDesde;
			while(!horaActual.plusMinutes(duracion).isAfter(horaHasta)) {
				Disponibilidad d = new Disponibilidad(fechaActual, horaActual, true, p);
				p.getDisponibilidades().add(d);
				DisponibilidadDao.getInstance().agregar(d);
				horaActual = horaActual.plusMinutes(duracion);
			}
			fechaActual = fechaActual.plusDays(1);
		}
		ProfesionalDao.getInstance().actualizar(p);
	}

	public List<Profesional> traerPorEspecialidad(Especialidad e) throws Exception {
		if (e == null) {
			throw new Exception("ERROR: No existe la especialidad");
		}
		List<Profesional> profesionales = ProfesionalDao.getInstance().traerPorEspecialidad(e);
		if (profesionales == null || profesionales.isEmpty()) {
			throw new Exception("ERROR: No hay profesionales asociados a esta especialidad");
		}
		return profesionales;
	}
	
	public boolean turnoFecha(LocalDateTime fechaHora, Profesional profesional) {
		List<Disponibilidad> disponibilidades = verDisponibilidad(profesional);
		for (Disponibilidad d : disponibilidades) {
			if (d.getFecha().equals(fechaHora.toLocalDate()) && 
				d.getHora().equals(fechaHora.toLocalTime()) && 
				d.isDisponible()) {
				d.setDisponible(false);
				DisponibilidadABM.getInstance().reservarDisponibilidad(d);
				return true;
			}
		}
		return false;
	}

}
