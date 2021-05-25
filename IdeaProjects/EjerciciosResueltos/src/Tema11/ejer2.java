package Tema11;/* 2.) Crea la clase ejer2 e incluye el método denominado creaTablaCoches() que en la Base de
 Datos Concesionario, crea la estructura de la tabla de COCHES con el siguiente formato:

	* Matricula (Primary Key) => Tipo => varchar(8) NOT NULL
	* Marca => Tipo => varchar(40) NOT NULL
	* Modelo => Tipo => varchar(40) NOT NULL
	* Color => Tipo => varchar(40) NOT NULL
	* Anio => Tipo => integer NOT NULL
	* Precio => Tipo => integer NOT NULL
	
Importante: al crear la tabla comprueba que no existe antes, por si llamas al método dos veces
Create Table If Not Exists

Crea el método printSQLException () y usalo dentro del main() => tienes el código en JDBC_RAMA.java  

Dentro del main() haz la llamada al método creaTablaCoches().

Para probar que haz creado la tabla deberás tener abierta una terminal de comandos y haber accedido a MySQL (por ejemplo con el comando: mysql -u root -p, en la terminal de comandos ejecuta:
	show databases;
	use concesionario;
	describe COCHES; 
	
3.) Dentro de la clase ejer2 crea el método cargaTablaCoches(), que inserta en la tabla COCHES los siguientes datos a partir del fichero coches.txt con el formato: "matricula marca modelo color año precio":

8012-CLY Renault Megane Negro 2003 2350
5068-GDB Volkswagen Passat Gris 2008 13500
3268-BVN Opel Astra Negro 2002 2000
3452-DAC Renault Megane Azul 2004 2500
3189-BVN Opel Astra Blanco 2002 2000
1123-ABF Opel Corsa Rojo 2000 1100

Pista: usa la clase StringTokenizer que permite obtener los trozos o tokens de una cadena separados por un delimitador (en este caso es el espacio en blanco).

Para comprobar que está bien el ejercicio usa en una terminal de comandos el comando MySQL:
Select * From COCHES;
	
	*/

import java.sql.*; // importar clases para el manejo de SQL
import java.io.*;  // importar clases para el manejo de ficheros
import java.util.StringTokenizer; // importar clase StringTokenizer
import java.util.TimeZone;

public class ejer2 {

	// E: e => excepción de tipo SQL
	// nada, muestra por pantalla el error detallado
	// pag 234 libro RA-MA
	public static void printSQLException (SQLException e) {
		e.printStackTrace (System.err);
		// Mostrar el código SQLState
		System.err.println ("\nSQLState: " + e.getSQLState() );
		// Código de error numérico
		System.err.println ("\nCódigo de error: " + e.getErrorCode() );
		// Descripción del error
		System.err.println ("\nDescripción del error: " + e.getMessage() );

		// Obtener todos las causas del error
		Throwable t = e.getCause();
		int i = 1;
		while (t != null) {
			System.out.println ("\nCausa: " + i + "ª: " + t);
			i ++;
			t = t.getCause();
		}
	
	} // fin printSQLException


	// Crea la tabla COCHES en la BD
	// el método puede generar una excepción o error de tipo SQL => throws	
	public static void creaTablaCoches (Connection con, String BD) throws SQLException {
		
		String cadena = "Create Table If Not Exists " + BD + ".COCHES" +
		                "(Matricula varchar(8) NOT NULL," + 
		                "Marca varchar(40) NOT NULL," +
		                "Modelo varchar(40) NOT NULL," +
		                "Color varchar(40) NOT NULL," +
		                "Anio integer NOT NULL," +
		                "Precio integer NOT NULL," +
		                "Primary Key (Matricula))";
		// el objeto de stmt de la clase Statement servirá para enviar órdenes SQL
		Statement stmt = null;		
		                  
		try {
			// Llamada al constructor de la clase Statement con un objeto de la clase Connection
			stmt = con.createStatement();
			
			// Ejecutar sentencias DDL (Data Definition Language) 
			// => como crear tablas o eliminarlas. También insertar, borrar o modificar filas de una tabla
			stmt.executeUpdate (cadena);			
		
		} catch (SQLException e) {
			// Mostrar el error SQL producido 
			printSQLException(e);
			
		} finally {
			// Cerrar el objeto Statement
			stmt.close();
		}
	
	} // fin creaTablaCoches
	
	
	// Insertar los datos dentro de la tabla COCHES a partir del fichero de texto
	// el método puede generar una excepción o error de tipo SQL => throws	
	public static void cargaTablaCoches (Connection con, String BD, String fichero) throws SQLException {
	
		// el objeto de stmt de la clase Statement servirá para enviar órdenes SQL
		Statement stmt = null;
		
		try {
			// Llamada al constructor de la clase Statement con un objeto de la clase Connection
			stmt = con.createStatement();
			
			// Abrir el fichero de texto para lectura usando un Buffer
			File f = new File (fichero);
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			
			// Lectura del fichero línea a línea con BufferedReader			
			String linea;
			while((linea = br.readLine()) != null) {
				// definir que los trozos o tokens están separados por espacios en blanco
				StringTokenizer trozo = new StringTokenizer (linea);
				
				// Crear la cadena que va a insertar los datos en la tabla COCHE
				// con los datos suministrados por la línea leída del fichero
				String comando = "Insert Into " + BD + ".COCHES Values (" +
				                 "'" + trozo.nextToken() + "'," + // Matricula
				                 "'" + trozo.nextToken() + "'," + // Marca
				                 "'" + trozo.nextToken() + "'," + // Modelo
				                 "'" + trozo.nextToken() + "'," + // Color				                 
				                 "" + trozo.nextToken() + "," +   // Año 
				                 "" + trozo.nextToken() + ")";    // Precio
				                 
				// Ejecutar el comando SQL que inserta los datos en la tabla
				stmt.executeUpdate (comando);
				
			} // fin while			
			
			// Cerrar el fichero
			if (fr != null) 
				fr.close();			
				
		} catch (FileNotFoundException e) {
			System.err.println ("Fichero no encontrado " + fichero);
			
		} catch (IOException e) {
			System.err.println ("Error de E/S " + fichero);
			e.printStackTrace();		
			
		} catch (SQLException e) {
			// Mostrar el error SQL producido 
			printSQLException(e);				
			
		} finally {
			// Cerrar el objeto Statement
			stmt.close();
		}
	
	} // fin cargaTablaCoches
	
	
	
