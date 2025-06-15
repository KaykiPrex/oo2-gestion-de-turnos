package dao;

import datos.refactor.ProfessionalSpecialty;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProfessionalSpecialtyDao {

    public int agregar(ProfessionalSpecialty objeto) {
        Transaction tx = null;
        int id = 0;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            id = (int) session.save(objeto);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) tx.rollback();
            throw new HibernateException("Error al agregar Especialidad del profesional", he);
        }
        return id;
    }

    public ProfessionalSpecialty traer(long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(ProfessionalSpecialty.class, id);
        } catch (HibernateException he) {
            throw new HibernateException("Error al obtener Especialidad del profesional", he);
        }
    }

    public void actualizar(ProfessionalSpecialty objeto) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(objeto);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) tx.rollback();
            throw new HibernateException("Error al actualizar Especialidad del profesional", he);
        }
    }

    public void eliminar(ProfessionalSpecialty objeto) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.delete(objeto);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) tx.rollback();
            throw new HibernateException("Error al eliminar Especialidad del profesional", he);
        }
    }
}
