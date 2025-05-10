package negocio;

import java.time.LocalDateTime;

import dao.ClienteDao;
import dao.TurnoDao;
import datos.Cliente;
import datos.Turno;

public class ClienteABM {
	ClienteDao dao = new ClienteDao();
	
	public long agregar(Cliente objeto) {
		return dao.agregar(objeto);
	}
	public Cliente traer(long id) {
		return dao.traer(id);
	}
	
	public void modificarFHTurno(long idTurno, LocalDateTime fechaHora) {
		TurnoDao turnoDao = new TurnoDao();
		Turno t = turnoDao.traer(idTurno);
		t.setFechaHora(fechaHora);
		turnoDao.actualizar(t);
	}
	
}
