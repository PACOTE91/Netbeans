package Tema9.Ejercicio9;

public abstract class Figura implements java.io.Serializable {

	private String nombre;
	private int color;
	private int grosorBorde;
	
	// constructor
	public Figura (String nomb, int color2, int grosor) {
		nombre = nomb;
		color = color2;
		grosorBorde = grosor;	
	}

	public String getNombre(){
		return this.nombre;
	}
	
	public void setNombre(String n){
		this.nombre = n;
	}

	public int getColor(){
		return color;
	}

	public void setColor(int c){
		color=c;
	}

	public int getGrosorBorde(){
		return grosorBorde;
	}

	public void setGrosorBorde(int g){
		grosorBorde = g;
	}

	// puede haber una clase Abstracta que no tenga ningún método abstracto

	
	// método abstracto, que las subclases se encargaran de implementar
	public abstract double Area();
	
	public String toString () {		
		return "Nombre: " + nombre + ", color: " + color + ", grosor borde: " + grosorBorde;		
	}

	
	// public abstract void dibujar();

} // fin clase Figura
