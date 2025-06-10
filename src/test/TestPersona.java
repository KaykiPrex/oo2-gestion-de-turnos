package test;

import datos.Persona;
import negocio.PersonaABM;

public class TestPersona {

    public static void main(String[] args) {

        // ** Ejemplo del Registro **
        PersonaABM.getInstance().registrar("Luca Lazarte", "123456", null);

        // ** Ejemplo del Login **
        /*
        try {
            Persona login = PersonaABM.getInstance().login("Luca Lazarte", "123456");
            System.out.println(login.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        // ** Ejemplo del Eliminar **

        try {
            PersonaABM.getInstance().eliminar(1L);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        */

    }

}
