package Tema10.libroDeitel;// Fig. 19.8: Ordenamiento1.java
// Uso del algoritmo sort.
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class Ordenamiento1 
{
	// atributo de clase constante => vector con los palos de la baraja
	private static final String palos[] = { "Corazones", "Diamantes", "Bastos", "Espadas" };

	// muestra los elementos del arreglo
	public void imprimirElementos()
	{
		// crea objeto List a partir del vector palos con el método aslist() de la clase Arrays
		List <String> lista = Arrays.asList( palos ); 

		// imprime lista desordenada
		System.out.printf( "Elementos del arreglo desordenados:\n%s\n", lista );

		// ordena ArrayList      
		Collections.sort( lista ); 

		// imprime lista ordenada
		System.out.printf( "Elementos del arreglo ordenados:\n%s\n", lista );
	} // fin del método imprimirElementos

	public static void main( String args[] )
	{
		Ordenamiento1 orden1 = new Ordenamiento1();
		orden1.imprimirElementos();
	} // fin de main
} // fin de la clase Ordenamiento1


