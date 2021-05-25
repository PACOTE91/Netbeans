
package Tema9.Ejercicio10;

import java.io.*;

/**
* Tabla de libros persistente almacenada en
* un fichero de acceso aleatorio
*/
public class TablaLibros {
    // atributo => fichero de acceso aleatorio
    private RandomAccessFile fich;
    
    /**
    * Constructor al que se le pasa el nombre del fichero
    * => nombreFichero se abre para lectura y escritura 
    * * Nota: lanza FileNotFoundException para controlar que el fichero se pueda crear */    
    public TablaLibros (String nombreFichero) throws FileNotFoundException {
        fich = new RandomAccessFile(nombreFichero,"rw");
    }
    
    /**
     * E: indice => 0 es el primer elemento de la tabla persistente (fichero acceso aleatorio)
     *           => 1 es el segundo elemento, etc...
     * S: devuelve el elemento de la tabla que esta en "indice" 
     * Nota: Lanza IOException o EOFException para controlar errores al posicionarse */ 
    public Libro obten (int indice) throws IOException, EOFException {        
        long pos = indice*Libro.tamañoEnBytes;
        
        // posiciona el contador de lectura/escritura
        fich.seek(pos);
        
        // lee y retorna el libro
        return Libro.leeDeFichero(fich);
    }
    
    /* E: indice => indice de la tabla persistente 
     *     l => objeto libro a escribir
     * S: Escribe un libro en la posición "indice" de la tabla 
     * Nota: Lanza la excepción IOException para controlar errores al posicionarse  
     * y escribir en el fichero */ 
    public void almacena (int indice, Libro l) throws IOException {        
        long pos = indice*Libro.tamañoEnBytes;
        
        // posiciona el contador de lectura/escritura
        fich.seek(pos);
        
        // escribe el libro
        l.escribeEnFichero(fich);
    }
    
    /*---------*/
    /* EJER 10 */
    /*---------*/
    
   /* E: nada
    * S: Borra un libro en la posición "indice" de la tabla 
    * Nota: Lanza la excepción IOException para controlar errores al posicionarse  
    * y escribir en el fichero */ 
    public void borrar () throws IOException {    
               
        System.out.println("\nBorrando un libro en el fichero o tabla persistente:");
        
        // se almacena en regs el número de registros para evitar llamar a la función num_registros más de una vez
        // y así hacer el código más eficiente
        long regs = num_registros();
        
        // hay que controlar el número de registros
        // por si no hay libros que borrar
        if (regs == 0) {
            System.out.println("\nERROR no hay ningún libro que borrar!!");
        }
        else {                     
            int indice = 0; // poner un indice correcto
            
            // Leer la posición a borrar mientras sea incorrecta
            do {
                if (indice < 0 || indice >= regs)
                   System.out.println("\nÍndice o posición del libro a borrar incorrecta: ");

                indice = teclado.leer_entero("Posición del libro a borrar (0 => primera,  " + (regs-1) + " => ultima): ");        
            } while (indice < 0 || indice >= regs);

            // para borrar se crea un objeto libro sin datos
            Libro lib = new Libro ("",0,0);
            // se escribe el libro vacío en la posición índice
            almacena (indice, lib);
        }
    } // fin borrar
    
    
    /*---------*/
    /* EJER 10 */
    /*---------*/
    
    /* E: nada
     * S: intenta modificar un libro de la tabla 
     * Nota: Lanza la excepción IOException para controlar errores al posicionarse  
     * y escribir en el fichero */
    public void modificar () throws IOException {
        
         System.out.println("\nModificando un libro en el fichero o tabla persistente:");
        
        // se almacena en regs el número de registros para evitar llamar a la función num_registros más de una vez
        // y así hacer el código más eficiente
        long regs = num_registros();
        
        // hay que controlar el número de registros
        // por si no hay libros que modificar
        if (regs == 0) {
            System.out.println("\nERROR no hay ningún libro que modificar!!");
        }
        else {                     
            int indice = 0; // poner un indice correcto
            
            // Leer la posición a modificar mientras sea incorrecta
            do {
                if (indice < 0 || indice >= regs)
                   System.out.println("\nÍndice o posición del libro a modificar incorrecta: ");

                indice = teclado.leer_entero("Posición del libro a modificar (0 => primera,  " + (regs-1) + " => ultima): ");        
            } while (indice < 0 || indice >= regs);

        
            // 1.) lee el libro contenido en índice
            Libro lib = obten (indice);

            // 2.) comprobar que libro no esté borrado
            if (lib.get_titulo().compareTo("") == 0 && lib.get_precio() == 0 && lib.get_publicado() == 0)
                // libro borrado
                System.out.println ("\n Libro borrado, no se puede modificar");
            else {
                // mostrar por pantalla  los datos del libro
                System.out.println ("\n Datos de libro a modificar: \n" + lib);

                char respuesta = '0';
                boolean modificar = false; // para saber si hay que modificar o no
                do {
                    System.out.println ("\n Menú para modificar?");
                    System.out.println ("1. Título.");
                    System.out.println ("2. Precio.");
                    System.out.println ("3. Año de publicación.");
                    System.out.println ("4. Salir.\n");
                    System.out.println ("Opción: ");
                    respuesta = teclado.leer_caracter("Opción: ");
                    
                    switch (respuesta) {
                        case '1': lib.setTitulo (teclado.leer_cadena2("Nuevo valor para titulo: "));
                                  modificar = true;
                                  break;
                        case '2': lib.setPrecio (teclado.leer_double("Nuevo valor para precio: "));
                                  modificar = true;
                                  break;
                        case '3': lib.setPublicado (teclado.leer_entero( "Nuevo valor para año de publicación: "));
                                  modificar = true;
                                  break;    
                        case '4': System.out.println ("\n Saliendo del menú modificar....\n");                                                 
                    }

                   

                } while (respuesta != '4');  
                
                if (modificar) {
                    // hay que modificar
                    System.out.println ("\n Modificando el libro....");
                    almacena (indice, lib);
                }
                else {
                    // no hay que modificar
                    System.out.println ("\n No se modifica el libro....");
                }
                
            }  // fin else
            
        }  // fin else     
        
    } // fin modificar
    
    
    /*---------*/
    /* EJER 10 */
    /*---------*/
    
