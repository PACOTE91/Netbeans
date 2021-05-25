package Tema9.Ejercicio7y8;/* 7.) Realiza un método que reciba un archivo de texto y lo encripte por el algoritmo del César,
 * por ejemplo, si tenemos la frase: "Esto es un experimento", 
 * se puede encriptar la frase sumándole a cada carácter un número constante (uno o el que tu quieras). 
 * Por lo tanto la frase desencriptada será "Ftup!ft!vo!fyqfsjnfoup".

Lo mejor es que primero hagas una función que encripte una frase:
// E: cad => cadena a encriptar 
// S: cadena cad encriptada por el método del César
public static String encripta_cesar (String cad)

Y después uses esta función para encriptar el archivo de texto línea a línea. */

import java.io.*;

public class Ejer7 {
	
	// E: cad => cadena a encriptar 
	// S: cadena cad encriptada por el método del César 
	//    (le suma 1 a cada caracter de la cadena)
	public static String encripta_cesar (String cad) {
		int tamano = cad.length();
		
		String encriptada = "";
		
		for (int i=0; i < tamano; i++)	{
			// leer el caracter de la posición 1 y le sumamos uno
			int c = cad.charAt(i) + 1;			
			char car = (char) c;
			
			encriptada = encriptada + car;
		}
		
		return encriptada;
	}
	
	public static void main (String [] args) {
		
		// probar primero que encripta bien con el método encripta_cesar()
		String cadena = "Esto es un experimento";
				
		String cadena_encriptada = encripta_cesar (cadena);
		
		System.out.println ("\n La cadena " + cadena + " encriptada es = \n" + cadena_encriptada);
		
		// Lectura del fichero de texto
		
		// LECTURA DE UN FICHERO DE TEXTO con FileReader y BufferedReader
		
		String fichero_a_leer = "fichero.txt";
		String fichero_encriptado = "fichero2.txt";
		
		FileReader fr = null;
		BufferedReader entrada = null;
		FileWriter fw = null;
		PrintWriter salida = null;

		try {
			// abrir fichero para lectura
			File f = new File (fichero_a_leer );
			fr = new FileReader(f);
			entrada = new BufferedReader(fr);
			
			// abrir fichero para escritura (donde se copia lo encriptado)
			File f2 = new File (fichero_encriptado);
			fw = new FileWriter(f2);
			salida = new PrintWriter(fw);			
			
			String linea;
			String encriptada;
			
			System.out.println ("\n Empezando el proceso de encriptación del fichero " + fichero_a_leer);
			
			while((linea = entrada.readLine()) != null) {
				// encriptar la línea leída
				encriptada = encripta_cesar (linea);
				// escribir en el fichero la línea encriptada
				salida.println (encriptada);
			}
			
			System.out.println ("\n El fichero se ha encriptado en " + fichero_encriptado);			
			
				
		} catch (FileNotFoundException ex) {
			System.out.println("\n Error el fichero no existe o no se puede crear: " + ex);
			
		} catch(IOException ex){
			System.out.println("\n Error de E/S: " + ex);
			ex.printStackTrace();
			
		} finally {
			
			try {
				
				// cerrar flujos				
				if (fr != null) 
					fr.close();
					
				if (entrada != null) 
					entrada.close();
					
				if (fw != null) 
					fw.close();
					
				if (salida != null) 
					salida.close();
					
			} catch (IOException ex) {
				System.out.println("\n Error de E/S al cerrar los ficheros: " + ex);
				ex.printStackTrace();
			}
		}		
		
	} // fin main	
	
} // fin clase Ejer7
