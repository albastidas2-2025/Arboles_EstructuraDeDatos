package org.arboles.jerarquiaproductos;

public class Main {
    public static void main(String[] args) {
        ArbolBinarioBusqueda arbol =
                new ArbolBinarioBusqueda();
        int[] codigos = {
                50, 30, 70, 20, 40,
                60, 80, 10, 25, 35,
                45, 55, 65, 75, 90
        };
        for (int codigo : codigos) {
            arbol.insertar(codigo);
        }
        System.out.println("Inventario:");
        arbol.inOrden();
        System.out.println("\n\nProfundidad de 65: "
                + arbol.obtenerProfundidad(65));
        arbol.eliminarProducto(70);
        System.out.println("\nInventario después de eliminar 70:");
        arbol.inOrden();
    }
}
