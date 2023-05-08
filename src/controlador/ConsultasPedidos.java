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
import modelo.Pedido;
import java.sql.Timestamp;

/**
 *
 * @author Esme
 */
public class ConsultasPedidos {

    public static ArrayList<Pedido> listarTodosLosPedidos() {
        ArrayList<Pedido> listaPedidos = new ArrayList<>();
        Statement sentencia = null;
        ConexionDB conexionBD = null;
        try {
            String sql = "SELECT * FROM `pedidos`";
            conexionBD = new ConexionDB();
            Connection conexion = conexionBD.abrirConexion();
            sentencia = conexion.createStatement();
            ResultSet resultset = sentencia.executeQuery(sql);
            while (resultset.next()) {
                listaPedidos.add(new Pedido(resultset.getInt("idPedido"),
                        resultset.getInt("idTrabajador"),
                        resultset.getInt("idCliente"),
                        resultset.getString("estadoPedido"),
                        resultset.getTimestamp("fechaHoraPedido")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasPedidos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            Logger.getLogger("Conexion BD nula").log(Level.SEVERE, null, ex);
        } finally {
            try {
                sentencia.close();
                conexionBD.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasPedidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaPedidos;
    }

    public static boolean insertarPedido(int idPedido,int idTrabajador,int idCliente,String estado,Timestamp fechaHoraPedido) {
        PreparedStatement sentencia = null;
        ConexionDB conexionBD = null;
        boolean insertado = false;
        try {
            String sql = "INSERT INTO pedidos VALUES (?,?,?,?,?)";
            conexionBD = new ConexionDB();
            Connection conexion = conexionBD.abrirConexion();
            try {
                sentencia = conexion.prepareStatement(sql);
                sentencia.setInt(1, idPedido);
                sentencia.setInt(2, idTrabajador);
                sentencia.setInt(3, idCliente);
                sentencia.setString(4, estado);
                sentencia.setTimestamp(5, fechaHoraPedido);
                sentencia.executeUpdate();
                insertado = true;
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasPedidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NullPointerException e) {
            System.out.println("ConexionBD nula");
        } finally {
            try {
                sentencia.close();
                conexionBD.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasPedidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return insertado;
    }

    public static boolean eliminarPedido(int idPedido) {
        PreparedStatement sentencia = null;
        ConexionDB conexionBD = null;
        boolean eliminado = false;
        try {
            String sql = "DELETE FROM pedidos WHERE idPedido=?";
            conexionBD = new ConexionDB();
            Connection conexion = conexionBD.abrirConexion();
            try {
                sentencia = conexion.prepareStatement(sql);
                sentencia.setInt(1, idPedido);
                sentencia.executeUpdate();
                eliminado = true;
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasPedidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NullPointerException e) {
            System.out.println("ConexionBD nula");
        } finally {
            try {
                sentencia.close();
                conexionBD.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasPedidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return eliminado;
    }

    public static boolean modificarPedido(int idPedido,String nuevoEstado, Timestamp fechaHoraPedido) {
        PreparedStatement sentencia = null;
        ConexionDB conexionBD = null;
        boolean modificado = false;
        try {
            String sql = "UPDATE  pedidos SET estadoPedido=?,fechaHoraPedido=? WHERE idPedido=?";
            conexionBD = new ConexionDB();
            Connection conexion = conexionBD.abrirConexion();
            try {
                sentencia = conexion.prepareStatement(sql);
                sentencia.setString(1, nuevoEstado);
                sentencia.setTimestamp(2, fechaHoraPedido);
                sentencia.setInt(3, idPedido);
               sentencia.executeUpdate();
               modificado = true;
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasPedidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NullPointerException e) {
            System.out.println("ConexionBD nula");
        } finally {
            try {
                sentencia.close();
                conexionBD.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasPedidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return modificado;
    }

    public static Pedido existePedido(int idPedido) {
        PreparedStatement sentencia = null;
        ConexionDB conexionBD = null;
        Pedido datosPedido = null;
        try {
            String sql = "SELECT * FROM `pedidos` WHERE idPedido=?";
            conexionBD = new ConexionDB();
            Connection conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1, idPedido);
            ResultSet resultset = sentencia.executeQuery();
            if (resultset.next()) {
                datosPedido = new Pedido(resultset.getInt("idPedido"),
                        resultset.getInt("idTrabajador"),
                        resultset.getInt("idCliente"),
                        resultset.getString("estadoPedido"),
                        resultset.getTimestamp("fechaHoraPedido"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasPedidos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            Logger.getLogger("Conexion BD nula").log(Level.SEVERE, null, ex);
        } finally {
            try {
                sentencia.close();
                conexionBD.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasPedidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return datosPedido;
    }
}
