package Tema10;

import java.util.ArrayList;
import java.util.Collections;

public class Libros {



    private  int ISBN;
    private  String titulo;

    public Libros (String titulo, int ISBN){
        this.titulo =titulo;
        this.ISBN =ISBN;

    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Libro [ "+ titulo+ ", "
                +ISBN+ " ]";
    }

    public static void main(String[] args) {
        ArrayList <Libros> libros = new  ArrayList <Libros>();

     /*   Libros uno=new Libros("Caperucita",3545356);
        Libros dos=new Libros("Cenicienta",7464566);
        Libros tres=new Libros("Blancanieves",6745645);
        Libros cuatro=new Libros("Los 3 cerditos",554545);
        Libros cinco=new Libros("Rapuncel",576455);
        Libros seis=new Libros("La Bella y la Bestia",34335);
        Libros siete=new Libros("Oliver Twist",6564545);
        Libros ocho=new Libros("La sombra en la Tormenta",2334543);
        Libros nueve=new Libros("La chica del tren",9686534);
        Libros diez=new Libros("Aprende programar en Java",234554);*/


        libros.add(new Libros("Caperucita",3545356));
        libros.add(new Libros("Cenicienta",7464566));
        libros.add(new Libros("Blancanieves",6745645));
        libros.add(new Libros("Los 3 cerditos",554545));
        libros.add(new Libros("Rapuncel",576455));
        libros.add(new Libros("La Bella y la Bestia",34335));
        libros.add(new Libros("Oliver Twist",6564545));
        libros.add(new Libros("La sombra en la Tormenta",2334543));
        libros.add(new Libros("La chica del tren",9686534));
        libros.add(new Libros("Un amor",356544));
        libros.add(new Libros("Biología molecular",234285));
        libros.add(new Libros("Química inorganica",2475654));
        libros.add(new Libros("Bioquimica de los seres vivos",28426464));
        libros.add(new Libros("La madre de Frankestein",239563));
        libros.add(new Libros("Lo que el viento se llevó",23456766));
        libros.add(new Libros("El código DAVINCI",26378454));
        libros.add(new Libros("Sira",6545556));
        libros.add(new Libros("EL juego del alma",56756656));
        libros.add(new Libros("El infinito en un junco",2344564));
        libros.add(new Libros("Crónica de una muerte anunciada",5655677));
        libros.add(new Libros("El paciente",465676));
        libros.add(new Libros("Alli donde nace el día",4567866));
        libros.add(new Libros("El gran error de la República",4566556));
        libros.add(new Libros("La ciudad de vapor",3567666));
        libros.add(new Libros("Un oceano para llegar a ti",478754));
        libros.add(new Libros("Nadie es normal",36565));


        System.out.println("#########################");
        System.out.println("Lista desordenada");
        System.out.println("#########################\n");
       for (Libros in:libros) {
            System.out.println(in);
        }

        System.out.println();
        System.out.println("#########################");
        System.out.println("Lista ordenada por titulo");
        System.out.println("#########################\n");
        Collections.sort ( libros, new ComparadorTitulo() );

        System.out.println("Lista desordenada");
        for (Libros in:libros) {
            System.out.println(in);
        }

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println ("TOTAL DE REGISTROS "+libros.size());
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

    }


    }



