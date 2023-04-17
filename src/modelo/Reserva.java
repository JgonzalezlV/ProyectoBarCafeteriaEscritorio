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
public class Reserva {

  private int idReserva,idCliente,numMesa;
  private String estado;
  private Timestamp fechaHoraReserva;

    public Reserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Reserva(int numMesa, String fechaHoraReserva) {
        this.numMesa = numMesa;
        this.fechaHoraReserva = Timestamp.valueOf(fechaHoraReserva);
    }

    public Reserva(int idReserva, int idCliente, int numMesa,String estadoReserva, Timestamp fechaHoraReserva) {
        this.idReserva = idReserva;
        this.idCliente = idCliente;
        this.numMesa = numMesa;
        this.estado = estadoReserva;
        this.fechaHoraReserva = fechaHoraReserva;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }

    public Timestamp getFechaHoraReserva() {
        return fechaHoraReserva;
    }

    public void setFechaHoraReserva(Timestamp fechaHoraReserva) {
        this.fechaHoraReserva = fechaHoraReserva;
    }

    @Override
    public String toString() {
        return "Reserva{" + "idReserva=" + idReserva + ", idCliente=" + idCliente + ", numMesa=" + numMesa + ", fechaHoraReserva=" + fechaHoraReserva + '}';
    }

  
   

    
  
  
  
}
