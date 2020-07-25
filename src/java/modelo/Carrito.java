/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author danie
 */
public class Carrito {
    private double id_pedido;
    private String nombre_producto;
    private double cantidad;
    private double precio_base;
    
    private ArrayList<Double> id_pedido_array = new ArrayList<>();
    private ArrayList<String> nombre_producto_array = new ArrayList<>();
    private ArrayList<Double> cantidad_array = new ArrayList<>();
    private ArrayList<Double> precio_base_array = new ArrayList<>();
    
    public Carrito(){
        
    }

    public double getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(double id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_base() {
        return precio_base;
    }

    public void setPrecio_base(double precio_base) {
        this.precio_base = precio_base;
    }

    public ArrayList<Double> getId_pedido_array() {
        return id_pedido_array;
    }

    public void setId_pedido_array(ArrayList<Double> id_pedido_array) {
        this.id_pedido_array = id_pedido_array;
    }

    public ArrayList<String> getNombre_producto_array() {
        return nombre_producto_array;
    }

    public void setNombre_producto_array(ArrayList<String> nombre_producto_array) {
        this.nombre_producto_array = nombre_producto_array;
    }

    public ArrayList<Double> getCantidad_array() {
        return cantidad_array;
    }

    public void setCantidad_array(ArrayList<Double> cantidad_array) {
        this.cantidad_array = cantidad_array;
    }

    public ArrayList<Double> getPrecio_base_array() {
        return precio_base_array;
    }

    public void setPrecio_base_array(ArrayList<Double> precio_base_array) {
        this.precio_base_array = precio_base_array;
    }
    
}
