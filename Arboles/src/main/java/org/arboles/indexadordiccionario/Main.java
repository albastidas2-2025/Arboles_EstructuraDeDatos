package org.arboles.indexadordiccionario;

public class Main {
    public static void main(String[] args) {

        ArbolAVL diccionario = new ArbolAVL();

        diccionario.insertarAVL("Algoritmo");
        diccionario.insertarAVL("Matriz");
        diccionario.insertarAVL("Puntero");
        diccionario.insertarAVL("Variable");
        diccionario.insertarAVL("Clase");
        diccionario.insertarAVL("Objeto");
        diccionario.insertarAVL("Metodo");
        diccionario.insertarAVL("Compilador");
        diccionario.insertarAVL("Programa");
        diccionario.insertarAVL("Archivo");
        diccionario.insertarAVL("Interfaz");
        diccionario.insertarAVL("Framework");
        diccionario.insertarAVL("Paquete");
        diccionario.insertarAVL("Herencia");
        diccionario.insertarAVL("Polimorfismo");
        diccionario.insertarAVL("Encapsulamiento");
        diccionario.insertarAVL("Arreglo");
        diccionario.insertarAVL("Lista");
        diccionario.insertarAVL("Cola");
        diccionario.insertarAVL("Pila");

        System.out.println("=== DICCIONARIO ORDENADO ===");
        diccionario.inOrden();

        System.out.println("\n=== PALABRAS ENTRE M Y Z ===");
        diccionario.rangoAlfabetico("M", "Z");
    }
}
