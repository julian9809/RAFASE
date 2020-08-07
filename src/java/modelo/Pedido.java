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
    private long id_pedido;
    private String estado_pedido;
    private Date fecha_pedido;
    private double total_pedido;
    private long id_ciudad;
    private long id_cedula;
    private String tipo_id;
    
    private ArrayList<Long> id_pedido_array = new ArrayList<>();
    private ArrayList<String> estado_pedido_array = new ArrayList<>();
    private ArrayList<Date> fecha_pedido_array = new ArrayList<>();
    private ArrayList<Double> total_pedido_array = new ArrayList<>();
    private ArrayList<Long> id_ciudad_array = new ArrayList<>();
    private ArrayList<Long> id_cedula_array = new ArrayList<>();
    private ArrayList<String> tipo_id_array = new ArrayList<>();
    
    public Pedido() {
    }

    public long getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(long id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getEstado_pedido() {
        return estado_pedido;
    }

    public void setEstado_pedido(String estado_pedido) {
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

    public long getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(long id_ciudad) {
        this.id_ciudad = id_ciudad;
    }
    
    public long getId_cedula() {
        return id_cedula;
    }

    public void setId_cedula(long id_cedula) {
        this.id_cedula = id_cedula;
    }

    public String getTipo_id() {
        return tipo_id;
    }

    public void setTipo_id(String tipo_id) {
        this.tipo_id = tipo_id;
    }

    public ArrayList<Long> getId_pedido_array() {
        return id_pedido_array;
    }

    public void setId_pedido_array(ArrayList<Long> id_pedido_array) {
        this.id_pedido_array = id_pedido_array;
    }

    public ArrayList<String> getEstado_pedido_array() {
        return estado_pedido_array;
    }

    public void setEstado_pedido_array(ArrayList<String> estado_pedido_array) {
        this.estado_pedido_array = estado_pedido_array;
    }

    public ArrayList<Date> getFecha_pedido_array() {
        return fecha_pedido_array;
    }

    public void setFecha_pedido_array(ArrayList<Date> fecha_pedido_array) {
        this.fecha_pedido_array = fecha_pedido_array;
    }

    public ArrayList<Double> getTotal_pedido_array() {
        return total_pedido_array;
    }

    public void setTotal_pedido_array(ArrayList<Double> total_pedido_array) {
        this.total_pedido_array = total_pedido_array;
    }

    public ArrayList<Long> getId_ciudad_array() {
        return id_ciudad_array;
    }

    public void setId_ciudad_array(ArrayList<Long> id_ciudad_array) {
        this.id_ciudad_array = id_ciudad_array;
    }

    public ArrayList<Long> getId_cedula_array() {
        return id_cedula_array;
    }

    public void setId_cedula_array(ArrayList<Long> id_cedula_array) {
        this.id_cedula_array = id_cedula_array;
    }

    public ArrayList<String> getTipo_id_array() {
        return tipo_id_array;
    }

    public void setTipo_id_array(ArrayList<String> tipo_id_array) {
        this.tipo_id_array = tipo_id_array;
    }
    
}
