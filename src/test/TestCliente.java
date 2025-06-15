package test;

import datos.*;
import dao.ClienteDao;

import java.time.LocalDateTime;
import java.time.Month;

import java.util.List;



public class TestCliente {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("nico", "123",new Contacto("aaa", "1111", "111", new Persona(null, null, null)));
        System.out.println(cliente);
        ClienteDao clienteDao = new ClienteDao();
        Turno turno= new Turno(LocalDateTime.of(2025, Month.JUNE, 20, 14, 30),cliente,null, null);
        Turno turno2= new Turno(LocalDateTime.of(2025, Month.JUNE, 13, 14, 30),cliente,null, null);
        Turno turno3= new Turno(LocalDateTime.of(2025, Month.JUNE, 12, 11, 20),cliente,null, null);
        clienteDao.pedirTurno(cliente, turno);
        clienteDao.pedirTurno(cliente, turno2);
        clienteDao.pedirTurno(cliente, turno3);
        List<Turno> turnos = clienteDao.obtenerHistorialTurnos(cliente);
        clienteDao.cancelarTurno(turno2);
        System.out.println("Historial de turnos:");
        for (Turno t : turnos) {
            System.out.println(t);
        }
        List<Turno> turnos2 = clienteDao.obtenerHistorialTurnos(cliente);
        System.out.println("Historial de turnos habiendo cancelado el turno 2:");
        System.out.println(cliente.getTurnos());

    }
}
