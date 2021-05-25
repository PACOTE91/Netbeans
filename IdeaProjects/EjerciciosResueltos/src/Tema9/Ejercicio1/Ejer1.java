package Tema9.Ejercicio1;// 1.) Añadir al final de un archivo de texto otro archivo de texto.

// Al final de Texto1.txt se añade el archivo Texto2.txt

import java.io.*;

public class Ejer1 {
	
	public static void main (String[] args){
		
		String nomb1 = "Texto1.txt";
		String nomb2 = "Texto2.txt";		
		
		FileWriter salida = null;
		FileReader entrada = null;
		
		// AÑADIR AL FINAL DE UN FICHERO DE TEXTO con FileWriter		
		try {
			File f1 = new File(nomb1);
			File f2 = new File(nomb2);
			
			// abrir fichero para añadir al final del mismo
			salida = new FileWriter (f1, true);
			// abrir fichero para lectura
			entrada = new FileReader (f2);
			
			// aunque sea c un entero, lo uso para leer caracteres
			int c; 
			
			System.out.println ("\n Añadiendo al final del fichero " + nomb1 + " el archivo " + nomb2);
			// leer todos los caracteres del fichero de entrada => -1 es el caracter EOF (final del fichero);						
			while((c=entrada.read())!=-1)
				// añadir al final del fichero de salida el caracter leido del fichero de entrada
				salida.write(c);
			
			System.out.println ("\n Proceso de escritura finalizado!!");
		} catch (FileNotFoundException ex) {			
			System.out.println("\n Error, el fichero no existe!! o no se puede crear.");							
		
		} catch (IOException ex) {
			System.out.println("\nError de E/S" + ex);		
			
		} finally {
			// En el finally cerrar el fichero, para asegurarse
			// que se cierra tanto si todo va bien como si salta una excepcion.
			try {                    
				if (null != entrada) 
					entrada.close();
				if (null != salida) 
					salida.close();     				             
	
			} catch (Exception e2) { 
				e2.printStackTrace();
			}
		} // fin finally		
		
		
	} // fin main
	
} // fin clase Ejer1

