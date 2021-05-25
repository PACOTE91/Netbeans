package Tema7;
// Subclase Monovolumen que hereda de la superclase Coche
public class Monovolumen extends Coche {
	// ejercicio 1
	
	// atributo de clase
	private static int num_monovolumenes = 0;
	
	// ejercicio 2 

	// constructor por defecto
	public Monovolumen () {
		num_monovolumenes ++;
	}
	
	// constructor
	// E: todos los valores para los atributos de instancia
	// S: inicializa todos los atributos de instancia e incrementa el número de Deportivos en 1
	public Monovolumen (String fabricante2, String matricula2, int anio, String propietario2, int airbags, boolean climatizador2, int puertas) {
	  // llamada explícita al constructor de la superclase
	  super (fabricante2, matricula2, anio, propietario2, airbags, climatizador2, puertas);
		num_monovolumenes ++;
	} 
	
	
	// ejercicio 3	
	
	public static int get_num_monovolumenes () {
		return num_monovolumenes;	
	}
	
	public static void put_num_monovolumenes (int num) {
		num_monovolumenes = num;	
	}
	
	// ejercicio 4 => redefinir el método toString() que hereda de la superclase Coche
	
	// E: nada
	// S: devuelve una cadena con todos los atributos del objeto que llama al método
	public String toString () {
		// llamar al método toString() de Vehiculo con super.toString()
		return super.toString() + String.format (", Nº de monovolúmenes: %d", num_monovolumenes);		
	} // fin toString
	
} // fin subclase Monovolumen
