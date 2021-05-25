public class Camion extends Transporte {

    private double peso_kilos;

    public Camion(String descripcion, String matricula, double kms_recorridos, Trabajador currante, double peso) {
        super (descripcion, matricula, kms_recorridos, currante);
        peso_kilos = peso;
    }

    public double getPeso_kilos() {
        return peso_kilos;
    }

    public void setPeso_kilos(double peso_kilos) {
        this.peso_kilos = peso_kilos;
    }

    @Override
    public double coste() {
        return getKms_recorridos()*2 + getCurrante().getSalario();
    }

    @Override
    // La valoración va desde 0 a 10
    // cada 100 km recorridos es 1 punto de valoración
    // con un máximo de 10 puntos de valoración
    public double valorar() {
        double valor = 0;
        valor = getKms_recorridos() / 100.0;

        if (valor > 10)
            valor = 10;

        return valor;
    }

    @Override
    public String toString() {
       return super.toString()+"Camion{" +
                "peso_kilos=" + peso_kilos +
                '}';
    }
}
