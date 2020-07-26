/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.CaException;
import util.ServiceLocator;
import modelo.Cliente;
import modelo.Direccion;

/**
 *
 * @author danie
 */
public class ClienteDAO {

    private Cliente cliente;
    private Direccion direccion;

    public ClienteDAO() {
        cliente = new Cliente();
        direccion = new Direccion();
    }

    /**
     * @throws CaException
     */
    public void insertarCliente() throws CaException {
        try {
            String strSQL = "INSERT INTO usur(ID_CEDULA, PRIMER_NOMB, SEGUNDO_NOMB, PRIMER_APELL, SEGUNDO_APELL, PASSWORD, FECH_NAC, TIPO_ID, GENERO, EMAIL, NICKNAME) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                prepStmt.setLong(1, cliente.getId_cedula());
                prepStmt.setString(2, cliente.getPrimer_nombre());
                prepStmt.setString(3, cliente.getSegundo_nombre());
                prepStmt.setString(4, cliente.getPrimer_apellido());
                prepStmt.setString(5, cliente.getSegundo_apellido());
                prepStmt.setString(6, cliente.getPassword());
                prepStmt.setDate(7, (Date) cliente.getFecha_nacimiento());
                prepStmt.setString(8, cliente.getTipo_id());
                prepStmt.setString(9, cliente.getGenero());
                prepStmt.setString(10, cliente.getEmail());
                prepStmt.setString(11, cliente.getNickname());
                prepStmt.executeUpdate();
            }
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("ClienteDAO", "No pudo crear el cliente\n" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public boolean iniciarSesion(String nickname, String userPassword) throws CaException {
        try {
            String strSQL = "SELECT COUNT(*) FROM usur WHERE NICKNAME = ? AND PASSWORD = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                prepStmt.setString(1, nickname);
                prepStmt.setString(2, userPassword);
                ResultSet rs = prepStmt.executeQuery();
                while (rs.next()) {
                    if (rs.getLong(1) == 0) {
                        return false;
                    } else {
                        return true;
                    }
                }
            }
        } catch (SQLException e) {
            throw new CaException("ClienteDAO", "No pudo recuperar el conjunto\n " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
        return false;
    }

    public void insertarDireccion(String usuario, String password) throws CaException {
        try {
            String strSQL = "INSERT INTO dir(ID_DIRECCION, DIRECCION_COMPLETA, EXTRAS, TIPO_DIRECCION, ID_CEDULA, ID_CIUDAD) VALUES (?,?,?,?,?,?)";
            Connection conexion = ServiceLocator.getInstance(usuario, password).tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                prepStmt.setLong(1, direccion.getId_direccion());
                prepStmt.setString(2, direccion.getDireccion_completa());
                prepStmt.setString(3, direccion.getExtras());
                prepStmt.setString(4, direccion.getTipo_direccion());
                prepStmt.setLong(5, direccion.getId_cedula());
                prepStmt.setLong(6, direccion.getId_ciudad());
                prepStmt.executeUpdate();
            }
            ServiceLocator.getInstance(usuario, password).commit();
        } catch (SQLException e) {
            throw new CaException("ClienteDAO", "No se pudo crear el Usuario\n" + e.getMessage());
        } finally {
            ServiceLocator.getInstance(usuario, password).liberarConexion();
        }
    }

    public ArrayList<String> buscarDirecciones(String usuario, String password, long cedula) throws CaException {
        ArrayList<String> direcciones = new ArrayList<>();
        try {
            String strSQL = "SELECT DIRECCION FROM dir WHERE ID_CEDULA = ?";
            Connection conexion = ServiceLocator.getInstance(usuario, password).tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                prepStmt.setLong(1, cedula);
                ResultSet rs = prepStmt.executeQuery();
                direcciones.add(rs.getString(1));
            }

        } catch (SQLException e) {
            throw new CaException("ClienteDAO", "No se pudo realizar la busqueda" + e.getMessage());
        } finally {
            ServiceLocator.getInstance(usuario, password).liberarConexion();
        }
        return direcciones;
    }

    public void crearUsuario(String usuario, String password) throws CaException {
        try {
            String strSQL = "create user " + usuario + " identified by "
                    + password;
            String strSQLDOS = "grant cliente to " + usuario;
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.execute();
            prepStmt = conexion.prepareStatement(strSQLDOS);
            prepStmt.execute();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("ClienteDAO", "No se pudo crear el Usuario\n" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public long buscarIdCliente(String usuario) throws CaException {
        long id_cliente=-1;
        try {
            String strSQL = "SELECT ID_CEDULA FROM usur WHERE NICKNAME='" + usuario + "'";
            Connection conexion = ServiceLocator.getInstance("visitante", "abc123").tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                ResultSet rs = prepStmt.executeQuery();
                while (rs.next()) {
                    id_cliente = (long) rs.getLong(1);
                }
            }
        } catch (SQLException e) {
            throw new CaException("ClienteDAO", "No se pudo realizar la busqueda" + e.getMessage());
        } finally {
            ServiceLocator.getInstance("visitante", "abc123").liberarConexion();
        }
        return id_cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
}
