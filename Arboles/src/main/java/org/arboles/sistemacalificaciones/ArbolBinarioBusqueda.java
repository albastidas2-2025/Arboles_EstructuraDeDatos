package org.arboles.sistemacalificaciones;

public class ArbolBinarioBusqueda {
    Nodo raiz;

    public ArbolBinarioBusqueda() {
        raiz = null;
    }

    // INSERTAR
    public void insertar(Estudiante estudiante) {
        raiz = insertarRecursivo(raiz, estudiante);
    }

    private Nodo insertarRecursivo(Nodo nodo, Estudiante estudiante) {

        if (nodo == null) {
            return new Nodo(estudiante);
        }

        if (estudiante.id < nodo.estudiante.id) {
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, estudiante);
        } else if (estudiante.id > nodo.estudiante.id) {
            nodo.derecho = insertarRecursivo(nodo.derecho, estudiante);
        }

        return nodo;
    }

    // BUSCAR ESTUDIANTE
    public Estudiante buscarEstudiante(int id) {
        return buscarRecursivo(raiz, id);
    }

    private Estudiante buscarRecursivo(Nodo nodo, int id) {

        if (nodo == null) {
            return null;
        }

        if (id == nodo.estudiante.id) {
            return nodo.estudiante;
        }

        if (id < nodo.estudiante.id) {
            return buscarRecursivo(nodo.izquierdo, id);
        }

        return buscarRecursivo(nodo.derecho, id);
    }

    // REPORTE CSV
    public void generarReporteCSV() {

        System.out.println("ID,Nombre,CalificacionFinal");

        inOrdenCSV(raiz);
    }

    private void inOrdenCSV(Nodo nodo) {

        if (nodo != null) {

            inOrdenCSV(nodo.izquierdo);

            System.out.println(
                    nodo.estudiante.id + "," +
                            nodo.estudiante.nombre + "," +
                            nodo.estudiante.calificacionFinal
            );

            inOrdenCSV(nodo.derecho);
        }
    }
}
