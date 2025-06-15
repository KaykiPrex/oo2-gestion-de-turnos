package negocio;

import dao.ContactDao;
import datos.refactor.Contact;

public class ContactABM {

    ContactDao dao = new ContactDao();

    public int agregar(Contact c) {
        return dao.agregar(c);
    }

    public void modificar(Contact c) {
        dao.actualizar(c);
    }

    public void eliminar(int id) {
        Contact c = dao.traer(id);
        dao.eliminar(c);
    }

    public Contact traer(int id){
        return dao.traer(id);
    }
}
