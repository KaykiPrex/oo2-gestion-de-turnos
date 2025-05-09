package dao;

import datos.Persona;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PersonaDao {

    private static Session session;
    private Transaction tx;

    private void iniciaOperacion() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Error en la capa de acceso a datos", he);
    }

    // ** Método para agregar una Persona **
    public int agregar(Persona objeto) {
        int id = 0;
        try {
            iniciaOperacion();
            id = Integer.parseInt(session.save(objeto).toString());
            tx.commit();
        } catch(HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
        return id;
    }

    // ** Método para actualizar una Persona **
    public void actualizar(Persona objeto) {
        try {
            iniciaOperacion();
            session.update(objeto);
            tx.commit();
        } catch(HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
    }

    // ** Método para traer una Persona (Posterior eliminar) **
    public Persona traer(long idPersona) {
        Persona objeto = null;
        try {
            iniciaOperacion();
            objeto = (Persona)session.get(Persona.class, idPersona);
        } finally {
            session.close();
        }
        return objeto;
    }

    // ** Método para traer una Persona (Posterior Login) **
    public Persona traer(String nombre, String contrasena) {
        Persona objeto = null;
        try {
            iniciaOperacion();
            String hql = "from Persona p where p.nombre = :nombre and p.contrasena = :contrasena";
            objeto = (Persona) session.createQuery(hql)
                    .setParameter("nombre", nombre)
                    .setParameter("contrasena", contrasena)
                    .uniqueResult();
        } finally {
            session.close();
        }
        return objeto;
    }

    // ** Método para eliminar una Persona **
    public void eliminar(Persona objeto) {
        try {
            iniciaOperacion();
            session.delete(objeto);
            tx.commit();
        } catch(HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
    }

}
