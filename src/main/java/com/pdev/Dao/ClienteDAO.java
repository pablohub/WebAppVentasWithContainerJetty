package com.pdev.Dao;

import com.pdev.Model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private static List<Cliente> listaClientes = new ArrayList<>();

    static{
        if(listaClientes.isEmpty()){
            loadExampleData();
        }
    }

    private static void loadExampleData(){
        listaClientes.add(new Cliente("25369874", "Luis Castro"));
        listaClientes.add(new Cliente("89562325", "Mario Zevallos"));
        listaClientes.add(new Cliente("74851236", "Diego Velasquez"));
    }

    public static List<Cliente> listar() { return listaClientes; }

    public static Cliente encontrarPorId(int id_cliente){
        Cliente clienteEncontrado = null;
        for(Cliente cliente : listaClientes){
            if(cliente.getId_cliente() == id_cliente){
                clienteEncontrado = cliente;
                break;
            }
        }
        return clienteEncontrado;
    }

    private static int encontrarIndexPorId(int id_cliente){
        for(int i=0; i < listaClientes.size(); i++){
            if(listaClientes.get(i).getId_cliente() == id_cliente){
                return i;
            }
        }
        return -1;
    }

    public static void agregar(Cliente cliente){ listaClientes.add(cliente); }

    public static Cliente actualizar(Cliente cliente){
        int index = encontrarIndexPorId(cliente.getId_cliente());
        if(index > -1) listaClientes.set(index, cliente);
        return cliente;
    }

    public static Cliente eliminar(int id_cliente){
        Cliente clienteEncontrado = encontrarPorId(id_cliente);
        if(clienteEncontrado != null) listaClientes.remove(clienteEncontrado);
        return clienteEncontrado;
    }
}
