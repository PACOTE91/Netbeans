package Tema7;

public class Recolector extends Trabajador_Agricola{

    double n_kilos;
    double prec_kilo;
    boolean eventual; //Verdadero:Trabajador es eventual ... Falso:Trabajador no eventual
    static int num_recolectores;

    Recolector(String nombre,int dni, double sueldo,boolean eventual,double n_kilos,double prec_kilo){
        super(nombre,dni,sueldo);
        this.n_kilos=n_kilos;
        this.prec_kilo=prec_kilo;
        this.eventual=eventual;
        num_recolectores++;

    }
    public static int getNum_recolectores() {
        return num_recolectores;
    }

    @Override
    public double salario () {
        double sueldo_base;
        if (eventual){
            sueldo_base=super.salario()+(n_kilos*prec_kilo);
        }else{
            sueldo_base=super.salario()+100;
        }
        return sueldo_base;
    }

    @Override
    public String toString() {

        String tipo_trabajador;
        if (eventual) {
            tipo_trabajador="Eventual";
        }else{
            tipo_trabajador="No eventual";
        }
        return 	super.toString() +"  / "+ tipo_trabajador+" /"+"  / Nº kilos: "+n_kilos+" / "+"  / Precio del kilo:" +prec_kilo+" /  "+"  /***   SUELDO TOTAL:"+ salario()+"€   ***/";
    }





}
