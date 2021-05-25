package Tema12.JTextField;/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//package javaapplication1;

/**
 *
 * @author ramon
 */
// Fig. 11.10: PruebaCampoTexto.java
// Prueba de CampoTextoMarco.
import javax.swing.JFrame;

public class PruebaCampoTexto
{
   public static void main( String args[] )
   {
      // vector a ordenar
       int vector[] = {7, -8, 564, 300, 350, 795, 455, -9, 433};
      // pasar el vector como parámetro del constructor
      CampoTextoMarco campoTextoMarco = new CampoTextoMarco(vector);
      campoTextoMarco.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      campoTextoMarco.setSize( 350, 100 ); // establece el tamaño del marco
      campoTextoMarco.setVisible( true ); // muestra el marco
   } // fin de main
} // fin de la clase PruebaCampoTexto
