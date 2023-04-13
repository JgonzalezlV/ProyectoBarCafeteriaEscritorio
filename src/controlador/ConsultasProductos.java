/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import modelo.Producto;

/**
 *
 * @author Esme
 */
public class ConsultasProductos {

    public static ArrayList<Producto> listarTodosLosProductos() {
        ArrayList<Producto> listaProductos = new ArrayList<>();
        Statement sentencia = null;
        ConexionDB conexionBD = null;
        try {
            String sql = "SELECT * FROM `productos`";
            conexionBD = new ConexionDB();
            Connection conexion = conexionBD.abrirConexion();
            sentencia = conexion.createStatement();
            ResultSet resultset = sentencia.executeQuery(sql);
            while (resultset.next()) {
                listaProductos.add(new Producto(resultset.getInt("idProducto"),
                        resultset.getString("nombreProducto"),
                        resultset.getDouble("precioProducto")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasProductos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            Logger.getLogger("Conexion BD nula").log(Level.SEVERE, null, ex);
        } finally {
            try {
                sentencia.close();
                conexionBD.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasProductos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaProductos;
    }

    public static void insertarProductos(String nombreProducto, double precioProducto) {
        PreparedStatement sentencia = null;
        ConexionDB conexionBD = null;
        try {
            String sql = "INSERT INTO `productos` (`nombreProducto`, `precioProducto`) VALUES (?,?)";
            conexionBD = new ConexionDB();
            Connection conexion = conexionBD.abrirConexion();
            try {
                sentencia = conexion.prepareStatement(sql);
                sentencia.setString(1, nombreProducto);
                sentencia.setDouble(2, precioProducto);
                sentencia.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasProductos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NullPointerException e) {
            System.out.println("ConexionBD nula");
        } finally {
            try {
                sentencia.close();
                conexionBD.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasProductos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void eliminarProducto(String nombreProducto) {
        PreparedStatement sentencia = null;
        ConexionDB conexionBD = null;
        try {
            String sql = "DELETE FROM productos WHERE nombreProducto=?";
            conexionBD = new ConexionDB();
            Connection conexion = conexionBD.abrirConexion();
            try {
                sentencia = conexion.prepareStatement(sql);
                sentencia.setString(1, nombreProducto);
                sentencia.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasProductos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NullPointerException e) {
            System.out.println("ConexionBD nula");
        } finally {
            try {
                sentencia.close();
                conexionBD.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasProductos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void modificarProducto(String nuevoNombreProducto, double nuevoPrecioProducto) {
        PreparedStatement sentencia = null;
        ConexionDB conexionBD = null;
        try {
            String sql = "UPDATE  productos SET precioProducto=? WHERE nombreProducto=?";
            conexionBD = new ConexionDB();
            Connection conexion = conexionBD.abrirConexion();
            try {
                sentencia = conexion.prepareStatement(sql);
                sentencia.setDouble(1, nuevoPrecioProducto);
                sentencia.setString(2, nuevoNombreProducto);
                sentencia.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasProductos.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (NullPointerException e) {
            System.out.println("ConexionBD nula");
        } finally {
            try {
                sentencia.close();
                conexionBD.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasProductos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static Producto existeProducto(String nombreProducto) {
        PreparedStatement sentencia = null;
        ConexionDB conexionBD = null;
        Producto datosProducto = null;
        try {
            String sql = "SELECT * FROM `productos` WHERE nombreProducto=?";
            conexionBD = new ConexionDB();
            Connection conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, nombreProducto);
            ResultSet resultset = sentencia.executeQuery();
            if (resultset.next()) {
                datosProducto = new Producto(resultset.getInt("idProducto"),
                        resultset.getString("nombreProducto"),
                        resultset.getDouble("precioProducto"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasProductos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            Logger.getLogger("Conexion BD nula").log(Level.SEVERE, null, ex);
        } finally {
            try {
                sentencia.close();
                conexionBD.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasProductos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return datosProducto;
    }
    
    public static Producto existeProducto(int idProducto) {
        PreparedStatement sentencia = null;
        ConexionDB conexionBD = null;
        Producto datosProducto = null;
        try {
            String sql = "SELECT * FROM `productos` WHERE idProducto=?";
            conexionBD = new ConexionDB();
            Connection conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1, idProducto);
            ResultSet resultset = sentencia.executeQuery();
            if (resultset.next()) {
                datosProducto = new Producto(resultset.getInt("idProducto"),
                        resultset.getString("nombreProducto"),
                        resultset.getDouble("precioProducto"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasProductos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            Logger.getLogger("Conexion BD nula").log(Level.SEVERE, null, ex);
        } finally {
            try {
                sentencia.close();
                conexionBD.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasProductos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return datosProducto;
    }

}
