package Tema9;

import java.io.Serializable;

public abstract class Actividad extends Producto_Turistico implements Serializable {

   boolean principiantes;
   static int tota_actividades;

    public Actividad(String descripcion, int num_adultos, int num_ninos, boolean principiantes) {
        super(descripcion, num_adultos, num_ninos);
        this.principiantes=principiantes;
        tota_actividades++;
    }

    public boolean isPrincipiantes() {
        return principiantes;
    }

    public void setPrincipiantes(boolean principiantes) {
        this.principiantes = principiantes;
    }

    public static int getTota_actividades() {
        return tota_actividades;
    }

    @Override
    public String toString() {
        return "Actividad{" +
                "principiantes=" + principiantes +
                ", descripcion='" + descripcion + '\'' +
                ", num_adultos=" + num_adultos +
                ", num_ninos=" + num_ninos +
                '}';
    }

    public abstract double precio();
}
