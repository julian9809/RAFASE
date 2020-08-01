/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import util.ServiceLocator;

/**
 *
 * @author julia
 */
public class pruebaConexion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws CaException {
        try {
            String strSQL = "INSERT INTO usur(ID_CEDULA, TIPO_ID, PRIMER_NOMB, SEGUNDO_NOMB, PRIMER_APELL, SEGUNDO_APELL, PASSWORD, FECH_NAC, GENERO, EMAIL, NICKNAME) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                prepStmt.setLong(1, 1031169327);
                prepStmt.setString(2, "CC");
                prepStmt.setString(3, "Jhonathan");
                prepStmt.setString(4, "Daniel");
                prepStmt.setString(5, "Rojas");
                prepStmt.setString(6, "Zora");
                prepStmt.setString(7, "abc123");
                prepStmt.setDate(8, (Date) Date.valueOf(LocalDate.MAX));
                prepStmt.setString(9, "O");
                prepStmt.setString(10, "daniel.r.97@hotmail.com");
                prepStmt.setString(11, "Papas338");
                prepStmt.executeUpdate();
            }
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("ClienteDAO", "No pudo crear el cliente\n" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
    
}
