package dao;

import datos.refactor.ProfessionalService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProfessionalServiceDao {

    public int agregar(ProfessionalService objeto) {
        Transaction tx = null;
        int id = 0;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            id = (int) session.save(objeto);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) tx.rollback();
            throw new HibernateException("Error al agregar Servicio del profesional", he);
        }
        return id;
    }

    public ProfessionalService traer(long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(ProfessionalService.class, id);
        } catch (HibernateException he) {
            throw new HibernateException("Error al obtener Servicio del profesional", he);
        }
    }

    public void actualizar(ProfessionalService objeto) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(objeto);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) tx.rollback();
            throw new HibernateException("Error al actualizar Servicio del profesional", he);
        }
    }

    public void eliminar(ProfessionalService objeto) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.delete(objeto);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) tx.rollback();
            throw new HibernateException("Error al eliminar Servicio del profesional", he);
        }
    }
}
