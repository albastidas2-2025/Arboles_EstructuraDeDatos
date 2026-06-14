package org.arboles.analisisdesbalanceo;

public class Nodo {
int valor;
        Nodo izquierdo, derecho;
int altura;

public Nodo(int valor) {
    this.valor = valor;
    izquierdo = derecho = null;
    altura = 1;
}
}
