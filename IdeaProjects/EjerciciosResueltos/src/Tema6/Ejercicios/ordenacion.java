package Tema6.Ejercicios;

import java.util.Arrays;

public class ordenacion {

	/* E: v -> vector de enteros        
	   S: ordena ascendentemente (de menor a mayor) el vector v por el método de la burbuja */
	public static void burbuja_asc (int v[])
	{
		int i, j;	int temp;  
		int num_ele = v.length; // número de elementos del vector		
		
		boolean ordenado = false;
		/* El bucle i controla el número de pasadas num_ele -1 pasadas  */
		for (i=1; i < num_ele && !ordenado; i++) {
		   /* El bucle j controla el número de comparaciones entre elementos del vector */
		   
		   ordenado = true; 
		   // si no hay ningún intercambio estará ordenado el vector
		   // y no hará falta realizar más pasadas para ordenarlo
		   for (j=0 ; j < num_ele - i; j++)
		      /*Comparar el elemento j con el j+1 y si están desordenados los intercambiamos*/
		       if (v[j] > v[j+1]) {
		            temp = v[j];
		            v[j] = v[j+1];
		            v[j+1] = temp;
		            // ha habido un intercambio el vector no estaba ordenado
		            ordenado = false; 
		      } /* fin if */
		}
	} /* fin burbuja_asc */	
	
	/* Ejercicio 6  */
	/* E: v -> vector de cadenas 
       S: ordena descendentemente (de mayor a menor) el vector v 
          por el método de la burbuja */ 
	public static void burbuja_desc (String v[]) {
	
		int i, j;	String temp;  
		int num_ele = v.length; // número de elementos del vector
		
		/* El bucle i controla el número de pasadas */
		for (i=1; i < num_ele; i++)
		   /* El bucle j controla el número de comparaciones entre elementos del vector */
		   for (j=0 ; j < num_ele-i; j++)
		      /*Comparar el elemento j con el j+1 y si están desordenados los intercambiamos*/
		       if (v[j].compareTo(v[j+1]) < 0) {
		            temp = v[j];
		            v[j] = v[j+1];
		            v[j+1] = temp;
		      } /* fin if */	 
		      
	} // fin burbuja_desc
	
	
	/* in: v -> vector de enteros
  	   out: ordena ascendentemente de menor a mayor
            el vector v por el metodo de shell */
	public static void shell_asc (int v[])
	{
		int d, i, ele;
		boolean ordenado;
		int num_ele = v.length; // número de elementos
		
		d = num_ele/2; // distancia de comparación		
		
		/* La ordenación se realiza mientras la distancia de comparación d sea mayor igual que 1 */ 
				
		while (d >= 1) {	
			
			ordenado = false;
			
			/* ordena el vector para la distancia d */	
			while (!ordenado) { 	// !ordenado es como poner ordenado == false
				
				ordenado = true;
				// Ejercicio 6
		// vector desordenado
		String cadenas [] = {"Robustiano", "Juan", "María", "Roberto", "Pepe Luis", "Rogelio", "Sebastian", "Zacarias"};
				for (i=0; i < num_ele-d; i++)
					// si el elemento i es mayor que i+d los intercambia
					if (v[i] > v[i+d]) {						
						ele = v[i];
						v[i] = v[i+d];
						v[i+d] = ele;
						ordenado = false;
					} /* fin if */
			} /* fin while !ordenado */ 
			
			/* calcula la nueva distancia de comparación d */
			d = d/2;
			   
		} /* fin while d */

	} /* fin shell_asc */   
	
	/* Ejercicio 8 */
	/* in: v -> vector de cadenas 
  	 out: ordena descendentemente de mayor a menor el vector v por el método de shell */ 
	public static void shell_desc (String v[]) {		
		int d, i; 
		String ele;
		boolean ordenado;
		int num_ele = v.length; // número de elementos
		
		d= num_ele; // distancia de comparación
		
		/* La ordenación se realiza mientras la distancia de comparación d sea distinta de 1, 
				ya que despues  d= d/2*/
		while (d != 1) {
			/*calcula la nueva distancia de comparación d*/
			d = d/2;
			ordenado = false;
			/* ordena el vector para la distancia d */	
			while (!ordenado) { 	// !ordenado es como poner ordenado == false
				ordenado = true;
				for (i=0; i < num_ele-d; i++)
					// si el elemento i es menor que i+d los intercambia
					if (v[i].compareTo(v[i+d]) < 0) {
						ele = v[i];
						v[i] = v[i+d];
						v[i+d] = ele;
						ordenado = false;
					} /* fin if */
			} /* fin while ordenado */    
		} /* fin while d */

	} /* fin shell_desc */  	
	
	/* E: v => vector de enteros
	   S: nada, ordena ascendentemente por quicksort el vector */	
	public static void quicksort_asc (int v[]) {
		quicksort_asc(v, 0, v.length-1);		
	}
	
	
	// Se sobrecarga el método para evitar llamarlo la primera vez
	// con quicksort_asc(v, 0, v.length-1)
	/* E: v => vector de enteros
	   S: nada, ordena ascendentemente por quicksort el vector */	
	public static void quicksort_asc (int v[], int izq, int der) {

	  int pivote=v[izq]; // tomamos primer elemento como pivote
	  int i=izq; // i realiza la búsqueda de izquierda a derecha
	  int j=der; // j realiza la búsqueda de derecha a izquierda
	  int aux;
	 
	  while(i<j){            // mientras no se crucen las búsquedas
		 while(v[i]<=pivote && i<j) 
			i++; // busca elemento mayor que pivote
		 while(v[j]>pivote) 
			j--;         // busca elemento menor igual que pivote
		 if (i<j) {                      // si no se han cruzado                      
			 aux= v[i];                  // los intercambia
			 v[i]=v[j];
			 v[j]=aux;
		 }
	   }
	   v[izq]=v[j]; // se coloca el pivote en su lugar de forma que tendremos
	   v[j]=pivote; // los menores a su izquierda y los mayores a su derecha
	   if(izq<j-1)
		  quicksort_asc(v,izq,j-1); // ordenamos subarray izquierdo
	   if(j+1 <der)
		  quicksort_asc(v,j+1,der); // ordenamos subarray derecho
	             
		  
 	}


