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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Carrito;
import modelo.DetallePedido;
import util.CaException;
import util.ServiceLocator;
//imports modelo
import modelo.Pedido;

public class PedidoDAO {

    private Pedido pedido;
    private DetallePedido detalle_pedido;
    private Carrito carrito;

    public PedidoDAO() {
        pedido = new Pedido();
        detalle_pedido = new DetallePedido();
        carrito = new Carrito();
    }

    public void consultarPedido(String usuario, long usuario_id) throws CaException {
        try {
            String strSQL = "SELECT * FROM ped, usur WHERE ped.ID_CEDULA=usur.ID_CEDULA and usur.ID_CEDULA=" + usuario_id + " and ped.ESTADO_PEDIDO='CA'";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                ResultSet rs = prepStmt.executeQuery();
                while (rs.next()) {
                    pedido.getId_pedido_array().add(rs.getLong(1));
                    pedido.getEstado_pedido_array().add(rs.getString(2));
                    pedido.getFecha_pedido_array().add(rs.getDate(3));
                    pedido.getTotal_pedido_array().add(rs.getDouble(4));
                    pedido.getId_cedula_array().add(rs.getLong(5));
                    pedido.getId_ciudad_array().add(rs.getLong(6));
                }
            }
        } catch (SQLException e) {
            throw new CaException("No pudo consultar el pedido\n " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public long consultarIdPedido(String usuario, long usuario_id) throws CaException {
        long id_pedido = -1;
        try {
            String strSQL = "SELECT ped.ID_PEDIDO FROM ped, usur WHERE ped.ID_CEDULA=usur.ID_CEDULA and usur.ID_CEDULA=" + usuario_id + " and ped.ESTADO_PEDIDO='CA'";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                ResultSet rs = prepStmt.executeQuery();
                while (rs.next()) {
                    id_pedido = (long) rs.getLong(1);
                }
            }
        } catch (SQLException e) {
            throw new CaException("No pudo consultar el pedido\n " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
        return id_pedido;
    }
    //antes consultarPedidos redundante
    //solo consulta existencia del pedido en estado = carrito

    public boolean existeCarrito(String nickname, String password, long usuario_id) throws CaException {
        try {
            String strSQL = "SELECT COUNT(*) FROM ped, usur WHERE ped.ID_CEDULA=usur.ID_CEDULA and usur.ID_CEDULA= " + usuario_id + " and ped.ESTADO_PEDIDO='CA'";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                ResultSet rs = prepStmt.executeQuery();
                while (rs.next()) {
                    return rs.getDouble(1) != 0;
                }
            }
        } catch (SQLException e) {
            throw new CaException("No pudo recuperar  pedido\n " + e.getMessage() + "linea67");
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
        return false;
    }

    public void insertarPedido(String usuario) throws CaException {
        try {
            String strSQL = "INSERT INTO ped VALUES(ID_PEDIDO.NEXTVAL,?,SYSDATE,?,?,?,?)";

            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                prepStmt.setString(1, (String) pedido.getEstado_pedido());
                prepStmt.setDouble(2, (double) pedido.getTotal_pedido());
                prepStmt.setLong(3, (long) pedido.getId_ciudad());
                prepStmt.setLong(4, (long) pedido.getId_cedula());
                prepStmt.setString(5, (String) pedido.getTipo_id());
                prepStmt.executeUpdate();
            }
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("PedidoDAO", "No pudo insertar Pedido\n" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void insertarProductosPedido(String usuario) throws CaException {
        try {
            String strSQL = "INSERT INTO depe(ID_PEDIDO, ID_PRODUCTO, CANTIDAD) VALUES (?,?,?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                prepStmt.setLong(1, (long) detalle_pedido.getId_pedido());
                prepStmt.setLong(2, (long) detalle_pedido.getId_producto());
                prepStmt.setLong(3, (long) detalle_pedido.getCantidad());
                prepStmt.executeUpdate();
            }
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("PedidoDAO", "No pudo insertar Productos Pedido\n" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void consultarProductosPedido(String usuario, String password, DetallePedido deped) throws CaException {
        try {
            String strSQL = "SELECT depe.ID_PEDIDO, depe.ID_PRODUCTO, depe.CANTIDAD, inv.PRECIO_BASE "
                    + "FROM depe, ped, inv, prod"
                    + "WHERE depe.ID_PEDIDO = ped.ID_PEDIDO "
                    + "AND depe.ID_PRODUCTO = prod.ID_PRODUCTO  "
                    + "AND prod.ID_PRODUCTO = inv.ID_PRODUCTO"
                    + "AND depe.ID_PEDIDO = '" + deped.getId_pedido() + "'";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                ResultSet rs = prepStmt.executeQuery();
                while (rs.next()) {
                    detalle_pedido.getId_pedido_array().add(rs.getLong(1));
                    detalle_pedido.getId_producto_array().add(rs.getLong(2));
                    detalle_pedido.getCantidad_array().add(rs.getLong(3));

                }
            }
        } catch (SQLException e) {
            throw new CaException("PedidoDAO", "No pudo consultar productos pedido\n" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void crearCarrito(String usuario, long cedula, long id_ciudad) throws CaException {
        try {
            String strSQL = "CREATE VIEW CARRITO_" + usuario + "_" + id_ciudad
                    + " AS (SELECT ciu.ID_CIUDAD, ciu.NOMBRE, ped.ID_PEDIDO, "
                    + "categ.ID_CATEGORIA, categ.NOMBRE_CATEGORIA, "
                    + "categ.DESCRIPCION_CATEGORIA, subcat.ID_SUBCATEGORIA, "
                    + "subcat.NOMBRE_SUBCATEGORIA, prod.ID_PRODUCTO, "
                    + "prod.NOMBRE_PRODUCTO, prod.MARCA_PRODUCTO, "
                    + "depe.CANTIDAD, inv.PRECIO_BASE, prod.IVA, prod.FOTO "
                    + "FROM prod, depe, usur, ped, inv, ciu, subcat, categ "
                    + "WHERE prod.ID_PRODUCTO = depe.ID_PRODUCTO AND "
                    + "prod.ID_SUBCATEGORIA = subcat.ID_SUBCATEGORIA AND "
                    + "subcat.ID_CATEGORIA = categ.ID_CATEGORIA AND "
                    + "ciu.ID_CIUDAD = inv.ID_CIUDAD AND "
                    + "usur.ID_CEDULA = ped.ID_CEDULA AND "
                    + "ped.ID_PEDIDO = depe.ID_PEDIDO AND "
                    + "prod.ID_PRODUCTO = inv.ID_PRODUCTO AND "
                    + "usur.ID_CEDULA = " + cedula + " AND "
                    + "ciu.ID_CIUDAD = " + id_ciudad + " AND "
                    + "ped.ESTADO_PEDIDO = 'CA')";
            System.out.println("la sentencia es: " + strSQL);
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                prepStmt.executeUpdate();
            }
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("PedidoDAO", "No pudo crear el carrito\n" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void consultarCarrito(String usuario, long id_ciudad) throws CaException {
        try {
            String strSQL = "SELECT * FROM CARRITO_" + usuario + "_" + id_ciudad;
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                ResultSet rs = prepStmt.executeQuery();
                while (rs.next()) {
                    carrito.getId_ciudad_array().add(rs.getLong(1));
                    carrito.getNombre_ciudad_array().add(rs.getString(2));
                    carrito.getId_pedido_array().add(rs.getLong(3));
                    carrito.getId_categoria_array().add(rs.getLong(4));
                    carrito.getNombre_categoria_array().add(rs.getString(5));
                    carrito.getDescripcion_categoria_array().add(rs.getString(6));
                    carrito.getId_subcategoria_array().add(rs.getLong(7));
                    carrito.getNombre_subcategoria_array().add(rs.getString(8));
                    carrito.getId_producto_array().add(rs.getLong(9));
                    carrito.getNombre_producto_array().add(rs.getString(10));
                    carrito.getMarca_producto_array().add(rs.getString(11));
                    carrito.getCantidad_array().add(rs.getLong(12));
                    carrito.getPrecio_base_array().add(rs.getDouble(13));
                    carrito.getIva_array().add(rs.getDouble(14));
                    carrito.getFoto_array().add(rs.getString(15));
                }
            }
        } catch (SQLException e) {
            throw new CaException("PedidoDAO", "No pudo consultar el carrito\n" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public boolean verificarExistencia(double id_pedido, long id_producto) throws CaException {
        try {
            String strSQL = "SELECT COUNT(*) FROM depe WHERE ID_PEDIDO = " + id_pedido + " AND ID_PRODUCTO = " + id_producto;
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                ResultSet rs = prepStmt.executeQuery();
                while (rs.next()) {
                    return rs.getLong(1) != 0;
                }
            }
        } catch (SQLException e) {
            throw new CaException("No pudo recuperar el pedido al verificar existencias" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
        return false;
    }

    public void actualizarCantidad(Long id_pedido, long id_producto, long cantidad) throws CaException {
        try {
            String strSQL = "SELECT CANTIDAD FROM depe WHERE ID_PEDIDO = " + id_pedido + " AND ID_PRODUCTO = " + id_producto;
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                ResultSet rs = prepStmt.executeQuery();
                while (rs.next()) {
                    cantidad = cantidad + rs.getLong(1);
                }
                String strSQLDOS = "UPDATE depe SET CANTIDAD = ? WHERE ID_PRODUCTO = ? AND ID_PEDIDO = ?";
                try (PreparedStatement prepStmt2 = conexion.prepareStatement(strSQLDOS)) {
                    prepStmt2.setLong(1, cantidad);
                    prepStmt2.setLong(2, id_producto);
                    prepStmt2.setLong(3, id_pedido);
                    prepStmt2.executeUpdate();
                }
            }
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("PedidoDAO", "No se pudo editar la cantidad\n" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public Pedido getPedido() {
        return pedido;
    }

    public DetallePedido getDetalle_pedido() {
        return detalle_pedido;
    }

    public Carrito getCarrito() {
        return carrito;
    }

}
