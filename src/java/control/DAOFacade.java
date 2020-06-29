/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import modelo.Cliente;
import modelo.Producto;
import util.CaException;

/**
 *
 * @author danie
 */
public class DAOFacade {
    private ClienteDAO clienteDAO;
    private PedidoDAO pedidoDAO;
    private ProductosDAO productosDAO;
    
    private String usuario, password;
    
    public DAOFacade(String usuario, String password){
        this.usuario = usuario;
        this.password = password;
        
        clienteDAO = new ClienteDAO();
        pedidoDAO = new PedidoDAO();
        productosDAO = new ProductosDAO();
    }
    
    public void insertarCliente() throws CaException {
        //clienteDAO.insertarCliente(usuario, password,);
    }
    
    public boolean iniciarSesion(String nickname, String userPassword) throws CaException{
        return clienteDAO.iniciarSesion(usuario, password, nickname, userPassword);
    }
    
    public ArrayList<Producto> buscarProducto(String producto_buscado) throws CaException {
        return productosDAO.buscarProducto(usuario, password, producto_buscado);
    }
    
    public void insertarDireccion() throws CaException{
        clienteDAO.insertarDireccion(usuario, password);
    }
}
