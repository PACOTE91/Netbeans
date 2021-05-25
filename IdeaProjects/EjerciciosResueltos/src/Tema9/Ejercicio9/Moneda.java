package Tema9.Ejercicio9;
public class Moneda extends Sorteo {
	
	
	public int lanzar () {		
		posibilidades = 2;
		
		// número aleatorio entre 0 y 1
		double aleatorio_0_1 = Math.random();
		// número aleatorio entre 1 y 2
		int aleatorio_1_2 = (int) (Math.round ( (aleatorio_0_1*(posibilidades-1) ) ) +1);
		
		if (aleatorio_1_2 == 1)
			System.out.print (" :) Cara ");
		else
			System.out.print (" + Cruz ");
					
		
		return aleatorio_1_2;		
	} // fin lanzar
	
	public static void main (String [] args) {
		
		Dado dado6 = new Dado();
		
		
		for (int i=1; i<=40; i++) 
			System.out.println ("Lanzamiento " +  i + " del dado = " + dado6.lanzar() );
			
			
		Moneda moneda1 = new Moneda();
		
		
		for (int i=1; i<=10; i++) 
			System.out.println ("Lanzamiento " +  i + " de la moneda = " + moneda1.lanzar() );
		
		
	} // fin main
	
}
