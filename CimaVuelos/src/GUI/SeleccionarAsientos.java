package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import proyecto.Control;
import proyecto.Vuelo;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class SeleccionarAsientos extends JFrame {

	private JPanel contentPane;
	public static Vuelo vuelo;
	public AtomicInteger contador;
	public AtomicInteger total;

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
					SeleccionarAsientos frame = new SeleccionarAsientos(vuelo);
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
	public SeleccionarAsientos(Vuelo vuelo) {
		SeleccionarAsientos.vuelo = vuelo;
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(SeleccionarAsientos.class.getResource("/IMG/billeteDeAvion.png")));
		setTitle("Seleccionar Asientos");
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
		lblNewLabel_1_2.setIcon(new ImageIcon(SeleccionarAsientos.class.getResource("/IMG/viajarLogo.png")));
		lblNewLabel_1_2.setBounds(10, 0, 59, 63);
		Encabezado.add(lblNewLabel_1_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 62, 920, 482);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton A1 = new JButton("A");
		A1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		A1.setBounds(99, 419, 45, 33);
		panel.add(A1);
		
		JButton B1 = new JButton("B");
		B1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		B1.setBounds(154, 419, 45, 33);
		panel.add(B1);
		
		JButton C1 = new JButton("C");
		C1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		C1.setBounds(209, 419, 45, 33);
		panel.add(C1);
		
		JLabel lblNewLabel_1 = new JLabel("1");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(68, 427, 21, 13);
		panel.add(lblNewLabel_1);
		
		JButton A2 = new JButton("A");
		A2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		A2.setBounds(99, 376, 45, 33);
		panel.add(A2);
		
		JButton B2 = new JButton("B");
		B2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		B2.setBounds(154, 376, 45, 33);
		panel.add(B2);
		
		JButton C2 = new JButton("C");
		C2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		C2.setBounds(209, 376, 45, 33);
		panel.add(C2);
		
		JButton A3 = new JButton("A");
		A3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		A3.setBounds(99, 331, 45, 33);
		panel.add(A3);
		
		JButton B3 = new JButton("B");
		B3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		B3.setBounds(154, 331, 45, 33);
		panel.add(B3);
		
		JButton C3 = new JButton("C");
		C3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		C3.setBounds(209, 331, 45, 33);
		panel.add(C3);
		
		JButton A4 = new JButton("A");
		A4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		A4.setBounds(99, 287, 45, 33);
		panel.add(A4);
		
		JButton B4 = new JButton("B");
		B4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		B4.setBounds(154, 287, 45, 33);
		panel.add(B4);
		
		JButton C4 = new JButton("C");
		C4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		C4.setBounds(209, 287, 45, 33);
		panel.add(C4);
		
		JButton A5 = new JButton("A");
		A5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		A5.setBounds(99, 244, 45, 33);
		panel.add(A5);
		
		JButton B5 = new JButton("B");
		B5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		B5.setBounds(154, 244, 45, 33);
		panel.add(B5);
		
		JButton C5 = new JButton("C");
		C5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		C5.setBounds(209, 244, 45, 33);
		panel.add(C5);
		
		JButton A6 = new JButton("A");
		A6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		A6.setBounds(99, 201, 45, 33);
		panel.add(A6);
		
		JButton B6 = new JButton("B");
		B6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		B6.setBounds(154, 201, 45, 33);
		panel.add(B6);
		
		JButton C6 = new JButton("C");
		C6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		C6.setBounds(209, 201, 45, 33);
		panel.add(C6);
		
		JButton A7 = new JButton("A");
		A7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		A7.setBounds(99, 158, 45, 33);
		panel.add(A7);
		
		JButton B7 = new JButton("B");
		B7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		B7.setBounds(154, 158, 45, 33);
		panel.add(B7);
		
		JButton C7 = new JButton("C");
		C7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		C7.setBounds(209, 158, 45, 33);
		panel.add(C7);
		
		JButton A8 = new JButton("A");
		A8.setFont(new Font("Tahoma", Font.PLAIN, 10));
		A8.setBounds(99, 115, 45, 33);
		panel.add(A8);
		
		JButton B8 = new JButton("B");
		B8.setFont(new Font("Tahoma", Font.PLAIN, 10));
		B8.setBounds(154, 115, 45, 33);
		panel.add(B8);
		
		JButton C8 = new JButton("C");
		C8.setFont(new Font("Tahoma", Font.PLAIN, 10));
		C8.setBounds(209, 115, 45, 33);
		panel.add(C8);
		
		JButton A9 = new JButton("A");
		A9.setFont(new Font("Tahoma", Font.PLAIN, 10));
		A9.setBounds(99, 72, 45, 33);
		panel.add(A9);
		
		JButton B9 = new JButton("B");
		B9.setFont(new Font("Tahoma", Font.PLAIN, 10));
		B9.setBounds(154, 72, 45, 33);
		panel.add(B9);
		
		JButton C9 = new JButton("C");
		C9.setFont(new Font("Tahoma", Font.PLAIN, 10));
		C9.setBounds(209, 72, 45, 33);
		panel.add(C9);
		
		JButton A10 = new JButton("A");
		A10.setFont(new Font("Tahoma", Font.PLAIN, 10));
		A10.setBounds(99, 29, 45, 33);
		panel.add(A10);
		
		JButton B10 = new JButton("B");
		B10.setFont(new Font("Tahoma", Font.PLAIN, 10));
		B10.setBounds(154, 29, 45, 33);
		panel.add(B10);
		
		JButton C10 = new JButton("C");
		C10.setFont(new Font("Tahoma", Font.PLAIN, 10));
		C10.setBounds(209, 29, 45, 33);
		panel.add(C10);
		
		JLabel lblNewLabel_1_1 = new JLabel("2");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(68, 386, 21, 13);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("3");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(68, 341, 21, 13);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("4");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_4.setBounds(68, 297, 21, 13);
		panel.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("5");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_5.setBounds(68, 254, 21, 13);
		panel.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("6");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_6.setBounds(68, 211, 21, 13);
		panel.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("7");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_7.setBounds(68, 168, 21, 13);
		panel.add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_1_8 = new JLabel("8");
		lblNewLabel_1_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_8.setBounds(68, 125, 21, 13);
		panel.add(lblNewLabel_1_8);
		
		JLabel lblNewLabel_1_9 = new JLabel("9");
		lblNewLabel_1_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_9.setBounds(68, 82, 21, 13);
		panel.add(lblNewLabel_1_9);
		
		JLabel lblNewLabel_1_10 = new JLabel("10");
		lblNewLabel_1_10.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_10.setBounds(57, 37, 21, 13);
		panel.add(lblNewLabel_1_10);
		
		JButton D1 = new JButton("D");
		D1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		D1.setBounds(351, 419, 45, 33);
		panel.add(D1);
		
		JButton E1 = new JButton("E");
		E1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		E1.setBounds(406, 419, 45, 33);
		panel.add(E1);
		
		JButton F1 = new JButton("F");
		F1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		F1.setBounds(461, 419, 45, 33);
		panel.add(F1);
		
		JButton D2 = new JButton("D");
		D2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		D2.setBounds(351, 376, 45, 33);
		panel.add(D2);
		
		JButton E2 = new JButton("E");
		E2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		E2.setBounds(406, 376, 45, 33);
		panel.add(E2);
		
		JButton F2 = new JButton("F");
		F2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		F2.setBounds(461, 376, 45, 33);
		panel.add(F2);
		
		JButton D3 = new JButton("D");
		D3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		D3.setBounds(351, 331, 45, 33);
		panel.add(D3);
		
		JButton E3 = new JButton("E");
		E3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		E3.setBounds(406, 331, 45, 33);
		panel.add(E3);
		
		JButton F3 = new JButton("F");
		F3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		F3.setBounds(461, 331, 45, 33);
		panel.add(F3);
		
		JButton D4 = new JButton("D");
		D4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		D4.setBounds(351, 287, 45, 33);
		panel.add(D4);
		
		JButton E4 = new JButton("E");
		E4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		E4.setBounds(406, 287, 45, 33);
		panel.add(E4);
		
		JButton F4 = new JButton("F");
		F4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		F4.setBounds(461, 287, 45, 33);
		panel.add(F4);
		
		JButton D5 = new JButton("D");
		D5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		D5.setBounds(351, 244, 45, 33);
		panel.add(D5);
		
		JButton E5 = new JButton("E");
		E5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		E5.setBounds(406, 244, 45, 33);
		panel.add(E5);
		
		JButton F5 = new JButton("F");
		F5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		F5.setBounds(461, 244, 45, 33);
		panel.add(F5);
		
		JButton D6 = new JButton("D");
		D6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		D6.setBounds(351, 201, 45, 33);
		panel.add(D6);
		
		JButton E6 = new JButton("E");
		E6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		E6.setBounds(406, 201, 45, 33);
		panel.add(E6);
		
		JButton F6 = new JButton("F");
		F6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		F6.setBounds(461, 201, 45, 33);
		panel.add(F6);
		
		JButton D7 = new JButton("D");
		D7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		D7.setBounds(351, 158, 45, 33);
		panel.add(D7);
		
		JButton E7 = new JButton("E");
		E7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		E7.setBounds(406, 158, 45, 33);
		panel.add(E7);
		
		JButton F7 = new JButton("F");
		F7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		F7.setBounds(461, 158, 45, 33);
		panel.add(F7);
		
		JButton D8 = new JButton("D");
		D8.setFont(new Font("Tahoma", Font.PLAIN, 10));
		D8.setBounds(351, 115, 45, 33);
		panel.add(D8);
		
		JButton E8 = new JButton("E");
		E8.setFont(new Font("Tahoma", Font.PLAIN, 10));
		E8.setBounds(406, 115, 45, 33);
		panel.add(E8);
		
		JButton F8 = new JButton("F");
		F8.setFont(new Font("Tahoma", Font.PLAIN, 10));
		F8.setBounds(461, 115, 45, 33);
		panel.add(F8);
		
		JButton D9 = new JButton("D");
		D9.setFont(new Font("Tahoma", Font.PLAIN, 10));
		D9.setBounds(351, 72, 45, 33);
		panel.add(D9);
		
		JButton E9 = new JButton("E");
		E9.setFont(new Font("Tahoma", Font.PLAIN, 10));
		E9.setBounds(406, 72, 45, 33);
		panel.add(E9);
		
		JButton F9 = new JButton("F");
		F9.setFont(new Font("Tahoma", Font.PLAIN, 10));
		F9.setBounds(461, 72, 45, 33);
		panel.add(F9);
		
		JButton D10 = new JButton("D");
		D10.setFont(new Font("Tahoma", Font.PLAIN, 10));
		D10.setBounds(351, 29, 45, 33);
		panel.add(D10);
		
		JButton E10 = new JButton("E");
		E10.setFont(new Font("Tahoma", Font.PLAIN, 10));
		E10.setBounds(406, 29, 45, 33);
		panel.add(E10);
		
		JButton F10 = new JButton("F");
		F10.setFont(new Font("Tahoma", Font.PLAIN, 10));
		F10.setBounds(461, 29, 45, 33);
		panel.add(F10);
		
		JLabel lblNewLabel_5_2_1 = new JLabel("Seleccione sus asientos");
		lblNewLabel_5_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5_2_1.setBounds(595, 131, 242, 25);
		panel.add(lblNewLabel_5_2_1);
		
		JButton ocupadoBtn = new JButton("");
		ocupadoBtn.setBackground(new Color(244, 91, 64));
		ocupadoBtn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		ocupadoBtn.setBounds(638, 176, 45, 33);
		panel.add(ocupadoBtn);
		
		JButton disponibleBtn = new JButton("");
		disponibleBtn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		disponibleBtn.setBounds(638, 217, 45, 33);
		panel.add(disponibleBtn);
		
		JButton seleccionadoBtn = new JButton("");
		seleccionadoBtn.setBackground(new Color(141, 251, 136));
		seleccionadoBtn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		seleccionadoBtn.setBounds(638, 260, 45, 33);
		panel.add(seleccionadoBtn);
		
		JLabel lblNewLabel_1_10_1 = new JLabel("Ocupado");
		lblNewLabel_1_10_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_10_1.setBounds(689, 176, 67, 31);
		panel.add(lblNewLabel_1_10_1);
		
		JLabel lblNewLabel_1_10_1_1 = new JLabel("Disponible");
		lblNewLabel_1_10_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_10_1_1.setBounds(689, 217, 81, 33);
		panel.add(lblNewLabel_1_10_1_1);
		
		JLabel lblNewLabel_1_10_1_1_1 = new JLabel("Seleccionado");
		lblNewLabel_1_10_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_10_1_1_1.setBounds(691, 260, 100, 33);
		panel.add(lblNewLabel_1_10_1_1_1);
		
		JLabel lblNewLabel_1_10_1_1_1_1 = new JLabel("Cantidad de boletos:");
		lblNewLabel_1_10_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_10_1_1_1_1.setBounds(554, 323, 220, 33);
		panel.add(lblNewLabel_1_10_1_1_1_1);
		
		JLabel lblNewLabel_1_10_1_1_1_1_1 = new JLabel("Total a pagar:");
		lblNewLabel_1_10_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_10_1_1_1_1_1.setBounds(554, 366, 151, 33);
		panel.add(lblNewLabel_1_10_1_1_1_1_1);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean infoCompletada = ingresarInfoPasajeros(vuelo);
				
				if (!infoCompletada) { // si no se completo la informacion
					JOptionPane.showMessageDialog(null, "Proceso Cancelado. No se ingresaron todos los pasajeros.", "Proceso Cancelado", -1);
					return; // cancelar el proceso
				}
				
				realizarPago(vuelo);
								
				// regresar al panel de Inicio
				CardLayout c = (CardLayout)(Inicio.panel_1.getLayout());
				c.show(Inicio.panel_1, "pInicio");
				dispose();
			}
		});
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnConfirmar.setBounds(779, 419, 111, 36);
		panel.add(btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Control.limpiarAsientos();
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancelar.setBounds(658, 419, 111, 36);
		panel.add(btnCancelar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(554, 254, 323, -7);
		panel.add(separator);
		
		JLabel lblNewLabel_5_2_1_1 = new JLabel();
		lblNewLabel_5_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_2_1_1.setText("Vuelo " + vuelo.getNumVuelo());
		lblNewLabel_5_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5_2_1_1.setBounds(595, 29, 242, 25);
		panel.add(lblNewLabel_5_2_1_1);
		
		JLabel lblNewLabel_5_2_1_1_1 = new JLabel();
		lblNewLabel_5_2_1_1_1.setText("Origen:");
		lblNewLabel_5_2_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5_2_1_1_1.setBounds(595, 60, 67, 25);
		panel.add(lblNewLabel_5_2_1_1_1);
		
		JLabel lblNewLabel_5_2_1_1_1_1 = new JLabel();
		lblNewLabel_5_2_1_1_1_1.setText("Destino:");
		lblNewLabel_5_2_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5_2_1_1_1_1.setBounds(595, 80, 67, 25);
		panel.add(lblNewLabel_5_2_1_1_1_1);
		
		JLabel lblNewLabel_5_2_1_1_1_2 = new JLabel();
		lblNewLabel_5_2_1_1_1_2.setText(vuelo.getOrigen());
		lblNewLabel_5_2_1_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5_2_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5_2_1_1_1_2.setBounds(671, 60, 166, 25);
		panel.add(lblNewLabel_5_2_1_1_1_2);
		
		JLabel lblNewLabel_5_2_1_1_1_2_1 = new JLabel();
		lblNewLabel_5_2_1_1_1_2_1.setText(vuelo.getDestino());
		lblNewLabel_5_2_1_1_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5_2_1_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5_2_1_1_1_2_1.setBounds(671, 82, 166, 25);
		panel.add(lblNewLabel_5_2_1_1_1_2_1);
		
		JLabel cantidadlbl = new JLabel();
		cantidadlbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cantidadlbl.setBounds(772, 323, 105, 33);
		panel.add(cantidadlbl);
		
		JLabel totallbl = new JLabel("");
		totallbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		totallbl.setBounds(706, 366, 151, 33);
		panel.add(totallbl);
		
		JButton[] botones = {A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, // arreglo con todos los botones tipo asiento, para facilitar su modificacion
							 B1, B2, B3, B4, B5, B6, B7, B8, B9, B10,
							 C1, C2, C3, C4, C5, C6, C7, C8, C9, C10,
							 D1, D2, D3, D4, D5, D6, D7, D8, D9, D10,
							 E1, E2, E3, E4, E5, E6, E7, E8, E9, E10,
							 F1, F2, F3, F4, F5, F6, F7, F8, F9, F10};
		// asignandole nombre a los botones
		A1.setName("A1"); B1.setName("B1"); C1.setName("C1"); D1.setName("D1"); E1.setName("E1"); F1.setName("F1");
		A2.setName("A2"); B2.setName("B2"); C2.setName("C2"); D2.setName("D2"); E2.setName("E2"); F2.setName("F2");
		A3.setName("A3"); B3.setName("B3"); C3.setName("C3"); D3.setName("D3"); E3.setName("E3"); F3.setName("F3");
		A4.setName("A4"); B4.setName("B4"); C4.setName("C4"); D4.setName("D4"); E4.setName("E4"); F4.setName("F4");
		A5.setName("A5"); B5.setName("B5"); C5.setName("C5"); D5.setName("D5"); E5.setName("E5"); F5.setName("F5");
		A6.setName("A6"); B6.setName("B6"); C6.setName("C6"); D6.setName("D6"); E6.setName("E6"); F6.setName("F6");
		A7.setName("A7"); B7.setName("B7"); C7.setName("C7"); D7.setName("D7"); E7.setName("E7"); F7.setName("F7");
		A8.setName("A8"); B8.setName("B8"); C8.setName("C8"); D8.setName("D8"); E8.setName("E8"); F8.setName("F8");
		A9.setName("A9"); B9.setName("B9"); C9.setName("C9"); D9.setName("D9"); E9.setName("E9"); F9.setName("F9");
		A10.setName("A10"); B10.setName("B10"); C10.setName("C10"); D10.setName("D10"); E1.setName("E10"); F10.setName("F10");
		
		// funcionamiento de los botones Asientos
		for (JButton boton : botones) {
			contador = new AtomicInteger(0); // contador que se actualiza automaticamente
			total = new AtomicInteger(0); // total a pagar que se actualiza automaticamente
			String numAsiento = boton.getName(); // obtengo el numero de asiento del boton
			
			// inhabilito aquellos asientos que ya estan ocupados
			if (vuelo.estadoOcupado(numAsiento)) {
				boton.setBackground(new Color(244, 91, 64)); // cambia su color a rojo (Ocupado)
				boton.putClientProperty("estado", "ocupado"); // cambio su estado a Ocupado
			
			} else { // pongo disponibles aquellos que no
				boton.putClientProperty("estado", "disponible"); // les asigna el estado Disponible
			}
			
			boton.addActionListener(e -> { // cuando se seleccione
				String estado = (String) boton.getClientProperty("estado"); // obtiene su estado
				
				if (estado.equals("disponible")) { // si esta disponible, al presionarlo...
					boton.setBackground(new Color(141, 251, 136)); // cambia su color a verde (Seleccionado)
					boton.putClientProperty("estado", "seleccionado"); // cambia su estado a Seleccionado
					contador.incrementAndGet(); // incrementa el contador
					total.getAndAdd((int) vuelo.getCosto()); // suma el precio de un boleto al total
					Control.agregarAsiento(boton.getName()); // agrega el boton al arraylist de seleccionados
					
				} else if (estado.equals("seleccionado")) { // si esta seleccionado, al presionarlo...
					boton.setBackground(null); // cambia su color a gris (Disponible)
					boton.putClientProperty("estado", "disponible"); // cambia su estado a Seleccionado
					contador.decrementAndGet(); // decrementa el contador
					total.getAndAdd((int) -vuelo.getCosto()); // resta el precio del boleto al total
					Control.removerAsiento(boton.getName()); // elimina el boton al arraylist de seleccionados
					
				} else if (estado.equals("ocupado")) { // si esta ocupado
					// no hace nada si esta ocupado
				}
				cantidadlbl.setText("" + contador.get());	
				totallbl.setText("" + total.get());
			});
		}
	}
	
	// creacion de ventanas
	public boolean ingresarInfoPasajeros(Vuelo vuelo) {
		List<String> asientosSeleccionados = Control.getAsientosSeleccionados();
		
		for (String asiento : asientosSeleccionados) {
			IngresarInfoPasajero v = new IngresarInfoPasajero(vuelo, asiento);
			v.setModal(true);
			v.setVisible(true);
			
			if (!v.infoIngresada()) { // si no se ingreso la info		
				return false;
			}
		}
		return true; // se ingreso la info de todos los pasajeros
	}
	
	public void realizarPago(Vuelo vuelo) {
		RealizarPago v = new RealizarPago(total, contador, vuelo);
		v.setVisible(true);
	}

}
