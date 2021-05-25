package javafx.eventos.clases;

import java.util.Objects;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PersonajePropiedades {
	public enum Estrategia {
		RISA,
		MALHUMOR,
		ATAQUE
	}
	
	private final StringProperty nombre = new SimpleStringProperty();
	private final IntegerProperty poder = new SimpleIntegerProperty();
	private final BooleanProperty superpoder = new SimpleBooleanProperty();
	private final ObjectProperty<Estrategia> estrategia = new SimpleObjectProperty<>();
	
	public PersonajePropiedades(String nombre, int poder, boolean superpoder, Estrategia estrategia) {
		this.nombre.set(nombre);
		this.poder.set(poder);
		this.superpoder.set(superpoder);
		this.estrategia.set(estrategia);
	}

	public final String getNombre() {
		return nombre.get();
	}
	
	public final void setNombre(String nombre) {
		this.nombre.set(nombre);
	}
	
	public final StringProperty nombreProperty() {
		return nombre;
	}
	
	public final int getPoder() {
		return poder.get();
	}
	
	public final void setPoder(int poder) {
		this.poder.set(poder);
	}
	
	public final IntegerProperty poderProperty() {
		return poder;
	}
	
	public final boolean isSuperpoder() {
		return superpoder.get();
	}
	
	public final void setSuperpoder(boolean superpoder) {
		this.superpoder.set(superpoder);
	}
	
	public final BooleanProperty superpoderProperty() {
		return superpoder;
	}
	
	public final Estrategia getEstrategia() {
		return estrategia.get();
	}
	
	public final void setEstrategia(Estrategia estrategia) {
		this.estrategia.set(estrategia);
	}
	
	public final ObjectProperty<Estrategia> estrategiaProperty() {
		return estrategia;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(estrategia.get(), nombre.get(), poder.get(), superpoder.get());
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
		PersonajePropiedades other = (PersonajePropiedades) obj;
		return estrategia.get() == other.estrategia.get() && Objects.equals(nombre.get(), other.nombre.get()) && 
				poder.get() == other.poder.get() && superpoder.get() == other.superpoder.get();
	}


	public String toString() {
		return String.format("Nombre: %s, Poder: %d, Superpoder: %b, Estrategia: %s",
				nombre.get(), poder.get(), superpoder.get(), estrategia.get());
	}
}