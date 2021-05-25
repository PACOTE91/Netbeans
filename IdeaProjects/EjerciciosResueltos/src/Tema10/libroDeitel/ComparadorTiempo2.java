package Tema10.libroDeitel;// Clase ComparadorTiempo2.java
// Clase Comparator personalizada que compara dos objetos Tiempo2.
import java.util.Comparator;

public class ComparadorTiempo2 implements Comparator <Tiempo2> 
{
   // este método de comparación es para ordenar descendentemente
   public int compare( Tiempo2 tiempo1, Tiempo2 tiempo2 )
   {
		// compara la hora      
		int compararHora = tiempo1.obtenerHora() - tiempo2.obtenerHora(); 
         
		// evalúa la hora primero
		if ( compararHora != 0 )
			return -compararHora;
		 
		// compara el minuto      
		int comparaMinuto = tiempo1.obtenerMinuto() - tiempo2.obtenerMinuto(); 
		 
		// después evalúa el minuto
		if ( comparaMinuto != 0 )
			return -comparaMinuto;
		 
		// compara el segundo     
		int compararSegundo = tiempo1.obtenerSegundo() - tiempo2.obtenerSegundo(); 

		return -compararSegundo; // devuelve el resultado de comparar los segundos
   } // fin del método compare
} // fin de la clase ComparadorTiempo2


