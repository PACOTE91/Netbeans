package Tema8;
public class Tour_Desierto_Tabernas extends Visita{

    boolean todoterreno4x4;
    static int total_tours;

    public Tour_Desierto_Tabernas(String descripcion, int num_adultos, int num_ninos, boolean guiada, boolean todoterreno4x4) {
        super(descripcion, num_adultos, num_ninos, guiada);
        this.todoterreno4x4=todoterreno4x4;
        total_tours++;
    }

    public boolean isTodoterreno4x4() {
        return todoterreno4x4;
    }

    public void setTodoterreno4x4(boolean todoterreno4x4) {
        this.todoterreno4x4 = todoterreno4x4;
    }

    public static int getTotal_tours() {
        return total_tours;
    }



    public double precio() {
        double precio=(num_adultos+num_ninos)*30;
        if (guiada){
            precio=(num_adultos+num_ninos)*5;
        }
        if (todoterreno4x4){
            precio=precio+50;
        }

        return precio;
    }

    @Override
    public String toString() {
        return "Tour_Desierto_Tabernas{" +
                "Descripcion='" + descripcion + '\'' +
                ", Total adultos=" + num_adultos +
                ", Total niños=" + num_ninos +
                ", Todoterreno contratado=" + todoterreno4x4 +
                ", ¿Es guiada?=" + guiada +
                ", Precio total=" + precio() +
                '}';
    }
}
