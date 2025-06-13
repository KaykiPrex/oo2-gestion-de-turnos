package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Disponibilidad;
import datos.Especialidad;
import datos.Profesional;

public class ProfesionalDao {
	
	private static Session session;
	private Transaction tx;
	
	private void iniciaOperacion() throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException{
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	public long agregar(Profesional objeto) {
		long id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
		} catch(HibernateException he){
			manejaExcepcion(he);
		}finally {
			session.close();
		}
		return id;
	}
	
	public void actualizar(Profesional objeto) {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		}catch(HibernateException he) {
			manejaExcepcion(he);
		}finally {
			session.close();
		}
	}
	
	public void eliminar(Profesional objeto) {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		}catch(HibernateException he){
			manejaExcepcion(he);
		}finally {
			session.close();
		}
	}
	
	public Profesional traer(long id) {
		Profesional objeto = null;
		try {
			iniciaOperacion();
			objeto = (Profesional) session.get(Profesional.class, id);
		}finally {
			session.close();
		}
		return objeto;
	}
	
	public Profesional traer(String nombre) {
		Profesional objeto = null;
		try {
			iniciaOperacion();
		 String hql = "from Profesional p where p.nombre = :nombre";
			objeto = (Profesional) session.createQuery(hql).setParameter("nombre", nombre).uniqueResult();
		
			
		}finally {
			session.close();
		}
		return objeto;
	}

	public List<Profesional> traerPorEspecialidad(Especialidad e){
		List<Profesional> profesionales = new ArrayList<>();
		try {
			iniciaOperacion();
			profesionales = session.createQuery("from Profesional p where p.especialidad = :especialidad", Profesional.class).setParameter("especialidad", e).list();
		} finally {
			session.close();
		}
		return profesionales;
	}

	
}
