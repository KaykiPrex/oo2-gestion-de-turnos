package dao;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.Cliente;
import datos.Persona;
import datos.Profesional;
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
    
    public List<Turno> traerPosteriores(Cliente cliente) {
    	List<Turno> turnos = null;
    	try {
    		iniciaOperacion();
    		LocalDateTime ahora = LocalDateTime.now();
    		Query<Turno> query = session.createQuery(
    				"from Turno t " +
    				"where t.cliente = :cliente " +
    				"and t.fechaHora > :ahora " +
    				"order by t.fechaHora asc"
    				, Turno.class
    		);
    		query.setParameter("cliente", cliente);
    		query.setParameter("ahora", ahora);
    		turnos = query.list();
    	} finally {
    		session.close();
    	}
    	return turnos;
    }
    
    public Turno traerPorFechaHora(LocalDateTime fechaHora, Persona persona) {
    	Turno turno = null;
    	try {
    		iniciaOperacion();
    		Query<Turno> query = null;
    		if (persona instanceof Cliente) {
    			query = session.createQuery (
    					"from Turno t where t.fechaHora = :fechaHora " +
    					"and t.cliente = :persona", Turno.class
    			);
    		} else if (persona instanceof Profesional) {
    			query = session.createQuery (
						"from Turno t where t.fechaHora = :fechaHora " +
						"and t.profesional = :persona", Turno.class
				);
			} else {
				throw new IllegalArgumentException("Tipo de persona no soportado");
			}
    		query.setParameter("fechaHora", fechaHora);
			query.setParameter("persona", persona);
			turno = query.uniqueResult();
    	} finally {
    		session.close();
    	}
    	return turno;
    }
    
}
