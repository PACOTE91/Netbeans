public class Trabajador {
    private String nombre;

    public Trabajador(String nombre, String NIF, double salario) {
        this.nombre = nombre;
        this.NIF = NIF;
        this.salario = salario;
    }

    private String NIF;
    private double salario;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }


    @Override
    public String toString() {
        return "Trabajador{" +
                "nombre='" + nombre + '\'' +
                ", NIF='" + NIF + '\'' +
                ", salario=" + salario +
                '}';
    }
}
