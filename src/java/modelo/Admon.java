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
    
    private String nombreProductoMasVendido;
    private Long cantidadProductoMasVendido;
    
    private String nombreProductoMenosVendido;
    private Long cantidadProductoMenosVendido;
    
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private Long cantidadCompras;
    
    private ArrayList<String> nombreProductoMasVendidoArray = new ArrayList<>();
    private ArrayList<Long> cantidadProductoMasVendidoArray = new ArrayList<>();
    
    private ArrayList<String> nombreProductoMenosVendidoArray = new ArrayList<>();
    private ArrayList<Long> cantidadProductoMenosVendidoArray = new ArrayList<>();
    
    private ArrayList<String> primerNombreArray = new ArrayList<>();
    private ArrayList<String> segundoNombreArray = new ArrayList<>();
    private ArrayList<String> primerApellidoArray = new ArrayList<>();
    private ArrayList<String> segundoApellidoArray = new ArrayList<>();
    private ArrayList<Long> cantidadComprasArray = new ArrayList<>();
    
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

    public String getNombreProductoMasVendido() {
        return nombreProductoMasVendido;
    }

    public void setNombreProductoMasVendido(String nombreProductoMasVendido) {
        this.nombreProductoMasVendido = nombreProductoMasVendido;
    }

    public Long getCantidadProductoMasVendido() {
        return cantidadProductoMasVendido;
    }

    public void setCantidadProductoMasVendido(Long cantidadProductoMasVendido) {
        this.cantidadProductoMasVendido = cantidadProductoMasVendido;
    }

    public String getNombreProductoMenosVendido() {
        return nombreProductoMenosVendido;
    }

    public void setNombreProductoMenosVendido(String nombreProductoMenosVendido) {
        this.nombreProductoMenosVendido = nombreProductoMenosVendido;
    }

    public Long getCantidadProductoMenosVendido() {
        return cantidadProductoMenosVendido;
    }

    public void setCantidadProductoMenosVendido(Long cantidadProductoMenosVendido) {
        this.cantidadProductoMenosVendido = cantidadProductoMenosVendido;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Long getCantidadCompras() {
        return cantidadCompras;
    }

    public void setCantidadCompras(Long cantidadCompras) {
        this.cantidadCompras = cantidadCompras;
    }

    public ArrayList<String> getNombreProductoMasVendidoArray() {
        return nombreProductoMasVendidoArray;
    }

    public void setNombreProductoMasVendidoArray(ArrayList<String> nombreProductoMasVendidoArray) {
        this.nombreProductoMasVendidoArray = nombreProductoMasVendidoArray;
    }

    public ArrayList<Long> getCantidadProductoMasVendidoArray() {
        return cantidadProductoMasVendidoArray;
    }

    public void setCantidadProductoMasVendidoArray(ArrayList<Long> cantidadProductoMasVendidoArray) {
        this.cantidadProductoMasVendidoArray = cantidadProductoMasVendidoArray;
    }

    public ArrayList<String> getNombreProductoMenosVendidoArray() {
        return nombreProductoMenosVendidoArray;
    }

    public void setNombreProductoMenosVendidoArray(ArrayList<String> nombreProductoMenosVendidoArray) {
        this.nombreProductoMenosVendidoArray = nombreProductoMenosVendidoArray;
    }

    public ArrayList<Long> getCantidadProductoMenosVendidoArray() {
        return cantidadProductoMenosVendidoArray;
    }

    public void setCantidadProductoMenosVendidoArray(ArrayList<Long> cantidadProductoMenosVendidoArray) {
        this.cantidadProductoMenosVendidoArray = cantidadProductoMenosVendidoArray;
    }

    public ArrayList<String> getPrimerNombreArray() {
        return primerNombreArray;
    }

    public void setPrimerNombreArray(ArrayList<String> primerNombreArray) {
        this.primerNombreArray = primerNombreArray;
    }

    public ArrayList<String> getSegundoNombreArray() {
        return segundoNombreArray;
    }

    public void setSegundoNombreArray(ArrayList<String> segundoNombreArray) {
        this.segundoNombreArray = segundoNombreArray;
    }

    public ArrayList<String> getPrimerApellidoArray() {
        return primerApellidoArray;
    }

    public void setPrimerApellidoArray(ArrayList<String> primerApellidoArray) {
        this.primerApellidoArray = primerApellidoArray;
    }

    public ArrayList<String> getSegundoApellidoArray() {
        return segundoApellidoArray;
    }

    public void setSegundoApellidoArray(ArrayList<String> segundoApellidoArray) {
        this.segundoApellidoArray = segundoApellidoArray;
    }

    public ArrayList<Long> getCantidadComprasArray() {
        return cantidadComprasArray;
    }

    public void setCantidadComprasArray(ArrayList<Long> cantidadComprasArray) {
        this.cantidadComprasArray = cantidadComprasArray;
    }
    
    
}
