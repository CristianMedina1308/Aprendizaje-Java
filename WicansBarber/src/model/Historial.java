package model;

import model.Cita;

import java.util.ArrayList;
import java.util.List;

public class Historial {
    private List<Cita> citasRealizadas;

    public Historial() {

        this.citasRealizadas = new ArrayList<>();
    }

    public void agregarCita(Cita cita) {
        citasRealizadas.add(cita);
    }

    public List<Cita> obtenerHistorial() {
        return citasRealizadas;
    }
}
