package dao;

import datos.Cliente;
import datos.Turno;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import static dao.HibernateUtil.getSessionFactory;
import static dao.HibernateUtil.sessionFactory;

public class ClienteDao {
    private static Session session;
    private Transaction tx;

    private void iniciaOperacion() throws RuntimeException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Error", he);
    }

    public void pedirTurno(Cliente cliente ,Turno turno) {

        iniciaOperacion();
        cliente.traerHistorialTurnos().add(turno);
        session.update(cliente);
        session.getTransaction().commit();

    }


    public void cancelarTurno(Turno turno) throws HibernateException  {
        try {
            iniciaOperacion();
            Turno turnoaux = (Turno) session.get(Turno.class, turno.getId());
            if (turno == null) {
                throw new RuntimeException("Turno no encontrado");
            }

        Cliente cliente= turno.getCliente();
        if(cliente!=null) {
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
