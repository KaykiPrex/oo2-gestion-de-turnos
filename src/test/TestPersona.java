package test;

import datos.Persona;
import negocio.PersonaABM;

public class TestPersona {

    public static void main(String[] args) {

        PersonaABM abmPersona = new PersonaABM();

        // ** Ejemplo del Registro **
        // abmPersona.registrar("UNLa", "UNLa1234", null);

        // ** Ejemplo del Login **
        /*
		try {
			Persona login = abmPersona.login("UNLa", "UNLa1234");
			System.out.println(login.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
        */

        // ** Ejemplo del Eliminar **
		/*
		try {
			abmPersona.eliminar(1L);
		} catch (Exception e) {
			System.out.println(e.getMessage());;
		}
	    */
    }

}
