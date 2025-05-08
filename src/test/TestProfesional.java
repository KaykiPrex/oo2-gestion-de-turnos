package test;

import datos.*;
import negocio.ContactoABM;
import negocio.DisponibilidadABM;
import negocio.EspecialidadABM;
import negocio.PersonaABM;

import java.util.List;
import java.util.Set;

public class TestProfesional {

    public static void main(String[] args) {
        ContactoABM abm = new ContactoABM();
        Contacto contacto = abm.traer(1);

        EspecialidadABM especialidadABM = new EspecialidadABM();
        especialidadABM.traer(1);

        DisponibilidadABM disponibilidadABM = new DisponibilidadABM();
        Disponibilidad disponibilidad = disponibilidadABM.traer(1);

        List<Persona> personas = PersonaABM.getInstance().traer();
        Persona p = PersonaABM.getInstance().traerProfesional(1);
        Profesional prof = (Profesional) p;
        Set<Disponibilidad> dis = prof.getDisponibilidades();
        Especialidad es = prof.getEspecialidad();

    }
}
