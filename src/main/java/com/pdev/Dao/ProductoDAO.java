package com.pdev.Dao;

import com.pdev.Model.Producto;

import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    public static List<Producto> listaProductos = new ArrayList<>();

    static {
        if(listaProductos.isEmpty()){
            loadExampleData();
        }
    }
    private static void loadExampleData(){
        listaProductos.add(new Producto("Laptop", 1500, 10));
        listaProductos.add(new Producto("Teclado", 40, 10));
        listaProductos.add(new Producto("Mouse", 20, 10));
    }

    public static List<Producto> listar(){
        return listaProductos;
    }
    public static void registrar(Producto producto){
        listaProductos.add(producto);
    }
    public static Producto encontrarPorId(int id_producto){
        Producto productoEncontrado = null;
        for(Producto producto : listaProductos){
            if(producto.getId_producto() == id_producto){
                productoEncontrado = producto;
                break;
            }
        }
        return productoEncontrado;
    }

    private static int encontrarIndexPorId(int id_producto){
        for(int i=0; i < listaProductos.size(); i++){
            if(listaProductos.get(i).getId_producto() == id_producto){
                return i;
            }
        }
        return -1;
    }

    public static Producto actualizar(Producto producto){
        int index = encontrarIndexPorId(producto.getId_producto());
        if(index > -1 ) listaProductos.set(index, producto);
        return producto;
    }
    public static Producto eliminar(int id_producto){
        Producto productoEncontrado = encontrarPorId(id_producto);
        if(productoEncontrado != null ) listaProductos.remove(productoEncontrado);
        return productoEncontrado;
    }
}
