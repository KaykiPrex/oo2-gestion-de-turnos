package negocio;

import dao.DisponibilidadDao;
import datos.Disponibilidad;
import datos.Profesional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class DisponibilidadABM {
    private static DisponibilidadABM instancia = null;
    
    protected DisponibilidadABM() {
    }
    
    public static DisponibilidadABM getInstance() {
		if (instancia == null) 
			instancia = new DisponibilidadABM();
		return instancia;
	}

    public long agregar(Disponibilidad d) {
        return DisponibilidadDao.getInstance().agregar(d);
    }

    public int agregar(LocalDate date, LocalTime time, boolean isBlocked, Profesional profesional) {
        Disponibilidad c = new Disponibilidad(date, time, isBlocked, profesional);
        return DisponibilidadDao.getInstance().agregar(c);
    }

    public Disponibilidad traer(long idDisponibilidad) {
        return DisponibilidadDao.getInstance().traer(idDisponibilidad);
    }


    public void modificar(Disponibilidad d) {
    	DisponibilidadDao.getInstance().actualizar(d);
    }

    public void reservarDisponibilidad(Disponibilidad d) {
        d.setDisponible(false);
        DisponibilidadDao.getInstance().actualizar(d);
    }

    public void liberarDisponibilidad(Disponibilidad d) {
        d.setDisponible(true);
        DisponibilidadDao.getInstance().actualizar(d);
    }
    
    public List<Disponibilidad> traerPosterior(Profesional profesional) throws Exception{
    	List<Disponibilidad> disponibilidades = DisponibilidadDao.getInstance().traerPosteriores(profesional);
    	if (profesional == null) {
    		throw new Exception("Error: El profesional no puede ser nulo.");
    	}
    	if (disponibilidades.isEmpty()) {
			throw new Exception("No hay disponibilidades para el profesional: " + profesional.getNombre());
		}
    	return disponibilidades;
    }

}
