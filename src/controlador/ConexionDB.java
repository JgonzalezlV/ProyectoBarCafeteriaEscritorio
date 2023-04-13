/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author negu2
 */
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDB implements Configuracion {

    Connection conexion;
    String usuario, password;

    public ConexionDB() {
        this.usuario = "root";
        this.password = "";
    }

    public ConexionDB(String usuario, String password) {
        // super();
        this.usuario = usuario;
        this.password = password;
    }

    public Connection abrirConexion() {
        try {

            //Cargamos el driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            try {
                conexion = (Connection) DriverManager.getConnection("jdbc:mysql://" + DBHOST + ":3306/" + DBNAME,
                        this.usuario, this.password);
            } catch (SQLException e) {

                e.printStackTrace();
                // Utils.escribirLog(Utils.FICHERO_LOG, e.getMessage());
            }
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }

        return conexion;
    }

    public boolean cerrarConexion() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
}
