/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Mateo
 */
public class DetallePedido {

    private double id_pedido;
    private double id_producto;
    private double cantidad;
    
    private ArrayList<Double> id_pedido_array = new ArrayList<>();
    private ArrayList<Double> id_producto_array = new ArrayList<>();
    private ArrayList<Double> cantidad_array = new ArrayList<>();

    public double getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(double id_pedido) {
        this.id_pedido = id_pedido;
    }

    public double getId_producto() {
        return id_producto;
    }

    public void setId_producto(double id_producto) {
        this.id_producto = id_producto;
    }
    
    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public ArrayList<Double> getId_pedido_array() {
        return id_pedido_array;
    }

    public void setId_pedido_array(ArrayList<Double> id_pedido_array) {
        this.id_pedido_array = id_pedido_array;
    }

    public ArrayList<Double> getId_producto_array() {
        return id_producto_array;
    }

    public void setId_producto_array(ArrayList<Double> id_producto_array) {
        this.id_producto_array = id_producto_array;
    }

    public ArrayList<Double> getCantidad_array() {
        return cantidad_array;
    }

    public void setCantidad_array(ArrayList<Double> cantidad_array) {
        this.cantidad_array = cantidad_array;
    }
    
}


