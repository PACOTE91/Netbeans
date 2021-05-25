package Tema8;
public abstract class Visita extends Producto_Turistico {

    boolean guiada;
    static int total_visitas=0;

    public Visita(String descripcion, int num_adultos, int num_ninos, boolean guiada) {
        super(descripcion, num_adultos, num_ninos);
        this.guiada=guiada;
        total_visitas++;
    }

    public boolean isGuiada() {
        return guiada;
    }

    public void setGuiada(boolean guiada) {
        this.guiada = guiada;
    }

    public static int getTotal_visitas() {
        return total_visitas;
    }

    @Override
    public String toString() {
        return "Visita{" +
                "descripcion='" + descripcion + '\'' +
                ", num_adultos=" + num_adultos +
                ", num_ninos=" + num_ninos +
                ", guiada=" + guiada +
                '}';
    }

    abstract public double precio();
}
