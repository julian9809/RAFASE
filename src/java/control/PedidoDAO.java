/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author david
 */
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.DetallePedido;
import util.CaException;
import util.ServiceLocator;
//imports modelo
import modelo.Pedido;

public class PedidoDAO {

    private Pedido pe;

    public PedidoDAO() {
        pe = new Pedido();
    }

    public Pedido consultarPedido(String usuario, long usuario_id) throws CaException {
        try {
            String strSQL = "SELECT * FROM Pedido PE, Usuario USER WHERE PE.ID_CEDULA=USER.ID_CEDULA and USER.ID_CEDULA=" + usuario_id + "and PE.ESTADO_PEDIDO=0";
            Connection conexion = ServiceLocator.getInstance("admin_db", "dbadministrator").tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                ResultSet rs = prepStmt.executeQuery();
                while (rs.next()) {
                    pe.setId_pedido(rs.getDouble(1));
                    pe.setEstado_pedido(rs.getDouble(2));
                    pe.setFecha_pedido(rs.getDate(3));
                    pe.setTotal_pedido(rs.getDouble(4));
                    pe.setId_cedula(rs.getDouble(5));
                    pe.setId_ciudad(rs.getDouble(6));
                }
            }
        } catch (SQLException e) {
            throw new CaException("No pudo recuperar el pedido\n " + e.getMessage());
        } finally {
            ServiceLocator.getInstance("admin_db", "dbadministrator").liberarConexion();
        }
        return pe;
    }
    
    public boolean consultarPedidos(String usuario, long usuario_id) throws CaException {
        try {
            String strSQL = "SELECT COUNT(*) FROM Pedido PE, Usuario USER WHERE PE.ID_CEDULA=USER.ID_CEDULA and USER.ID_CEDULA=" + usuario_id + "and PE.ESTADO_PEDIDO=0";
            Connection conexion = ServiceLocator.getInstance("admin_db", "dbadministrator").tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                ResultSet rs = prepStmt.executeQuery();
                while (rs.next()) {
                    if(rs.getDouble(1) == 0){
                        return false;
                    }
                    else{
                        return true;
                    }
                }
            }
        } catch (SQLException e) {
            throw new CaException("No pudo recuperar el pedido\n " + e.getMessage());
        } finally {
            ServiceLocator.getInstance("admin_db", "dbadministrator").liberarConexion();
        }
        return true;
    }

    public void insertarPedido(String usuario, Pedido ped) throws CaException {
        try {
            String strSQL = "INSERT INTO Pedido (ID_PEDIDO, ESTADO_PEDIDO, FECHA_PEDIDO, TOTAL_PEDIDO, ID_CEDULA, ID_CIUDAD) VALUES(ID_PEDIDO.NEXTVALUE,?,SYSDATE,?,?,?)";
            Connection conexion = ServiceLocator.getInstance("admin_db", "dbadministrator").tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                prepStmt.setDouble(1, (double) ped.getEstado_pedido());
                prepStmt.setDouble(2, (double) ped.getTotal_pedido());
                prepStmt.setDouble(3, (double) ped.getId_cedula());
                prepStmt.setDouble(4, (double) ped.getId_ciudad());
                prepStmt.executeUpdate();
            }
            ServiceLocator.getInstance("admin_db", "dbadministrator").commit();
        } catch (SQLException e) {
            throw new CaException("PedidoDAO", "No pudo crear el carrito\n" + e.getMessage());
        } finally {
            ServiceLocator.getInstance("admin_db", "dbadministrator").liberarConexion();
        }
    }

    public void insertarProductosPedido(String usuario, DetallePedido deped) throws CaException {
        try {
            String strSQL = "INSERT INTO Detalle_Pedido(ID_DETALLE, CANTIDAD, ID_PEDIDO, ID_PRODUCTO) VALUES (ID_DETALLE.NEXTVALUE,?,?,?)";
            Connection conexion = ServiceLocator.getInstance("admin_db", "dbadministrator").tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                prepStmt.setDouble(1, (double) deped.getCANTIDAD());
                prepStmt.setDouble(2, (double) deped.getID_PEDIDO());
                prepStmt.setDouble(3, (double) deped.getID_PRODUCTO());
                prepStmt.executeUpdate();
            }
            ServiceLocator.getInstance("admin_db", "dbadministrator").commit();
        } catch (SQLException e) {
            throw new CaException("PedidoDAO", "No pudo crear el carrito\n" + e.getMessage());
        } finally {
            ServiceLocator.getInstance("admin_db", "dbadministrator").liberarConexion();
        }
    }

    public ArrayList<DetallePedido> consultarProductosPedido(String usuario, String password, DetallePedido deped) throws CaException {
        ArrayList<DetallePedido> detaped = new ArrayList<>();
        try {
            String strSQL = "SELECT DE.ID_DETALLE, DE.CANTIDAD, DE.ID_PEDIDO, DE.ID_PRODUCTO FROM admin_db.Detalle_Pedido DE, admin_db.Pedido PE WHERE DE.ID_PEDIDO = PE.ID_PEDIDO AND DE.ID_PEDIDO = '" + deped.getID_PEDIDO() + "'";
            Connection conexion = ServiceLocator.getInstance(usuario, password).tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                ResultSet rs = prepStmt.executeQuery();
                while (rs.next()) {
                    pe.setId_pedido(rs.getDouble(1));
                    pe.setEstado_pedido(rs.getDouble(2));
                    pe.setFecha_pedido(rs.getDate(3));
                    pe.setTotal_pedido(rs.getDouble(4));
                    pe.setId_cedula(rs.getDouble(5));
                    pe.setId_ciudad(rs.getDouble(6));
                }
            }
            ServiceLocator.getInstance(usuario, password).commit();
        } catch (SQLException e) {
            throw new CaException("PedidoDAO", "No pudo crear el carrito\n" + e.getMessage());
        } finally {
            ServiceLocator.getInstance(usuario, password).liberarConexion();
        }
        return detaped;
    }

    public void crearCarrito(String usuario, String password) throws CaException {

        try {
            String strSQL = "CREATE VIEW CARRITO "
                    + "AS SELECT tabla1.campo_a, tabla2.campo_b"
                    + "FROM Pedido PE, Detalle_Pedido DP, Producto PR"
                    + "WHERE tabla1.campo_a = tabla2.campo_a...";
            Connection conexion = ServiceLocator.getInstance(usuario, password).tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                prepStmt.executeUpdate();
            }
            ServiceLocator.getInstance(usuario, password).commit();
        } catch (SQLException e) {
            throw new CaException("PedidoDAO", "No pudo crear el carrito\n" + e.getMessage());
        } finally {
            ServiceLocator.getInstance(usuario, password).liberarConexion();
        }
    }

}
