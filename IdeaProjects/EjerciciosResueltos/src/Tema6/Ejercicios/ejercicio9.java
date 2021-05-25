package Tema6.Ejercicios;/* Guarda los datos de 5 alumnos, compuestos por el número de matricula, nombre y nota en una asignatura. Para almacenar la información tendremos 3 vectores (matricula, nombre y nota). Sacar 3 listados consecutivos y ordenados, el primero ascendentemente por el número de matricula, el 2º por el nombre ascendentemente y el 3º descendentemente por la nota. Se deberán realizar 3 métodos para sacar los listados (3 métodos de ordenación). */

public class ejercicio9 {
	
	/* E: mat => vector de matriculas
	      nom => vector de nombres
	      nota => vector de notas
	      i => posición del vector
	      j => posición del vector	      
	   S: nada, intercambia la posición i y j de todos los vectores
	   requisito: los 3 vectores deben tener el mismo número de elementos */
	public static void intercambiar (int mat[], String nom[], float nota[], int i, int j) {
		int aux_mat;
		String aux_nom;
		float aux_nota;
		
		aux_mat = mat[i]; aux_nom = nom[i]; aux_nota = nota[i];
		mat[i] = mat[j];  nom[i] = nom[j];  nota[i] = nota [j];
		mat[j] = aux_mat; nom[j] = aux_nom; nota[j] = aux_nota;		
	} // fin intercambiar	
	
	
	// ORDENACION CON EL MÉTODO DE SHELL DE 3 VECTORES DE FORMA SIMULTÁNEA
	
	/* E: mat => vector de matriculas
	      nom => vector de nombres
	      nota => vector de notas	
	      tipo => 1, 2 o 3           
	   S: nada, 
	   si tipo = 1 => ordena los 3 vectores simultáneamente por el número de matricula ascendentemente
	   si tipo = 2 => ordena los 3 vectores simultáneamente por el nombre ascendentemente
	   si tipo = 3 => ordena los 3 vectores simultáneamente por la nota descendentemente
	   ten en cuenta que la posición de cada vector están relacionadas entre si
	   por ejemplo, la posición 3 corresponde a la información del alumno 3: nombre, matricula y nota
	   requisito: los 3 vectores deben tener el mismo número de elementos */
	public static void shell (int mat[], String nom[], float nota[], int tipo) {
		int d, i;
		boolean ordenado, intercambio;
		int num_ele = mat.length; // número de elementos
		
		d = num_ele; // distancia de comparación
		
		/* La ordenación se realiza mientras la distancia de comparación d sea distinta de 1, 
				ya que despues  d= d/2*/
		while (d != 1) {
			/*calcula la nueva distancia de comparación d*/
			d = d/2;
			ordenado = false;
			/* ordena el vector para la distancia d */	
			while (!ordenado) { 	// !ordenado es como poner ordenado == false
				ordenado = true;
				for (i=0; i < num_ele-d; i++) {
					// si el elemento i es mayor que i+d los intercambia en los 3 vectores
					intercambio = false;
					switch (tipo) {
						case 1: // ordenar por matrícula ascendentemente		
							if (mat[i] > mat[i+d])
								intercambio = true;
							break;
						case 2: // ordenar por el nombre ascendentemente		
							if (nom[i].compareTo(nom[i+d]) > 0)
								intercambio = true;
							break;
						case 3: // ordenar por la nota descendentemente		
							if (nota[i] < nota[i+d])
								intercambio = true;							
					} // fin switch
					
					// comprobar si hay que realizar el intercambio, es como poner intercambio == true
					if (intercambio) { 
						intercambiar (mat, nom, nota, i, i+d);
						ordenado = false;
					}
				} // fin for
					
			} /* fin while ordenado */    
		} /* fin while d */

	} /* fin shell */

