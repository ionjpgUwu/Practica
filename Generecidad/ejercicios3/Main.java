package Generecidad.ejercicios3;

import java.util.ArrayList;
import java.util.List;

class Catalogo<T> {
    private List<T> elementos = new ArrayList<>();

    // a) Agrega métodos para agregar y buscar elemento
    public void agregar(T elemento) {
        elementos.add(elemento);
    }

    public T buscar(T elemento) {
        for (T e : elementos) {
            if (e.equals(elemento)) {
                return e;
            }
        }
        return null;
    }
}

class Libro {
    private String titulo;

    public Libro(String titulo) {
        this.titulo = titulo;
    }

    public String toString() {
        return "Libro: " + titulo;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Libro) {
            Libro otro = (Libro) obj;
            return this.titulo.equalsIgnoreCase(otro.titulo);
        }
        return false;
    }
}

class Producto {
    private String nombre;

    public Producto(String nombre) {
        this.nombre = nombre;
    }

    public String toString() {
        return "Producto: " + nombre;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Producto) {
            Producto otro = (Producto) obj;
            return this.nombre.equalsIgnoreCase(otro.nombre);
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        // b) Prueba el catálogo con libros
        Catalogo<Libro> catalogoLibros = new Catalogo<>();
        catalogoLibros.agregar(new Libro("1984"));
        catalogoLibros.agregar(new Libro("El Principito"));
        System.out.println(catalogoLibros.buscar(new Libro("1984")));

        // c) Prueba el catálogo con productos
        Catalogo<Producto> catalogoProductos = new Catalogo<>();
        catalogoProductos.agregar(new Producto("Laptop"));
        catalogoProductos.agregar(new Producto("Mouse"));
        System.out.println(catalogoProductos.buscar(new Producto("Mouse")));
    }
}
