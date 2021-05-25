package Tema10;


import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Ejercicio3 {

    public static int submenulinkedlist() {
        int opsubmenu;
        Scanner leer = new Scanner(System.in);
        int result;

        result=0;
        do {
            System.out.println("Seleciona el LinkedList sobre el que quieres trabajar:");
            System.out.println("1. LinkedList (uno)");
            System.out.println("2. LinkedList (dos)");
            opsubmenu = leer.nextInt();
        } while (opsubmenu != 1 && opsubmenu !=2);

        switch (opsubmenu) {
            case 1 :
                System.out.println("Has seleccionado el LinkedList 1");
                result = 1;

            case 2 :
                System.out.println("Has seleccionado el LinkedList 2");
                result = 2;

        }
        return result;
    }

    public static void imprime (LinkedList <Integer> lista){
        System.out.print("{");
        for ( int numeros : lista ){

            System.out.print(numeros+" ");
        }
        System.out.print("}\n");

    }

    public static void rellena (LinkedList <Integer> lista1, int[] v){
        for ( int numeros : v ){
            lista1.add (numeros);
        }

    }
    public static void pausa (){
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e ) {
        }
    }

    public static void rango (){
        Scanner str= new Scanner(System.in);
        System.out.println("Introduce un rango inicial");
        int inicial=str.nextInt();
        System.out.println("Introduce un rango final");
        int finaly=str.nextInt();
        System.out.println("Rango a eliminar ["+inicial+"-"+finaly+"]");
    }

    public static void menu(LinkedList <Integer> lista1,LinkedList <Integer> lista2){


        Scanner str = new Scanner(System.in);
        int num=0;
        int opcion;
        int array;
        int busq;
        str = new Scanner(System.in);
        boolean salir = false;
        do {
            System.out.println("");
            System.out.println("MENU");
            System.out.println("1. Añade al final una lista la otra fila");
            System.out.println("2. Muestra el contenido de las dos listas al derecho o al revés");
            System.out.println("3. Eliminar elementos de las lista, comprendidos en un rango");
            System.out.println("4. Inserta un elemento en cualquier de las dos listas");
            System.out.println("5. Calcula la media aritmeticas");
            System.out.println("0. Salir");
            System.out.println("Introduce una opcion");
            opcion=str.nextInt();


            switch (opcion){
                case 0:
                    System.out.println("Has decidido salir :(");
                    System.out.println("Saliendo...");
                    salir=true;
                    break;

                case 1:
                    if (submenulinkedlist()==1){
                        System.out.println("Vamos añadir el contenido del LinkedList1 en el LinkedList2");
                        for (int numero: lista1 ) {
                            lista2.add(numero);
                        }
                        imprime(lista2);
                        pausa();

                    }else{
                        System.out.println("Vamos añadir el contenido del LinkedList2 en el LinkedList1");
                        for (int numero: lista2 ) {
                            lista1.add(numero);
                        }
                        imprime(lista1);
                        pausa();


                    }
                    break;

                case 2:
                    System.out.println("Lista 1 al derecho");
                    imprime(lista1);
                    Collections.sort (lista1, Collections.reverseOrder() );
                    System.out.println("Lista 1 descendentemente");
                    imprime(lista1);
                    System.out.println("Lista 2 al derecho");
                    imprime(lista2);
                    Collections.sort (lista2, Collections.reverseOrder() );
                    System.out.println("Lista 2 descendentemente");
                    imprime(lista2);
                    pausa();
                    break;


                case 3:
                    if (submenulinkedlist()==1){
                        int tamano=lista1.size();
                        System.out.println("Introduce un rango inicial (Entre 0 y " +(tamano-1)+")");
                        int inicial=str.nextInt();
                        System.out.println("Introduce un rango final (Entre 0 y " +(tamano-1)+")");
                        int finaly=str.nextInt();
                        System.out.println("Rango a eliminar ["+inicial+"-"+finaly+"]");


                        for (int i=finaly; i>=inicial;i--){
                            lista1.remove(i);


                        }
                        imprime(lista1);
                        pausa();
                        break;



                    }else{
                            int tamano=lista2.size();
                            System.out.println("Introduce un rango inicial (Entre 0 y " +(tamano-1)+")");
                            int inicial=str.nextInt();
                            System.out.println("Introduce un rango final (Entre 0 y "+(tamano-1)+")");
                            int finaly=str.nextInt();
                            System.out.println("Rango a eliminar ["+inicial+"-"+finaly+"]");



                        for (int i=finaly; i>=inicial;i--){
                            lista2.remove(i);

                            }
                            imprime(lista2);
                            pausa();


                    }
                    break;

                case 4:
                    if (submenulinkedlist()==1){
                        System.out.println("Introduce un valor para rellenar");
                        int valor=str.nextInt();
                        lista1.add(valor);
                        System.out.println("Valor insertado: "+valor+" en la ultima posicion de LinkedList1");
                        imprime(lista1);
                        System.out.println("Total de elementos: "+lista1.size()+"\n");
                        pausa();


                    }else{
                        System.out.println("Introduce un valor para rellenar");
                        int valor=str.nextInt();
                        lista2.add(valor);
                        System.out.println("Valor insertado: "+valor+" en la ultima posicion de LinkedList2");
                        imprime(lista2);
                        System.out.println("Total de elementos: "+lista2.size()+"\n");
                        pausa();

                    }
                    break;

                case 5:
                    if (submenulinkedlist()==1){
                        int media=0;
                        System.out.println("Vamos a calcular la media del LinkedList1");
                        for (int i=0;i<lista1.size();i++){
                            media+=lista1.get(i);
                        }
                        System.out.println("La media del ArrayList1 es: "+media/lista1.size());
                        pausa();



                    }else{
                        int media=0;
                        System.out.println("Vamos a calcular la media del LinkedList1");
                        for (int i=0;i<lista2.size();i++){
                            media=media+lista2.get(i);
                        }
                        System.out.println("La media del ArrayList2 es: "+media/lista2.size());
                        pausa();

                    }
                    break;

            }

        }while (!salir);


    }


    public static void main(String[] args) {

        int [] numeros1= new int[]{2, 4, 9, 4, 2, 7, 4, 5, 2, 1};
        int [] numeros2= new int[]{33,12,66,47,85,67,28,29,20,34};
        LinkedList<Integer> lista1 = new LinkedList<>();
        LinkedList<Integer> lista2 = new LinkedList<>();

        rellena(lista1,numeros1);
        rellena(lista2,numeros2);
        imprime(lista1);
        System.out.println("");
        imprime(lista2);
        menu(lista1,lista2);
    }
}
