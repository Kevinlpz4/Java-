package edu.libreria;

import java.text.NumberFormat;
import java.util.Locale;

public class LibroDeTexto extends Libro {
    private String asignatura;

    public LibroDeTexto(String titulo, Autor autor, double precio, String asignatura) {
        super(titulo, autor, precio);
        this.asignatura = asignatura;
    }

    public String getAsignatura() { return asignatura; }
    public void setAsignatura(String asignatura) { this.asignatura = asignatura; }

    private String formatearMoneda(double valor) {
        NumberFormat formato = NumberFormat.getCurrencyInstance(new Locale("es", "CO"));
        return formato.format(valor);
    }

    @Override
    public String toString() {
        return "Título: " + getTitulo() +
               ", Autor: " + getAutor().getNombre() +
               ", Precio: " + formatearMoneda(getPrecio()) +
               ", Asignatura: " + asignatura;
    }
}


