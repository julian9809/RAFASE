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
public class Ciudad {
    
    private long id_ciudad;
    private String nombre;
    private Long id_tienda;
    
    private ArrayList<Long> id_ciudad_array = new ArrayList<>();
    private ArrayList<String> nombre_array = new ArrayList<>();
    private ArrayList<Long> id_tienda_array = new ArrayList<>();

    public Ciudad() {
    }

    public double getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(long id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getId_tienda() {
        return id_tienda;
    }

    public void setId_tienda(long id_tienda) {
        this.id_tienda = id_tienda;
    }

    public ArrayList<Long> getId_ciudad_array() {
        return id_ciudad_array;
    }

    public void setId_ciudad_array(ArrayList<Long> id_ciudad_array) {
        this.id_ciudad_array = id_ciudad_array;
    }

    public ArrayList<String> getNombre_array() {
        return nombre_array;
    }

    public void setNombre_array(ArrayList<String> nombre_array) {
        this.nombre_array = nombre_array;
    }

    public ArrayList<Long> getId_tienda_array() {
        return id_tienda_array;
    }

    public void setId_tienda_array(ArrayList<Long> id_tienda_array) {
        this.id_tienda_array = id_tienda_array;
    }
    
    
    
}
