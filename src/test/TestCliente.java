package test;

import datos.*;
import dao.ClienteDao;

import java.time.LocalDateTime;


public class TestCliente {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("nico", "123",new Contacto("aaa", "1111", "111", new Persona(null, null, null)));
        cliente.setNombre("Jose");
        cliente.mostrarCliente();
        ClienteDao clienteDao = new ClienteDao();
        clienteDao.pedirTurno(cliente, new Turno(LocalDateTime.of(2025, 5, 9, 15, 30),cliente, new Profesional(null, null, null), new Servicio("si", "no", "2 meses", 2.0)));
        System.out.println( cliente.traerHistorialTurnos());
    }
}
