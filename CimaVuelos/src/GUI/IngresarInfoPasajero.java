package GUI;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import proyecto.Control;
import proyecto.Pasajero;
import proyecto.Vuelo;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class IngresarInfoPasajero extends JDialog {

	private static Vuelo vuelo;
	private static String asiento;
	private JPanel contentPane;
	private JTextField primerNombretxt;
	private JTextField apellidoPaternotxt;
	private JTextField segundoNombretxt;
	private JTextField apellidoMaternotxt;
	private JTextField telefonotxt;
	private JTextField correotxt;
	private JRadioButton femeninordbtn;
	private JComboBox mesCB;
	private JRadioButton masculinordbtn;
	private JRadioButton otrordbn;
	private JComboBox diaCB;
	private JComboBox añoCB;
	private JComboBox asientoCB;
	private DefaultComboBoxModel<String> cbModelAsientos;
	private boolean confirmado = false;
	private ArrayList<String> asientosAsignados = new ArrayList<>(); // temp para asientos ocupados CB

	/**
	 * Launch the application.
	 */
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
					IngresarInfoPasajero frame = new IngresarInfoPasajero(vuelo, asiento);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param asiento 
	 */
	public IngresarInfoPasajero(Vuelo vuelo, String asiento) {
		IngresarInfoPasajero.vuelo = vuelo;
		
		setTitle("Ingresar Información del Pasajero");
		setIconImage(Toolkit.getDefaultToolkit().getImage(IngresarInfoPasajero.class.getResource("/IMG/billeteDeAvion.png")));
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 920, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(130, 220, 236));
		panel.setBounds(0, 0, 920, 63);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("CimaVuelos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(73, 12, 234, 41);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setIcon(new ImageIcon(IngresarInfoPasajero.class.getResource("/IMG/viajarLogo.png")));
		lblNewLabel_1_2.setBounds(10, 0, 59, 63);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_5_2_1 = new JLabel("Información del Pasajero");
		lblNewLabel_5_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5_2_1.setBounds(335, 95, 315, 25);
		contentPane.add(lblNewLabel_5_2_1);
		
		JLabel lblNombre = new JLabel("Nombre(s)");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombre.setBounds(98, 142, 140, 29);
		contentPane.add(lblNombre);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Apellidos");
		lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5_1_1.setBounds(98, 181, 140, 29);
		contentPane.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_5_1_1_1 = new JLabel("Género");
		lblNewLabel_5_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5_1_1_1.setBounds(98, 230, 140, 29);
		contentPane.add(lblNewLabel_5_1_1_1);
		
		JLabel lblNewLabel_5_1_1_1_1 = new JLabel("Fecha de nacimiento");
		lblNewLabel_5_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5_1_1_1_1.setBounds(98, 291, 202, 29);
		contentPane.add(lblNewLabel_5_1_1_1_1);
		
		primerNombretxt = new JTextField();
		primerNombretxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		primerNombretxt.setColumns(10);
		primerNombretxt.setBounds(276, 142, 226, 28);
		contentPane.add(primerNombretxt);
		
		apellidoPaternotxt = new JTextField();
		apellidoPaternotxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		apellidoPaternotxt.setColumns(10);
		apellidoPaternotxt.setBounds(276, 182, 226, 28);
		contentPane.add(apellidoPaternotxt);
		
		femeninordbtn = new JRadioButton("Femenino");
		femeninordbtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		femeninordbtn.setBounds(276, 234, 147, 21);
		contentPane.add(femeninordbtn);
		
		JLabel lblNewLabel_5_1_1_1_2 = new JLabel("Mes:");
		lblNewLabel_5_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5_1_1_1_2.setBounds(310, 273, 48, 21);
		contentPane.add(lblNewLabel_5_1_1_1_2);
		
		mesCB = new JComboBox();
		mesCB.setToolTipText("");
		mesCB.setModel(new DefaultComboBoxModel(new String[] {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		mesCB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mesCB.setBounds(310, 291, 147, 29);
		contentPane.add(mesCB);
		
		masculinordbtn = new JRadioButton("Masculino");
		masculinordbtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		masculinordbtn.setBounds(425, 234, 147, 21);
		contentPane.add(masculinordbtn);
		
		segundoNombretxt = new JTextField();
		segundoNombretxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		segundoNombretxt.setColumns(10);
		segundoNombretxt.setBounds(529, 142, 226, 28);
		contentPane.add(segundoNombretxt);
		
		apellidoMaternotxt = new JTextField();
		apellidoMaternotxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		apellidoMaternotxt.setColumns(10);
		apellidoMaternotxt.setBounds(529, 182, 226, 28);
		contentPane.add(apellidoMaternotxt);
		
		otrordbn = new JRadioButton("Otro");
		otrordbn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		otrordbn.setBounds(574, 234, 147, 21);
		contentPane.add(otrordbn);
		
		// agrupar las opciones de botones de radio
		ButtonGroup bg = new ButtonGroup();
		bg.add(femeninordbtn);
		bg.add(masculinordbtn);
		bg.add(otrordbn);
		
		JLabel lblNewLabel_5_1_1_1_2_1 = new JLabel("Día:");
		lblNewLabel_5_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5_1_1_1_2_1.setBounds(497, 273, 48, 21);
		contentPane.add(lblNewLabel_5_1_1_1_2_1);
		
		diaCB = new JComboBox();
		diaCB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		diaCB.setModel(new DefaultComboBoxModel(new String[] {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		diaCB.setBounds(497, 291, 107, 29);
		contentPane.add(diaCB);
		
		añoCB = new JComboBox();
		añoCB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		añoCB.setModel(new DefaultComboBoxModel(new String[] {"", "2024", "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921", "1920"}));
		añoCB.setBounds(648, 291, 107, 29);
		contentPane.add(añoCB);
		
		JLabel lblNewLabel_5_1_1_1_2_1_1 = new JLabel("Año:");
		lblNewLabel_5_1_1_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5_1_1_1_2_1_1.setBounds(648, 273, 48, 21);
		contentPane.add(lblNewLabel_5_1_1_1_2_1_1);
		
		JLabel lblCorreo = new JLabel("Num. Telefónico ");
		lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCorreo.setBounds(98, 341, 202, 29);
		contentPane.add(lblCorreo);
		
		JLabel lblTelefono = new JLabel("Correo Electrónico");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTelefono.setBounds(98, 386, 170, 29);
		contentPane.add(lblTelefono);
		
		telefonotxt = new JTextField();
		telefonotxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		telefonotxt.setColumns(10);
		telefonotxt.setBounds(312, 341, 443, 28);
		contentPane.add(telefonotxt);
		// validar que solo se puedan ingresar numeros y que no se sobrepasen los 10 caracteres
		telefonotxt.addKeyListener(new KeyAdapter() {
			String temp;
			
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if ( (caracter < '0' || caracter > '9') || telefonotxt.getText().length() >= 10) { 
						e.consume(); // ignora el evento
					}
			}
			
			public void keyReleased(KeyEvent arg0) {
				String v = telefonotxt.getText().trim();
				
				if (v.length() > 10) {
					JOptionPane.showMessageDialog(null, "Valor invalido");
					telefonotxt.setText(temp);
				} else {
					temp = v;
				}
			}
		});
		
		correotxt = new JTextField();
		correotxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		correotxt.setColumns(10);
		correotxt.setBounds(312, 385, 443, 28);
		contentPane.add(correotxt);
		
		JLabel lblNumAsiento = new JLabel("Num. Asiento");
		lblNumAsiento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNumAsiento.setBounds(98, 428, 170, 29);
		contentPane.add(lblNumAsiento);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar(); // guarda el estado y cierra la ventana
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancelar.setBounds(645, 487, 111, 36);
		contentPane.add(btnCancelar);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarPasajero();
				confirmar();
			}
		});
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnConfirmar.setBounds(766, 487, 111, 36);
		contentPane.add(btnConfirmar);
		
		asientoCB = new JComboBox();
		asientoCB.setToolTipText("");
		asientoCB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		asientoCB.setBounds(312, 428, 147, 29);
		contentPane.add(asientoCB);
		mostrarAsientos();
		
	}
	
	// metodo para registrar pasajero
	public void guardarPasajero() {
        // Obtener valores de los campos
        String primerNombre = primerNombretxt.getText();
        String segundoNombre = segundoNombretxt.getText();
        String apellidoPaterno = apellidoPaternotxt.getText();
        String apellidoMaterno = apellidoMaternotxt.getText();
        String genero = femeninordbtn.isSelected() ? "Femenino" : masculinordbtn.isSelected() ? "Masculino" : "Otro";
        String dia = diaCB.getSelectedItem().toString();
        String mes = mesCB.getSelectedItem().toString();
        String año = añoCB.getSelectedItem().toString();
        String correo = correotxt.getText();
        String telefono = telefonotxt.getText();
        String numAsiento = (String) asientoCB.getSelectedItem();
		
        // validar que no haya campos vacios
        if ( (primerNombre.isEmpty()) || (apellidoPaterno.isEmpty()) || (genero.isEmpty()) || (dia.isEmpty()) || (mes.isEmpty()) 
        			|| (año.isEmpty()) || (correo.isEmpty()) || (telefono.isEmpty()) || (numAsiento.isEmpty()) ) {  
        	// si hay algun campo importante vacio  
            JOptionPane.showMessageDialog(null, "Error. Favor de llenar todos los campos.", "Error", 0);
			return;
        } else {
	        // convertir la fecha a LocalDate
	        int diaInt = Integer.parseInt(dia);
	        int mesInt = Integer.parseInt(mes);
	        int añoInt = Integer.parseInt(año);
	        LocalDate fechaNacimiento = LocalDate.of(añoInt, mesInt, diaInt);
	        
	        // obtener vuelo
	        String numVuelo = String.valueOf(vuelo.getNumVuelo()); 
	        // crear pasajero
	        Pasajero pasajero = new Pasajero(primerNombre, segundoNombre, apellidoPaterno, apellidoMaterno, genero, fechaNacimiento, telefono, correo,  numAsiento);
	        Control.escribirArchivosPasajeros(numVuelo, pasajero);
        	JOptionPane.showMessageDialog(null, "¡Pasajero obtenido!", "Confirmación", -1); 
        }
	}
	
	// metodo para asegurar que se llene la info de todos los pasajeros
	public void confirmar() {
        String primerNombre = primerNombretxt.getText();
        String segundoNombre = segundoNombretxt.getText();
        String apellidoPaterno = apellidoPaternotxt.getText();
        String apellidoMaterno = apellidoMaternotxt.getText();
        String genero = femeninordbtn.isSelected() ? "Femenino" : masculinordbtn.isSelected() ? "Masculino" : "Otro";
        String dia = diaCB.getSelectedItem().toString();
        String mes = mesCB.getSelectedItem().toString();
        String año = añoCB.getSelectedItem().toString();
        String correo = correotxt.getText();
        String telefono = telefonotxt.getText();
        String numAsiento = (String) asientoCB.getSelectedItem();
        
		if ( (primerNombre.isEmpty()) || (apellidoPaterno.isEmpty()) || (genero.isEmpty()) || (dia.isEmpty()) || (mes.isEmpty()) 
        		|| (año.isEmpty()) || (correo.isEmpty()) || (telefono.isEmpty()) || (numAsiento.isEmpty()) ) {
			// no hace nada
		} else {
			confirmado = true;
			this.dispose();
		}
	}
	
	private void cancelar() {
		confirmado = false;
		this.dispose();
	}
	
	public boolean infoIngresada() {
		return confirmado;
	}
	
	// metodo para colocar los asientos a elegir
	public void mostrarAsientos() {
		ArrayList<String> asientos = Control.getAsientosSeleccionados(); // obtengo la lista de asientos seleccionados
		
		cbModelAsientos = new DefaultComboBoxModel<>(); // creo el modelo del combobox
		for (String a : asientos) {
			if (!asientosAsignados.contains(a)) { // no muestra aquellos asientos ya seleccionados
				cbModelAsientos.addElement(a); // agrego los asientos como opciones del CB
			}			
		}
		asientoCB.setModel(cbModelAsientos); // asigno el modelo
		if (cbModelAsientos.getSize() > 0) {
			asientoCB.setSelectedIndex(0); // selecciono la primera opcion como la determinada
		}
	}
}
