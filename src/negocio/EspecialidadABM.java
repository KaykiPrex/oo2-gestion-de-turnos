package negocio;

import dao.EspecialidadDao;
import datos.Especialidad;

public class EspecialidadABM {
    EspecialidadDao dao = new EspecialidadDao();

    public Especialidad traer(long idEspecialidad) {
        return dao.traer(idEspecialidad);
    }
}
