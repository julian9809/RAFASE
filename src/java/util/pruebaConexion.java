/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import control.DAOFacade;
import java.sql.Date;
import java.time.LocalDate;
import modelo.Direccion;
import modelo.TarjetaCredito;
import modelo.Telefono;

/**
 *
 * @author julia
 */
public class pruebaConexion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws CaException {
        
        //DIRECCIONES
        
        /*
        //Insercion de direcciones
        DAOFacade facade = new DAOFacade();
        Direccion dir = facade.getDireccion();
        dir.setDireccion_completa(direccioncompleta);
        dir.setTipo_direccion(R,E,N);
        dir.setId_ciudad(idciudad);
        dir.setId_cedula(facade.buscarIdCliente(usuario, contraseña));
        dir.setTipo_id(facade.buscarTipoID(usuario, contraseña));
        facade.insertarDireccion(usuario, contraseña);
        */
        
        /*
        //Listado de direcciones
        DAOFacade facade = new DAOFacade();
        facade.buscarDirecciones(usuario, contraseña, facade.buscarIdCliente(usuario, contraseña));
        for(int i=0;i < facade.getDireccion().getDireccion_completa_array().size();i++){
            System.out.println(facade.getDireccion().getDireccion_completa_array().get(i));
        }*/
        
        //TELEFONOS
        
        /*
        //Insercion de telefonos
        DAOFacade facade = new DAOFacade();
        Telefono tel = facade.getTelefono();
        tel.setNumeroTelefono(telefono);
        tel.setEnUso(S,N);
        tel.setIdCedula(facade.buscarIdCliente(usuario, contraseña));
        tel.setTipoID(facade.buscarTipoID(usuario, contraseña));
        facade.insertarTelefono(usuario, contraseña);
        */
        
        /*
        //Listado de telefonos
        DAOFacade facade = new DAOFacade();
        facade.buscarTelefono("", "", facade.buscarIdCliente("Papas338", ""));
        for(int i=0;i < facade.getTelefono().getNumeroTelefonoArray().size();i++){
            System.out.println(facade.getTelefono().getNumeroTelefonoArray().get(i));
        }*/
        
        //TARJETA DE CREDITO
        
        /*
        //Insercion de tarjetas
        DAOFacade facade = new DAOFacade();
        TarjetaCredito tc = facade.getTarjetaCredito();
        tc.setNombreTitular(nombre titular);
        tc.setNumeroTarjeta(numero tarjeta);
        tc.setFechaExp(fecha);
        tc.setTipoID(facade.buscarTipoID(usuario, contraseña));
        tc.setIdCedula(facade.buscarIdCliente(usuario, contraseña));
        
        facade.insertarTarjetaCredito(usuario, contraseña);
        */
        
        /*
        //Listado de tarjetas
        DAOFacade facade = new DAOFacade();
        facade.buscarTarjetaCredito(usuario, contraseña, facade.buscarIdCliente(usuario, contraseña));
        for(int i=0;i < facade.getTarjetaCredito().getNombreTitularArray().size();i++){
            System.out.println(facade.getTarjetaCredito().getNombreTitularArray().get(i));
            System.out.println(facade.getTarjetaCredito().getNumeroTarjetaArray().get(i));
            System.out.println(facade.getTarjetaCredito().getFechaExpArray().get(i));
        }
        */
    }
    
}
