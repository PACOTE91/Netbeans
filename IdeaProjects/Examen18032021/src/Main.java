// package com.company;

import java.io.*;

public class Main {

    /* E: v => vector con los integrantes de la selección de Basket
       S: muestra por pantalla la media aritmética de la valoracion que se  obtiene
          de cada integrante de la seleccion con el método valorar()
     */
    public static void media_valoracion(Seleccion_Basket v[]) {
        double media=0;
        
        for (int i=0;i<v.length;i++){
            if (v[i] instanceof Jugador_Basket){
                media=v[i].valorar();
                System.out.println("El jugador: "+v[i].toString()+" Tiene una media de puntos de:" +media);
            }
            if (v[i] instanceof Entrenador_Basket){
                media=v[i].valorar();
                System.out.println("El entrenador: "+v[i].toString()+" Tiene una media de puntos de:" +media);
            }
        }
        
        
    }

    /* E: v => vector con los integrantes de la selección de Basket
       S: nada, ordena el vector v por el método de burbuja ascendentemente de menor a mayor
          por la valoracion que se  obtiene de cada integrante de la seleccion
          con el método valorar()

          Después de ordenar el vector
          muestra por pantalla el vector ordenado (usa el toString()
          para mostrar la información de cada elemento del vector) y
          usa el método valorar() para mostrar su valoracion
     */
    public static void burbuja (Seleccion_Basket v[]) {
        int i;
        int j;
        Seleccion_Basket aux;
        int n_elem = v.length;
        boolean ordenado = false;

        for (i = 1; i < n_elem && !ordenado; i++) {
            ordenado = true;
            for (j = 0; j < n_elem - i; j++)
                if (v[j].valorar() > v[j + 1].valorar()) {
                    aux = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = aux;
                    ordenado = false;
                }
        }

        System.out.println("\n");
        System.out.println("######VECTOR ORDENADO######");
        for (i=0;i< v.length;i++){
            System.out.println(v[i].toString());
            System.out.println("Tiene una valoración");
            System.out.println(v[i].valorar());
        }
        
    }

    /* E: v => vector con los Jugadores de Basket
          dorsal => nombre del dorsal del jugador de basket a buscar
       S: nada
          muestra si no encuentra un jugador con ese dorsal en el vector
          si lo encuentra muestra la posición donde  encuentra el jugador
          con ese dorsal y muestra el nombre y apellidos del jugador encontrado
       nota: la búsqueda que se realiza es de forma secuencial
     */
    public static void busqueda_secuencial (Jugador_Basket v[], int dorsal) {
            int i;
            int pos = -1;
            boolean encontrado = false;

            /* !encontrado es igual que encontrado == false */
            for (i=0; i < v.length && !encontrado; i++)
                if (v[i].getDorsal() == dorsal) {
                    // se ha encontrado el elemento ele en el vector
                    encontrado = true;
                    pos = i;
                }

            if (pos==-1){
                System.out.println("Jugador no encontrado");
            }else{
                System.out.println("Jugador encontrado! Corresponde con: ");
                System.out.println(v[i].getNombre()+" "+v[i].getApellidos());
            }

        } /* fin buscar_secuencial */

        





    /* E: nomFich => nombre del fichero
          v => vector con los jugadores de Basket
       S: Guarda en el fichero de texto nomFich los jugadores de basket con toString
          que han anotado más de 110 puntos
          El fichero se creará mediante la clase PrintWriter
       Nota: Se proporciona parte del código, sustituye ???? por tú código 
     */
    public static void escribir_fichero (String nomFich, Jugador_Basket v[]) throws IOException {
        PrintWriter salida = null;
        try {
            // crea el flujo de salida asociado al nombre del fichero nomFich
            // Descomenta la siguiente línea y pon bien el código
            salida = new PrintWriter(nomFich);
            System.out.println("Escribiendo en el fichero jugadores con mas de 120 puntos: " +nomFich);
            // escribe los jugadores de basket que han anotado más de 110 puntos
            // del vector v en el fichero
            for (int i=0;i< v.length;i++){
                if (v[i].getPuntos_anotados()>110){
                    salida.println(v[i].toString());
                }
            }

        } catch (FileNotFoundException ex) {
            // El fichero no se puede crear
            System.out.println ("\n El fichero no se puede crear " + ex);

        } finally {
            if (salida != null)
                salida.close();
        }
    } // fin escribir_fichero


