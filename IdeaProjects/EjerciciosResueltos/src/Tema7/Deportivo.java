package Tema7;
// Subclase Deportivo que hereda de la superclase Coche
public class Deportivo extends Coche {
	// ejercicio 1
	
	// atributo de instancia
	// nº de airbags ya fue definido en Coche, por lo tanto el atributo no se puede cambiar ni redefinir
	private boolean descapotable;
	
	// atributo de clase
	private static int num_deportivos = 0;
	
	// ejercicio 2 

	// constructor por defecto
	public Deportivo () {
		num_deportivos ++;
	}
	
	// constructor
	// E: todos los valores para los atributos de instancia
	// S: inicializa todos los atributos de instancia e incrementa el número de Deportivos en 1
	public Deportivo (String fabricante2, String matricula2, int anio, String propietario2, 
	               int airbags, boolean climatizador2, int puertas, boolean capota) {
	  // llamada explícita al constructor de la superclase
	  super (fabricante2, matricula2, anio, propietario2, airbags, climatizador2, puertas);

	  descapotable = capota;
		num_deportivos ++;
	} 
	
	// ejercicio 3
	
	public boolean get_descapotable () {
		return descapotable;	
	}
	
	public void put_descapotable (boolean descapotable2) {
		descapotable = descapotable2;	
	}	
	
	public static int get_num_deportivos () {
		return num_deportivos;	
	}
	
	public static void put_num_deportivos (int num) {
		num_deportivos = num;	
	}
	
	// ejercicio 4 => redefinir el método toString() que hereda de la superclase Coche
	
	// E: nada
	// S: devuelve una cadena con todos los atributos del objeto que llama al método
	public String toString () {
		// llamar al método toString() de Coche
		String cad = super.toString();
		
		cad = cad + String.format (", Descapotable: %b, Nº de Deportivos: %d", descapotable, num_deportivos);
		return cad;  
	} // fin toString
	
	
	
} // fin subclase Deportivo
