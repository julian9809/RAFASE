/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import modelo.Carrito;
import modelo.Ciudad;
import modelo.Cliente;
import modelo.DetallePedido;
import modelo.InventarioRafase;
import modelo.Producto;
import modelo.Pedido;
import util.CaException;

/**
 *
 * @author danie
 */
public class DAOFacade {

    private CiudadDAO ciudadDAO;
    private ClienteDAO clienteDAO;
    private PedidoDAO pedidoDAO;
    private ProductosDAO productosDAO;

    public DAOFacade() {
        ciudadDAO = new CiudadDAO();
        clienteDAO = new ClienteDAO();
        pedidoDAO = new PedidoDAO();
        productosDAO = new ProductosDAO();
    }
    
    //---------------------------------CiudadDAO--------------------------------
    public void buscarCiudades(String nickname, String userPassword) throws CaException {
        ciudadDAO.buscarCiudades(nickname, userPassword);
    }
    
    //--------------------------------ClienteDAO--------------------------------
    public void insertarCliente() throws CaException {
        clienteDAO.insertarCliente();
    }

    public boolean buscarExisteCliente(String usuario, String password, String nickname) throws CaException {
        return clienteDAO.buscarExisteCliente(usuario, password, nickname);
    }
    
    public boolean buscarExisteCliente(String usuario, String password, String nickname, String userPassword) throws CaException {
        return clienteDAO.buscarExisteCliente(usuario, password, nickname, userPassword);
    }

    public void insertarDireccion(String usuario, String password) throws CaException {
        clienteDAO.insertarDireccion(usuario, password);
    }

    public void buscarDirecciones(String usuario, String password, long cedula) throws CaException {
        clienteDAO.buscarDirecciones(usuario, password, cedula);
    }

    public void crearUsuario(String usuario, String password) throws CaException {
        clienteDAO.crearUsuario(usuario, password);
    }

    public long buscarIdCliente(String usuario, String password) throws CaException {
        return clienteDAO.buscarIdCliente(usuario, password);
    }
    
    //---------------------------------PedidoDAO--------------------------------
    public void consultarPedido(String usuario, long usuario_id) throws CaException{
        pedidoDAO.consultarPedido(usuario, usuario_id);
    }

    public boolean consultarPedidos(String nickname, String password, long usuario_id) throws CaException{
        return pedidoDAO.consultarPedidos(nickname, password, usuario_id);
    }

    public void insertarPedido(String usuario, Pedido ped) throws CaException{
        pedidoDAO.insertarPedido(usuario, ped);
    }

    public void insertarProductosPedido(String usuario, DetallePedido deped) throws CaException{
        pedidoDAO.insertarProductosPedido(usuario, deped);
    }

    public void consultarProductosPedido(String usuario, String password, DetallePedido deped) throws CaException{
        pedidoDAO.consultarProductosPedido(usuario, password, deped);
    }

    public void crearCarrito(String usuario, long cedula) throws CaException{
        pedidoDAO.crearCarrito(usuario, cedula);
    }

    public void consultarCarrito(String usuario) throws CaException{
        pedidoDAO.consultarCarrito(usuario);
    }

    public boolean verificarExistencia(double id_pedido, double id_producto) throws CaException{
        return pedidoDAO.verificarExistencia(id_pedido, id_producto);
    }

    public void actualizarCantidad(double id_pedido, double id_producto) throws CaException{
        pedidoDAO.actualizarCantidad(id_pedido, id_producto);
    }
    
    //-------------------------------ProductoDAO--------------------------------
    public void buscarProducto(String usuario, String password,
            String producto_buscado, String ciudad,
            String subcategoria_buscada, String categoria_buscada) throws CaException {
        productosDAO.buscarProducto(usuario, password, producto_buscado,
                ciudad,subcategoria_buscada,categoria_buscada);
    }
    
    public Cliente getCliente(){
        return clienteDAO.getCliente();
    }
    
    public Producto getProducto(){
        return productosDAO.getProducto();
    }
    
    public InventarioRafase getInventario_rafase() {
        return productosDAO.getInventario_rafase();
    }
    
    public Ciudad getCiudad(){
        return ciudadDAO.getCiudad();
    }
    
}
