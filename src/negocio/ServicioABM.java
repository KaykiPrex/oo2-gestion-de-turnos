package negocio;

import java.util.List;

import dao.ServicioDao;
import datos.Servicio;

public class ServicioABM {
    private static ServicioABM instancia = null;
    
    protected ServicioABM() {
    }
    
    public static ServicioABM getInstance() {
    	if (instancia == null)
    		instancia = new ServicioABM();
    	return instancia;
    }

    public long agregar(Servicio e) throws Exception {
        if (ServicioDao.getInstance().traer(e.getNombre()) != null) throw new Exception("Servicio ya creado");
        return ServicioDao.getInstance().agregar(e);
    }

    public Servicio traer(long idServicio) {
        return ServicioDao.getInstance().traer(idServicio);
    }

    public Servicio traer(String nombre) {
        return ServicioDao.getInstance().traer(nombre);
    }

    public void eliminar(long id) {
        Servicio e = ServicioDao.getInstance().traer(id);
        ServicioDao.getInstance().eliminar(e);
    }
    
    public List<Servicio> traerTodos() {
    	return ServicioDao.getInstance().traerTodos();
    }

}