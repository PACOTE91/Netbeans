package Tema6.Ejercicios;


public class Grupo_Rock {
	// Atributos de instancia
	String nombre;
	Fecha fecha_creacion; // objeto de otra clase => composición
	byte num_integrantes; // Número de integrantes del grupo.
	String[] integrantes; // Vector de cadenas con los integrantes del grupo.
	
	// constructor
	public Grupo_Rock (String nomb, Fecha fecha1, byte num) {
		nombre = nomb;
		fecha_creacion = fecha1; // fecha_creación apunta al mismo objeto que fecha1
		num_integrantes = num;
		// se hace reserva de memoria para el vector de integrantes
		integrantes = new String [num_integrantes];	
		
		// Pedir por teclado cada integrante del grupo
		for (int i=0; i<integrantes.length;i++)
			integrantes[i] = teclado.leer_cadena ("Introduce el integrante del grupo nº " + i + ": ");
	} // fin constructor
	
	// constructor del ejercicio 2 => sobrecargar el constructor
	public Grupo_Rock (String nomb, Fecha fecha1, byte num, String[] cadenas) {
		nombre = nomb;
		fecha_creacion = fecha1; // fecha_creación apunta al mismo objeto que fecha1
		num_integrantes = num;
		integrantes = cadenas; // integrantes apunta a cadenas, una cadena de caracteres		
	} // fin constructor del ejercicio 2	
	
	// muestra por pantalla todos los atributos del objeto actual
	public void mostrar () {
		System.out.println ("\nNombre: " + nombre);
		System.out.println ("Fecha de creación: " + fecha_creacion);
		System.out.println ("Total integrantes: " + num_integrantes);
		System.out.println ("Integrantes de la banda: ");
		// uso del for mejorado
		for ( String rockero : integrantes )
			System.out.println (rockero);		
	} // fin mostrar
	
	// Ejercicio 3
	/* E: grupos => vector de objetos de la clase Grupo_Rock
      banda => objeto de la clase Grupo_Rock
		 S: La posición dentro del vector => si encuentra la banda dentro del vector
        -1 => si no lo encuentra */
	public static int busqueda_secuencial (Grupo_Rock[] vector, Grupo_Rock banda) {
		boolean encontrado = false;
		int pos = -1; // posición donde encuentra el grupo de rock
		
		for (int i=0; i < vector.length && !encontrado; i++) 
			// comprobar si el nombre de la banda es igual al nombre del grupo actual (i) del vector
			if (banda.nombre.equals (vector[i].nombre)) {
				encontrado = true;
				pos = i;
			}		
		
		return pos;
	
	} // fin busqueda_secuencial
	
	// Ejercicio 7
	// ordena el atributo integrantes del objeto actual de forma descendente
	public void ordena_integrantes () {
		ordenacion.burbuja_desc (integrantes);
	} // fin ordena_integrantes
	
	public static void main (String[] args) {
		// Ejercicio 1
		Fecha fecha_banda = new Fecha (12,31,1965);
		Grupo_Rock banda = new Grupo_Rock ("Queen", fecha_banda, (byte)3);
		banda.mostrar();		
		
		// Ejercicio 2
		Fecha fecha_banda2 = new Fecha (7,25,1978);
		String[] rockeros = {"Mark Nopfler", "Batería", "Guitarra"};
		Grupo_Rock banda2 = new Grupo_Rock ("Dire Straits", fecha_banda2, (byte)3, rockeros);
		banda2.mostrar();		
		
		// Ejercicio 3
		
		/* crear otra banda de rock para el vector de objetos */
		Fecha fecha_banda3 = new Fecha (8,24,1979);
		String[] rockeros3 = {"Jim Morrison", "Anthony Nopfler", "Zacarias Smith"};
		Grupo_Rock banda3 = new Grupo_Rock ("Otra Banda", fecha_banda3, (byte)3, rockeros3);
		banda3.mostrar();		
		
		// reservar memoria para el vector de grupos de rock
		Grupo_Rock[] grupos = new Grupo_Rock [3];
		// asignar los elementos del vector (aprovechar los 3 objetos que hay creados)
		grupos [0] = banda;
		grupos [1] = banda2;
		grupos [2] = banda3;
		
		int posicion = busqueda_secuencial (grupos, banda3);
		
		if (posicion == -1)
			System.out.println ("Banda de rock no encontrada en el vector");
		else
			System.out.println ("Banda de rock encontrada en el vector en la posición: " + (posicion+1) ) ;
		
		// Ejercicio 7
		banda3.ordena_integrantes();
		System.out.println ("Integrantes ordenados de mayor a menor: ");
		banda3.mostrar();		
		
	} // fin main

} // fin clase Grupo_Rock
