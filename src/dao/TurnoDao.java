package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Turno;

public class TurnoDao {
    private static Session session;
    private Transaction tx;
    private static TurnoDao instancia = null;
    
    protected TurnoDao() {
    }
    
    public static TurnoDao getInstance() {
    	if(instancia == null)
    		instancia = new TurnoDao();
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

    public long agregar(Turno objeto) {
        long id = 0;
        try {
            iniciaOperacion();
            id = Long.parseLong(session.save(objeto).toString());
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
        return id;
    }

    public void actualizar(Turno objeto) {
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

    public void eliminar(Turno objeto) {
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

    public Turno traer(long id) {
        Turno objeto = null;
        try {
            iniciaOperacion();
            objeto = (Turno) session.get(Turno.class, id);
            if (objeto != null) {
				Hibernate.initialize(objeto.getProfesional().getDisponibilidades());
			}
        } finally {
            session.close();
        }
        return objeto;
    }

    public void eliminarTurno(Turno objeto) {
        try {
            iniciaOperacion();
            session.delete(objeto);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
    }
}
