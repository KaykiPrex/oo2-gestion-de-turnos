package negocio;

import dao.AppointmentDao;
import datos.refactor.Appointment;

public class AppoinmentABM {
    AppointmentDao dao = new AppointmentDao();

    public int agregar(Appointment a) {
        return dao.agregar(a);
    }

    public void modificar(Appointment a) {
        dao.actualizar(a);
    }

    public void eliminar(int id) {
        Appointment a = dao.traer(id);
        dao.eliminar(a);
    }

    public Appointment traer(int id){
        return dao.traer(id);
    }
}
