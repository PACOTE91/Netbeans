package Tema10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Ejercicio2 {


    public static void pausa() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }

    public static int submenu() {
        int opsubmenu;
        Scanner leer = new Scanner(System.in);
        int result = 0;

        do {
            System.out.println("Seleciona tipo de array sobre el que quieres trabajar:");
            System.out.println("1. ArrayList (uno)");
            System.out.println("2. ArrayList (dos)");
            System.out.println("3. Vector de enteros");
            opsubmenu = leer.nextInt();
        } while (opsubmenu != 1 && opsubmenu != 2 && opsubmenu != 3);

        switch (opsubmenu) {
            case 1 :
                System.out.println("Has seleccionado el ArrayList 1");
                result = 1;

            case 2 :
                System.out.println("Has seleccionado el ArrayList 2");
                result = 2;

        case 3 :
                System.out.println("Vector de enteros seleccionado");
                result = 3;

        }


        return result;
    }

    public static void imprimevector(int[] v) {
        System.out.println("");
        System.out.println("##########################");
        System.out.println("····VECTOR DE ENTEROS·····");
        System.out.println("##########################");
        System.out.print("{ ");


        for (int numero : v) {

            System.out.print(numero + " ");
        }

        System.out.print(" }");
    }

    public static void imprimearraylist(ArrayList<Integer> alist) {
        System.out.println("");
        System.out.print("{ ");
        for (int numero : alist) {
            System.out.print(numero + " ");
        }
        System.out.print(" }");


    }

    public static int submenuarraylists() {
        int opsubmenu;
        Scanner leer = new Scanner(System.in);
        int result;
        result = 0;
        do {
            System.out.println("Seleciona el ArrayList sobre el que quieres trabajar:");
            System.out.println("1. ArrayList (uno)");
            System.out.println("2. ArrayList (dos)");
            opsubmenu = leer.nextInt();
        } while (opsubmenu != 1 && opsubmenu != 2);

        switch (opsubmenu) {
            case 1 :
                System.out.println("ArrayList 1 seleccionado");
                result = 1;

            case 2 :
                System.out.println("ArrayList 2 seleccionado");
                result = 2;

        }
        return result;
    }


    public static void menu(int[] venteros, ArrayList<Integer> num1, ArrayList<Integer> num2) {

        Scanner str = new Scanner(System.in);

        int aleaorio;
        int varsubmenu;
        int num = 0;
        int opcion;
        boolean salir = false;
        do {
            System.out.println();
            System.out.println("##################################################");
            System.out.println("::::::::::::::::::::::MENU::::::::::::::::::::::::");
            System.out.println("##################################################");
            System.out.println("1. Rellena Aleatorios");
            System.out.println("2. Rellenar con unico numero");
            System.out.println("3. Ordena ascendentemente o descendentemente");
            System.out.println("4. Muestra array");
            System.out.println("5. Borrar numero del array");
            System.out.println("6. Realiza busqueda binaria");
            System.out.println("7. Ordena al azar");
            System.out.println("8. Invierte el orden de los elementos");
            System.out.println("9. Copia el contenido de un ArrayList en otro");
            System.out.println("10. Invierte el orden de los elementos");
            System.out.println("11. Añadir al final del ArrayList, el contenido del Array normal");
            System.out.println("12. Invierte el orden de los elementos");
            System.out.println("13. Comprueba si los dos ArrayList tienen números enteros en común ");
            System.out.println("0. Salir");
            System.out.println("Introduce una opcion");
            opcion = str.nextInt();

            switch (opcion) {

                case 0:
                    salir = true;
                    break;
                case 1:
                    int var=submenu();
                    if (var == 1) {
                        for (int i = 0; i < 50; i++) {
                            aleaorio = (int) (Math.random() * 10);
                            num1.add(i, aleaorio);
                        }
                        imprimearraylist(num1);
                        pausa();
                        break;
                    } else if (var == 2) {
                        for (int i = 0; i < 50; i++) {
                            aleaorio = (int) (Math.random() * 10);
                            num2.add(i, aleaorio);

                        }
                        imprimearraylist(num2);
                        pausa();
                        break;


                    } else if (var == 3) {
                        for (int i = 0; i < venteros.length; i++) {
                            venteros[i] = (int) (Math.random() * 10);
                        }
                        imprimevector(venteros);
                        pausa();
                    }

                    break;


                case 2:
                    var=submenu();
                    System.out.println("Introduce un numero para rellenar");
                    int rellena = str.nextInt();

                    if (var == 1) {
                        for (int i = 0; i < 50; i++) {
                            num1.add(i, rellena);
                        }
                        imprimearraylist(num1);
                        pausa();

                    }
                    if (var == 2) {
                        for (int i = 0; i < 50; i++) {
                            num2.add(i, rellena);

                        }
                        imprimearraylist(num2);
                        pausa();

                    }
                    if (var == 3) {
                        for (int i = 0; i < venteros.length; i++) {
                            Arrays.fill(venteros, rellena);
                        }
                        pausa();
                    }
                    break;
                case 3:

                case 4:
                        System.out.println("ARRAYLIST1");
                        imprimearraylist(num1);
                        pausa();
                        System.out.println("\nARRAYLIST2");
                        imprimearraylist(num2);
                        pausa();
                        imprimevector(venteros);
                        pausa();
                        break;



                case 5:
                    System.out.println("Introduce valor numerico a buscar y eliminar");
                    int binary;
                    int clave = str.nextInt();
                    if (submenuarraylists() == 1) {
                        do {
                            binary = Collections.binarySearch(num1, clave);

                            if (binary >= 0) {
                                System.out.printf("Se encontro en el indice y fue eliminado %d\n", clave);
                                num1.remove(binary);
                                pausa();
                            } else {
                                System.out.printf("No se encontro el numero y no hay nada que borrar:(%d)\n", clave);
                                pausa();
                            }


                        } while (binary >= 0);

                    } else {
                        do {
                            binary = Collections.binarySearch(num2, clave);

                            if (binary >= 0) {
                                System.out.printf("Se encontro en el indice y fue eliminado %d\n", clave);
                                num2.remove(binary);
                                pausa();
                            } else {
                                System.out.printf("No se encontro el numero y no hay nada que borrar:(%d)\n", clave);
                                pausa();
                            }

                        } while (binary >= 0);

                    }
                    break;

                case 6:
                    int submenu = submenuarraylists();
                    System.out.println("Introduce valor numerico a buscar");
                    int valorabuscar = str.nextInt();
                    if (submenu == 1) {
                        int resultado;
                        System.out.printf("\nBuscando: %s\n", valorabuscar);
                        // búsqueda binaria sobre la lista ordenada
                        resultado = Collections.binarySearch(num1, valorabuscar);

                        if (resultado >= 0)
                            System.out.printf("Se encontro en el indice %d\n", resultado);
                        else
                            System.out.printf("No se encontro el numero:(%d)\n", resultado);
                        pausa();

                    } else {
                        int resultado;
                        System.out.printf("\nBuscando: %s\n", valorabuscar);
                        resultado = Collections.binarySearch(num2, valorabuscar);
                        if (resultado >= 0)
                            System.out.printf("Se encontro en el indice %d\n", resultado);
                        else
                            System.out.printf("No se encontro el numero:(%d)\n ", resultado);
                        pausa();

                    }
                    break;

                case 7:
                    if (submenuarraylists() == 1) {
                        Collections.shuffle(num1);
                        for (int numero : num1) {
                            System.out.printf("%s ", numero);
                        }
                        pausa();


                    } else {
                        Collections.shuffle(num2);
                        for (int numero : num2) {
                            System.out.printf("%s ", numero);
                        }
                        pausa();
                    }
                    break;

                case 8:
                    if (submenuarraylists() == 1) {
                        Collections.sort(num1, Collections.reverseOrder());
                        for (int numero : num1) {
                            System.out.printf("%s ", numero);
                        }
                        pausa();


                    } else {
                        Collections.sort(num2, Collections.reverseOrder());
                        for (int numero : num2) {
                            System.out.printf("%s ", numero);
                        }
                        pausa();
                    }
                    break;

                case 9:
                    if (submenuarraylists() == 1) {
                        Collections.copy(num1, num2);
                        System.out.println("\nDespues de copy: ");
                        for (int numero : num1) {
                            System.out.printf("%s ", numero);
                        }
                        pausa();


                    } else {
                        Collections.copy(num2, num1);
                        System.out.println("\nDespues de copy: ");
                        for (int numero : num1) {
                            System.out.printf("%s ", numero);
                        }
                        pausa();

                    }
                    break;

                case 10:
                    if (submenuarraylists() == 1) {
                        // Obtener el máximo de la lista
                        System.out.printf("\nMax: %s", Collections.max(num1));
                        // Obtener el mínimo de la lista
                        System.out.printf(" Min: %s\n", Collections.min(num1));
                        pausa();

                    } else {
                        // Obtener el máximo de la lista
                        System.out.printf("\nMax: %s", Collections.max(num2));
                        // Obtener el mínimo de la lista
                        System.out.printf(" Min: %s\n", Collections.min(num2));
                        pausa();

                    }
                    break;

                case 11:
                    if (submenuarraylists() == 1) {
                        for (int numero : num1) //num1 es el ArrayList1
                            System.out.printf("%s ", numero);
                        Collections.addAll(num1, num); //num es el vector de enteros
                        System.out.println("\n\nDespues de addAll, el vector contiene: ");
                        for (int numero : num1) {
                            System.out.printf("%s ", numero);
                        }
                        pausa();

                    } else {
                        for (int numero : num2) //num2 es el ArrayList2
                            System.out.printf("%s ", numero);
                        Collections.addAll(num2, num);//num es el vector de enteros
                        System.out.println("\n\nDespues de addAll, el vector contiene: ");
                        for (int numero : num2) {
                            System.out.printf("%s ", numero);
                        }
                        pausa();
                    }
                    break;

                case 12:
                    if (submenuarraylists() == 1) {
                        System.out.println("Numero a comprobar repeticiones");
                        int numero = str.nextInt();
                        for (int n : num1)
                            System.out.printf("%s ", n);
                        // obtiene la frecuencia de "rojo" en el vector
                        int frecuencia = Collections.frequency(num1, numero);
                        System.out.printf("\n\nFrecuencia de " + numero + " en el ArrayList1: %d\n", frecuencia);
                        pausa();

                    } else {
                        System.out.println("Numero a comprobar repeticiones");
                        int numero = str.nextInt();
                        for (int n : num2)
                            System.out.printf("%s ", n);
                        int frecuencia = Collections.frequency(num2, numero);
                        System.out.printf("\n\nFrecuencia de " + numero + " en el ArrayList2: %d\n", frecuencia);
                        pausa();

                    }
                    break;

                case 13:
                    boolean desunion = Collections.disjoint(num1, num2);
                    if (desunion)
                        System.out.println("ArrayList1 y ArrayList2 no tienen elementos en comun");
                    else
                        System.out.println("ArrayList1 y ArrayList2 tienen elementos en comun");

                    pausa();
                    break;

            }
        } while (!salir);

    }

    public static void main(String[] args) {
        ArrayList<Integer> num1 = new ArrayList<>(50);
        ArrayList<Integer> num2 = new ArrayList<>(50);
        int[] ent = new int[50];


        menu(ent, num1, num2);

    }
}

