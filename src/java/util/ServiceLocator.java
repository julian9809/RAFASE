package util;

import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;

/**
 * Recursos Humanos
 *
 * @author Alba Consuelo Nieto
 */
public class ServiceLocator {

    /**
     * Instancia del ServiceLocator
     */
    private static ServiceLocator instance = null;

    /**
     * Conexion compartida a la Base de Datos
     */
    private Connection conexion = null;

    /**
     * Bandera que indica el estado de la conexion
     */
    private boolean conexionLibre = true;

    /**
     * Usuario y contraseña de quien esta conectado
     */
    private String usuario = "";
    private String password = "";

    /**
     * @return instancia del ServiceLocator para el manejo de la conexion
     */
    public static ServiceLocator getInstance() {
        if (instance == null) {
            try {
                instance = new ServiceLocator();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    /**
     * @throws Exception dice si no se pudo crear la conexion
     */
    private ServiceLocator() throws Exception {
    }

    private ServiceLocator(String usuario, String password) throws Exception {
        try {
            // Se registra el Driver y se crea la conexion
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conexion = DriverManager.getConnection(url, usuario, password);
            conexion.setAutoCommit(false);
        } catch (Exception e) {
            throw new CaException("ServiceLocator", "ERROR_CONEXION_BD " + e);
        }
    }

    public synchronized boolean realizarConexion() {
        try {
            /*Primera conexión que se hace al iniciar la aplicación
                por seguridad se iniciar como visitante*/
            if (conexion == null) {
                String user = "visitante";
                String pass = "abc123";
                String url = "jdbc:oracle:thin:@localhost:1521:XE";
                Class.forName("oracle.jdbc.OracleDriver").newInstance();
                conexion = DriverManager.getConnection(url, user, pass);
                conexion.setAutoCommit(false);
                System.out.println("CONEXION USUARIO1: " + usuario);
                /*Verificación de que la conexión no es null (cuando se cierra
                    una conexión queda como close, no como null)*/
            } else if (conexion != null) {
                /*Verificación de que la conexión a sido cerrada, de ser asi
                    tomara los valores que se le setean a usuario y password*/
                if (conexion.isClosed()) {
                    String user = usuario;
                    String pass = password;
                    System.out.println("USER: " + user + " y su contraseña es: " + pass);
                    String url = "jdbc:oracle:thin:@localhost:1521:XE";
                    Class.forName("oracle.jdbc.OracleDriver").newInstance();
                    conexion = DriverManager.getConnection(url, user, pass);
                    conexion.setAutoCommit(false);
                    System.out.println("CONEXION USUARIO2: " + usuario);
                }
            }
            /*Retorna que fue posible hacer la conexión como true*/
            return true;
        } catch (Exception e) {
            System.out.println("NO FUE POSIBLE REALIZAR LA CONEXION (ServiceLocator): " + e.getMessage());
            /*Retorna que fue no posible hacer la conexión como false*/
            return false;
        }
    }

    /**
     * Toma la conexion para que ningun otro proceso la puedan utilizar
     *
     * @return da la conexion a la base de datos
     */
    public synchronized Connection tomarConexion() {
        while (!conexionLibre) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        conexionLibre = false;
        notify();
        return conexion;
    }

    /**
     * Libera la conexion de la bases de datos para que ningun otro proceso la
     * pueda utilizar
     */
    public synchronized void liberarConexion() {
        while (conexionLibre) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        conexionLibre = true;
        notify();
    }

    /**
     * Cierra la conexion a la base de datos cuando se termina de ejecutar el
     * programa
     */
    public void close() {
        try {
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Realiza los cambios en la base de datos. Con este metodo se asegura que
     * no halla inconsitencias en el modelo relacional de la Base de datos.
     *
     * Se utiliza cuando el procedimiento de insercion es terminado
     * correctamente y se asegura que los datos en el modelo estan bien
     * relacionados.
     */
    public void commit() {
        try {
            conexion.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deshace los cambios en la base de datos. Con este metodo se asegura que
     * no halla inconsitencias en el modelo relacional de la Base de datos.
     *
     * Se utiliza por lo general cuando se devuelve una Exepcion. Los
     * procedimientos intermedios no deberia quedar almacenados en la base de
     * datos.
     */
    public void rollback() {
        try {
            conexion.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Seter y geter del nombre de usuario y la contraseña.
     *
     * @return
     */
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
