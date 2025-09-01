package edu.libreria;

public class Novela extends Libro {
    private String genero;

    public Novela(String titulo, Autor autor, double precio, String genero) {
        super(titulo, autor, precio);
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    @Override
    public String toString() {
        return super.toString() + " [Novela - " + genero + "]";
    }
}

