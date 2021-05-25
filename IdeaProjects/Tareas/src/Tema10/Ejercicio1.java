package Tema10;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio1 {

    static Scanner str = new Scanner(System.in);


    public static void rellenavectoraleatorio(int v[]){
        for (int i=0; i<v.length; i++){
            v[i]= (int) (Math.random()*10);
        }

    }
    public static void rellenavectormismovalor(int v[], int num){
        for (int i=0; i<v.length; i++){
            Arrays.fill(v,num);
        }


    }

    public static void imprimir(int v[])
    {
        System.out.println( "Mostrando vector \n" );

        System.out.print("{");
        for ( int num : v ){
            System.out.print(num);}
            System.out.print("}\n\n");
    } // fin del método imprimirArreglos

    public static void ordenaarray(int v[]) {
        Arrays.sort(v);
    }


    public static void copiar(int v[], int vdest[]) {
       System.arraycopy(v,0,vdest,0,v.length);
    }

    public static int buscarUnInt(int v[], int valor)
    {
        return Arrays.binarySearch ( v, valor );
    }


    public static void comparador(int v[], int vcomp[])
    {
        boolean iguales = Arrays.equals ( v, vcomp );

        if (iguales == true)
            System.out.printf( "Ambos son iguales\n");
        else
            System.out.printf( "No son iguales\n");


    }

        public static void menu(int v [],int vcomp[]){

        int num=0;
        int opcion;
        int array;
        int busq;
            boolean salir = false;
        do {
            System.out.println("MENU");
            System.out.println("1. Rellena Aleatorios");
            System.out.println("2. Rellenar con unico numero");
            System.out.println("3. Ordena ascendentemente");
            System.out.println("4. Muestra array");
            System.out.println("5. Copia el array");
            System.out.println("6. Busqueda binaria");
            System.out.println("7. Compara igualdad");
            System.out.println("0. Salir");
            System.out.println("Introduce una opcion");
            opcion=str.nextInt();


            switch (opcion){
                case 0:
                    salir=true;
                    break;

                case 1:
                    do{
                        System.out.println("Elije un array (1 o 2)");
                        array=str.nextInt();
                    }while (array!=1 && array!=2);

                    if (array==1){
                        rellenavectoraleatorio(v);

                    }else{
                        rellenavectoraleatorio(vcomp);

                    }
                    break;


                case 2:
                    int rel;
                    do{
                        System.out.println("Elije un array (1 o 2)");
                        array=str.nextInt();
                    }while (array!=1 && array!=2);

                    do{
                        System.out.println("Introduce un unico valor para rellenar el vector");
                        rel=str.nextInt();
                    }while (rel >100 && rel <-100);
                    if (array==1){
                        rellenavectormismovalor(v,rel);

                    }else{
                        rellenavectormismovalor(vcomp,rel);
                    }
                    break;
                case 3:
                    do{
                        System.out.println("Elije un array (1 o 2)");
                        array=str.nextInt();
                    }while (array!=1 && array!=2);

                    if (array==1){
                        ordenaarray(v);
                    }else{
                        ordenaarray(vcomp);

                    }
                    break;
                case 4:
                    do{
                        System.out.println("Elije un array (1, 2 o 3 (para mostrar ambos))");
                        array=str.nextInt();
                    }while (array!=1 && array!=2 && array!=3);

                    if (array==1){
                        imprimir(v);

                    }else{
                        if (array==2){
                        imprimir(vcomp);
                        }else{
                            imprimir(v);
                            imprimir(vcomp);
                        }

                    }
                    break;
                case 5:
                    do{
                        System.out.println("Elije un array (1 o 2)");
                        array=str.nextInt();
                    }while (array!=1 && array!=2);

                    if (array==1){
                        copiar(v, vcomp);

                    }else{
                        copiar(vcomp,v);

                    }
                    break;
                case 6:
                    do{
                        System.out.println("Elije un array (1 o 2)");
                        array=str.nextInt();
                    }while (array!=1 && array!=2);

                    do{
                        System.out.println("Introduce un valor para buscar en el vector (-100 y 100");
                        busq=str.nextInt();
                    }while (busq >100 && busq <-100);

                    if (array==1){
                        buscarUnInt(v,busq);

                    }else{
                        buscarUnInt(vcomp,busq);

                    }
                    break;
                case 7:
                    comparador(v,vcomp);
                    break;

            }

        }while (!salir);


    }





    public static void main(String[] args) {
         int[] v1 = new int[50];
         int[] v2 = new int[50];
         //v1 va a ser el vector1 y v2 el vector2
         //cuando se pida elegir un vector
         menu(v1,v2);







    }
}
