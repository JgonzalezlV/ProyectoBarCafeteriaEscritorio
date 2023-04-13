/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ventanas;

import com.google.gson.JsonSyntaxException;
import controlador.Consultas;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelo.Trabajador;
import modelo.Usuario;
import utilidades.RespuestaJson;

/**
 * Panel donde se gestiona los datos de los trabajadores
 * @author Josu
 */
public class GestionTrabajadores extends javax.swing.JPanel {

    private DefaultTableModel modeloTabla = new DefaultTableModel();
    private TableRowSorter<TableModel> tablaOrdenada = new TableRowSorter<TableModel>(modeloTabla);

    /**
     * Constructor del panel getion trabajadores
     * Creates new form GestionTrabajadores
     */
    public GestionTrabajadores() {
        initComponents();
        llenarModeloTablaTrabajadores();
        listarTrabajadores();
        llenarComboBoxCategoria();
        //tablaTrabajadores.setRowSorter(tablaOrdenada);
    }

    /**
     * Metodo que lista a los trabajadores registrados en la base de datos.
     */
    private void listarTrabajadores() {
        int id = 0;
        // Se limpia la tabla
        int numFilas = modeloTabla.getRowCount();
        for (int i = 0; i < numFilas; i++) {
            modeloTabla.removeRow(0);
        }
        // Se consultan los usuarios y los trabajadores, se recorren
        ArrayList<Usuario> users = Consultas.ListarUsuarios();
        ArrayList<Trabajador> trabajadores = Consultas.ListarTrabajadores();
        for (Usuario u : users) {
            // Se asigna a id el valor del id del usuario 
            id = u.getIdUsuario();
            for (Trabajador t : trabajadores) {
                // Para comprobar si es trabajador
                if (id == t.getIdTrabajador()) {
                    // Se insertan en la tabla
                    String datos[] = {u.getNombre(), u.getApellidos(), u.getTelefono(), t.getNIF(), String.valueOf(t.getSalario()), t.getCategoria()};
                    modeloTabla.addRow(datos);
                }
            }
        }
    }

