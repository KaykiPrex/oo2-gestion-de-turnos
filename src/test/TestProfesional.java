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

        // Traer Disponibilidad del profesional
        long idProfesional1 = 1L;
        Persona p1 = PersonaABM.getInstance().traerProfesional(idProfesional1);
        Profesional prof1 = (Profesional) p1;
        Set<Disponibilidad> disponibilidades = prof1.getDisponibilidades();

        // Traer Especialidad del profesional
        long idProfesional2 = 1L;
        Persona p2 = PersonaABM.getInstance().traerProfesional(idProfesional2);
        Profesional prof2 = (Profesional) p2;
        Especialidad especialidad = prof2.getEspecialidad();

        // Reservar Disponibilidad del profesional
        long idDisponibilidad1 = 1L;
        DisponibilidadABM disponibilidadABM2 = new DisponibilidadABM();
        Disponibilidad disponibilidad1 = disponibilidadABM.traer(idDisponibilidad1);
        disponibilidadABM2.reservarDisponibilidad(disponibilidad1);

        // Liberar Disponibilidad del profesional
        long idDisponibilidad2 = 1L;
        DisponibilidadABM disponibilidadABM3 = new DisponibilidadABM();
        Disponibilidad disponibilidad2 = disponibilidadABM.traer(idDisponibilidad2);
        disponibilidadABM2.liberarDisponibilidad(disponibilidad2);

    }
}
