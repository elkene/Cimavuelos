package GUI;

import java.awt.EventQueue;
import java.util.stream.Collectors;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import proyecto.Control;
import proyecto.Pasajero;
import proyecto.Reservacion;
import proyecto.Vuelo;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JSeparator;

public class Inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	public static JPanel panel_1;
	private JLabel labelPersonalizado;
	private JButton registrarseBtn;
	private JButton iniciarSesionBtn;
	private JButton cerrarSesionBtn;
	private JMenuItem menuItemReservas;
	private JTable table;
	private JComboBox<?> ordenarCbx;
	private ArrayList<Vuelo> vuelos;
	private JTextField maxtxt;
	private JTextField mintxt;
	private JLabel avionlbl;
	private JLabel nube6;
	private JLabel nube1;
	private JLabel nube4;
	private JLabel nube11;
	private JLabel nube8;
	private JLabel nube10;
	private JLabel nube7;
	private JLabel nube3;
	private JLabel nube9;
	private JLabel nube5;
	private JLabel nube2;
	private JCheckBox cdmxDestino;
	private JCheckBox chiapasDestino;
	private JCheckBox oaxacaDestino;
	private JCheckBox yucatanDestino;
	private JCheckBox cdmxOrigen;
	private JCheckBox tjOrigen;
	private JCheckBox mtyOrigen;
	private JCheckBox gdlDestino;
	private JTable tableReservaciones;

	// Launch the application.
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
			
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException| UnsupportedLookAndFeelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Create the frame.
	public Inicio() {
		Control.leerArchivoRegistros(); // cargar los datos
		setTitle("Inicio");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/IMG/billeteDeAvion.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 920, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(130, 220, 236));
		panel.setBounds(0, 0, 917, 63);
		contentPane.add(panel);
		panel.setLayout(null);
		
		registrarseBtn = new JButton("Registrarse");
		registrarseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarse();
			}
		});
		registrarseBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		registrarseBtn.setBounds(628, 20, 127, 33);
		panel.add(registrarseBtn);
		
		iniciarSesionBtn = new JButton("Iniciar Sesión");
		iniciarSesionBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciarsesion();
			}
		});
		iniciarSesionBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		iniciarSesionBtn.setBounds(769, 20, 127, 33);
		panel.add(iniciarSesionBtn);
		
		JLabel lblNewLabel = new JLabel("CimaVuelos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(73, 12, 234, 41);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Inicio.class.getResource("/IMG/viajarLogo.png")));
		lblNewLabel_1.setBounds(10, 0, 59, 63);
		panel.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 62, 917, 480);
		contentPane.add(scrollPane);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		scrollPane.setColumnHeaderView(menuBar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Inicio");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// muestro el panel de Inicio
				CardLayout c = (CardLayout)(panel_1.getLayout());
				c.show(panel_1, "pInicio");
			}
		});
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Vuelos");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// muestro el panel de Vuelos
				CardLayout c = (CardLayout)(panel_1.getLayout());
				c.show(panel_1, "pVuelos");
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mntmNewMenuItem_1);
		
		menuItemReservas = new JMenuItem("Mis reservas");
		menuItemReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// muestro el panel de Reservas
				CardLayout c = (CardLayout)(panel_1.getLayout());
				c.show(panel_1, "pReservas");
				actualizarTablaReservaciones();
			}
		});
		menuItemReservas.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(menuItemReservas);
		menuItemReservas.setVisible(false); // inicializar este menu oculto
		
		panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));
		
		JPanel panelInicio = new JPanel();
		panel_1.add(panelInicio, "pInicio");
		panelInicio.setLayout(null);
		
		JLabel lblNewLabel_5_2_1 = new JLabel("¡Bienvenido a CimaVuelos!");
		lblNewLabel_5_2_1.setBounds(319, 38, 315, 25);
		lblNewLabel_5_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		panelInicio.add(lblNewLabel_5_2_1);
		
		JLabel lblNewLabel_5_2_1_1 = new JLabel("Derechos reservados de K&M Enterprises");
		lblNewLabel_5_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5_2_1_1.setBounds(35, 410, 341, 21);
		panelInicio.add(lblNewLabel_5_2_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		ImageIcon originalIcon = (new ImageIcon(Inicio.class.getResource("/IMG/Copyright.svg.png")));
		Image scaledImage = originalIcon.getImage().getScaledInstance(20, 15, Image.SCALE_SMOOTH);
		
		avionlbl = new JLabel("");
		avionlbl.setIcon(new ImageIcon(Inicio.class.getResource("/IMG/avion.png")));
		avionlbl.setBounds(10, 76, 70, 70);
		panelInicio.add(avionlbl);
		lblNewLabel_1_1.setIcon(new ImageIcon(scaledImage));
		lblNewLabel_1_1.setBounds(10, 410, 26, 21);
		panelInicio.add(lblNewLabel_1_1);
		
		nube2 = new JLabel("");
		nube2.setIcon(new ImageIcon(Inicio.class.getResource("/IMG/nube.png")));
		nube2.setBounds(35, 282, 55, 52);
		panelInicio.add(nube2);
		
		nube5 = new JLabel("");
		nube5.setIcon(new ImageIcon(Inicio.class.getResource("/IMG/nube.png")));
		nube5.setBounds(399, 88, 55, 52);
		panelInicio.add(nube5);
		
		nube9 = new JLabel("");
		nube9.setIcon(new ImageIcon(Inicio.class.getResource("/IMG/nube.png")));
		nube9.setBounds(631, 231, 55, 52);
		panelInicio.add(nube9);
		
		nube3 = new JLabel("");
		nube3.setIcon(new ImageIcon(Inicio.class.getResource("/IMG/nube.png")));
		nube3.setBounds(215, 129, 55, 52);
		panelInicio.add(nube3);
		
		nube7 = new JLabel("");
		nube7.setIcon(new ImageIcon(Inicio.class.getResource("/IMG/nube.png")));
		nube7.setBounds(425, 323, 55, 52);
		panelInicio.add(nube7);
		
		nube10 = new JLabel("");
		nube10.setIcon(new ImageIcon(Inicio.class.getResource("/IMG/nube.png")));
		nube10.setBounds(774, 299, 55, 52);
		panelInicio.add(nube10);
		
		nube8 = new JLabel("");
		nube8.setIcon(new ImageIcon(Inicio.class.getResource("/IMG/nube.png")));
		nube8.setBounds(579, 129, 55, 52);
		panelInicio.add(nube8);
		
		nube11 = new JLabel("");
		nube11.setIcon(new ImageIcon(Inicio.class.getResource("/IMG/nube.png")));
		nube11.setBounds(813, 163, 55, 52);
		panelInicio.add(nube11);
		
		nube4 = new JLabel("");
		nube4.setIcon(new ImageIcon(Inicio.class.getResource("/IMG/nube.png")));
		nube4.setBounds(225, 312, 55, 52);
		panelInicio.add(nube4);
		
		nube6 = new JLabel("");
		nube6.setIcon(new ImageIcon(Inicio.class.getResource("/IMG/nube.png")));
		nube6.setBounds(352, 209, 55, 52);
		panelInicio.add(nube6);
		
		nube1 = new JLabel("");
		nube1.setIcon(new ImageIcon(Inicio.class.getResource("/IMG/nube.png")));
		nube1.setBounds(0, 129, 55, 52);
		panelInicio.add(nube1);
		
		JPanel panelVuelos = new JPanel();
		panel_1.add(panelVuelos, "pVuelos");
		panelVuelos.setLayout(null);
		
		JLabel lblNewLabel_5_2_2 = new JLabel("Vuelos");
		lblNewLabel_5_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_2_2.setBounds(459, 40, 173, 25);
		lblNewLabel_5_2_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		panelVuelos.add(lblNewLabel_5_2_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(196, 86, 697, 307);
		panelVuelos.add(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"No. Vuelo", "Puerta", "Origen", "Destino", "Fecha", "Hora de Salida", "Hora de Llegada", "Costo"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(6).setResizable(false);
		table.getColumnModel().getColumn(7).setResizable(false);
		
		scrollPane_1.setViewportView(table);
		
		JLabel lblNewLabel_5_2_2_1 = new JLabel("Por origen:");
		lblNewLabel_5_2_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5_2_2_1.setBounds(20, 40, 91, 25);
		panelVuelos.add(lblNewLabel_5_2_2_1);
		
		JLabel lblNewLabel_5_2_2_2 = new JLabel("Filtrar vuelos");
		lblNewLabel_5_2_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5_2_2_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5_2_2_2.setBounds(20, 10, 148, 33);
		panelVuelos.add(lblNewLabel_5_2_2_2);
		
		JLabel lblNewLabel_5_2_2_2_1 = new JLabel("Ordenar vuelos");
		lblNewLabel_5_2_2_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5_2_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5_2_2_2_1.setBounds(20, 328, 164, 25);
		panelVuelos.add(lblNewLabel_5_2_2_2_1);
		
		JLabel lblNewLabel_5_2_2_1_1 = new JLabel("Por:");
		lblNewLabel_5_2_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5_2_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5_2_2_1_1.setBounds(20, 356, 49, 25);
		panelVuelos.add(lblNewLabel_5_2_2_1_1);
		
		ordenarCbx = new JComboBox();
		ordenarCbx.setModel(new DefaultComboBoxModel(new String[] {"", "Origen", "Destino", "Fecha", "Precio"}));
		ordenarCbx.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ordenarCbx.setBounds(68, 358, 103, 21);
		panelVuelos.add(ordenarCbx);
		
		JButton btnAplicar = new JButton("Aplicar");
		btnAplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtrarYordenar(); // filtra y ordena los vuelos
			}
		});
		btnAplicar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAplicar.setBounds(38, 391, 121, 33);
		panelVuelos.add(btnAplicar);
		
		JLabel lblNewLabel_5_2_2_1_3 = new JLabel("Por destino:");
		lblNewLabel_5_2_2_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5_2_2_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5_2_2_1_3.setBounds(20, 124, 112, 25);
		panelVuelos.add(lblNewLabel_5_2_2_1_3);
		
		gdlDestino = new JCheckBox("Guadalajara");
		gdlDestino.setFont(new Font("Tahoma", Font.PLAIN, 15));
		gdlDestino.setBounds(30, 182, 138, 19);
		panelVuelos.add(gdlDestino);
		
		JLabel lblNewLabel_5_2_2_1_2_1 = new JLabel("Por precio:");
		lblNewLabel_5_2_2_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5_2_2_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5_2_2_1_2_1.setBounds(20, 243, 91, 21);
		panelVuelos.add(lblNewLabel_5_2_2_1_2_1);
		
		maxtxt = new JTextField();
		maxtxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		maxtxt.setColumns(10);
		maxtxt.setBounds(107, 282, 77, 19);
		panelVuelos.add(maxtxt);
		// validar que solo se ingresen numeros
		maxtxt.addKeyListener(new KeyAdapter() {
			String temp;
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				// verificar que solo se puedan ingresar numeros
				if ( (caracter < '0' || caracter > '9') &&
					caracter != '\b' &&
					caracter != '.') { // backspace
					e.consume(); // ignora el evento
				}
				temp = maxtxt.getText();
			}
			
			public void keyReleased(KeyEvent arg0) {
				String v = maxtxt.getText().trim();
				float f;
				
				try {
					// trata de covertir
					if (!v.equals(""))
						f = Float.parseFloat(v);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Valor invalido");
					maxtxt.setText(temp);
				}
			}
		});
		
		mintxt = new JTextField();
		mintxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mintxt.setColumns(10);
		mintxt.setBounds(20, 282, 77, 19);
		panelVuelos.add(mintxt);
		// validar que solo se puedan ingresar numeros
		mintxt.addKeyListener(new KeyAdapter() {
			String temp;
			public void keyTyped(KeyEvent e) {
				
				char caracter = e.getKeyChar();
				// verificar que solo se puedan ingresar numeros
				if ( (caracter < '0' || caracter > '9') &&
					caracter != '\b' &&
					caracter != '.') { // backspace
					e.consume(); // ignora el evento
				}
				temp = mintxt.getText();
			}
			
			public void keyReleased(KeyEvent arg0) {
				String v = mintxt.getText().trim();
				float f;
				
				try {
					// trata de covertir
					if (!v.equals(""))
						f = Float.parseFloat(v);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Valor invalido");
					mintxt.setText(temp);
				}
			}
		});
		
		JLabel lblNewLabel_5_2_2_1_2_1_1 = new JLabel("Mínimo:");
		lblNewLabel_5_2_2_1_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5_2_2_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5_2_2_1_2_1_1.setBounds(20, 261, 77, 25);
		panelVuelos.add(lblNewLabel_5_2_2_1_2_1_1);
		
		JLabel lblNewLabel_5_2_2_1_2_1_1_1 = new JLabel("Máximo:");
		lblNewLabel_5_2_2_1_2_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5_2_2_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5_2_2_1_2_1_1_1.setBounds(107, 261, 77, 25);
		panelVuelos.add(lblNewLabel_5_2_2_1_2_1_1_1);
		
		cdmxDestino = new JCheckBox("CDMX");
		cdmxDestino.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cdmxDestino.setBounds(30, 145, 138, 21);
		panelVuelos.add(cdmxDestino);
		
		chiapasDestino = new JCheckBox("Chiapas");
		chiapasDestino.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chiapasDestino.setBounds(30, 164, 121, 21);
		panelVuelos.add(chiapasDestino);
		
		oaxacaDestino = new JCheckBox("Oaxaca");
		oaxacaDestino.setFont(new Font("Tahoma", Font.PLAIN, 15));
		oaxacaDestino.setBounds(30, 199, 121, 21);
		panelVuelos.add(oaxacaDestino);
		
		yucatanDestino = new JCheckBox("Yucatan");
		yucatanDestino.setFont(new Font("Tahoma", Font.PLAIN, 15));
		yucatanDestino.setBounds(30, 218, 138, 19);
		panelVuelos.add(yucatanDestino);
		
		cdmxOrigen = new JCheckBox("CDMX");
		cdmxOrigen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cdmxOrigen.setBounds(30, 62, 138, 21);
		panelVuelos.add(cdmxOrigen);
		
		mtyOrigen = new JCheckBox("Monterrey");
		mtyOrigen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mtyOrigen.setBounds(30, 81, 121, 21);
		panelVuelos.add(mtyOrigen);
		
		tjOrigen = new JCheckBox("Tijuana");
		tjOrigen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tjOrigen.setBounds(30, 99, 138, 25);
		panelVuelos.add(tjOrigen);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 318, 176, 2);
		panelVuelos.add(separator);
		llenarTabla();
		// mostrar informacion al seleccionar un vuelo
		table.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		    	if (e.getClickCount() == 2) { // verificar que se haga doble click			     
			        int filaSeleccionada = table.getSelectedRow(); // obtengo la fila seleccionada
			        int numVuelo = Integer.parseInt(table.getValueAt(filaSeleccionada, 0).toString()); // obtengo el numero de vuelo de la linea que se selecciono
			        // busco el vuelo por su numero
			        Vuelo vueloSeleccionado = vuelos.stream()
			        		.filter( v -> v.getNumVuelo() == (numVuelo)) // si los numeros de vuelo son iguales
			        		.findFirst() // guarda el primero que encuentra
			        		.orElse(null); // o regresa vacio si no encuentra una coincidencia
			        
			        if (vueloSeleccionado != null) {			       
			        	seleccionarAsientos(vueloSeleccionado); // creo la interfaz y le paso el vuelo seleccionado
			        }
		    	}
		    }
		});
		
		JPanel panelReservas = new JPanel();
		panel_1.add(panelReservas, "pReservas");
		panelReservas.setLayout(null);
		
		JLabel lblNewLabel_5_2_3 = new JLabel("Mis Reservas");
		lblNewLabel_5_2_3.setBounds(384, 39, 138, 25);
		lblNewLabel_5_2_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		panelReservas.add(lblNewLabel_5_2_3);
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(106, 95, 697, 307);
		panelReservas.add(scrollPane_1_1);
		
		tableReservaciones = new JTable();
		tableReservaciones.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tableReservaciones.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"No. Reservaci\u00F3n", "Fecha de Reservaci\u00F3n", "No. Vuelo"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableReservaciones.getColumnModel().getColumn(0).setResizable(false);
		tableReservaciones.getColumnModel().getColumn(1).setResizable(false);
		tableReservaciones.getColumnModel().getColumn(2).setResizable(false);
		scrollPane_1_1.setViewportView(tableReservaciones);
		actualizarTablaReservaciones();
		// mostrar informacion al seleccionar una reservacion
		tableReservaciones.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		    	if (e.getClickCount() == 2) { // verificar que se haga doble click			     
			        int filaSeleccionada = tableReservaciones.getSelectedRow(); // obtengo la fila seleccionada
			        int numVuelo = Integer.parseInt(tableReservaciones.getValueAt(filaSeleccionada, 2).toString()); // obtengo el numero de vuelo de la linea que se selecciono
			        // busco el vuelo por su numero
			        Vuelo vueloSeleccionado = vuelos.stream()
			        		.filter( v -> v.getNumVuelo() == (numVuelo)) // si los numeros de vuelo son iguales
			        		.findFirst() // guarda el primero que encuentra
			        		.orElse(null); // o regresa vacio si no encuentra una coincidencia
			        
			        if (vueloSeleccionado != null) {			       
			        	detallesReservacion(vueloSeleccionado); // creo la interfaz y le paso el vuelo seleccionado
			        }
		    	}
		    }
		});
		
		animacionAvion(); // activa la animacion de avion
		animacionNubes(); // activa la animacion de nubes
		
	}
	
	// llenar la tabla de los vuelos disponibles
	private void llenarTabla() {
		Control.inicializarVuelos(); // inicializo los vuelos
		vuelos = Control.getVuelos(); // traigo el array del gestor
		
		// creo el modelo de la tabla, es como la estructura
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0); // quito los reglones que tenga
		
		for (Vuelo v: vuelos) { // recorro la lista
			model.addRow(new Object[] {v.getNumVuelo(), v.getPuerta(), v.getOrigen(), v.getDestino(), v.getFecha(), v.getHoraSalida(), v.getHoraLlegada(), v.getCosto()});
		}
		
		table.repaint(); // repinto la tabla
	}
	
	// llenar la tabla de las reservaciones
	private void llenarTablaReservaciones(List<Reservacion> reservaciones) {
		// creo el modelo de la tabla, es como la estructura
		DefaultTableModel model = (DefaultTableModel) tableReservaciones.getModel();
		model.setRowCount(0); // quito los reglones que tenga
		
		for (Reservacion r: reservaciones) { // recorro la lista
			model.addRow(new Object[] {r.getNumReservacion(), r.getFechaReservacion(), r.getNumVuelo()});
		}
		
		tableReservaciones.repaint(); // repinto la tabla
	}
	
	// metodo para actualizar la tabla de reservaciones
	private void actualizarTablaReservaciones() {
		if (Control.getPasajeroActual() != null) {
			List<Reservacion> reservaciones = Control.obtenerReservaciones(Control.getPasajeroActual().getCorreo());
			llenarTablaReservaciones(reservaciones);
		}
	}
	
    // metodo para cambiar la perspectiva cuando se Inicia Sesion 
    public void usuarioActivo() {
    	Pasajero pasajero = Control.getPasajeroActual();
    	
    	// Desactivar
    	registrarseBtn.setVisible(false);
    	iniciarSesionBtn.setVisible(false);
    	// Activar
    	menuItemReservas.setVisible(true); // activamos la pestaña de Mis Reservas
    	actualizarTablaReservaciones();
    	
    	// agregar Label personalizado
		labelPersonalizado = new JLabel("Bienvenido, " + pasajero.getPrimerNombre() + " " + pasajero.getApellidoPaterno());
		labelPersonalizado.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelPersonalizado.setBounds(500, 26, 341, 21);
		panel.add(labelPersonalizado);
		labelPersonalizado.setVisible(true); // ocultar la etiqueta
		
		// agregar boton para cerrar sesion
		cerrarSesionBtn = new JButton("Cerrar Sesión");
		cerrarSesionBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usuarioInactivo();
				// muestro el panel de Inicio
				CardLayout c = (CardLayout)(panel_1.getLayout());
				c.show(panel_1, "pInicio");
				JOptionPane.showMessageDialog(null, "Se cerró su sesión.", "Cerrar Sesión", -1); 				
			}
		});
		cerrarSesionBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cerrarSesionBtn.setBounds(769, 20, 127, 33);
		panel.add(cerrarSesionBtn);
    }
    
    // metodo para cambiar la perspectiva cuando se Cierra Sesion 
    public void usuarioInactivo() {
    	// Desactivar
    	menuItemReservas.setVisible(false);
    	cerrarSesionBtn.setVisible(false);
    	labelPersonalizado.setVisible(false);
    	// Activar
    	registrarseBtn.setVisible(true);
    	iniciarSesionBtn.setVisible(true);
    	// remover el pasajero actual
    	Control.setPasajeroActual(null);
    }
    
    // metodo para filtrar vuelos
    public void filtrarYordenar() {
    	Predicate<Vuelo> filtroOrigen = v -> false;
    	Predicate<Vuelo> filtroDestino = v -> false;
    	Predicate<Vuelo> filtroPrecio = v -> true;
    	// Origen
    	if (cdmxOrigen.isSelected()) { // CDMX
    		filtroOrigen = filtroOrigen.or(v -> v.getOrigen().equals("CDMX"));  
    	}
    	if (mtyOrigen.isSelected()) { // Monterrey
    		filtroOrigen = filtroOrigen.or(v -> v.getOrigen().equals("Monterrey"));
    	}
    	if (tjOrigen.isSelected()) { // Tijuana
    		filtroOrigen = filtroOrigen.or(v -> v.getOrigen().equals("Tijuana"));
    	}
    	// si no se selecciona ningun origen
    	if (!cdmxOrigen.isSelected() && !mtyOrigen.isSelected() && !tjOrigen.isSelected()) {
    		filtroOrigen = v -> true; // se aceptan todos los vuelos
    	}
    	// Destino
    	if (cdmxDestino.isSelected()) { // CDMX
    		filtroDestino = filtroDestino.or(v -> v.getDestino().equals("CDMX"));  
    	}
    	if (chiapasDestino.isSelected()) { // Chiapas
    		filtroDestino = filtroDestino.or(v -> v.getDestino().equals("Chiapas")); 
    	}
    	if (gdlDestino.isSelected()) { // Guadalajara
    		filtroDestino = filtroDestino.or(v -> v.getDestino().equals("Guadalajara"));
    	}
    	if (oaxacaDestino.isSelected()) { // Oaxaca
    		filtroDestino = filtroDestino.or(v -> v.getDestino().equals("Oaxaca"));
    	}
    	if (yucatanDestino.isSelected()) { // Yucatan
    		filtroDestino = filtroDestino.or(v -> v.getDestino().equals("Yucatan"));
    	}
    	// si no se selecciona ningun destino
    	if (!cdmxDestino.isSelected() && !chiapasDestino.isSelected() && !gdlDestino.isSelected() && !oaxacaDestino.isSelected() && !yucatanDestino.isSelected()) {
    		filtroDestino = v -> true; // se aceptan todos los vuelos
    	}
    	// Precio
    	if (mintxt != null && !mintxt.getText().isEmpty()) { // minimo
    		float minimo = Float.parseFloat(mintxt.getText());
    		filtroPrecio = filtroPrecio.and(v -> v.getCosto() > minimo);  
    	}
    	if (maxtxt != null && !maxtxt.getText().isEmpty()) { // maximo
    		float maximo = Float.parseFloat(maxtxt.getText());
    		filtroPrecio = filtroPrecio.and(v -> v.getCosto() < maximo); 
    	}
    	
    	Predicate<Vuelo> filtroCombinado = filtroOrigen.and(filtroDestino).and(filtroPrecio); // se combinan todos los filtros
    	
    	List<Vuelo> filtrados = vuelos.stream()  // filtra la lista original
    			.filter(filtroCombinado)
    			.collect(Collectors.toList());
    	
    	// Ordenar--------------------
    	List<Vuelo> ordenados;
    	
    	if (ordenarCbx.getSelectedItem().equals("Origen")) { // ordenar por Origen
    		ordenados = filtrados.stream() 
    				.sorted( (v1, v2) -> v1.origen.compareTo(v2.origen))  
    				.collect(Collectors.toList()); 
    	} else if (ordenarCbx.getSelectedItem().equals("Destino")) { // ordenar por Destino
    		ordenados = filtrados.stream() 
    				.sorted( (v1, v2) -> v1.destino.compareTo(v2.destino))  
    				.collect(Collectors.toList());
    	} else if (ordenarCbx.getSelectedItem().equals("Fecha")) { // ordenar por Fecha
    		ordenados = filtrados.stream() 
    				.sorted( (v1, v2) -> v1.getFecha().compareTo(v2.getFecha()))  
    				.collect(Collectors.toList());
    	} else if (ordenarCbx.getSelectedItem().equals("Precio")) { // ordenar por Precio
    		ordenados = filtrados.stream() 
    				.sorted( (v1, v2) -> Float.compare(v1.getCosto(), v2.getCosto()))  
    				.collect(Collectors.toList());
    	} else {
    		ordenados = filtrados;
    	}
    	
		// creo el modelo de la tabla para la nueva lista
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0); // quito los reglones que tenga
		
		for (Vuelo v: ordenados) { // recorro la lista
			model.addRow(new Object[] {v.getNumVuelo(), v.getPuerta(), v.getOrigen(), v.getDestino(), v.getFecha(), v.getHoraSalida(), v.getHoraLlegada(), v.getCosto()});
		}
		table.repaint(); // repinto la tabla
    }
    
    // metodo para animacion de avion
    public void animacionAvion() {
    	Runnable tarea = () -> { // inicializo mi Runnable
    		boolean bajando = true;
    		
    		while (true) {
    			int x = avionlbl.getX(); // obtengo su posicion en X
    			int y = avionlbl.getY(); // obtengo su posicion en Y
    			x += 5;
    			if(x > 920) { // si su posicion en X es mayor al largo de la ventana
    				x = -70; // posiciona el label en el comienzo de la ventana
    			}
    			
    			if (bajando) {
    				avionlbl.setBounds(x, y+5, 70, 70);
    				if (y >= 300) {
    					bajando = false;
    				}	
    			} else {
    				avionlbl.setBounds(x, y-5, 70, 70);
    				if (y <= 85) {
    					bajando = true;
    				}
    			}
				try {
					Thread.sleep(30); // suspencion 
				} catch(InterruptedException e) {}
    			
    		}
    	};
    	Thread hilo = new Thread(tarea);
    	hilo.start();
    }
    
    // metodo para mover las nubes
    public void animacionNubes() {
    	List<JLabel> nubes = Arrays.asList(nube1, nube2, nube3, nube4, nube5, nube6, nube7, nube8, nube9, nube10, nube11); 
    	Runnable tarea = () -> {
    		while (true) {
    			for (JLabel nube: nubes) {
    				int x = nube.getX();
    				int y = nube.getY();
    				x += 5;
    				if (x > 920) {
    					x = -70;
    				}
    				nube.setBounds(x, y, 70, 70);
    			}   		
    			try {
    				Thread.sleep(30); // suspencion 
    			} catch(InterruptedException e) {}
    		}
    	};
    	Thread hilo = new Thread(tarea);
    	hilo.start();
    	
    }
    
	// creacion de ventanas
	public void iniciarsesion() {
		IniciarSesion v = new IniciarSesion(this);
		v.setVisible(true);
	}
	public void registrarse() {
		Registrarse v = new Registrarse();
		v.setVisible(true);
	}
	public void seleccionarAsientos(Vuelo vuelo) {
		SeleccionarAsientos v = new SeleccionarAsientos(vuelo);
		v.setVisible(true);
	}
	public void detallesReservacion(Vuelo vuelo) {
		DetallesReservacion v = new DetallesReservacion(vuelo);
		v.setVisible(true);
	}
}
