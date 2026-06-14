package org.arboles.analisisdesbalanceo;

public class ArbolAVL extends ArbolBinarioBusqueda{
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

        public void insertarAVL(int valor) {
            raiz = insertarAVLRecursivo(raiz, valor);
        }

        private Nodo insertarAVLRecursivo(Nodo nodo, int valor) {

            if (nodo == null)
                return new Nodo(valor);

            if (valor < nodo.valor) {
                nodo.izquierdo =
                        insertarAVLRecursivo(nodo.izquierdo, valor);
            } else if (valor > nodo.valor) {
                nodo.derecho =
                        insertarAVLRecursivo(nodo.derecho, valor);
            } else {
                return nodo;
            }

            nodo.altura = 1 + Math.max(
                    obtenerAltura(nodo.izquierdo),
                    obtenerAltura(nodo.derecho));

            int balance = obtenerBalance(nodo);

            // LL
            if (balance > 1 &&
                    valor < nodo.izquierdo.valor) {
                return rotacionDerecha(nodo);
            }

            // RR
            if (balance < -1 &&
                    valor > nodo.derecho.valor) {
                return rotacionIzquierda(nodo);
            }

            // LR
            if (balance > 1 &&
                    valor > nodo.izquierdo.valor) {

                nodo.izquierdo =
                        rotacionIzquierda(nodo.izquierdo);

                return rotacionDerecha(nodo);
            }

            // RL
            if (balance < -1 &&
                    valor < nodo.derecho.valor) {

                nodo.derecho =
                        rotacionDerecha(nodo.derecho);

                return rotacionIzquierda(nodo);
            }

            return nodo;
        }
}
