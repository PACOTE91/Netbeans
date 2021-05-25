package Tema9.Ejercicio9;
public class Triangulo extends Figura2D {

	private double lado1;
	private double lado2;
	private double base;	
	private double altura;
	
	// constructor
	public Triangulo (String nomb, int color2, int grosor, double l1, double l2, double b, double a) {
		super (nomb, color2, grosor); // llamada al constructor de la superclase
		lado1 = l1;
		lado2 = l2;
		base = b;
		altura = a;
	}
	
	// implementar los métodos abstractos heredados de Figura2D
	public double Area() {	
		return base*altura/2;
	}

	public double Perimetro() {
		return lado1 + lado2 + base;
	}	
	
	public double get_lado1 () {
		return lado1;
	}
	
	public void put_lado1 (double l) {
		lado1 = l;
	}
	
	public double get_lado2 () {
		return lado2;
	}
	
	public void put_lado2 (double l) {
		lado2 = l;
	}	
	
	public double get_base () {
		return base;
	}
	
	public void put_base (double b) {
		base = b;
	}	
	
	public double get_altura () {
		return altura;
	}
	
	public void put_altura (double a) {
		altura = a;
	}	

} // fin clase Triangulo
