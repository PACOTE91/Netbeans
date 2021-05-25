package Tema10.libroDeitel;// Fig. 19.12: MazoDeCartas.java
// Uso del algoritmo shuffle.
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

// clase para representar un objeto Carta en un mazo de cartas
class Carta 
{    
   // Tipo enumerado => permite definir un nuevo tipo 
   // => dos nuevos tipos en este caso, Cara y Palo
   public static enum Cara { As, Dos, Tres, Cuatro, Cinco, Seis,
                             Siete, Ocho, Nueve, Diez, Jota, Reina, Rey  };
   public static enum Palo { Bastos, Diamantes, Corazones, Espadas };

   // declaración de la cara y palo => constantes
   private final Cara cara; // cara de la carta
   private final Palo palo; // palo de la carta
   
   // constructor con dos argumentos
   public Carta( Cara caraCarta, Palo paloCarta ) 
   {   
       cara = caraCarta; // inicializa la cara de la carta
       palo = paloCarta; // inicializa el palo de la carta
   } // fin del constructor de Carta con dos argumentos
   
   // devuelve la cara de la carta
   public Cara obtenerCara() 
   { 
      return cara; 
   } // fin del método obtenerCara

   // devuelve el palo de la Carta
   public Palo obtenerPalo() 
   { 
      return palo; 
   } // fin del método obtenerPalo

   // devuelve la representación String de la Carta
   public String toString()
   {
      return String.format( "%s de %s", cara, palo );
   } // fin del método toString
} // fin de la clase Carta

// declaración de la clase MazoDeCartas
public class MazoDeCartas 
{
   // declara objeto List que almacenará los objetos Carta
   private List <Carta> lista; 

   // constructor => establece mazo de objetos Carta y baraja
   public MazoDeCartas()
   {
      // definir el mazo con 52 cartas
      Carta[] mazo = new Carta[ 52 ];
      int cuenta = 0; // número de cartas

      // llena el mazo con objetos Carta
      // el bucle for recorre todos los valores del palo 
      for ( Carta.Palo palo : Carta.Palo.values() )  
      {
         // el bucle for recorre todos los valores de la cara 
         for ( Carta.Cara cara : Carta.Cara.values() )   
         {
            // almacena una a una todas las posibles cartas de la baraja en el vector mazo
            mazo [cuenta] = new Carta (cara, palo);
            cuenta++;
         } // fin de for
      } // fin de for

      // obtiene objeto List a partir del vector mazo
      lista = Arrays.asList ( mazo ); 
      
      // baraja el mazo de cartas a través de la lista
      Collections.shuffle ( lista );  
      
   } // fin del constructor de MazoDeCartas

   // imprime el mazo
   public void imprimirCartas()
   {
      // muestra las 52 cartas en 4 columnas
      for ( int i = 0; i < lista.size(); i++ )
      	 // con el método get(i) se obtiene el elemento	i de la lista
         System.out.printf( "%-20s%s", lista.get (i), ( ( i + 1 ) % 4 == 0 ) ? "\n" : "" );
   } // fin del método imprimirCartas

   public static void main(String[] args)
   {
      MazoDeCartas cartas = new MazoDeCartas();
      cartas.imprimirCartas();
   } // fin de main  
   
} // fin de la clase MazoDeCartas

