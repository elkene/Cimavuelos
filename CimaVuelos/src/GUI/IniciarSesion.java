package GUI;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import proyecto.Control;
import proyecto.Pasajero;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;

public class IniciarSesion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel contentPanel = new JPanel();
	private JTextField correotxt;
	private JPasswordField contraseñatxt;
	private ArrayList<Pasajero> pasajeros;
	
	private Inicio inicio;

	public static void main(String[] args){
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
					IniciarSesion frame = new IniciarSesion(null);
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
	public IniciarSesion(Inicio inicio) { // le paso la referencia de la interfaz Inicio
		this.inicio = inicio;
		setIconImage(Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/IMG/billeteDeAvion.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // solo se cierra esta ventana al cerrar
		setBounds(100, 100, 920, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
        setTitle("Iniciar Sesión");
		setBounds(100, 100, 920, 570);
        contentPane.setLayout(null);
        contentPanel.setBounds(0, 0, 939, 538);
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel);
        contentPanel.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 920, 63);
        panel.setLayout(null);
        panel.setBackground(new Color(130, 220, 236));
        contentPanel.add(panel);
        
        JLabel lblNewLabel = new JLabel("CimaVuelos");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblNewLabel.setBounds(73, 12, 234, 41);
        panel.add(lblNewLabel);
        
        JLabel lblNewLabel_1_2 = new JLabel("");
        lblNewLabel_1_2.setIcon(new ImageIcon(IniciarSesion.class.getResource("/IMG/viajarLogo.png")));
        lblNewLabel_1_2.setBounds(10, 0, 59, 63);
        panel.add(lblNewLabel_1_2);
        
        JLabel lblNewLabel_5_2 = new JLabel("Iniciar Sesión");
        lblNewLabel_5_2.setBounds(383, 95, 146, 55);
        lblNewLabel_5_2.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPanel.add(lblNewLabel_5_2);
        
        JLabel lblCorreo = new JLabel("Correo Electrónico");
        lblCorreo.setBounds(224, 289, 202, 29);
        lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        contentPanel.add(lblCorreo);
        
        correotxt = new JTextField();
        correotxt.setBounds(436, 289, 250, 28);
        correotxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        correotxt.setColumns(10);
        contentPanel.add(correotxt);
        
        JLabel lblContraseña = new JLabel("Contraseña");
        lblContraseña.setBounds(224, 353, 202, 29);
        lblContraseña.setFont(new Font("Tahoma", Font.PLAIN, 20));
        contentPanel.add(lblContraseña);
        
        contraseñatxt = new JPasswordField();
        contraseñatxt.setBounds(436, 353, 250, 28);
        contraseñatxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        contentPanel.add(contraseñatxt);
        
        JButton okButton = new JButton("Iniciar Sesión");
        okButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		iniciarSesion();
        	}
        });
        okButton.setBounds(710, 482, 165, 33);
        okButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        contentPanel.add(okButton);            
        okButton.setActionCommand("OK");
        getRootPane().setDefaultButton(okButton);
                
        JButton cancelButton = new JButton("Cancelar");
        cancelButton.setBounds(521, 482, 165, 33);
        cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        contentPanel.add(cancelButton);
        cancelButton.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                    dispose();
              }
        });
        cancelButton.setActionCommand("Cancel");
                        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setBounds(411, 160, 118, 103);
        lblNewLabel_1.setIcon(new ImageIcon(IniciarSesion.class.getResource("/IMG/iniciar-sesion.png")));
        contentPanel.add(lblNewLabel_1);
        
        // Añadir KeyListener para la tecla Enter
        correotxt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    iniciarSesion();
                }
            }
        });
        contraseñatxt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    iniciarSesion();
                }
            }
        });
               
    }
	
    // Método para validar y iniciar sesión
    private void iniciarSesion() {
        String correoIngresado = correotxt.getText();
        String contraseñaIngresada = new String(contraseñatxt.getPassword());

        // Verificar que los campos no estén vacíos
        if (correoIngresado.isEmpty() || contraseñaIngresada.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Control.leerArchivoRegistros();

        // Leer el archivo de registro
        try (BufferedReader br = new BufferedReader(new FileReader("registro.txt"))) {
            String linea;
            boolean correoEncontrado = false;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("Correo Electrónico: " + correoIngresado)) {
                    correoEncontrado = true;  // Encontramos el correo
                    // Leer las siguientes 2 líneas: Teléfono y Contraseña
                    br.readLine(); // Línea del teléfono, no la necesitamos
                    String contraseñaArchivo = br.readLine().split(":")[1].trim();
                    if (contraseñaArchivo.equals(contraseñaIngresada)) { // si las contraseñas coinciden
                    	// inicia sesion
                        JOptionPane.showMessageDialog(this, "¡Inicio de sesión exitoso!", "Éxito", JOptionPane.INFORMATION_MESSAGE);                    
                        if(establecerPasajero(correoIngresado)) { // si se establece el pasajeroActual                        	       
                        	// cargar sus reservaciones
                        	Control.obtenerReservaciones(correoIngresado);  
                        	// Vista de usuario activo
                        	cambiarVistaActivo(); 
                        }                        
                    } else {
                    	// contraseña incorrecta
                        JOptionPane.showMessageDialog(this, "Contraseña incorrecta.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }
            if (!correoEncontrado) { // no se encuentra el correo
                JOptionPane.showMessageDialog(this, "Correo no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al leer el archivo de registro.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // metodo para establecer el pasajero actual (una vez iniciado sesion)
    public boolean establecerPasajero(String correoIngresado) {
    	pasajeros = Control.getPasajeros();
    	
    	for(Pasajero p: pasajeros) {
    		if(p.getCorreo().trim().equals(correoIngresado.trim())) {
    			Control.setPasajeroActual(p);
    			return true;
    		}
    	}  
    	return false;
    } 
	
    // metodo para cambiar la vista a la de Usuario Activo
    public void cambiarVistaActivo() {
    	inicio.usuarioActivo();
    	dispose();
    }

  
}


