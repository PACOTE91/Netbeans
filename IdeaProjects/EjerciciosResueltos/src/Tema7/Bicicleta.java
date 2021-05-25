package Tema7;

// subclase Bicicleta que hereda de la superclase Vehiculo
public class Bicicleta extends Vehiculo {
	// ejercicio 1
	
	// atributo de instancia
	private String tipo_bicicleta;
	// atributo de clase
	private static int num_bicis = 0;
	
	// ejercicio 2 

	// constructor por defecto
	public Bicicleta () {
		num_bicis ++;
	}
	
	// constructor
	// E: todos los valores para los atributos de instancia
	// S: inicializa todos los atributos de instancia e incrementa el número de bicicletas en 1
	public Bicicleta (String fabricante2, String matricula2, int anio, String propietario2, String tipo) {
		// llamada explícita al constructor de la superclase
		super (fabricante2, matricula2, anio, propietario2);

		tipo_bicicleta = tipo;
		num_bicis ++;
	}
	
	// ejercicio 3	
	
	public String get_tipo_bicicleta () {
		return tipo_bicicleta;	
	}
	
	public void put_tipo_bicicleta (String tipo_bicicleta2) {
		tipo_bicicleta = tipo_bicicleta2;	
	}	
	
	public static int get_num_bicis () {
		return num_bicis;	
	}
	
	public static void put_num_bicis (int num) {
		num_bicis = num;	
	}
	
	// ejercicio 4 => redefinir el método toString() que hereda de la superclase Vehiculo
	
	// E: nada
	// S: devuelve una cadena con todos los atributos del objeto que llama al método
	public String toString () {
		// llamar al método toString() de Vehiculo
		String cad = super.toString();
		
		cad = cad + String.format (", Tipo de bicicleta: %s, nº bicis: %d", tipo_bicicleta, num_bicis);
		return cad;  
	} // fin toString
	

} // fin subclase Bicicleta
