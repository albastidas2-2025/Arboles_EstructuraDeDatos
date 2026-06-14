package org.arboles.indexadordiccionario;

public class Nodo {
    String palabra;
    Nodo izquierdo, derecho;
    int altura;

    public Nodo(String palabra) {
        this.palabra = palabra;
        izquierdo = derecho = null;
        altura = 1;
    }
}
