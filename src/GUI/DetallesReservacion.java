package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import proyecto.Vuelo;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class DetallesReservacion extends JFrame {
	public static Vuelo vuelo;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetallesReservacion frame = new DetallesReservacion(vuelo);
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
	public DetallesReservacion(Vuelo vuelo) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DetallesReservacion.class.getResource("/IMG/billeteDeAvion.png")));
		setTitle("Detalles de la Reservación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		lblNewLabel_1_2.setIcon(new ImageIcon(DetallesReservacion.class.getResource("/IMG/viajarLogo.png")));
		lblNewLabel_1_2.setBounds(10, 0, 59, 63);
		panel.add(lblNewLabel_1_2);
		
		JLabel vuelolbl = new JLabel();
		vuelolbl.setText("Información del Vuelo");
		vuelolbl.setHorizontalAlignment(SwingConstants.CENTER);
		vuelolbl.setFont(new Font("Tahoma", Font.BOLD, 20));
		vuelolbl.setBounds(113, 123, 242, 25);
		contentPane.add(vuelolbl);
		
		JLabel lblNewLabel_5_2_1_1_1 = new JLabel();
		lblNewLabel_5_2_1_1_1.setText("No. Vuelo:");
		lblNewLabel_5_2_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5_2_1_1_1.setBounds(82, 194, 111, 25);
		contentPane.add(lblNewLabel_5_2_1_1_1);
		
		JLabel lblNewLabel_5_2_1_1_1_1 = new JLabel();
		lblNewLabel_5_2_1_1_1_1.setText("Origen:");
		lblNewLabel_5_2_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5_2_1_1_1_1.setBounds(82, 229, 111, 25);
		contentPane.add(lblNewLabel_5_2_1_1_1_1);
		
		JLabel numVuelolbl = new JLabel();
		numVuelolbl.setText((String) null);
		numVuelolbl.setHorizontalAlignment(SwingConstants.LEFT);
		numVuelolbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		numVuelolbl.setBounds(192, 194, 182, 25);
		contentPane.add(numVuelolbl);
		
		JLabel origenlbl = new JLabel();
		origenlbl.setText((String) null);
		origenlbl.setHorizontalAlignment(SwingConstants.LEFT);
		origenlbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		origenlbl.setBounds(176, 229, 198, 25);
		contentPane.add(origenlbl);
		
		JLabel lblNewLabel_5_2_1_1_1_3 = new JLabel();
		lblNewLabel_5_2_1_1_1_3.setText("Destino:");
		lblNewLabel_5_2_1_1_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5_2_1_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5_2_1_1_1_3.setBounds(82, 264, 111, 25);
		contentPane.add(lblNewLabel_5_2_1_1_1_3);
		
		JLabel destinolbl = new JLabel();
		destinolbl.setText((String) null);
		destinolbl.setHorizontalAlignment(SwingConstants.LEFT);
		destinolbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		destinolbl.setBounds(176, 264, 198, 25);
		contentPane.add(destinolbl);
		
		JLabel lblNewLabel_5_2_1_1_1_1_1 = new JLabel();
		lblNewLabel_5_2_1_1_1_1_1.setText("Fecha:");
		lblNewLabel_5_2_1_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5_2_1_1_1_1_1.setBounds(82, 299, 111, 25);
		contentPane.add(lblNewLabel_5_2_1_1_1_1_1);
		
		JLabel fechalbl = new JLabel();
		fechalbl.setText((String) null);
		fechalbl.setHorizontalAlignment(SwingConstants.LEFT);
		fechalbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		fechalbl.setBounds(163, 299, 211, 25);
		contentPane.add(fechalbl);
		
		JLabel lblNewLabel_5_2_1_1_1_4 = new JLabel();
		lblNewLabel_5_2_1_1_1_4.setText("Hora de Salida:");
		lblNewLabel_5_2_1_1_1_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5_2_1_1_1_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5_2_1_1_1_4.setBounds(82, 334, 148, 25);
		contentPane.add(lblNewLabel_5_2_1_1_1_4);
		
		JLabel salidalbl = new JLabel();
		salidalbl.setText((String) null);
		salidalbl.setHorizontalAlignment(SwingConstants.LEFT);
		salidalbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		salidalbl.setBounds(241, 334, 133, 25);
		contentPane.add(salidalbl);
		
		JLabel lblNewLabel_5_2_1_1_1_1_2 = new JLabel();
		lblNewLabel_5_2_1_1_1_1_2.setText("Hora de Llegada:");
		lblNewLabel_5_2_1_1_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5_2_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5_2_1_1_1_1_2.setBounds(82, 369, 164, 25);
		contentPane.add(lblNewLabel_5_2_1_1_1_1_2);
		
		JLabel llegadalbl = new JLabel();
		llegadalbl.setText((String) null);
		llegadalbl.setHorizontalAlignment(SwingConstants.LEFT);
		llegadalbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		llegadalbl.setBounds(251, 369, 123, 25);
		contentPane.add(llegadalbl);
		
		JLabel lblNewLabel_5_2_1_1_1_5 = new JLabel();
		lblNewLabel_5_2_1_1_1_5.setText("Puerta:");
		lblNewLabel_5_2_1_1_1_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5_2_1_1_1_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5_2_1_1_1_5.setBounds(82, 404, 111, 25);
		contentPane.add(lblNewLabel_5_2_1_1_1_5);
		
		JLabel puertalbl = new JLabel();
		puertalbl.setText((String) null);
		puertalbl.setHorizontalAlignment(SwingConstants.LEFT);
		puertalbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		puertalbl.setBounds(168, 404, 206, 25);
		contentPane.add(puertalbl);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAceptar.setBounds(381, 475, 111, 36);
		contentPane.add(btnAceptar);
		
		// colocar el texto de los labels
		numVuelolbl.setText(String.valueOf(vuelo.getNumVuelo())) ;
		destinolbl.setText(vuelo.getDestino());
		origenlbl.setText(vuelo.getOrigen());
		salidalbl.setText(String.valueOf(vuelo.getHoraSalida()));
		llegadalbl.setText(String.valueOf(vuelo.getHoraLlegada()));
		puertalbl.setText(vuelo.getPuerta());
		fechalbl.setText(String.valueOf(vuelo.getFecha()));
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(436, 110, 16, 331);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(DetallesReservacion.class.getResource("/IMG/qrcode-generado.png")));
		lblNewLabel_1.setBounds(530, 181, 276, 260);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblCdigoQrDe = new JLabel();
		lblCdigoQrDe.setText("Código QR de los Boletos");
		lblCdigoQrDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblCdigoQrDe.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCdigoQrDe.setBounds(530, 123, 276, 25);
		contentPane.add(lblCdigoQrDe);
	}

}
