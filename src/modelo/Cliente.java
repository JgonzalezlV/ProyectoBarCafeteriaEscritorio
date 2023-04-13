/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Josu
 */
public class Cliente {

    private int idCliente;
    private double descuento;

    public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    public Cliente(int idCliente, double descuento) {
        this.idCliente = idCliente;
        this.descuento = descuento;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", descuento=" + descuento + '}';
    }
    
    
    
}
