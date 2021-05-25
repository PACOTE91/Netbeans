package Tema9.Ejercicio9;
public abstract class Figura2D extends Figura {

	// constructor
	public Figura2D (String nomb, int color2, int grosor) {
		super (nomb, color2, grosor); // llamada al constructor de la superclase
	}	

	// método abstracto, que las subclases se encargaran de implementar
	public abstract double Perimetro();
} // fin clase Figura2D
