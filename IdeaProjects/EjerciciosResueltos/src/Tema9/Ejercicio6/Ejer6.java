package Tema9.Ejercicio6;// 6.) Buscar a un amigo en el fichero de objetos amigos.dat y ver si lo encuentra.

// Ejemplo de lectura de un fichero de objetos
import java.io.*;


public class Ejer6 {

	public static void main(String[] args){
	
		boolean encontrado = false;
		
		//======== Lectura del fichero ==========
		try {
			File f=null;
			FileInputStream fe = null;
			ObjectInputStream ois = null;
			
			
			try {
				
				f = new File("amigos.dat");
				// Primero se comprueba si el fichero de objetos amigos.dat existe	
				if (f.exists()){
					// Abrir ficheros para lectura
					fe = new FileInputStream (f);
					ois = new ObjectInputStream (fe);
					
					// leer desde teclado el amigo a buscar
					String nombre = teclado.leer_cadena2 ("\n Introduce el nombre del amigo a buscar: ");					
					
					// leer objetos del fichero mientras que no salte la excepción de fin del fichero EOFException 					
					while ( !encontrado) { // bucle infinito?? si no lo encuentra
						Amigo a = null;
						// leer el objeto a del fichero ois 
						a = (Amigo)ois.readObject();
						
						if (a.nombre.equals (nombre) ) {
							// se ha encontrado el amigo
							encontrado = true;
							
							System.out.println ("\n Amigo encontrado!!");
							// mostrar por pantalla la información del objeto
							a.print();
							System.out.println("");
						}
					} 
					
					// aqui no se puede poner código....
					// if (!encontrado) MAL este código nunca se ejecutará sino se encuentra el amigo			 
					
				} // fin if
				else
					System.out.println ("\n El fichero amigos.dat no existe!!");
				
			} catch (EOFException eof) {
				// Se ha alcanzado el final del fichero
				System.err.println(" --------EOF------------------");
			
			} catch (FileNotFoundException fnf) {
				// El fichero no existe
				System.err.println("Fichero no encontrado " + fnf);
				
			} catch (StreamCorruptedException ex) {
				// El fichero de objetos está corrupto, p.e tienes dos cabeceras de bytes
				System.err.println("\nERROR: El fichero de objetos está corrupto");
				
			} catch(IOException e) {
				// Error de E/S
				System.err.println("Se ha producido una IOException");
				e.printStackTrace();
				
			} catch (Throwable e) {
				// Error de programa
				System.err.println("Error de programa: " + e);
				e.printStackTrace();
				
			} finally {
				// Cerrar ficheros
				if (ois != null) 
					ois.close();
				if (fe != null)
					fe.close();		
				
				if (!encontrado)
					System.out.println ("\n Amigo NO encontrado!!");
			}
			
		} catch(IOException e){
			e.printStackTrace();
		}
		
	} // fin main
	
} // fin clase Ejer6


