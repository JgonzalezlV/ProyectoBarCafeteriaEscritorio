/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Timestamp;

/**
 *
 * @author Josu
 */
public class Pedido {
 
    private int idPedido,idTrabajador,idCliente;
    private String estado;
    private Timestamp fechaHoraPedido;

    public Pedido(int idPedidos) {
        this.idPedido = idPedidos;
    }
    
    public Pedido(int idPedido, int idTrabajador, int idCliente, String estado, Timestamp fechaHoraPedido) {
        this.idPedido = idPedido;
        this.idTrabajador = idTrabajador;
        this.idCliente = idCliente;
        this.estado = estado;
        this.fechaHoraPedido = fechaHoraPedido;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Timestamp getFechaHoraPedido() {
        return fechaHoraPedido;
    }

    public void setFechaHoraPedido(Timestamp fechaHoraPedido) {
        this.fechaHoraPedido = fechaHoraPedido;
    }

    @Override
    public String toString() {
        return "Pedido{" + "idPedidos=" + idPedido + ", idTrabajador=" + idTrabajador + ", idCliente=" + idCliente + ", estado=" + estado + ", fechaHoraPedido=" + fechaHoraPedido + '}';
    }
}
