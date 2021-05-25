package Tema7;

public class Recolector_Aceituna extends Recolector {
    static int recolectores_aceituna;

    Recolector_Aceituna(String nombre, int dni, double sueldo, boolean eventual, double n_kilos, double prec_kilo) {
        super(nombre, dni, sueldo, eventual, n_kilos, prec_kilo);
        recolectores_aceituna++;

    }

    public static int getNum_recolectores_aceituna() {
        return recolectores_aceituna;
    }

    @Override
    public double salario() {
        double sueldo_base;
        sueldo_base = super.salario() + 150;
        return sueldo_base;
    }
}
