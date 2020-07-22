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
    
    public Carrito(){}

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
    
    
}
