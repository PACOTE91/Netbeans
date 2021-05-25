package Tema12.EjemplosRAMA;// importar las clases de la librería Swing y AWT
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingTest {

	// atributos de clase o estáticos
	private static JLabel etiqueta = new JLabel("--");
	private static JButton btnlimpia = new JButton("Limpia");
	private static JButton btnescribe = new JButton("Escribe");
	
	// E: e => evento
	// S: nada, establece el texto de la etiqueta dependiendo del tipo de botón
	//          si es el botón limpia (cadena vacia) 
	//          y si es el botón escribe pone el texto "Hola Mundo"
	public static void acciones(ActionEvent e) {
		// obtener el objeto que generó el evento
		Object obj = e.getSource();
		
		// comprobar si el objeto es el botón limpia
		if (obj == btnlimpia)
			// establecer el texto de la etiqueta
			etiqueta.setText("");

		// comprobar si el objeto es el botón escribe
		if (obj == btnescribe)
			etiqueta.setText("Hola Mundo");
	
	} // fin acciones
	
	public static void main(String[] args) {
	
		try {
			// Establecer el estilo metal o multiplataforma
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) { }
		
		// crear la ventana con el título: "Controlando eventos"
		JFrame ventana = new JFrame("Controlando eventos");
		
		// Crear un Listener asociado al botón limpia
		btnlimpia.addActionListener (new ActionListener() {
			// método de este Listener, se llama al pulsar el botón
			public void actionPerformed(ActionEvent e) {
				// se ejecuta el método acciones()
				acciones(e);
			}
		}); // fin Listener asociado al botón limpia
		
		// Crear un Listener asociado al botón escribe
		btnescribe.addActionListener (new ActionListener() {
			// método de este Listener, se llama al pulsar el botón
			public void actionPerformed(ActionEvent e) {
				// se ejecuta el método acciones()
				acciones(e);
			}
		}); // fin Listener asociado al botón escribe
		
		// añadir la etiqueta a la ventana
		ventana.getContentPane().add(etiqueta);
		
		// añadir los botones a la ventana
		ventana.getContentPane().add(btnlimpia);
		ventana.getContentPane().add(btnescribe);		
		
		// Crear un Listener asociado a la ventana
		ventana.addWindowListener(new WindowAdapter() {
			// método de este Listener se llama al cerrar la ventana
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		}); // fin Listener de la Ventana
		
		// Establecer el diseño de la ventana a una columna 
		ventana.setLayout(new GridLayout(0,1));
		// Establecer el tamaño de la ventana
    ventana.pack();
    // Centrar la ventana en la pantalla
    ventana.setLocationRelativeTo (null);
		// Hacer visible la ventana
    ventana.setVisible (true);
		
	} //fin main
	
} // fin clase SwingTest




