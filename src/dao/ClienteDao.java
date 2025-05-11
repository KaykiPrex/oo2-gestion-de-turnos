package dao;

import datos.Cliente;
import datos.Turno;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClienteDao {
    private static Session session;
    private Transaction tx;

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
        } finally {
            session.close();
        }
        return objeto;
    }

    public void pedirTurno(Cliente cliente, Turno turno) {

        iniciaOperacion();
        cliente.traerHistorialTurnos().add(turno);
        session.update(cliente);
        session.getTransaction().commit();

    }


    public void cancelarTurno(Turno turno) throws HibernateException {
        try {
            iniciaOperacion();
            Turno turnoaux = (Turno) session.get(Turno.class, turno.getId());
            if (turno == null) {
                throw new RuntimeException("Turno no encontrado");
            }

            Cliente cliente = turno.getCliente();
            if (cliente != null) {
                cliente.traerHistorialTurnos().remove(turno);// se lo borra al cliente
                session.update(cliente);

            }
            session.delete(turno);// lo borra de la db
            session.getTransaction().commit();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        }

    }

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
}
