package dao;

import datos.Especialidad;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class EspecialidadDao {
    private static Session session;
    private Transaction tx;
    private static EspecialidadDao instancia = null;
    
    protected EspecialidadDao() {}
    
    public static EspecialidadDao getInstance() {
    	if (instancia == null)
    		instancia = new EspecialidadDao();
    	return instancia;
    }

    private void iniciaOperacion() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("ERROR en la capa de acceso a datos", he);
    }

    public long agregar(Especialidad objeto) {
        long id = 0;
        try {
            iniciaOperacion();
            id = Integer.parseInt(session.save(objeto).toString());
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
        return id;
    }

    public void actualizar(Especialidad objeto) {
        try {
            iniciaOperacion();
            session.update(objeto);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
    }

    public void eliminar(Especialidad objeto) {
        try {
            iniciaOperacion();
            session.delete(objeto);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
    }

    public Especialidad traer(long idEspecialidad) {
        Especialidad objeto = null;
        try {
            iniciaOperacion();
            objeto = (Especialidad) session.get(Especialidad.class, idEspecialidad);
        } finally {
            session.close();
        }
        return objeto;
    }

    public Especialidad traer(String nombre) {
        Especialidad objeto = null;
        try {
            iniciaOperacion();

            objeto = (Especialidad) session.createQuery("from Especialidad e where e.nombre = :nombre").setParameter("nombre", nombre).uniqueResult();
        } finally {
            session.close();
        }
        return objeto;
    }

}
