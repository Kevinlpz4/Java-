package edu.libreria;

public class Main {
    public static void main(String[] args) {
        Autor autor1 = new Autor("Gabriel García Márquez");
        Novela novela1 = new Novela("Cien Años de Soledad", autor1, 50000.0, "Realismo mágico");

        Autor autor2 = new Autor("Isaac Newton");
        LibroDeTexto libro1 = new LibroDeTexto("Principia Mathematica", autor2, 120000.0, "Física");

        Libreria libreria = new Libreria();
        libreria.agregarLibro(novela1);
        libreria.agregarLibro(libro1);

        libreria.mostrarInventario();
    }
}

