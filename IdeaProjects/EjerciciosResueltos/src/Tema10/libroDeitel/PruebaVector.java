package Tema10.libroDeitel;// Fig. 19.6: PruebaVector.java
// Uso de la clase Vector.
import java.util.Vector;
import java.util.NoSuchElementException;

public class PruebaVector 
{
   private static final String colores[] = { "rojo", "blanco", "azul" };

   public PruebaVector()
   {
      // Declara un vector de la clase Vector
      Vector <String> vector = new Vector< String >();      
      
      imprimirVector (vector); // imprime el vector

      // agrega elementos al vector => método add
      for ( String color : colores )
         vector.add (color);   

      imprimirVector( vector ); // imprime el vector
      
      // imprime los elementos primero firstElement() y último lastElement()
      try 
      {
         System.out.printf( "Primer elemento: %s\n", vector.firstElement());
         System.out.printf( "Último elemento: %s\n", vector.lastElement() );
      } // fin de try
      // atrapa la excepción si el vector está vacío
      catch ( NoSuchElementException excepcion ) 
      {
         excepcion.printStackTrace();
      } // fin de catch
      
      // ¿el vector contiene "rojo"? => método contains()
      if ( vector.contains( "rojo" ) )
         System.out.printf( "\nse encontró \"rojo\" en el indice %d\n\n", vector.indexOf( "rojo" ) );
      else
         System.out.println( "\nno se encontró \"rojo\"\n" );
      
      // elimina la cadena "rojo" => remove ()
      vector.remove( "rojo" ); 
      System.out.println( "se eliminó \"rojo\"" );
      imprimirVector( vector ); // imprime el vector
      
      // ¿el vector contiene "rojo" después de la operación de eliminación?
      if ( vector.contains( "rojo" ) )
         System.out.printf("se encontró \"rojo\" en el índice %d\n", vector.indexOf( "rojo" ) );
      else
         System.out.println( "no se encontró \"rojo\"" );
      
      // imprime el tamaño y la capacidad del vector
      System.out.printf( "\nTamanio: %d\nCapacidad: %d\n", vector.size(), vector.capacity() );
      
   } // fin del constructor de PruebaVector
   
   private void imprimirVector( Vector <String> vectorAImprimir )
   {
      // comprueba si el vector está vacio => isEmpty()
      if ( vectorAImprimir.isEmpty() ) 
         System.out.print( "el vector está vacío" ); // vectorAImprimir está vacío
      else  // itera a través de los elementos
      { 
         System.out.print( "el vector contiene: " );      

         // imprime los elementos
         for ( String elemento : vectorAImprimir )
            System.out.printf( "%s ", elemento );
      } // fin de else
      
      System.out.println( "\n" ); 
   } // fin del método imprimirVector

   public static void main( String args[] )
   {
      new PruebaVector(); // crea objeto y llama a su constructor
   } // fin de main
   
} // fin de la clase PruebaVector


