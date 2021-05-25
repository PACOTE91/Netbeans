import java.util.*;

public class fechas {

	public static void main(String[] args) {
		
		// crear una fecha d de la clase Date
		Date d = new Date();		
		
		// crear una fecha c de la clase GregorianCalendar
		// horas => 0..23, dias => 1..31, 
		// años => cuatro dígitos, meses => 0..11		
		GregorianCalendar c = new GregorianCalendar();
		
		// se puede establecer la fecha de la clase GregorianCalendar en base a la clase Date
		c.setTime(d);
		
		// Mostrar por pantalla la fecha actual
		System.out.print(c.get(Calendar.DAY_OF_MONTH));
		System.out.print("-");
		System.out.print(c.get(Calendar.MONTH)+1);
		System.out.print("-");
		System.out.println(c.get(Calendar.YEAR));
		
		// Mostrar la hora actual
		System.out.println ("La hora actual es: " + c.get(Calendar.HOUR));
		System.out.println ("Los minutos son: " + c.get(Calendar.MINUTE));
		System.out.println ("Los segundos son: " + c.get(Calendar.SECOND));
		
	} // fin main
	
} // fin clase fechas

