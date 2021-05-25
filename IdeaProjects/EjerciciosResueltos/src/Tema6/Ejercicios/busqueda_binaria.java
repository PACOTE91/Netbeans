package Tema6.Ejercicios;

public class busqueda_binaria {
	/* E: v -> vector de reales ordenado de forma ascendente, de menor a mayor
				ele -> real a buscar en v	
		 S: -1 -> si no encuentra ele en v
        la posición de ele -> si se encuentra ele en v */
	public static int b_binaria_asc (float v[], float ele)
	{
		// colocar la izquierda al principio y la derecha al final
		int izquierda=0, derecha=v.length-1, posicion, mitad;

		// calcular la mitad
		mitad = (izquierda + derecha) / 2;

		/* realizar la búsqueda mientras no encontremos el elemento y el rango de busqueda sea correcto*/
		while (v[mitad] != ele  && izquierda <= derecha) {
			if (ele > v[mitad])
				/* buscar en la parte derecha */
				izquierda = mitad +1;
			else
				/* buscar en la parte izquierda */
				derecha = mitad -1;
				
			// calcular de nuevo la mitad
	    mitad = (izquierda + derecha) / 2;
		} /* fin while */

		if (v[mitad] == ele)
			// se ha encontrado el elemento
			posicion = mitad;
		else
			// no se ha encontrado
			posicion = -1;

		return posicion;
	} /* fin b_binaria_asc */
	
	
	/* E: v -> vector de cadenas ordenado de forma ascendente, de menor a mayor
				ele -> cadena a buscar en v	
		 S: -1 -> si no encuentra ele en v
        la posición de ele -> si se encuentra ele en v */
	public static int b_binaria_asc (String v[], String ele)
	{
		// colocar la izquierda al principio y la derecha al final
		int izquierda=0, derecha=v.length-1, posicion, mitad;

		// calcular la mitad
		mitad = (izquierda + derecha) / 2;

		/* realizar la búsqueda mientras no encontremos el elemento y el rango de busqueda sea correcto*/
		while (v[mitad].equals(ele) == false  && izquierda <= derecha) {
			// comprueba si la cadena ele es mayor que la cadena v[mitad]
			if (ele.compareTo (v[mitad]) > 0)
				/* buscar en la parte derecha */
				izquierda = mitad +1;
			else
				/* buscar en la parte izquierda */
				derecha = mitad -1;
				
			// calcular de nuevo la mitad
	    mitad = (izquierda + derecha) / 2;
		} /* fin while */

		if ( v[mitad].equals(ele) )
			// se ha encontrado el elemento
			posicion = mitad;
		else
			// no se ha encontrado
			posicion = -1;

		return posicion;
	} /* fin b_binaria_asc */
	
	/* Ejercicio 4 */
	/* E: v -> vector de cadenas ordenado de forma descendente
        ele -> cadena a buscar en v 
   	 S: -1 -> si no encuentra ele en v 
        la posición de ele -> si se encuentra ele en v */ 
	public static int b_binaria_desc (String v[], String ele)
	{
		// colocar la izquierda al principio y la derecha al final
		int izquierda=0, derecha=v.length-1, posicion, mitad;

		// calcular la mitad
		mitad = (izquierda + derecha) / 2;

		/* realizar la búsqueda mientras no encontremos el elemento y el rango de busqueda sea correcto*/
		while (v[mitad].equals(ele) == false  && izquierda <= derecha) {
			// comprueba si la cadena ele es menor que la cadena v[mitad]
			if (ele.compareTo (v[mitad]) < 0)
				/* buscar en la parte derecha */
				izquierda = mitad +1;
			else
				/* buscar en la parte izquierda */
				derecha = mitad -1;
				
			// calcular de nuevo la mitad
	    mitad = (izquierda + derecha) / 2;
		} /* fin while */

		if ( v[mitad].equals(ele) )
			// se ha encontrado el elemento
			posicion = mitad;
		else
			// no se ha encontrado
			posicion = -1;

		return posicion;
	} /* fin b_binaria_desc */
	
	/* Ejercicio 5 */
	/* E: v -> vector de reales de doble precisión ordenado de forma descendente
        ele -> elemento a buscar en v 
   	 S: -1 -> si no encuentra ele en v 
        la posición de ele -> si se encuentra ele en v */ 
	public static int b_binaria_desc (double v[], double ele)
	{
		// colocar la izquierda al principio y la derecha al final
		int izquierda=0, derecha=v.length-1, posicion, mitad;

		// calcular la mitad
		mitad = (izquierda + derecha) / 2;

		/* realizar la búsqueda mientras no encontremos el elemento y el rango de busqueda sea correcto*/
		while (v[mitad] != ele && izquierda <= derecha) {
			// comprueba si el elemento es menor que v[mitad]
			if (ele < v[mitad])
				/* buscar en la parte derecha */
				izquierda = mitad +1;
			else
				/* buscar en la parte izquierda */
				derecha = mitad -1;
				
			// calcular de nuevo la mitad
	    mitad = (izquierda + derecha) / 2;
		} /* fin while */

		if ( v[mitad] == ele )
			// se ha encontrado el elemento
			posicion = mitad;
		else
			// no se ha encontrado
			posicion = -1;

		return posicion;
	} /* fin b_binaria_desc */