    public static void main(String[] args) {
        // Crear 7 jugadores de baloncesto
        Jugador_Basket j1 = new Jugador_Basket("Mark", "Gasol", 27, 2, 140, 22, 12, "Pivot");
        Jugador_Basket j2 = new Jugador_Basket("Sergio", "Llul", 30, 8, 100, 5, 20, "Alero");
        Jugador_Basket j3 = new Jugador_Basket("Ricky", "Rubio", 31, 9, 120, 10, 14, "Base");
        Jugador_Basket j4 = new Jugador_Basket("Rudy", "Fernández", 33, 10, 115, 12, 11, "Alero");
        Jugador_Basket j5 = new Jugador_Basket("Victor", "Clavel", 28, 1, 80, 4, 12, "Escolta");
        Jugador_Basket j6 = new Jugador_Basket("Pau", "Gasol", 34, 7, 200, 20, 12, "Pivot");
        Jugador_Basket j7 = new Jugador_Basket("Javier", "Beirán", 25, 3, 70, 4, 22, "Escolta");

        // Crear 1 entrenador
        Entrenador_Basket e1 = new Entrenador_Basket("Sergio", "Scariolo", 59, 100, 20);

        // Crear vector del tipo Seleccion_Basket con los 7 jugadores y el entrenador
        Seleccion_Basket v[] = {j1, j2, j3, j4, j5, j6, j7, e1};

        // Crear vector del tipo Jugador_Basket con los 7 jugadores
        Jugador_Basket jugadores [] = {j1, j2, j3, j4, j5, j6, j7};

        // muestra por pantalla la media aritmética de la valoracion que se  obtiene
        // de cada integrante de la seleccion, llama al método media_valoracion()
        media_valoracion(v);

        /* ordena el vector v por el método de burbuja ascendentemente de menor a mayor
          por la valoracion que se  obtiene de cada integrante de la seleccion
          llama al método burbuja() */
		burbuja(v);

        /* Buscar a un jugador por su dorsal, por ejemplo el dorsal número 10 */
        // llama al método busqueda_secuencial()
        busqueda_secuencial(jugadores,10);

        try {
            // escribe en el fichero seleccion.txt
            // todos los jugadores de la seleccion del vector jugadores
            // que han anotado más de 110 ptos
            escribir_fichero("Jugadores.txt",jugadores);
        } catch (IOException ex) {
            System.out.println ("\n Error de E/S " + ex);
        }


    } // fin main()
}

/* Posible ejecución del programa

La media de la valoración es: 136.04166666666666

El vector ordenado por la valoración es:

Seleccion_Basket{nombre='Sergio', apellidos='Scariolo', edad=59} .Entrenador_Basket{partidos_ganados=100, partidos_perdidos=20}  Valoración = 83.33333333333334
Seleccion_Basket{nombre='Victor', apellidos='Clavel', edad=28} .Jugador_Basket{dorsal=1, puntos_anotados=80, rebotes=4, asistencias=12, puesto='Escolta'}  Valoración = 96.0
Seleccion_Basket{nombre='Javier', apellidos='Beirán', edad=25} .Jugador_Basket{dorsal=3, puntos_anotados=70, rebotes=4, asistencias=22, puesto='Escolta'}  Valoración = 96.0
Seleccion_Basket{nombre='Sergio', apellidos='Llul', edad=30} .Jugador_Basket{dorsal=8, puntos_anotados=100, rebotes=5, asistencias=20, puesto='Alero'}  Valoración = 125.0
Seleccion_Basket{nombre='Rudy', apellidos='Fernández', edad=33} .Jugador_Basket{dorsal=10, puntos_anotados=115, rebotes=12, asistencias=11, puesto='Alero'}  Valoración = 138.0
Seleccion_Basket{nombre='Ricky', apellidos='Rubio', edad=31} .Jugador_Basket{dorsal=9, puntos_anotados=120, rebotes=10, asistencias=14, puesto='Base'}  Valoración = 144.0
Seleccion_Basket{nombre='Mark', apellidos='Gasol', edad=27} .Jugador_Basket{dorsal=2, puntos_anotados=140, rebotes=22, asistencias=12, puesto='Pivot'}  Valoración = 174.0
Seleccion_Basket{nombre='Pau', apellidos='Gasol', edad=34} .Jugador_Basket{dorsal=7, puntos_anotados=200, rebotes=20, asistencias=12, puesto='Pivot'}  Valoración = 232.0

Encontrado jugador con dorsal: 10, en la posicion: 4
Nombre y Apellidos: Rudy, Fernández

Escribiendo en el fichero: seleccion.txt

Process finished with exit code 0
 */
