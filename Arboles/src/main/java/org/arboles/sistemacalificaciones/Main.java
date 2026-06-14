package org.arboles.sistemacalificaciones;

public class Main {
    public static void main(String[] args) {

        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();

        arbol.insertar(new Estudiante(105, "Alexis", 9.5));
        arbol.insertar(new Estudiante(102, "Maria", 8.7));
        arbol.insertar(new Estudiante(110, "Carlos", 9.0));
        arbol.insertar(new Estudiante(101, "Ana", 10.0));

        System.out.println("=== BUSQUEDA ===");

        Estudiante estudiante = arbol.buscarEstudiante(102);

        if (estudiante != null) {
            System.out.println(estudiante);
        } else {
            System.out.println("Estudiante no registrado.");
        }

        System.out.println("\n=== REPORTE CSV ===");
        arbol.generarReporteCSV();
    }
}
