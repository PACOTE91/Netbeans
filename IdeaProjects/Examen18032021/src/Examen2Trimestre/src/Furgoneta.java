public class Furgoneta extends Transporte {
    private int num_paquetes;

    public Furgoneta (String descripcion, String matricula, double kms_recorridos, Trabajador currante, int paquetes) {
        super (descripcion, matricula, kms_recorridos, currante);
        num_paquetes = paquetes;
    }

    @Override
    public double coste() {
        return getKms_recorridos()*1.5 + getCurrante().getSalario();
    }

    public int getNum_paquetes() {
        return num_paquetes;
    }

    public void setNum_paquetes(int num_paquetes) {
        this.num_paquetes = num_paquetes;
    }

    // La valoración va desde 0 a 10
    // cada 10 paquetes entregados es 1 punto de valoración
    // con un máximo de 10 puntos de valoración
    @Override
    public double valorar() {
        double valor = 0;
        valor = num_paquetes / 10;
        if (valor > 10)
            valor = 10;

        return valor;
    }

    @Override
    public String toString() {
        return super.toString()+ "Furgoneta{" +
                "num_paquetes=" + num_paquetes +
                '}';
    }
}
