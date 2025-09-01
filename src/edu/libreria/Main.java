package edu.libreria;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Libreria libreria = new Libreria("Librería Central");

        // Libros iniciales
        Autor autor1 = new Autor("Gabriel García Márquez");
        libreria.agregarLibro(new Novela("Cien Años de Soledad", autor1, 50000.0, "Realismo mágico"));

        Autor autor2 = new Autor("Isaac Newton");
        libreria.agregarLibro(new LibroDeTexto("Principia Mathematica", autor2, 120000.0, "Física"));

        Autor autor3 = new Autor("Antoine de Saint-Exupéry");
        libreria.agregarLibro(new Novela("El Principito", autor3, 30000.0, "Fábula"));

        int opcion;
        do {
            System.out.println("\n📚 Menú de la " + libreria.getNombre());
            System.out.println("1. Ver inventario de libros");
            System.out.println("2. Comprar un libro");
            System.out.println("3. Vender un libro a la librería");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");

            while (!sc.hasNextInt()) {
                System.out.println("⚠️ Ingresa un número válido.");
                sc.next();
            }
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("\n📖 Inventario de la librería:\n");
                    libreria.mostrarInventario();
                    break;

                case 2:
                    System.out.print("\nIngresa el título del libro que deseas comprar: ");
                    String tituloCompra = sc.nextLine();
                    libreria.comprarLibro(tituloCompra);
                    break;

                case 3:
                    System.out.println("\n=== Vender un libro a la librería ===");
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Autor: ");
                    String nombreAutor = sc.nextLine();
                    Autor autorNuevo = new Autor(nombreAutor);

                    System.out.print("Precio: ");
                    double precio = sc.nextDouble();
                    sc.nextLine(); // limpiar buffer

                    System.out.println("Tipo de libro:");
                    System.out.println("1. Literario (cuento, novela, etc.)");
                    System.out.println("2. Texto Académico");
                    int tipoLibro = sc.nextInt();
                    sc.nextLine();

                    if (tipoLibro == 1) {
                        System.out.print("Género literario (cuento, novela, etc.): ");
                        String genero = sc.nextLine();
                        Novela nuevaNovela = new Novela(titulo, autorNuevo, precio, genero);
                        libreria.agregarLibro(nuevaNovela);
                        System.out.println("✅ Libro literario agregado con éxito.");
                    } else if (tipoLibro == 2) {
                        System.out.print("Asignatura (Matemáticas, Historia, etc.): ");
                        String asignatura = sc.nextLine();
                        LibroDeTexto nuevoTexto = new LibroDeTexto(titulo, autorNuevo, precio, asignatura);
                        libreria.agregarLibro(nuevoTexto);
                        System.out.println("✅ Texto académico agregado con éxito.");
                    } else {
                        System.out.println("⚠️ Tipo no válido. El libro no fue agregado.");
                    }
                    break;

                case 4:
                    System.out.println("👋 ¡Gracias por visitar la librería!");
                    break;

                default:
                    System.out.println("⚠️ Opción inválida. Intenta de nuevo.");
            }

        } while (opcion != 4);

        sc.close();
    }
}
