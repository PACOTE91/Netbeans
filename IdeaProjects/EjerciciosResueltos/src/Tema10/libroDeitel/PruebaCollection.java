package Tema10.libroDeitel;// Fig. 19.3: PruebaCollection.java
// Uso de la interfaz Collection.
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class PruebaCollection 
{
   // atributos que son constantes de tipo vector
   private static final String[] colores = { "MAGENTA", "ROJO", "BLANCO", "AZUL", "CYAN" };
   private static final String[] eliminarColores = { "ROJO", "BLANCO", "AZUL" };

   // crea objeto ArrayList, le agrega los colores y lo manipula
   public PruebaCollection()
   {
      // Crea las listas de String
      List <String> lista = new ArrayList<>();
      List <String> eliminarLista = new ArrayList<>();
      // Crea la lista de Integer
      List<Integer> enteros = new ArrayList<>();
      List<Integer> enteros2 = new ArrayList<>();
		
      // agrega los elementos del arreglo colores a la lista
      for ( String color : colores )
         lista.add( color );

      // agrega los elementos de eliminarColores a eliminarLista
      for ( String color : eliminarColores )
         eliminarLista.add( color ); 
      
      // agregar varios Integer a lista de enteros
      enteros.add (25);
      enteros.add (57);
      enteros.add (-4);  
      
      enteros2.add (-29);
      enteros2.add (51);
      enteros2.add (-4);  

      System.out.println( "ArrayList: " );

      // imprime en pantalla el contenido de la lista
      for (String s : lista) System.out.printf("%s ", s);

      // elimina los colores contenidos en eliminarLista
      eliminarColores( lista, eliminarLista );

      System.out.println( "\n\nArrayList despues de llamar a eliminarColores: " );

      // imprime en pantalla el contenido de la lista
      for ( String color : lista )
         System.out.printf( "%s ", color );
         
      // imprimir las dos listas de enteros
      System.out.println ("\n\nLas listas de enteros son: ");   
      for (Integer entero : enteros)
      	System.out.print (entero.toString() + " ");
      System.out.println();
      for (Integer entero : enteros2)
      	System.out.print (entero.toString() + " ");
      
      // elimina los enteros contenidos en enteros2
      eliminarEnteros (enteros, enteros2);
      System.out.println ("\n\nLos enteros una vez eliminados los contenidos en la lista enteros2: ");   
      for (Integer entero : enteros)
      	System.out.print (entero.toString() + " ");

      System.out.println();
      
   } // fin del constructor de PruebaCollection

   // elimina de coleccion1 los colores especificados en coleccion2
   private void eliminarColores (Collection <String> coleccion1, Collection <String> coleccion2)
   {
      // obtiene el iterador que permite recorrer la coleccion1
      Iterator <String> iterador = coleccion1.iterator(); 

      // itera mientras la colección tenga elementos
      while ( iterador.hasNext() )
      	 // comprueba si el elemento actual de coleccion1 coincide con alguno de la coleccion2
         if ( coleccion2.contains (iterador.next()) )
         		// elimina el color actual de coleccion2
            iterador.remove(); 
            
   } // fin del método eliminarColores
   
   // elimina de coleccion1 los Integer especificados en coleccion2
   private void eliminarEnteros (Collection <Integer> coleccion1, Collection <Integer> coleccion2)
   {
      // obtiene el iterador que permite recorrer la coleccion1
      Iterator <Integer> iterador = coleccion1.iterator();

      // itera mientras la colección tenga elementos
      while ( iterador.hasNext() )
      	 // comprueba si el elemento actual de coleccion1 coincide con alguno de la coleccion2
         if ( coleccion2.contains (iterador.next()) )
         		// elimina el color actual de coleccion2
            iterador.remove();
            
   } // fin del método eliminarEnteros   
   

   public static void main( String args[] )
   {
      new PruebaCollection();
   } // fin de main
} // fin de la clase PruebaCollection


