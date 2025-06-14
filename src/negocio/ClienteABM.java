package negocio;

import java.time.LocalDateTime;

import dao.ClienteDao;
import dao.DisponibilidadDao;
import dao.TurnoDao;
import datos.Cliente;
import datos.Disponibilidad;
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
		
		if(t == null) {
			throw new Exception("ERROR: El turno no existe.");
		}
		if(cliente == null) {
			throw new Exception("ERROR: El cliente no existe.");
		}
		if(t.getCliente().getId() != cliente.getId()) {
			throw new Exception("ERROR: El turno no le pertenece al cliente.");
		}
		
		Disponibilidad nueva = null;
		for(Disponibilidad d : t.getProfesional().getDisponibilidades()) {
			if(d.getFecha().equals(fechaHora.toLocalDate()) && d.getHora().equals(fechaHora.toLocalTime())) {
				nueva = d;
			}
		}
		
		if(nueva == null) {
			throw new Exception("ERROR: El profesional no cuenta con esta disponibilidad.");
		}
		Disponibilidad anterior = DisponibilidadDao.getInstance().traer(t.getFechaHora().toLocalDate(), t.getFechaHora().toLocalTime(), t.getProfesional());
		if(anterior.getId() == nueva.getId()) {
			throw new Exception("ERROR: La nueva fecha y hora del turno es la misma que la anterior.");
		}
		if(!nueva.isDisponible()) {
			throw new Exception("ERROR: La disponibilidad no se encuentra disponible.");
		} 
		nueva.setDisponible(false);	// Pasa a estar ocupada
		DisponibilidadDao.getInstance().actualizar(nueva); 
		
		
		anterior.setDisponible(true); // La anterior disponibilidad pasa a estar disponible
		DisponibilidadDao.getInstance().actualizar(anterior);
		
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
	
	public void cancelarTurno(Cliente cliente, Turno turno) throws Exception{
		if(turno == null) {
			throw new Exception("ERROR: El turno no existe.");
		}
		if(cliente == null) {
			throw new Exception("ERROR: El cliente no existe.");
		}
		if(turno.getCliente().getId() != cliente.getId()) {
			throw new Exception("ERROR: El turno no le pertenece al cliente.");
		}
		Disponibilidad dispo = DisponibilidadDao.getInstance().traer(turno.getFechaHora().toLocalDate(), 
				turno.getFechaHora().toLocalTime(), 
				turno.getProfesional());;
		dispo.setDisponible(true); // La disponibilidad pasa a estar disponible
		DisponibilidadDao.getInstance().actualizar(dispo);;
		ClienteDao.getInstance().cancelarTurno(turno);
		
	}

}
