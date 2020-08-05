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
import modelo.Direccion;
import modelo.InventarioRafase;
import modelo.Producto;
import modelo.Pedido;
import modelo.TarjetaCredito;
import modelo.Telefono;
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
    public boolean buscarExisteCliente(String usuario, String password, String nickname) throws CaException {
        return clienteDAO.buscarExisteCliente(usuario, password, nickname);
    }
    
    public boolean buscarExisteCliente(String usuario, String password, String nickname, String userPassword) throws CaException {
        return clienteDAO.buscarExisteCliente(usuario, password, nickname, userPassword);
    }

    public void insertarDireccion(String usuario, String password) throws CaException {
        clienteDAO.insertarDireccion(usuario, password);
    }

    public void buscarDireccionResidencia(String usuario, String password, String tipo, long cedula) throws CaException {
        clienteDAO.buscarDireccionResidencia(usuario, password, tipo, cedula);
    }
    
    public void buscarDireccionEnvio(String usuario, String password, String tipo, long cedula) throws CaException {
        clienteDAO.buscarDireccionEnvio(usuario, password, tipo, cedula);
    }
    
    public void insertarTelefono(String usuario, String password) throws CaException {
        clienteDAO.insertarTelefono(usuario, password);
    }

    public void buscarTelefono(String usuario, String password, long cedula) throws CaException {
        clienteDAO.buscarTelefono(usuario, password, cedula);
    }
    
    public void insertarTarjetaCredito(String usuario, String password) throws CaException {
        clienteDAO.insertarTarjetaCredito(usuario, password);
    }

    public void buscarTarjetaCredito(String usuario, String password, long cedula) throws CaException {
        clienteDAO.buscarTarjetaCredito(usuario, password, cedula);
    }

    public void crearUsuario() throws CaException {
        clienteDAO.crearUsuario();
    }

    public long buscarIdCliente(String usuario, String password) throws CaException {
        return clienteDAO.buscarIdCliente(usuario, password);
    }
    
    public String buscarTipoID(String usuario, String password) throws CaException{
        return clienteDAO.buscarTipoID(usuario, password);
    }
    
    //---------------------------------PedidoDAO--------------------------------
    public void consultarPedido(String usuario, long usuario_id) throws CaException{
        pedidoDAO.consultarPedido(usuario, usuario_id);
    }

    public boolean existeCarrito(String nickname, String password, long usuario_id) throws CaException{
        return pedidoDAO.existeCarrito(nickname, password, usuario_id);
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
    
    public Direccion getDireccion(){
        return clienteDAO.getDireccion();
    }
    
    public Direccion getDireccionEnvio(){
        return clienteDAO.getDireccionEnvio();
    }
    
    public Telefono getTelefono(){
        return clienteDAO.getTelefono();
    }
    
    public TarjetaCredito getTarjetaCredito(){
        return clienteDAO.getTarjetaCredito();
    }
}
