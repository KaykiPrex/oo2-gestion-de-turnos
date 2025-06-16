package test;

import datos.refactor.Contact;
import datos.refactor.User;
import negocio.UserABM;

public class F_ModificarPerfil {
    public static void main(String[] args) {
        //A continuacion vamos a setear algunos datos del contacto del usuario 1
        UserABM userABM= new UserABM();

        System.out.println("Contacto viejo-----");
        System.out.println( userABM.traer(1));

        System.out.println("Contacto modificado-----");
        User user = userABM.traerUserContacto(1);

        Contact userContact=  user.getContact();
        userContact.setMobile("1170263046");
        userContact.setWorkEmail("irreranicolas8@gmail.com");
        userContact.setPersonalEmail("platopool69@gmail.com");

        //una vez finalizados los cambios llamamos a setContact para modificar el contacto
        user.setContact(userContact);

        //userABM.modificar(user) para que los cambios impacten en la base de datos
        userABM.modificar(user);
        System.out.println(userABM.traer(1));
    }

}
