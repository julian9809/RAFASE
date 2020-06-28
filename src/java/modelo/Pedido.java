/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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
    private double id_cedula;
    private double id_ciudad;

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

    public double getId_cedula() {
        return id_cedula;
    }

    public void setId_cedula(double id_cedula) {
        this.id_cedula = id_cedula;
    }

    public double getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(double id_ciudad) {
        this.id_ciudad = id_ciudad;
    }
    
}
