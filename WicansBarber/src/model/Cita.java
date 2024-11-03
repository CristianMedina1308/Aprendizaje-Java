package model;

import java.time.LocalDate;
import java.time.LocalTime;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cita {
    private Cliente cliente;
    private Barbero barbero;
    private Servicio servicio;
    private LocalDate fecha;
    private LocalTime hora;

    public Cita(Cliente cliente, Barbero barbero, Servicio servicio, LocalDate fecha, LocalTime hora) {
        this.cliente = cliente;
        this.barbero = barbero;
        this.servicio = servicio;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Cliente getCliente() { return cliente; }
    public Barbero getBarbero() { return barbero; }
    public Servicio getServicio() { return servicio; }
    public LocalDate getFecha() { return fecha; }
    public LocalTime getHora() { return hora; }
}


