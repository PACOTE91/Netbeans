package Tema9.Ejercicio5;
/* 5.) Añadir al final de un archivos de objetos más objetos.
 * Puedes utilzar el código de Amigo.java y FicheroObjetos.java, 
 * para añadir más objetos al archivo amigos.dat. */
 
 /* Este ejercicio en realidad ya está hecho lo tenéis en los apuntes en la clase Escritura3FicheroObjetos */
 
 // Ejemplo de añadir al final de un fichero de objetos
// FUNCIONA BIEN al añadir datos sobre un ObjectOutputStream
// http://www.chuidiang.com/java/ficheros/ObjetosFichero.php


import java.io.*;

public class Ejer5 {

	public static void main(String[] args){
	
		String [] amigos = {"JUAN García","Jesús Perez","Antonio Sanchez","María Martin"};
		long [] telefonos = {950777555,950221133,950331744,950444400};		
		
		FileOutputStream fs = null;
		MiObjectOutputStream oos = null;
		try {
			// Apertura del fichero de objetos amigos.dat para añadir al final
			// FUNCIONA BIEN (no le añade una nueva cabecera al final del archivo)
			fs = new FileOutputStream ("amigos.dat", true);
			oos = new MiObjectOutputStream(fs);
			
			// Escribir 4 objetos en el fichero
			for (int i=0;i<4;i++){
				Amigo a = new Amigo (amigos[i],telefonos[i]);
				// escribir el objeto a en el fichero oos
				oos.writeObject(a);
			}			
			
		} catch (FileNotFoundException ex) {
			// El fichero no se puede crear
			System.out.println ("\n Error, el fichero no se puede crear" + ex);
			
		} catch(IOException ex) {
			// Error de E/S
			System.out.println ("\n Error de E/S");
			ex.printStackTrace();
			
		} finally {
			
			try {
				// Cierre de los ficheros
				if (fs != null)
					fs.close();
				if (oos != null)
					oos.close();
			} catch (IOException ex) {
				// Error de E/S
				System.out.println ("\n Error de E/S al cerrar los ficheros");
				ex.printStackTrace();
			}			
		}	
		
	} // fin main
	
} // fin clase Ejer5



