package Tema8;
public class Cubo extends Figura3D {

	private double lado;
	
	// constructor
	public Cubo (String nomb, int color2, int grosor, double lado_cubo) {
		super (nomb, color2, grosor); // llamada al constructor de la superclase
		lado = lado_cubo;	
	}
	
	// implementar los métodos abstractos heredados de Figura2D
	public double Area() {	
		return 6*lado*lado; // 6 caras
	}

	public double Volumen () {
		return lado*lado*lado;
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
