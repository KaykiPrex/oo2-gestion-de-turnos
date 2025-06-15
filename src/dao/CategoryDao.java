package dao;

import datos.refactor.Category;
import datos.refactor.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CategoryDao {

    public int agregar(Category objeto) {
        Transaction tx = null;
        int id = 0;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            id = (int) session.save(objeto);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) tx.rollback();
            throw new HibernateException("Error al agregar Categoria", he);
        }
        return id;
    }

    public Category traer(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Category.class, id);
        } catch (HibernateException he) {
            throw new HibernateException("Error al obtener Categoria", he);
        }
    }

    public List<Category> traerTodas() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Category", Category.class).list();
        } catch (HibernateException he) {
            throw new HibernateException("Error al obtener todas las Categorías", he);
        }
    }

    public void actualizar(Category objeto) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(objeto);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) tx.rollback();
            throw new HibernateException("Error al actualizar Categoria", he);
        }
    }

    public void eliminar(Category objeto) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.delete(objeto);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) tx.rollback();
            throw new HibernateException("Error al eliminar Categoria", he);
        }
    }

    public Category traerCategoriaYEspecialidades(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Category c JOIN FETCH c.specialties WHERE c.id = :id", Category.class)
                    .setParameter("id", id)
                    .uniqueResult();
        } catch (HibernateException he) {
            throw new HibernateException("Error al obtener Categoria", he);
        }
    }
}
