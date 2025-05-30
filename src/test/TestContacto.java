package test;

import negocio.ContactoABM;
import negocio.PersonaABM;

public class TestContacto {

    public static void main(String[] args) {
        ContactoABM abmContacto = new ContactoABM();

        // ** Ejemplo de asociar Contacto a Persona **

        try {
            abmContacto.asociar("prueba@hotmail.com.ar", "123454678", "123456", PersonaABM.getInstance().traer(1L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        // ** Ejemplo de eliminar Contacto a Persona **
        abmContacto.eliminar(1L);
    }

}
