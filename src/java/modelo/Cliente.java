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
public class Cliente {
    private long id_cedula;
    private String tipo_id;
    private String primer_nombre;
    private String segundo_nombre;
    private String primer_apellido;
    private String segundo_apellido;
    private String password;
    private Date fecha_nacimiento;
    private String genero;
    private String email;
    private String nickname;
    
    private ArrayList<Long> id_cedula_array = new ArrayList<>();
    private ArrayList<String> tipo_id_array = new ArrayList<>();
    private ArrayList<String> primer_nombre_array = new ArrayList<>();
    private ArrayList<String> segundo_nombre_array = new ArrayList<>();
    private ArrayList<String> primer_apellido_array = new ArrayList<>();
    private ArrayList<String> segundo_apellido_array = new ArrayList<>();
    private ArrayList<String> password_array = new ArrayList<>();
    private ArrayList<Date> fecha_nacimiento_array = new ArrayList<>();
    private ArrayList<String> genero_array = new ArrayList<>();    
    private ArrayList<String> email_array = new ArrayList<>();
    private ArrayList<String> nickname_array = new ArrayList<>();

    public Cliente(){}
    
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

    public String getPrimer_nombre() {
        return primer_nombre;
    }

    public void setPrimer_nombre(String primer_nombre) {
        this.primer_nombre = primer_nombre;
    }

    public String getSegundo_nombre() {
        return segundo_nombre;
    }

    public void setSegundo_nombre(String segundo_nombre) {
        this.segundo_nombre = segundo_nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public ArrayList<String> getPrimer_nombre_array() {
        return primer_nombre_array;
    }

    public void setPrimer_nombre_array(ArrayList<String> primer_nombre_array) {
        this.primer_nombre_array = primer_nombre_array;
    }

    public ArrayList<String> getSegundo_nombre_array() {
        return segundo_nombre_array;
    }

    public void setSegundo_nombre_array(ArrayList<String> segundo_nombre_array) {
        this.segundo_nombre_array = segundo_nombre_array;
    }

    public ArrayList<String> getPrimer_apellido_array() {
        return primer_apellido_array;
    }

    public void setPrimer_apellido_array(ArrayList<String> primer_apellido_array) {
        this.primer_apellido_array = primer_apellido_array;
    }

    public ArrayList<String> getSegundo_apellido_array() {
        return segundo_apellido_array;
    }

    public void setSegundo_apellido_array(ArrayList<String> segundo_apellido_array) {
        this.segundo_apellido_array = segundo_apellido_array;
    }

    public ArrayList<String> getPassword_array() {
        return password_array;
    }

    public void setPassword_array(ArrayList<String> password_array) {
        this.password_array = password_array;
    }

    public ArrayList<Date> getFecha_nacimiento_array() {
        return fecha_nacimiento_array;
    }

    public void setFecha_nacimiento_array(ArrayList<Date> fecha_nacimiento_array) {
        this.fecha_nacimiento_array = fecha_nacimiento_array;
    }

    public ArrayList<String> getGenero_array() {
        return genero_array;
    }

    public void setGenero_array(ArrayList<String> genero_array) {
        this.genero_array = genero_array;
    }

    public ArrayList<String> getEmail_array() {
        return email_array;
    }

    public void setEmail_array(ArrayList<String> email_array) {
        this.email_array = email_array;
    }

    public ArrayList<String> getNickname_array() {
        return nickname_array;
    }

    public void setNickname_array(ArrayList<String> nickname_array) {
        this.nickname_array = nickname_array;
    }
    
    
}
