package test;

import datos.*;
import negocio.*;

import java.util.List;
import java.util.Set;

public class TestProfesional {

    public static void main(String[] args) {

        DisponibilidadABM disponibilidadABM = new DisponibilidadABM();

        List<Persona> personas = PersonaABM.getInstance().traer();
        Persona p = PersonaABM.getInstance().traerProfesional(5L);
        Profesional prof = (Profesional) p;
        Set<Disponibilidad> dis = prof.getDisponibilidades();
        Especialidad es = prof.getEspecialidad();

        // Traer Disponibilidad del profesional
        Persona p1 = PersonaABM.getInstance().traerProfesional(5L);
        Profesional prof1 = (Profesional) p1;
        Set<Disponibilidad> disponibilidades = prof1.getDisponibilidades();
        System.out.println(disponibilidades);

        // Traer Especialidad del profesional
        Persona p2 = PersonaABM.getInstance().traerProfesional(5L);
        Profesional prof2 = (Profesional) p2;
        Especialidad especialidad = prof2.getEspecialidad();
        System.out.println(especialidad);

        // Liberar Disponibilidad del profesional
        long idDisponibilidad2 = 1L;
        Disponibilidad disponibilidad2 = disponibilidadABM.traer(idDisponibilidad2);
        disponibilidadABM.liberarDisponibilidad(disponibilidad2);
        System.out.println(disponibilidadABM.traer(idDisponibilidad2));

        // Reservar Disponibilidad del profesional
        long idDisponibilidad1 = 1L;
        Disponibilidad disponibilidad1 = disponibilidadABM.traer(idDisponibilidad1);
        disponibilidadABM.reservarDisponibilidad(disponibilidad1);
        System.out.println(disponibilidadABM.traer(idDisponibilidad1));

        // Derivar turno de profesional
        TurnoABM turnoABM = new TurnoABM();
        System.out.println(turnoABM.traer(1L));
        
        long idProfesional3 = 1L;
        long idTurno = 1L;
        Persona p3 = PersonaABM.getInstance().traerProfesional(7l);
        Profesional prof3 = (Profesional) p3;
        turnoABM.derivar(1L,prof3);
        System.out.println(turnoABM.traer(1L));

    }
}
