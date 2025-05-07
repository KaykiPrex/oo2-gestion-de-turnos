package dao;

import datos.Disponibilidad;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DisponibilidadDao {
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

    public Disponibilidad traer(long idDisponibilidad) {
        Disponibilidad objeto = null;
        try {
            iniciaOperacion();
            objeto = (Disponibilidad) session.get(Disponibilidad.class, idDisponibilidad);
        } finally {
            session.close();
        }
        return objeto;
    }
}
