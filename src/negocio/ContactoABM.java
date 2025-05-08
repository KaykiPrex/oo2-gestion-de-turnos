package negocio;

import dao.ContactoDao;
import datos.Contacto;
import datos.Persona;

public class ContactoABM {
    ContactoDao dao = new ContactoDao();

    public Contacto traer(long idContacto) {
        return dao.traer(idContacto);
    }

    // ** Asignar un contacto a una Persona **
    public int asociar(String email, String telefonoFijo, String telefonoMovil, Persona persona) throws Exception {
        if(persona.getContacto() != null) {
            throw new Exception("El cliente ya cuenta con un contacto asociado");
        }
        Contacto c = new Contacto(email, telefonoFijo, telefonoMovil, persona);
        return dao.agregar(c);
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
