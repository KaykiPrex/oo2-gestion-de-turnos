package negocio;

import java.time.LocalDateTime;

import dao.ClienteDao;
import dao.TurnoDao;
import datos.Cliente;
import datos.Turno;

public class ClienteABM {
	private static ClienteABM instancia = null;
	
	protected ClienteABM() {
	}
	 
	public static ClienteABM getInstance() {
		if(instancia == null) 
			instancia = new ClienteABM();
		return instancia;
	}

	public long agregar(Cliente objeto) {
		return ClienteDao.getInstance().agregar(objeto);
	}
	
	public Cliente traer(long id) {
		return ClienteDao.getInstance().traer(id);
	}
	
	public Cliente traer(String nombre) {
		return ClienteDao.getInstance().traer(nombre);
	}
	
	public void actualizar(Cliente objeto) {
		ClienteDao.getInstance().actualizar(objeto);
	}
	
	public void modificarFHTurno(Cliente cliente, long idTurno, LocalDateTime fechaHora) throws Exception{
		Turno t = TurnoDao.getInstance().traer(idTurno);

		if(t.getCliente().getId()!=cliente.getId()) throw new Exception("ERROR Este turno no le pertenece al cliente que quiere modificarlo");

		t.setFechaHora(fechaHora);
		TurnoDao.getInstance().actualizar(t);
	}
	
    public Turno traerTurno(int idCliente, int idTurno) throws Exception {
        return ClienteDao.getInstance().traerTurno(idCliente, idTurno);
    }

	public void actualizarTurnos(Cliente cliente, Turno t) {
		cliente.getTurnos().add(t);
		ClienteDao.getInstance().actualizar(cliente);
	}

}
