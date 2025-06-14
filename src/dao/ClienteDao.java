package dao;

import datos.Cliente;
import datos.Turno;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClienteDao {
    private static Session session;
    private Transaction tx;
    private static ClienteDao instancia = null;
    
    protected ClienteDao() {
    }
    
    public static ClienteDao getInstance() {
    	if(instancia == null)
    		instancia = new ClienteDao();
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

    public long agregar(Cliente objeto) {
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

    public void actualizar(Cliente objeto) {
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

    public void eliminar(Cliente objeto) {
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

    public Cliente traer(long id) {
        Cliente objeto = null;
        try {
            iniciaOperacion();
            objeto = (Cliente) session.get(Cliente.class, id);
            Hibernate.initialize(objeto.getTurnos());
        } finally {
            session.close();
        }
        return objeto;
    }
    
    public Cliente traer(String nombre) {
		Cliente objeto = null;
		try {
			iniciaOperacion();
			objeto = (Cliente) session.createQuery("from Cliente c where c.nombre = :nombre")
					.setParameter("nombre", nombre)
					.uniqueResult();
			Hibernate.initialize(objeto.getTurnos());
		} finally {
			session.close();
		}
		return objeto;
	}

  /*  public void pedirTurno(Cliente cliente, Turno turno) {

        iniciaOperacion();
        cliente.getTurnos().add(turno);
        session.update(cliente);
        session.getTransaction().commit();

    }
*/
    public Turno traerTurno(int idCliente, int idTurno) {
        Turno turno = null;
        try {
            iniciaOperacion();
            String hql = "from Turno t where t.cliente.id = :idCliente and t.id = :idTurno";
            turno = (Turno) session.createQuery(hql)
                    .setParameter("idCliente", idCliente)
                    .setParameter("idTurno", idTurno)
                    .uniqueResult();
        } finally {
            session.close();
        }
        return turno;
    }
    
    public void cancelarTurno(Turno turno){
    	try {
    		iniciaOperacion();
    		Turno turnoSession = (Turno) session.get(Turno.class, turno.getId());
            Cliente cliente = turnoSession.getCliente();
            if (cliente != null) {
            	Hibernate.initialize(cliente.getTurnos());
                cliente.getTurnos().remove(turnoSession);
                session.update(cliente);
            }
            session.delete(turnoSession);
            tx.commit();
    	} catch (HibernateException he) {
    		manejaExcepcion(he);
    	} finally {
    		session.close();
    	}
    }
}
