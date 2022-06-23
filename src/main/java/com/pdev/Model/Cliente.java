package com.pdev.Model;

public class Cliente {

    private static int count = 0;
    private int id_cliente;
    private String dni;
    private String nombre;

    public Cliente() {
        setId_cliente(++count);
    }

    public Cliente(String dni, String nombre) {
        setId_cliente(++count);
        this.dni = dni;
        this.nombre = nombre;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
