public class Main {

    // E: vector de Estadisticas
    // S: muestra todos los datos del vector con toString() de todos los objetos
    public static void mostrar (Estadisticas v[]) {

        for (Estadisticas ele : v)
            System.out.println(ele.toString());
    }

    /* in: v -> vector de enteros
	   out: ordena ascendentemente (de menor a mayor por su valoración) el vector v por el método de la burbuja */
    public static void burbuja_asc (Estadisticas v[])
    {
        int i, j;	Estadisticas temp;
        int num_ele = v.length; // número de elementos del vector


        boolean ordenado = false;
        /* El bucle i controla el número de pasadas */
        for (i=1; i < num_ele && !ordenado; i++) {
            /* El bucle j controla el número de comparaciones entre elementos del vector */

            ordenado = true;
            // si no hay ningún intercambio estará ordenado el vector
            // y no hará falta realizar más pasadas para ordenarlo
            for (j=0 ; j < num_ele - i; j++)
                /*Comparar el elemento j con el j+1 y si están desordenados los intercambiamos*/
                if (v[j].valorar() > v[j+1].valorar()) {
                    temp = v[j];
                    v[j] = v[j+1];
                    v[j+1] = temp;
                    // ha habido un intercambio el vector no estaba ordenado
                    ordenado = false;
                } /* fin if */
        }
    } /* fin burbuja_asc */

    // E: vector de Estadisticas
    // S: muestra el nombre de todos los trabajadores, en que trabajan, y su valoracion
    public static void mostrar_valoracion (Estadisticas v[]) {
        String cad = "";
        System.out.println("\nValoración obtenida:");
        for (Estadisticas ele: v) {
            if (ele instanceof  Camion) {
                Camion aux_c = (Camion) ele;
                cad = aux_c.getCurrante().getNombre()+ ", camionero, valoración = ";
            }
            else if (ele instanceof Furgoneta) {
                Furgoneta aux_f = (Furgoneta) ele;
                cad = aux_f.getCurrante().getNombre()+ ", conductor de furgonetas, valoración = ";
            }
            else if (ele instanceof Venta_Tienda) {
                Venta_Tienda aux_v = (Venta_Tienda) ele;
                cad = aux_v.getCurrante().getNombre()+ ", vendedor en tienda, valoración = ";
            }

            System.out.println(cad + "Valoración = " + ele.valorar());

        }

    }

    // E: vector de Estadisticas
    // S: devuelve la suma de todos los costes
    public static double total_costes (Estadisticas v[]) {
        double total=0;

        for (Estadisticas ele: v) {
            total += ele.coste();
        }

        return total;
    }

    public static void main(String[] args) {

        Trabajador t1 = new Trabajador("Pepe", "12345678F", 1500);
        Trabajador t2 = new Trabajador("Luis", "34567812D", 2000);
        Trabajador t3 = new Trabajador("Juan", "22345678A", 1800);
        Trabajador t4 = new Trabajador("Maria", "11145678G", 1700);
        Trabajador t5 = new Trabajador("Juani", "43345673H", 2100);
        Trabajador t6 = new Trabajador("Esteban", "72345678F", 1800);
        Trabajador t7 = new Trabajador("Paco", "62345678V", 2300);


        Camion c1 = new Camion("Pegaso", "121212-DE",700, t2,8000);
        Camion c2 = new Camion("Avia", "5454521-SW", 1000, t3, 5000);
        Camion c3 = new Camion("Camión", "2454521-SF", 1000, t4, 5000);
        Furgoneta f1 = new Furgoneta("Ford Courier", "727727-BV",500, t1, 80);

        Furgoneta f2 =  new Furgoneta("Furgoneta", "12766-AZ",250, t7, 80);
        Venta_Tienda v1 = new Venta_Tienda("Supermercado", t5, 300);
        Venta_Tienda v2 = new Venta_Tienda("Bar",t6,150);

        Estadisticas v[] = {c1, c2, c3, f1, f2, v1, v2};

        mostrar (v);

        mostrar_valoracion (v);

        burbuja_asc(v);

        mostrar_valoracion(v);

        System.out.println("El total de los costes de la empresa son: " + total_costes(v) + " euros");


	// write your code here
    }
}
