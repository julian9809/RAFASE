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
public class Subcategoria {
    private double id_subcategoria;
    private String nombre_subcategoria;
    private double id_categoria;
    
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
    
    
}
