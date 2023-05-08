/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Productos_Pedidos;

/**
 *
 * @author negu2
 */
public class ConsultasProductos_Pedidos {
    
    public static ArrayList<Productos_Pedidos> listarTodosLosProductos_Pedidos() {
        ArrayList<Productos_Pedidos> listaProductos_Pedidos = new ArrayList<>();
        Statement sentencia = null;
        ConexionDB conexionBD = null;
        try {
            String sql = "SELECT * FROM `productos_pedidos`";
            conexionBD = new ConexionDB();
            Connection conexion = conexionBD.abrirConexion();
            sentencia = conexion.createStatement();
            ResultSet resultset = sentencia.executeQuery(sql);
            while (resultset.next()) {
                listaProductos_Pedidos.add(new Productos_Pedidos(
                        resultset.getInt("idPP"),
                        resultset.getInt("idPedido"),
                        resultset.getInt("idProducto"),
                        resultset.getInt("cantidadProducto")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasProductos_Pedidos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            Logger.getLogger("Conexion BD nula").log(Level.SEVERE, null, ex);
        } finally {
            try {
                sentencia.close();
                conexionBD.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasProductos_Pedidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaProductos_Pedidos;
    }
    
    public static boolean insertarProductos_Pedidos(int idPP, int idPedido, int idProducto, int cantidadProducto) {
        PreparedStatement sentencia = null;
        ConexionDB conexionBD = null;
        boolean insertado = false;
        try {
            String sql = "INSERT INTO `productos_pedidos` VALUES (?,?,?,?)";
            conexionBD = new ConexionDB();
            Connection conexion = conexionBD.abrirConexion();
            try {
                sentencia = conexion.prepareStatement(sql);
                sentencia.setInt(1, idPP);
                sentencia.setInt(2, idPedido);
                sentencia.setInt(3, idProducto);
                sentencia.setInt(4, cantidadProducto);
                sentencia.executeUpdate();
                insertado = true;
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasProductos_Pedidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NullPointerException e) {
            System.out.println("ConexionBD nula");
        } finally {
            try {
                sentencia.close();
                conexionBD.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasProductos_Pedidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return insertado;
    }
    
    public static boolean eliminarProducto_Pedidos(int idPP) {
        PreparedStatement sentencia = null;
        ConexionDB conexionBD = null;
        boolean eliminado = false;
        try {
            String sql = "DELETE FROM productos_pedidos WHERE idPP=?";
            conexionBD = new ConexionDB();
            Connection conexion = conexionBD.abrirConexion();
            try {
                sentencia = conexion.prepareStatement(sql);
                sentencia.setInt(1, idPP);
                sentencia.executeUpdate();
                eliminado = true;
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasProductos_Pedidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NullPointerException e) {
            System.out.println("ConexionBD nula");
        } finally {
            try {
                sentencia.close();
                conexionBD.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasProductos_Pedidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return eliminado;
    }
    
    public static boolean modificarProducto_Pedidos(int idPP, int idPedido, int idProducto, int cantidadProducto) {
        PreparedStatement sentencia = null;
        ConexionDB conexionBD = null;
        boolean modificado = false;
        try {
            String sql = "UPDATE  productos_pedidos SET idPedido=?,idProducto=?,cantidadProducto=?  WHERE idPP=?";
            conexionBD = new ConexionDB();
            Connection conexion = conexionBD.abrirConexion();
            try {
                sentencia = conexion.prepareStatement(sql);
                sentencia.setInt(1, idPedido);
                sentencia.setInt(2, idProducto);
                sentencia.setInt(3, cantidadProducto);
                sentencia.setInt(4, idPP);
                sentencia.executeUpdate();
                modificado = true;
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasProductos_Pedidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NullPointerException e) {
            System.out.println("ConexionBD nula");
        } finally {
            try {
                sentencia.close();
                conexionBD.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasProductos_Pedidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return  modificado;
    }
    
    public static Productos_Pedidos existeProducto(int idPP) {
        PreparedStatement sentencia = null;
        ConexionDB conexionBD = null;
        Productos_Pedidos datosProducto = null;
        try {
            String sql = "SELECT * FROM `productos_pedidos` WHERE idPP=?";
            conexionBD = new ConexionDB();
            Connection conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1, idPP);
            ResultSet resultset = sentencia.executeQuery();
            if (resultset.next()) {
                datosProducto = new Productos_Pedidos(
                        resultset.getInt("idPP"),
                        resultset.getInt("idPedido"),
                        resultset.getInt("idProducto"),
                        resultset.getInt("cantidadProducto"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasProductos_Pedidos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            Logger.getLogger("Conexion BD nula").log(Level.SEVERE, null, ex);
        } finally {
            try {
                sentencia.close();
                conexionBD.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasProductos_Pedidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return datosProducto;
    }
    
}
