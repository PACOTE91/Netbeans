package Tema8;
public class Main {
    public static void menu(Ticket[] v) {
        int num;
        boolean salir = false;
        Ticket ticket=null;
        int num_tickets = 0;
        do {
            System.out.println("***MENU PRINCIPAL***");
            System.out.println("1.-Crear ticket.");
            System.out.println("2.-Ver ultimo ticket.");
            System.out.println("3.-Ver total ticket.");
            System.out.println("4.-Ver numero ticket.");
            System.out.println("5.-Salir.");
            num = teclado.leer_entero("Elije una opcion: \n");

            switch (num) {
                case 1:
                    ticket=menucrearticket();
                    if (ticket != null){
                        System.out.println(ticket);
                        System.out.println("Precio ticket = " +ticket.precio());
                        // guardar en el vector de tickets v el ticket creado
                        v[num_tickets] = ticket;
                        num_tickets ++;
                    }
                break;
                case 2:
                    if (ticket != null){

                        System.out.println(ticket);
                        System.out.println("Precio ticket: "+ticket.precio());
                    }else{
                        System.out.println("No has creado ningún ticket");
                    }

                    break;
                case 3:
                    System.out.println("El total de tickets es: "+ Ticket.getTotal_tickets());
                    break;
                case 4:
                    int numero;
                    int totaltickets=Ticket.getTotal_tickets();
                    System.out.println("El número total de tickets es: " + totaltickets);


                    if (totaltickets > 0){

                        do {
                            numero = teclado.leer_entero("Introduce nº de ticket entre  1  y " + totaltickets);
                        } while (numero <= 0 || numero > totaltickets);

                        System.out.println(v[totaltickets-1]);
                        System.out.println("Precio del ticket = " + v[totaltickets-1].precio());

                } else
                System.out.println("No se pueden visualizar ningún ticket");
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    salir=true;
                    break;
            }
        } while (!salir);


    }

    public static Ticket menucrearticket() {
        Ticket ticket=null;
        boolean salir=false;
        Producto_Turistico[] productos = new Producto_Turistico[4];
        productos[0]=null;
        productos[1]=null;
        productos[2]=null;
        productos[3]=null;


        String nombre = teclado.leer_cadena2("Introduce el nombre del cliente: ");
        String apellidos = teclado.leer_cadena2( "Introduce los apellidos del cliente: ");
        int DNI = teclado.leer_entero("Introduce el DNI del cliente: ");

        int num_adultos, num_ninos;

        do {
            num_adultos = teclado.leer_entero("Número de adultos: ");
        } while (!(num_adultos>0));

        // leer el número de niños mientras sea incorrecto
        do {
            num_ninos = teclado.leer_entero("Número de niños: ");
        } while (!(num_ninos>=0));
        Cliente cli = new Cliente(nombre, apellidos, DNI);



        int num;
        do {
            System.out.println("MENÚ CREAR TICKET\n");


            if (productos[0] != null)
                System.out.println("1.- Quitar visita Alcazaba");
            else
                System.out.println("1.- Añadir visita Alcazaba");

            if (productos[1] != null)
                System.out.println("2.- Quitar Tour desierto Tabernas");
            else
                System.out.println("2.- Añadir Tour desierto Tabernas ");

            if (productos[2] != null)
                System.out.println("3.- Quitar kayak Cabo de Gata");
            else
                System.out.println("3.- Añadir kayak Cabo de Gata ");

            if (productos[3] != null)
                System.out.println("4.- Quitar Espeleologia Sorbas ");
            else
                System.out.println("4.- Añadir Espeleologia Sorbas.");

            System.out.println("5.- Salir sin Guardar ticket");
            System.out.println("6.- Salir y Guardar ticket");
            num = teclado.leer_entero("Elije una opcion: \n");

            switch (num) {
                case 1 :
                    System.out.println("Añadir/Quitar visita a la Alcazaba");
                    productos[0] = contratar_visita_alcazaba(productos[0], num_adultos, num_ninos);

                case 2 :
                    System.out.println("Añadir/Quitar Tour Desierto Tabernas");
                    productos[1] = contratar_desierto_tabernas(productos[1], num_adultos, num_ninos);

                case 3 :
                    System.out.println("Añadir/Quitar Kayak Cabo de Gata");
                    productos[2] = contratar_kayak(productos[2], num_adultos, num_ninos);

                case 4 :
                    System.out.println("Añadir/Quitar Espeleología Sorbas");
                    productos[3] = contratar_espeleolofia(productos[3], num_adultos, num_ninos);

                case 5 :
                    salir = salir_singuardar();
                case 6 :
                    Producto_Turistico[] productos_aux = null;
                    productos_aux = salir_guardar(productos);
                    if (productos_aux != null) {
                        ticket = new Ticket(cli, productos_aux);
                        salir = true;
                    } else {
                        System.out.println("Has decidido no salir o no hay ningún producto turístico contratado");
                    }

            }


        } while (!salir);

        return ticket;
    }

