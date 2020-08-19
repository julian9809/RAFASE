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
        //Insercion de direcciones
        DAOFacade facade = new DAOFacade();

        facade.realizarConexion();
        //Conexion de las pruebas
        facade.cerrarConexion();
        facade.setearAdminDB();
        facade.realizarConexion();

        //facade.nombreUsuario(username);
        //facade.passwordUsuario(password);
        facade.actualizarEstadoPedido(23, facade.obtenerTotalPedido(23));
        boolean recibido = facade.confirmarTajertaConBanco(Long.parseLong("761373757573"), 789, "07/23", 23);
    }

}
