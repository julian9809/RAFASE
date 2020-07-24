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
import modelo.Carrito;
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
            String strSQL = "SELECT * FROM Pedido PE, Usuario U WHERE PE.ID_CEDULA=U.ID_CEDULA and U.ID_CEDULA=" + usuario_id + " and PE.ESTADO_PEDIDO=0";
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

    public boolean consultarPedidos(long usuario_id) throws CaException {
        try {
            String strSQL = "SELECT COUNT(*) FROM Pedido PE, Usuario U WHERE PE.ID_CEDULA=U.ID_CEDULA and U.ID_CEDULA= " + usuario_id + " and PE.ESTADO_PEDIDO=0";
            Connection conexion = ServiceLocator.getInstance("admin_db", "dbadministrator").tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                ResultSet rs = prepStmt.executeQuery();
                while (rs.next()) {
                    if (rs.getDouble(1) == 0) {
                        return false;
                    } else {
                        return true;
                    }
                }
            }
        } catch (SQLException e) {
            throw new CaException("No pudo recuperar el pedido\n " + e.getMessage());
        } finally {
            ServiceLocator.getInstance("admin_db", "dbadministrator").liberarConexion();
        }
        return false;
    }

    public void insertarPedido(String usuario, Pedido ped) throws CaException {
        try {
            String strSQL = "INSERT INTO Pedido (ID_PEDIDO, ESTADO_PEDIDO, FECHA_PEDIDO, TOTAL_PEDIDO, ID_CEDULA, ID_CIUDAD) VALUES(ID_PEDIDO.NEXTVAL,?,SYSDATE,?,?,?)";
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
            String strSQL = "INSERT INTO Detalle_Pedido(ID_DETALLE_PEDIDO, CANTIDAD, ID_PEDIDO, ID_PRODUCTO) VALUES (ID_DETALLE.NEXTVAL,?,?,?)";
            Connection conexion = ServiceLocator.getInstance("admin_db", "dbadministrator").tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                prepStmt.setDouble(1, (double) deped.getCantidad());
                prepStmt.setDouble(2, (double) deped.getId_pedido());
                prepStmt.setDouble(3, (double) deped.getId_producto());
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
            String strSQL = "SELECT DE.ID_DETALLE, DE.CANTIDAD, DE.ID_PEDIDO, DE.ID_PRODUCTO FROM admin_db.Detalle_Pedido DE, admin_db.Pedido PE WHERE DE.ID_PEDIDO = PE.ID_PEDIDO AND DE.ID_PEDIDO = '" + deped.getId_pedido() + "'";
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

    public void crearCarrito(String usuario, long cedula) throws CaException {

        try {
            String strSQL = "CREATE VIEW CARRITO_" + usuario + " AS "
                    + "(SELECT PE.ID_PEDIDO, PR.NOMBRE_PRODUCTO, DP.CANTIDAD, PR.PRECIO_BASE FROM Producto PR, Detalle_pedido DP, Usuario U, Pedido PE "
                    + "WHERE PR.ID_PRODUCTO = DP.ID_PRODUCTO AND "
                    + "U.ID_CEDULA = PE.ID_CEDULA AND "
                    + "PE.ID_PEDIDO = DP.ID_PEDIDO AND "
                    + "U.ID_CEDULA = " + cedula + " AND "
                    + "PE.ESTADO_PEDIDO = 0)";
            Connection conexion = ServiceLocator.getInstance("admin_db", "dbadministrator").tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                prepStmt.executeUpdate();
            }
            ServiceLocator.getInstance("admin_db", "dbadministrator").commit();
        } catch (SQLException e) {
            throw new CaException("PedidoDAO", "No pudo crear el carrito\n" + e.getMessage());
        } finally {
            ServiceLocator.getInstance("admin_db", "dbadministrator").liberarConexion();
        }
    }

    public ArrayList<Carrito> consultarCarrito(String usuario) throws CaException {
        ArrayList<Carrito> productosCarrito = new ArrayList<>();
        try {
            String strSQL = "SELECT * FROM CARRITO_" + usuario;
            Connection conexion = ServiceLocator.getInstance("admin_db", "dbadministrator").tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                ResultSet rs = prepStmt.executeQuery();
                while (rs.next()) {
                    Carrito producto = new Carrito();
                    producto.setId_pedido(rs.getDouble(1));
                    producto.setNombre_producto(rs.getString(2));
                    producto.setCantidad(rs.getDouble(3));
                    producto.setPrecio_base(rs.getDouble(4));
                    productosCarrito.add(producto);
                    producto = null;
                }
            }
            ServiceLocator.getInstance("admin_db", "dbadministrator").commit();
        } catch (SQLException e) {
            throw new CaException("PedidoDAO", "No pudo crear el carrito\n" + e.getMessage());
        } finally {
            ServiceLocator.getInstance("admin_db", "dbadministrator").liberarConexion();
        }
        return productosCarrito;
    }

    public boolean verificarExistencia(double id_pedido, double id_producto) throws CaException {
        try {
            String strSQL = "SELECT COUNT(*) FROM DETALLE_PEDIDO WHERE ID_PEDIDO = " + id_pedido + " AND ID_PRODUCTO = " + id_producto;
            Connection conexion = ServiceLocator.getInstance("admin_db", "dbadministrator").tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                ResultSet rs = prepStmt.executeQuery();
                while (rs.next()) {
                    if (rs.getDouble(1) == 0) {
                        return false;
                    } else {
                        return true;
                    }
                }
            }
        } catch (SQLException e) {
            throw new CaException("No pudo recuperar el pedido\n " + e.getMessage());
        } finally {
            ServiceLocator.getInstance("admin_db", "dbadministrator").liberarConexion();
        }
        return false;
    }

    public void actualizarCantidad(double id_pedido, double id_producto) throws CaException {
        try {
            double cantidad = 0;
            String strSQL = "SELECT CANTIDAD FROM DETALLE_PEDIDO WHERE ID_PEDIDO = " + id_pedido + " AND ID_PRODUCTO = " + id_producto;

            Connection conexion = ServiceLocator.getInstance("admin_db", "dbadministrator").tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                ResultSet rs = prepStmt.executeQuery();
                while (rs.next()) {
                    cantidad = rs.getDouble(1);
                }
                double nuevaCantidad = cantidad + 1;
                String strSQLDOS = "UPDATE DETALLE_PEDIDO SET CANTIDAD = ? WHERE ID_PRODUCTO = ? AND ID_PEDIDO = ?";
                PreparedStatement prepStmt2 = conexion.prepareStatement(strSQLDOS); 
                prepStmt2.setDouble(1, nuevaCantidad);
                prepStmt2.setDouble(2, id_producto);
                prepStmt2.setDouble(3, id_pedido);
                prepStmt2.executeUpdate();
            }
            
            ServiceLocator.getInstance("admin_db", "dbadministrator").commit();
        } catch (SQLException e) {
            throw new CaException("PedidoDAO", "No se pudo editar la cantidad\n" + e.getMessage());
        } finally {
            ServiceLocator.getInstance("admin_db", "dbadministrator").liberarConexion();
        }
    }
}
