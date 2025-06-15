package negocio;

import dao.ProfessionalSpecialtyDao;
import datos.refactor.ProfessionalSpecialty;

public class ProfessionalSpecialtyABM {
    ProfessionalSpecialtyDao dao = new ProfessionalSpecialtyDao();

    public int agregar(ProfessionalSpecialty p) {
        return dao.agregar(p);
    }

    public void modificar(ProfessionalSpecialty p) {
        dao.actualizar(p);
    }

    public void eliminar(int id) {
        ProfessionalSpecialty p = dao.traer(id);
        dao.eliminar(p);
    }

    public ProfessionalSpecialty traer(int id){
        return dao.traer(id);
    }
}
