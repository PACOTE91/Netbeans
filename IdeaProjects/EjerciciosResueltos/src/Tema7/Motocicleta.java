package Tema7;
// subclase Motocicleta que hereda de la superclase Vehiculo
public class Motocicleta extends Vehiculo {
	// ejercicio 1
	
	// atributos de instancia
	private boolean portaequipajes;
	private boolean casco;
	private String cilindrada;
	// atributo de clase
	private static int num_motocicletas = 0;
	
	// ejercicio 2 

	// constructor por defecto
	public Motocicleta () {
		num_motocicletas ++;
	}
	
	// constructor
	// E: todos los valores para los atributos de instancia
	// S: inicializa todos los atributos de instancia e incrementa el número de motocicletas en 1
	public Motocicleta (String fabricante2, String matricula2, int anio, String propietario2, 
	               boolean equipaje, boolean casco2, String motor) {
		// llamada explícita al constructor de la superclase
		super (fabricante2, matricula2, anio, propietario2);

		portaequipajes = equipaje;
		casco = casco2;
		cilindrada = motor;
		num_motocicletas ++;
	} 
	
	// ejercicio 3
	
	public boolean get_portaequipajes () {
		return portaequipajes;	
	}
	
	public void put_portaequipajes (boolean portaequipajes2) {
		portaequipajes = portaequipajes2;	
	}	
	
	public boolean get_casco () {
		return casco;	
	}
	
	public void put_casco (boolean casco2) {
		casco = casco2;	
	}
	
	public String get_cilindrada () {
		return cilindrada;	
	}
	
	public void put_cilindrada (String cilindrada2) {
		cilindrada = cilindrada2;	
	}	
	
	public static int get_num_motocicletas () {
		return num_motocicletas;	
	}
	
	public static void put_num_motocicletas (int num) {
		num_motocicletas = num;	
	}
	
	// ejercicio 4 => redefinir el método toString() que hereda de la superclase Vehiculo
	
	// E: nada
	// S: devuelve una cadena con todos los atributos del objeto que llama al método
	public String toString () {
		// llamar al método toString() de Vehiculo
		String cad = super.toString();
		
		cad = cad + String.format (", Portaequipajes: %b, Casco: %b, Cilindrada %s, nº motocicletas: %d", portaequipajes, casco, cilindrada, num_motocicletas);
		return cad;  
	} // fin toString

} // fin subclase Motocicleta
