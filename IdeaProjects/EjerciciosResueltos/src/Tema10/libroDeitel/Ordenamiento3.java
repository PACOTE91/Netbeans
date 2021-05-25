package Tema10.libroDeitel;// Fig. 19.11: Ordenamiento3.java
// Ordena una lista usando la clase Comparator personalizada ComparadorTiempo.
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Ordenamiento3 
{
	public void imprimirElementos()
	{
		// crea objeto ArrayList de tipo Tiempo2
		List <Tiempo2> lista = new ArrayList< Tiempo2 >(); 

		lista.add ( new Tiempo2(  6, 24, 34 ) );
		lista.add ( new Tiempo2( 18, 14, 58 ) );
		lista.add ( new Tiempo2(  6, 05, 34 ) );
		lista.add ( new Tiempo2( 12, 14, 58 ) );
		lista.add ( new Tiempo2(  6, 24, 22 ) );
		lista.add ( new Tiempo2( 23, 55, 50 ) );
		lista.add ( new Tiempo2(  0, 12, 43 ) );

		// imprime los elementos del objeto List
		System.out.printf( "Elementos del arreglo desordenados:\n%s\n", lista );

		// ordena ascendentemente usando un comparador
		Collections.sort( lista, new ComparadorTiempo() ); 

		// imprime los elementos del objeto List
		System.out.printf( "Elementos de la lista ordenados ascendentemente:\n%s\n", lista );

		// ordena descendentemente usando un comparador
		Collections.sort( lista, new ComparadorTiempo2() ); 

		// imprime los elementos del objeto List
		System.out.printf( "Elementos de la lista ordenados descendentemente:\n%s\n", lista );
		
		/**********/
		// ordena ascendentemente usando un comparador
		Collections.sort( lista, new ComparadorTiempo3() ); 

		// imprime los elementos del objeto List
		System.out.printf( "Elementos de la lista ordenados ascendentemente:\n%s\n", lista );

		// ordena descendentemente usando un comparador
		Collections.sort( lista, new ComparadorTiempo4() ); 

		// imprime los elementos del objeto List
		System.out.printf( "Elementos de la lista ordenados descendentemente:\n%s\n", lista );
	  
	  
	} // fin del método imprimirElementos

	public static void main( String args[] )
	{
		Ordenamiento3 ordenamiento3 = new Ordenamiento3();
		ordenamiento3.imprimirElementos();
	} // fin de main
} // fin de la clase Ordenamiento3