	public static void main (String args[]) {
		// estos vectores han de estar ordenados ascendentemente
		float reales [] = {-111.05f, -34, 55.5f, 200.1f, 248, 545.45f, 545.67f, 545.69f, 800};
		String cadenas [] = {"Antonio", "Juan", "María", "Pepe Luis", "Rogelio", "Sebastian", "Zacarias"};
		
		// ejercicio 4 => este vector ha de estar ordenado descendentemente
		String cadenas2 [] = {"Zacarias", "Sebastian", "Rogelio", "Pepe Luis", "María", "Juan", "Antonio"};
		
		// ejercicio 5 => este vector ha de estar ordenado descendentemente
		double reales2[] = {500.55, 180.78, 110.74, 100, 75, 70, 50, 40, 38, 37, 20, 10, 7, 5, 2, -8, -9};
		
		// probar con uno que no está
		int posicion = b_binaria_asc (reales, 48f);
		if (posicion == -1)
			System.out.println ("Real no encontrado en el vector");
		else
			System.out.println (reales[posicion] + " encontrado en la posición " + (posicion+1) );		
		
		// probar con uno que está en la parte derecha
		posicion = b_binaria_asc (reales, 545.67f);
		if (posicion == -1)
			System.out.println ("Real no encontrado en el vector");
		else
			System.out.println (reales[posicion] + " encontrado en la posición " + (posicion+1) );
			
		// probar con uno que está en la parte izquierda
		posicion = b_binaria_asc (reales,-34f);
		if (posicion == -1)
			System.out.println ("Real no encontrado en el vector");
		else
			System.out.println (reales[posicion] + " encontrado en la posición " + (posicion+1) );
		
				
		// búsqueda binaria en cadenas			
		posicion = b_binaria_asc (cadenas, "Alejandro");
		if (posicion == -1)
			System.out.println ("Cadena no encontrada en el vector");
		else
			System.out.println (cadenas[posicion] + " encontrado en la posición " + (posicion+1) );		
		
		posicion = b_binaria_asc (cadenas, "Sebastian");
		if (posicion == -1)
			System.out.println ("Cadena no encontrada en el vector");
		else
			System.out.println (cadenas[posicion] + " encontrada en la posición " + (posicion+1) );	
			
		posicion = b_binaria_asc (cadenas, "Antonio");
		if (posicion == -1)
			System.out.println ("Cadena no encontrada en el vector");
		else
			System.out.println (cadenas[posicion] + " encontrada en la posición " + (posicion+1) );				
		
		// búsqueda binaria en cadenas del ejercicio 4			
		posicion = b_binaria_desc (cadenas2, "Alejandro");
		if (posicion == -1)
			System.out.println ("Cadena no encontrada en el vector");
		else
			System.out.println (cadenas2[posicion] + " encontrado en la posición " + (posicion+1) );		
		
		posicion = b_binaria_desc (cadenas2, "Sebastian");
		if (posicion == -1)
			System.out.println ("Cadena no encontrada en el vector");
		else
			System.out.println (cadenas2[posicion] + " encontrada en la posición " + (posicion+1) );	
			
		posicion = b_binaria_desc (cadenas2, "Antonio");
		if (posicion == -1)
			System.out.println ("Cadena no encontrada en el vector");
		else
			System.out.println (cadenas2[posicion] + " encontrada en la posición " + (posicion+1) );
		
		// Ejercicio 5 => probar con uno que no está
		posicion = b_binaria_desc (reales2, 48);
		if (posicion == -1)
			System.out.println ("Real no encontrado en el vector");
		else
			System.out.println (reales2[posicion] + " encontrado en la posición " + (posicion+1) );		
		
		// probar con uno que está en la parte derecha
		posicion = b_binaria_desc (reales2, 10);
		if (posicion == -1)
			System.out.println ("Real no encontrado en el vector");
		else
			System.out.println (reales2[posicion] + " encontrado en la posición " + (posicion+1) );
			
		// probar con uno que está en la parte izquierda
		posicion = b_binaria_desc (reales2,180.78);
		if (posicion == -1)
			System.out.println ("Real no encontrado en el vector");
		else
			System.out.println (reales2[posicion] + " encontrado en la posición " + (posicion+1) );
	} // fin main

} // fin clase busqueda_binaria
