package negocio;

import dao.ContactoDao;
import datos.Contacto;

public class ContactoABM {
    ContactoDao dao = new ContactoDao();

    public Contacto traer(long idContacto) {
        return dao.traer(idContacto);
    }

    // ** Modificar un contacto a una Persona **
    public void modificar(Contacto c) {
        dao.actualizar(c);
    }

    // ** Eliminar un contacto a una Persona **
    public void eliminar(long idContacto) {
        Contacto c = dao.traer(idContacto);
        dao.eliminar(c);
    }
}
