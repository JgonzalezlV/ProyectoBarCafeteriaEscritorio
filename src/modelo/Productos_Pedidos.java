/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Josu
 */
public class Productos_Pedidos {
    
    private int idPP, idPedido,idProducto,cantidadProducto;

    public Productos_Pedidos(int idPP, int idPedido, int idProducto, int cantidadProducto) {
        this.idPP = idPP;
        this.idPedido = idPedido;
        this.idProducto = idProducto;
        this.cantidadProducto = cantidadProducto;
    }

    public int getIdPP() {
        return idPP;
    }

    public void setIdPP(int idPP) {
        this.idPP = idPP;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    @Override
    public String toString() {
        return "Productos_Pedidos{" + "idPP=" + idPP + ", idPedido=" + idPedido + ", idProducto=" + idProducto + ", cantidadProducto=" + cantidadProducto + ", estado=" + '}';
    }
    
    
    
}
