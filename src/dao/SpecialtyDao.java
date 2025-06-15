package dao;

import datos.refactor.Category;
import datos.refactor.Specialty;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SpecialtyDao {

    public int agregar(Specialty objeto) {
        Transaction tx = null;
        int id = 0;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            id = (int) session.save(objeto);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) tx.rollback();
            throw new HibernateException("Error al agregar Especialidad", he);
        }
        return id;
    }

    public Specialty traer(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Specialty.class, id);
        } catch (HibernateException he) {
            throw new HibernateException("Error al obtener Especialidad", he);
        }
    }

    public void actualizar(Specialty objeto) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(objeto);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) tx.rollback();
            throw new HibernateException("Error al actualizar Especialidad", he);
        }
    }

    public void eliminar(Specialty objeto) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.delete(objeto);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) tx.rollback();
            throw new HibernateException("Error al eliminar Especialidad", he);
        }
    }

    public Specialty traerEspecialidadYServicios(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Specialty s JOIN FETCH s.services WHERE s.id = :id", Specialty.class)
                    .setParameter("id", id)
                    .uniqueResult();
        } catch (HibernateException he) {
            throw new HibernateException("Error al obtener Categoria", he);
        }
    }
}
