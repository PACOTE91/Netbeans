package Tema8;
public abstract class Figura3D extends Figura {

	// constructor
	public Figura3D (String nomb, int color2, int grosor) {
		super (nomb, color2, grosor); // llamada al constructor de la superclase
	}	
	
	// método abstracto, que las subclases se encargaran de implementar
	public abstract double Volumen();
} // fin clase Figura3D

