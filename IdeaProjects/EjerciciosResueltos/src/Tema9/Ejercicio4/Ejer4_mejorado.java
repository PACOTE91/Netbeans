package Tema9.Ejercicio4;// 4.) Comprobar si dos archivos binarios son iguales.

// USAR LA CLASE BufferedInputStream de ficheros binarios para leer muchos bytes de golpe en vez de uno a uno

import java.io.*;

public class Ejer4_mejorado {
	
	// comprobar si dos vectores son iguales		
	private static boolean vectores_iguales (byte v1[], byte v2[]) {
		boolean igual = true;
		
		if (v1.length != v2.length)
			igual = false;
		else {
			// los dos vectores son iguales, se pueden recorrer a la vez
			for (int i=0; i<v1.length && igual; i++)
				if (v1[i] != v2[i])
					// los dos vectores son distintos
					igual = false;
		}
		
		return igual;
	}

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
		BufferedInputStream buffer1 = null;
		BufferedInputStream buffer2 = null;
		
		
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
				
				buffer1 = new BufferedInputStream (entrada1);
				buffer2 = new BufferedInputStream (entrada2);
				
				// Bucle para leer de un fichero y escribir en el otro de 1000 bytes en 1000 bytes.
				byte [] vector1 = new byte[1000];
				byte [] vector2 = new byte[1000];
				int leidos1 = buffer1.read(vector1);
				int leidos2 = buffer2.read(vector2);
				
				boolean mismos_vectores = vectores_iguales (vector1, vector2);
				
				while (leidos1 > 0 && leidos2 > 0 &&  mismos_vectores) 	{					
					leidos1 = buffer1.read(vector1);
					leidos2 = buffer2.read(vector2);
					mismos_vectores = vectores_iguales (vector1, vector2);
				}							
												
				if (mismos_vectores)
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
				// cerrar los flujos
				if (entrada1 != null)
					entrada1.close();
					
				if (entrada2 != null)
					entrada2.close();
				
				if (buffer1 != null)
					buffer1.close();
					
				if (buffer2 != null)
					buffer2.close();
					
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
