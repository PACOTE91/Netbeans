package Tema10.libroDeitel;// Fig. 19.5: UsoToArray.java
// Uso del método toArray.
import java.util.LinkedList;
import java.util.Arrays;

public class UsoToArray 
{
   // el constructor crea un objeto LinkedList, le agrega elementos y lo convierte en arreglo
   public UsoToArray()
   {
      String[] colores = { "negro", "azul", "amarillo", "blanco", "naranja" };
      String[] colores2 = null;

      // crea una lista enlazada a partir del vector colores en una sola instrucción
      LinkedList <String> enlaces = new LinkedList <String> (Arrays.asList (colores) );

      enlaces.addLast( "rojo" );   // lo agrega como último elemento
      enlaces.add( "rosa" );      // lo agrega al final
      enlaces.add( 3, "verde" );  // lo agrega en el 3er índice, es decir el cuarto
      enlaces.addFirst( "cyan" ); // lo agrega como primer elemento 

      // obtiene los elementos de LinkedList como un arreglo o vector 
      colores2 = enlaces.toArray (new String [enlaces.size()]);      

      // mostrar los elementos del vector colores
      System.out.println ("Elementos del vector colores: ");
      for ( String color : colores )
         System.out.println( color );
         
      // mostrar los elementos del vector colores
      System.out.println ("\nElementos del vector colores2: ");
      for ( String color : colores2 )
         System.out.println( color );       
      
      // mostrar los elementos de la lista enlazada enlaces
      System.out.println ("\nElementos la lista enlazada enlaces: ");
      for ( String color : enlaces )
         System.out.println( color );
         
   } // fin del constructor de UsoToArray

   public static void main(String[] args)
   {
      new UsoToArray();
   } // fin de main 
} // fin de la clase UsoToArray


/**************************************************************************
 * (C) Copyright 1992-2007 por Deitel & Associates, Inc. y                *
 * Pearson Education, Inc. Todos los derechos reservados.                 *
 *                                                                        *
 * RENUNCIA: Los autores y el editor de este libro han realizado su mejor *
 * esfuerzo para preparar este libro. Esto incluye el desarrollo, la      *
 * investigación y prueba de las teorías y programas para determinar su   *
 * efectividad. Los autores y el editor no hacen ninguna garantía de      *
 * ningún tipo, expresa o implícita, en relación con estos programas o    *
 * con la documentación contenida en estos libros. Los autores y el       *
 * editor no serán responsables en ningún caso por los daños consecuentes *
 * en conexión con, o que surjan de, el suministro, desempeño o uso de    *
 * estos programas.                                                       *
 *************************************************************************/
