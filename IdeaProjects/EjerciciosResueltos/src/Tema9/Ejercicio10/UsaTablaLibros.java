
package Tema9.Ejercicio10;

import java.io.*;

    /*---------*/
    /* EJER 10 */
    /*---------*/

public class UsaTablaLibros {
    
    // E: nada
    // S: true si se quiere ordenar ascendentemente
    //    false si se quiere ordenar descendentemente
    public static boolean leer_ascendente () {
        char opcion;
        boolean resul;
        do {            
            opcion = teclado.leer_caracter("\n¿Quieres ordenar ascendentemente S/N?");
        } while (opcion != 's' && opcion != 'n' && opcion != 'S' && opcion != 'N');
        
        if (opcion == 's' || opcion == 'S' )
           resul = true;
        else
           resul = false;
        
        return resul;
    }
    
    // menú de libros
    // E: nada
    // S: devuelve la opción leída
    public static char menu () {
        
        char respuesta = '0';
        do {
            System.out.println ("\n Menú de Libros");
            System.out.println ("1. Listado de libros.");
            System.out.println ("2. Insertar un libro.");
            System.out.println ("3. Modificar un libro.");
            System.out.println ("4. Borrar un libro.");
            System.out.println ("5. Mostrar ordenado por titulo.");
            System.out.println ("6. Mostrar ordenado por precio.");
            System.out.println ("7. Mostrar ordenado por año.");
            System.out.println ("8. Salir.\n");
            System.out.println ("Opción: ");
            respuesta = teclado.leer_caracter("Opción: ");           

        } while (respuesta < '1' || respuesta > '8');
        
        return respuesta;
    } // fin menu
    
    
    public static void usa_menu(TablaLibros tabla) throws IOException {
        char opcion ='0'; 
        Libro [] vector;
        boolean ascendente;
               
        do {
            opcion = menu();
            switch (opcion) {
                case '1': tabla.mostrar(); break;
                case '2': tabla.insertar(); break;
                case '3': tabla.modificar(); break;
                case '4': tabla.borrar(); break;
                case '5': // pasar todos los libros a un vector
                          vector = tabla.leer_vector();
                          // Leer si se ordena ascendentemente o descentemente
                          ascendente = leer_ascendente();
                          
                          // comprobar si el vector es null                          
                          if (vector== null) {
                              System.out.println ("\nError vector no creado (null)");
                          }
                          else {                          
                            // ordenar por titulo
                            Ordenacion.quicksort (vector, 0, vector.length-1, 1, ascendente);
                            // ver vector ordenado por titulo
                            System.out.println ("\n Libros ordenados por titulo:\n");
                            TablaLibros.ver_vector(vector);
                          }
                          break;
                case '6': // pasar todos los libros a un vector
                          vector = tabla.leer_vector();
                           // Leer si se ordena ascendentemente o descentemente
                          ascendente = leer_ascendente();
                          
                          // comprobar si el vector es null                          
                          if (vector== null) {
                              System.out.println ("\nError vector no creado (null)");
                          }
                          else { 
                            // ordenar por precio
                            Ordenacion.quicksort (vector, 0, vector.length-1, 3, ascendente);
                            // ver vector ordenado por precio
                            System.out.println ("\n Libros ordenados por precio:\n");
                            TablaLibros.ver_vector(vector);
                          }
                          break;
                case '7': // pasar todos los libros a un vector
                          vector = tabla.leer_vector();
                           // Leer si se ordena ascendentemente o descentemente
                          ascendente = leer_ascendente();
                          
                          // comprobar si el vector es null                          
                          if (vector== null) {
                              System.out.println ("\nError vector no creado (null)");
                          }
                          else { 
                            // ordenar por año de publicacion
                            Ordenacion.quicksort (vector, 0, vector.length-1, 2, ascendente);
                            // ver vector ordenado por año de publicacion
                            System.out.println ("\n Libros ordenados por año de publicacion:\n");
                            TablaLibros.ver_vector(vector);
                          }
                          break;
                    
                case '8': System.out.println("Saliendo del menu...."); break;
            }

            System.out.println("\n Opción leída = " + opcion); 
        } while (opcion != '8');       
        
    }
    
    
    public static void main(String[] args) throws IOException {
        // ejemplo de uso de TablaLibros
        TablaLibros t = null;
        
        try {
            
            t = new TablaLibros("Libros.dat");
            
            /*
            // Crear 8 libros
            Libro libro1 = new Libro("Java", 2006, 15.0); 
            Libro libro2 = new Libro("1984", 1949, 25.0);
            Libro libro3 = new Libro("Head First Java",  2005, 14.75); 
            Libro libro4 = new Libro("Head First Object Oriented Analysis and Desig", 2006, 14.45);
            Libro libro5 = new Libro("Thinking in Java", 2006, 16.57); 
            Libro libro6 = new Libro("The Java Tutorial: A Short Course on the Basics", 2013, 32.54);            
            Libro libro7 = new Libro("The Java Language Specification", 2013, 26.34); 
            Libro libro8 = new Libro("COMO PROGRAMAR EN JAVA", 2008, 59.95); 
            
            String s = "COMO PROGRAMAR EN JAVA";
            System.out.println ("\n tamaño 'COMO PROGRAMAR EN JAVA' = " + s.length());
            
            System.out.println ("tamaño integer = " + Integer.SIZE/8  + " tamaño double = " + Double.SIZE/8 );           
            
            

            // almacenamos los libros de modo persistente (en el archivo Libros.dat)
            t.almacena(0,libro1); t.almacena(1,libro2); t.almacena(2,libro3); t.almacena(3,libro4);   
            t.almacena(4,libro5); t.almacena(5,libro6); t.almacena(6,libro7); t.almacena(7,libro8);   

            // recuperamos los libros accediendo de modo directo o aleatorio
            Libro l1= t.obten(3); Libro l2= t.obten(7); Libro l3= t.obten(4);
            Libro l4= t.obten(5); Libro l5= t.obten(1); Libro l6= t.obten(0);   
            Libro l7= t.obten(6); Libro l8= t.obten(2);   

            // Mostramos los datos de los libros anteriores
            System.out.println ("\nDatos de los libros:" );   
            System.out.println (l1.toString());
            System.out.println (l2);  // no hace falta poner toString()    
            System.out.println (l3); System.out.println (l4);        
            System.out.println (l5); System.out.println (l6); 
            System.out.println (l7); System.out.println (l8);*/
            
            // mostrar todos los libros
            t.mostrar();
            
            // hacer uso del menú para borrar, modificar, insertar, etc....
            usa_menu (t);              
           
            /*
            Libro [] vector = t.leer_vector();
            
            TablaLibros.ver_vector(vector);*/
            
        } catch (EOFException ex) {
            System.out.println ("\n--------EOF--------");   
        
        } catch (FileNotFoundException ex) {
            System.out.println ("\n Error el fichero no se puede crear o acceder: " + ex);
            
        } catch (IOException ex) {
            System.out.println ("\n Error de E/S al leer o escribir en el fichero: " +ex);
        } finally {
            try {
               t.cerrar();            
            } catch (IOException ex) {
                System.out.println ("\n Error de E/S al cerrar el fichero: " +ex);
            }
        }
             
    
    } // fin main

} // fin clase UsaTablaLibros
