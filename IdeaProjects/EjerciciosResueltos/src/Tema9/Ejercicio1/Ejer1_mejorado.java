package Tema9.Ejercicio1;// 1.) Añadir al final de un archivo de texto otro archivo de texto.

// Al final de Texto1.txt se añade el archivo Texto2.txt

// Se utiliza la clase BufferedReader y Printwriter que acelera el proceso de lectura y escritura
// Con archivos pequeños no se nota la diferencia, 
// pero con archivos de texto grandes es mucho más rápida la lectura y escritura

import java.io.*;

public class Ejer1_mejorado {
	
	public static void main (String[] args){
		
		String nomb1 = "Texto1.txt";
		String nomb2 = "Texto2.txt";		
		
		FileWriter salida = null;
		FileReader entrada = null;
		PrintWriter salida2 = null;
		BufferedReader entrada2 = null;		
		
		// AÑADIR AL FINAL DE UN FICHERO DE TEXTO 	
		try {
			File f1 = new File(nomb1);
			File f2 = new File(nomb2);
			
			// abrir fichero para añadir al final del mismo
			salida = new FileWriter (f1, true);
			salida2 = new PrintWriter (salida); 
			// abrir fichero para lectura
			entrada = new FileReader (f2);
			entrada2 = new BufferedReader (entrada);
			
				
			System.out.println ("\n Añadiendo al final del fichero " + nomb1 + " el archivo " + nomb2);
			String linea;
			while((linea = entrada2.readLine()) != null) {
				salida2.println(linea);
			}
			
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
				if (null != entrada2) 
					entrada2.close();
				if (null != salida2) 
					salida2.close();   				             
	
			} catch (Exception e2) { 
				e2.printStackTrace();
			}
		} // fin finally		
		
		
	} // fin main
	
} // fin clase Ejer1