    public static Producto_Turistico contratar_visita_alcazaba(Producto_Turistico prod, int num_adultos, int num_ninos) {
        char car;
        boolean guiada = false;
        if (prod!=null){
            do {
                car=teclado.leer_caracter("Ya has contratado esta visita, ¿deseas eliminar la visita? S/N");
            }while (!(car == 'S' || car == 's' || car == 'N' || car == 'n'));
                if (car=='S'|| car=='s'){
                    prod=null;
                }

        }
        if (prod==null){
            do {
                car=teclado.leer_caracter("Todavía no has contratado esta visita, ¿deseas contratar la visita? S/N");
            }while (!(car == 'S' || car == 's' || car == 'N' || car == 'n'));
            if (car=='S' || car=='s'){
                do {
                    car=teclado.leer_caracter("Visita guiada S/N");
                }while (!(car == 'S' || car == 's' || car == 'N' || car == 'n'));
                if (car=='S' || car=='s'){
                    guiada = true;

                }else{
                    guiada=false;
                }
            }
            Visita_Alcazaba alcazaba = new Visita_Alcazaba("Visita a la Alzaba de Almeria",num_adultos,num_ninos,guiada);
            System.out.println("El precio total es: "+alcazaba.precio());
            prod=alcazaba;

        }

        return prod;
    }

    public static Producto_Turistico contratar_desierto_tabernas(Producto_Turistico prod, int num_adultos, int num_ninos) {
        char car;
        boolean guiada = false;
        boolean todoterreno = false;
        if (prod!=null){
            do {
                car=teclado.leer_caracter("Ya has contratado esta visita, ¿deseas eliminar la visita? S/N");
            }while (!(car == 'S' || car == 's' || car == 'N' || car == 'n'));
            if (car=='S'|| car=='s'){
                prod=null;
            }

        }
        if (prod==null){
            do {
                car=teclado.leer_caracter("Todavía no has contratado esta visita, ¿deseas contratar la visita? S/N");
            }while (!(car == 'S' || car == 's' || car == 'N' || car == 'n'));
            if (car=='S' || car=='s'){
                do {
                    car=teclado.leer_caracter("Visita guiada S/N");
                }while (!(car == 'S' || car == 's' || car == 'N' || car == 'n'));
                if (car=='S' || car=='s'){
                    guiada = true;

                }else{
                    guiada=false;
                }
                do {
                    car=teclado.leer_caracter("Alquilar Todoterreno 4x4 S/N");
                }while (!(car == 'S' || car == 's' || car == 'N' || car == 'n'));
                if (car=='S' || car=='s'){
                    todoterreno = true;

                }else{
                    todoterreno=false;
                }
            }
            Tour_Desierto_Tabernas tabernas = new Tour_Desierto_Tabernas("Visita al desierto de Tabernas",num_adultos,num_ninos,guiada,todoterreno);
            System.out.println("El precio total es: "+tabernas.precio());
            prod=tabernas;

        }


        return prod;
    }

    public static Producto_Turistico contratar_kayak(Producto_Turistico prod, int num_adultos, int num_ninos) {
        char car;
        boolean principiantes = false;
        boolean snorket = false;
        if (prod!=null){
            do {
                car=teclado.leer_caracter("Ya has contratado esta experiencia, ¿deseas eliminar la experiencia? S/N");
            }while (!(car == 'S' || car == 's' || car == 'N' || car == 'n'));
            if (car=='S'|| car=='s'){
                prod=null;
            }

        }
        if (prod==null){
            do {
                car=teclado.leer_caracter("Todavía no has contratado esta experiencia, ¿deseas contratar la experiencia? S/N");
            }while (!(car == 'S' || car == 's' || car == 'N' || car == 'n'));
            if (car=='S' || car=='s'){
                do {
                    car=teclado.leer_caracter("Eres principiante S/N");
                }while (!(car == 'S' || car == 's' || car == 'N' || car == 'n'));
                if (car=='S' || car=='s'){
                    principiantes = true;

                }else{
                    principiantes=false;
                }
                do {
                    car=teclado.leer_caracter("Deseas realizar snorkel S/N");
                }while (!(car == 'S' || car == 's' || car == 'N' || car == 'n'));
                if (car=='S' || car=='s'){
                    snorket = true;

                }else{
                    snorket=false;
                }
            }
            Kayak_Cabo_Gata cabogata = new Kayak_Cabo_Gata("Experiencia en el Cabo de Gata",num_adultos,num_ninos,principiantes,snorket);
            System.out.println("El precio total es: "+cabogata.precio());
            prod=cabogata;

        }

        return prod;
    }

