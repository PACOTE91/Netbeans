package Tema7;
// Superclase o clase de las que heredan todas las demás subclases
public class Vehiculo {
	// ejercicio 1
	
	// atributos de instancia
	private String fabricante;
	private String matricula;
	private int anio_matricula;
	private String propietario; // nombre y apellidos
	// atributo de clase
	private static int num_vehiculos = 0;

	// ejercicio 2 

	// constructor por defecto
	public Vehiculo () {
		num_vehiculos ++;
	}
	
	// constructor
	// E: todos los valores para los atributos de instancia
	// S: inicializa todos los atributos de instancia e incrementa el número de vehiculos en 1
	public Vehiculo (String fabricante2, String matricula2, int anio, String propietario2) {
		fabricante = fabricante2;
		matricula = matricula2;
		anio_matricula = anio;
		propietario = propietario2;	
		num_vehiculos ++;
	} 
	
	// ejercicio 3
	
	public String get_fabricante () {
		return fabricante;	
	}
	
	public void put_fabricante (String fabricante2) {
		fabricante = fabricante2;	
	}
	
	
	public String get_matricula () {
		return matricula;	
	}
	
	public void put_matricula (String matricula2) {
		matricula = matricula2;	
	}
	
	public int get_anio_matricula () {
		return anio_matricula;	
	}
	
	public void put_anio_matricula (int anio) {
		anio_matricula = anio;	
	}
	
	public String get_propietario () {
		return propietario;	
	}
	
	public void put_propietario (String propietario2) {
		propietario = propietario2;	
	}
	
	public static int get_num_vehiculos () {
		return num_vehiculos;	
	}
	
	public static void put_num_vehiculos (int num) {
		num_vehiculos = num;	
	}

	// ejercicio 4 => redefinir el método toString() que hereda en este caso de la clase Object
	
	// E: nada
	// S: devuelve una cadena con todos los atributos del objeto que llama al método
	public String toString () {
		return String.format ("\nFabricante: %s, Matricula: %s, Año de matriculación %d, Propietario: %s, nº vehículos: %d", fabricante, matricula, anio_matricula, propietario, num_vehiculos);  
	} // fin toString
	
	
	
} // fin clase Vehiculo
