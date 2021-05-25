package Tema7;
// clase que hace uso de toda la jerarquía de clases
public class UsaVehiculo {
	public static void main (String args []) {
		// ejercicio 1 => crear objetos de las clases y subclases definidas => constructor por defecto (sin parámetros)
		
		Vehiculo vehiculo1 = new Vehiculo ();
		Coche seat127 = new Coche();
		Todoterreno nissan = new Todoterreno();
		Deportivo ferrari = new Deportivo();
		Monovolumen picasso = new Monovolumen();
		Motocicleta derbi = new Motocicleta();
		Bicicleta orbea = new Bicicleta();
		
		// puedes ver a que clase pertenece cada objeto o los valores de los atributos de cada objeto
		// el método toString es redefinido por cada subclase
		System.out.println ("vehiculo1: " + vehiculo1.toString());
		System.out.println ("seat127: " + seat127.toString());
		System.out.println ("ferrari: " + ferrari.toString());
		System.out.println ("nissan: " + nissan.toString());
		System.out.println ("picasso: " + picasso.toString());
		System.out.println ("derbi: " + derbi.toString());
		System.out.println ("orbea: " + orbea.toString());
		

		Vehiculo vehiculo2 = new Vehiculo ("Lancha Motora S.L", "AL-3435-AZ", 1985, "José Pérez Rodríguez");
		Coche seat600 = new Coche ("Seat", "CA-3445-SA", 1999, "Severiano Almansa Torres", 2, false, 4);
		Todoterreno nissan2 = new Todoterreno ("Nissan", "MA-3467-CD", 2002, "María Pérez Pérez", 4, true, 3, true);
		Deportivo ferrari2 = new Deportivo ("Ferrari", "M-38809-SE", 2000, "Luisa López López", 6, true, 2, false); 
		Monovolumen picasso2 = new Monovolumen ("Citroen", "J-4568-ZZ", 2003, "Andrés Gutierréz Salgado", 4, true, 5);
		Motocicleta derbi2 = new Motocicleta ("Derbi", "AL-4556", 1965, "Esteban González Martín", false, false, "75cc");
		Bicicleta orbea2 = new Bicicleta ("Orbea", "AL-5644", 2010, "Roberto Pérez García", "Montaña");
		
		// puedes ver a que clase pertenece cada objeto o los valores de los atributos de cada objeto
		// el método toString es redefinido por cada subclase
		System.out.println ("\nvehiculo2: " + vehiculo2.toString());
		System.out.println ("seat600: " + seat600.toString());
		System.out.println ("ferrari2: " + ferrari2.toString());
		System.out.println ("nissan2: " + nissan2.toString());
		System.out.println ("picasso2: " + picasso2.toString());
		System.out.println ("derbi2: " + derbi2.toString());
		System.out.println ("orbea2: " + orbea2.toString());
		
		// ejercicio 3 => hacer uso de los métodos get y put
		System.out.println ("\nFabricante del vehiculo2: " + vehiculo2.get_fabricante());
		System.out.println ("Año de la matrícula del seat600: " + seat600.get_anio_matricula());
		derbi.put_cilindrada ("50 cc");
		System.out.println ("Cilindrada de la derbi: " + derbi.get_cilindrada());
		System.out.println ("Tipo de bicleta orbea2: " + orbea2.get_tipo_bicicleta());
		System.out.println ("Nº de monovolúmenes: " + Monovolumen.get_num_monovolumenes());
		ferrari.put_descapotable (true);
		System.out.println ("Ferrari descapotable: " + ferrari.get_descapotable());
		System.out.println ("Nissan2 4x4: " + nissan2.get_traccion_4x4());		

		// ejercicios 4 y 5 => llamar al método toString()
		System.out.println ("\nvehiculo2: " + vehiculo2.toString());
		System.out.println ("seat600: " + seat600.toString());
		System.out.println ("ferrari2: " + ferrari2.toString());
		System.out.println ("nissan2: " + nissan2.toString());
		System.out.println ("picasso2: " + picasso2.toString());
		System.out.println ("derbi2: " + derbi2.toString());
		System.out.println ("orbea2: " + orbea2.toString());
	
	} // fin main

} // fin clase UsaVehiculo
