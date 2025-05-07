package dao;

import datos.Especialidad;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EspecialidadDao {
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

}
