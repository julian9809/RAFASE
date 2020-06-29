/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import control.ClienteDAO;
import control.PedidoDAO;
import java.sql.Connection;
import java.util.ArrayList;
import modelo.Carrito;
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
        ClienteDAO clienteDAO = new ClienteDAO(); 
        PedidoDAO pedidoDAO = new PedidoDAO();
        ArrayList<Carrito> carrito = new ArrayList<Carrito>();
        carrito = pedidoDAO.consultarCarrito("generico");
        for(int i = 0;i<carrito.size();i++){
            System.out.println(carrito.get(i).getNombreProducto());
        }
    }
    
}
