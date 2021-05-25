package Tema12.EjemplosRAMA;// importar la librería Swing
import javax.swing.*;

public class HolaMundoSwing {

	public static void main(String args[]) {
	
		// Crear la ventana
		JFrame ventana = new JFrame("Ventana Hola Mundo");
		// Terminar la aplicación al cerrar la ventana
		ventana.setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);
		
		// Crear una etiqueta
		JLabel etiqueta= new JLabel ("  Hola Mundo!!   ");
		// Añadir la etiqueta a la ventana
		ventana.getContentPane().add(etiqueta);
		// Establecer el tamaño de la ventana
		ventana.pack();
		// Centrar la ventana en la pantalla
		ventana.setLocationRelativeTo (null);
		
		// Recuperar el estilo del Sistema Operativo actual
		String estiloSO = UIManager.getSystemLookAndFeelClassName();
		
		try {
			// Establecer el estilo metal o multiplataforma
			// UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			
			// Establecer el estilo del SO actual
			UIManager.setLookAndFeel(estiloSO);
			
			// Establecer el estilo metal o multiplataforma (otra forma de hacerlo)
			// UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			
			// Establecer el estilo de Windows => da un error al ejecutarlo sobre Linux ;-)
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			
			// Estilo Solaris => se puede usar en cualquier plataforma
			// UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		} catch (Exception e) { System.out.println("Error al aplicar estilo de de ventanas"); }
		
		// Hacer visible la ventana
		ventana.setVisible (true);
		
	} // fin main

} // fin clase HolaMundoSwing

