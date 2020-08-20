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
import modelo.Proveedor;
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
    
    public String buscarNombreCiudad(long id_ciudad) throws CaException {
        return ciudadDAO.buscarNombreCiudad(id_ciudad);
    }
    //--------------------------------AdmonDAO----------------------------------
    public void buscarAdministradores(String nickname, String userPassword) throws CaException {
        admonDAO.buscarAdministradores(nickname, userPassword);
    }
    
    public void buscarProveedores(String nickname, String userPassword) throws CaException {
        admonDAO.buscarProveedores(nickname, userPassword);
    }
    
    public void insertarProveedor() throws CaException {
        admonDAO.insertarProveedor();
    }
    
    public boolean existeAdmin(String usuario, String password) throws CaException {
        return admonDAO.existeAdmin(usuario, password);
    }
    
    public double obtenerValorTotalVentas() throws CaException {
        return admonDAO.obtenerValorTotalVentas();
    }
    
    public void obtenerProductosMasVendidos() throws CaException {
        admonDAO.obtenerProductosMasVendidos();
    }
    
    public void obtenerProductosMenosVendidos() throws CaException {
        admonDAO.obtenerProductosMenosVendidos();
    }
    
    public long obtenerCantidadPagosRechazados() throws CaException {
        return admonDAO.obtenerCantidadPagosRechazados();
    }
    
    public void clientesConMasCompras() throws CaException {
        admonDAO.clientesConMasCompras();
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
    
    public void buscarDirecciones(String usuario, String password, String tipo, long cedula) throws CaException{
        clienteDAO.buscarDirecciones(usuario, password, tipo, cedula);
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
    
    public void buscarDatosClientes() throws CaException {
        clienteDAO.buscarDatosClientes();
    }

    public long buscarIdCliente(String usuario, String password) throws CaException {
        return clienteDAO.buscarIdCliente(usuario, password);
    }
    
    public String buscarTipoID(String usuario, String password) throws CaException{
        return clienteDAO.buscarTipoID(usuario, password);
    }
    
    //---------------------------------PagoDAO----------------------------------
    public double obtenerTotalPedido(long pedido_id) throws CaException {
        return pagoDAO.obtenerTotalPedido(pedido_id);
    }
    
    public boolean confirmarTajertaConBanco(long numero_tarjeta, long cvv, String fecha_exp, long pedido_id) throws CaException {
        return pagoDAO.confirmarTajertaConBanco(numero_tarjeta, cvv, fecha_exp, pedido_id);
    }
    
    public String obtenerSentenciaFactura(long pedido_id) throws CaException {
        return pagoDAO.obtenerSentenciaFactura(pedido_id);
    }
    
    public void actualizarEnvio(long telefono, String direccion, String direccionExtras, String nombreDestino, String metodo, String ciudad) throws CaException {
        pagoDAO.actualizarEnvio(telefono, direccion, direccionExtras, nombreDestino, metodo, ciudad);
    }
    
    public void confirmarEnvio() throws CaException {
        pagoDAO.confirmarEnvio();
    }
    //---------------------------------PedidoDAO--------------------------------
    public void consultarPedido(long usuario_id, long ciudad_id) throws CaException{
        pedidoDAO.consultarPedido(usuario_id, ciudad_id);
    }
    
    public void buscarFacturas(long usuario_id) throws CaException {
        pedidoDAO.buscarFacturas(usuario_id);
    }
    
    public long consultarIdPedido(long usuario_id, long ciudad_id) throws CaException {
        return pedidoDAO.consultarIdPedido(usuario_id, ciudad_id);
    }

    public boolean existeCarrito(long usuario_id, long ciudad_id) throws CaException{
        return pedidoDAO.existeCarrito(usuario_id, ciudad_id);
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
    
    public void actualizarEstadoPedido(long pedido_id, double total_pedido) throws CaException {
        pedidoDAO.actualizarEstadoPedido(pedido_id, total_pedido);
    }
    
    //-------------------------------ProductoDAO--------------------------------
    public void buscarProducto(String usuario, String password,
            String producto_buscado, String ciudad,
            String subcategoria_buscada, String categoria_buscada) throws CaException {
        productosDAO.buscarProducto(usuario, password, producto_buscado,
                ciudad,subcategoria_buscada,categoria_buscada);
    }
    
    public void quitarProducto(long id_producto, long id_pedido, long cantidad) throws CaException {
        productosDAO.quitarProducto(id_producto, id_pedido, cantidad);
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
    
    public Proveedor getProveedor(){
        return admonDAO.getProveedor();
    }
    
}
