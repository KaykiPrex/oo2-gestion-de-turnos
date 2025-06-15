package negocio;

import dao.CategoryDao;
import datos.refactor.Category;

import java.util.List;

public class CategoryABM {
    CategoryDao dao = new CategoryDao();

    public int agregar(Category c) {
        return dao.agregar(c);
    }

    public void modificar(Category c) {
        dao.actualizar(c);
    }

    public void eliminar(int id) {
        Category c = dao.traer(id);
        dao.eliminar(c);
    }

    public Category traer(int id){
        return dao.traer(id);
    }

    public List<Category> traerTodas(){
        return dao.traerTodas();
    }

    public Category traerCategoriaYEspecialidades(int id) {
        return dao.traerCategoriaYEspecialidades(id);
    }
}
