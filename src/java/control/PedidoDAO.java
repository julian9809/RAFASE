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
import util.CaException;
import util.ServiceLocator;
//imports modelo
import modelo.Pedido;

public class PedidoDAO {

    private Pedido pe;

    public PedidoDAO() {
        pe = new Pedido();
    }

    public ArrayList<Pedido> consultarPedido(String usuario, String password) throws CaException {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        try {
            String strSQL = "SELECT * FROM Pedido PE, Usuario USER WHERE PE.ID_CEDULA=USER.ID_CEDULA";
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
                    pedidos.add(pe);
                    pe = null;
                    pe = new Pedido();
                }
            }
        } catch (SQLException e) {
            throw new CaException("No pudo recuperar los pedidos\n " + e.getMessage());
        } finally {
            ServiceLocator.getInstance(usuario, password).liberarConexion();
        }
        return pedidos;
    }
    
    public void insertarPedido(String usuario, String password, Pedido ped) throws CaException {
        try {
            String strSQL = "INSERT INTO Pedido (ID_PEDIDO, ESTADO_PEDIDO, FECHA_PEDIDO, TOTAL_PEDIDO, ID_CEDULA, ID_CIUDAD) VALUES(?,?,?,?,?,?)";
            Connection conexion = ServiceLocator.getInstance(usuario, password).tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                prepStmt.setLong(1, (long) ped.getId_pedido());
                prepStmt.setLong(2, (long) ped.getEstado_pedido());
                prepStmt.setDate(3, (Date) ped.getFecha_pedido());
                prepStmt.setLong(4, (long) ped.getTotal_pedido());
                prepStmt.setLong(5, (long) ped.getId_cedula());
                prepStmt.setLong(6, (long) ped.getId_ciudad());
                prepStmt.executeUpdate();
            }
            ServiceLocator.getInstance(usuario, password).commit();
        } catch (SQLException e) {
            throw new CaException("PedidoDAO", "No pudo crear el carrito\n" + e.getMessage());
        } finally {
            ServiceLocator.getInstance(usuario, password).liberarConexion();
        }
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
