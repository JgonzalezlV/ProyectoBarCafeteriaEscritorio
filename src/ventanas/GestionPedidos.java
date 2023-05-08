/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ventanas;

import controlador.Consultas;
import controlador.ConsultasPedidos;
import controlador.ConsultasUsuarios;
import java.sql.Timestamp;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.sql.Time;
import javax.swing.JOptionPane;
import modelo.Pedido;
import modelo.Producto;
import modelo.Productos_Pedidos;
import modelo.Usuario;

/**
 *
 * @author Josu
 */
public class GestionPedidos extends javax.swing.JPanel {

    private DefaultTableModel modeloTablaPedidos = new DefaultTableModel();
    private DefaultTableModel modeloTablaProductos = new DefaultTableModel();

    /**
     * Creates new form GestionPedidos
     */
    public GestionPedidos() {
        initComponents();
        llenarModeloTabla();
        listarPedidos();
        modeloTablaProductosPedidos();
        llenarComboBox();
        jSpinnerIdPedido.setEnabled(false);
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
        tablaPedidos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnInsertarPedido = new javax.swing.JButton();
        btnEliminarPedido = new javax.swing.JButton();
        btnModificarPedido = new javax.swing.JButton();
        btnNuevoPedido = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombreTrabajador = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        timePickerHoraPedido = new com.github.lgooddatepicker.components.TimePicker();
        datePickerFechaPedido = new com.github.lgooddatepicker.components.DatePicker();
        jLabel6 = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtApellidosCliente = new javax.swing.JTextField();
        jSpinnerIdPedido = new javax.swing.JSpinner();
        jComboBoxEstadoPedido = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        tablaPedidos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        tablaPedidos.setModel(modeloTablaPedidos);
        jScrollPane1.setViewportView(tablaPedidos);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 974;
        gridBagConstraints.ipady = 178;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 6);
        add(jScrollPane1, gridBagConstraints);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(105, 56, 41)), "Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 2, 18))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(105, 56, 41)), "Operaciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 2, 18))); // NOI18N

        btnInsertarPedido.setText("Insertar Pedido");
        btnInsertarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarPedidoActionPerformed(evt);
            }
        });

        btnEliminarPedido.setText("Eliminar Pedido");
        btnEliminarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPedidoActionPerformed(evt);
            }
        });

        btnModificarPedido.setText("Modificar Pedido");
        btnModificarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarPedidoActionPerformed(evt);
            }
        });

        btnNuevoPedido.setText("Nuevo Pedido");
        btnNuevoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoPedidoActionPerformed(evt);
            }
        });

        jButton2.setText("Actualizar Productos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnEliminarPedido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModificarPedido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInsertarPedido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNuevoPedido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnNuevoPedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInsertarPedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminarPedido)
                .addGap(12, 12, 12)
                .addComponent(btnModificarPedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jButton2))
        );

        jLabel1.setText("Id del pedido: ");

        jLabel2.setText("Nombre del trabajador: ");

        jLabel3.setText("Estado del pedido: ");

        jLabel4.setText("Fecha del pedido: ");

        jLabel5.setText("Hora del pedido: ");

        jLabel6.setText("Nombre del cliente:");

        jLabel8.setText("Apellidos del cliente:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNombreTrabajador)
                                .addComponent(jLabel6)
                                .addComponent(txtNombreCliente))
                            .addComponent(jSpinnerIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(datePickerFechaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5)
                                            .addComponent(timePickerHoraPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jComboBoxEstadoPedido, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(86, 86, 86)))
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(txtApellidosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSpinnerIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxEstadoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(datePickerFechaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(timePickerHoraPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellidosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 18;
        gridBagConstraints.ipady = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 6, 0);
        add(jPanel1, gridBagConstraints);

        tablaProductos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        tablaProductos.setModel(modeloTablaProductos);
        jScrollPane2.setViewportView(tablaProductos);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 347;
        gridBagConstraints.ipady = 232;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 6, 6, 0);
        add(jScrollPane2, gridBagConstraints);

        jLabel7.setText("Productos");
        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 3, 36)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 87, 0, 0);
        add(jLabel7, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarPedidoActionPerformed
        int idPedido = (int) jSpinnerIdPedido.getValue();
        String fechaPedido = Date.valueOf(datePickerFechaPedido.getDate()).toString();
        String horaPedido = Time.valueOf(timePickerHoraPedido.getTime()).toString();
        String fechaHoraPedido = fechaPedido.concat(" "+horaPedido);
        if (ConsultasPedidos.existePedido(idPedido) != null) {
            ConsultasPedidos.modificarPedido(idPedido, jComboBoxEstadoPedido.getSelectedItem().toString(),Timestamp.valueOf(fechaHoraPedido));
            JOptionPane.showMessageDialog(null, "Pedido modificado");
            listarPedidos();
            limpiarTextos();
        } else {
            JOptionPane.showMessageDialog(null, "Pedido no registrado");
        }
    }//GEN-LAST:event_btnModificarPedidoActionPerformed

    private void btnEliminarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPedidoActionPerformed
        int idPedido = (int) jSpinnerIdPedido.getValue();
        if (ConsultasPedidos.existePedido(idPedido) != null) {
            ConsultasPedidos.eliminarPedido(idPedido);
            JOptionPane.showMessageDialog(null, "Pedido eliminado");
            listarPedidos();
            limpiarTextos();
        } else {
            JOptionPane.showMessageDialog(null, "Pedido no registrado");
        }
    }//GEN-LAST:event_btnEliminarPedidoActionPerformed

    private void btnInsertarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarPedidoActionPerformed
        int idPedido = (int) jSpinnerIdPedido.getValue();
        String fechaPedido = Date.valueOf(datePickerFechaPedido.getDate()).toString();
        String horaPedido = Time.valueOf(timePickerHoraPedido.getTime()).toString();
        String fechaHoraPedido = fechaPedido.concat(" "+horaPedido);
        Usuario userCliente = Consultas.existeUsuario(new Usuario(txtNombreCliente.getText(), txtApellidosCliente.getText(),""));
        Usuario userTrabajador = ConsultasUsuarios.existeUsuarioTrabajador(txtNombreTrabajador.getText());
        if (ConsultasPedidos.existePedido(idPedido) == null) {
            if (userCliente != null) {
                if (userTrabajador != null) {
                    boolean insertado = ConsultasPedidos.insertarPedido(idPedido,userTrabajador.getIdUsuario(), userCliente.getIdUsuario(), jComboBoxEstadoPedido.getSelectedItem().toString(),Timestamp.valueOf(fechaHoraPedido));
                    if (insertado) {
                        JOptionPane.showMessageDialog(null, "Pedido insertado", "Información", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "Pedido no insertado", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    listarPedidos();
                    limpiarTextos();
                }else {
                    JOptionPane.showMessageDialog(null, "Trabajador no registrado");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Cliente no registrado");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pedido ya registrado");
        }
    }//GEN-LAST:event_btnInsertarPedidoActionPerformed

    private void btnNuevoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoPedidoActionPerformed
        limpiarTextos();
        // Creamos una variable para hacer el id de la reserva automatico
        int ultimoIdPedido = 0;
        // Listamos todas las reservas 
        ArrayList<Pedido> pedidos = ConsultasPedidos.listarTodosLosPedidos();
        for (Pedido pedido : pedidos) {
            // Por cada reserva la varible va incrementandose
            ultimoIdPedido = pedido.getIdPedido();
        }
        // Y para tener el siguiente id de reserva 
        ultimoIdPedido++;
        // Y le damos el valor al spinner
        jSpinnerIdPedido.setValue((int) ultimoIdPedido);
        txtNombreTrabajador.requestFocus();
    }//GEN-LAST:event_btnNuevoPedidoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarPedido;
    private javax.swing.JButton btnInsertarPedido;
    private javax.swing.JButton btnModificarPedido;
    private javax.swing.JButton btnNuevoPedido;
    private com.github.lgooddatepicker.components.DatePicker datePickerFechaPedido;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBoxEstadoPedido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinnerIdPedido;
    private javax.swing.JTable tablaPedidos;
    private javax.swing.JTable tablaProductos;
    private com.github.lgooddatepicker.components.TimePicker timePickerHoraPedido;
    private javax.swing.JTextField txtApellidosCliente;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNombreTrabajador;
    // End of variables declaration//GEN-END:variables

    private void llenarModeloTabla() {
        modeloTablaPedidos.addColumn("Id del Pedido");
        modeloTablaPedidos.addColumn("Trabajador");
        modeloTablaPedidos.addColumn("Cliente");
        modeloTablaPedidos.addColumn("Apellidos");
        modeloTablaPedidos.addColumn("Estado");
        modeloTablaPedidos.addColumn("Fecha del pedido");
        modeloTablaPedidos.addColumn("Hora del pedido");
        tablaPedidos.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                jSpinnerIdPedido.setValue(Integer.parseInt(tablaPedidos.getValueAt(tablaPedidos.getSelectedRow(), 0).toString()));
                txtNombreTrabajador.setText(tablaPedidos.getValueAt(tablaPedidos.getSelectedRow(), 1).toString());
                txtNombreCliente.setText(tablaPedidos.getValueAt(tablaPedidos.getSelectedRow(), 2).toString());
                txtApellidosCliente.setText(tablaPedidos.getValueAt(tablaPedidos.getSelectedRow(), 3).toString());
                jComboBoxEstadoPedido.setSelectedItem(tablaPedidos.getValueAt(tablaPedidos.getSelectedRow(), 4).toString());
                datePickerFechaPedido.setDate(LocalDate.parse(tablaPedidos.getValueAt(tablaPedidos.getSelectedRow(), 5).toString()));
                timePickerHoraPedido.setTime(LocalTime.parse(tablaPedidos.getValueAt(tablaPedidos.getSelectedRow(), 6).toString()));
                llenarTablaProductos();
            }
        });
    }

    private void listarPedidos() {
        String nombreTrabajador = "", nombreCliente = "", apellidosCliente = "";
        int numFilas = modeloTablaPedidos.getRowCount();
        for (int i = 0; i < numFilas; i++) {
            modeloTablaPedidos.removeRow(0);
        }
        ArrayList<Pedido> pedidos = ConsultasPedidos.listarTodosLosPedidos();
        ArrayList<Usuario> usuarios = Consultas.ListarUsuarios();
        for (Pedido p : pedidos) {
            for (Usuario u : usuarios) {
                if (u.getIdUsuario() == p.getIdTrabajador()) {
                    nombreTrabajador = u.getNombre();
                } else if (u.getIdUsuario() == p.getIdCliente()) {
                    nombreCliente = u.getNombre();
                    apellidosCliente = u.getApellidos();
                }
            }
            String datos[] = {String.valueOf(p.getIdPedido()), nombreTrabajador, nombreCliente, apellidosCliente, p.getEstadoPedido(), String.valueOf(p.getFechaHoraPedido().toString().subSequence(0, 10)),String.valueOf(p.getFechaHoraPedido().toString().substring(11,16))};
            modeloTablaPedidos.addRow(datos);
        }
    }

    private void limpiarTextos() {
        jSpinnerIdPedido.setValue((int) 0);
        txtNombreTrabajador.setText("");
        jComboBoxEstadoPedido.setSelectedIndex(0);
        txtNombreCliente.setText("");
        txtApellidosCliente.setText("");
        datePickerFechaPedido.setDate(LocalDate.now());
        timePickerHoraPedido.setTime(LocalTime.now());
    }

    private void llenarTablaProductos() {
        int idPedido = 0, idProducto = 0;
        int numFilas = modeloTablaProductos.getRowCount();
        for (int i = 0; i < numFilas; i++) {
            modeloTablaProductos.removeRow(0);
        }
        ArrayList<Producto> productos = Consultas.ListarProductos();
        ArrayList<Productos_Pedidos> productosPedidos = Consultas.ListarProductos_Pedidos();
        for (Producto pro : productos) {
            idProducto = pro.getIdProducto();
            idPedido = Integer.parseInt(tablaPedidos.getValueAt(tablaPedidos.getSelectedRow(), 0).toString());
            for (Productos_Pedidos p : productosPedidos) {
                if (idPedido == p.getIdPedido()) {
                    if (idProducto == p.getIdProducto()) {
                        String datos[] = {pro.getNombreProducto(), String.valueOf(p.getCantidadProducto()), String.valueOf(pro.getPrecioProducto()), String.valueOf(pro.getPrecioProducto() * p.getCantidadProducto())};
                        modeloTablaProductos.addRow(datos);
                    }
                }
            }
        }
    }

    private void modeloTablaProductosPedidos() {
        modeloTablaProductos.addColumn("Nombre Producto");
        modeloTablaProductos.addColumn("Cantidad");
        modeloTablaProductos.addColumn("Precio Unidad");
        modeloTablaProductos.addColumn("Total Producto");
    }
    
    /**
     * Metodo que llena el combo box
     */
    private void llenarComboBox(){
        jComboBoxEstadoPedido.addItem("");
        jComboBoxEstadoPedido.addItem("En preparación");
        jComboBoxEstadoPedido.addItem("Sin pagar");
        jComboBoxEstadoPedido.addItem("Pagado");
    }

}
