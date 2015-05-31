package enviaremail;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import enviar.EmailSender;

/**
 * Clase que representa la ventana principal 
 * de la aplicacion al ejecutar
 * 
 * @author Pavel
 * @author Cristo
 */
public class EnviarEmailForm extends JFrame {

	private static final long serialVersionUID = 1L;
	// DECLARACIONES
    JButton enviarButton;
    JButton vaciarButton;
    JButton cerrarButton;
    JLabel direccionLabel;
    JLabel asuntoLabel;
    JTextField direccionTextField;
    JTextField asuntoTextField;
    JTextArea mensajeTextArea;
    JPanel correoPanel;
    JPanel asuntoPanel;
    JPanel botonesPanel;
    JPanel textAreaPanel;

// CONSTRUCTOR
    /**
     * Constructor de la ventana,
     * inicializa el formulario y sus compentes
     */
    public EnviarEmailForm(){
        initForm();
        initComponents();
    }

    /**
     * Inicialización del formulario de envio de correo electronico
     */
    private void initForm(){
        setTitle("Enviar eMail");
        setSize(600,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * Inicialización de los componentes del formulario de envio de correo electronico
     */
    private void initComponents(){

        enviarButton = new JButton("Enviar"); 
        enviarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                enviar();
            }
        });

        vaciarButton = new JButton("Vaciar");
        vaciarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                vaciar();
            }
        });
        
        cerrarButton = new JButton("Cerrar");
        cerrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                cerrar();
            }
        });
        
        direccionLabel = new JLabel("eMail: ");
        asuntoLabel = new JLabel("Asunto: ");
        direccionTextField = new JTextField();
        asuntoTextField = new JTextField();
        mensajeTextArea = new JTextArea();
        mensajeTextArea.setLineWrap(true); //Inserta saltos de linea al final de linea.

        // Instanciamos todos los componentes del formulario.
        correoPanel = new JPanel();
        correoPanel.setLayout(new GridBagLayout());

        asuntoPanel = new JPanel();
        asuntoPanel.setLayout(new GridBagLayout());

        asuntoPanel.add(direccionLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.NORTH,
                GridBagConstraints.BOTH, new Insets(4, 4, 4, 4), 0, 0));
        asuntoPanel.add(direccionTextField, new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.NORTH,
                GridBagConstraints.BOTH, new Insets(4, 4, 4, 4), 0, 0));
        asuntoPanel.add(asuntoLabel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.NORTH,
                GridBagConstraints.BOTH, new Insets(4, 4, 4, 4), 0, 0));
        asuntoPanel.add(asuntoTextField, new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0, GridBagConstraints.NORTH,
                GridBagConstraints.BOTH, new Insets(4, 4, 4, 4), 0, 0));

        correoPanel.add(asuntoPanel, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.NORTH,
                GridBagConstraints.BOTH, new Insets(4, 4, 4, 4), 0, 0));
        correoPanel.add(mensajeTextArea, new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0, GridBagConstraints.SOUTH,
                GridBagConstraints.BOTH, new Insets(10, 10, 10, 10), 0, 0));


        botonesPanel = new JPanel();
        JPanel botonesPanel2 = new JPanel();
        botonesPanel2.setLayout(new GridLayout(3, 1, 4, 4));

        // Agregamos los botones al panel botnesPanel2.
        botonesPanel2.add(enviarButton); 
        botonesPanel2.add(vaciarButton);
        botonesPanel2.add(cerrarButton);
        botonesPanel.add(botonesPanel2);

        textAreaPanel = new JPanel();
        textAreaPanel.setLayout(new GridBagLayout());

        //Agregamos los paneles correoPanel y botonesPanel del contentPane. WEST = Izqda, EAST = Dcha.

        getContentPane().add(correoPanel, BorderLayout.CENTER);
        getContentPane().add(botonesPanel, BorderLayout.EAST); 

    }

    /**
     * Envia el correo a una cuenta predeterminada 
     */
    public void enviar(){
        EmailSender sender = new EmailSender("ecosaturno_oliver@yahoo.es", "43826914t");
        boolean resultado = sender.enviar("tabita@hotmail.com", "Prueba", "Hola");
        if (!resultado){
            JOptionPane.showMessageDialog(this, "Su correo no se ha podido enviar", 
                    "Mensaje no enviado", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Mejora de codigo, implementado la limpieza de los 
     * campos de "dirección, asunto y contenido" del correo electronico
     */
    public void vaciar(){
        
        direccionTextField.setText("");
        asuntoTextField.setText("");
        mensajeTextArea.setText("");
        direccionTextField.updateUI();
    }
    
    /**
     * Mejora de codigo, implementado el cierre de la aplicación
     */
    public void cerrar(){
        System.exit(DISPOSE_ON_CLOSE);
    }
    
}
