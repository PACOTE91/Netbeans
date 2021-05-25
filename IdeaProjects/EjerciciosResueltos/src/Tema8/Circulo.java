package Tema8;
public class Circulo extends Figura2D {

	private double radio;
	
	// constante PI
	private static final double PI = 3.141592653589;
	
	// constructor
	public Circulo (String nomb, int color2, int grosor, double r) {
		super (nomb, color2, grosor); // llamada al constructor de la superclase
		radio = r;
	}
	
	// implementar los métodos abstractos heredados de Figura2D
	public double Area() {	
		return PI*radio*radio;
	}

	public double Perimetro() {
		return 2*PI*radio;
	}
	
	public double get_radio () {
		return radio;
	}
	
	public void put_radio (double r) {
		radio = r;
	}	

} // fin clase Circulo
