/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author julia
 */
public class Producto {
    private double id_producto;
    private String nombre_producto;
    private String marca_producto;
    private String referencia_producto;
    private String caracteristicas_producto;
    private String foto;
    private double precio_base;
    private String unidad_medida;
    private double id_subcategoria;
    
    public Producto(){
        
    }

    public double getId_producto() {
        return id_producto;
    }

    public void setId_producto(double id_producto) {
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

    public double getPrecio_base() {
        return precio_base;
    }

    public void setPrecio_base(double precio_base) {
        this.precio_base = precio_base;
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
    
}