	public static void main (String args[]) {
	
		try {
			
			Connection connection = null;					
			
			// Cargar la clase para el controlador de la Base de Datos 
			// => Driver JDBC => fichero jar incluido en MySQL/Connector
			// No es necesario ponerlo, aunque la ventaja de incluirlo es que 
			// mediante la excepción ClassNotFoundException te controla el error si no encuentra el driver
			Class.forName("com.mysql.cj.jdbc.Driver");			
			
			// Obtiene la hora local de tu ordenador y se la pasa al servidor MySQL para que no de error			
			String horaLocal = TimeZone.getDefault().getID();
			
			// Intentar la conexión con la BD Concesionario => PON TU usuario CONTRASEÑA de tu usuario
			// este usuario debe tener todos los privilegios en la BD	
			// Aquí se realiza con el usuario "ramon" y la contraseña "libro" 
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Concesionario?serverTimezone=" + horaLocal, "root", "1234");
			System.out.println("\nConexión establecida!!\n");			
			
			// Crear la tabla COCHES			
			creaTablaCoches (connection, "Concesionario");
			
			// Insertar los datos en la tabla COCHES a partir del fichero coches.txt
			cargaTablaCoches (connection, "Concesionario", "coches.txt");						
						
		} catch (Exception e) {
			// Mostrar errores
			System.out.println ("Error en la BD");
			e.printStackTrace();
		}		
	
	} // fin main

} // fin clase ejer1

/* REQUISITOS PREVIOS
 * No se te olvide crear la BD en mysql con:

mysql>  CREATE DATABASE IF NOT EXISTS Concesionario;
Query OK, 1 row affected (0.00 sec)

mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| Banco              |
| Club_Futbol        |
| Concesionario      |
| books              |
| mysql              |
| performance_schema |
| sys                |
+--------------------+
8 rows in set (0.00 sec)


==================================================

YA PUEDES EJECUTAR EL CÓDIGO DE ejer1.java.

Resultado de la ejecución del código:


Conexión establecida!!

------------------
(program exited with code: 0)
Press return to continue

===================================================

AHORA ES EL MOMENTO DE COMPROBAR QUE HA FUNCIONADO TU CÓDIGO CON LOS COMANDOS MySQL:


Para probar que funciona el Ejercicio 2)

mysql> use Concesionario;
Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A

Database changed
mysql> describe COCHES;
+-----------+-------------+------+-----+---------+-------+
| Field     | Type        | Null | Key | Default | Extra |
+-----------+-------------+------+-----+---------+-------+
| Matricula | varchar(8)  | NO   | PRI | NULL    |       |
| Marca     | varchar(40) | NO   |     | NULL    |       |
| Modelo    | varchar(40) | NO   |     | NULL    |       |
| Color     | varchar(40) | NO   |     | NULL    |       |
| Anio      | int(11)     | NO   |     | NULL    |       |
| Precio    | int(11)     | NO   |     | NULL    |       |
+-----------+-------------+------+-----+---------+-------+
6 rows in set (0.00 sec)

-------------------------------------------------------------

Para probar que funciona el Ejercicio 3)


mysql> Select * From COCHES;
+-----------+------------+--------+--------+------+--------+
| Matricula | Marca      | Modelo | Color  | Anio | Precio |
+-----------+------------+--------+--------+------+--------+
| 1123-ABF  | Opel       | Corsa  | Rojo   | 2000 |   1100 |
| 3189-BVN  | Opel       | Astra  | Blanco | 2002 |   2000 |
| 3268-BVN  | Opel       | Astra  | Negro  | 2002 |   2000 |
| 3452-DAC  | Renault    | Megane | Azul   | 2004 |   2500 |
| 5068-GDB  | Volkswagen | Passat | Gris   | 2008 |  13500 |
| 8012-CLY  | Renault    | Megane | Negro  | 2003 |   2350 |
+-----------+------------+--------+--------+------+--------+
6 rows in set (0.00 sec)


*/
 
