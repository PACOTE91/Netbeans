package Tema6;

/**
 * Esta clase controla la introduccion de fechas en otras clases
 * @version 1.0
 * @author PACOFENOY
 */

public class Fecha
{
   // 1-12/
   /**
    * Entero almacena mes de la fecha
    */
   private int mes;
   /**
    * Entero almacena dia de la fecha
    */
   // 1-31 días de cada mes
   private int dia;
   /**
    * Entero almacena ano de la fecha
    */
   // cualquier año
   private int anio;


   // constructor: llama a comprobarMes para confirmar el valor apropiado para el mes
   // llama a comprobarDia para confirmar el valor apropiado del día de un mes

   /**
    * Constructor de la clse Fecha
    * @param elmes En este parametro hay que introducier el mes de la fecha.
    * @param eldia En este parametro hay que introducier el dia de la fecha.
    * @param elanio En este parametro hay que introducier el ano de la fecha.
    */
   public Fecha( int elmes, int eldia, int elanio )
   {
      super();
      mes = comprobarMes (elmes); // valida el mes
      if (mes == -1)
      	mes = 1; // si el mes es incorrecto lo pongo a Enero, aunque podía haber optado por otro
      
      anio = elanio; // podría validar el año
      
      dia = comprobarDia (eldia); // valida el día del mes
      if (dia == -1)
      	dia = 1; // si el día es incorrecto lo pongo a día 1, aunque podía haber optado por otro

   } // end Date constructor

   // E: mesprueba => cualquier valor entero
   // S: -1 => si el mesprueba es incorrecto 
   //     mesprueba => caso de ser correcto (entre 1 y 12)

   /**
    * Este metodo comprueba la correcta introducion del mes
    * @param mesprueba Comprueba que el valor de mesprueba este entre 1 y 12 cada uno asociado a un mes.
    * @return Devuelve -1 si el mes es incorrecto y valor de 1 hasta 12 en funcion del mes que corresponda.
    */
   public int comprobarMes( int mesprueba )
   {
      if ( mesprueba > 0 && mesprueba < 13 ) // validar el mes
         return mesprueba;
      else       
         return -1;  // mes incorrecto  
   } // fin comprobarMes

   // E: diaprueba => cualquier valor entero
   // S: -1 => si el diaprueba es incorrecto
   //     mesprueba => caso de ser correcto (estar dentro de los días que tiene el mes actual)

   /**
    * Este metodo comprueba la correcta introducion del dia
    * @param diaprueba Comprueba que el valor de "diaprueba" este entre 1 y 31 (cada uno asociado a un dia)
    * @return Devuelve -1 si el dia es incorrecto y valor de 1 hasta 31 en funcion del dia que corresponda
    */
   public int comprobarDia( int diaprueba )
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

   /**
    * Este metodo sobreescribe el toString
    * @return Devuelve la fecha en formato dia, mes, año
    */
   public String toString()
   { 
      return String.format( "%d/%d/%d", dia, mes, anio ); 
   } // fin toString
   
} // fin clase Fecha


