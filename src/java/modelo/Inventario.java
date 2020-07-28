/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author david
 */
public class Inventario {
    
    private double id_producto;
    private double id_proveedor;
    private double id_ciudad;
    private double existencias;
    private double precio_base;
    
    private ArrayList<Double> id_producto_array = new ArrayList<>();
    private ArrayList<Double> id_proveedor_array = new ArrayList<>();
    private ArrayList<Double> id_ciudad_array = new ArrayList<>();
    private ArrayList<Double> existencias_array = new ArrayList<>();
    private ArrayList<Double> precio_base_array = new ArrayList<>();

    public Inventario() {
    }    

    public double getId_producto() {
        return id_producto;
    }

    public void setId_producto(double id_producto) {
        this.id_producto = id_producto;
    }

    public double getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(double id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public double getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(double id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public double getExistencias() {
        return existencias;
    }

    public void setExistencias(double existencias) {
        this.existencias = existencias;
    }

    public double getPrecio_base() {
        return precio_base;
    }

    public void setPrecio_base(double precio_base) {
        this.precio_base = precio_base;
    }

    public ArrayList<Double> getId_producto_array() {
        return id_producto_array;
    }

    public void setId_producto_array(ArrayList<Double> id_producto_array) {
        this.id_producto_array = id_producto_array;
    }

    public ArrayList<Double> getId_proveedor_array() {
        return id_proveedor_array;
    }

    public void setId_proveedor_array(ArrayList<Double> id_proveedor_array) {
        this.id_proveedor_array = id_proveedor_array;
    }

    public ArrayList<Double> getId_ciudad_array() {
        return id_ciudad_array;
    }

    public void setId_ciudad_array(ArrayList<Double> id_ciudad_array) {
        this.id_ciudad_array = id_ciudad_array;
    }

    public ArrayList<Double> getExistencias_array() {
        return existencias_array;
    }

    public void setExistencias_array(ArrayList<Double> existencias_array) {
        this.existencias_array = existencias_array;
    }

    public ArrayList<Double> getPrecio_base_array() {
        return precio_base_array;
    }

    public void setPrecio_base_array(ArrayList<Double> precio_base_array) {
        this.precio_base_array = precio_base_array;
    }
    
}
