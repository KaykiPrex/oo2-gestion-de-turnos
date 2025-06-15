package dao;

import datos.refactor.Category;
import datos.refactor.Service;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ServiceDao {

    public int agregar(Service objeto) {
        Transaction tx = null;
        int id = 0;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            id = (int) session.save(objeto);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) tx.rollback();
            throw new HibernateException("Error al agregar Servicio", he);
        }
        return id;
    }

    public Service traer(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Service.class, id);
        } catch (HibernateException he) {
            throw new HibernateException("Error al obtener Servicio", he);
        }
    }

    public void actualizar(Service objeto) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(objeto);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) tx.rollback();
            throw new HibernateException("Error al actualizar Servicio", he);
        }
    }

    public void eliminar(Service objeto) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.delete(objeto);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) tx.rollback();
            throw new HibernateException("Error al eliminar Servicio", he);
        }
    }

    public Service traerServiciosDeProfesional(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Service s JOIN FETCH s.professionalServices ps JOIN FETCH ps.professional WHERE s.id = :id", Service.class)
                    .setParameter("id", id)
                    .uniqueResult();
        } catch (HibernateException he) {
            throw new HibernateException("Error al obtener Categoria", he);
        }
    }
}
