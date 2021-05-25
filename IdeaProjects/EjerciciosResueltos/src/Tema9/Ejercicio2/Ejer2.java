package Tema9.Ejercicio2;// 2.) Buscar si una palabra o frase está dentro de un archivo de texto.

import java.io.*;

public class Ejer2 {
	public static void main(String [] arg) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		String palabra = teclado.leer_cadena2("Introduce la cadena a buscar: ");		
      
		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File ("Osaka.txt");
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero línea a línea
			String linea;
			
			boolean encontrado = false;
			int num = 0; // contador de líneas
			
			String linea_encontrada = null;
			
			while((linea=br.readLine())!=null && !encontrado) {
				num ++;
				// System.out.println (linea);
				// buscar la cadena palabra en la línea leída
				if (linea.indexOf(palabra) != -1) {
					encontrado = true;
					linea_encontrada = linea;
				}
			}
			
			if (encontrado) {
				System.out.println ("Encontrada la palabra " + palabra + " en la línea nº " + num);
				System.out.println ("La línea donde aparecio la palabra es: \n" + linea_encontrada );
			}
			else
				System.out.println ("No Encontrada la palabra " + palabra);
				
		} catch (FileNotFoundException ex) {			
			System.out.println("\n Error, el fichero no existe!! o no se puede crear.");							
		
		} catch (IOException ex) {
			System.out.println("\nError de E/S" + ex);	
		}finally{
			// En el finally cerrar el fichero, para asegurarse
			// que se cierra tanto si todo va bien como si salta una excepcion.
			try {                    
				if (null != fr) 
					fr.close();     
				if (br != null)
					br.close();               
	
			} catch (Exception e2) { 
				e2.printStackTrace();
			}
		} // fin finally
		
   } // fin main
}
