package negocio;

import dao.PersonaDao;
import datos.Contacto;
import datos.Persona;

import java.util.List;

public class PersonaABM {
    private static PersonaABM instancia = null;

    protected PersonaABM() {
    }

    public static PersonaABM getInstance() {
        if (instancia == null)
            instancia = new PersonaABM();
        return instancia;
    }

    public Persona traer(long idPersona) {
        return PersonaDao.getInstance().traer(idPersona);
    }

    public Persona traerProfesional(long idProfesional) {
        return PersonaDao.getInstance().traerProfesionalDisponibilidadesYEspecialidad(idProfesional);
    }

    public List<Persona> traer() {
        return PersonaDao.getInstance().traer();
    }
    
    // ** Método genérico para registrar una Persona (Cliente o Profesional) **
    public long registrar(Persona objeto) throws Exception {
    	if(objeto == null) {
    		throw new Exception("El objeto Persona no puede ser nulo");
    	}
    	if(objeto.getNombre() == null || objeto.getNombre().isEmpty()) {
    		throw new Exception("El nombre de la persona no puede ser nulo o vacío");
    	}
    	if(objeto.getContrasena() == null || objeto.getContrasena().isEmpty()) {
			throw new Exception("La contraseña de la persona no puede ser nula o vacía");
		}
    	if(PersonaDao.getInstance().traer(objeto.getNombre()) != null) {
    		throw new Exception("Ya existe una persona con el nombre: " + objeto.getNombre());
    	}
    	return PersonaDao.getInstance().registrarPersona(objeto);
    }

    // ** Inicio de Sesión (Cliente o Profesional) **
    public Persona login(String nombre, String contrasena) throws Exception {
        Persona p = PersonaDao.getInstance().traer(nombre, contrasena);
        if (p == null) {
            throw new Exception("No existe el usuario o la contraseña es incorrecta");
        }
        return p;
    }
    
    // ** Agregar o actualizar el Contacto de una Persona (Cliente o Profesional) **
    public void agregarContacto(Persona persona, Contacto contacto) throws Exception {
    	if(persona == null) {
    		throw new Exception("La persona no existe");
    	}
    	persona.setContacto(contacto);
    	contacto.setPersona(persona);
    	PersonaDao.getInstance().actualizar(persona);
    }    

    // ** Eliminar Usuario **
    public void eliminar(long idPersona) throws Exception {
        Persona p = PersonaDao.getInstance().traer(idPersona);
        if (p == null) {
            throw new Exception("No existe el usuario con ID:" + idPersona);
        }
        PersonaDao.getInstance().eliminar(p);
    }

}
