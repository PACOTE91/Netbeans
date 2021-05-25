package Tema9;

import java.io.Serializable;

public class Espeologia_Sorbas extends Actividad implements Serializable {
    boolean alquiler_equipo;
    static int total_espeleologia=0;

    public Espeologia_Sorbas(String descripcion, int num_adultos, int num_ninos, boolean principiantes, boolean alquiler_equipo) {
        super(descripcion, num_adultos, num_ninos, principiantes);
        this.alquiler_equipo=alquiler_equipo;
        total_espeleologia++;
    }

    public boolean isAlquiler_equipo() {
        return alquiler_equipo;
    }

    public void setAlquiler_equipo(boolean alquiler_equipo) {
        this.alquiler_equipo = alquiler_equipo;
    }

    public static int getTotal_espeleologia() {
        return total_espeleologia;
    }



    public double precio() {
        double precio;
        if (principiantes){
            precio=(num_adultos+num_ninos)*35;
            if(alquiler_equipo){
                precio=precio+((num_ninos+num_adultos)*5);
            }
        }else{
            precio=(num_adultos*20)+(num_ninos*15);
            if(alquiler_equipo){
                precio=precio+((num_ninos+num_adultos)*5);
            }
        }
        return precio;
    }

    @Override
    public String toString() {
        return "Espeologia Sorbas" +
                ", Descripcion " + descripcion + '\'' +
                ", Numero adultos " + num_adultos +
                ", Numero niños=" + num_ninos +
                ", ¿Sois principiantes? " + principiantes +
                ", ¿Equipo contratado? " + alquiler_equipo +
                ", Total espeleologias " + total_espeleologia +
                ", Precio total: " + precio()+"€";
    }
}
