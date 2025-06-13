package negocio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;


import dao.DisponibilidadDao;
import dao.ProfesionalDao;
import datos.Disponibilidad;
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
	
	public long crearDisponibilidad(LocalDate date, LocalTime time,  boolean bloked, Profesional p) {
		DisponibilidadDao disponibilidadDao = new DisponibilidadDao();
		Disponibilidad d = new Disponibilidad(date, time, bloked, p);
		disponibilidadDao.agregar(d);
		dao.actualizar(p);
		return d.getId();
	}
}
