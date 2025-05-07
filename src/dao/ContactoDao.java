package dao;

import datos.Contacto;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ContactoDao {
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

    public Contacto traer(long idContacto) {
        Contacto objeto = null;
        try {
            iniciaOperacion();
            objeto = (Contacto) session.get(Contacto.class, idContacto);
        } finally {
            session.close();
        }
        return objeto;
    }

}
