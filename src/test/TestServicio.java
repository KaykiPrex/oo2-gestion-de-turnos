package test;

import dao.ServicioDao;
import datos.Servicio;
import negocio.ServicioABM;

public class TestServicio {

    public static void main(String[] args) {

       ServicioABM abm = new ServicioABM();
       Servicio servicio= new Servicio("hola", "si", "20 años ", 12237489.0);

       try {
           abm.agregar(new Servicio("Juan", "Lavado de Auto", "2 minutos", 2.0));
       } catch (Exception e) {
           e.getMessage();
       }

    }

}
