package negocio;

import dao.SpecialtyDao;
import datos.refactor.Specialty;

import java.util.List;

public class SpecialtyABM {
    SpecialtyDao dao = new SpecialtyDao();

    public int agregar(Specialty s) {
        return dao.agregar(s);
    }

    public void modificar(Specialty s) {
        dao.actualizar(s);
    }

    public void eliminar(int id) {
        Specialty s = dao.traer(id);
        dao.eliminar(s);
    }

    public Specialty traer(int id){
        return dao.traer(id);
    }

    public Specialty traerEspecialidadYServicios(int id) {
        return dao.traerEspecialidadYServicios(id);
    }
}
