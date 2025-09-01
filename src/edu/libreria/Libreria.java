package edu.libreria;

import java.util.ArrayList;
import java.util.List;

public class Libreria {
    private List<Libro> libros;

    public Libreria() {
        libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void mostrarInventario() {
        System.out.println("Inventario de la librería:");
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }
}


