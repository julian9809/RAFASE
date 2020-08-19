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
import util.CaException;
import util.ServiceLocator;

public class PagoDAO {
    
    public PagoDAO(){
    }
    
    public double obtenerTotalPedido(long pedido_id) throws CaException {
        try {
            String strSQL = "SELECT admin_db.PK_PAQUETERAFASE.FU_TOTALPRODUCTOS(" + pedido_id + ") FROM DUAL";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                ResultSet rs = prepStmt.executeQuery();
                while (rs.next()) {
                    return rs.getDouble(1);
                }
            }
        } catch (SQLException e) {
            throw new CaException("No pudo consultar el pedido\n " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
        return 0;
    }
    
    public String obtenerSentenciaFactura(long pedido_id) throws CaException {
        try {
            String strSQL = "SELECT PK_PAQUETERAFASE.FU_CREARFACTURA(" + pedido_id + ") FROM DUAL";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                ResultSet rs = prepStmt.executeQuery();
                while (rs.next()) {
                    return rs.getString(1);
                }
            }
        } catch (SQLException e) {
            throw new CaException("No pudo consultar el pedido\n " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
        return null;
    }
    
    /**
     * Esto se ejecuta desde admin_db
     */
    public boolean confirmarTajertaConBanco(long numero_tarjeta, long cvv, String fecha_exp, long pedido_id) throws CaException {
        try {
            String strSQL = "SELECT PK_PAQUETERAFASE.FU_COMPROBARPAGO(" + numero_tarjeta + "," + cvv + ",TO_DATE('" + fecha_exp + "','MM/YY')) FROM DUAL";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                ResultSet rs = prepStmt.executeQuery();
                while (rs.next()) {
                    if(rs.getString(1).equals("TRUE")){
                        String strSQLDOS = "UPDATE PED SET ESTADO_PEDIDO = 'PA' WHERE ID_PEDIDO = ? AND ESTADO_PEDIDO = 'PP'";
                        try (PreparedStatement prepStmtDOS = conexion.prepareStatement(strSQLDOS)) {
                            prepStmtDOS.setLong(1, pedido_id);
                            prepStmtDOS.executeUpdate();
                            ServiceLocator.getInstance().liberarConexion();
                            
                            String strSQLTRES = obtenerSentenciaFactura(pedido_id);
                            ServiceLocator.getInstance().tomarConexion();
                            try (PreparedStatement prepStmtTRES = conexion.prepareStatement(strSQLTRES)) {
                                prepStmtTRES.executeUpdate();
                            }
                            ServiceLocator.getInstance().commit();
                        }
                        
                        return true;
                    }
                    else{
                        String strSQLDOS = "UPDATE PED SET ESTADO_PEDIDO = 'RE' WHERE ID_PEDIDO = ? AND ESTADO_PEDIDO = 'PP'";
                        try (PreparedStatement prepStmtDOS = conexion.prepareStatement(strSQLDOS)) {
                            prepStmtDOS.setLong(1, pedido_id);
                            prepStmtDOS.executeUpdate();
                        }
                        ServiceLocator.getInstance().commit();
                        return false;
                    }
                }
            }
        } catch (SQLException e) {
            throw new CaException("No pudo consultar el pedido\n " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
        return false;
    }
    
    public void actualizarEnvio(long telefono, String direccion, String direccionExtras, String nombreDestino, String metodo) throws CaException {
        try {
            String strSQL = "UPDATE ENV SET TELEFONO_DESTINO = ?, NOMBRE_DESTINO = ?, DIRECCION_ENVIO = ?, EXTRAS = ?, METODO_PAGO = ? WHERE ID_ENVIO = (SELECT MAX(ID_ENVIO) FROM ENV)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                prepStmt.setLong(1, telefono);
                prepStmt.setString(2, nombreDestino);
                prepStmt.setString(3, direccion);
                prepStmt.setString(4, direccionExtras);
                prepStmt.setString(5, metodo);
                prepStmt.executeUpdate();
            }
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("PedidoDAO", "No se pudo actualizar el estado del pedido\n" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
    
}
