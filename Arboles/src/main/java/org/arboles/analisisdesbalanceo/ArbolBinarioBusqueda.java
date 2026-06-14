package org.arboles.analisisdesbalanceo;

public class ArbolBinarioBusqueda {
    Nodo raiz;

    public ArbolBinarioBusqueda() {
        raiz = null;
    }

    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    private Nodo insertarRecursivo(Nodo nodo, int valor) {

        if (nodo == null) {
            return new Nodo(valor);
        }

        if (valor < nodo.valor) {
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, valor);
        } else if (valor > nodo.valor) {
            nodo.derecho = insertarRecursivo(nodo.derecho, valor);
        }

        return nodo;
    }

    public void inOrden(Nodo nodo) {
        if (nodo != null) {
            inOrden(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            inOrden(nodo.derecho);
        }
    }

    // Calcular altura total del árbol
    public int calcularAlturaTotal() {
        return calcularAltura(raiz);
    }

    private int calcularAltura(Nodo nodo) {

        if (nodo == null) {
            return 0;
        }

        return 1 + Math.max(
                calcularAltura(nodo.izquierdo),
                calcularAltura(nodo.derecho)
        );
    }
}
