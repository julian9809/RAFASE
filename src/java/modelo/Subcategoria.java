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
public class Subcategoria {
    private double id_subcategoria;
    private String nombre_subcategoria;
    private double id_categoria;
    
    private ArrayList<Double> id_subcategoria_array = new ArrayList<>();
    private ArrayList<String> nombre_subcategoria_array = new ArrayList<>();
    private ArrayList<Double> id_categoria_array = new ArrayList<>();
    
    public Subcategoria(){
        
    }

    public double getId_subcategoria() {
        return id_subcategoria;
    }

    public void setId_subcategoria(double id_subcategoria) {
        this.id_subcategoria = id_subcategoria;
    }

    public String getNombre_subcategoria() {
        return nombre_subcategoria;
    }

    public void setNombre_subcategoria(String nombre_subcategoria) {
        this.nombre_subcategoria = nombre_subcategoria;
    }

    public double getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(double id_categoria) {
        this.id_categoria = id_categoria;
    }

    public ArrayList<Double> getId_subcategoria_array() {
        return id_subcategoria_array;
    }

    public void setId_subcategoria_array(ArrayList<Double> id_subcategoria_array) {
        this.id_subcategoria_array = id_subcategoria_array;
    }

    public ArrayList<String> getNombre_subcategoria_array() {
        return nombre_subcategoria_array;
    }

    public void setNombre_subcategoria_array(ArrayList<String> nombre_subcategoria_array) {
        this.nombre_subcategoria_array = nombre_subcategoria_array;
    }

    public ArrayList<Double> getId_categoria_array() {
        return id_categoria_array;
    }

    public void setId_categoria_array(ArrayList<Double> id_categoria_array) {
        this.id_categoria_array = id_categoria_array;
    }
    
}
