package negocio;

import java.util.List;

import dao.EspecialidadDao;
import datos.Especialidad;

public class EspecialidadABM {
	private static EspecialidadABM instancia = null;
	
    public static EspecialidadABM getInstance() {
    	if (instancia == null)
    		instancia = new EspecialidadABM();
    	return instancia;
    }

    public long agregar(Especialidad e) throws Exception {
        if (EspecialidadDao.getInstance().traer(e.getNombre()) != null) throw new Exception("Especialidad ya creada");
        return EspecialidadDao.getInstance().agregar(e);
    }

    public Especialidad traer(long idEspecialidad) {
        return EspecialidadDao.getInstance().traer(idEspecialidad);
    }

    public Especialidad traer(String nombre) {
        return EspecialidadDao.getInstance().traer(nombre);
    }

    public List<Especialidad> traer(){
    	return EspecialidadDao.getInstance().traer();
    }
    
    public void eliminar(long id) {
        Especialidad e = EspecialidadDao.getInstance().traer(id);
        EspecialidadDao.getInstance().eliminar(e);
    }
}