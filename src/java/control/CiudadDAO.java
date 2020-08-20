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
import modelo.Ciudad;
import util.CaException;
import util.ServiceLocator;

/**
 *
 * @author david
 */
public class CiudadDAO {
    
    private Ciudad ciudad;

    public CiudadDAO() {
        ciudad = new Ciudad();
    }
    
    public void buscarCiudades(String usuario, String password) throws CaException {
        try {
            String strSQL = "SELECT * FROM ciu";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                ResultSet rs = prepStmt.executeQuery();
                while (rs.next()) {
                    ciudad.getId_ciudad_array().add(rs.getLong(1));
                    ciudad.getNombre_array().add(rs.getString(2));
                    ciudad.getId_tienda_array().add(rs.getLong(3));
                }
            }
        } catch (SQLException e) {
            throw new CaException("ciudadDAO", " no se pudo conseguir ciudades: " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
    
    public long buscarIdCiudad(String usuario, String password, String nombre_ciudad) throws CaException {
        long id_ciudad = -1;
        try {
            String strSQL = "SELECT ciu.ID_CIUDAD FROM ciu WHERE ciu.NOMBRE = '"
                    + nombre_ciudad + "'";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                ResultSet rs = prepStmt.executeQuery();
                while (rs.next()) {
                    id_ciudad = (long) rs.getLong(1);
                }
            }
        } catch (SQLException e) {
            throw new CaException("ciudadDAO", " no se pudo conseguir ciudades: " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
        return id_ciudad;
    }
    
    public String buscarNombreCiudad(long id_ciudad) throws CaException {
        String nombreCiudad = "";
        try {
            String strSQL = "SELECT ciu.NOMBRE FROM ciu WHERE ciu.ID_CIUDAD = '"
                    + id_ciudad + "'";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                ResultSet rs = prepStmt.executeQuery();
                while (rs.next()) {
                    nombreCiudad = (String) rs.getString(1);
                }
            }
        } catch (SQLException e) {
            throw new CaException("ciudadDAO", " no se pudo conseguir ciudades: " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
        return nombreCiudad;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    
}
