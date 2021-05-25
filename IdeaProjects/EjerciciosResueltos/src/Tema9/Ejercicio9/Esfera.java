package Tema9.Ejercicio9;
public class Esfera extends Figura3D {
	
	private double radio;
	
	// constante PI
	private static final double PI = 3.141592653589;
	
	// constructor
	public Esfera (String nomb, int color2, int grosor, double r) {
		super (nomb, color2, grosor); // llamada al constructor de la superclase
		radio = r;
	}
	
	// implementar los métodos abstractos heredados de Figura3D
	public double Area() {	
		return 4*PI*radio*radio;
	}


	public double Volumen() {
		return 4/3*PI*radio*radio*radio;
	}	
	
	public double get_radio () {
		return radio;
	}
	
	public void put_radio (double r) {
		radio = r;
	}	

} // fin clase Esfera
