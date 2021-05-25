package Tema9.Ejercicio4;// 4.) Comprobar si dos archivos binarios son iguales.

// Se puede mejorar el código leyendo en un buffer (vector) muchos bytes de golpe en vez de uno a uno

// USAR LA CLASE FileInputStream de ficheros binarios para leer byte a byte

import java.io.*;

public class Ejer4 {

	public static void main (String args[]) {
	
		// String nomb1 = "Texto1.txt";
		// String nomb2 = "Texto2.txt"; // Texto2.txt es una copia de Texto1.txt
		// String nomb2 = "Prueba.txt";	// Prueba.txt es distinto => diferente tamaño que Texto1.txt
		// String nomb2 = "Prueba2.txt";	// Prueba2.txt es distinto => pero tiene el mismo tamaño que Texto1.txt
		String nomb1 = "Ejer3.class";
		String nomb2 = "Ejer3_copia.class"; // Ejer3_copia.class es una copia de Ejer3.class
		
		// manejadores de los archivos nomb1 y nomb2
		FileInputStream entrada1 = null; 
		FileInputStream entrada2 = null;
		
		boolean iguales = false; // indica sin son iguales o no los ficheros		
		
		// Comparar los dos archivos de texto	
		try {
			
			File f1 = new File(nomb1);
			File f2 = new File(nomb2);
			
			// Se comprueba el tamaño de los dos archivos
			long tamano1 = f1.length();
			long tamano2 = f2.length();			
						
			if (tamano1 != tamano2) {
				// tamaño distinto los archivos no son iguales
				iguales = false;
				System.out.println ("\n Tamaño diferente en los archivos.");
			}			
			else {
				// mismo tamaño se pueden comparar los archivos
						
				// abrir los ficheros binarios para lectura
				entrada1 = new FileInputStream (f1);
				entrada2 = new FileInputStream (f2);									
				
				boolean byte_igual = true;
				int byte_leido1, byte_leido2;
						
				// leer byte a byte de los dos ficheros
				// mientras sean los bytes leídos iguales
				for (long i=1; i<=tamano1 && byte_igual; i++) {
					byte_leido1 = entrada1.read();
					byte_leido2 = entrada2.read();
					
					if (byte_leido1 != byte_leido2)
						// los bytes leídos son diferentes
						byte_igual = false;
				}
				
				if (byte_igual)
					// los dos archivos son iguales
					iguales = true;
				else
					iguales = false; // no hace falta ya que tiene este valor inicial
					
			} // fin else
			
		} catch (FileNotFoundException ex) {			
			System.out.println ("Error, alguno de los archivos no existe " + ex);
			ex.printStackTrace();			
							
		} catch (IOException e) {
			// En caso de error			
			System.out.println ("Error en la lectura del archivo " + e);
			e.printStackTrace();
		}
		finally {
			try {
				// cerrar los archivos
				if (entrada1 != null)
					entrada1.close();
					
				if (entrada2 != null)
					entrada2.close();					
					
			} catch (IOException e) {
				// En caso de error			
				System.out.println ("Error al cerrar los archivos abiertos para lectura " + e);
				/* printStackTrace() => Describe el contenido de la pila de llamadas en el momento 
				 * en que se produjo la excepción */
				e.printStackTrace(); 
			} 		
			
			if (iguales)
				System.out.println ("\n " + nomb1 + " y " + nomb2 + " son dos archivos iguales");
			else
				System.out.println ("\n " + nomb1 + " y " + nomb2 + " son dos archivos diferentes");
										
		} // fin finally			
	
	} // fin main

} // fin clase Ejer4
