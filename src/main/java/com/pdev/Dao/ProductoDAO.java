package com.pdev.Dao;

import com.pdev.Model.Producto;
import com.pdev.Util.MemoryDatabase;

import java.util.List;

public class ProductoDAO {

    public static List<Producto> listar(){
        return MemoryDatabase.listar();
    }

    public static void registrar(Producto producto){
        MemoryDatabase.agregar(producto);
    }

    public static Producto encontrarPorId(int id_producto){
        return MemoryDatabase.encontrarPorId(id_producto);
    }

    public static Producto actualizar(Producto producto){
        return MemoryDatabase.actualizar(producto);
    }
    public static Producto eliminar(int id_producto){
        return MemoryDatabase.eliminar(id_producto);
    }
}
