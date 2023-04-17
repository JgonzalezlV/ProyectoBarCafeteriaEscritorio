/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Reserva;
import java.sql.Timestamp;

/**
 *
 * @author Josu
 */
public class ConsultasReservas {

    public static ArrayList<Reserva> listarTodosLasReservas() {
        ArrayList<Reserva> listaReservas = new ArrayList<>();
        Statement sentencia = null;
        ConexionDB conexionBD = null;
        try {
            String sql = "SELECT * FROM `reservas`";
            conexionBD = new ConexionDB();
            Connection conexion = conexionBD.abrirConexion();
            sentencia = conexion.createStatement();
            ResultSet resultset = sentencia.executeQuery(sql);
            while (resultset.next()) {
                listaReservas.add(new Reserva(resultset.getInt("idReserva"),
                        resultset.getInt("idCliente"),
                        resultset.getInt("numMesa"),
                        resultset.getString("estadoReserva"),
                        resultset.getTimestamp("fechaHoraReserva")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasReservas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            Logger.getLogger("Conexion BD nula").log(Level.SEVERE, null, ex);
        } finally {
            try {
                sentencia.close();
                conexionBD.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasReservas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaReservas;
    }

    public static void insertarReserva(int idReserva, int idCliente, int numMesa,String estadoReserva ,Timestamp fechaHoraReserva) {
        PreparedStatement sentencia = null;
        ConexionDB conexionBD = null;
        try {
            String sql = "INSERT INTO `reservas` (idReserva,idCliente,numMesa,estadoReserva,fechaHoraReserva) VALUES (?,?,?,?,?)";
            conexionBD = new ConexionDB();
            Connection conexion = conexionBD.abrirConexion();
            try {
                sentencia = conexion.prepareStatement(sql);
                sentencia.setInt(1, idReserva);
                sentencia.setInt(2, idCliente);
                sentencia.setInt(3, numMesa);
                sentencia.setString(4, estadoReserva);
                sentencia.setTimestamp(5, fechaHoraReserva);
                sentencia.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasReservas.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NullPointerException e) {
            System.out.println("ConexionBD nula");
        } finally {
            try {
                sentencia.close();
                conexionBD.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasReservas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void eliminarReserva(int idReserva) {
        PreparedStatement sentencia = null;
        ConexionDB conexionBD = null;
        try {
            String sql = "DELETE FROM reservas WHERE idReserva=?";
            conexionBD = new ConexionDB();
            Connection conexion = conexionBD.abrirConexion();
            try {
                sentencia = conexion.prepareStatement(sql);
                sentencia.setInt(1, idReserva);
                sentencia.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasReservas.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NullPointerException e) {
            System.out.println("ConexionBD nula");
        } finally {
            try {
                sentencia.close();
                conexionBD.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasReservas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void modificarReserva(int idReserva,int idCliente,int numMesa,String estadoReserva ,Timestamp fechaHoraReserva) {
        PreparedStatement sentencia = null;
        ConexionDB conexionBD = null;
        try {
            String sql = "UPDATE reservas SET idCliente=?, numMesa=?, estadoReserva=? ,fechaHoraReserva=? WHERE idReserva=?";
            conexionBD = new ConexionDB();
            Connection conexion = conexionBD.abrirConexion();
            try {
                sentencia = conexion.prepareStatement(sql);
                sentencia.setInt(1, idCliente);
                sentencia.setInt(2, numMesa);
                sentencia.setString(3, estadoReserva);
                sentencia.setTimestamp(4, fechaHoraReserva);
                sentencia.setInt(5, idReserva);
                sentencia.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasReservas.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (NullPointerException e) {
            System.out.println("ConexionBD nula");
        } finally {
            try {
                sentencia.close();
                conexionBD.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasReservas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static Reserva existeReserva(int idReserva) {
        PreparedStatement sentencia = null;
        ConexionDB conexionBD = null;
        Reserva datosReserva = null;
        try {
            String sql = "SELECT * FROM `reservas` WHERE idReserva=?";
            conexionBD = new ConexionDB();
            Connection conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1, idReserva);
            ResultSet resultset = sentencia.executeQuery();
            if (resultset.next()) {
                datosReserva = new Reserva(resultset.getInt("idReserva"),
                        resultset.getInt("idCliente"),
                        resultset.getInt("numMesa"),
                        resultset.getString("estadoReserva"),
                        resultset.getTimestamp("fechaHoraReserva"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasReservas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            Logger.getLogger("Conexion BD nula").log(Level.SEVERE, null, ex);
        } finally {
            try {
                sentencia.close();
                conexionBD.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasReservas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return datosReserva;
    }
    
    public static Reserva existeReserva(int numMesa,Timestamp fechaHoraReserva) {
        PreparedStatement sentencia = null;
        ConexionDB conexionBD = null;
        Reserva datosReserva = null;
        try {
            String sql = "SELECT * FROM `reservas` WHERE numMesa=? AND fechaHoraReserva=?";
            conexionBD = new ConexionDB();
            Connection conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1, numMesa);
            sentencia.setTimestamp(2, fechaHoraReserva);
            ResultSet resultset = sentencia.executeQuery();
            if (resultset.next()) {
                datosReserva = new Reserva(resultset.getInt("idReserva"),
                        resultset.getInt("idCliente"),
                        resultset.getInt("numMesa"),
                        resultset.getString("estadoReserva"),
                        resultset.getTimestamp("fechaHoraReserva"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasReservas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            Logger.getLogger("Conexion BD nula").log(Level.SEVERE, null, ex);
        } finally {
            try {
                sentencia.close();
                conexionBD.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasReservas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return datosReserva;
    }

}
