package edu.libreria;

public class Main {
    public static void main(String[] args) {
        Autor autor = new Autor("Gabriel García Márquez");
        Novela novela = new Novela("Cien Años de Soledad", autor, 50000, "Realismo mágico");

        Libreria libreria = new Libreria();
        libreria.agregarProducto(novela);

        System.out.println(" Inventario de la librería:");
        libreria.mostrarInventario();
    }
}

