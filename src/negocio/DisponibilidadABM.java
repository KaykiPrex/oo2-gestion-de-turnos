package negocio;

import dao.DisponibilidadDao;
import datos.Disponibilidad;

public class DisponibilidadABM {
    DisponibilidadDao dao = new DisponibilidadDao();

    public Disponibilidad traer(long idDisponibilidad) {
        return dao.traer(idDisponibilidad);
    }
}