	/* E: v => vector de enteros
	   S: nada, ordena descendentemente por quicksort el vector */	
	public static void quicksort_desc (int v[]) {
		quicksort_desc(v, 0, v.length-1);		
	}
	
	
	// Se sobrecarga el método para evitar llamarlo la primera vez
	// con quicksort_desc(v, 0, v.length-1)
	/* E: v => vector de enteros
	   S: nada, ordena descendentemente por quicksort el vector */	
	public static void quicksort_desc (int v[], int izq, int der) {

	  int pivote=v[izq]; // tomamos primer elemento como pivote
	  int i=izq; // i realiza la búsqueda de izquierda a derecha
	  int j=der; // j realiza la búsqueda de derecha a izquierda
	  int aux;
	 
	  while(i<j){            // mientras no se crucen las búsquedas
		 while(v[i]>=pivote && i<j) 
			i++; // busca elemento menor que pivote situado el i
		 while(v[j]<pivote) 
			j--;         // busca elemento mayor igual que pivote situado el j
		 if (i<j) {                      // si no se han cruzado                      
			 aux= v[i];                  // los intercambia
			 v[i]=v[j];
			 v[j]=aux;
		 }
	   }
	   v[izq]=v[j]; // se coloca el pivote en su lugar de forma que tendremos
	   v[j]=pivote; // los mayores a su izquierda y los menores a su derecha
	   if(izq<j-1)
		  quicksort_desc(v,izq,j-1); // ordenamos subarray izquierdo
	   if(j+1 <der)
		  quicksort_desc(v,j+1,der); // ordenamos subarray derecho
	}

	
	
	
	
	/* E: v => vector de enteros
	   S: muestra por pantalla el vector de enteros */
	public static void muestra (int v[], String mensaje) {
		if (v.length <= 50) {
			System.out.println("\n"  + mensaje ); 
			for (int f=0; f < v.length; f++)
				System.out.print (v[f]+" ");
		}
	} // fin muestra
	
	/* Ejercicio 6 => sobrecargar el método muestra */
	/* E: v => vector de cadenas
	   S: muestra por pantalla el vector de enteros */
	public static void muestra (String v[], String mensaje) {
		System.out.printf("\n " + mensaje); 
		for (int f=0; f < v.length; f++)
			System.out.print (v[f]+", ");
	} // fin muestra
	
	/* E: v => vector de enteros
	   S: genera un número aleatorio para cada elemento del vector de enteros */
	public static void aleatorio (int v[]) {		
		for (int f=0; f < v.length; f++)
			/* número aleatorio entre 0 y 100 */
			v[f] = (int) Math.round (Math.random()*100);	
			
			// (int) Math.random ()*10  ==> números aleatorios entre 0 y 9
						
	} // fin aleatorio
	
	/* E: v => vector de enteros
		 S: true => si está ordenado ascendentemente v		 
		    false => si no lo está */
	public static boolean ordenado_asc (int []v) {
		boolean ordenado = true;
		int i = 0;
		
		while (ordenado && i < v.length-1) {// Ejercicio 6
		// vector desordenado
		String cadenas [] = {"Robustiano", "Juan", "María", "Roberto", "Pepe Luis", "Rogelio", "Sebastian", "Zacarias"};
			if (v[i] > v[i+1])
				ordenado = false; 
			i++;
		}
		
		return ordenado;
	} // fin ordenado_asc
	
	
	/* E: v => vector de enteros
		 S: true => si está ordenado descendentemente v		 
		    false => si no lo está */
	public static boolean ordenado_desc (int []v) {
		boolean ordenado = true;
		int i = 0;
		
		while (ordenado && i < v.length-1) {
			if (v[i] < v[i+1])
				ordenado = false; 
			i++;
		}
		
		return ordenado;
	} // fin ordenado_desc
	
	
	public static void main (String args []) {
		
		int vector [] = new int [40];
		
		aleatorio (vector);		
		muestra (vector, "El vector de enteros desordenado es: ");
		
		burbuja_asc (vector);
		muestra (vector, "El vector de enteros ordenado por burbuja es: ");
		
		aleatorio (vector);		
		muestra (vector, "El vector de enteros desordenado es: ");
		
		shell_asc (vector);
		muestra (vector, "El vector de enteros ordenado  por Shell es: ");
		
		// Ejercicio 6
		// vector desordenado
		String cadenas [] = {"Robustiano", "Juan", "María", "Roberto", "Pepe Luis", "Rogelio", "Sebastian", "Zacarias"};
		
		muestra (cadenas, " El vector desordenado es: ");
		burbuja_desc (cadenas);
		muestra (cadenas, " El vector ordenado por burbuja es: ");		
		
		// Ejercicio 8
		// vector desordenado
		String cadenas2 [] = {"Robustiano", "Juan", "María", "Roberto", "Pepe Luis", "Rogelio", "Sebastian", "Zacarias"};
		
		muestra (cadenas2, " El vector desordenado es: ");
		shell_desc (cadenas2);
		muestra (cadenas2, " El vector ordenado por shell de mayor a menor es: ");
				
		
		
	} // fin main

} // fin clase ordenacion
