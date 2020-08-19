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
public class Proveedor {
    private Long id_proveedor;
    private String nombre;
    private String dirección;
    
    private ArrayList<Long> id_proveedor_array = new ArrayList<>();
    private ArrayList<String> nombre_array = new ArrayList<>();
    private ArrayList<String> direccion_array = new ArrayList<>();

    public Proveedor() {
    }   

    public Long getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(Long id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    public ArrayList<Long> getId_proveedor_array() {
        return id_proveedor_array;
    }

    public void setId_proveedor_array(ArrayList<Long> id_proveedor_array) {
        this.id_proveedor_array = id_proveedor_array;
    }

    public ArrayList<String> getNombre_array() {
        return nombre_array;
    }

    public void setNombre_array(ArrayList<String> nombre_array) {
        this.nombre_array = nombre_array;
    }

    public ArrayList<String> getDireccion_array() {
        return direccion_array;
    }

    public void setDireccion_array(ArrayList<String> direccion_array) {
        this.direccion_array = direccion_array;
    }    
    
}
