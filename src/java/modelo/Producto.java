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
public class Producto {
    private long id_producto;
    private String nombre_producto;
    private String marca_producto;
    private String referencia_producto;
    private String caracteristicas_producto;
    private String foto;
    private double id_subcategoria;
    private double iva;
    private String unidad_medida;
    
    private ArrayList<Long> id_producto_array = new ArrayList<>();
    private ArrayList<String> nombre_producto_array = new ArrayList<>();
    private ArrayList<String> marca_producto_array = new ArrayList<>();
    private ArrayList<String> referencia_producto_array = new ArrayList<>();
    private ArrayList<String> caracteristicas_producto_array = new ArrayList<>();
    private ArrayList<String> foto_array = new ArrayList<>();
    private ArrayList<Double> id_subcategoria_array = new ArrayList<>();
    private ArrayList<Double> iva_array = new ArrayList<>();
    private ArrayList<String> unidad_medida_array = new ArrayList<>();
    
    public Producto(){
        
    }

    public double getId_producto() {
        return id_producto;
    }

    public void setId_producto(long id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getMarca_producto() {
        return marca_producto;
    }

    public void setMarca_producto(String marca_producto) {
        this.marca_producto = marca_producto;
    }

    public String getReferencia_producto() {
        return referencia_producto;
    }

    public void setReferencia_producto(String referencia_producto) {
        this.referencia_producto = referencia_producto;
    }

    public String getCaracteristicas_producto() {
        return caracteristicas_producto;
    }

    public void setCaracteristicas_producto(String caracteristicas_producto) {
        this.caracteristicas_producto = caracteristicas_producto;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public double getId_subcategoria() {
        return id_subcategoria;
    }

    public void setId_subcategoria(double id_subcategoria) {
        this.id_subcategoria = id_subcategoria;
    }

    public ArrayList<Long> getId_producto_array() {
        return id_producto_array;
    }

    public void setId_producto_array(ArrayList<Long> id_producto_array) {
        this.id_producto_array = id_producto_array;
    }

    public ArrayList<String> getNombre_producto_array() {
        return nombre_producto_array;
    }

    public void setNombre_producto_array(ArrayList<String> nombre_producto_array) {
        this.nombre_producto_array = nombre_producto_array;
    }

    public ArrayList<String> getMarca_producto_array() {
        return marca_producto_array;
    }

    public void setMarca_producto_array(ArrayList<String> marca_producto_array) {
        this.marca_producto_array = marca_producto_array;
    }

    public ArrayList<String> getReferencia_producto_array() {
        return referencia_producto_array;
    }

    public void setReferencia_producto_array(ArrayList<String> referencia_producto_array) {
        this.referencia_producto_array = referencia_producto_array;
    }

    public ArrayList<String> getCaracteristicas_producto_array() {
        return caracteristicas_producto_array;
    }

    public void setCaracteristicas_producto_array(ArrayList<String> caracteristicas_producto_array) {
        this.caracteristicas_producto_array = caracteristicas_producto_array;
    }

    public ArrayList<String> getFoto_array() {
        return foto_array;
    }

    public void setFoto_array(ArrayList<String> foto_array) {
        this.foto_array = foto_array;
    }

    public ArrayList<Double> getId_subcategoria_array() {
        return id_subcategoria_array;
    }

    public void setId_subcategoria_array(ArrayList<Double> id_subcategoria_array) {
        this.id_subcategoria_array = id_subcategoria_array;
    }

    public ArrayList<Double> getIva_array() {
        return iva_array;
    }

    public void setIva_array(ArrayList<Double> iva_array) {
        this.iva_array = iva_array;
    }

    public ArrayList<String> getUnidad_medida_array() {
        return unidad_medida_array;
    }

    public void setUnidad_medida_array(ArrayList<String> unidad_medida_array) {
        this.unidad_medida_array = unidad_medida_array;
    }
    
}


