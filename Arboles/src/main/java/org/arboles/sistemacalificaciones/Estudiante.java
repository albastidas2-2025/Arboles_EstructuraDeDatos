package org.arboles.sistemacalificaciones;

public class Estudiante {
    int id;
    String nombre;
    double calificacionFinal;

    public Estudiante(int id, String nombre, double calificacionFinal) {
        this.id = id;
        this.nombre = nombre;
        this.calificacionFinal = calificacionFinal;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Nombre: " + nombre +
                ", Calificación: " + calificacionFinal;
    }

}
