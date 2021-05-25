package Tema6;

import java.util.Scanner;

public class Alumno {
    int matri;
    Fecha fecha_registro;
    String cad;
    double nota;

    Alumno(int matri, Fecha fecha_registro, String cad, double nota) {
        this.matri = matri;
        this.fecha_registro = fecha_registro;
        this.cad = cad;
        this.nota = nota;
    }

    public int getMatri() {
        return matri;
    }

    public void setMatri(int matri) {
        this.matri = matri;
    }

    public Fecha getFecha_registro() {
        return fecha_registro;
    }

    @Override
    public String toString() {
        return cad + " , " + fecha_registro;
    }

    public void setFecha_registro(Fecha fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getCad() {
        return cad;
    }

    public void setCad(String cad) {
        this.cad = cad;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public static int busqueda_secuencial_matricula(Alumno v[], String alum) {
        boolean encontrado = false;
        int i = 0;
        int posicion = -1; // en caso de no encontrar el cliente

        while (!encontrado && i < v.length) {
            if (v[i].getCad().equals(alum)) {
                encontrado = true;
                posicion = i;
            }
            i++;
        }

        return posicion;
    }

    public static void mostrar_alumno(Alumno v) {
        System.out.println("Registro nº:" + v.getMatri() + " --> " + v.getCad() + ", nacimiento: " + v.getFecha_registro()
                + " , nota: " + v.getNota());

    }

    public static void mostrar_vector(Alumno[] v) {
        for (int i = 0; i < v.length; i++) {
            mostrar_alumno(v[i]);
        }

    }

    public static void shell_desc(Alumno v[]) {
        int d, i;
        String nombre_aux;
        Fecha fecha_aux;
        double nota_aux;
        int matricula_aux;
        boolean ordenado;
        int num_ele = v.length;
        d = num_ele;

        while (d != 1) {
            d = d / 2;
            ordenado = false;
            while (!ordenado) {    // !ordenado es como poner ordenado == false
                ordenado = true;
                for (i = 0; i < num_ele - d; i++)
                    if (v[i].getCad().compareTo(v[i + d].getCad()) > 0) {
                        nombre_aux = v[i].getCad();
                        fecha_aux = v[i].getFecha_registro();
                        matricula_aux = v[i].getMatri();
                        nota_aux = v[i].getNota();
                        v[i].setCad(v[i + d].getCad());
                        v[i].setFecha_registro(v[i + d].getFecha_registro());
                        v[i].setMatri(v[i + d].getMatri());
                        v[i].setNota(v[i + d].getNota());
                        v[i + d].setCad(nombre_aux);
                        v[i + d].setFecha_registro(fecha_aux);
                        v[i + d].setMatri(matricula_aux);
                        v[i + d].setNota(nota_aux);

                        ordenado = false;
                    }
            }//Fin while2ª
        }//Fin while1º
    }//Fin shell_desc


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        Fecha alumno1 = new Fecha(1, 17, 1999);
        Fecha alumno2 = new Fecha(4, 14, 1999);
        Fecha alumno3 = new Fecha(7, 30, 1999);
        Fecha alumno4 = new Fecha(9, 29, 1999);
        Fecha alumno5 = new Fecha(12, 13, 1999);
        Fecha alumno6 = new Fecha(10, 25, 1999);
        Fecha alumno7 = new Fecha(6, 14, 1999);
        Fecha alumno8 = new Fecha(3, 18, 1999);
        Fecha alumno9 = new Fecha(2, 4, 1999);
        Fecha alumno10 = new Fecha(1, 3, 1999);

        Alumno[] v_alumno = {new Alumno(1, alumno1, "Juan", 2.7),
                new Alumno(2, alumno2, "Maria", 4),
                new Alumno(3, alumno3, "Jacinto", 9.4),
                new Alumno(4, alumno4, "Adolfo", 7),
                new Alumno(5, alumno5, "Paco", 6.67),
                new Alumno(6, alumno6, "Laura", 8),
                new Alumno(7, alumno7, "Isabel", 3.9),
                new Alumno(8, alumno8, "Javier", 6.2),
                new Alumno(9, alumno9, "Daniel", 4.4),
                new Alumno(10, alumno10, "Jose", 5)};

        mostrar_vector(v_alumno);
        shell_desc(v_alumno);
        System.out.println("//////////////////////////////////");
        System.out.println("*********VECTOR ORDENADO*********");
        mostrar_vector(v_alumno);


        System.out.println("Introduce nombre alumno:");
        String alum = sc.nextLine();
        int pos = busqueda_secuencial_matricula(v_alumno,alum );
        if (pos == -1)
            System.out.println("Error, alumno no encontrado");
        else {
            System.out.println("Alumno encontrado: ");
            mostrar_vector(new Alumno[]{v_alumno[pos]});

        }
    }
}

