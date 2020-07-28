/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import modelo.Producto;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.InventarioRafase;
import util.CaException;
import util.ServiceLocator;

/**
 *
 * @author julia
 */
public class ProductosDAO {

    private Producto producto;
    private InventarioRafase inventario_rafase;
    
    public ProductosDAO() {
        producto = new Producto();
        inventario_rafase = new InventarioRafase();
    }
    
    /**
     * @param usuario
     * @param password
     * @param producto_buscado
     * @param ciudad
     * @param subcategoria_buscada
     * @param categoria_buscada
     * @throws CaException
     */
    public void buscarProducto(String usuario, String password,
            String producto_buscado, String ciudad,
            String subcategoria_buscada, String categoria_buscada)
            throws CaException {
        try {
            String strSQL = "SELECT * FROM INVENTARIO_RAFASE "
                    + "WHERE ID_CIUDAD = " + ciudad + " "
                    + "AND NOMBRE_PRODUCTO LIKE UPPER('%"+producto_buscado+"%') "
                    + "AND ID_SUBCATEGORIA LIKE UPPER('%"+subcategoria_buscada+"%') "
                    + "AND ID_CATEGORIA LIKE UPPER('%"+categoria_buscada+"%') "
                    + "ORDER BY NOMBRE_PRODUCTO ASC";
            Connection conexion = ServiceLocator.getInstance(usuario, password).tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                ResultSet rs = prepStmt.executeQuery();
                while (rs.next()) {
                    inventario_rafase.getCiudad().getId_ciudad_array().add(rs.getDouble(1));
                    inventario_rafase.getCiudad().getNombre_array().add(rs.getString(2));
                    inventario_rafase.getCategoria().getId_categoria_array().add(rs.getDouble(3));
                    inventario_rafase.getCategoria().getNombre_categoria_array().add(rs.getString(4));
                    inventario_rafase.getCategoria().getDescripcion_categoria_array().add(rs.getString(5));
                    inventario_rafase.getSubcategoria().getId_subcategoria_array().add(rs.getDouble(6));
                    inventario_rafase.getSubcategoria().getNombre_subcategoria_array().add(rs.getString(7));
                    inventario_rafase.getProducto().getId_producto_array().add(rs.getDouble(8));
                    inventario_rafase.getProducto().getNombre_producto_array().add(rs.getString(9));
                    inventario_rafase.getProducto().getMarca_producto_array().add(rs.getString(10));
                    inventario_rafase.getProducto().getReferencia_producto_array().add(rs.getString(11));
                    inventario_rafase.getProducto().getCaracteristicas_producto_array().add(rs.getString(12));
                    inventario_rafase.getProducto().getFoto_array().add(rs.getString(13));
                    inventario_rafase.getProducto().getIva_array().add(rs.getDouble(14));
                    inventario_rafase.getProducto().getUnidad_medida_array().add(rs.getString(15));
                    inventario_rafase.getInventario().getExistencias_array().add(rs.getDouble(16));
                    inventario_rafase.getInventario().getPrecio_base_array().add(rs.getDouble(17));
                }
            }
        } catch (SQLException e) {
            throw new CaException("productosDAO", " no se pudo realizar la busqueda: " + e.getMessage());
        } finally {
            ServiceLocator.getInstance(usuario, password).liberarConexion();
        }
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public InventarioRafase getInventario_rafase() {
        return inventario_rafase;
    }

    public void setInventario_rafase(InventarioRafase inventario_rafase) {
        this.inventario_rafase = inventario_rafase;
    }
    
}
