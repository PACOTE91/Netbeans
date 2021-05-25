package Tema10.libroDeitel;// Fig. 19.4: PruebaList.java
// Uso de objetos LinkList.
import java.util.List;
import java.util.LinkedList;
import java.util.ListIterator;

public class PruebaList 
{
   // Constantes de tipo vector
   private static final String colores[] = { "negro", "amarillo", "verde", "azul", "violeta", "plateado" };
   private static final String colores2[] = { "dorado", "blanco", "cafe", "azul", "gris", "plateado" };
                  
   // establece y manipula objetos LinkedList => LISTA ENLAZADA
   public PruebaList()
   {
      // Crear dos objetos lista enlazada
      List <String> lista1 = new LinkedList <String>(); 
      List <String> lista2 = new LinkedList <String>();

      // agrega los elementos del vector colores a la lista enlazada 1
      for ( String color : colores )      	
         // añade el elemento actual del vector a lista1
         lista1.add (color);

      // agrega elementos del vector colores2 a la lista enlazada 2
      for ( String color : colores2 )
         // añade el elemento actual del vector a lista2
         lista2.add( color );

      // concatena las listas enlazadas => añade la lista2 a la lista1
      lista1.addAll( lista2 ); 
      
	  // libera los recursos de la lista2 (borra todos los elementos) => la lista2 queda vacía     
      lista2.clear();
      lista2 = null;		
      
      // imprime los elementos de lista1
      imprimirLista( lista1 ); 

      // convierte los elementos de la lista a mayúsculas
      mayusculas( lista1 ); 
      imprimirLista( lista1 ); // imprime los elementos de lista1

      System.out.print( "\nEliminando elementos 4 a 6..." );
      // elimina los elementos 4 a 6 de la lista => el 0 es el primero
      eliminarElementos( lista1, 3, 6 ); 
      imprimirLista( lista1 ); // imprime los elementos de lista1
      
      // imprime la lista en orden inverso
      imprimirListaInversa( lista1 ); 
      
   } // fin del constructor de PruebaList

   // imprime el contenido del objeto List
   public void imprimirLista( List <String> lista )
   {
      System.out.println( "\nlista: " );
   
      // recorrer todos los elementos de la lista
      for ( String color : lista )
         System.out.printf( "%s ", color );

      System.out.println();
      
   } // fin del método imprimirLista                                                   

   // localiza los objetos String y los convierte a mayúsculas
   private void mayusculas (List <String> lista)
   {
      // crear el iterador para recorrer la lista
      ListIterator <String> iterador = lista.listIterator();

      while ( iterador.hasNext() ) {
         // obtiene el siguiente elemento de la lista => iterador.next()
         String elemento = iterador.next();  
         // convierte a mayúsculas elemento y se lo pasa al elemento actual de la lista
         iterador.set (elemento.toUpperCase()); 
      } // fin de while
      
   } // fin del método mayusculas

   // obtiene sublista y utiliza el método clear para eliminar los elementos de la misma
   private void eliminarElementos( List <String> lista, int inicio, int fin )
   {
      // obtiene los elementos comprendidos entre inicio y fin de la lista y luego los elimina
      lista.subList (inicio, fin).clear();  
   } // fin del método eliminarElementos

   // imprime la lista inversa
   private void imprimirListaInversa (List< String > lista) 
   {
      // crear el iterador para recorrer la lista desde el final => lista.size()
      ListIterator <String> iterador = lista.listIterator (lista.size());

      System.out.println( "\nLista inversa:" );

      // imprime la lista en orden inverso => comprueba si existe elemento anterior
      while (iterador.hasPrevious())
         // muestra por pantalla el elemento anterior
         System.out.printf( "%s ", iterador.previous() ); 
   } // fin del método imprimirListaInversa
   
   public static void main( String args[] )
   {
      new PruebaList();
   } // fin de main                                    
} // fin de la clase PruebaList



