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
import modelo.Cliente;


/**
 *
 * @author danie
 */
public class ClienteDAO {
    
    private Cliente cliente;
    
    public ClienteDAO()
    {
        cliente = new Cliente();
    }
   

    /**
     * @throws CaException
     */
    public void insertarCliente() throws CaException {
        try {
            String strSQL = "INSERT INTO Usuario(ID_CEDULA, PRIMER_NOMB, SEGUNDO_NOMB, PRIMER_APELL, SEGUNDO_APELL, PASSWORD, FECH_NAC, TIPO_ID, GENERO, EMAIL, NICKNAME) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                prepStmt.setLong(1, cliente.getId_cedula());
                prepStmt.setString(2, cliente.getPrimer_nombre());
                prepStmt.setString(3, cliente.getSegundo_nombre());
                prepStmt.setString(4, cliente.getPrimer_apellido());
                prepStmt.setString(5, cliente.getSegundo_apellido());
                prepStmt.setString(6, cliente.getPassword());
                prepStmt.setDate(7, cliente.getFecha_nacimiento());
                prepStmt.setString(8, cliente.getTipo_id());
                prepStmt.setString(2, cliente.getGenero());
                prepStmt.setString(2, cliente.getEmail());
                prepStmt.setString(2, cliente.getNickname());
                prepStmt.executeUpdate();
            }
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("ConjuntoDAO", "No pudo crear el conjunto\n" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }}

