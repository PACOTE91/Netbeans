public class wrappers {

	public static void main (String args[]) {
		// wrapper Integer
		Integer num1 = new Integer ("45");
		Integer num2 = new Integer (-77);
		
		// pasar a cadena el wrapper Integer
		String cad1 = num1.toString();
		System.out.println ("El wrapper num1 es igual a " + cad1);
		String cad2 = num2.toString();
		System.out.println ("El wrapper num2 es igual a " + cad2);
		
		// pasar a int el wrapper Integer
		int entero1 = num1.intValue();
		int entero2 = num2.intValue();		
		System.out.println ("\n entero1 = " + entero1);
		System.out.println (" entero2 = " + entero2);
		
		
		// Pasar 77 a base 10
		int num3 = Integer.parseInt ("77",10);
		System.out.println ("El entero 77 en base 10 es igual a " + num3);
		// Pasar B de base hexadecimal (16) a base 10
		int num4 = Integer.parseInt ("B",16);
		System.out.println ("El hexadecimal B en base 10 es igual a " + num4);
		// Pasar 7 de base binaria (2) a base 10
		int num5 = Integer.parseInt ("111",2);
		System.out.println ("El número binario 111 en base 10 es igual a " + num5); 		
		
		// Pasar de un número decimal a base binaria
		System.out.println ("El número 2 en binario es " + Integer.toBinaryString (2));
		// Pasar de un número decimal a base hexadecimal
		System.out.println ("El número 15 en hexadecimal es " + Integer.toHexString (15));		
		
	} // fin main

} // fin clase wrappers
