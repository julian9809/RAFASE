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
public class Direccion {
    private long id_direccion;
    private String direccion_completa;
    private String extras;
    private String tipo_direccion;
    private long id_ciudad;
    private long id_cedula;
    private String tipo_id;
    
    private ArrayList<Long> id_direccion_array = new ArrayList<>();
    private ArrayList<String> direccion_completa_array = new ArrayList<>();
    private ArrayList<String> extras_array = new ArrayList<>();
    private ArrayList<String> tipo_direccion_array = new ArrayList<>();
    private ArrayList<Long> id_ciudad_array = new ArrayList<>();
    private ArrayList<Long> id_cedula_array = new ArrayList<>();
    private ArrayList<String> tipo_id_array = new ArrayList<>();
    
    public Direccion(){}

    public long getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(long id_direccion) {
        this.id_direccion = id_direccion;
    }

    public String getDireccion_completa() {
        return direccion_completa;
    }

    public void setDireccion_completa(String direccion_completa) {
        this.direccion_completa = direccion_completa;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public String getTipo_direccion() {
        return tipo_direccion;
    }

    public void setTipo_direccion(String tipo_direccion) {
        this.tipo_direccion = tipo_direccion;
    }

    public long getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(long id_ciudad) {
        this.id_ciudad = id_ciudad;
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

    public ArrayList<Long> getId_direccion_array() {
        return id_direccion_array;
    }

    public void setId_direccion_array(ArrayList<Long> id_direccion_array) {
        this.id_direccion_array = id_direccion_array;
    }

    public ArrayList<String> getDireccion_completa_array() {
        return direccion_completa_array;
    }

    public void setDireccion_completa_array(ArrayList<String> direccion_completa_array) {
        this.direccion_completa_array = direccion_completa_array;
    }

    public ArrayList<String> getExtras_array() {
        return extras_array;
    }

    public void setExtras_array(ArrayList<String> extras_array) {
        this.extras_array = extras_array;
    }

    public ArrayList<String> getTipo_direccion_array() {
        return tipo_direccion_array;
    }

    public void setTipo_direccion_array(ArrayList<String> tipo_direccion_array) {
        this.tipo_direccion_array = tipo_direccion_array;
    }

    public ArrayList<Long> getId_ciudad_array() {
        return id_ciudad_array;
    }

    public void setId_ciudad_array(ArrayList<Long> id_ciudad_array) {
        this.id_ciudad_array = id_ciudad_array;
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
    
}
