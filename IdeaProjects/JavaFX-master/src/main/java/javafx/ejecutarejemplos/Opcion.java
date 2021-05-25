package javafx.ejecutarejemplos;

public class Opcion {

	private Class<?> clase;
	private String texto;
	
	public Opcion(String texto, Class<?> clase) {
		this.texto = texto;
		this.clase = clase;
	}
	
	public Class<?> getClase() {
		return clase;
	}
	
	@Override
	public String toString() {
		return texto;
	}
	
}
