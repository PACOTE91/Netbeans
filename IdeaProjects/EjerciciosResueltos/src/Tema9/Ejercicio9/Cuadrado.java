package Tema9.Ejercicio9;
public class Cuadrado extends Figura2D {

	private double lado;
	
	// constructor
	public Cuadrado (String nomb, int color2, int grosor, double lado_cuadrado) {
		super (nomb, color2, grosor); // llamada al constructor de la superclase
		lado = lado_cuadrado;	
	}
	
	// implementar los métodos abstractos heredados de Figura2D
	public double Area() {	
		return lado*lado;
	}

	public double Perimetro() {
		return lado*4;
	}
	
	public double Diagonal () {
		return lado*Math.sqrt(2);
	}
	
	public double get_lado () {
		return lado;
	}
	
	public void put_lado (double l) {
		lado = l;
	}	

} // fin clase Cuadrado
