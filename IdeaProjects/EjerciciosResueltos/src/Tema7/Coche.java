package Tema7;
// subclase Coche que hereda de la superclase Vehiculo
public class Coche extends Vehiculo {
	// ejercicio 1
	
	// atributos de instancia
	private int num_airbags;
	private boolean climatizador;
	private int num_puertas;
	// atributo de clase
	private static int num_coches = 0;
	
	// ejercicio 2 

	// constructor por defecto
	public Coche () {
		num_coches ++;
	}
	
	// constructor
	// E: todos los valores para los atributos de instancia
	// S: inicializa todos los atributos de instancia e incrementa el número de coches en 1
	public Coche (String fabricante2, String matricula2, int anio, String propietario2, 
	               int airbags, boolean climatizador2, int puertas) {
		// llamada explícita al constructor de la superclase
		super (fabricante2, matricula2, anio, propietario2);

		num_airbags = airbags;
		climatizador = climatizador2;
		num_puertas = puertas;
		num_coches ++;
	} 
	
	// ejercicio 3
	
	public int get_num_airbags () {
		return num_airbags;	
	}
	
	public void put_num_airbags (int num) {
		num_airbags = num;	
	}
	
	public boolean get_climatizador () {
		return climatizador;	
	}
	
	public void put_climatizador (boolean climatizador2) {
		climatizador = climatizador2;	
	}
	
	public int get_num_puertas () {
		return num_puertas;	
	}
	
	public void put_num_puertas (int num) {
		num_puertas = num;	
	}	
	
	public static int get_num_coches () {
		return num_coches;	
	}
	
	public static void put_num_coches (int num) {
		num_coches = num;	
	}
	
	// ejercicio 4 => redefinir el método toString() que hereda de la superclase Vehiculo
	
	// E: nada
	// S: devuelve una cadena con todos los atributos del objeto que llama al método
	public String toString () {
		// llamar al método toString() de Vehiculo
		String cad = super.toString();
		
		cad = cad + String.format (", Nº de airbags: %d, Climatizador: %b, Nº de puertas %d, nº coches: %d", num_airbags, climatizador, num_puertas, num_coches);
		return cad;  
	} // fin toString
	
	
	
	
	

} // fin subclase Coche
