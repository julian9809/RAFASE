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
import java.sql.Statement;
import java.util.ArrayList;
import util.CaException;
import util.ServiceLocator;

/**
 *
 * @author julia
 */
public class ProductosDAO {
    
    private Producto p;
    
    public ProductosDAO(){
        p = new Producto();
    }
    
    public ArrayList<Producto> buscarProducto(String usuario,String password,String producto_buscado) throws CaException {
        ArrayList<Producto> productos = new ArrayList<Producto>();
        try {
            String strSQL = "select id_producto,nombre_producto,marca_producto,referencia_producto,caracteristicas_producto,foto,precio_base,unidad_medida,id_subcategoria from admin_db.producto " 
                    + "where UPPER(nombre_producto) like UPPER('%"+producto_buscado+"%') ";
            Connection conexion = ServiceLocator.getInstance(usuario,password).tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                p.setId_producto(rs.getDouble(1));
                p.setNombre_producto(rs.getString(2));
                p.setMarca_producto(rs.getString(3));
                p.setReferencia_producto(rs.getString(4));
                p.setCaracteristicas_producto(rs.getString(5));
                p.setFoto(rs.getString(6));
                p.setPrecio_base(rs.getDouble(7));
                p.setUnidad_medida(rs.getString(8));
                p.setId_subcategoria(rs.getDouble(9));
                productos.add(p);
                p = null;
                p = new Producto();
            }
            for(int i=0;i<productos.size();i++){
                System.out.println(productos.get(i).getNombre_producto());
            }
        } catch (SQLException e) {
            throw new CaException("productosDAO", "no se pudo realizar la busqueda");
        } finally {
            ServiceLocator.getInstance(usuario,password).liberarConexion();
        }
        return productos;
    }

    public Producto getP() {
        return p;
    }

    public void setP(Producto p) {
        this.p = p;
    }
    
}
