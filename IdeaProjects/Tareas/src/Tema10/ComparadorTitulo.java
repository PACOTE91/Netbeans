package Tema10;

import java.util.Comparator;

public class ComparadorTitulo implements Comparator <Libros> {

        public int compare ( Libros titulo1, Libros titulo2 ){
                return titulo1.getTitulo().compareToIgnoreCase(titulo2.getTitulo());
            }



}
