package edu.libreria;

import java.text.NumberFormat;
import java.util.Locale;

public class Novela extends Libro {
    private String genero;

    public Novela(String titulo, Autor autor, double precio, String genero) {
        super(titulo, autor, precio);
        this.genero = genero;
    }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    private String formatearMoneda(double valor) {
        NumberFormat formato = NumberFormat.getCurrencyInstance(new Locale("es", "CO"));
        return formato.format(valor);
    }

    @Override
    public String toString() {
        return "Título: " + getTitulo() +
               ", Autor: " + getAutor().getNombre() +
               ", Precio: " + formatearMoneda(getPrecio()) +
               ", Género: novela " + "(" + genero + ")";
    }
}


