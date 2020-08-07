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
import modelo.TarjetaCredito;
import modelo.Telefono;

/**
 *
 * @author danie
 */
public class ClienteDAO {

    private Cliente cliente;
    private Direccion direccion;
    private Direccion direccionEnvio;
    private Telefono telefono;
    private TarjetaCredito tarjetaCredito;

    public ClienteDAO() {
        cliente = new Cliente();
        direccion = new Direccion();
        direccionEnvio = new Direccion();
        telefono = new Telefono();
        tarjetaCredito = new TarjetaCredito();
    }

    /**
     * @throws CaException
     */
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
            String strSQL = "INSERT INTO DIR(ID_DIRECCION,DIRECCION_COMPLETA, EXTRAS, TIPO_DIRECCION, ID_CIUDAD, ID_CEDULA, TIPO_ID) VALUES(ID_DIRECCION.NEXTVAL,?,?,?,?,?,?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                prepStmt.setString(1, direccion.getDireccion_completa());
                prepStmt.setString(2, direccion.getExtras());
                prepStmt.setString(3, direccion.getTipo_direccion());
                prepStmt.setLong(4, direccion.getId_ciudad());
                prepStmt.setLong(5, direccion.getId_cedula());
                prepStmt.setString(6, direccion.getTipo_id());
                prepStmt.executeUpdate();
                ServiceLocator.getInstance().commit();
            }
        } catch (SQLException e) {
            ServiceLocator.getInstance().rollback();
            throw new CaException("ClienteDAO", "No se pudo insertar la dirección\n" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void buscarDireccionResidencia(String usuario, String password, String tipo, long cedula) throws CaException {
        try {
            String strSQL = "SELECT DIRECCION_COMPLETA,EXTRAS FROM DIR, USUR WHERE DIR.ID_CEDULA = USUR.ID_CEDULA AND DIR.TIPO_ID = USUR.TIPO_ID AND USUR.ID_CEDULA = ? AND DIR.TIPO_DIRECCION = 'R'";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                prepStmt.setLong(1, cedula);
                ResultSet rs = prepStmt.executeQuery();
                while (rs.next()) {
                    direccion.getDireccion_completa_array().add(rs.getString(1));
                    direccion.getExtras_array().add(rs.getString(2));
                }
            }
        } catch (SQLException e) {
            throw new CaException("ClienteDAO", "No se pudo realizar la busqueda" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
    
    public void buscarDireccionEnvio(String usuario, String password, String tipo, long cedula) throws CaException {
        try {
            String strSQL = "SELECT DIRECCION_COMPLETA,EXTRAS FROM DIR, USUR WHERE DIR.ID_CEDULA = USUR.ID_CEDULA AND DIR.TIPO_ID = USUR.TIPO_ID AND USUR.ID_CEDULA = ? AND DIR.TIPO_DIRECCION = 'E'";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                prepStmt.setLong(1, cedula);
                ResultSet rs = prepStmt.executeQuery();
                while (rs.next()) {
                    direccionEnvio.getDireccion_completa_array().add(rs.getString(1));
                    direccionEnvio.getExtras_array().add(rs.getString(2));
                }
            }
        } catch (SQLException e) {
            throw new CaException("ClienteDAO", "No se pudo realizar la busqueda" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void insertarTelefono(String usuario, String password) throws CaException {
        try {
            String strSQL = "INSERT INTO TEL(ID_TELEFONO, NUMERO_TELEFONO, EN_USO, ID_CEDULA, TIPO_ID) VALUES (ID_TELEFONO.NEXTVAL, ?, ?, ?, ?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                prepStmt.setLong(1, telefono.getNumeroTelefono());
                prepStmt.setString(2, telefono.getEnUso());
                prepStmt.setLong(3, telefono.getIdCedula());
                prepStmt.setString(4, telefono.getTipoID());
                prepStmt.executeUpdate();
                ServiceLocator.getInstance().commit();
            }
        } catch (SQLException e) {
            ServiceLocator.getInstance().rollback();
            throw new CaException("ClienteDAO", "No se pudo insertar el telefono\n" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void buscarTelefono(String usuario, String password, long cedula) throws CaException {
        try {
            String strSQL = "SELECT NUMERO_TELEFONO FROM TEL, USUR WHERE USUR.ID_CEDULA = TEL.ID_CEDULA AND USUR.TIPO_ID = TEL.TIPO_ID AND USUR.ID_CEDULA = ? AND TEL.EN_USO = 'S'";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                prepStmt.setLong(1, cedula);
                ResultSet rs = prepStmt.executeQuery();
                while (rs.next()) {
                    telefono.getNumeroTelefonoArray().add(rs.getLong(1));
                }
            }
        } catch (SQLException e) {
            throw new CaException("ClienteDAO", "No se pudo realizar la busqueda" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
    
    public void quitarTelefono(String usuario, String password, long cedula, long telefono) throws CaException {
        try {
            String strSQL = "UPDATE TEL SET TEL.EN_USO = 'N' WHERE NUMERO_TELEFONO = ? AND ID_CEDULA = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                prepStmt.setLong(1, telefono);
                prepStmt.setLong(2, cedula);
                prepStmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new CaException("ClienteDAO", "No se pudo realizar la busqueda" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
    
    public void insertarTarjetaCredito(String usuario, String password) throws CaException {
        try {
            String strSQL = "INSERT INTO TC(ID_TARJETA,NOMBRETITULAR,NUMERO_TARJETA, FECH_EXP, TIPO_ID, ID_CEDULA) VALUES (ID_TARJETA.NEXTVAL,?,?,?,?,?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                prepStmt.setString(1, tarjetaCredito.getNombreTitular());
                prepStmt.setLong(2, tarjetaCredito.getNumeroTarjeta());
                prepStmt.setDate(3, (Date) tarjetaCredito.getFechaExp());
                prepStmt.setString(4, tarjetaCredito.getTipoID());
                prepStmt.setLong(5, tarjetaCredito.getIdCedula());
                prepStmt.executeUpdate();
                ServiceLocator.getInstance().commit();
            }
        } catch (SQLException e) {
            ServiceLocator.getInstance().rollback();
            throw new CaException("ClienteDAO", "No se pudo insertar la tarjeta\n" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void buscarTarjetaCredito(String usuario, String password, long cedula) throws CaException {
        try {
            String strSQL = "SELECT NOMBRETITULAR, NUMERO_TARJETA, FECH_EXP FROM TC, USUR WHERE TC.TIPO_ID = USUR.TIPO_ID AND TC.ID_CEDULA = USUR.ID_CEDULA AND USUR.ID_CEDULA = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                prepStmt.setLong(1, cedula);
                ResultSet rs = prepStmt.executeQuery();
                while (rs.next()) {
                    tarjetaCredito.getNombreTitularArray().add(rs.getString(1));
                    tarjetaCredito.getNumeroTarjetaArray().add(rs.getLong(2));
                    tarjetaCredito.getFechaExpArray().add(rs.getDate(3));
                }
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
            String strSQLDOS = "CREATE USER " + cliente.getNickname() +" IDENTIFIED BY " + cliente.getPassword() + "  DEFAULT TABLESPACE RAFASE_usuarios TEMPORARY TABLESPACE RAFASE_usuariosTemp QUOTA 2M ON RAFASE_usuarios";
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
                        ServiceLocator.getInstance().commit();
                    }
                }
            }
        } catch (SQLException e) {
            ServiceLocator.getInstance().rollback();
            throw new CaException("ClienteDAO", "No se pudo crear el Usuario\n" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
        
    public void buscarDatosCliente(String usuario, String password, long cedula) throws CaException {
        try {
            String strSQL = "SELECT PRIMER_NOMB, SEGUNDO_NOMB, PRIMER_APELL, SEGUNDO_APELL, FECH_NAC, GENERO, EMAIL FROM USUR WHERE ID_CEDULA = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                prepStmt.setLong(1, cedula);
                ResultSet rs = prepStmt.executeQuery();
                while (rs.next()) {
                    cliente.getPrimer_nombre_array().add(rs.getString(1));
                    cliente.getSegundo_nombre_array().add(rs.getString(2));
                    cliente.getPrimer_apellido_array().add(rs.getString(3));
                    cliente.getSegundo_apellido_array().add(rs.getString(4));
                    cliente.getFecha_nacimiento_array().add(rs.getDate(5));
                    cliente.getGenero_array().add(rs.getString(6));
                    cliente.getEmail_array().add(rs.getString(7));
                }
            }
        } catch (SQLException e) {
            throw new CaException("ClienteDAO", "No se pudo realizar la busqueda" + e.getMessage());
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

    public String buscarTipoID(String usuario, String password) throws CaException {
        String tipoId="";
        try {
            String strSQL = "SELECT TIPO_ID FROM usur WHERE NICKNAME='" + usuario + "'";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                ResultSet rs = prepStmt.executeQuery();
                while (rs.next()) {
                    tipoId = rs.getString(1);
                }
            }
        } catch (SQLException e) {
            throw new CaException("ClienteDAO", "No se pudo realizar la busqueda" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
        return tipoId;
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

    public Direccion getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(Direccion direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }    
    
    public Telefono getTelefono() {
        return telefono;
    }

    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
    }

    public TarjetaCredito getTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setTarjetaCredito(TarjetaCredito tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }   
    
}
