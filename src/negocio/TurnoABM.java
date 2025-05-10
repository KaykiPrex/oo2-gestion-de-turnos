package negocio;

import dao.TurnoDao;
import datos.Cliente;
import datos.Profesional;
import datos.Servicio;
import datos.Turno;

import java.time.LocalDateTime;

public class TurnoABM {

    TurnoDao dao = new TurnoDao();

    public int agregarTurno(LocalDateTime date, Cliente cliente, Profesional profesional, Servicio servicio) {
        Turno t = new Turno(date, cliente, profesional, servicio);
        return dao.agregarTurno(t);
    }

    public Turno traerTurno(int id) {
        return dao.traerTurno(id);
    }

    public void eliminarTurno(long idTurno) {
        Turno t = dao.traerTurno(idTurno);
        dao.eliminarTurno(t);
    }



}
