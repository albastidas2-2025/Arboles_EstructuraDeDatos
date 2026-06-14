package org.arboles.sistemacalificaciones;

public class Nodo {
    Estudiante estudiante;
    Nodo izquierdo, derecho;

    public Nodo(Estudiante estudiante) {
        this.estudiante = estudiante;
        izquierdo = derecho = null;
    }
}
