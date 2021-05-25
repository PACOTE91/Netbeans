package Tema9.Ejercicio9;

public class Prueba_Figura2 {	
	
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
	
	// Ejer 5
	
	/* E: fig => variable de la superclase abstracta Figura
	   S: nada, lee desde teclado los datos de una figura (Cuadrado, Circulo,
	  Triangulo, Esfera y Cubo) y los almacena en la variable fig */
	public static void leer_figura_MAL (Figura fig) {
		// MAL el método, debería devolver la reserva de memoria del objeto
		
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
		
		
	} // fin leer_figura_MAL
	
	
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
	
	//-------------------------------------------------
	// =================== Ejer 7  ====================
	//-------------------------------------------------
	
	/* E: v => vector de variables de la superclase abstracta Figura
       S: nada, ordenada descendentemente el vector según el tamaño del área por el método de quicksort */
	public static void ordenar_quicksort_desc (Figura v[], int izq, int der) {
		
		int pivote;
		if(izq < der){
			pivote = pivote_desc(v, izq, der);
			// ordenar la parte izquierda del vector a partir de pivote
			ordenar_quicksort_desc (v, izq, pivote-1);
			// ordenar la parte derecha del vector a partir de pivote
			ordenar_quicksort_desc (v, pivote+1, der);
		}  
		
	} // fin ordenar_quicksort_desc
	
	
	
	/* E: v => vector de variables de la superclase abstracta Figura		
		izq => posición del indice izquierda dentro del vector
		der => posición del indice derecha dentro del vector		 
	   S: posición del pivote o elemento del vector que queda ordenado descendentemente */ 	     
	public static int pivote_desc (Figura v[], int izq, int der) {			
		
		int pos; // posición del vector a intercambiar con el pivote
		/* eleccion del pivote, por ejemplo el elemento más a la izquierda */
		int	pivote = izq;		
		
		// comprobar el caso particular de que derecha es uno más que izquierda
		if (izq+1 == der) {			
				// Caso 1) hay que ordenar un vector de dos elementos
				if ( v[izq].Area() < v[der].Area() )
					pos = der;
				else
					pos = izq;				
		}
		else {			
			// Caso 2) el vector a ordenar tiene 3 o más elementos
			izq ++;				
			
			while (izq < der) {
				
				// comprobar si izq y der están bien posicionados con respecto a pivote				
				if ( v[izq].Area() <= v[pivote].Area() && v[der].Area() > v[pivote].Area() ) {					
					// no están bien ordenados => se intercambian v[izq] con v[der]					
					Figura aux = v[izq];
					v[izq] = v[der];
					v[der] = aux;
											
					izq ++;
					der --;					
				}				
				else {
					// comprobar si hay que avanzar o no los indices izquierda o derecha
					// en caso de que estén bien colocados respecto al pivote
					if ( v[izq].Area() > v[pivote].Area() )
						izq ++;
						
					if ( v[der].Area() <= v[pivote].Area() )
						der --;					
				}	// fin else	
				
			} // fin while			
		
			// ====== Calcular donde hay que colocar el pivote ===========
			if (izq == der) {
				if (v[pivote].Area() <= v[izq].Area() )
					// esto significa que hay que intercambiar el pivote con der, por ejemplo.
					pos = der;					
				else 
					// hay que intercambiar el pivote con derecha -1
					// puede suceder que si pivote = derecha -1 realmente no se intercambie nada
					pos = der -1;						
			}
			else
				// izq > der
				pos = der;	
				
		} // fin else de más arriba
		
		// Al salir del bucle a la izquierda de izq todos los elementos (no se cuenta a pivote) son 
		// menores o iguales que v[pivote]
		// Y a la derecha de dech todos los elementos (excepto pivote) son 
		// mayores que v[pivote]		
		
		if (pos != pivote) {			
			// intercambiar v[pos] con v[pivote]
			Figura aux = v[pos];
			v[pos] = v[pivote];
			v[pivote] = aux;							
		} 
		
		// la posición del pivote está en pos
		return pos;
	
	} // fin pivote_desc
	
	

	

