/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author julia
 */
public class Categoria {
    private double id_categoria;
    private String nombre_categoria;
    private String descripcion_categoria;
    
    private ArrayList<Double> id_categoria_array = new ArrayList<>();
    private ArrayList<String> nombre_categoria_array = new ArrayList<>();
    private ArrayList<String> descripcion_categoria_array = new ArrayList<>();
    
    public Categoria(){
        
    }

    public double getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(double id_categoria) {
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

    public ArrayList<Double> getId_categoria_array() {
        return id_categoria_array;
    }

    public void setId_categoria_array(ArrayList<Double> id_categoria_array) {
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
    
}
