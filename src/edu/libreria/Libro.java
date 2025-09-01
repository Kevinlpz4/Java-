package edu.libreria;

public abstract class Libro implements Vendible {
    private String titulo;
    private Autor autor;
    private double precio;

    public Libro(String titulo, Autor autor, double precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return titulo + " - " + autor.getNombre() + " ($" + precio + ")";
    }
}

