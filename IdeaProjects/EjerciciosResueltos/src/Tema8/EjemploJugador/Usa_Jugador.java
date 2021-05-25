package Tema8.EjemploJugador;

public class Usa_Jugador {
	
	public static void main (String args[]) {
		
		// Crear 2 jugadores
		Jugador jug1 = new Jugador ("Pepe Luis", 12345678, 8);
		Jugador jug2 = new Jugador ("Maria", 87654321, 9);
		
		// Crear 2 futbolistas
		Futbolista futb1 = new Futbolista ("Cristiano Ronaldo", 12124545, 10, 200);
		Futbolista futb2 = new Futbolista ("Lionel Messi", 77774444, 10, 400);
		
		// Crear 2 jugadores de basket
		Jugador_Basket bask1 = new Jugador_Basket ("Sabonis", 33332222, 9, 1000, 500, 2000, 1500);
		Jugador_Basket bask2 = new Jugador_Basket ("Jordan", 11112222, 10, 2000, 800, 3000, 1700);		
		
		// Crear 2 ciclistas		
		int [] carreras1 = {3, 5, 1, 2, 1};
		int [] carreras2 = {8, 10, 1, 1, 1, 2};
		
		Ciclista cicli1 = new Ciclista ("Alberto Contador", 78785454, 9, carreras1);
		Ciclista cicli2 = new Ciclista ("Miguel Indurain", 78785454, 10, carreras2);
		
		// Crear vector con los 8 objetos de diferentes clases => Polimorfismo
		Jugador [] v = {jug1, jug2, futb1, futb2, bask1, bask2, cicli1, cicli2};
		
		
		/* recorre dicho vector mostrando: Todos los atributos de cada objeto definido anteriormente (haz uso de toString() )
		 * La valoración de cada objeto => método valorar()  */
		for (Jugador jug : v) 
			System.out.println (jug + ". Valoración = " + jug.valorar() );
			
		/* Recorre el vector anterior y muestra para los objetos de la clase Futbolista el número de goles, 
		 * para los objetos de la clase Jugador_Basket los puntos anotados 
		 * y para los de la clase Ciclista el total de puntuaciones obtenidas en todas las carreras, 
		 * haciendo uso de los métodos get() creados antes.*/
		 
		for (Jugador jug : v) {
			
			if (jug instanceof Futbolista) {
				Futbolista futbolero = (Futbolista) jug;
				System.out.println ("\n" + futbolero.getNombre() + ", número de goles = " + futbolero.getNum_goles() );
				
			}
				
			if (jug instanceof Jugador_Basket) {
				Jugador_Basket basket = (Jugador_Basket) jug;
				System.out.println ("\n" + basket.getNombre() + ", ptos anotados = " + basket.getPuntos_anotados() );				
			}
			
			if (jug instanceof Ciclista) {
				Ciclista ciclo = (Ciclista) jug;				
				System.out.println ("\n" + ciclo.getNombre() + ", media carreras = " + ciclo.valorar() );				
			}	
			
		}
		
		
		
	}
}

