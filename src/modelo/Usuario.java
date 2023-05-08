/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author negu2
 */
public class Usuario {
    
    private int idUsuario;
    private String usuario,password,nombre,apellidos,telefono,email,tipoUsuario;

    public Usuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(String nombre, String apellidos, String tipoUsuario) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.tipoUsuario = tipoUsuario;
    }
    
    public Usuario(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public Usuario(String telefono) {
        this.telefono = telefono;
    }

    public Usuario(String usuario, String password, String nombre, String apellidos, String telefono, String email, String tipoUsuario) {
        this.usuario = usuario;
        this.password = password;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
        this.tipoUsuario = tipoUsuario;
    }
    
    public Usuario(String usuario, String nombre, String apellidos, String telefono, String email, String tipoUsuario) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
        this.tipoUsuario = tipoUsuario;
    }
    
    public Usuario(int idUsuario, String usuario, String password, String nombre, String apellidos, String telefono, String email, String tipoUsuario) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.password = password;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
        this.tipoUsuario = tipoUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", usuario=" + usuario + ", password=" + password + ", nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono + ", tipoUsuario=" + tipoUsuario + '}';
    }
    
    
    
}
