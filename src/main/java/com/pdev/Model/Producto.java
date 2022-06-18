package com.pdev.Model;

public class Producto {

    private static int count = 0;
    private int id_producto;
    private String descripcion;
    private double precio;
    private int stock;
    private String url_img;

    public Producto() {
        setId_producto(++count);
        this.url_img = "default.png";
    }

    public Producto(String descripcion, double precio, int stock) {
        setId_producto(++count);
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.url_img = "default.png";
    }

    public Producto(int id_producto, String descripcion, double precio, int stock) {
        this.id_producto = id_producto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.url_img = "default.png";
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getUrl_img() {
        return url_img;
    }

    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }
}
