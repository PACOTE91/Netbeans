package Tema9;

import java.io.Serializable;

public class Kayak_Cabo_Gata extends Actividad implements Serializable {
    boolean snorkel;
    int totalkayaks;

    public Kayak_Cabo_Gata(String descripcion, int num_adultos, int num_ninos, boolean principiantes,boolean snorkel) {
        super(descripcion, num_adultos, num_ninos, principiantes);
        this.snorkel=snorkel;
        totalkayaks++;
    }

    public boolean isSnorkel() {
        return snorkel;
    }

    public void setSnorkel(boolean snorkel) {
        this.snorkel = snorkel;
    }

    public int getTotalkayaks() {
        return totalkayaks;
    }


    public double precio() {
        double precio;
        if (principiantes){
            precio=(num_adultos*30)+(num_ninos*15);
        }else{
            precio=(num_adultos*20)+(num_ninos*10);
        }
        if(snorkel){
            precio=precio+((num_ninos+num_adultos)*5);
        }
        return precio;
    }

    @Override
    public String toString() {
        return "Kayak Cabo Gata" +
                ", Descripcion " + descripcion + '\'' +
                ", Numero adultos " + num_adultos +
                ", Numero niños " + num_ninos +
                ", ¿Sois principiantes? " + principiantes +
                ", ¿Snorkel contratado? " + snorkel +
                ", Total de Kayaks " + totalkayaks +
                ", Precio total: " + precio() +"€";
    }
}
