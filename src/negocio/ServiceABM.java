package negocio;

import dao.ServiceDao;
import datos.refactor.Service;

public class ServiceABM {
    ServiceDao dao = new ServiceDao();

    public int agregar(Service s) {
        return dao.agregar(s);
    }

    public void modificar(Service s) {
        dao.actualizar(s);
    }

    public void eliminar(int id) {
        Service s = dao.traer(id);
        dao.eliminar(s);
    }

    public Service traer(int id){
        return dao.traer(id);
    }

    public Service traerServicioDeProfesional(int id) {
        return dao.traerServiciosDeProfesional(id);
    }
}
