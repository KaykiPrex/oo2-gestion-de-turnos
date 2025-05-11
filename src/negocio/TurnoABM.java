package negocio;

import dao.TurnoDao;
import datos.Cliente;
import datos.Profesional;
import datos.Servicio;
import datos.Turno;

import java.time.LocalDateTime;

public class TurnoABM {

	TurnoDao dao = new TurnoDao();

	public long agregar(Turno objeto) {
		return dao.agregar(objeto);
	}

    public long agregarTurno(LocalDateTime date, Cliente cliente, Profesional profesional, Servicio servicio) {
        Turno t = new Turno(date, cliente, profesional, servicio);
        return dao.agregar(t);
    }

	public void modificar(Turno objeto) {
		dao.actualizar(objeto);
	}

	public Turno traer(long id) {
		return dao.traer(id);
	}

	public void eliminar(long id) {
		Turno objeto = dao.traer(id);
		dao.eliminar(objeto);
	}


}
