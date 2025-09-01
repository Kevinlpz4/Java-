package edu.libreria;

import java.util.ArrayList;
import java.util.List;

public class Libreria {
    private String nombre;
    private List<Libro> libros;

    public Libreria(String nombre) {
        this.nombre = nombre;
        this.libros = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void mostrarInventario() {
        if (libros.isEmpty()) {
            System.out.println(" No hay libros en el inventario.");
        } else {
            for (Libro libro : libros) {
                System.out.println(libro);
            }
        }
    }

    public Libro buscarPorTitulo(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null; // si no encuentra el libro
    }

    // Compra: elimina un libro del inventario
    public void comprarLibro(String titulo) {
        Libro libro = buscarPorTitulo(titulo);
        if (libro != null) {
            libros.remove(libro);
            System.out.println(" Has comprado el libro: " + libro);
        } else {
            System.out.println(" El libro no está disponible en la librería.");
        }
    }
}