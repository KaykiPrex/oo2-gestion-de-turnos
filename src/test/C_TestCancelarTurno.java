package test;

import datos.refactor.Appointment;
import negocio.AppoinmentABM;

public class C_TestCancelarTurno {
    public static void main(String[] args) {
        // Cancelar turno
        System.out.println("========================= Cancelar Turno =========================");
        AppoinmentABM appoinmentABM = new AppoinmentABM();
        // Suponemos el turno obtenido en el anterior test de SolicitarTurno
        int turnoSolicitadoId = 1;
        Appointment appointment = appoinmentABM.traer(turnoSolicitadoId);
        System.out.println("Desea cancelar este turno : " + appointment);

        appointment.setClient(null);
        appointment.setIsBlocked(false);
        appoinmentABM.modificar(appointment);
        System.out.println("Turno Cancelado");

        System.out.println("========================= Cancelar Turno =========================");
    }
}
