package Tema6;

public class Prueba_Alumno {
    public static void main(String[] args) {
        Alumno[] v_alumno = new Alumno [10];
        Fecha alumno1 = new Fecha(1,9,2000);
        Fecha alumno2 = new Fecha(5,7,2001);
        Fecha alumno3 = new Fecha(7,12,2002);
        Fecha alumno4 = new Fecha(4,14,1998);
        Fecha alumno5 = new Fecha(12,22,2001);
        Fecha alumno6 = new Fecha(10,25,2000);
        Fecha alumno7 = new Fecha(3,12,1997);
        Fecha alumno8 = new Fecha(3,6,1998);
        Fecha alumno9 = new Fecha(1,9,2002);
        Fecha alumno10 = new Fecha(1,7,2001);



        Alumno[] v_prueba_alumno = {new Alumno(1, alumno1, "Juan", 3.5),
                new Alumno(2, alumno2, "Marcelo", 3.3),
                new Alumno(3, alumno3, "Adrian", 9.4),
                new Alumno(4, alumno4, "Angel", 10),
                new Alumno(5, alumno5, "Antonio", 8.9),
                new Alumno(6, alumno6, "Laura", 6.67),
                new Alumno(7, alumno7, "Juan Carlos", 4.45),
                new Alumno(8, alumno8, "Javier", 5.25),
                new Alumno(9, alumno9, "Evaristo", 3.33),
                new Alumno(10, alumno10, "Maria Jose", 7)};

        System.out.println("////////////////////////////////////////////////////////////////////");
        System.out.println("***************************VECTOR DESORDENADO***********************");
        System.out.println("////////////////////////////////////////////////////////////////////");

        Alumno.mostrar_vector(v_prueba_alumno);
        Alumno.shell_desc(v_prueba_alumno);
        System.out.println("////////////////////////////////////////////////////////////////////");
        System.out.println("*****************************VECTOR ORDENADO***********************");
        System.out.println("////////////////////////////////////////////////////////////////////");
        Alumno.mostrar_vector(v_prueba_alumno);










    }

        
}
