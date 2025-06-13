package negocio;

import dao.TurnoDao;
import datos.Cliente;
import datos.Profesional;
import datos.Servicio;
import datos.Turno;

import java.time.LocalDateTime;

public class TurnoABM {

	private static TurnoABM instancia = null;
	
	protected TurnoABM() {
	}
	
	public static TurnoABM getInstance() {
		if(instancia == null)
			instancia = new TurnoABM();
		return instancia;
	}

	public long agregar(Turno objeto) {
		return TurnoDao.getInstance().agregar(objeto);
	}

	public void modificar(Turno objeto) {
		TurnoDao.getInstance().actualizar(objeto);
	}

	public Turno traer(long id) {
		return TurnoDao.getInstance().traer(id);
	}

	public void eliminar(long id) {
		Turno objeto = TurnoDao.getInstance().traer(id);
		TurnoDao.getInstance().eliminar(objeto);
	}

    public long solicitarTurno(LocalDateTime date, Cliente cliente, 
    		Profesional profesional, Servicio servicio) throws Exception {
    	if (date == null || cliente == null || profesional == null || servicio == null) {
    		throw new Exception("ERROR: Todos los campos deben ser completados.");
    	}
    	if (date.isBefore(LocalDateTime.now())) {
    		throw new Exception("ERROR: La fecha y hora del turno no pueden ser en el pasado.");
    	}
    	if (!ProfesionalABM.getInstance().turnoFecha(date, profesional)) {
    		throw new Exception("ERROR: El profesional no tiene disponibilidad para la fecha y hora seleccionadas.");
    	}
        Turno t = new Turno(date, cliente, profesional, servicio);
        ClienteABM.getInstance().actualizarTurnos(cliente, t);
        return TurnoDao.getInstance().agregar(t);
    }

	public void derivar(long idTurno, Profesional profesionalAsignado) {
		Turno objeto = TurnoDao.getInstance().traer(idTurno);
		objeto.setProfesional(profesionalAsignado);
		TurnoDao.getInstance().actualizar(objeto);
	}


}
