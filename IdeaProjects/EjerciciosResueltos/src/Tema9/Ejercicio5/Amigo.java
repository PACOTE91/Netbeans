package Tema9.Ejercicio5;

// Los objetos de esta clase se pueden copiar a un fichero
public class Amigo implements java.io.Serializable {

	protected String nombre;
	protected long telefono;
	
	public Amigo(String n, long t){
		nombre = n;
		telefono = t;
	}
	
	public void print() {
		System.out.println(nombre + " -> " + telefono);
	}
	
} // fin clase Amigo


