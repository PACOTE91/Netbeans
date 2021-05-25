package Tema12.Menu;// Fig. 22.6: PruebaMenu.java
// Prueba de MarcoMenu.
import javax.swing.JFrame;

public class PruebaMenu
{
   public static void main( String args[] )
   { 
   		// vector
      int vector [] = {1, -3, 15, -7, 4, 12, 0};
      
      MarcoMenu marcoMenu = new MarcoMenu (vector); // crea objeto MarcoMenu 
      marcoMenu.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      marcoMenu.setSize( 700, 200 ); // establece el tamaño del marco
      marcoMenu.setVisible( true ); // muestra el marco
   } // fin de main
} // fin de la clase PruebaMenu



