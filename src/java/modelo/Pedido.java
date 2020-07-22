/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author david
 */
public class Pedido {
    private double id_pedido;
    private double estado_pedido;
    private Date fecha_pedido;
    private double total_pedido;
    private double id_ciudad;
    private double id_cedula;
    private String tipo_id;
    
    private ArrayList id_pedido_array = new ArrayList();
    private ArrayList estado_pedido_array = new ArrayList();
    private ArrayList fecha_pedido_array = new ArrayList();
    private ArrayList total_pedido_array = new ArrayList();
    private ArrayList id_ciudad_array = new ArrayList();
    private ArrayList id_cedula_array = new ArrayList();
    private ArrayList tipo_id_array = new ArrayList();
    
    public Pedido() {
    }

    public double getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(double id_pedido) {
        this.id_pedido = id_pedido;
    }

    public double getEstado_pedido() {
        return estado_pedido;
    }

    public void setEstado_pedido(double estado_pedido) {
        this.estado_pedido = estado_pedido;
    }

    public Date getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(Date fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    public double getTotal_pedido() {
        return total_pedido;
    }

    public void setTotal_pedido(double total_pedido) {
        this.total_pedido = total_pedido;
    }

    public double getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(double id_ciudad) {
        this.id_ciudad = id_ciudad;
    }
    
    public double getId_cedula() {
        return id_cedula;
    }

    public void setId_cedula(double id_cedula) {
        this.id_cedula = id_cedula;
    }

    public String getTipo_id() {
        return tipo_id;
    }

    public void setTipo_id(String tipo_id) {
        this.tipo_id = tipo_id;
    }

    public ArrayList getId_pedido_array() {
        return id_pedido_array;
    }

    public void setId_pedido_array(ArrayList id_pedido_array) {
        this.id_pedido_array = id_pedido_array;
    }

    public ArrayList getEstado_pedido_array() {
        return estado_pedido_array;
    }

    public void setEstado_pedido_array(ArrayList estado_pedido_array) {
        this.estado_pedido_array = estado_pedido_array;
    }

    public ArrayList getFecha_pedido_array() {
        return fecha_pedido_array;
    }

    public void setFecha_pedido_array(ArrayList fecha_pedido_array) {
        this.fecha_pedido_array = fecha_pedido_array;
    }

    public ArrayList getTotal_pedido_array() {
        return total_pedido_array;
    }

    public void setTotal_pedido_array(ArrayList total_pedido_array) {
        this.total_pedido_array = total_pedido_array;
    }

    public ArrayList getId_ciudad_array() {
        return id_ciudad_array;
    }

    public void setId_ciudad_array(ArrayList id_ciudad_array) {
        this.id_ciudad_array = id_ciudad_array;
    }

    public ArrayList getId_cedula_array() {
        return id_cedula_array;
    }

    public void setId_cedula_array(ArrayList id_cedula_array) {
        this.id_cedula_array = id_cedula_array;
    }

    public ArrayList getTipo_id_array() {
        return tipo_id_array;
    }

    public void setTipo_id_array(ArrayList tipo_id_array) {
        this.tipo_id_array = tipo_id_array;
    }
    
}
