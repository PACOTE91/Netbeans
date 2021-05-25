public abstract class Transporte implements Estadisticas {
    private String descripcion;
    private String matricula;
    private double kms_recorridos;
    private Trabajador currante;

    public Transporte(String descripcion, String matricula, double kms_recorridos, Trabajador currante) {
        this.descripcion = descripcion;
        this.matricula = matricula;
        this.kms_recorridos = kms_recorridos;
        this.currante = currante;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getKms_recorridos() {
        return kms_recorridos;
    }

    public void setKms_recorridos(double kms_recorridos) {
        this.kms_recorridos = kms_recorridos;
    }

    public Trabajador getCurrante() {
        return currante;
    }

    public void setCurrante(Trabajador currante) {
        this.currante = currante;
    }

    @Override
    public String toString() {
        return "Transporte{" +
                "descripcion='" + descripcion + '\'' +
                ", matricula='" + matricula + '\'' +
                ", kms_recorridos=" + kms_recorridos +
                ", currante=" + currante +
                '}';
    }
}
