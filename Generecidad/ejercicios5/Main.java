package Generecidad.ejercicios5;

import java.util.ArrayList;
import java.util.List;

class Pila<T> {
    private List<T> elementos = new ArrayList<>();

    // a) Metodo para apilar
    public void apilar(T elemento) {
        elementos.add(elemento);
    }

    // b) Metodo para desapilar
    public T desapilar() {
        if (!elementos.isEmpty()) {
            return elementos.remove(elementos.size() - 1);
        }
        return null;
    }

    // d) Metodo para mostrar los datos
    public void mostrar() {
        for (int i = elementos.size() - 1; i >= 0; i--) {
            System.out.println(elementos.get(i));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // c) Prueba la pila con diferentes tipos de datos

        Pila<String> pilaString = new Pila<>();
        pilaString.apilar("A");
        pilaString.apilar("B");
        pilaString.apilar("C");
        pilaString.desapilar();
        pilaString.mostrar();

        Pila<Integer> pilaEnteros = new Pila<>();
        pilaEnteros.apilar(10);
        pilaEnteros.apilar(20);
        pilaEnteros.apilar(30);
        pilaEnteros.desapilar();
        pilaEnteros.mostrar();
    }
}
