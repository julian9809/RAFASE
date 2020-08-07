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

    private long id_pedido;
    private long id_producto;
    private long cantidad;
    
    private ArrayList<Long> id_pedido_array = new ArrayList<>();
    private ArrayList<Long> id_producto_array = new ArrayList<>();
    private ArrayList<Long> cantidad_array = new ArrayList<>();

    public long getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(long id_pedido) {
        this.id_pedido = id_pedido;
    }

    public long getId_producto() {
        return id_producto;
    }

    public void setId_producto(long id_producto) {
        this.id_producto = id_producto;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public ArrayList<Long> getId_pedido_array() {
        return id_pedido_array;
    }

    public void setId_pedido_array(ArrayList<Long> id_pedido_array) {
        this.id_pedido_array = id_pedido_array;
    }

    public ArrayList<Long> getId_producto_array() {
        return id_producto_array;
    }

    public void setId_producto_array(ArrayList<Long> id_producto_array) {
        this.id_producto_array = id_producto_array;
    }

    public ArrayList<Long> getCantidad_array() {
        return cantidad_array;
    }

    public void setCantidad_array(ArrayList<Long> cantidad_array) {
        this.cantidad_array = cantidad_array;
    }
    
}


