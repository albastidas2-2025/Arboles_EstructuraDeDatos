package org.arboles.jerarquiaproductos;

public class ArbolBinarioBusqueda {
    Nodo raiz;

    public ArbolBinarioBusqueda() {
        raiz = null;
    }

    // INSERTAR
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

    // RECORRIDO INORDEN
    public void inOrden() {
        inOrdenRecursivo(raiz);
    }

    private void inOrdenRecursivo(Nodo nodo) {

        if (nodo != null) {

            inOrdenRecursivo(nodo.izquierdo);

            System.out.print(nodo.valor + " ");

            inOrdenRecursivo(nodo.derecho);
        }
    }

    // PROFUNDIDAD
    public int obtenerProfundidad(int codigoBarra) {
        return obtenerProfundidadRecursiva(raiz, codigoBarra, 0);
    }

    private int obtenerProfundidadRecursiva(
            Nodo nodo,
            int codigoBarra,
            int nivel) {

        if (nodo == null) {
            return -1;
        }

        if (nodo.valor == codigoBarra) {
            return nivel;
        }

        if (codigoBarra < nodo.valor) {
            return obtenerProfundidadRecursiva(
                    nodo.izquierdo,
                    codigoBarra,
                    nivel + 1);
        }

        return obtenerProfundidadRecursiva(
                nodo.derecho,
                codigoBarra,
                nivel + 1);
    }

    // ELIMINAR PRODUCTO
    public void eliminarProducto(int codigoBarra) {
        raiz = eliminarRecursivo(raiz, codigoBarra);
    }

    private Nodo eliminarRecursivo(Nodo nodo, int codigoBarra) {

        if (nodo == null) {
            return null;
        }

        if (codigoBarra < nodo.valor) {
            nodo.izquierdo =
                    eliminarRecursivo(nodo.izquierdo, codigoBarra);
        }

        else if (codigoBarra > nodo.valor) {
            nodo.derecho =
                    eliminarRecursivo(nodo.derecho, codigoBarra);
        }

        else {
            // CASO 1: Nodo hoja
            if (nodo.izquierdo == null &&
                    nodo.derecho == null) {

                return null;
            }
            // CASO 2: Un hijo
            if (nodo.izquierdo == null) {
                return nodo.derecho;
            }
            if (nodo.derecho == null) {
                return nodo.izquierdo;
            }
            // CASO 3: Dos hijos
            Nodo sucesor = obtenerMinimo(nodo.derecho);
            nodo.valor = sucesor.valor;
            nodo.derecho =
                    eliminarRecursivo(
                            nodo.derecho,
                            sucesor.valor);
        }
        return nodo;
    }
    private Nodo obtenerMinimo(Nodo nodo) {

        while (nodo.izquierdo != null) {
            nodo = nodo.izquierdo;
        }

        return nodo;
    }
}
