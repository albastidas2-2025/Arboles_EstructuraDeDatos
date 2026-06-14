package org.arboles.indexadordiccionario;

public class ArbolAVL {
    Nodo raiz;
    private int obtenerAltura(Nodo nodo) {
        if (nodo == null)
            return 0;
        return nodo.altura;
    }
    private int obtenerBalance(Nodo nodo) {
        if (nodo == null)
            return 0;
        return obtenerAltura(nodo.izquierdo)
                - obtenerAltura(nodo.derecho);
    }
    private Nodo rotacionDerecha(Nodo y) {
        Nodo x = y.izquierdo;
        Nodo T2 = x.derecho;
        x.derecho = y;
        y.izquierdo = T2;
        y.altura = Math.max(
                obtenerAltura(y.izquierdo),
                obtenerAltura(y.derecho)) + 1;
        x.altura = Math.max(
                obtenerAltura(x.izquierdo),
                obtenerAltura(x.derecho)) + 1;
        return x;
    }
    private Nodo rotacionIzquierda(Nodo x) {

        Nodo y = x.derecho;
        Nodo T2 = y.izquierdo;

        y.izquierdo = x;
        x.derecho = T2;
        x.altura = Math.max(
                obtenerAltura(x.izquierdo),
                obtenerAltura(x.derecho)) + 1;
        y.altura = Math.max(
                obtenerAltura(y.izquierdo),
                obtenerAltura(y.derecho)) + 1;
        return y;
    }
    public void insertarAVL(String palabra) {
        raiz = insertarAVLRecursivo(raiz, palabra);
    }
    private Nodo insertarAVLRecursivo(Nodo nodo, String palabra) {
        if (nodo == null)
            return new Nodo(palabra);
        if (palabra.compareTo(nodo.palabra) < 0) {
            nodo.izquierdo =
                    insertarAVLRecursivo(
                            nodo.izquierdo,
                            palabra);
        } else if (palabra.compareTo(nodo.palabra) > 0) {
            nodo.derecho =
                    insertarAVLRecursivo(
                            nodo.derecho,
                            palabra);
        } else {
            return nodo;
        }
        nodo.altura = 1 + Math.max(
                obtenerAltura(nodo.izquierdo),
                obtenerAltura(nodo.derecho));
        int balance = obtenerBalance(nodo);
        // LL
        if (balance > 1 &&
                palabra.compareTo(nodo.izquierdo.palabra) < 0) {
            return rotacionDerecha(nodo);
        }
        // RR
        if (balance < -1 &&
                palabra.compareTo(nodo.derecho.palabra) > 0) {
            return rotacionIzquierda(nodo);
        }
        // LR
        if (balance > 1 &&
                palabra.compareTo(nodo.izquierdo.palabra) > 0) {
            nodo.izquierdo =
                    rotacionIzquierda(nodo.izquierdo);
            return rotacionDerecha(nodo);
        }
        // RL
        if (balance < -1 &&
                palabra.compareTo(nodo.derecho.palabra) < 0) {
            nodo.derecho =
                    rotacionDerecha(nodo.derecho);
            return rotacionIzquierda(nodo);
        }
        return nodo;
    }
    public void rangoAlfabetico(String inicio, String fin) {
        rangoAlfabeticoRecursivo(raiz, inicio, fin);
    }
    private void rangoAlfabeticoRecursivo(
            Nodo nodo,
            String inicio,
            String fin) {
        if (nodo == null)
            return;
        if (nodo.palabra.compareTo(inicio) > 0) {
            rangoAlfabeticoRecursivo(
                    nodo.izquierdo,
                    inicio,
                    fin);
        }
        if (nodo.palabra.compareTo(inicio) >= 0 &&
                nodo.palabra.compareTo(fin) <= 0) {
            System.out.println(nodo.palabra);
        }
        if (nodo.palabra.compareTo(fin) < 0) {
            rangoAlfabeticoRecursivo(
                    nodo.derecho,
                    inicio,
                    fin);
        }
    }
    public void inOrden() {
        inOrdenRecursivo(raiz);
    }
    private void inOrdenRecursivo(Nodo nodo) {
        if (nodo != null) {
            inOrdenRecursivo(nodo.izquierdo);
            System.out.println(nodo.palabra);
            inOrdenRecursivo(nodo.derecho);
        }
    }
}
