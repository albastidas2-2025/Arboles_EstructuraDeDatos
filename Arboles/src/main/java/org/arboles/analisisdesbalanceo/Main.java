package org.arboles.analisisdesbalanceo;

public class Main {

    public static void main(String[] args) {

        ArbolBinarioBusqueda bst =
                new ArbolBinarioBusqueda();

        ArbolAVL avl =
                new ArbolAVL();

        for (int i = 1; i <= 100; i++) {

            bst.insertar(i);

            avl.insertarAVL(i);
        }

        System.out.println("===== COMPARACIÓN =====");

        System.out.println(
                "Altura BST: "
                        + bst.calcularAlturaTotal());

        System.out.println(
                "Altura AVL: "
                        + avl.calcularAlturaTotal());
    }
}
