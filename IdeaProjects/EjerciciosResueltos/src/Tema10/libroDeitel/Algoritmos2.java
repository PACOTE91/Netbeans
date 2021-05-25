package Tema10.libroDeitel;// Fig. 19.15: Algoritmos2.java
// Uso de los algoritmos addAll, frequency y disjoint.
import java.util.List;
import java.util.Vector;
import java.util.Arrays;
import java.util.Collections;

public class Algoritmos2 
{
   private String[] colores = { "rojo", "blanco", "amarillo", "azul" };
   private List <String> lista;
   private Vector <String> vector = new Vector <String>();
   
   // Constructor => crea objetos List y Vector y los manipula con métodos de Collections
   public Algoritmos2()
   {
      // crea la lista con la matriz colores
      lista = Arrays.asList (colores); 
      // añade 3 elementos al vector
      vector.add( "negro" );
      vector.add( "rojo" );
      vector.add( "verde" );

      System.out.println( "Antes de addAll, el vector contiene:" );

      // muesta los elementos en el vector
      for ( String s : vector )
         System.out.printf ("%s ", s);

      // agrega los elementos de la matriz colores al vector (de la clase Vector)
      Collections.addAll (vector, colores);

      System.out.println( "\n\nDespues de addAll, el vector contiene: " );

      // muestra los elementos en el vector
      for ( String s : vector )
         System.out.printf( "%s ", s );

      // obtiene la frecuencia de "rojo" en el vector
      int frecuencia = Collections.frequency (vector, "rojo");
      System.out.printf("\n\nFrecuencia de rojo en el vector: %d\n", frecuencia );

      // comprueba si lista y vector tienen elementos en común
      boolean desunion = Collections.disjoint (lista, vector);
      
      if (desunion)
      	System.out.printf( "\nlista y vector no tienen elementos en comun\n");
      else 
      	System.out.printf( "\nlista y vector tienen elementos en comun\n");
        
   } // fin del constructor de Algoritmos2

   public static void main( String args[] ) 
   {
      new Algoritmos2();
   } // fin de main
   
} // fin de la clase Algoritmos2


