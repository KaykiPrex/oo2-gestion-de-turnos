package test;

import negocio.UserABM;

public class E_MostrarPerfilUsuario {
    public static void main(String[] args) {
        //Mostrar perfil de usuario
        UserABM userABM= new UserABM();
        System.out.println(userABM.traer(1));
    }

}
