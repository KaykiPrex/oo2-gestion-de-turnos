package negocio;

import dao.ServicioDao;
import datos.Servicio;

public class ServicioABM {
    ServicioDao dao = new ServicioDao();

    public long agregar(Servicio e) throws Exception {
        if (dao.traer(e.getNombre()) != null) throw new Exception("Servicio ya creado");
        return dao.agregar(e);
    }

    public Servicio traer(long idEspecialidad) {
        return dao.traer(idEspecialidad);
    }

    public Servicio traer(String nombre) {
        return dao.traer(nombre);
    }

    public void eliminar(long id) {
        Servicio e = dao.traer(id);
        dao.eliminar(e);
    }
}