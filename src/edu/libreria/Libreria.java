package edu.libreria;

import java.util.ArrayList;
import java.util.List;

public class Libreria {
    private List<Vendible> inventario = new ArrayList<>();

    public void agregarProducto(Vendible v) {
        inventario.add(v);
    }

    public void mostrarInventario() {
        for (Vendible v : inventario) {
            System.out.println(v);
        }
    }
}

