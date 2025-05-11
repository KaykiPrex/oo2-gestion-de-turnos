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

	public void modificarFHTurno(Cliente cliente, long idTurno, LocalDateTime fechaHora) throws Exception{
		TurnoDao turnoDao = new TurnoDao();
		Turno t = turnoDao.traer(idTurno);

		if(t.getCliente().getId()!=cliente.getId()) throw new Exception("ERROR Este turno no le pertenece al cliente que quiere modificarlo");

		t.setFechaHora(fechaHora);
		turnoDao.actualizar(t);
	}

    public void cancelar(int idCliente, int idTurno) throws Exception {
        Turno turno= dao.traerTurno(idCliente, idTurno);
        if (turno==null) {
            throw new Exception("no existe el turno");
        }
        dao.cancelarTurno(turno);
    }

    public void pedirTurno(Cliente cliente, Turno turno) {
        dao.pedirTurno(cliente, turno);
    }
    public Turno traerTurno(int idCliente, int idTurno) throws Exception {
        return dao.traerTurno(idCliente, idTurno);
    }

}
