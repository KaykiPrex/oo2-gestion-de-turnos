package negocio;

import dao.PersonaDao;
import datos.Contacto;
import datos.Persona;

public class PersonaABM {

    PersonaDao dao = new PersonaDao();

    // ** Traer persona **
    public Persona traerPersona(long id) {
        return dao.traer(id);
    }

    // ** Registro de Usuario **
    public int registrar(String nombre, String contrasena, Contacto contacto) {
        Persona p = new Persona(nombre, contrasena, contacto);
        return dao.agregar(p);
    }

    // ** Inicio de Sesión **
    public Persona login(String nombre, String contrasena) throws Exception {
        Persona p = dao.traer(nombre, contrasena);
        if(p == null) {
            throw new Exception("No existe el usuario");
        }
        return p;
    }

    // ** Eliminar Usuario **
    public void eliminar(long idPersona) throws Exception  {
        Persona p = dao.traer(idPersona);
        if(p == null) {
            throw new Exception("No existe el usuario con ID:" + idPersona);
        }
        dao.eliminar(p);
    }

}
