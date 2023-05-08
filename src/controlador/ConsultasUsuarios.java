/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;

/**
 *
 * @author Josu
 */
public class ConsultasUsuarios {
    
    public static Usuario existeUsuarioTrabajador(String nombre) {
        PreparedStatement sentencia = null;
        ConexionDB conexionBD = null;
        Usuario datosUsuario = null;
        try {
            String sql = "SELECT * FROM `usuarios` WHERE nombre LIKE ?";
            conexionBD = new ConexionDB();
            Connection conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, nombre);
            ResultSet resultset = sentencia.executeQuery();
            if (resultset.next()) {
                datosUsuario = new Usuario(resultset.getInt("idUsuario"),
                        resultset.getString("usuario"),
                        resultset.getString("password"),
                        resultset.getString("nombre"),
                        resultset.getString("apellidos"),
                        resultset.getString("telefono"),
                        resultset.getString("email"),
                        resultset.getString("tipoUsuario"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            Logger.getLogger("Conexion BD nula").log(Level.SEVERE, null, ex);
        } finally {
            try {
                sentencia.close();
                conexionBD.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return datosUsuario;
    }

}
