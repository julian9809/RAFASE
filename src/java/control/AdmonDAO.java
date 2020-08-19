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
    
    public double obtenerValorTotalVentas() throws CaException {
        try {
            String strSQL = "SELECT SUM(TOTAL_PEDIDO) FROM ped WHERE ESTADO_PEDIDO = 'PA'";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                ResultSet rs = prepStmt.executeQuery();
                while (rs.next()) {
                    return rs.getFloat(1);
                }
            }
        } catch (SQLException e) {
            throw new CaException("No pudo consultar el pedido\n " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
        return 0;
    }
    
    public void obtenerProductosMasVendidos() throws CaException {
        try {
            String strSQL = "SELECT CANTIDADES, NOMPROD FROM (SELECT MAX(CANTIDADES) AS CANTIDADES, NOMPROD FROM (SELECT SUM(DEPE.CANTIDAD) AS CANTIDADES, PROD.NOMBRE_PRODUCTO AS NOMPROD FROM DEPE, PROD WHERE DEPE.ID_PRODUCTO = PROD.ID_PRODUCTO GROUP BY PROD.NOMBRE_PRODUCTO) GROUP BY NOMPROD ORDER BY CANTIDADES DESC) WHERE ROWNUM <= 3";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                ResultSet rs = prepStmt.executeQuery();
                while (rs.next()) {
                    admon.getCantidadProductoMasVendidoArray().add(rs.getLong(1));
                    admon.getNombreProductoMasVendidoArray().add(rs.getString(1));
                }
            }
        } catch (SQLException e) {
            throw new CaException("No pudo consultar el pedido\n " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
    
    public void obtenerProductosMenosVendidos() throws CaException {
        try {
            String strSQL = "SELECT CANTIDADES, NOMPROD FROM (SELECT MIN(CANTIDADES) AS CANTIDADES, NOMPROD FROM (SELECT SUM(DEPE.CANTIDAD) AS CANTIDADES, PROD.NOMBRE_PRODUCTO AS NOMPROD FROM DEPE, PROD WHERE DEPE.ID_PRODUCTO = PROD.ID_PRODUCTO GROUP BY PROD.NOMBRE_PRODUCTO) GROUP BY NOMPROD ORDER BY CANTIDADES ASC) WHERE ROWNUM <= 3";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                ResultSet rs = prepStmt.executeQuery();
                while (rs.next()) {
                    admon.getCantidadProductoMenosVendidoArray().add(rs.getLong(1));
                    admon.getNombreProductoMenosVendidoArray().add(rs.getString(1));
                }
            }
        } catch (SQLException e) {
            throw new CaException("No pudo consultar el pedido\n " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
    
    public long obtenerCantidadPagosRechazados() throws CaException {
        try {
            String strSQL = "SELECT COUNT(PED.ESTADO_PEDIDO) FROM PED WHERE PED.ESTADO_PEDIDO = 'RE'";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                ResultSet rs = prepStmt.executeQuery();
                while (rs.next()) {
                    return rs.getLong(1);
                }
            }
        } catch (SQLException e) {
            throw new CaException("No pudo consultar el pedido\n " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
        return 0;
    }
    
    public void clientesConMasCompras() throws CaException {
        try {
            String strSQL = "SELECT PRIMNOM, SEGNOM, PRIMAPE, SEGAPE, CANTIDAD FROM (SELECT COUNT(PED.ID_CEDULA) AS CANTIDAD, USUR.PRIMER_NOMB AS PRIMNOM, USUR.SEGUNDO_NOMB AS SEGNOM, USUR.PRIMER_APELL AS PRIMAPE, USUR.SEGUNDO_APELL AS SEGAPE FROM USUR, PED WHERE PED.ID_CEDULA = USUR.ID_CEDULA AND PED.TIPO_ID = USUR.TIPO_ID AND PED.ESTADO_PEDIDO = 'PA' GROUP BY USUR.PRIMER_NOMB, USUR.SEGUNDO_NOMB, USUR.PRIMER_APELL, USUR.SEGUNDO_APELL ORDER BY CANTIDAD DESC) WHERE  ROWNUM <= 3";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                ResultSet rs = prepStmt.executeQuery();
                while (rs.next()) {
                    admon.getPrimerNombreArray().add(rs.getString(1));
                    admon.getSegundoNombreArray().add(rs.getString(2));
                    admon.getPrimerApellidoArray().add(rs.getString(3));
                    admon.getSegundoApellidoArray().add(rs.getString(4));
                    admon.getCantidadComprasArray().add(rs.getLong(1));
                }
            }
        } catch (SQLException e) {
            throw new CaException("No pudo consultar el pedido\n " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
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
