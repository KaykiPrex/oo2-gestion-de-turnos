package negocio;

import dao.ContactoDao;
import datos.Contacto;

public class ContactoABM {
    ContactoDao dao = new ContactoDao();

    public Contacto traer(long idContacto) {
        Contacto c = dao.traer(idContacto);
        return c;
    }

}
