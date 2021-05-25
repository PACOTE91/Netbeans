package Tema12.Menu;/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//package javaapplication1;

/**
 *
 * @author ramon
 */
public class ordenacion {

    public static void burbuja (int [] v) {
        int tam = v.length;

        for (int i =1; i<tam; i++)
            for (int j=0; j<tam-i; j++)
                if (v[j] > v[j+1]) {
                    int aux = v[j];
                    v[j] = v[j+1];
                    v[j+1] = aux;
                }

    } // fin burbuja


}