    /* E: nada
     * S: inserta un libro en la posición "indice" de la tabla 
     * Nota: Lanza la excepción IOException para controlar errores al posicionarse  
     * y escribir en el fichero */
    public void insertar () throws IOException {
        
        int indice = 0;
        // se almacena en regs el número de registros para evitar llamar a la función num_registros más de una vez
        // y así hacer el código más eficiente
        long regs = num_registros();
        
        // leer el índice mientras sea incorrecto
        do {
            if (indice < 0 || indice > regs)
                   System.out.println("\nÍndice o posición del libro a modificar incorrecta: ");
           
            System.out.println ("Se pueden insertar más libros indicando una posición más alla de la última");
            if (regs > 0)
                indice = teclado.leer_entero("Posición del libro a insertar (0 => primera,  " + (regs-1) + " => ultima): ");
            else
                indice = teclado.leer_entero("Posición del libro a insertar (0 => única posición): ");
        } while (indice < 0 || indice > regs);
        
        // Leer los datos del libro a insertar
        String titulo = teclado.leer_cadena2("Introduce el titulo del libro:");
        int publicacion = teclado.leer_entero("Año de publicación de libro: ");
        double precio = teclado.leer_double("Precio del libro: ");
        
        // crear el objeto libro para insertarlo
        Libro lib = new Libro (titulo, publicacion, precio);
        
        // insertando el libro
        almacena (indice, lib);
        
        System.out.println("\nInsertando un libro en el fichero o tabla persistente:");
        
    } //fin insertar
    
    /* obtener el tamaño del archivo */
    public long tamano () throws IOException {
        return fich.length();        
    }
    
    /* calcular el total de registros del archivo */
    public long num_registros () throws IOException {
        long capacidad = tamano();
        long resto = capacidad % Libro.tamañoEnBytes;
        long total;
        
        if (resto == 0)
            total = capacidad / Libro.tamañoEnBytes;
        else
            total = (capacidad / Libro.tamañoEnBytes) + 1;
        
        return total;            
    } // fin num_registros
    
    
    
    /*---------*/
    /* EJER 10 */
    /*---------*/
    
    /* E: nada
     * S: devuelve en un vector todos los libros del fichero
     *    devuelve null si no cogen en memoria
     * Nota: este método no funcionará bien si hay demasiados libros
     *       y no cogen en memoria (en el vector)
     */
    public Libro [] leer_vector () throws IOException {
        long regs = num_registros();
        final int MAX = 10000; // limite máximo de libros depende de la RAM libre
        Libro [] vector;
        
        if (regs > MAX)
            vector = null;
        else {
            // reservar memoria para un vector de 'regs' libros
            vector = new Libro[(int) regs];
            // almacenar en el vector todos los libros del fichero
            for (int i=0; i < regs; i++) 
                vector[i] = obten (i);            
        }
        
        return vector;
        
    } // fin leer_vector
    

    
    /*---------*/
    /* EJER 10 */
    /*---------*/
    
    // ver en pantalla el contenido del vector de libros
    public static void ver_vector (Libro[] v) {
        int i = 1;
        for (Libro ele: v) {
            System.out.println ("Libro " + i + " : " + ele);
            i++;
        }
    }
    
    
    /*---------*/
    /* EJER 10 */
    /*---------*/
    
    // mostrar todos los libros
    public void mostrar () throws IOException {
        
        try {
            // Averiguar el tamaño del fichero
            long capacidad = tamano();
            long registros = num_registros();           

            System.out.println ("\nCapacidad bytes archivo = " + capacidad);        
            System.out.println ("\nTamaño de cada registro archivo = " + Libro.tamañoEnBytes);
            System.out.println ("\nTotal de libros = " + registros);

            // recorrer todos los libros y mostrarlos       
            Libro lib = null;
            System.out.println ("\nDatos de los libros en el orden que se grabaron 1:" );   
            for (int i=0;  i < registros; i++) {
                lib = obten (i);
                System.out.println ("Libro " + (i+1) + " " + lib);                           
            }
        } catch (IOException ex) {
            System.out.println ("\n Error de E/S: " + ex);
        }
    } //fin mostrar
    
    /** Cerrar la tabla */
    public void cerrar() throws IOException {
        if (fich!= null)
            fich.close();
    }
} // clase TablaLibros
