package com.pdev.Dao;

import com.pdev.Model.Proveedor;

import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO {

    private static List<Proveedor> listaProveedores = new ArrayList<>();

    static{
        if(listaProveedores.isEmpty()){
            loadExampleData();
        }
    }

    private static void loadExampleData(){
        listaProveedores.add(new Proveedor("20365897854", "IDAT", "Corporación IDAT"));
        listaProveedores.add(new Proveedor("23056889658", "UTP", "Universidad Tecnológica del Perú"));
        listaProveedores.add(new Proveedor("20369854753", "GMS", "General Modified South"));
    }

    public static List<Proveedor> listar() { return listaProveedores; }

    public static Proveedor encontrarPorId(int id_proveedor){
        Proveedor proveedorEncontrado = null;
        for(Proveedor proveedor : listaProveedores){
            if(proveedor.getId_proveedor() == id_proveedor){
                proveedorEncontrado = proveedor;
                break;
            }
        }
        return proveedorEncontrado;
    }

    private static int encontrarIndexPorId(int id_proveedor){
        for(int i=0; i < listaProveedores.size(); i++){
            if(listaProveedores.get(i).getId_proveedor() == id_proveedor){
                return i;
            }
        }
        return -1;
    }

    public static void agregar(Proveedor proveedor){ listaProveedores.add(proveedor); }

    public static Proveedor actualizar(Proveedor proveedor){
        int index = encontrarIndexPorId(proveedor.getId_proveedor());
        if(index > -1) listaProveedores.set(index, proveedor);
        return proveedor;
    }

    public static Proveedor eliminar(int id_proveedor){
        Proveedor proveedorEncontrado = encontrarPorId(id_proveedor);
        if(proveedorEncontrado != null) listaProveedores.remove(proveedorEncontrado);
        return proveedorEncontrado;
    }

}
