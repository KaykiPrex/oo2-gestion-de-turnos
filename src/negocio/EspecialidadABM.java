package negocio;

import dao.EspecialidadDao;
import datos.Especialidad;

public class EspecialidadABM {
    EspecialidadDao dao = new EspecialidadDao();

    public long agregar(Especialidad e) throws Exception {
        if (dao.traer(e.getNombre()) != null) throw new Exception("Especialidad ya creada");
        return dao.agregar(e);
    }

    public Especialidad traer(long idEspecialidad) {
        return dao.traer(idEspecialidad);
    }

    public Especialidad traer(String nombre) {
        return dao.traer(nombre);
    }

    public void eliminar(long id) {
        Especialidad e = dao.traer(id);
        dao.eliminar(e);
    }
}