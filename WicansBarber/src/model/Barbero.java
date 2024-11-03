package model;

public class Barbero {
    private String nombre;
    private String especialidad;

    public Barbero(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }


    public String getNombre() { return nombre; }
    public String getEspecialidad() { return especialidad; }
}

