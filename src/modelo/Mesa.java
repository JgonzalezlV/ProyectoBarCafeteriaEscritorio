/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Esme
 */
public class Mesa {
    
    private int numMesa,PAX;
    private String localizacion;

    public Mesa(int numMesa) {
        this.numMesa = numMesa;
    }
    
    public Mesa(int numMesa, int PAX, String localizacion) {
        this.numMesa = numMesa;
        this.PAX = PAX;
        this.localizacion = localizacion;
    }

    public int getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }

    public int getPAX() {
        return PAX;
    }

    public void setPAX(int PAX) {
        this.PAX = PAX;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    @Override
    public String toString() {
        return "Mesas{" + "numMesa=" + numMesa + ", PAX=" + PAX + ", localizacion=" + localizacion + '}';
    }
    
    
    
}
