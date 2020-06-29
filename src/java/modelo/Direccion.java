/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author danie
 */
public class Direccion {
    private long id_direccion;
    private String direccion;
    private String extras;
    private String tipo_direccion;
    private long id_cedula;
    private long id_ciudad;
    
    public Direccion(){}

    public long getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(long id_direccion) {
        this.id_direccion = id_direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public long getId_cedula() {
        return id_cedula;
    }

    public void setId_cedula(long id_cedula) {
        this.id_cedula = id_cedula;
    }

    public long getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(long id_ciudad) {
        this.id_ciudad = id_ciudad;
    }
    
    
}
