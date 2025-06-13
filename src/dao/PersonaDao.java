package dao;

import datos.Persona;
import datos.Profesional;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PersonaDao {

    private static Session session;
    private Transaction tx;
    private static PersonaDao instancia = null;

    protected PersonaDao() {
    }

    public static PersonaDao getInstance() {
        if (instancia == null)
            instancia = new PersonaDao();
        return instancia;
    }

    protected void iniciaOperacion() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    protected void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("ERROR en la capa de acceso a datos", he);
    }

    // ** Método para registrar una Persona **
    public long registrarPersona(Persona objeto) {
        long id = 0;
        try {
            iniciaOperacion();
            id = Long.parseLong(session.save(objeto).toString());
            tx.commit();
        } catch(HibernateException he) {
            manejaExcepcion(he);
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
        } finally {
            session.close();
        }
    }

    // ** Método para traer una Persona (Posterior eliminar) **
    public Persona traer(long idPersona) {
        Persona objeto = null;
        try {
            iniciaOperacion();
            objeto = (Persona) session.createQuery("from Persona p where p.id=:idPersona")
                    .setParameter("idPersona", idPersona).uniqueResult();
        } finally {
            session.close();
        }
        return objeto;
    }

    public Profesional traerProfesionalDisponibilidadesYEspecialidad(long idProfesional) throws HibernateException {
        Profesional objeto = null;
        try {
            iniciaOperacion();
            String hql = "from Persona p where p.id=:idPersona";
            objeto = (Profesional) session.createQuery(hql).setParameter("idPersona", idProfesional).uniqueResult();
            Hibernate.initialize(objeto.getDisponibilidades());
            Hibernate.initialize(objeto.getEspecialidad());
        } finally {
            session.close();
        }
        return objeto;
    }

    // ** Método para traer una Persona  **
    public Persona traer(String nombre, String contrasena) {
        Persona objeto = null;
        try {
            iniciaOperacion();
            String hql = "from Persona p where p.nombre = :nombre and p.contrasena = :contrasena";
            objeto = (Persona) session.createQuery(hql)
                    .setParameter("nombre", nombre)
                    .setParameter("contrasena", contrasena)
                    .uniqueResult();
        } catch (HibernateException he) {
        	manejaExcepcion(he);
    	} finally {
            session.close();
        }
        return objeto;
    }

    public List<Profesional> traerTodosLosProfesionales() throws HibernateException {
        List<Profesional> lista = null;
        try {
            iniciaOperacion();
            String hql = "FROM Profesional";
            lista = session.createQuery(hql, Profesional.class).list();
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
        return lista;
    }

    public List<Persona> traer() throws HibernateException {
        List<Persona> lista = null;
        try {
            iniciaOperacion();
            lista = session.createQuery("from Persona", Persona.class).list();
        } finally {
            session.close();
        }
        return lista;
    }

    public void eliminar(Persona objeto) {
        try {
            iniciaOperacion();
            session.delete(objeto);
            tx.commit();
        } catch(HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
    }

}
