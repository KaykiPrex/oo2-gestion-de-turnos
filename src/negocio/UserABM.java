package negocio;

import dao.UserDao;
import datos.refactor.User;

public class UserABM {
    UserDao dao = new UserDao();

    public int agregar(User u) {
        return dao.agregar(u);
    }

    public void modificar(User u) {
        dao.actualizar(u);
    }

    public void eliminar(int id) {
        User u = dao.traerUserContacto(id);
        dao.eliminar(u);
    }

    public User traer(int id){
        return dao.traer(id);
    }

    public User traerUserContacto(int id){
        return dao.traerUserContacto(id);
    }
}
