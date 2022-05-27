package com.pdev.Util;

import com.pdev.Model.Producto;

import java.util.ArrayList;
import java.util.List;

public final class MemoryDatabase {

    public static List<Producto> listaProductos;

    static {
        listaProductos = new ArrayList<>();
        loadExampleData();
    }

    private static void loadExampleData(){
        listaProductos.add(new Producto(1, "Laptop", 1500, 10));
        listaProductos.add(new Producto(2, "Teclado", 40, 10));
        listaProductos.add(new Producto(3, "Mouse", 20, 10));
    }

}
