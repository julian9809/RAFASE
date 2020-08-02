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
            String strSQL = "INSERT INTO usur(ID_CEDULA, TIPO_ID, PRIMER_NOMB, SEGUNDO_NOMB, PRIMER_APELL, SEGUNDO_APELL, PASSWORD, FECH_NAC, GENERO, EMAIL, NICKNAME) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                prepStmt.setLong(1, cliente.getId_cedula());
                prepStmt.setString(2, cliente.getTipo_id());
                prepStmt.setString(3, cliente.getPrimer_nombre());
                prepStmt.setString(4, cliente.getSegundo_nombre());
                prepStmt.setString(5, cliente.getPrimer_apellido());
                prepStmt.setString(6, cliente.getSegundo_apellido());
                prepStmt.setString(7, cliente.getPassword());
                prepStmt.setDate(8, (Date) cliente.getFecha_nacimiento());
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

    public boolean buscarExisteCliente(String usuario, String password, String nickname) throws CaException {
        try {
            String strSQL = "SELECT COUNT(*) FROM usur WHERE NICKNAME = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                prepStmt.setString(1, nickname);
                ResultSet rs = prepStmt.executeQuery();
                while (rs.next()) {
                    return rs.getLong(1) != 0;
                }
            }
        } catch (SQLException e) {
            throw new CaException("ClienteDAO", "No pudo recuperar el conjunto\n " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
        return false;
    }
    
    public boolean buscarExisteCliente(String usuario, String password, String nickname, String userPassword) throws CaException {
        try {
            String strSQL = "SELECT COUNT(*) FROM usur WHERE NICKNAME = ? AND PASSWORD = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                prepStmt.setString(1, nickname);
                prepStmt.setString(2, userPassword);
                ResultSet rs = prepStmt.executeQuery();
                while (rs.next()) {
                    return rs.getLong(1) != 0;
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
            String strSQL = "INSERT INTO dir(ID_DIRECCION, DIRECCION_COMPLETA, EXTRAS, TIPO_DIRECCION, ID_CIUDAD, ID_CEDULA, TIPO_ID) VALUES (?,?,?,?,?,?,?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                prepStmt.setLong(1, direccion.getId_direccion());
                prepStmt.setString(2, direccion.getDireccion_completa());
                prepStmt.setString(3, direccion.getExtras());
                prepStmt.setString(4, direccion.getTipo_direccion());
                prepStmt.setLong(5, direccion.getId_ciudad());
                prepStmt.setLong(6, direccion.getId_cedula());
                prepStmt.setString(7, direccion.getTipo_id());
                prepStmt.executeUpdate();
            }
            ServiceLocator.getInstance(usuario, password).commit();
        } catch (SQLException e) {
            throw new CaException("ClienteDAO", "No se pudo insertar la dirección\n" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void buscarDirecciones(String usuario, String password, long cedula) throws CaException {
        try {
            String strSQL = "SELECT DIRECCION FROM dir WHERE ID_CEDULA = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                prepStmt.setLong(1, cedula);
                ResultSet rs = prepStmt.executeQuery();
                direccion.getDireccion_completa_array().add(rs.getString(1));
            }
        } catch (SQLException e) {
            throw new CaException("ClienteDAO", "No se pudo realizar la busqueda" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void crearUsuario() throws CaException {
        try {
            String strSQL = "INSERT INTO usur(ID_CEDULA, TIPO_ID, PRIMER_NOMB, SEGUNDO_NOMB, PRIMER_APELL, SEGUNDO_APELL, PASSWORD, FECH_NAC, GENERO, EMAIL, NICKNAME) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            String strSQLDOS = "CREATE USER " + cliente.getNickname() +" IDENTIFIED BY " + cliente.getPassword();
            String strSQLTRES = "GRANT CLIENTE TO " + cliente.getNickname();
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                prepStmt.setLong(1, cliente.getId_cedula());
                prepStmt.setString(2, cliente.getTipo_id());
                prepStmt.setString(3, cliente.getPrimer_nombre());
                prepStmt.setString(4, cliente.getSegundo_nombre());
                prepStmt.setString(5, cliente.getPrimer_apellido());
                prepStmt.setString(6, cliente.getSegundo_apellido());
                prepStmt.setString(7, cliente.getPassword());
                prepStmt.setDate(8, (Date) cliente.getFecha_nacimiento());
                prepStmt.setString(9, cliente.getGenero());
                prepStmt.setString(10, cliente.getEmail());
                prepStmt.setString(11, cliente.getNickname());
                try(PreparedStatement prepStmtDOS = conexion.prepareStatement(strSQLDOS)){
                    try(PreparedStatement prepStmtTRES = conexion.prepareStatement(strSQLTRES)){
                        prepStmt.executeUpdate();
                        prepStmtDOS.execute();
                        prepStmtTRES.execute();
                    }
                }
            }
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("ClienteDAO", "No se pudo crear el Usuario\n" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public long buscarIdCliente(String usuario, String password) throws CaException {
        long id_cliente=-1;
        try {
            String strSQL = "SELECT ID_CEDULA FROM usur WHERE NICKNAME='" + usuario + "'";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                ResultSet rs = prepStmt.executeQuery();
                while (rs.next()) {
                    id_cliente = (long) rs.getLong(1);
                }
            }
        } catch (SQLException e) {
            throw new CaException("ClienteDAO", "No se pudo realizar la busqueda" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
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
