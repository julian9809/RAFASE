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
public class factura {

    private long id_cedula;
    private String tipo_id;
    private long id_pedido;
    private long cantidad;
    private double precioProd;
    private double iva;
    private double precioConIva;
    private double ivaCompleto;
    private double precioSinIva;
    private String metodoPago;
    private long id_ciudad;

    private ArrayList<Long> id_cedula_array = new ArrayList<>();
    private ArrayList<String> tipo_id_array = new ArrayList<>();
    private ArrayList<Long> id_pedido_array = new ArrayList<>();
    private ArrayList<Long> cantidad_array = new ArrayList<>();
    private ArrayList<Double> precioProd_array = new ArrayList<>();
    private ArrayList<Double> iva_array = new ArrayList<>();
    private ArrayList<Double> precioConIva_array = new ArrayList<>();
    private ArrayList<Double> ivaCompleto_array = new ArrayList<>();
    private ArrayList<Double> precioSinIva_array = new ArrayList<>();
    private ArrayList<String> metodoPago_array = new ArrayList<>();
    private ArrayList<Long> id_ciudad_array = new ArrayList<>();

    public factura() {
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

    public long getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(long id_pedido) {
        this.id_pedido = id_pedido;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioProd() {
        return precioProd;
    }

    public void setPrecioProd(double precioProd) {
        this.precioProd = precioProd;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getPrecioConIva() {
        return precioConIva;
    }

    public void setPrecioConIva(double precioConIva) {
        this.precioConIva = precioConIva;
    }

    public double getIvaCompleto() {
        return ivaCompleto;
    }

    public void setIvaCompleto(double ivaCompleto) {
        this.ivaCompleto = ivaCompleto;
    }

    public double getPrecioSinIva() {
        return precioSinIva;
    }

    public void setPrecioSinIva(double precioSinIva) {
        this.precioSinIva = precioSinIva;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public long getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(long id_ciudad) {
        this.id_ciudad = id_ciudad;
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

    public ArrayList<Long> getId_pedido_array() {
        return id_pedido_array;
    }

    public void setId_pedido_array(ArrayList<Long> id_pedido_array) {
        this.id_pedido_array = id_pedido_array;
    }

    public ArrayList<Long> getCantidad_array() {
        return cantidad_array;
    }

    public void setCantidad_array(ArrayList<Long> cantidad_array) {
        this.cantidad_array = cantidad_array;
    }

    public ArrayList<Double> getPrecioProd_array() {
        return precioProd_array;
    }

    public void setPrecioProd_array(ArrayList<Double> precioProd_array) {
        this.precioProd_array = precioProd_array;
    }

    public ArrayList<Double> getIva_array() {
        return iva_array;
    }

    public void setIva_array(ArrayList<Double> iva_array) {
        this.iva_array = iva_array;
    }

    public ArrayList<Double> getPrecioConIva_array() {
        return precioConIva_array;
    }

    public void setPrecioConIva_array(ArrayList<Double> precioConIva_array) {
        this.precioConIva_array = precioConIva_array;
    }

    public ArrayList<Double> getIvaCompleto_array() {
        return ivaCompleto_array;
    }

    public void setIvaCompleto_array(ArrayList<Double> ivaCompleto_array) {
        this.ivaCompleto_array = ivaCompleto_array;
    }

    public ArrayList<Double> getPrecioSinIva_array() {
        return precioSinIva_array;
    }

    public void setPrecioSinIva_array(ArrayList<Double> precioSinIva_array) {
        this.precioSinIva_array = precioSinIva_array;
    }

    public ArrayList<String> getMetodoPago_array() {
        return metodoPago_array;
    }

    public void setMetodoPago_array(ArrayList<String> metodoPago_array) {
        this.metodoPago_array = metodoPago_array;
    }

    public ArrayList<Long> getId_ciudad_array() {
        return id_ciudad_array;
    }

    public void setId_ciudad_array(ArrayList<Long> id_ciudad_array) {
        this.id_ciudad_array = id_ciudad_array;
    }
    
}
