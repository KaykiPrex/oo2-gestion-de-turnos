package negocio;

import dao.PersonaDao;
import datos.Persona;

import java.util.List;

public class PersonaABM {
    private static PersonaABM instancia = null;

    protected PersonaABM() {
    }

    public static PersonaABM getInstance() {
        if (instancia == null)
            instancia = new PersonaABM();
        return instancia;
    }

    public Persona traer(long idPersona) {
        return PersonaDao.getInstance().traer(idPersona);
    }

    public Persona traerProfesional(long idProfesional) {
        return PersonaDao.getInstance().traerProfesionalDisponibilidadesYEspecialidad(idProfesional);
    }

    public List<Persona> traer() {
        return PersonaDao.getInstance().traer();
    }
}
