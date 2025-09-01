package edu.libreria;

public class LibroDeTexto extends Libro {
    private String curso;

    public LibroDeTexto(String titulo, Autor autor, double precio, String curso) {
        super(titulo, autor, precio);
        this.curso = curso;
    }

    public String getCurso() {
        return curso;
    }

    @Override
    public String toString() {
        return super.toString() + " [Texto - Curso: " + curso + "]";
    }
}

