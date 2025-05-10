package negocio;

import dao.DisponibilidadDao;
import datos.Disponibilidad;

public class DisponibilidadABM {
    DisponibilidadDao dao = new DisponibilidadDao();

    public long agregar(Disponibilidad d) {
    	return dao.agregar(d);
    }
    public Disponibilidad traer(long idDisponibilidad) {
        return dao.traer(idDisponibilidad);
    }
    
    
}
