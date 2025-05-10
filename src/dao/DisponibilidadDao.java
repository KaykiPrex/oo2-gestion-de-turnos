package dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.Disponibilidad;
import datos.Profesional;

public class DisponibilidadDao {

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
	
	public long agregar(Disponibilidad objeto) {
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
	
	public void actualizar(Disponibilidad objeto) {
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
	
	public void eliminar(Disponibilidad objeto) {
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
	
	public Disponibilidad traer(long id) {
		Disponibilidad objeto = null;
		try {
			iniciaOperacion();
			objeto = (Disponibilidad) session.get(Disponibilidad.class, id);
		} finally{
			session.close();
		}
		return objeto;
	}
	
	public Set<Disponibilidad> traer(Profesional p){
		Set<Disponibilidad> lista = new HashSet<Disponibilidad>();
			try {
				iniciaOperacion();
				Query<Disponibilidad> query = session.createQuery("from Disponibilidad d where d.profesional.id = :id", Disponibilidad.class).setParameter("id", p.getId());
				lista.addAll(query.getResultList());
			}finally {
				session.close();
			}
		return lista;
	}
}
