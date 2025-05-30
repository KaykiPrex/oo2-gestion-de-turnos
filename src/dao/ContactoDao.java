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

    // ** Método para agregar un Contacto **
    public int agregar(Contacto objeto) {
        int id = 0;
        try {
            iniciaOperacion();
            id = Integer.parseInt(session.save(objeto).toString());
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
        return id;
    }

    // ** Método para traer un Contacto **
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

    // ** Método para actualizar un Contacto **
    public void actualizar(Contacto objeto) {
        try {
            iniciaOperacion();
            session.update(objeto);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
    }

    // ** Método para eliminar un Contacto **
    public void eliminar(Contacto objeto) {
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
