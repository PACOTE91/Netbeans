package Tema9.Ejercicio9;

// 9.) Grabar en un archivo los objetos de la clase Figura.

import java.io.*;

public class Ejer9 {	
	
	// Ejer 4
	/* E: v => vector de variables de la superclase Figura
	   S: nada, para cada elemento del vector muestra por pantalla su área 
	   * y según corresponda su volumen o perímetro, también muestra el nombre de la clase  a la que pertenece */
	public static void mostrar_vector (Figura[]v) {
		
		for (Figura ele: v) {
			System.out.println ("\n El área de la figura "+ ele.getNombre() + " es: " + ele.Area());
			
			if (ele instanceof Figura2D == true) {
				// conversion descendente
				Figura2D fig2D = (Figura2D) ele;
				System.out.println (" Perímetro: " + fig2D.Perimetro() );
			}
			
			if (ele instanceof Figura3D) {
				// conversion descendente
				Figura3D fig3D = (Figura3D) ele;
				System.out.println (" Volumen: " + fig3D.Volumen() );
			}
			
			
		}
	}
	
	
	/* E: fig => variable de la superclase abstracta Figura
	   S: nada, lee desde teclado los datos de una figura (Cuadrado, Circulo,
	  Triangulo, Esfera y Cubo) y los almacena en la variable fig */
	public static Figura leer_figura_BIEN ( ) {
		
		Figura fig = null; // figura a devolver apuntando a un objeto de una clase concreta
		int num;
		
		do {
			num = teclado.leer_entero("\n Introduce el tipo de figura a introducir: 1 Cuadrado, 2 Circulo, 3 Triangulo, 4 Esfera, 5 Cubo:");
		} while (num <= 0 || num > 5);
		
		
		// datos comunes a todas las figuras
		String nomb = teclado.leer_cadena ("\nNombre de la figura: ");
		int color2 = teclado.leer_entero (", color: ");
		int grosor = teclado.leer_entero (", grosor: ");
		
		if (num == 1)  {
			// Cuadrado			
			double lado_cuadrado = teclado.leer_double (", lado del cuadrado: ");						
			Cuadrado cuad = new Cuadrado (nomb, color2, grosor, lado_cuadrado);			
			fig = cuad;			
		}
		
		if (num == 2)  {
			// Circulo			
			double radio2 = teclado.leer_double (", radio del círculo: ");						
			Circulo cir = new Circulo (nomb, color2, grosor, radio2);			
			fig = cir;			
		}
		
		if (num == 3)  {
			// Triangulo			
			double l1 = teclado.leer_double (", lado1: ");
			double l2 = teclado.leer_double (", lado2: ");
			double b = teclado.leer_double (", base: ");
			double a = teclado.leer_double (", altura: ");								
			Triangulo tri = new Triangulo (nomb, color2, grosor, l1, l2, b, a);			
			fig = tri;			
		}
		
		if (num == 4)  {
			// Esfera			
			double r = teclado.leer_double (", radio de la esfera: ");						
			Esfera esfe = new Esfera (nomb, color2, grosor, r);			
			fig = esfe;			
		}
		
		if (num == 5)  {
			// Cubo			
			double lado_cubo = teclado.leer_double (", lado del cubo: ");						
			Cubo cubo1 = new Cubo (nomb, color2, grosor, lado_cubo);			
			fig = cubo1;			
		}
		
		return fig;
		
		
	} // fin leer_figura_BIEN
	
	
	// Ejer 6
	
	/* E: v => vector de variables de la superclase abstracta Figura
	   S: nada, para cada elemento del vector lee desde teclado los datos de una 
	      figura (Cuadrado, Circulo,Triangulo, Esfera y Cubo) y los almacena en la
          en ese elemento del vector */
	public static void leer_figuras (Figura v[]) {
		
		/* OJO no se puede usar el for mejorado para asignar valores a los elementos del vector
		for (Figura fig : v) 
			fig = leer_figura_BIEN(); */
			
		for (int i=0; i<v.length; i++) 
			v[i] = leer_figura_BIEN();
		
	} // fin leer_figura

	

	public static void main (String args[]) {
		// crear un vector de 5 figuras
		Figura [] vector = new Figura[5];
		
		// leer las figuras y guardarlas en el vector
		leer_figuras (vector);
		
		// mostrar las figuras por pantalla
		mostrar_vector (vector);		
		
		FileOutputStream fs = null;
		ObjectOutputStream salida = null;
		
		FileInputStream fi = null;
		ObjectInputStream entrada = null;
		
		try {
			// Apertura del fichero de objetos figuras.dat para escritura
			fs = new FileOutputStream ("figuras.dat");
			salida = new ObjectOutputStream (fs);
			
			// Escribir todos los objetos figura en el fichero
			for (int i=0; i<vector.length; i++) {			
				// escribir el objeto v[i] en el fichero oos				
				salida.writeObject (vector[i]);
			}
			
			// Apertura del fichero de objetos para lectura			
			fi = new FileInputStream ("figuras.dat");
			entrada = new ObjectInputStream (fi);
			
			// Leer todos los objetos figura del fichero
			
			while(true) { // bucle infinito??
				Figura fig = null;
				// leer el objeto a del fichero ois 
				fig = (Figura) entrada.readObject();
				// mostrar por pantalla la información del objeto leído
				System.out.println(fig);
			} 
			
			/* No poner aqui instrucciones hay un bucle infinito antes */							
			
		} catch (EOFException ex) {
			System.out.println ("\n Se ha alcanzado el final del archivo ..........");
		
		} catch (ClassNotFoundException ex) {
			System.out.println ("\n Error no se ha leido la clase del Objeto esperada .........." + ex);
			
		} catch (FileNotFoundException ex) {
			// El fichero no se puede crear
			System.out.println ("\n Error, el fichero no se puede crear o no existe" + ex);
			
		} catch(IOException ex) {
			// Error de E/S
			System.out.println ("\n Error de E/S");
			ex.printStackTrace();
			
		} finally {
			
			try {
				// Cierre de los ficheros
				if (fs != null)
					fs.close();
				if (salida != null)
					salida.close();
				if (entrada != null)
					entrada.close();	
				
			} catch (IOException ex) {
				// Error de E/S
				System.out.println ("\n Error de E/S al cerrar los ficheros");
				ex.printStackTrace();
			}			
		}	
		
		
	} // fin main

} // fin clase Prueba_figura
