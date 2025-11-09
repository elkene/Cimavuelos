package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import proyecto.Control;

import javax.swing.JPasswordField;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Registrarse extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField primerNombretxt;
	private JTextField apellidoPaternotxt;
	private JTextField segundoNombretxt;
	private JTextField apellidoMaternotxt;
	private JTextField correotxt;
	private JTextField telefonotxt;
	private JPasswordField contraseña2txt;
	private JPasswordField contraseñatxt;
	private JComboBox añoCB;
	private JComboBox diaCB;
	private JComboBox mesCB;
	private JRadioButton otrordbn;
	private JRadioButton femeninordbtn;
	private JRadioButton masculinordbtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					Registrarse frame = new Registrarse();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public Registrarse() {
		setTitle("Registrarse");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/IMG/billeteDeAvion.png")));

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // solo se cierra esta ventana al cerrar
		setBounds(100, 100, 920, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(130, 220, 236));
		panel.setBounds(0, 0, 917, 63);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("CimaVuelos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(73, 12, 234, 41);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setIcon(new ImageIcon(Registrarse.class.getResource("/IMG/viajarLogo.png")));
		lblNewLabel_1_2.setBounds(10, 0, 59, 63);
		panel.add(lblNewLabel_1_2);
		
		JPanel contenido = new JPanel();
		contenido.setBounds(0, 59, 917, 474);
		contentPane.add(contenido);
		contenido.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre(s)");
		lblNombre.setBounds(117, 59, 140, 29);
		contenido.add(lblNombre);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblContacto = new JLabel("Información de contacto");
		lblContacto.setBounds(75, 222, 422, 55);
		contenido.add(lblContacto);
		lblContacto.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		primerNombretxt = new JTextField();
		primerNombretxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		primerNombretxt.setBounds(295, 59, 226, 28);
		contenido.add(primerNombretxt);
		primerNombretxt.setColumns(10);
		
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnConfirmar.setBounds(779, 428, 111, 36);
		contenido.add(btnConfirmar);
		
		JLabel lblNewLabel_5_2 = new JLabel("Información personal");
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5_2.setBounds(75, 10, 422, 55);
		contenido.add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Apellidos");
		lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5_1_1.setBounds(117, 98, 140, 29);
		contenido.add(lblNewLabel_5_1_1);
		
		apellidoPaternotxt = new JTextField();
		apellidoPaternotxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		apellidoPaternotxt.setColumns(10);
		apellidoPaternotxt.setBounds(295, 99, 226, 28);
		contenido.add(apellidoPaternotxt);
		
		JLabel lblNewLabel_5_1_1_1 = new JLabel("Género");
		lblNewLabel_5_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5_1_1_1.setBounds(117, 137, 140, 29);
		contenido.add(lblNewLabel_5_1_1_1);
		
		femeninordbtn = new JRadioButton("Femenino");
		femeninordbtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		femeninordbtn.setBounds(295, 141, 147, 21);
		contenido.add(femeninordbtn);
		
		masculinordbtn = new JRadioButton("Masculino");
		masculinordbtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		masculinordbtn.setBounds(444, 141, 147, 21);
		contenido.add(masculinordbtn);
		
		otrordbn = new JRadioButton("Otro");
		otrordbn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		otrordbn.setBounds(593, 141, 147, 21);
		contenido.add(otrordbn);
		
		// agrupar las opciones de botones de radio
		ButtonGroup bg = new ButtonGroup();
		bg.add(femeninordbtn);
		bg.add(masculinordbtn);
		bg.add(otrordbn);
		
		JLabel lblNewLabel_5_1_1_1_1 = new JLabel("Fecha de nacimiento");
		lblNewLabel_5_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5_1_1_1_1.setBounds(117, 176, 202, 29);
		contenido.add(lblNewLabel_5_1_1_1_1);
		
		mesCB = new JComboBox();
		mesCB.setToolTipText("");
		mesCB.setModel(new DefaultComboBoxModel(new String[] {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		mesCB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mesCB.setBounds(340, 186, 147, 29);
		contenido.add(mesCB);
		
		diaCB = new JComboBox();
		diaCB.setModel(new DefaultComboBoxModel(new String[] {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		diaCB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		diaCB.setBounds(525, 186, 107, 29);
		contenido.add(diaCB);
		
		añoCB = new JComboBox();
		añoCB.setModel(new DefaultComboBoxModel(new String[] {"", "2024", "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921", "1920"}));
		añoCB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		añoCB.setBounds(668, 186, 107, 29);
		contenido.add(añoCB);
		
		segundoNombretxt = new JTextField();
		segundoNombretxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		segundoNombretxt.setColumns(10);
		segundoNombretxt.setBounds(548, 59, 226, 28);
		contenido.add(segundoNombretxt);
		
		apellidoMaternotxt = new JTextField();
		apellidoMaternotxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		apellidoMaternotxt.setColumns(10);
		apellidoMaternotxt.setBounds(548, 99, 226, 28);
		contenido.add(apellidoMaternotxt);
		
		JLabel lblCorreo = new JLabel("Correo Electrónico");
		lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCorreo.setBounds(116, 272, 202, 29);
		contenido.add(lblCorreo);
		
		correotxt = new JTextField();
		correotxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		correotxt.setColumns(10);
		correotxt.setBounds(330, 272, 435, 28);
		contenido.add(correotxt);
		
		JLabel lblTelefono = new JLabel("Num. Teléfono");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTelefono.setBounds(116, 311, 202, 29);
		contenido.add(lblTelefono);
		
		telefonotxt = new JTextField();
		telefonotxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		telefonotxt.setColumns(10);
		telefonotxt.setBounds(330, 310, 435, 28);
		contenido.add(telefonotxt);
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
		
		JLabel lblContraseña = new JLabel("Contraseña");
		lblContraseña.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContraseña.setBounds(116, 350, 202, 29);
		contenido.add(lblContraseña);
		
		JLabel lblContraseñaConfirmacion = new JLabel("Confirmar Contraseña");
		lblContraseñaConfirmacion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContraseñaConfirmacion.setBounds(116, 389, 202, 29);
		contenido.add(lblContraseñaConfirmacion);
		
		
		contraseña2txt = new JPasswordField();
		contraseña2txt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contraseña2txt.setBounds(330, 387, 435, 28);
		contenido.add(contraseña2txt);
		
		contraseñatxt = new JPasswordField();
		contraseñatxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contraseñatxt.setBounds(330, 348, 435, 28);
		contenido.add(contraseñatxt);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancelar.setBounds(658, 428, 111, 36);
		contenido.add(btnCancelar);
		
		JLabel lblNewLabel_5_1_1_1_2 = new JLabel("Mes:");
		lblNewLabel_5_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5_1_1_1_2.setBounds(340, 168, 48, 21);
		contenido.add(lblNewLabel_5_1_1_1_2);
		
		JLabel lblNewLabel_5_1_1_1_2_1 = new JLabel("Día:");
		lblNewLabel_5_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5_1_1_1_2_1.setBounds(525, 168, 48, 21);
		contenido.add(lblNewLabel_5_1_1_1_2_1);
		
		JLabel lblNewLabel_5_1_1_1_2_1_1 = new JLabel("Año:");
		lblNewLabel_5_1_1_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5_1_1_1_2_1_1.setBounds(668, 168, 48, 21);
		contenido.add(lblNewLabel_5_1_1_1_2_1_1);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearCuenta(); // crear una cuenta
			}
		});
	
	}
	
	// metodo para crear una cuenta
	public void crearCuenta() {
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
        String contraseña = new String(contraseñatxt.getPassword());
        String contraseña2 = new String(contraseña2txt.getPassword());
              
        // validar que no haya campos vacios
        if ( (primerNombre.isEmpty()) || (apellidoPaterno.isEmpty()) || (genero.isEmpty()) || (dia.isEmpty()) || (mes.isEmpty()) 
        		|| (año.isEmpty()) || (correo.isEmpty()) || (telefono.isEmpty()) || (contraseña.isEmpty()) || (contraseña2.isEmpty())) {
        	// si hay algun campo importante vacio
			JOptionPane.showMessageDialog(null, "Error. Favor de llenar todos los campos.", "Error", 0);
			return;
        } 
        // validar que las contraseñas sean iguales
        if (! contraseña.equals(contraseña2)) {
			JOptionPane.showMessageDialog(null, "Error. Las contraseñas igresadas no son iguales.", "Error", 0);
			return;
        }
        else {
        	Control.escribirArchivoRegistros(primerNombre, segundoNombre, apellidoPaterno, apellidoMaterno, genero, dia, mes, año, correo, telefono, contraseña);
        	JOptionPane.showMessageDialog(null, "¡Pasajero Registrado!", "Confirmación", -1);
        	dispose();
        }
	}
}
