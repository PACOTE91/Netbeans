package Tema6.Ejercicios;

public class Fecha
{
   private int mes; 	// 1-12
   private int dia;   // 1-31 días de cada mes
   private int anio;  // cualquier año

   // constructor: llama a comprobarMes para confirmar el valor apropiado para el mes
   // llama a comprobarDia para confirmar el valor apropiado del día de un mes
   public Fecha( int elmes, int eldia, int elanio )
   {
      mes = comprobarMes (elmes); // valida el mes
      if (mes == -1)
      	mes = 1; // si el mes es incorrecto lo pongo a Enero, aunque podía haber optado por otro
      
      anio = elanio; // podría validar el año
      
      dia = comprobarDia (eldia); // valida el día del mes
      if (dia == -1)
      	dia = 1; // si el día es incorrecto lo pongo a día 1, aunque podía haber optado por otro

      System.out.printf ("Constructor de objeto Fecha para la fecha %s\n", this );
   } // end Date constructor

   // E: mesprueba => cualquier valor entero
   // S: -1 => si el mesprueba es incorrecto 
   //     mesprueba => caso de ser correcto (entre 1 y 12)
   private int comprobarMes( int mesprueba )
   {
      if ( mesprueba > 0 && mesprueba < 13 ) // validar el mes
         return mesprueba;
      else       
         return -1;  // mes incorrecto  
   } // fin comprobarMes

   // E: diaprueba => cualquier valor entero
   // S: -1 => si el diaprueba es incorrecto
   //     mesprueba => caso de ser correcto (estar dentro de los días que tiene el mes actual)
   private int comprobarDia( int diaprueba )
   {
      int diasPorMes[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
      int devolucion;
   
      // comprobar si el día esta en el rango correcto para el mes actual 
      if ( diaprueba > 0 && diaprueba <= diasPorMes [mes] )
         devolucion = diaprueba;
      else   
      	// comprobar si es día 29 de Febrero de un año bisiesto
      	if ( mes == 2 && diaprueba == 29 && ( anio % 400 == 0 || 
           ( anio % 4 == 0 && anio % 100 != 0 ) ) )
        	devolucion = diaprueba;
        else 
   				devolucion = -1;
   			
      return devolucion;  
   } // fin comprobarDia
   
   // redefine el método toString
   // devuelve una cadena en la forma dia/mes/anio
   public String toString()
   { 
      return String.format( "%d/%d/%d", dia, mes, anio ); 
   } // fin toString
   
} // fin clase Fecha


/**************************************************************************
 * (C) Copyright 1992-2007 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
