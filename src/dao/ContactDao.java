package dao;

import datos.refactor.Contact;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ContactDao {

    public int agregar(Contact objeto) {
        Transaction tx = null;
        int id = 0;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            id = (int) session.save(objeto);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) tx.rollback();
            throw new HibernateException("Error al agregar Contacto", he);
        }
        return id;
    }

    public Contact traer(int idContact) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Contact.class, idContact);
        } catch (HibernateException he) {
            throw new HibernateException("Error al obtener Contacto", he);
        }
    }

    public void actualizar(Contact objeto) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(objeto);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) tx.rollback();
            throw new HibernateException("Error al actualizar Contacto", he);
        }
    }

    public void eliminar(Contact objeto) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.delete(objeto);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) tx.rollback();
            throw new HibernateException("Error al eliminar Contacto", he);
        }
    }
}
