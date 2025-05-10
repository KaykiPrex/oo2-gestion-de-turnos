package negocio;

import dao.ClienteDao;
import datos.Cliente;
import datos.Turno;

public class ClienteABM {
    ClienteDao dao= new ClienteDao();

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


