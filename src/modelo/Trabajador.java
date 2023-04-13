/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Josu
 */
public class Trabajador {
    
    private int idTrabajador;
    private  double salario;
    private String NIF,categoria;

    public Trabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }
    
    public Trabajador(int idTrabajador, double salario, String NIF, String categoria) {
        this.idTrabajador = idTrabajador;
        this.salario = salario;
        this.NIF = NIF;
        this.categoria = categoria;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Trabajadores{" + "idTrabajador=" + idTrabajador + ", salario=" + salario + ", NIF=" + NIF + ", categoria=" + categoria + '}';
    }
    
    
    
}
