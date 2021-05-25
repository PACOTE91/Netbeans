package Tema10.libroDeitel;// Fig. 19.13: Algoritmos1.java
// Uso de los algoritmos reverse, fill, copy, min y max.
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class Algoritmos1 
{
   // Character es la clase envoltorio o Wrapper de char
   private Character[] letras = { 'P', 'C', 'M' };
   private Character[] copiaLetras;
   // declaración de las listas de tipo Character sin hacer reserva de memoria
   private List <Character> lista;
   private List <Character> copiaLista;

   // crea un objeto List y lo manipula con los métodos de Collections
   public Algoritmos1()
   {
      // obtiene el objeto List (ArrayList) del vector letras
      lista = Arrays.asList (letras); 
      copiaLetras = new Character [3]; // reservar memoria para 3 objetos de tipo Character 
      copiaLista = Arrays.asList( copiaLetras ); // vista List de copiaLetras

      // imprimir la lista y obtener el máximo y el mínimo
      System.out.println( "Lista inicial: " );
      imprimir( lista );

      // invierte el orden => reverse()
      Collections.reverse( lista ); 
      System.out.println( "\nDespues de llamar a reverse: " );
      imprimir( lista );

      // copia el objeto lista en copialista
      Collections.copy( copiaLista, lista ); 
      System.out.println( "\nDespues de copy: " );
      imprimir( copiaLista );

       // llena la lista con Rs
      Collections.fill (lista, 'R' );
      System.out.println( "\nDespues de llamar a fill: " );
      imprimir( lista );
   } // fin del constructor de Algoritmos1

   // imprime la información del objeto List
   // y obtiene el máximo y mínimo de la lista
   private void imprimir( List <Character> refLista )
   {
      System.out.print( "La lista es: " );

      // recorrer todos los elementos de la lista y mostrarlos por pantalla
      for ( Character elemento : refLista )
         System.out.printf( "%s ", elemento );

      // Obtener el máximo de la lista
      System.out.printf( "\nMax: %s", Collections.max( refLista ) );
      // Obtener el mínimo de la lista
      System.out.printf( "  Min: %s\n", Collections.min( refLista ) );
   } // fin del método imprimir

   public static void main( String args[] )
   {
      new Algoritmos1();
   } // fin de main
} // fin de la clase Algoritmos1


