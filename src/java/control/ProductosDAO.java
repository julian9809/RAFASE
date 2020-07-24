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
import util.CaException;
import util.ServiceLocator;

/**
 *
 * @author julia
 */
public class ProductosDAO {

    private Producto producto;

    public ProductosDAO() {
        producto = new Producto();
    }
    
    /**
     * @param usuario
     * @param password
     * @param producto_buscado
     * @throws CaException
     */
    public void buscarProducto(String usuario, String password, String producto_buscado) throws CaException {
        try {
            String strSQL = "SELECT id_producto,nombre_producto,marca_producto,"
                    + "referencia_producto,caracteristicas_producto,foto,id_subcategoria,"
                    + "iva,unidad_medida FROM prod WHERE "
                    + "UPPER(nombre_producto) LIKE UPPER('%" + producto_buscado
                    + "%')";
            Connection conexion = ServiceLocator.getInstance(usuario, password).tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                ResultSet rs = prepStmt.executeQuery();
                while (rs.next()) {
                    producto.getId_producto_array().add(rs.getDouble(1));
                    producto.getNombre_producto_array().add(rs.getString(2));
                    producto.getMarca_producto_array().add(rs.getString(3));
                    producto.getReferencia_producto_array().add(rs.getString(4));
                    producto.getCaracteristicas_producto_array().add(rs.getString(5));
                    producto.getFoto_array().add(rs.getString(6));
                    producto.getId_subcategoria_array().add(rs.getDouble(7));
                    producto.getIva_array().add(rs.getDouble(8));
                    producto.getUnidad_medida_array().add(rs.getString(9));
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

}
