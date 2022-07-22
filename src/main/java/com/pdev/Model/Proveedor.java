package com.pdev.Model;

public class Proveedor {

    private static int count = 0;
    private int id_proveedor;
    private String ruc;
    private String razon_social;
    private String nombre_comercial;

    public Proveedor() {
        setId_proveedor(++count);
    }

    public Proveedor(String ruc, String razon_social, String nombre_comercial) {
        setId_proveedor(++count);
        this.ruc = ruc;
        this.razon_social = razon_social;
        this.nombre_comercial = nombre_comercial;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getNombre_comercial() {
        return nombre_comercial;
    }

    public void setNombre_comercial(String nombre_comercial) {
        this.nombre_comercial = nombre_comercial;
    }
}
