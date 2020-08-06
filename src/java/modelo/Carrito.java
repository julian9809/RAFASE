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
    private long id_ciudad;
    private String nombre_ciudad;
    private long id_pedido;
    private long id_categoria;
    private String nombre_categoria;
    private String descripcion_categoria;
    private long id_subcategoria;
    private String nombre_subcategoria;
    private long id_producto;
    private String nombre_producto;
    private String marca_producto;
    private long cantidad;
    private double precio_base;
    private double iva;
    private String foto;
    
    private ArrayList<Long> id_ciudad_array = new ArrayList<>();
    private ArrayList<String> nombre_ciudad_array = new ArrayList<>();
    private ArrayList<Long> id_pedido_array = new ArrayList<>();
    private ArrayList<Long> id_categoria_array = new ArrayList<>();
    private ArrayList<String> nombre_categoria_array = new ArrayList<>();
    private ArrayList<String> descripcion_categoria_array = new ArrayList<>();
    private ArrayList<Long> id_subcategoria_array = new ArrayList<>();
    private ArrayList<String> nombre_subcategoria_array = new ArrayList<>();
    private ArrayList<Long> id_producto_array = new ArrayList<>();
    private ArrayList<String> nombre_producto_array = new ArrayList<>();
    private ArrayList<String> marca_producto_array = new ArrayList<>();
    private ArrayList<Long> cantidad_array = new ArrayList<>();
    private ArrayList<Double> precio_base_array = new ArrayList<>();
    private ArrayList<Double> iva_array = new ArrayList<>();
    private ArrayList<String> foto_array = new ArrayList<>();
    
    public Carrito(){
        
    }

    public long getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(long id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public String getNombre_ciudad() {
        return nombre_ciudad;
    }

    public void setNombre_ciudad(String nombre_ciudad) {
        this.nombre_ciudad = nombre_ciudad;
    }

    public long getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(long id_pedido) {
        this.id_pedido = id_pedido;
    }

    public long getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(long id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    public String getDescripcion_categoria() {
        return descripcion_categoria;
    }

    public void setDescripcion_categoria(String descripcion_categoria) {
        this.descripcion_categoria = descripcion_categoria;
    }

    public long getId_subcategoria() {
        return id_subcategoria;
    }

    public void setId_subcategoria(long id_subcategoria) {
        this.id_subcategoria = id_subcategoria;
    }

    public String getNombre_subcategoria() {
        return nombre_subcategoria;
    }

    public void setNombre_subcategoria(String nombre_subcategoria) {
        this.nombre_subcategoria = nombre_subcategoria;
    }

    public long getId_producto() {
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

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_base() {
        return precio_base;
    }

    public void setPrecio_base(double precio_base) {
        this.precio_base = precio_base;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public ArrayList<Long> getId_ciudad_array() {
        return id_ciudad_array;
    }

    public void setId_ciudad_array(ArrayList<Long> id_ciudad_array) {
        this.id_ciudad_array = id_ciudad_array;
    }

    public ArrayList<String> getNombre_ciudad_array() {
        return nombre_ciudad_array;
    }

    public void setNombre_ciudad_array(ArrayList<String> nombre_ciudad_array) {
        this.nombre_ciudad_array = nombre_ciudad_array;
    }

    public ArrayList<Long> getId_pedido_array() {
        return id_pedido_array;
    }

    public void setId_pedido_array(ArrayList<Long> id_pedido_array) {
        this.id_pedido_array = id_pedido_array;
    }

    public ArrayList<Long> getId_categoria_array() {
        return id_categoria_array;
    }

    public void setId_categoria_array(ArrayList<Long> id_categoria_array) {
        this.id_categoria_array = id_categoria_array;
    }

    public ArrayList<String> getNombre_categoria_array() {
        return nombre_categoria_array;
    }

    public void setNombre_categoria_array(ArrayList<String> nombre_categoria_array) {
        this.nombre_categoria_array = nombre_categoria_array;
    }

    public ArrayList<String> getDescripcion_categoria_array() {
        return descripcion_categoria_array;
    }

    public void setDescripcion_categoria_array(ArrayList<String> descripcion_categoria_array) {
        this.descripcion_categoria_array = descripcion_categoria_array;
    }

    public ArrayList<Long> getId_subcategoria_array() {
        return id_subcategoria_array;
    }

    public void setId_subcategoria_array(ArrayList<Long> id_subcategoria_array) {
        this.id_subcategoria_array = id_subcategoria_array;
    }

    public ArrayList<String> getNombre_subcategoria_array() {
        return nombre_subcategoria_array;
    }

    public void setNombre_subcategoria_array(ArrayList<String> nombre_subcategoria_array) {
        this.nombre_subcategoria_array = nombre_subcategoria_array;
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

    public ArrayList<Long> getCantidad_array() {
        return cantidad_array;
    }

    public void setCantidad_array(ArrayList<Long> cantidad_array) {
        this.cantidad_array = cantidad_array;
    }

    public ArrayList<Double> getPrecio_base_array() {
        return precio_base_array;
    }

    public void setPrecio_base_array(ArrayList<Double> precio_base_array) {
        this.precio_base_array = precio_base_array;
    }

    public ArrayList<Double> getIva_array() {
        return iva_array;
    }

    public void setIva_array(ArrayList<Double> iva_array) {
        this.iva_array = iva_array;
    }

    public ArrayList<String> getFoto_array() {
        return foto_array;
    }

    public void setFoto_array(ArrayList<String> foto_array) {
        this.foto_array = foto_array;
    }

}