    public static Producto_Turistico contratar_espeleolofia(Producto_Turistico prod, int num_adultos, int num_ninos) {
        char car;
        boolean principiantes = false;
        boolean alquiler = false;
        if (prod!=null){
            do {
                car=teclado.leer_caracter("Ya has contratado esta experiencia, ¿deseas eliminar la experiencia? S/N");
            }while (!(car == 'S' || car == 's' || car == 'N' || car == 'n'));
            if (car=='S'|| car=='s'){
                prod=null;
            }

        }
        if (prod==null){
            do {
                car=teclado.leer_caracter("Todavía no has contratado esta experiencia, ¿deseas contratar la experiencia? S/N");
            }while (!(car == 'S' || car == 's' || car == 'N' || car == 'n'));
            if (car=='S' || car=='s'){
                do {
                    car=teclado.leer_caracter("Eres principiante S/N");
                }while (!(car == 'S' || car == 's' || car == 'N' || car == 'n'));
                if (car=='S' || car=='s'){
                    principiantes = true;

                }else{
                    principiantes=false;
                }
                do {
                    car=teclado.leer_caracter("Deseas alquilar equipamiento S/N");
                }while (!(car == 'S' || car == 's' || car == 'N' || car == 'n'));
                if (car=='S' || car=='s'){
                    alquiler = true;

                }else{
                    alquiler=false;
                }
            }
            Espeologia_Sorbas espeleologia = new Espeologia_Sorbas("Experiencia en las Cuevas de Sorbas",num_adultos,num_ninos,principiantes,alquiler);
            System.out.println("El precio total es: "+espeleologia.precio());
            prod=espeleologia;

        }

        return prod;
    }


    public static Producto_Turistico[] salir_guardar(Producto_Turistico[] v) {
        Producto_Turistico[] v_aux = null; // vector auxiliar de productos turisticos

        char opcion;
        int num_productos = 0;

        // calcular cuantos productos turisticos hay contratados (son != null)
        if (v != null)
            for (Producto_Turistico producto_turistico : v)
                if (producto_turistico != null) {
                    num_productos++;
                }


        // comprobar si hay algún producto turistico en el ticket que guardar
        if (num_productos == 0){
            System.out.println("Error!! no has contratado ningún producto turístico.");
            System.out.println("No se puede guardar el ticket y salir");
            v_aux = null;
        } else{
            // Quiere salir guardando
            // Pregunta para si quiere hacerlo
            do {
                opcion = teclado.leer_caracter("Deseas salir y guardar el ticket S/N: ");
                opcion = Character.toUpperCase(opcion);
            } while (opcion !='S' &&opcion !='N' );

            if (opcion == 'S') {
                // reorganizamos los productos del vector v para que estén
                // seguidos todos los que no son null

                // Crear un vector de productos auxiliar del tamaño
                // de los productos que hay que no son null => num_productos
                if (num_productos > 0) {
                    // creamos un vector del tamaño de num_productos
                    // tamaño = (nº de productos turisticos contratados)
                    v_aux = new Producto_Turistico[num_productos];

                    // num sera el índice del vector v_aux donde guardaremos
                    // el producto contratado != null de vector v
                    int num = 0;

                    System.out.println("\n Número de productos contratados = " + num_productos);

                    // copiar los productos del vector v que existan (no sean null) en v_aux
                    for (Producto_Turistico producto_turistico : v) {
                        if (producto_turistico != null) {
                            // guardamos en la posición num del vector v_aux el elemento i de v
                            v_aux[num] = producto_turistico;
                            num++;
                        }
                    }

                } else {
                    System.out.println("Error grave, no debería ser negativo el nº de productos");
                    v_aux = null;
                }

            } else
                v_aux = null;
        }

        return v_aux;

    }


    public static boolean salir_singuardar() {
        char car;
        boolean salir;
        do {
            car=teclado.leer_caracter("¿Deseas salir sin guardar el ticket? S/N");
        }while (!(car == 'S' || car == 's' || car == 'N' || car == 'n'));

        if (car=='S' || car=='s'){
            salir=true;
        }else{
            salir=false;
        }

        return salir;
    }

    public static void main(String[] args) {
        Ticket[] v = new Ticket[100];
        menu(v);
    }
}