	/* E: mat => vector de matriculas
	      nom => vector de nombres
	      nota => vector de notas
	      mensaje => mensaje a mostrar
	   S: nada, muestra por pantalla los 3 vectores 
	   requisito: los 3 vectores deben tener el mismo número de elementos */
	public static void mostrar (int mat[], String nom[], float nota[], String mensaje) {
		System.out.println ("\nListado de los alumnos " + mensaje + "\n");
		for (int i=0; i<mat.length; i++)
			System.out.println ("Nombre: "+ nom[i] + ", Matrícula: " + mat[i] + ", Nota:" + nota[i]);		
	} // fin mostrar
	
	
	// NO TE LO PIDE EL EJERCICIO PERO TAMBIÉN SE PODÍA HABER ORDENADO CON QUICKSORT
	/* E: mat => vector de matriculas 
		nom => vector de nombres 
		nota => vector de notas
		izq => posición del indice izquierda dentro del vector
		der => posición del indice derecha dentro del vector	 
		tipo => 1, 2 o 3           
	   S: nada, 
		si tipo = 1 => ordena los 3 vectores simultáneamente por la matricula ascendentemente 
		si tipo = 2 => ordena los 3 vectores simultáneamente por el nombre ascendentemente 
		si tipo = 3 => ordena los 3 vectores simultáneamente por la nota descendentemente 
		requisito: los 3 vectores deben tener el mismo número de elementos */ 
	public static void quicksort (int mat[], String nom[], float nota[], int izq, int der, int tipo) {
		int pivote;
		if(izq < der){
			pivote = pivote(mat, nom, nota, izq, der, tipo);
			// ordenar la parte izquierda del vector a partir de pivote
			quicksort (mat, nom, nota, izq, pivote-1, tipo);
			// ordenar la parte derecha del vector a partir de pivote
			quicksort (mat, nom, nota, pivote+1, der, tipo);
		}  
		
	} // fin quicksort
	
	
	// NO TE LO PIDE EL EJERCICIO PERO TAMBIÉN SE PODÍA HABER ORDENADO CON QUICKSORT
	/* E: mat => vector de matriculas 
		nom => vector de nombres 
		nota => vector de notas
		izq => posición del indice izquierda dentro del vector
		der => posición del indice derecha dentro del vector
		tipo => 1, 2 o 3           
	   S: posición del pivote o elemento del vector que queda ordenado ascendentemente de 
		tal forma que los elementos desde v[pivote-1] hasta v[izq] son menores o iguales
		que v[pivote], además los elementos desde v[pivote+1] hasta v[der] son mayores 
		que v[pivote] (si la ordenación es ascendente sino es al contrario)
		si tipo = 1 => ordena los 3 vectores simultáneamente por la matricula ascendentemente respecto a pivote
		si tipo = 2 => ordena los 3 vectores simultáneamente por el nombre ascendentemente respecto a pivote
		si tipo = 3 => ordena los 3 vectores simultáneamente por la nota descendentemente respecto a pivote
		requisito: los 3 vectores deben tener el mismo número de elementos */ 	     
	public static int pivote (int mat[], String nom[], float nota[], int izq, int der, int tipo) {			
		
		int pos; // posición del vector a intercambiar con el pivote
		/* eleccion del pivote, por ejemplo el elemento más a la izquierda */
		int	pivote = izq;		
		
		// comprobar el caso particular de que derecha es uno más que izquierda
		if (izq+1 == der) {			
				// Caso 1) hay que ordenar un vector de dos elementos
				if ( (tipo == 1 && mat[izq] > mat[der]) || 
				       (tipo == 2 && nom[izq].compareTo(nom[der]) > 0) || 
				       (tipo == 3 && nota[izq] < nota[der]) )
					pos = der;
				else
					pos = izq;				
		}
		else {			
			// Caso 2) el vector a ordenar tiene 3 o más elementos
			izq ++;				
			
			while (izq < der) {
				
				// comprobar si izq y der están bien posicionados con respecto a pivote				
				if ( (tipo == 1 && mat[izq] > mat[pivote] && mat[der] <= mat[pivote]) ||
				     (tipo == 2 && nom[izq].compareTo (nom[pivote]) > 0 && nom[der].compareTo(nom[pivote]) <= 0) ||
				     (tipo == 3 && nota[izq] <= nota[pivote] && nota[der] > nota[pivote]) ) {					
					// no están bien ordenados => se intercambian v[izq] con v[der]
					intercambiar (mat, nom, nota, izq, der);						
					izq ++;
					der --;					
				}				
				else {
					// comprobar si hay que avanzar o no los indices izquierda o derecha
					// en caso de que estén bien colocados respecto al pivote
					if ( (tipo == 1 && mat[izq] <= mat[pivote]) ||
					     (tipo == 2 && nom[izq].compareTo(nom[pivote]) <= 0) ||
					     (tipo == 3 && nota[izq] > nota[pivote]) )
						izq ++;
						
					if ( (tipo == 1 && mat[der] > mat[pivote]) ||
					      (tipo == 2 && nom[der].compareTo(nom[pivote]) > 0) ||
					      (tipo == 3 && nota[der] <= nota[pivote]) )
						der --;					
				}	// fin else	
				
			} // fin while			
		
			// ====== Calcular donde hay que colocar el pivote ===========
			if (izq == der) {
				if ( (tipo == 1 && mat[pivote] > mat[izq]) ||
				     (tipo == 2 && nom[pivote].compareTo(nom[izq]) > 0) ||
				     (tipo == 3 && nota[pivote] <= nota[izq]) )
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
			intercambiar (mat, nom, nota, pos, pivote);								
		} 
		
		// la posición del pivote está en pos
		return pos;
	
	} // fin pivote
	
	
	
	

	public static void main (String args[]) {
		int matricula [] = {1234, 56778, 567, 4555, 3423};
		String nombre [] = {"Pedro", "María", "Esteban", "Zacarias", "Fernando"};
		float nota [] = {5.5f, 4, 8.8f, 4.5f, 7.7f};		
		
		// ORDENAR POR SHELL
		// ordenar por matrícula
		mostrar (matricula, nombre, nota, "sin ordenar");
		shell (matricula, nombre, nota, 1);
		mostrar (matricula, nombre, nota, "ordenado por la matrícula ascendentemente");
		
		// ordenar por nombre
		shell (matricula, nombre, nota, 2);
		mostrar (matricula, nombre, nota, "ordenado por el nombre ascendentemente");
		
		// ordenar por nota
		shell (matricula, nombre, nota, 3);
		mostrar (matricula, nombre, nota, "ordenado por la nota descendentemente");		
		
		
		// ORDENAR POR QUICKSORT NO TE LO PIDE EL EJERCICIO
		
		/*
		// ordenar por matrícula
		mostrar (matricula, nombre, nota, "sin ordenar");
		quicksort (matricula, nombre, nota, 0, matricula.length-1, 1);
		mostrar (matricula, nombre, nota, "ordenado por la matrícula ascendentemente");
		
		// ordenar por nombre
		quicksort (matricula, nombre, nota, 0, matricula.length-1, 2);
		mostrar (matricula, nombre, nota, "ordenado por el nombre ascendentemente");
		
		// ordenar por nota
		quicksort (matricula, nombre, nota, 0, matricula.length-1, 3);
		mostrar (matricula, nombre, nota, "ordenado por la nota descendentemente");	*/
		
	
	} // fin main

} // fin clase ejercicio 9
