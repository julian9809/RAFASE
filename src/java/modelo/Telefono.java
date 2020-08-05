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
public class Telefono {
 
    private long numeroTelefono;
    private String enUso;
    private long idCedula;
    private String tipoID;
    
    private ArrayList<Long> numeroTelefonoArray = new ArrayList<>();
    private ArrayList<String> enUsoArray = new ArrayList<>();
    private ArrayList<Long> idCedulaArray = new ArrayList<>();
    private ArrayList<String> tipoIDArray = new ArrayList<>();

    public Telefono() {}

    public long getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(long numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getEnUso() {
        return enUso;
    }

    public void setEnUso(String enUso) {
        this.enUso = enUso;
    }

    public long getIdCedula() {
        return idCedula;
    }

    public void setIdCedula(long idCedula) {
        this.idCedula = idCedula;
    }

    public String getTipoID() {
        return tipoID;
    }

    public void setTipoID(String tipoID) {
        this.tipoID = tipoID;
    }

    public ArrayList<Long> getNumeroTelefonoArray() {
        return numeroTelefonoArray;
    }

    public void setNumeroTelefonoArray(ArrayList<Long> numeroTelefonoArray) {
        this.numeroTelefonoArray = numeroTelefonoArray;
    }

    public ArrayList<String> getEnUsoArray() {
        return enUsoArray;
    }

    public void setEnUsoArray(ArrayList<String> enUsoArray) {
        this.enUsoArray = enUsoArray;
    }

    public ArrayList<Long> getIdCedulaArray() {
        return idCedulaArray;
    }

    public void setIdCedulaArray(ArrayList<Long> idCedulaArray) {
        this.idCedulaArray = idCedulaArray;
    }

    public ArrayList<String> getTipoIDArray() {
        return tipoIDArray;
    }

    public void setTipoIDArray(ArrayList<String> tipoIDArray) {
        this.tipoIDArray = tipoIDArray;
    }
    
}
