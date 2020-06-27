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
import java.util.ArrayList;
import util.CaException;
import util.ServiceLocator;

public class PedidoDAO {

    private ArrayList kCodigoConjuntoArrayNuevo = new ArrayList();
    private ArrayList nConjuntoArrayNuevo = new ArrayList();
    private ArrayList pDescuentoArrayNuevo = new ArrayList();
    private ArrayList pMoraArrayNuevo = new ArrayList();
    private ArrayList vMensualArrayNuevo = new ArrayList();
    private ArrayList fDescuentoArrayNuevo = new ArrayList();

    private ArrayList kNumAptoArrayNuevo = new ArrayList();
    private ArrayList vCoeficienteArrayNuevo = new ArrayList();

    private ArrayList kIdCuotaArrayNuevo = new ArrayList();
    private ArrayList iEstadoArrayNuevo = new ArrayList();
    private ArrayList oMesArrayNuevo = new ArrayList();
    private ArrayList oAñoArrayNuevo = new ArrayList();
    private ArrayList vCuotaArrayNuevo = new ArrayList();

    public PedidoDAO() {

    }

    public void consultarPedido() throws CaException {
        try {
            String strSQL = "SELECT c.ID_PEDIDO,c.p_descuento,c.p_mora,c.k_codigo,c.n_conjunto,c.f_descuento,a.k_numApto,a.v_coeficiente,cu.k_idCuota,cu.i_estado,cu.o_mes,cu.o_ano,cu.v_cuota from conjunto c, bloque b, apartamento a, cuota cu where c.k_codigo=b.k_codigo and b.k_numbloque=a.k_numbloque and a.k_numapto=cu.k_numapto order by k_idcuota";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                ResultSet rs = prepStmt.executeQuery();
                while (rs.next()) {

                }
            }
        } catch (SQLException e) {
            throw new CaException("No pudo recuperar las cuotas\n " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }

    }

    public void crearCarrito() throws CaException {

        try {
            String prueba = "CREATE MATERIALIZED VIEW vista_materializada"
                    + "[TABLESPACE nuestro_tablespace]"
                    + "[BUILD {IMMEDIATE | DEFERRED}]"
                    + "[REFRESH {ON COMMIT | ON DEMAND | [START WITH fecha_inicial] NEXT intervalo_tiempo } |"
                    + "{COMPLETE | FAST | FORCE | NEVER} ]"
                    + "[{ENABLE|DISABLE} QUERY REWRITE]"
                    + "AS SELECT tabla1.campo_a, tabla2.campo_b"
                    + "FROM tabla1 , tabla2"
                    + "WHERE tabla1.campo_a = tabla2.campo_a...";
            String strSQL = "INSERT INTO Pedido (ID_PEDIDO, ESTADO_PEDIDO, FECHA_PEDIDO, TOTAL_PEDIDO, ID_CEDULA, ID_CIUDAD) VALUES(?,?,?,?,?,?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                for (int i = 0; i < kIdCuotaArrayNuevo.size(); i++) {
                    prepStmt.setLong(1, Long.parseLong(String.valueOf(kIdCuotaArrayNuevo.get(i))));
                    prepStmt.setString(2, (String) iEstadoArrayNuevo.get(i));
                    prepStmt.setLong(3, (long) oMesArrayNuevo.get(i));
                    prepStmt.setLong(4, (long) oAñoArrayNuevo.get(i));
                    prepStmt.setLong(5, (long) kNumAptoArrayNuevo.get(i));
                    prepStmt.setFloat(6, (float) vCuotaArrayNuevo.get(i));
                    prepStmt.executeUpdate();
                }
            }
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("PedidoDAO", "No pudo crear el carrito\n" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }

    }
}
