package Tema10.libroDeitel;// Clase ComparadorTiempo2.java
// Clase Comparator personalizada que compara dos objetos Tiempo2.
import java.util.Comparator;

public class ComparadorTiempo4 implements Comparator <Tiempo2> 
{
   // este método de comparación es para ordenar descendentemente
   public int compare ( Tiempo2 tiempo1, Tiempo2 tiempo2 )
   {
		// Pasar a segundos el tiempo1
		int seg1 = tiempo1.obtenerHora() * 3600 + tiempo1.obtenerMinuto() * 60 + tiempo1.obtenerSegundo();
		
		// Pasar a segundos el tiempo2
		int seg2 = tiempo2.obtenerHora() * 3600 + tiempo2.obtenerMinuto() * 60 + tiempo2.obtenerSegundo();
		
		return seg2-seg1;
		
   } // fin del método compare
   
} // fin de la clase ComparadorTiempo4


