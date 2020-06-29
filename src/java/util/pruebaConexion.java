/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import control.ClienteDAO;
import java.sql.Connection;
import util.ServiceLocator;

/**
 *
 * @author julia
 */
public class pruebaConexion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws CaException {
        // TODO code application logic here
        ClienteDAO cliente = new ClienteDAO(); 
        System.out.println(cliente.buscarIdCliente("yami", "1234"));
    }
    
}
