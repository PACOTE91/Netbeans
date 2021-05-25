/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tema9.Ejercicio10;

/**
 *
 * @author ramon
 */

    /*---------*/
    /* EJER 10 */
    /*---------*/

public class Ordenacion {
    
    // método para comparar 
    /* E: v => vector de libros
     *    i => posición del vector
     *    j => posición del vector
     *    modo => 1 comparar titulo, 2 comparar año, 3 comparar precio
     *    may => si es true se compara mayor v[i] > v[j] sino menor
     *    igual => compara además si son iguales
     *    asc => para ordenación ascendente si es true sino (false => descendente)
     * S: true si al comparar v[i] con v[j] => v[i] > v[j] dependiendo del modo
     *    false en caso contrario
     */
    public static boolean comp (Libro v[], int i, int j, int modo, boolean mayor, boolean igual, boolean ascendente) {
        boolean resul = false;       

        if (modo == 1) {
            // comparar por titulo
            if (mayor && !igual) // >
                if (v[i].get_titulo().compareTo(v[j].get_titulo()) > 0)
                    resul = true;
                else 
                    resul= false;
            else if (mayor && igual) // >=
                if (v[i].get_titulo().compareTo(v[j].get_titulo()) >= 0)
                    resul = true;
                else 
                    resul= false;
            else if (!mayor && !igual) // <
                if (v[i].get_titulo().compareTo(v[j].get_titulo()) < 0)
                    resul = true;
                else 
                    resul= false;
             else if (!mayor && igual) // <=
                if (v[i].get_titulo().compareTo(v[j].get_titulo()) <= 0)
                    resul = true;
                else 
                    resul= false;
        }
        else             
            if (modo == 3) {              
                // comparar por precio                
                if (mayor && !igual) // >
                    if (v[i].get_precio() > v[j].get_precio())
                        resul = true;
                    else 
                        resul= false;
                else if (mayor && igual) // >=
                    if (v[i].get_precio() >= v[j].get_precio())
                        resul = true;
                    else 
                        resul= false;
                else if (!mayor && !igual) // <
                    if (v[i].get_precio() < v[j].get_precio())
                        resul = true;
                    else 
                        resul= false;
                 else if (!mayor && igual) // <=
                    if (v[i].get_precio() <= v[j].get_precio())
                        resul = true;
                    else 
                        resul= false;                   
            }
            else 
                if (modo == 2) {
                    // comparar por año de publicación
                    if (mayor && !igual) // >
                        if (v[i].get_publicado() > v[j].get_publicado())
                            resul = true;
                        else 
                            resul= false;
                    else if (mayor && igual) // >=
                        if (v[i].get_publicado() >= v[j].get_publicado())
                            resul = true;
                        else 
                            resul= false;
                    else if (!mayor && !igual) // <
                        if (v[i].get_publicado() < v[j].get_publicado())
                            resul = true;
                        else 
                            resul= false;
                     else if (!mayor && igual) // <=
                        if (v[i].get_publicado() <= v[j].get_publicado())
                            resul = true;
                        else 
                            resul= false;
                }                          
       
       if (!ascendente)
           // si es ordenacion descendente se cambia el resultado al contrario
           resul = !resul;
       return resul;       
   } // fin comp
   
    
    /*  E: v => vector de libros
	   izq => posición del indice izquierda dentro del vector
	   der => posición del indice derecha dentro del vector
           modo => 1 => ordenado ascendentemente por Titulo
                   => 2 => ordenado ascendentemente por Año de publicación
                   => 3 => ordenado ascendentemente por precio
           asc => para ordenación ascendente si es true sino (false => descendente)
        S: posición del pivote o elemento del vector que queda ordenado ascendentemente de 
           tal forma que los elementos desde v[pivote-1] hasta v[izq] son menores o iguales
           que v[pivote], además los elementos desde v[pivote+1] hasta v[der] son mayores 
           que v[pivote] */
    public static int pivote1 (Libro v[], int izq, int der, int modo, boolean asc) {	

            Libro temp; // variable auxiliar para el intercambio
            int pos; // posición del vector a intercambiar con el pivote
            /* eleccion del pivote, por ejemplo el elemento más a la izquierda */
            int	pivote = izq;		

            // comprobar el caso particular de que derecha es uno más que izquierda
            if (izq+1 == der) {
                    // Caso 1) hay que ordenar un vector de dos elementos
                    if (comp (v, izq, der, modo, true, false, asc) )
                            pos = der;
                    else
                            pos = izq;		
            }
            else {			
                    // Caso 2) el vector a ordenar tiene 3 o más elementos
                    izq ++;				

                    while (izq < der) {
                            // comprobar si v[izq] y v[der] están bien ordenados respecto a v[pivote]
                            if (comp (v, izq, pivote, modo, true, false, asc) && comp (v, der, pivote, modo, false, true, asc)) {                        
                                    // no están bien ordenados => se intercambian v[izq] con v[der]
                                    temp = v[izq];
                                    v[izq] = v[der];
                                    v[der] = temp;
                                    izq ++;
                                    der --;					
                            }
                            else {
                                    // comprobar si hay que avanzar o no los indices izquierda o derecha
                                    // en caso de que estén bien colocados respecto al pivote
                                    if (comp (v,izq, pivote, modo, false, true, asc))                                    
                                            izq ++;
                                    
                                    if (comp (v,der, pivote, modo, true, false, asc))                                    
                                            der --;					
                            }	// fin else					
                    } // fin while			

                    // ====== Calcular donde hay que colocar el pivote ===========
                    if (izq == der) {
                            if (comp (v,pivote, izq, modo, true, false, asc))                        
                                    // esto significa que hay que intercambiar el pivote con der, por ejemplo.
                                    pos = der;					
                            else 
                                    // hay que intercambiar el pivote con derecha -1
                                    // puede suceder que si pivote = derecha -1 realmente no se intercambie nada
                                    pos = der -1;						
                    }
                    else
                            // izq > der
                            pos = der;	

            } // fin else de más arriba

            // Al salir del bucle a la izquierda de izq todos los elementos (no se cuenta a pivote) son 
            // menores o iguales que v[pivote]
            // Y a la derecha de dech todos los elementos (excepto pivote) son 
            // mayores que v[pivote]		

            if (pos != pivote) {			
                    // intercambiar v[pos] con v[pivote]
                    temp = v[pos];
                    v[pos] = v[pivote];
                    v[pivote] = temp;							
            } 

            // la posición del pivote está en pos
            return pos;

    } // fin pivote1
	
	
    /* E: v => vector de libros
     * izq => posición del indice izquierda dentro del vector
       der => posición del indice derecha dentro del vector
       modo => 1 => ordenado ascendentemente por Titulo
               => 2 => ordenado ascendentemente por Año de publicación
               => 3 => ordenado ascendentemente por precio
       asc => para ordenación ascendente si es true sino (false => descendente)
       S: nada, ordena ascendentemente por quicsort el vector */
    public static void quicksort (Libro [] v, int izq, int der, int modo, boolean asc) {
        
        // comprueba si el vector es null para no hacer nada
        if (v == null)
            System.out.println ("\n Error el vector no está creado es null");
        else {
            // vector con algún elemento
            int pivote;
            if(izq < der){
               pivote = pivote1(v, izq, der, modo, asc);
               // ordenar la parte izquierda del vector a partir de pivote
               quicksort(v, izq, pivote-1, modo, asc);
               // ordenar la parte derecha del vector a partir de pivote
               quicksort (v, pivote+1, der, modo, asc);
            }  
        }
    } // fin quicksor_asc
    
}
