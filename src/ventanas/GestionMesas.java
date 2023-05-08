/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventanas;

import com.google.gson.JsonSyntaxException;
import controlador.Consultas;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import modelo.Mesa;
import utilidades.RespuestaJson;

/**
 *
 * @author Josu
 */
public class GestionMesas extends JPanel implements ActionListener {

    private static JPanel panelBotones, panelDatos, panelOperaciones;
    private static JButton[] botones, botonesOperaciones;
    private static JTextField txtNumMesa, txtLocalizacion, txtPAX;
    private static String[] nombreOperaciones = {"Insertar Mesa", "Eliminar Mesa", "Modificar Mesa"};

    public GestionMesas() {
        cargarMesas();
        setLayout(new GridLayout(3, 1, 10, 10));
        inciarPanelDatos();
        iniciarPanelOperaciones();
    }

    public void cargarMesas() {
        ArrayList<Mesa> mesas = Consultas.ListarMesas();
        int mesasTotales = 0;
        int indice = 1;
        for (Mesa m : mesas) {
            mesasTotales = m.getNumMesa();
        }
        botones = new JButton[mesasTotales];
        panelBotones = new JPanel(new GridLayout(3, botones.length, 10, 10));
        panelBotones.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(105, 56, 41)), "Mesas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 2, 18)));
        for (JButton b : botones) {
            while (mesasTotales >= indice) {
                b = new JButton("Mesa " + indice);
                panelBotones.add(b);
                b.addActionListener((ActionEvent e) -> {
                    JButton boton = (JButton) e.getSource();
                    Mesa mesaPulsada = Consultas.existeMesa("mesas",new Mesa(Integer.parseInt(boton.getText().substring(5))));
                    new Pedido_Mesa(null,true,Integer.parseInt(boton.getText().substring(5)));
                    txtNumMesa.setText(String.valueOf(mesaPulsada.getNumMesa()));
                    txtLocalizacion.setText(mesaPulsada.getLocalizacion());
                    txtPAX.setText(String.valueOf(mesaPulsada.getPAX()));
                });
                indice++;
            }
        }
        add(panelBotones);
    }

    private void inciarPanelDatos() {
        panelDatos = new JPanel(new FlowLayout());
        panelDatos.setSize(400, 400);
        txtNumMesa = new JTextField(20);
        txtLocalizacion = new JTextField(20);
        txtPAX = new JTextField(20);
        panelDatos.add(new JLabel("Número de mesa:"));
        panelDatos.add(txtNumMesa);
        panelDatos.add(new JLabel("Localización:"));
        panelDatos.add(txtLocalizacion);
        panelDatos.add(new JLabel("PAX:"));
        panelDatos.add(txtPAX);
        panelDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(105, 56, 41)), "Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 2, 18)));
        add(panelDatos);
    }

    private void iniciarPanelOperaciones() {
        panelOperaciones = new JPanel(new FlowLayout());
        panelOperaciones.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(105, 56, 41)), "Operaciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 2, 18)));
        for (int i = 0; i < nombreOperaciones.length; i++) {
            botonesOperaciones = new JButton[i];
            botones[i] = new JButton(nombreOperaciones[i]);
            botones[i].addActionListener(this);
            panelOperaciones.add(botones[i]);
        }
        add(panelOperaciones);
    }

    public static void insertarMesa() {
        Mesa mesa = new Mesa(Integer.parseInt(txtNumMesa.getText()));
        try {
            mesa = Consultas.existeMesa("mesas", mesa);
            JOptionPane.showMessageDialog(null,"Mesa repetida", "Mesa ya registrada", JOptionPane.INFORMATION_MESSAGE);
        } catch (JsonSyntaxException jse) {
            Mesa mesaInsertar = new Mesa(Integer.parseInt(txtNumMesa.getText()),Integer.parseInt(txtPAX.getText()),txtLocalizacion.getText());
            RespuestaJson respuestaJson = Consultas.insertar("mesas",mesaInsertar);
            JOptionPane.showMessageDialog(null, respuestaJson.getValue());
            JButton nuevoBoton = new JButton("Mesa " + Integer.parseInt(txtNumMesa.getText()));
            nuevoBoton.addActionListener((ActionEvent e) -> {
                JButton boton = (JButton) e.getSource();
                Mesa mesaPulsada = Consultas.existeMesa("mesas",new Mesa(Integer.parseInt(boton.getText().substring(5))));
                txtNumMesa.setText(String.valueOf(mesaPulsada.getNumMesa()));
                txtLocalizacion.setText(mesaPulsada.getLocalizacion());
                txtPAX.setText(String.valueOf(mesaPulsada.getPAX()));
            });
            panelBotones.add(nuevoBoton);
            panelBotones.updateUI();
        }
    }

    public static void eliminarMesa() {
        Mesa mesa = new Mesa(Integer.parseInt(txtNumMesa.getText()));
        try {
            mesa = Consultas.existeMesa("mesas", mesa);
            Mesa mesaEliminada = new Mesa(mesa.getNumMesa());
            int eleccion = JOptionPane.showConfirmDialog(null,"¿Estas seguro de que quieres eliminar la mesa?", "Confirmacion", JOptionPane.YES_NO_OPTION);
            if (eleccion == JOptionPane.YES_OPTION) {
                RespuestaJson respuestaJson = Consultas.eliminar("mesas", mesaEliminada);
                JOptionPane.showMessageDialog(null, respuestaJson.getValue());
            }
        } catch (JsonSyntaxException e) {
            JOptionPane.showMessageDialog(null,"Mesa no registrada.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void modificarMesa() {
         Mesa mesa = new Mesa(Integer.parseInt(txtNumMesa.getText()));
        try {
            mesa = Consultas.existeMesa("mesas", mesa);
            Mesa mesaModificada = new Mesa(mesa.getNumMesa(),Integer.valueOf(txtPAX.getText()),txtLocalizacion.getText());
            int eleccion = JOptionPane.showConfirmDialog(null,"¿Estas seguro de que quieres modificar la mesa?", "Confirmacion", JOptionPane.YES_NO_OPTION);
            if (eleccion == JOptionPane.YES_OPTION) {
                RespuestaJson respuestaJson = Consultas.actualizar("mesas", mesaModificada);
                JOptionPane.showMessageDialog(null, respuestaJson.getValue());
            }
        } catch (JsonSyntaxException e) {
            JOptionPane.showMessageDialog(null,"Mesa no registrada.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton botonPulsado = (JButton) e.getSource();
        switch (botonPulsado.getText()) {
            case "Insertar Mesa" ->
                GestionMesas.insertarMesa();
            case "Eliminar Mesa" ->
                GestionMesas.eliminarMesa();
            case "Modificar Mesa" ->
                GestionMesas.modificarMesa();
        }
    }

}
