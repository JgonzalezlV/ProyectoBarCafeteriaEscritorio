/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventanas;

import controlador.ConexionDB;
import controlador.Consultas;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import modelo.Trabajador;
import modelo.Usuario;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 * Esta es la ventana principal
 *
 * @author Esme
 */
public class VentanaPrincipalEscritorio extends JFrame implements ActionListener {

    private JPanel panelSuperior, panelInferior;
    private JTabbedPane panelCentral;
    private JButton[] botones;
    private final String[] nombreImagenes = {"abrir.jpg", "guardar.png", "salir.png", "informe.png", "web.png"};
    private JToolBar barraHerramientas;
    private final String[] titulosPanelesAdministrador = {"Gestión Mesas", "Gestión Usuarios", "Gestión Clientes", "Gestión Trabajadores", "Gestión Reservas", "Gestión Productos", "Gestión Pedidos", "Insertar productos a pedidos"};
    private final String[] titulosPaneles = {"Gestión Pedidos", "Insertar productos a pedidos"};
    private final int[] mnemotecnicosPestaniasAdministrador = {KeyEvent.VK_1, KeyEvent.VK_2, KeyEvent.VK_3, KeyEvent.VK_4, KeyEvent.VK_5, KeyEvent.VK_6, KeyEvent.VK_7, KeyEvent.VK_8};
    private final int[] mnemotecnicosPestanias = {KeyEvent.VK_1, KeyEvent.VK_2, KeyEvent.VK_3};
    private String enlaceWeb = "https://sites.google.com/view/cafeterabar/inicio";

    /**
     * Constructor de la ventana principal.
     *
     * @param telefono --> Es el telefono del usuario logueado.
     */
    public VentanaPrincipalEscritorio(String telefono) {
        // Se da tamaño a la ventana
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        /*setMaximumSize(new Dimension(JFrame.MAXIMIZED_HORIZ, JFrame.MAXIMIZED_VERT));
        setMinimumSize(new Dimension(1000, 600));*/
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Gestión Bar/Cafetería");
        setLocationRelativeTo(null);
        // Se pone un icono para que salga en la barra de herramientas del sistema
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.png")).getImage());
        // Se llama a este metodo y se da visibilidad a la ventana
        iniciarComponentes(telefono);
        setVisible(true);
    }

    /**
     * Metodo en el cual se inicializan los componentes de la ventana.
     *
     * @param telefono --> Es el telefono del usuario logueado.
     */
    private void iniciarComponentes(String telefono) {
        iniciarPanelSuperior();
        iniciarPanelCentral(telefono);
        iniciarPanelInferior(telefono);
    }

    /**
     * Metodo en el que se crea y se incluye a la ventana el panel superior.
     */
    private void iniciarPanelSuperior() {
        panelSuperior = new JPanel();
        // Se inicializa la barra de herramientas de la aplicacion
        barraHerramientas = new JToolBar();
        // Establecemos el layout del panel superior
        panelSuperior.setLayout(new FlowLayout(FlowLayout.LEFT));
        // Inicializamos el array de botones
        botones = new JButton[nombreImagenes.length];
        // Recorremos ese array
        for (int i = 0; i < botones.length; i++) {
            // Inicializamos los botones
            botones[i] = new JButton();
            // Damos a dichos botones propiedades y eventos
            botones[i].setIcon(new ImageIcon(getClass().getResource("/imagenes/" + nombreImagenes[i])));
            botones[i].setName(nombreImagenes[i]);
            botones[i].addActionListener(this);
            // Y los insertamos en la barra de herramientas
            barraHerramientas.add(botones[i]);
        }
        // Insertamos la barra de herramientas al panel y dicho panel a la ventana al norte
        panelSuperior.add(barraHerramientas);
        add(panelSuperior, BorderLayout.NORTH);

    }