	public static void main (String args[]) {
		// ====== Ejercicio 2 ========
		
		System.out.println ("\nEjercicio 2:\n");
	
		// crear un objeto cuadrado de lado = 10
		Cuadrado cuadrado1 = new Cuadrado ("Cuadrado 1", 1, 2, 10);		
		
		// Mostrar el área del cuadrado y longitud de su diagonal
		System.out.println ("Área del cuadrado = " + cuadrado1.Area() );
		System.out.println ("Longitud de la diagonal del cuadrado = " + cuadrado1.Diagonal() );
		
		// cambiar el lado del cuadrado para que valga 20
		cuadrado1.put_lado (20);
		
		// crear un objeto cuadrado de lado = 40
		Cuadrado cuadrado2 = new Cuadrado ("Cuadrado 2", 1, 2, 40);	
		
		
		// Mostrar el área del cuadrado y longitud de su diagonal
		System.out.println ("Área del cuadrado = " + cuadrado1.Area() );
		System.out.println ("Longitud de la diagonal del cuadrado = " + cuadrado1.Diagonal() );
		
		// Crear un objeto triangulo de base = 10, altura = 20, lado = 20, lado = 22.360679775
		Triangulo triangulo1 = new Triangulo ("Triangulo 1", 1, 2, 20, 22.360679775, 10, 20);
		
		// Mostrar el área y longitud del triángulo
		System.out.println ("Área del triángulo = " + triangulo1.Area() );
		System.out.println ("Longitud del triángulo = " + triangulo1.Perimetro() );
		
		// Crear un objeto círculo de radio = 45
		Circulo circulo1 = new Circulo ("Circulo 1", 1, 2, 45);
		
		// Mostrar el radio, área y longitud del círculo
		System.out.println ("Radio del círculo = " + circulo1.get_radio() );
		System.out.println ("Área del círculo = " + circulo1.Area() );
		System.out.println ("Longitud del círculo = " + circulo1.Perimetro() );
		
		// Crear un objeto esfera de radio = 30
		Esfera esfera1 = new Esfera ("Esfera 1", 1, 2, 30);
		
		// Mostrar el radio, área y longitud del círculo
		System.out.println ("Radio de la esfera = " + esfera1.get_radio() );
		System.out.println ("Área de la esfera = " + esfera1.Area() );
		System.out.println ("Volumen de la esfera = " + esfera1.Volumen() );
		
		// Crear un objeto cubo de lado = 20
		Cubo cubo1 = new Cubo ("Cubo 1", 1, 2, 20);
		
		// Mostrar el volumen y área del cubo
		System.out.println ("Área del cubo = " + cubo1.Area() );
		System.out.println ("Volumen del cubo = " + cubo1.Volumen() );
		
		
		// ====== Ejercicio 3 ========
		
		System.out.println ("\nEjercicio 3:\n");
		
		// Polimorfismo
		// Hacer que una variable de la superclase apunte a objetos de sus subclases
		// para asi poder llamar a los métodos de la subclase que estén también en la superclase
		Figura figura1 = cuadrado1;
				
		System.out.println ("El Área del cuadrado es: " + figura1.Area() );
		
		figura1 = triangulo1;
				
		System.out.println ("El Área del triángulo es: " + figura1.Area() );
		
		figura1 = circulo1;
		
		System.out.println ("El Área del circulo es: " + figura1.Area() );
		
		
		
		// Como a través de una variable de la superclase no se puede llamar a métodos de la subclase
		// que no están en la superclase también, hay que utilizar la técnica de conversión descendente
		// para lograrlo
		
				
		/* Ejercicio 4.) Polimorfismo A partir de la clase Prueba_Figura, crea un vector de 5 variables de la superclase Figura 
		 * y haz que apunten a objetos de las 5 subclases concretas (Cuadrado, Circulo, Triangulo, Esfera y Cubo). 
		 * Recorre mediante un bucle esas 5 figuras y muestra por pantalla el área y según corresponda su volumen o perímetro, 
		 * también muestra el nombre de la clase de cada objeto que es apuntado por el elemento actual del vector.	*/
		 
		System.out.println ("\nEjercicio 4:\n");
		
		Figura [] v = {cuadrado1, cuadrado2, triangulo1, circulo1, esfera1, cubo1}; 
		
		mostrar_vector (v);
		
		/* Ejer 5 */
		System.out.println ("\nEjercicio 5:\n");
		
		
		// Este código no funciona, prueba a descomentarlo
		/*
		Figura fig=null;
		leer_figura_MAL (fig);
		
		System.out.println ("\n El área de la figura "+ fig.getNombre() + " es: " + fig.Area()); */
		
		char c;
		Figura fig=null;
		
		do {
			
			fig =leer_figura_BIEN ();
			
			System.out.println ("\n El área de la figura "+ fig.getNombre() + " es: " + fig.Area());
			c = teclado.leer_caracter ("\n Deseas crear más objetos figura (S/N): ");
			
			// date cuenta que las referencias de los objetos creados se pierden
			// solo queda la referencia del último objeto creado
			// este bucle es para poder probar la creación de los objetos de diferentes clases concretas			
		} while (c == 's' || c == 'S');
		
		
		
		// Ejer 6
		
		// crear un vector de 8 figuras
		
		System.out.println ("\n Ejercicio 6: \n");
		
		Figura [] vector = new Figura [8];
		
		leer_figuras (vector);
		
		mostrar_vector (vector);
		
		
		
		// Ejer 7
		
		System.out.println ("\n Ejercicio 7: \n");
		
		System.out.println ("\n Vector 1 del ejercicio 7: \n");
		ordenar_quicksort_desc (v, 0, v.length-1);
		mostrar_vector (v);
		
		
		System.out.println ("\n Vector 2 del ejercicio 7: \n");
		ordenar_quicksort_desc (vector, 0, vector.length-1);
		mostrar_vector (vector);
		
		
		
		
		
	} // fin main

} // fin clase Prueba_figura
