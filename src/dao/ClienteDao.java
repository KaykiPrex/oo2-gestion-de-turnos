package dao;

import datos.Cliente;
import datos.Turno;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;


public class ClienteDao {
    private static Session session;
    private Transaction tx;


    private void iniciaOperacion() throws HibernateException {
        session= HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction() ;
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("ERROR en la capa de acceso a datos", he);
    }

    public long agregar(Cliente objeto) {
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

    public void actualizar(Cliente objeto) {
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

    public void eliminar(Cliente objeto) {
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

    public Cliente traer(long id) {
        Cliente objeto = null;
        try {
            iniciaOperacion();
            objeto = (Cliente) session.get(Cliente.class, id);
        } finally {
            session.close();
        }
        return objeto;
    }
    public void pedirTurno(Cliente cliente, Turno turno) {
        iniciaOperacion();

        if (!session.contains(cliente)) {
            session.saveOrUpdate(cliente);
        }
        session.flush();
        Cliente clientePersistido = session.get(Cliente.class, cliente.getIdpersona());
        if (clientePersistido == null) {
            System.out.println("Cliente no encontrado en la BD. ID: " + cliente.getIdpersona());
        }
        session.flush();

        try {
            session.save(turno);

            cliente.getTurnos().add(turno);
            session.save(cliente);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }
    public void cancelarTurno(Turno turno) throws HibernateException {
        iniciaOperacion();
        Cliente cliente = turno.getCliente();
        try {

            if (cliente != null) {
                cliente.getTurnos().remove(turno);
                session.delete(turno);
                tx.commit();
            }
        } catch (HibernateException e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            manejaExcepcion(e);
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }
    public Turno traerTurno(int idCliente, int idTurno) {
        Turno turno = null;
        try {
            iniciaOperacion();
            String hql = "from Turno t where t.cliente.id = :idCliente and t.id = :idTurno";
            turno = (Turno) session.createQuery(hql)
                    .setParameter("idCliente", idCliente)
                    .setParameter("idTurno", idTurno)
                    .uniqueResult();
        } finally {
            session.close();
        }
        return turno;
    }
    public List<Turno> obtenerHistorialTurnos(Cliente cliente) {
        List<Turno> historialTurnos = new ArrayList<>();
        iniciaOperacion();

        if (cliente.getIdpersona() ==0) {
            session.save(cliente);
        }


        try {
            historialTurnos = session.createQuery(
                            "FROM Turno t WHERE t.cliente = :cliente ORDER BY t.fechaHora", Turno.class)
                    .setParameter("cliente", cliente)
                    .getResultList();

            tx.commit();
        } catch (HibernateException e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }

        return historialTurnos;
    }
}
