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
public class Admon {
    private long id_administrador;
    private String nombre_completo;
    private String correo;
    private String contraseña;
    
    private ArrayList<Long> id_administrador_array = new ArrayList<>();
    private ArrayList<String> nombre_completo_array = new ArrayList<>();
    private ArrayList<String> correo_array = new ArrayList<>();
    private ArrayList<String> contraseña_array = new ArrayList<>();

    public Admon() {
    }

    public long getId_administrador() {
        return id_administrador;
    }

    public void setId_administrador(long id_administrador) {
        this.id_administrador = id_administrador;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public ArrayList<Long> getId_administrador_array() {
        return id_administrador_array;
    }

    public void setId_administrador_array(ArrayList<Long> id_administrador_array) {
        this.id_administrador_array = id_administrador_array;
    }

    public ArrayList<String> getNombre_completo_array() {
        return nombre_completo_array;
    }

    public void setNombre_completo_array(ArrayList<String> nombre_completo_array) {
        this.nombre_completo_array = nombre_completo_array;
    }

    public ArrayList<String> getCorreo_array() {
        return correo_array;
    }

    public void setCorreo_array(ArrayList<String> correo_array) {
        this.correo_array = correo_array;
    }

    public ArrayList<String> getContraseña_array() {
        return contraseña_array;
    }

    public void setContraseña_array(ArrayList<String> contraseña_array) {
        this.contraseña_array = contraseña_array;
    }   
    
}
