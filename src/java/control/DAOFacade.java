/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import modelo.Admon;
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
import util.ServiceLocator;

/**
 *
 * @author danie
 */
public class DAOFacade {

    private CiudadDAO ciudadDAO;
    private ClienteDAO clienteDAO;
    private PedidoDAO pedidoDAO;
    private ProductosDAO productosDAO;
    private AdmonDAO admonDAO;
    private PagoDAO pagoDAO;

    public DAOFacade() {
        ciudadDAO = new CiudadDAO();
        clienteDAO = new ClienteDAO();
        pedidoDAO = new PedidoDAO();
        admonDAO = new AdmonDAO();
        productosDAO = new ProductosDAO();
        pagoDAO = new PagoDAO();
    }
    
    //-----------------------Conexión ServiceLocator----------------------------
    public boolean realizarConexion(){
        return ServiceLocator.getInstance().realizarConexion();
    }
    
    public void cerrarConexion(){
        ServiceLocator.getInstance().close();
    }
    
    public void nombreUsuario(String username){
        ServiceLocator.getInstance().setUsuario(username);
    }
    
    public void passwordUsuario(String password){
        ServiceLocator.getInstance().setPassword(password);
    }
    
    public void setearAdminDB(){
        ServiceLocator.getInstance().setUsuario("admin_db");
        ServiceLocator.getInstance().setPassword("dbadministrator");
    }
    
    //---------------------------------CiudadDAO--------------------------------
    public void buscarCiudades(String nickname, String userPassword) throws CaException {
        ciudadDAO.buscarCiudades(nickname, userPassword);
    }
    
    public long buscarIdCiudad(String usuario, String password, String nombre_ciudad) throws CaException {
        return ciudadDAO.buscarIdCiudad(usuario, password, nombre_ciudad);
    }
    //--------------------------------AdmonDAO----------------------------------
    public void buscarAdministradores(String nickname, String userPassword) throws CaException {
        admonDAO.buscarAdministradores(nickname, userPassword);
    }
    
    public boolean existeAdmin(String usuario) throws CaException {
        return admonDAO.existeAdmin(usuario);
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
    
    public void quitarTelefono(String usuario, String contraseña, long cedula, long telefono) throws CaException {
        clienteDAO.quitarTelefono(usuario, contraseña, cedula, telefono);
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
    
    public void buscarDatosCliente(String usuario, String password, long cedula) throws CaException {
        clienteDAO.buscarDatosCliente(usuario, password, cedula);
    }

    public long buscarIdCliente(String usuario, String password) throws CaException {
        return clienteDAO.buscarIdCliente(usuario, password);
    }
    
    public String buscarTipoID(String usuario, String password) throws CaException{
        return clienteDAO.buscarTipoID(usuario, password);
    }
    
    //---------------------------------PagoDAO----------------------------------
    
    public double obtenerTotalPedido(String usuario, long pedido_id) throws CaException {
        return pagoDAO.obtenerTotalPedido(usuario, pedido_id);
    }
    //---------------------------------PedidoDAO--------------------------------
    public void consultarPedido(String usuario, long usuario_id) throws CaException{
        pedidoDAO.consultarPedido(usuario, usuario_id);
    }
    
    public long consultarIdPedido(String usuario, long usuario_id) throws CaException {
        return pedidoDAO.consultarIdPedido(usuario, usuario_id);
    }

    public boolean existeCarrito(String nickname, String password, long usuario_id) throws CaException{
        return pedidoDAO.existeCarrito(nickname, password, usuario_id);
    }

    public void insertarPedido(String usuario) throws CaException{
        pedidoDAO.insertarPedido(usuario);
    }

    public void insertarProductosPedido(String usuario) throws CaException{
        pedidoDAO.insertarProductosPedido(usuario);
    }

    public void consultarProductosPedido(String usuario, String password, DetallePedido deped) throws CaException{
        pedidoDAO.consultarProductosPedido(usuario, password, deped);
    }

    public void crearCarrito(String usuario, long cedula, long id_ciudad) throws CaException{
        pedidoDAO.crearCarrito(usuario, cedula, id_ciudad);
    }

    public void consultarCarrito(String usuario, long id_ciudad) throws CaException{
        pedidoDAO.consultarCarrito(usuario, id_ciudad);
    }

    public boolean verificarExistencia(long id_pedido, long id_producto) throws CaException{
        return pedidoDAO.verificarExistencia(id_pedido, id_producto);
    }

    public void actualizarCantidad(long id_pedido, long id_producto, long cantidad) throws CaException{
        pedidoDAO.actualizarCantidad(id_pedido, id_producto, cantidad);
    }
    
    public void actualizarEstadoPedido(String usuario, long pedido_id, float total_pedido) throws CaException {
        pedidoDAO.actualizarEstadoPedido(usuario, pedido_id, total_pedido);
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
    
    public Carrito getCarrito(){
        return pedidoDAO.getCarrito();
    }
    
    public DetallePedido getDetallePedido(){
        return pedidoDAO.getDetalle_pedido();
    }
    
    public Pedido getPedido(){
        return pedidoDAO.getPedido();
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
    
    public Admon getAdmon(){
        return admonDAO.getAdmon();
    }
    
}
