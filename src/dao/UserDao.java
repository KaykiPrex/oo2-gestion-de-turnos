package dao;

import datos.refactor.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDao {
    public int agregar(User objeto) {
        Transaction tx = null;
        int id = 0;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            id = (int) session.save(objeto);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) tx.rollback();
            throw new HibernateException("Error al agregar usuario", he);
        }
        return id;
    }


    public User traer(int idUser) {
        User objeto = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            objeto = session.createQuery("from User u where u.id=:id", User.class)
                    .setParameter("id", idUser).uniqueResult();
            return objeto;
        } catch (HibernateException he) {
            throw new HibernateException("Error al obtener User", he);
        }
    }


    public User traerUserContacto(int idUser) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM User u JOIN FETCH u.contact WHERE u.id = :id", User.class)
                    .setParameter("id", idUser)
                    .uniqueResult();
        } catch (HibernateException he) {
            throw new HibernateException("Error al obtener usuario", he);
        }
    }

    public void actualizar(User objeto) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(objeto);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) tx.rollback();
            throw new HibernateException("Error al actualizar usuario", he);
        }
    }

    public void eliminar(User objeto) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.delete(objeto);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) tx.rollback();
            throw new HibernateException("Error al eliminar usuario", he);
        }
    }
    public User login(String nombre, String contrasena) {

        User objeto = null;
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();

        try{
            tx.commit();
            String hql = "from User u where u.name = :nombre and u.password = :contrasena";
            objeto = (User) session.createQuery(hql)
                    .setParameter("nombre", nombre)
                    .setParameter("contrasena", contrasena)
                    .uniqueResult();
        }   catch (HibernateException he) {
            if (tx != null) tx.rollback();
        } finally {
            session.close();
        }
        return objeto;
    }
}
