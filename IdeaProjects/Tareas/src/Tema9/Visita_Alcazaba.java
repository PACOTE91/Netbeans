package Tema9;

import java.io.Serializable;

public class Visita_Alcazaba extends Visita implements Serializable {
    static int total_visitas_alcazaba=0;


    public Visita_Alcazaba(String descripcion, int num_adultos, int num_ninos, boolean guiada) {
        super(descripcion, num_adultos, num_ninos, guiada);
        total_visitas_alcazaba++;
    }

    public static int getTotal_visitas_alcazaba() {
        return total_visitas_alcazaba;
    }



    public double precio() {
        double total;
        total=(num_adultos*10)+(num_ninos*5);
        if (guiada){
            total=total+30;
        }
        return total;
    }

    @Override
    public String toString() {
        return " ||" +
                "Descripcion" + descripcion + '\'' +
                ", Numero adultos " + num_adultos +
                ", Numero niños " + num_ninos +
                ", ¿Es guiada? " + guiada +
                ", Precio total: " + precio()+"€";
    }
}
