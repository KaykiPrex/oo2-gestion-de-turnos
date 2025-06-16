package test;

import datos.refactor.*;
import negocio.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;

public class B_TestSolicitarTurno {
    public static void main(String[] args) {

        // Carga de datos * * *
        CategoryABM categoryABM = new CategoryABM();
        int categoryMedicinaId = categoryABM.agregar(new Category("medicina"));
        categoryABM.agregar(new Category("abogacia"));
        Category categoryMedicina = categoryABM.traer(categoryMedicinaId);

        SpecialtyABM specialtyABM = new SpecialtyABM();
        int specialtyClinicaId = specialtyABM.agregar(new Specialty("clinica general","atencion clinica general",categoryMedicina));
        specialtyABM.agregar(new Specialty("clinica traumatologia","atencion traumatologia general",categoryMedicina));
        Specialty specialtyClinica = specialtyABM.traer(specialtyClinicaId);

        ServiceABM serviceABM = new ServiceABM();
        serviceABM.agregar(new Service("atencion adultos","atencion mayores de edad","no aplica",specialtyClinica));
        int servicePediatriaId = serviceABM.agregar(new Service("atencion pediatria","atencion menores de edad","no aplica",specialtyClinica));
        Service servicePedriatia = serviceABM.traer(servicePediatriaId);

        UserABM abmUserProfessional = new UserABM();
        Professional newProfessional = new Professional("nuevoprofesional","4567",null,"juan","perez","50123456");
        Contact newContactProfessional = new Contact("juan.perez@gmail.com","juanchi@gmail.com","1550004545","43201010",newProfessional);
        newProfessional.setContact(newContactProfessional);
        int userProfessionalId = abmUserProfessional.agregar(newProfessional);
        Professional userProfessional = (Professional) abmUserProfessional.traer(userProfessionalId);

        ProfessionalServiceABM professionalServiceABM = new ProfessionalServiceABM();
        int professionalServiceId = professionalServiceABM.agregar(new ProfessionalService(new BigDecimal("0.0"),userProfessional,servicePedriatia));
        ProfessionalService professionalService = professionalServiceABM.traer(professionalServiceId);

        AppoinmentABM appoinmentABM = new AppoinmentABM();
        int appointmenId = appoinmentABM.agregar(new Appointment(LocalDate.of(2025,7,1), LocalTime.of(10,0), professionalService)  );
        appoinmentABM.agregar(new Appointment(LocalDate.of(2025,7,1), LocalTime.of(10,30), professionalService)  );
        appoinmentABM.agregar(new Appointment(LocalDate.of(2025,7,1), LocalTime.of(11,0), professionalService)  );
        appoinmentABM.agregar(new Appointment(LocalDate.of(2025,7,1), LocalTime.of(11,30), professionalService)  );

        //  * * *

        // Solicitar turno
        System.out.println("========================= Solicitar Turno =========================");
        //Mostramos todas las categorias disponibles
        List<Category> listarCategorias = categoryABM.traerTodas();
        System.out.println("Categorias Disponibles");
        System.out.println(listarCategorias);
        final int opcionDeListaElegida = 0;
        Category categoriaElegida = listarCategorias.get(opcionDeListaElegida);
        System.out.println("Categoria elegida " + categoriaElegida);

        //Mostramos todas las especialidades disponibles
        System.out.println("Especialidades Disponibles");
        Category categoriaYEspecialidades = categoryABM.traerCategoriaYEspecialidades(categoriaElegida.getId());
        System.out.println(categoriaYEspecialidades.getSpecialties());
        final int especialidadElegidaId = 1;
        Specialty specialtyElegida = categoriaYEspecialidades.getSpecialties().stream()
                .filter(s -> s.getId() == especialidadElegidaId)
                .findFirst()
                .orElse(null);
        System.out.println("Especialidad elegida " + specialtyElegida);

        //Mostramos todas los servicios disponibles
        System.out.println("Servicios Disponibles");
        Specialty especialidadYServicios = specialtyABM.traerEspecialidadYServicios(specialtyElegida.getId());
        System.out.println(especialidadYServicios.getServices());
        final int servicioElegidoId = 2;
        Service servicioElegido = especialidadYServicios.getServices().stream()
                .filter(s -> s.getId() == servicioElegidoId)
                .findFirst()
                .orElse(null);
        System.out.println("Servicio elegido " + servicioElegido);

        //Mostramos todos los profesionales disponibles
        System.out.println("Profesionales Disponibles");
        Service serviceYProfessional = serviceABM.traerServicioDeProfesional(servicioElegido.getId());
        for (ProfessionalService ps : serviceYProfessional.getProfessionalServices()) {
            System.out.println("Profesional nombre: " + ps.getProfessional().getName());
        }
        final int profesionalServicioElegido = 1;
        ProfessionalService professionalServiceElegida = professionalServiceABM.traerProfesionalServicioYTurno(profesionalServicioElegido);

        //Mostramos todos los horarios disponibles
        System.out.println("Horarios Disponibles");
        List<Appointment> ordenAppointments = professionalServiceElegida.getAppointments().stream()
                .sorted(Comparator.comparing(Appointment::getDate).thenComparing(Appointment::getTime))
                .toList();
        System.out.println(ordenAppointments);

        //Consideramos el cliente logueado
        int turnoSolicitadoId = 1;
        int clienteLogueadoId = 1;
        UserABM abmUser = new UserABM();
        Client userClient = (Client) abmUser.traer(clienteLogueadoId);
        Appointment appointment = appoinmentABM.traer(turnoSolicitadoId);
        System.out.println("Solicitamos turno : " + appointment);

        appointment.setClient(userClient);
        appointment.setIsBlocked(true);
        appoinmentABM.modificar(appointment);
        System.out.println("Turno Solicitado");

        System.out.println("========================= FIN Solicitar Turno =========================");

    }
}
