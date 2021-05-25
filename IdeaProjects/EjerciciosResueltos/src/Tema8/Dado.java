package Tema8;
public class Dado extends Sorteo {
	
	
	public int lanzar () {		
		posibilidades = 6;
		
		// número aleatorio entre 0 y 1
		double aleatorio_0_1 = Math.random();
		// número aleatorio entre 1 y 6
		int aleatorio_1_6 = (int) (Math.round ( (aleatorio_0_1*(posibilidades-1) ) ) +1);		
		
		return aleatorio_1_6;		
	} // fin lanzar
	
	public static void main (String [] args) {
		
		Dado dado6 = new Dado();
		
		
		for (int i=1; i<=40; i++) 
			System.out.println ("Lanzamiento " +  i + " del dado = " + dado6.lanzar() );
		
		
	} // fin main
	
}
