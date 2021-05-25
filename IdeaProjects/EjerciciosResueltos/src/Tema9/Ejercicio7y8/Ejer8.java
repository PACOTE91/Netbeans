package Tema9.Ejercicio7y8;
/* 8.) Realiza un método que reciba un archivo de texto y lo desencripte por el algoritmo del César,
 * por ejemplo, si tenemos la frase: "Ftup!ft!vo!fyqfsjnfoup", 
 * se puede desencriptar la frase restándole a cada carácter un número constante (uno o el que tu quieras). 
 * Por lo tanto la frase encriptada será "Esto es un experimento".

Lo mejor es que primero hagas una función que desencripte una frase:
// E: cad => cadena encriptada
// S: cadena cad deseencriptada por el método del César
public static String desencripta_cesar (String cad)

Y después uses esta función para desencriptar el archivo de texto línea a línea. */

import java.io.*;

public class Ejer8 {
	
	// E: cad => cadena a encriptar 
	// S: cadena cad encriptada por el método del César 
	//    (le suma 1 a cada caracter de la cadena)
	public static String desencripta_cesar (String cad) {
		int tamano = cad.length();
		
		String encriptada = "";
		
		for (int i=0; i < tamano; i++)	{
			// leer el caracter de la posición 1 y le sumamos uno
			int c = cad.charAt(i) - 1;			
			char car = (char) c;
			
			encriptada = encriptada + car;
		}
		
		return encriptada;
	}
	
	public static void main (String [] args) {
		
		// probar primero que desencripta bien con el método desencripta_cesar()
		String cadena = "Ftup!ft!vo!fyqfsjnfoup";
				
		String cadena_desencriptada = desencripta_cesar (cadena);
		
		System.out.println ("\n La cadena " + cadena + " desencriptada es = \n" + cadena_desencriptada);
		
		// Lectura del fichero de texto
		
		// LECTURA DE UN FICHERO DE TEXTO con FileReader y BufferedReader
		
		String fichero_a_leer = "fichero2.txt";
		String fichero_desencriptado = "fichero3.txt";
		
		FileReader fr = null;
		BufferedReader entrada = null;
		FileWriter fw = null;
		PrintWriter salida = null;

		try {
			// abrir fichero encriptado para lectura
			File f = new File (fichero_a_leer );
			fr = new FileReader(f);
			entrada = new BufferedReader(fr);
			
			// abrir fichero para escritura (donde se copia lo desencriptado)
			File f2 = new File (fichero_desencriptado);
			fw = new FileWriter(f2);
			salida = new PrintWriter(fw);			
			
			String linea;
			String desencriptada;
			
			System.out.println ("\n Empezando el proceso de desencriptación del fichero " + fichero_a_leer);
			
			while((linea = entrada.readLine()) != null) {
				// encriptar la línea leída
				desencriptada = desencripta_cesar (linea);
				// escribir en el fichero la línea desencriptada
				salida.println (desencriptada);
			}
			
			System.out.println ("\n El fichero se ha desencriptado en " + fichero_desencriptado);			
			
				
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
	
} // fin clase Ejer8
