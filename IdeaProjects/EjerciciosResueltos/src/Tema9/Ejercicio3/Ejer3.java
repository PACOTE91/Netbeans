package Tema9.Ejercicio3;// 3.) Comprobar si dos archivos de texto son iguales.

import java.io.*;

// Se puede mejorar el código leyendo línea a línea con BufferedReader

public class Ejer3 {
	
	public static void main (String[] args){
		
		String nomb1 = "Texto1.txt";
		String nomb2 = "Texto2.txt"; // Texto2.txt es una copia de Texto1.txt
		// String nomb2 = "Prueba.txt";	// Prueba.txt es distinto => diferente tamaño que Texto1.txt
		// String nomb2 = "Prueba2.txt";	// Prueba2.txt es distinto => pero tiene el mismo tamaño que Texto1.txt
	
		
		FileReader entrada1 = null;
		FileReader entrada2 = null;
		
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
				
				// abrir ficheros para lectura
				entrada1 = new FileReader (f1);
				entrada2 = new FileReader (f2);
				
				// aunque sean car1 y car2 enteros, los uso para leer caracteres
				int car1, car2; 
				
				System.out.println ("\n Comparando el fichero " + nomb1 + " con el archivo " + nomb2);
				
				boolean caracter_igual = true; // para comprobar que los caracteres leídos son iguales
				while((car1 = entrada1.read())!=-1 && (car2 = entrada2.read())!=-1 && caracter_igual)
					if (car1 != car2)
						// los dos caracteres leídos son diferentes
						caracter_igual = false;
				
				if (caracter_igual == true)
					// los dos archivos son iguales
					iguales = true;		
				
			}
		} catch (FileNotFoundException ex) {			
			System.out.println("\n Error, el fichero no existe!!");							
		
		} catch (IOException ex) {
			System.out.println("\nError de E/S" + ex);		
			
		} finally {
			// En el finally cerrar los ficheros, para asegurarse
			// que se cierra tanto si todo va bien como si salta una excepcion.
			try {                    
				if (null != entrada1) 
					entrada1.close();
					
				if (null != entrada2) 
					entrada2.close();     				             
	
			} catch (Exception e2) { 
				e2.printStackTrace();
			}
			
			if (iguales)
				System.out.println ("\n " + nomb1 + " y " + nomb2 + " son dos archivos de texto iguales");
			else
				System.out.println ("\n " + nomb1 + " y " + nomb2 + " son dos archivos de texto diferentes");
		} // fin finally		
		
		
	} // fin main
	
} // fin clase Ejer3

