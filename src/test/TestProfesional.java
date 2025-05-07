package test;

import datos.Contacto;
import datos.Disponibilidad;
import negocio.ContactoABM;
import negocio.DisponibilidadABM;
import negocio.EspecialidadABM;

public class TestProfesional {

    public static void main(String[] args) {
        ContactoABM abm = new ContactoABM();
        Contacto contacto = abm.traer(1);

        EspecialidadABM especialidadABM = new EspecialidadABM();
        especialidadABM.traer(1);

        DisponibilidadABM disponibilidadABM = new DisponibilidadABM();
        Disponibilidad disponibilidad = disponibilidadABM.traer(1);
    }
}