    /**
     * Metodo donde se crea y se suma a la ventana el panel central.
     *
     * @param telefono --> Es el telefono del usuario logueado.
     */
    private void iniciarPanelCentral(String telefono) {
        // Con el telefono comprobamos si existe el usuario
        Usuario user = Consultas.existeUsuario("usuarios", new Usuario(telefono));
        // Como en este punto existe el usuario guardamos el id
        int idUsuario = user.getIdUsuario();
        // Creamos un objeto de la clase Trabajador para conseguir su categoria
        Trabajador trabajador = Consultas.existeTrabajador(new Trabajador(idUsuario));
        // Que la categoria es Administrador tiene acceso a todas las siguientes pestañas 
        if (trabajador.getCategoria().equalsIgnoreCase("Administrador")) {
            // Se inicializa el panel central
            panelCentral = new JTabbedPane();
            JPanel[] paneles = new JPanel[titulosPanelesAdministrador.length];
            panelCentral.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
            for (int i = 0; i < paneles.length; i++) {
                paneles[i] = new JPanel();
                paneles[i].setLayout(new GridLayout(1, 1));
                switch (titulosPanelesAdministrador[i]) {
                    // Segun los titulos de los paneles saldran uno u otro panel 
                    case "Gestión Usuarios" ->
                        paneles[i].add(new GestionUsuarios());
                    case "Gestión Clientes" ->
                        paneles[i].add(new GestionClientes());
                    case "Gestión Trabajadores" ->
                        paneles[i].add(new GestionTrabajadores());
                    case "Gestión Reservas" ->
                        paneles[i].add(new GestionReservas());
                    case "Gestión Mesas" ->
                        paneles[i].add(new GestionMesas());
                    case "Gestión Pedidos" ->
                        paneles[i].add(new GestionPedidos());
                    case "Gestión Productos" ->
                        paneles[i].add(new GestionProductos());
                    case "Insertar productos a pedidos" ->
                        paneles[i].add(new GestionProductos_Pedidos());
                }
                // Se introduce los paneles al panel central, se le asignan titulos y mnemotecnicos
                panelCentral.add(paneles[i]);
                panelCentral.setTitleAt(i, titulosPanelesAdministrador[i]);
                panelCentral.setMnemonicAt(i, mnemotecnicosPestaniasAdministrador[i]);
            }
            // Si en la categoria es camarero, solo tendra acceso a la gestion de pedidos e insertar productos a esos pedidos
        } else if (trabajador.getCategoria().equalsIgnoreCase("Camarero")) {
            panelCentral = new JTabbedPane();
            JPanel[] paneles = new JPanel[titulosPaneles.length];
            panelCentral.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
            for (int i = 0; i < paneles.length; i++) {
                paneles[i] = new JPanel();
                paneles[i].setLayout(new GridLayout(1, 1));
                switch (titulosPaneles[i]) {
                    case "Gestión Pedidos" ->
                        paneles[i].add(new GestionPedidos());
                    case "Insertar productos a pedidos" ->
                        paneles[i].add(new GestionProductos_Pedidos());
                    default -> {
                    }
                }
                panelCentral.add(paneles[i]);
                panelCentral.setTitleAt(i, titulosPaneles[i]);
                panelCentral.setMnemonicAt(i, mnemotecnicosPestanias[i]);
            }
            // Y si la categoria es cocinero solo prodra gestionar los productos
        } else if (trabajador.getCategoria().equals("Cocinero")) {
            panelCentral = new JTabbedPane();
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(1, 1));
            panelCentral.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
            panel.add(new GestionProductos());
            panelCentral.add(panel);
            panelCentral.setTitleAt(0, "Gestión Productos");
            panelCentral.setMnemonicAt(0, KeyEvent.VK_1);
        }
        // Y por ultimo, se inserta a la ventana.
        add(panelCentral, BorderLayout.CENTER);
    }

    /**
     * Metodo donde se crea y se inserta a la ventana el panel inferior.
     *
     * @param telefono --> Es el telefono del usuario logueado.
     */
    private void iniciarPanelInferior(String telefono) {
        // Con el telefono logro obtener el usuario al completo
        Usuario user = Consultas.existeUsuario("usuarios", new Usuario(telefono));
        int idUsuario = user.getIdUsuario();
        // Para conseguir el la categoria llamo al siguiente metodo
        Trabajador trabajador = Consultas.existeTrabajador(new Trabajador(idUsuario));
        // Inicializo el panel inferior
        panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        // Creo una etiqueta para mostrar el nombre, apellidos y la categoria del trabajador logueado 
        JLabel label = new JLabel("Usuario: " + user.getNombre() + ", Apellidos: " + user.getApellidos() + ", Categoría: " + trabajador.getCategoria());
        // Se incluye la etiqueta al panel inferior y este mismo a la ventana
        panelInferior.add(label);
        add(panelInferior, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();
        switch (boton.getName()) {
            //Hacer metodo para abrir ficheros u otra cosa
            case "abrir.jpg" -> {

            }
            //Hacer metodo para guardar ficheros u otra cosa
            case "guardar.png" -> {

            }
            // Pinta de nuevo el login
            case "salir.png" -> {
                new VentanaLogin();
                dispose();
            }
            // Muestra el informe de cierre de caja
            case "informe.png" -> {
                cierreCaja();
            }
            // Te redirecciona al sitio web del bar/cafeteria
            case "web.png" -> {
                try {
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + enlaceWeb);
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }

    }

    /**
     * Metodo que genera un informe de cierre de caja
     */
    private void cierreCaja() {
        try {
            //Indicamos las carpetas donde se encuentra el origen y destino del informe
            String reportSource = "src/informes/plantillas/informesClientes.jrxml";
            String reportDest = "src/informes/resultados/informesClientes.html";
            //Crear un mapa para guardar parametros que podemos pasar al informe
            Map<String, Object> params = new HashMap<>();
            //Compilamos el informe .jrxml  para generar el .jasper
            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
            //Creamos la conexion a la bd para poder rellenar el .jasper con los datos de la bd
            ConexionDB cbd = new ConexionDB();
            Connection conn = cbd.abrirConexion();
            //Cargamos los datos en el jasper pasandole los parámetros y la conexion a la BD
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);
            //Exportamos el informe
            JasperExportManager.exportReportToHtmlFile(jasperPrint, reportDest);
            //Y lo visualizamos
            JasperViewer jviewer = new JasperViewer(jasperPrint, false);
            jviewer.show();
        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }

}
