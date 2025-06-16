package negocio;

import dao.ProfessionalServiceDao;
import datos.refactor.ProfessionalService;

public class ProfessionalServiceABM {
    ProfessionalServiceDao dao = new ProfessionalServiceDao();

    public int agregar(ProfessionalService p) {
        return dao.agregar(p);
    }

    public void modificar(ProfessionalService p) {
        dao.actualizar(p);
    }

    public void eliminar(int id) {
        ProfessionalService p = dao.traer(id);
        dao.eliminar(p);
    }

    public ProfessionalService traer(int id){
        return dao.traer(id);
    }

    public ProfessionalService traerProfesionalServicioYTurno(int id) {
        return dao.traerProfesionalServicioYTurno(id);
    }
}
