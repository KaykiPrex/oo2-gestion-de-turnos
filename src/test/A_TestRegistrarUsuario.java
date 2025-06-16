package test;

import datos.refactor.*;
import negocio.UserABM;

import java.util.ArrayList;
import java.util.List;

public class A_TestRegistrarUsuario {

    public static void main(String[] args) {
        // Registro de Cliente
        System.out.println("========================= Registro de Cliente =========================");
        UserABM abmUser = new UserABM();
        List<Appointment> appointments = new ArrayList<>();
        System.out.println("Cargando datos ...");
        Client newClient = new Client("micliente","1234",null,"joanchito","gomez","50123456",appointments);
        Contact newContact = new Contact("alfredo.perez@gmail.com","sonic@gmail.com","1550001212","42908080",newClient);
        newClient.setContact(newContact);
        int userClientId = abmUser.agregar(newClient);
        Client userClient = (Client) abmUser.traer(userClientId);

        System.out.println("Cliente registrado");
        System.out.println(userClient);
        System.out.println("========================= FIN Registro de Cliente =========================");

        // Registro de Profesional
        System.out.println("========================= Registro de Profesional =========================");
        UserABM abmUserProfessional = new UserABM();
        System.out.println("Cargando datos ...");
        Professional newProfessional = new Professional("miprofesional","4567",null,"pablo","loma","50123456");
        Contact newContactProfessional = new Contact("pablo.loma@gmail.com","bros@gmail.com","1550004545","43201010",newProfessional);
        newProfessional.setContact(newContactProfessional);
        int userProfessionalId = abmUserProfessional.agregar(newProfessional);
        Professional userProfessional =(Professional) abmUserProfessional.traer(userProfessionalId);

        System.out.println("Profesional registrado");
        System.out.println(userProfessional);
        System.out.println("========================= FIN Registro de Profesional =========================");

    }
}
