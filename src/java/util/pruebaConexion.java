/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import control.DAOFacade;
import java.sql.Date;
import java.time.LocalDate;
import modelo.Carrito;
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
        
        //Conexion de las pruebas
        facade.realizarConexion();
        facade.cerrarConexion();
        facade.nombreUsuario("yami");
        facade.passwordUsuario("abc123");
        facade.realizarConexion();
        
        //facade.nombreUsuario(username);
        //facade.passwordUsuario(password);
        facade.realizarConexion();
        
        
        Carrito carrito = facade.getCarrito();
        facade.consultarCarrito("yami", 1);
        System.out.println("aqui llego");
        double total = facade.obtenerTotalPedido(carrito.getId_pedido_array().get(0));
        System.out.println("total: "+total);
        /*
        //Pago del pedido y simulación del banco
        facade.actualizarEstadoPedido(pedido_id, facade.obtenerTotalPedido(22));
        boolean recibido = facade.confirmarTajertaConBanco(numero de la tarjeta, cvv, fecha en String MM/YY, pedido_id);
        */
    }
    
}
