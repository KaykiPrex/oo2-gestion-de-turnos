package test;

import datos.refactor.Appointment;
import negocio.AppoinmentABM;
import negocio.UserABM;

public class D_TestLogin {

    public static void main(String[] args) {
        //login si el usuario y contrasena son correctos
        System.out.println("-------login correcto-------");
        UserABM userABM= new UserABM();
        String micliente="micliente";
        String mipass="1234";
        userABM.login(micliente, mipass);

        //Caso de uso si no anda el login(usuario o contraseña incorrectas)
        System.out.println("-------login incorrecto-------");
       if(userABM.login(micliente, "uwu")) {
           System.out.println("Login success");
       }else {
           System.out.println("Usuario o contrasenas incorrectos");
       }
       // luego de loguearme con este usuario procedemos al paso E


    }

}
