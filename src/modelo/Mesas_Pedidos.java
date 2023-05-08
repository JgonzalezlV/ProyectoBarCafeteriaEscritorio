/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author negu2
 */
public class Mesas_Pedidos {
    
     private int idMesaPedido, idPedido,numMesa;

    public Mesas_Pedidos(int idMP, int idPedido, int numMesa) {
        this.idMesaPedido = idMP;
        this.idPedido = idPedido;
        this.numMesa = numMesa;
    }

    public Mesas_Pedidos(int idMesaPedido) {
        this.idMesaPedido = idMesaPedido;
    }

    public int getIdMesaPedido() {
        return idMesaPedido;
    }

    public void setIdMesaPedido(int idMesaPedido) {
        this.idMesaPedido = idMesaPedido;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }

    @Override
    public String toString() {
        return "Mesas_Pedidos{" + "idMP=" + idMesaPedido + ", idPedido=" + idPedido + ", numMesa=" + numMesa + '}';
    }
     
}
