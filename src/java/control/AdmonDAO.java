/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Admon;
import modelo.Proveedor;
import util.CaException;
import util.ServiceLocator;

/**
 *
 * @author julia
 */
public class AdmonDAO {
    
    private Admon admon;
    private Proveedor proveedor;

    public AdmonDAO() {
        admon = new Admon();
        proveedor = new Proveedor();
    }
    
    public void buscarAdministradores(String usuario, String password) throws CaException {
        try {
            String strSQL = "SELECT * FROM admon";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                ResultSet rs = prepStmt.executeQuery();
                while (rs.next()) {
                    admon.getId_administrador_array().add(rs.getLong(1));
                    admon.getNombre_completo_array().add(rs.getString(2));
                    admon.getCorreo_array().add(rs.getString(3));
                    admon.getContraseña_array().add(rs.getString(4));
                }
            }
        } catch (SQLException e) {
            throw new CaException("admonDAO", " no se pudo conseguir proveedores: " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
    
    public void buscarProveedores(String usuario, String password) throws CaException {
        try {
            String strSQL = "SELECT * FROM prove";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                ResultSet rs = prepStmt.executeQuery();
                while (rs.next()) {                    
                    proveedor.getId_proveedor_array().add(rs.getLong(1));
                    proveedor.getNombre_array().add(rs.getString(2));
                    proveedor.getDireccion_array().add(rs.getString(3));
                }
            }
        } catch (SQLException e) {
            throw new CaException("admonDAO", " no se pudo conseguir administradores: " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
    
    public boolean existeAdmin(String usuario) throws CaException {
        try {
            String strSQL = "SELECT COUNT(*) FROM admon WHERE admon.NOMBRE_ADMINISTRADOR = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                prepStmt.setString(1, usuario);
                ResultSet rs = prepStmt.executeQuery();
                while (rs.next()) {
                    return rs.getLong(1) != 0;
                }
            }
        } catch (SQLException e) {
            throw new CaException("admonDAO", " no se pudo conseguir administradores: " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
        return false;
    }
    
    public Admon getAdmon() {
        return admon;
    }

    public void setAdmon(Admon admon) {
        this.admon = admon;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    
}
