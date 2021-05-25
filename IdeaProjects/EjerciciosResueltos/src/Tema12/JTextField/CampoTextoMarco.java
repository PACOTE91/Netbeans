package Tema12.JTextField;/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//package javaapplication1;

// Fig. 11.9: CampoTextoMarco.java
// Demostración de la clase JTextField.
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

public class CampoTextoMarco extends JFrame
{
   private JTextField campoTexto1; // campo de texto con tamaño fijo
   private JTextField campoTexto2; // campo de texto construido con texto
   private JTextField campoTexto3; // campo de texto con texto y tamaño
   private JPasswordField campoContrasenia; // campo de contraseña con texto

   // El constructor de CampoTextoMarco agrega objetos JTextField a JFrame
   public CampoTextoMarco(int vector[])
   {
      // crear una ventana con título
      super( "Prueba de JTextField y JPasswordField" );
      setLayout( new FlowLayout() ); // establece el esquema del marco

      // construye campo de texto con 10 columnas
      campoTexto1 = new JTextField( 10 );
      this.add( campoTexto1 ); // agrega campoTexto1 a JFrame

      // construye campo de texto con texto predeterminado
      campoTexto2 = new JTextField( "Escriba el texto aqui" );
      add( campoTexto2 ); // agrega campoTexto2 a JFrame

      // construye campo de texto con texto predeterminado y 21 columnas
      campoTexto3 = new JTextField( "Campo de texto no editable", 21 );
      campoTexto3.setEditable( false ); // deshabilita la edición
      add( campoTexto3 ); // agrega campoTexto3 a JFrame

      // construye campo de contraseña con texto predeterminado
      campoContrasenia = new JPasswordField( "Texto oculto" );
      add( campoContrasenia ); // agrega campoContrasenia a JFrame

      // registra los manejadores de eventos
      // crear el manejador de eventos con la clase privada ManejadorCampoTexto
      ManejadorCampoTexto manejador = new ManejadorCampoTexto();

      // otro manejador, pero con un parámetro
      ManejadorCampoTexto manejador2 = new ManejadorCampoTexto(vector);

      // añadir el manejador a los 3 campos de texto y al de la contraseña
      campoTexto1.addActionListener( manejador );
      campoTexto2.addActionListener( manejador2 );
      campoTexto3.addActionListener( manejador );
      campoContrasenia.addActionListener( manejador );
   } // fin del constructor de CampoTextoMarco

   // clase interna privada para el manejo de eventos
   private class ManejadorCampoTexto implements ActionListener
   {
       // atributos => para pasar parámetros
       private int v[];

      // Constructor => para pasar parámetros
       public ManejadorCampoTexto (int vector[]) {
           v = vector;
       }
       // constructor por defecto => sin parámetros
       public ManejadorCampoTexto () {

       }

      // procesa los eventos de campo de texto
      public void actionPerformed( ActionEvent evento )
      {
         String cadena = ""; // declara la cadena a mostrar

         // el usuario oprimió Intro en el objeto JTextField campoTexto1
         if ( evento.getSource() == campoTexto1 )
            cadena = String.format( "campoTexto1: %s", campoTexto1.getText() );
            // también valdría asi: cadena = String.format( "campoTexto2: %s", evento.getActionCommand() );

         // el usuario oprimió Intro en el objeto JTextField campoTexto2
         else if ( evento.getSource() == campoTexto2 ) {
            cadena = String.format( "campoTexto2: %s \n", evento.getActionCommand() );
            cadena = cadena + "El vector ordenado ascendentemente es: \n";

             ordenacion.burbuja(v);
            for (int i=0; i< v.length; i++) {
                cadena = cadena + String.valueOf(v[i]) + ", ";
            }


         }

         // el usuario oprimió Intro en el objeto JTextField campoTexto3
         else if ( evento.getSource() == campoTexto3 )
            cadena = String.format( "campoTexto3: %s", evento.getActionCommand() );

         // el usuario oprimió Intro en el objeto JTextField campoContrasenia
         else if ( evento.getSource() == campoContrasenia )
         		// si ponemos esto también funciona
            // cadena = String.format( "campoContrasenia: %s",evento.getActionCommand() );
            cadena = String.format( "campoContrasenia: %s",
                     new String( campoContrasenia.getPassword() ) );

         // muestra el contenido del objeto JTextField
         JOptionPane.showMessageDialog( null, cadena );
      } // fin del método actionPerformed
   } // fin de la clase interna privada ManejadorCampoTexto
} // fin de la clase CampoTextoMarco


