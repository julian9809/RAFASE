/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author danie
 */
public class TarjetaCredito {
    
    private String nombreTitular;
    private long numeroTarjeta;
    private String fechaExp;
    private String tipoID;
    private long idCedula;
    
    private ArrayList<String> nombreTitularArray = new ArrayList<>();
    private ArrayList<Long> numeroTarjetaArray = new ArrayList<>();;
    private ArrayList<String> fechaExpArray = new ArrayList<>();;
    private ArrayList<String> tipoIDArray = new ArrayList<>();;
    private ArrayList<Long> idCedulaArray = new ArrayList<>();;

    public TarjetaCredito() {}

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public long getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(long numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getFechaExp() {
        return fechaExp;
    }

    public void setFechaExp(String fechaExp) {
        this.fechaExp = fechaExp;
    }

    public String getTipoID() {
        return tipoID;
    }

    public void setTipoID(String tipoID) {
        this.tipoID = tipoID;
    }

    public long getIdCedula() {
        return idCedula;
    }

    public void setIdCedula(long idCedula) {
        this.idCedula = idCedula;
    }

    public ArrayList<String> getNombreTitularArray() {
        return nombreTitularArray;
    }

    public void setNombreTitularArray(ArrayList<String> nombreTitularArray) {
        this.nombreTitularArray = nombreTitularArray;
    }

    public ArrayList<Long> getNumeroTarjetaArray() {
        return numeroTarjetaArray;
    }

    public void setNumeroTarjetaArray(ArrayList<Long> numeroTarjetaArray) {
        this.numeroTarjetaArray = numeroTarjetaArray;
    }

    public ArrayList<String> getFechaExpArray() {
        return fechaExpArray;
    }

    public void setFechaExpArray(ArrayList<String> fechaExpArray) {
        this.fechaExpArray = fechaExpArray;
    }

    public ArrayList<String> getTipoIDArray() {
        return tipoIDArray;
    }

    public void setTipoIDArray(ArrayList<String> tipoIDArray) {
        this.tipoIDArray = tipoIDArray;
    }

    public ArrayList<Long> getIdCedulaArray() {
        return idCedulaArray;
    }

    public void setIdCedulaArray(ArrayList<Long> idCedulaArray) {
        this.idCedulaArray = idCedulaArray;
    }
            
    
}
