package dao;

import datos.Especialidad;
import datos.Servicio;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.*;


public class ServicioDao {

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
    public long agregar(Servicio objeto) {
        long id = 0;
        try {
            iniciaOperacion();
            id = Integer.parseInt(session.save(objeto).toString());
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
        return id;
    }

public void actualizar(Servicio objeto) {
    try {
        iniciaOperacion();
        session.update(objeto);
        tx.commit();
    } catch (HibernateException he) {
        manejaExcepcion(he);
    } finally {
        session.close();
    }
}

public void eliminar(Servicio objeto) {
    try {
        iniciaOperacion();
        session.delete(objeto);
        tx.commit();
    } catch (HibernateException he) {
        manejaExcepcion(he);
    } finally {
        session.close();
    }
}

public Servicio traer(long idEspecialidad) {
    Servicio objeto = null;
    try {
        iniciaOperacion();
        objeto = (Servicio) session.get(Servicio.class, idEspecialidad);
    } finally {
        session.close();
    }
    return objeto;
}

public Servicio traer(String nombre) {
    Servicio objeto = null;
    try {
        iniciaOperacion();
        String hql = "from Servicio s where s.nombre = :nombre";
        objeto = (Servicio) session.createQuery(hql)
                .setParameter("nombre", nombre)
                .uniqueResult();
    } finally {
        session.close();
    }
    return objeto;
}

}