    /**
     * Metodo para nombrar las columnas de la tabla
     */
    private void llenarModeloTablaTrabajadores() {
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Apellidos");
        modeloTabla.addColumn("Telefono");
        modeloTabla.addColumn("NIF");
        modeloTabla.addColumn("Salario");
        modeloTabla.addColumn("Categoría");
        // Cada vez que se pulse en una fila se rellenaran los campos correspondientes
        tablaTrabajadores.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                try {
                    txtTelefonoTrabajador.setText(tablaTrabajadores.getValueAt(tablaTrabajadores.getSelectedRow(), 2).toString());
                    txtSalario.setText(tablaTrabajadores.getValueAt(tablaTrabajadores.getSelectedRow(), 4).toString());
                    comboBoxCategoria.setSelectedItem(tablaTrabajadores.getValueAt(tablaTrabajadores.getSelectedRow(), 5).toString());
                    txtNIF.setText(tablaTrabajadores.getValueAt(tablaTrabajadores.getSelectedRow(), 3).toString());
                } catch (NullPointerException e) {
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTrabajadores = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnEliminarTrabajador = new javax.swing.JButton();
        btnModificarTrabajador = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTelefonoTrabajador = new javax.swing.JTextField();
        txtSalario = new javax.swing.JTextField();
        txtNIF = new javax.swing.JTextField();
        comboBoxCategoria = new javax.swing.JComboBox<>();

        setLayout(new java.awt.GridBagLayout());

        tablaTrabajadores.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        tablaTrabajadores.setModel(modeloTabla);
        jScrollPane1.setViewportView(tablaTrabajadores);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 705;
        gridBagConstraints.ipady = 448;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(27, 16, 34, 0);
        add(jScrollPane1, gridBagConstraints);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(105, 56, 41)), "Operaciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 2, 18))); // NOI18N

        btnEliminarTrabajador.setText("Eliminar Trabajador");
        btnEliminarTrabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTrabajadorActionPerformed(evt);
            }
        });

        btnModificarTrabajador.setText("Modificar Trabajador");
        btnModificarTrabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarTrabajadorActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar tabla");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnModificarTrabajador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminarTrabajador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEliminarTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnModificarTrabajador)
                .addGap(18, 18, 18)
                .addComponent(btnActualizar)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(60, 6, 0, 31);
        add(jPanel1, gridBagConstraints);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(105, 56, 41), 1, true), "Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 2, 18))); // NOI18N

        jLabel1.setText("Telefono trabajador");

        jLabel2.setText("Salario");

        jLabel3.setText("NIF");

        jLabel4.setText("Categoría");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(txtNIF, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(txtSalario, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(txtTelefonoTrabajador, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(comboBoxCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTelefonoTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(11, 11, 11)
                .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNIF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 28;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 6, 34, 31);
        add(jPanel2, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * 
     * @param evt 
     */
    private void btnEliminarTrabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTrabajadorActionPerformed
        // TODO add your handling code here:
        Usuario user = new Usuario(txtTelefonoTrabajador.getText());
        try {
            user = Consultas.existeUsuario("usuarios", user);
            Trabajador trabajador = new Trabajador(user.getIdUsuario());
            try {
                trabajador = Consultas.existeTrabajador(trabajador);
                Trabajador trabajadorEliminar = new Trabajador(user.getIdUsuario());
                RespuestaJson respuestaJson = Consultas.eliminar("trabajadores",trabajadorEliminar);
                JOptionPane.showMessageDialog(this, respuestaJson.getValue());
                listarTrabajadores();
                limpiarTextos();
            } catch (JsonSyntaxException e) {
                JOptionPane.showMessageDialog(this,"Trabajador no registrado", "No registrado", JOptionPane.ERROR_MESSAGE);
            }
        } catch (JsonSyntaxException e) {
            JOptionPane.showMessageDialog(this,"Usuario no registrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarTrabajadorActionPerformed

    private void btnModificarTrabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarTrabajadorActionPerformed
        // TODO add your handling code here:
        Usuario user = new Usuario(txtTelefonoTrabajador.getText());
        try {
            user = Consultas.existeUsuario("usuarios", user);
            Trabajador trabajador = new Trabajador(user.getIdUsuario());
            try {
                trabajador = Consultas.existeTrabajador(trabajador);
                Trabajador trabajadorModificar = new Trabajador(user.getIdUsuario(), Double.valueOf(txtSalario.getText()),txtNIF.getText(),String.valueOf(comboBoxCategoria.getSelectedItem()));
                RespuestaJson respuestaJson = Consultas.actualizar("trabajadores",trabajadorModificar);
                JOptionPane.showMessageDialog(this, respuestaJson.getValue());
                listarTrabajadores();
                limpiarTextos();
            } catch (JsonSyntaxException e) {
                System.out.println(e.getMessage());
                //JOptionPane.showMessageDialog(this,"Trabajador no registrado", "No registrado", JOptionPane.ERROR_MESSAGE);
            }
        } catch (JsonSyntaxException e) {
            JOptionPane.showMessageDialog(this,"Usuario no registrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarTrabajadorActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        listarTrabajadores();
    }//GEN-LAST:event_btnActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminarTrabajador;
    private javax.swing.JButton btnModificarTrabajador;
    private javax.swing.JComboBox<String> comboBoxCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaTrabajadores;
    private javax.swing.JTextField txtNIF;
    private javax.swing.JTextField txtSalario;
    private javax.swing.JTextField txtTelefonoTrabajador;
    // End of variables declaration//GEN-END:variables

    private void limpiarTextos() {
        txtTelefonoTrabajador.setText("");
        txtSalario.setText("");
        txtNIF.setText("");
        comboBoxCategoria.setSelectedItem("");
    }

    private void llenarComboBoxCategoria() {
        comboBoxCategoria.addItem("");
        comboBoxCategoria.addItem("Camarero");
        comboBoxCategoria.addItem("Cocinero");
        comboBoxCategoria.addItem("Administrador");
    }
}
