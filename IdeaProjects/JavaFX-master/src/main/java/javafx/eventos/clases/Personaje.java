package javafx.eventos.clases;

import java.util.Objects;

public class Personaje {
	public enum Estrategia {
		RISA,
		MALHUMOR,
		ATAQUE
	}
	
	private String nombre;
	private int poder;
	private boolean superpoder;
	private Estrategia estrategia;
	
	public Personaje(String nombre, int poder, boolean superpoder, Estrategia estrategia) {
		this.nombre = nombre;
		this.poder = poder;
		this.superpoder = superpoder;
		this.estrategia = estrategia;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getPoder() {
		return poder;
	}
	
	public void setPoder(int poder) {
		this.poder = poder;
	}
	
	public boolean isSuperpoder() {
		return superpoder;
	}
	
	public void setSuperpoder(boolean superpoder) {
		this.superpoder = superpoder;
	}
	
	public Estrategia getEstrategia() {
		return estrategia;
	}
	
	public void setEstrategia(Estrategia estrategia) {
		this.estrategia = estrategia;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(estrategia, nombre, poder, superpoder);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Personaje)) {
			return false;
		}
		Personaje other = (Personaje) obj;
		return estrategia == other.estrategia && Objects.equals(nombre, other.nombre) && poder == other.poder
				&& superpoder == other.superpoder;
	}

	public String toString() {
		return String.format("Nombre: %s, Poder: %d, Superpoder: %b, Estrategia: %s",
				nombre, poder, superpoder, estrategia);
	}
}