package negocio;

import dao.TurnoDao;
import datos.Turno;

public class TurnoABM {
	
	TurnoDao dao = new TurnoDao();
	
	public long agregar(Turno objeto) {
		return dao.agregar(objeto);
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
