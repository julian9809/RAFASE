/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
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
    public static void main(String[] args) {
        // TODO code application logic here
        String usuario = "admin_db";
        String password = "dbadministrator";
        System.out.println("esta corriendo");
        Connection conexion = ServiceLocator.getInstance(usuario,password).tomarConexion();
        System.out.println("hola()");
        System.out.println("Termino de correr");
    }
    
}
