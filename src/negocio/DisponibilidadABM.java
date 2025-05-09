package negocio;

import dao.DisponibilidadDao;
import datos.Disponibilidad;
import datos.Profesional;

import java.time.LocalDate;
import java.time.LocalTime;

public class DisponibilidadABM {
    DisponibilidadDao dao = new DisponibilidadDao();

    public Disponibilidad traer(long idDisponibilidad) {
        return dao.traer(idDisponibilidad);
    }

    public int agregar(LocalDate date, LocalTime time, boolean isBlocked, Profesional profesional) {
        Disponibilidad c = new Disponibilidad(date, time, isBlocked, profesional);
        return dao.agregar(c);
    }

    public void modificar(Disponibilidad d) {
        dao.actualizar(d);
    }

    public void reservarDisponibilidad(Disponibilidad d) {
        d.setDisponible(false);
        dao.actualizar(d);
    }

    public void liberarDisponibilidad(Disponibilidad d) {
        d.setDisponible(true);
        dao.actualizar(d);
    }
}
