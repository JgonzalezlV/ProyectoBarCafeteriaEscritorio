/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Tempalates/Classes/Class.java to edit this template
 */
package ventanas;

import com.formdev.flatlaf.IntelliJTheme;

/**
 * Clase principal, en la cual se llamara al login.
 * @author Josu
 */
public class Principal {
 
    public static void main(String[] args) {
        try {
            // Se muestra la ventana del login
            new VentanaLogin();
            // Se aplica un estilo a lo que se ejecuta despues del login
            IntelliJTheme.setup(Principal.class.getResourceAsStream(
     "/codely_dark.theme.json"));
        } catch (Exception ex) {
            System.err.println("Fallo en el estilo");
        }
    }
    
}
