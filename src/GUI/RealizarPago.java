package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import proyecto.Control;
import proyecto.Vuelo;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.atomic.AtomicInteger;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class RealizarPago extends JFrame {

	private JPanel contentPane;
	private JTextField titulartxt;
	private JTextField numTarjetatxt;
	private JTextField numSeguridadtxt;
	private JComboBox mesCB;
	private JComboBox añoCB;
	private static AtomicInteger total;
	private static AtomicInteger contador;
	private static Vuelo vuelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RealizarPago frame = new RealizarPago(total, contador, vuelo);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param total, AtomicInteger contador 
	 */
	public RealizarPago(AtomicInteger total, AtomicInteger contador, Vuelo vuelo) {
		this.total = total;
		this.contador = contador;
		this.vuelo = vuelo;
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(RealizarPago.class.getResource("/IMG/billeteDeAvion.png")));
		setTitle("Realizar Pago");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 920, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Encabezado = new JPanel();
		Encabezado.setLayout(null);
		Encabezado.setBackground(new Color(130, 220, 236));
		Encabezado.setBounds(0, 0, 920, 63);
		contentPane.add(Encabezado);
		
		JLabel lblNewLabel = new JLabel("CimaVuelos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(73, 12, 234, 41);
		Encabezado.add(lblNewLabel);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setIcon(new ImageIcon(RealizarPago.class.getResource("/IMG/viajarLogo.png")));
		lblNewLabel_1_2.setBounds(10, 0, 59, 63);
		Encabezado.add(lblNewLabel_1_2);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancelar.setBounds(648, 474, 111, 36);
		contentPane.add(btnCancelar);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// simular el pago
				pagar();
				if (Control.getPasajeroActual() != null) { // si esta iniciada la sesion se guarda la info en sus reservaciones
					Control.crearReservacion(String.valueOf(vuelo.getNumVuelo()), Control.pasajeroActual);
				}
			}
		});
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnConfirmar.setBounds(769, 474, 111, 36);
		contentPane.add(btnConfirmar);
		
		JLabel lblNewLabel_1_10_1_1_1_1 = new JLabel("Cantidad de boletos:");
		lblNewLabel_1_10_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_10_1_1_1_1.setBounds(519, 246, 220, 33);
		contentPane.add(lblNewLabel_1_10_1_1_1_1);
		
		JLabel lblNewLabel_1_10_1_1_1_1_1 = new JLabel("Total a pagar:");
		lblNewLabel_1_10_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_10_1_1_1_1_1.setBounds(520, 289, 151, 33);
		contentPane.add(lblNewLabel_1_10_1_1_1_1_1);
		
		JLabel cantidadlbl = new JLabel();
		cantidadlbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cantidadlbl.setBounds(738, 246, 105, 33);
		contentPane.add(cantidadlbl);
		
		JLabel totallbl = new JLabel("");
		totallbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		totallbl.setBounds(672, 289, 151, 33);
		contentPane.add(totallbl);
		
		JLabel lblNewLabel_5_2_1 = new JLabel("Detalles de la orden");
		lblNewLabel_5_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5_2_1.setBounds(592, 187, 220, 25);
		contentPane.add(lblNewLabel_5_2_1);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(460, 141, 18, 333);
		contentPane.add(separator);
		
		JLabel lblNewLabel_5_2_1_1 = new JLabel("Realizar Pago");
		lblNewLabel_5_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5_2_1_1.setBounds(386, 91, 162, 25);
		contentPane.add(lblNewLabel_5_2_1_1);
		
		JLabel lblNewLabel_5_2_1_2 = new JLabel("Titular de la Tarjeta");
		lblNewLabel_5_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5_2_1_2.setBounds(66, 141, 353, 25);
		contentPane.add(lblNewLabel_5_2_1_2);
		
		titulartxt = new JTextField();
		titulartxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		titulartxt.setBounds(66, 176, 353, 25);
		contentPane.add(titulartxt);
		titulartxt.setColumns(10);
		
		JLabel lblNewLabel_5_2_1_2_1 = new JLabel("Número de la Tarjeta");
		lblNewLabel_5_2_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5_2_1_2_1.setBounds(66, 222, 353, 25);
		contentPane.add(lblNewLabel_5_2_1_2_1);
		
		numTarjetatxt = new JTextField();
		numTarjetatxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		numTarjetatxt.setColumns(10);
		numTarjetatxt.setBounds(66, 257, 353, 25);
		contentPane.add(numTarjetatxt);
		// validar que solo se puedan ingresar numeros y que sea de 16 caracteres
		numTarjetatxt.addKeyListener(new KeyAdapter() {
			String temp;
			
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if ( (caracter < '0' || caracter > '9') || numTarjetatxt.getText().length() >= 16) { 
						e.consume(); // ignora el evento
					}
			}
			
			public void keyReleased(KeyEvent arg0) {
				String v = numTarjetatxt.getText().trim();
				
				if (v.length() > 16) {
					JOptionPane.showMessageDialog(null, "Valor invalido");
					numTarjetatxt.setText(temp);
				} else {
					temp = v;
				}
			}
		});
		
		JLabel lblNewLabel_5_2_1_2_1_1 = new JLabel("Fecha de Vencimiento");
		lblNewLabel_5_2_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5_2_1_2_1_1.setBounds(66, 312, 353, 25);
		contentPane.add(lblNewLabel_5_2_1_2_1_1);
		
		JLabel lblNewLabel_5_2_1_2_1_2 = new JLabel("Número de Seguridad");
		lblNewLabel_5_2_1_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5_2_1_2_1_2.setBounds(66, 421, 353, 25);
		contentPane.add(lblNewLabel_5_2_1_2_1_2);
		
		numSeguridadtxt = new JTextField();
		numSeguridadtxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		numSeguridadtxt.setColumns(10);
		numSeguridadtxt.setBounds(66, 456, 353, 25);
		contentPane.add(numSeguridadtxt);
		// validar que solo se puedan ingresar numeros y que no sobrepase los 3 caracteres
		numSeguridadtxt.addKeyListener(new KeyAdapter() {
			String temp;
			
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if ( (caracter < '0' || caracter > '9') || numSeguridadtxt.getText().length() >= 3) { 
						e.consume(); // ignora el evento
					}
			}
			
			public void keyReleased(KeyEvent arg0) {
				String v = numSeguridadtxt.getText().trim();
				
				if (v.length() > 3) {
					JOptionPane.showMessageDialog(null, "Valor invalido");
					numSeguridadtxt.setText(temp);
				} else {
					temp = v;
				}
			}
		});
		
		// ingreso los datos de la orden
		cantidadlbl.setText("" + contador.get());	
		totallbl.setText("" + total.get());
		
		mesCB = new JComboBox();
		mesCB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mesCB.setModel(new DefaultComboBoxModel(new String[] {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		mesCB.setBounds(66, 374, 162, 27);
		contentPane.add(mesCB);
		
		añoCB = new JComboBox();
		añoCB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		añoCB.setModel(new DefaultComboBoxModel(new String[] {"", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050"}));
		añoCB.setBounds(257, 374, 162, 27);
		contentPane.add(añoCB);
		
		JLabel lblNewLabel_5_1_1_1_2 = new JLabel("Mes:");
		lblNewLabel_5_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5_1_1_1_2.setBounds(64, 347, 48, 21);
		contentPane.add(lblNewLabel_5_1_1_1_2);
		
		JLabel lblNewLabel_5_1_1_1_2_1_1 = new JLabel("Año:");
		lblNewLabel_5_1_1_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5_1_1_1_2_1_1.setBounds(257, 347, 48, 21);
		contentPane.add(lblNewLabel_5_1_1_1_2_1_1);
	}
	
	// metodo para pagar la orden
	public void pagar() {
        String mes = mesCB.getSelectedItem().toString();
        String año = añoCB.getSelectedItem().toString();
		
        // validar que no haya campos vacios
        if ( (titulartxt.getText().isEmpty()) || (numTarjetatxt.getText().isEmpty()) || (numSeguridadtxt.getText().isEmpty()) || (año.isEmpty()) || (mes.isEmpty()) ) {
			JOptionPane.showMessageDialog(null, "Error. Favor de llenar todos los campos.", "Error", 0);
			return;
        } else {
        	Control.comprarAsientos(vuelo);        	
        	JOptionPane.showMessageDialog(null, "Pago exitoso ¡Gracias por su compra!", "Confirmación", -1);
        	dispose();
        }
	}
        
		
	
}
