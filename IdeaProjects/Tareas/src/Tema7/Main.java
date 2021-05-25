package Tema7;

public class Main {
    public static void main(String[] args) {
        Trabajador_Agricola t1 = new Trabajador_Agricola("Perico Perez", 12345678, 985.75);
        Recolector r1 = new Recolector("Jaime Martínez", 123456789, 700.75, true, 100, 2.5);
        Recolector r2 = new Recolector("Alfonso Martínez", 8746536, 700.75, false, 200, 2);
        Recolector_Aceituna r_ac_1 = new Recolector_Aceituna("María Fernandez", 3456786, 800, false, 300, 3);
        Recolector_Aceituna r_ac_2 = new Recolector_Aceituna("Jose Ortiz", 57467556, 900, true, 300, 4);

        System.out.println(t1.toString());
        System.out.println(r1.toString());
        System.out.println(r2.toString());
        System.out.println(r_ac_1.toString());
        System.out.println(r_ac_2.toString());


        System.out.println("Hay un total de " + Trabajador_Agricola.getNum_trabajadores() + " trabajadores");
        System.out.println("Hay un total de " + Recolector.getNum_recolectores() + " recolectores");
        System.out.println("Hay un total de " + Recolector_Aceituna.getNum_recolectores_aceituna() + " recolectores de aceituna");


    }
}
