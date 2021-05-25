package Tema11;

import java.sql.*;
import java.util.TimeZone;

// Requisitos:

// MySQL instalado y configurado
// debe haber un usuario root u otro usuario (en mi caso usuario ramon)
// con contraseña y todos los privilegios

// Debes tener creada una Base de Datos vacia denominada Club_Futbol
// Instrucción MySQL a ejecutar para crearla:
// CREATE DATABASE IF NOT EXISTS Club_Futbol;

/* Desde Linux conectarse con el usuario ramon a MySQL y crear la BD Club_Futbol
   Sería similar desde Windows, ya que los comandos son iguales

ramon@Ramon-PC:~$ mysql -u ramon -p
Enter password: 
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 2
Server version: 5.7.29-0ubuntu0.18.04.1 (Ubuntu)

Copyright (c) 2000, 2020, Oracle and/or its affiliates. All rights reserved.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> CREATE DATABASE IF NOT EXISTS Club_Futbol;
Query OK, 1 row affected (0.00 sec)

mysql> exit
Bye

*/


// ======= IMPORTANTE ======
// El programa debes ejecutarlo una sola vez
// La segunda vez que lo ejecutas dará error ya que no se puede insertar datos con llave primaria repetida


public class JDBC_RAMA {
	
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

	// Crea la tabla EQUIPO
	// el método puede generar una excepción o error de tipo SQL => throws
	// pag 236 libro RA-MA
	public static void createEQUIPO(Connection con, String BDNombre) throws	SQLException {
	
		// cadena que define la tabla que se creará después
		String createString = "create table IF NOT EXISTS " + BDNombre + ".EQUIPO " +
			"(TEAM_ID integer NOT NULL," +
			"EQ_NOMBRE varchar(40) NOT NULL," +
			"ESTADIO varchar(40) NOT NULL," +
			"POBLACION varchar(20) NOT NULL," +
			"PROVINCIA varchar(20) NOT NULL," +
			"COD_POSTAL char(5)," +
			"PRIMARY KEY (TEAM_ID))";
			
		// el objeto de stmt de la clase Statement servirá para enviar órdenes SQL
		Statement stmt = null;		
		
		try {
			// Llamada al constructor de la clase Statement con un objeto de la clase Connection
			stmt = con.createStatement();
			
			// Ejecutar sentencias DDL (Data Definition Language) 
			// => como crear tablas o eliminarlas. También insertar, borrar o modificar filas de una tabla
			stmt.executeUpdate (createString);
			
		} catch (SQLException e) {
			// Mostrar el error SQL producido 
			printSQLException(e);
			
		} finally {
			// Cerrar el objeto Statement => al cerrar puede lanzar una excepcion tipo SQLException
			stmt.close();
		}
		
	} // fin createEQUIPO
	
	// Crea la tabla JUGADORES
	// el método puede generar una excepción o error de tipo SQL => throws
	// pag 236-237 libro RA-MA
	public static void createJUGADORES(Connection con, String BDNombre) throws SQLException {
	
		// cadena que define la tabla que se creará después
		String createString = "create table IF NOT EXISTS " + BDNombre + ".JUGADORES" +
			"(PLAYER_ID integer NOT NULL," +
			"TEAM_ID integer NOT NULL," +
			"NOMBRE varchar(40) NOT NULL," +
			"DORSAL integer NOT NULL," +
			"EDAD integer NOT NULL," +
			"PRIMARY KEY (PLAYER_ID)," +
			"FOREIGN KEY (TEAM_ID) REFERENCES EQUIPO (TEAM_ID))";
			
		// el objeto de stmt de la clase Statement servirá para enviar órdenes SQL
		Statement stmt = null;
		
		try {
			// Llamada al constructor de la clase Statement con un objeto de la clase Connection
			stmt = con.createStatement();
			
			// Ejecutar sentencias DDL (Data Definition Language) 
			stmt.executeUpdate(createString);
			
		} catch (SQLException e) {
			// Mostrar el error SQL producido 
			printSQLException(e);
			
		} finally {
			// Cerrar el objeto Statement => al cerrar puede lanzar una excepcion tipo SQLException
			stmt.close();
		}
		
	} // fin createJUGADORES
	
	// Insertar filas en la tabla EQUIPO
	// el método puede generar una excepción o error de tipo SQL => throws
	// pag 238 libro RA-MA
	public static void cargaEQUIPO (Connection con, String BDNombre) throws	SQLException {
		
		// el objeto de stmt de la clase Statement servirá para enviar órdenes SQL
		Statement stmt = null;
		
		try {
			// Llamada al constructor de la clase Statement con un objeto de la clase Connection
			stmt = con.createStatement();
			
			// Ejecutar sentencias DDL (Data Definition Language) 
			// en este caso se inserta las filas o registros de la BD
			stmt.executeUpdate("INSERT INTO " + BDNombre + ".EQUIPO VALUES ("
			+"1,'ESTEPONA','MONTERROSO','ESTEPONA','MALAGA','29680')");
			
			stmt.executeUpdate("INSERT INTO " + BDNombre + ".EQUIPO VALUES ("
			+"2,'ALCORCON','SANTO	DOMINGO','ALCORCON','MADRID','28924')");
			
			stmt.executeUpdate("INSERT INTO " + BDNombre + ".EQUIPO VALUES ("
			+"3,'PORCUNA','SAN CRISTOBAL','PORCUNA','JAEN','23790')");
			
		} catch (SQLException e) {
			// Mostrar el error SQL producido 
			printSQLException(e);
			
		} finally {
			// Cerrar el objeto Statement => al cerrar puede lanzar una excepcion tipo SQLException
			stmt.close();
		}
		
	} // fin cargaEQUIPO

	// Insertar filas en la tabla JUGADORES
	// el método puede generar una excepción o error de tipo SQL => throws
	// pag 238-239 libro RA-MA
	public static void cargaJUGADORES (Connection con, String BDNombre) throws SQLException {
	
		// el objeto de stmt de la clase Statement servirá para enviar órdenes SQL
		Statement stmt = null;
		
		try {
			// Llamada al constructor de la clase Statement con un objeto de la clase Connection
			stmt = con.createStatement();
			
			// Ejecutar sentencias DDL (Data Definition Language) 
			// en este caso se inserta las filas o registros de la BD
			
			//Cargando datos de Estepona
			stmt.executeUpdate("INSERT INTO " + BDNombre + ".JUGADORES VALUES ("
			+"1,1,'JOSE ANTONIO',1,42)");
			stmt.executeUpdate("INSERT INTO " + BDNombre + ".JUGADORES VALUES ("
			+"2,1,'IGNACIO',2,62)");
			stmt.executeUpdate("INSERT INTO " + BDNombre + ".JUGADORES VALUES ("
			+"3,1,'DIEGO',3,20)");
			
			//Cargando datos de Alcorcón
			stmt.executeUpdate("INSERT INTO " + BDNombre + ".JUGADORES VALUES ("
			+"4,2,'TURRION',1,37)");
			stmt.executeUpdate("INSERT INTO " + BDNombre + ".JUGADORES VALUES ("
			+"5,2,'LUIS ABEL',2,37)");
			stmt.executeUpdate("INSERT INTO " + BDNombre + ".JUGADORES VALUES ("
			+"6,2,'ISAAC',3,40)");
			
			//Cargando datos de Porcuna
			stmt.executeUpdate("INSERT INTO " + BDNombre + ".JUGADORES VALUES ("
			+"7,3,'JUAN FRANCISCO',1,33)");
			stmt.executeUpdate("INSERT INTO " + BDNombre + ".JUGADORES VALUES ("
			+"8,3,'PARRA',2,37)");
			stmt.executeUpdate("INSERT INTO " + BDNombre + ".JUGADORES VALUES ("
			+"9,3,'RAUL',3,19)");
			
		} catch (SQLException e) {
			// Mostrar el error SQL producido 
			printSQLException(e);
			
		} finally {
			// Cerrar el objeto Statement => al cerrar puede lanzar una excepcion tipo SQLException
			stmt.close();
		}
		
	} // fin cargaJUGADORES

	// Mostrar los equipos de la tabla EQUIPO
	// el método puede generar una excepción o error de tipo SQL => throws
	// pag 239-240 libro RA-MA
	public static void verEQUIPO (Connection con, String BDNombre) throws SQLException {
		
		// el objeto de stmt de la clase Statement servirá para enviar órdenes SQL
		Statement stmt = null;
		
		// cadena con la consulta SQL que será lanzada posteriormente
		String consulta = "Select EQ_NOMBRE, ESTADIO, POBLACION, PROVINCIA From " + BDNombre + ".EQUIPO";
		                  
		try {
			// Llamada al constructor de la clase Statement con un objeto de la clase Connection
			stmt = con.createStatement();
			
			// El acceso a los datos se realiza mediante ResultSet y se denomina cursor.
			// No hay que confundir con los cursores de BD. 
			// Este cursor es un puntero a una zona de memoria 
			// donde residen los datos recuperados con el comando SQL
			
			// Ejecutar sentencias Select o de consulta
			ResultSet rs = stmt.executeQuery (consulta);
			
			// Mostrar todas las filas de la tabla EQUIPO
			while ( rs.next() ) {
				String equipo = rs.getString ("EQ_NOMBRE");
				System.out.println ("Equipo: " + equipo);
				String estadio = rs.getString ("ESTADIO");
				System.out.println ("Estadio: " + estadio);
				String poblacion = rs.getString ("POBLACION");
				System.out.println ("Población: " + poblacion);
				String provincia = rs.getString ("PROVINCIA");
				System.out.println ("Provincia: " + provincia);
				System.out.println ("**********************************************");
			}
		
		} catch (SQLException e) {
			// Mostrar el error SQL producido 
			printSQLException(e);
			
		} finally {
			// Cerrar el objeto Statement => al cerrar puede lanzar una excepcion tipo SQLException
			stmt.close();
		}
	
	} // fin verEQUIPO
	
	// Otra manera de recuperar los datos de una tabla
	// Este tipo de recuperación se usa cuando varios columnas tienen el mismo tipo
	// Mostrar los equipos de la tabla EQUIPO
	// el método puede generar una excepción o error de tipo SQL => throws
	// pag 242 libro RA-MA
	public static void verEQUIPO2 (Connection con, String BDNombre) throws SQLException {
		
		// el objeto de stmt de la clase Statement servirá para enviar órdenes SQL
		Statement stmt = null;
		
		// cadena con la consulta SQL que será lanzada posteriormente
		String consulta = "Select EQ_NOMBRE, ESTADIO, POBLACION, PROVINCIA From " + BDNombre + ".EQUIPO";
		                  
		try {
			// Llamada al constructor de la clase Statement con un objeto de la clase Connection
			stmt = con.createStatement();
			
			// El acceso a los datos se realiza mediante ResultSet y se denomina cursor.
			// No hay que confundir con los cursores de BD. 
			// Este cursor es un puntero a una zona de memoria 
			// donde residen los datos recuperados con el comando SQL
			
			// Ejecutar sentencias Select o de consulta
			ResultSet rs = stmt.executeQuery (consulta);
			
			// Mostrar todas las filas de la tabla EQUIPO
			while ( rs.next() ) {
				String equipo = rs.getString (1);
				System.out.println ("Equipo: " + equipo);
				String estadio = rs.getString (2);
				System.out.println ("Estadio: " + estadio);
				String poblacion = rs.getString (3);
				System.out.println ("Población: " + poblacion);
				String provincia = rs.getString (4);
				System.out.println ("Provincia: " + provincia);
				System.out.println ("**********************************************");
			}
		
		} catch (SQLException e) {
			// Mostrar el error SQL producido 
			printSQLException(e);
			
		} finally {
			// Cerrar el objeto Statement => al cerrar puede lanzar una excepcion tipo SQLException
			stmt.close();
		}
	
	} // fin verEQUIPO2
	
	// Modifica la Tabla EQUIPO => cambiar el estadio a ALBORAN
	// el método puede generar una excepción o error de tipo SQL => throws
	// pag 243-244 libro RA-MA
	public static void modificaEQUIPO (Connection con, String BDNombre) throws SQLException {
	
		// el objeto de stmt de la clase Statement servirá para enviar órdenes SQL
		Statement stmt = null;
		
		try {
			// Llamada al constructor de la clase Statement con un objeto de la clase Connection
			stmt = con.createStatement();
			
			// Ejecutar sentencias DDL (Data Definition Language) 

			// en este caso se actualiza con UPDATE el estadio del TEAM_ID = 1 al de ALBORAN
			stmt.executeUpdate ("Update " + BDNombre + ".EQUIPO set ESTADIO = 'ALBORAN' Where TEAM_ID = 1");			
			
		} catch (SQLException e) {
			// Mostrar el error SQL producido 
			printSQLException(e);
			
		} finally {
			// Cerrar el objeto Statement => al cerrar puede lanzar una excepcion tipo SQLException
			stmt.close();
		}
		
	} // fin modificaEQUIPO
	
	// Modifica Edad de los jugadores
	// E: conexión y BD
	//    suma => valor a incrementar de la edad
	// S: nada, incrementa la edad de todos los jugadores con el valor de suma
	// el método puede generar una excepción o error de tipo SQL => throws
	// pag 244 libro RA-MA
	public static void modificaEdadJugadores (Connection con, String BDNombre, int suma) throws SQLException {
	
		// el objeto de stmt de la clase Statement servirá para enviar órdenes SQL
		Statement stmt = null;
		
		try {
			// Llamada al constructor de la clase Statement con un objeto de la clase Connection			
			// ResultSet es bidireccionable => TYPE_SCROLL_SENSITIVE y actualizable => CONCUR_UPDATABLE
			stmt = con.createStatement (ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);			
			
			// Ejecutar sentencias de consulta o Select
			ResultSet rs = stmt.executeQuery ("Select * From " + BDNombre + ".JUGADORES");
			
			// Recorrer todas las filas y actualizar la edad
			while ( rs.next() ) {
			
				// recuperar un entero (EDAD) de la tabla
				int edad = rs.getInt ("EDAD");
				
				// actualiza el entero (EDAD) 
				// => sino fuera bidireccionable y actualizable no se podría modificar la edad
				rs.updateInt ("EDAD", edad + suma);
				
				// actualizar fila de la tabla
				rs.updateRow ();			
			}			
			
		} catch (SQLException e) {
			// Mostrar el error SQL producido 
			printSQLException(e);
			
		} finally {
			// Cerrar el objeto Statement => al cerrar puede lanzar una excepcion tipo SQLException
			stmt.close();
		}
		
	} // fin modificaEdadJugadores	
	
	// E: conexión y BD
	//    player_id, nombre, dorsal y edad => datos a insertar
	// S: nada, insertar los datos en la última fila de la tabla JUGADORES usando ResultSet
	//    el método puede generar una excepción o error de tipo SQL => throws
	// pag 245 libro RA-MA
	public static void insertaJUGADOR (Connection con, String BDNombre, int player_id, int team_id,  String nombre, int dorsal, int edad) throws SQLException {		
	
		// el objeto de stmt de la clase Statement servirá para enviar órdenes SQL
		Statement stmt = null;
		
		try {
			// Llamada al constructor de la clase Statement con un objeto de la clase Connection			
			stmt = con.createStatement ();
			// ResultSet es bidireccionable => TYPE_SCROLL_SENSITIVE y actualizable => CONCUR_UPDATABLE
			stmt = con.createStatement (ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);			
			
			// Ejecutar sentencias de consulta o Select
			ResultSet rs = stmt.executeQuery ("Select * From " + BDNombre + ".JUGADORES");
			
			// Hacer hueco para insertar una fila al final
			rs.moveToInsertRow();

			// Actualizar los datos de la fila			
			rs.updateInt ("PLAYER_ID", player_id);	
			rs.updateInt ("TEAM_ID", team_id);
			rs.updateString ("NOMBRE", nombre);
			rs.updateInt ("DORSAL", dorsal);
			rs.updateInt ("EDAD", edad);
			
			// Insertar fila 
			rs.insertRow();
			// coloca el cursor antes de la primera fila
			rs.beforeFirst();			
			
		} catch (SQLException e) {
			// Mostrar el error SQL producido 
			printSQLException(e);
			
		} finally {
			// Cerrar el objeto Statement => al cerrar puede lanzar una excepcion tipo SQLException
			stmt.close();
		}
		
	} // fin insertaJUGADOR
	
	
	public static void main (String args[]) {	
		
		
	
		try {
			// Cargar la clase para el controlador de la Base de Datos 
			// => Driver JDBC => fichero jar incluido en MySQL/Connector
			// No es necesario ponerlo, aunque la ventaja de incluirlo es que 
			// mediante la excepción ClassNotFoundException te controla el error si no encuentra el driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = null;
			
			
			// Obtiene la hora local de tu ordenador y se la pasa al servidor MySQL para que no de error			
			String horaLocal = TimeZone.getDefault().getID();            

			
			// Intentar la conexión con la BD Club_Futbol => PON TU usuario CONTRASEÑA de tu usuario
			// este usuario debe tener todos los privilegios en la BD	
			// Aquí se realiza con el usuario "ramon" y la contraseña "libro" 
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Club_Futbol?serverTimezone=" + horaLocal,
					"root", "1234");
			System.out.println("\nConexión establecida!!\n");
			
			// *****************
			
			/*
			// Intentar la conexión con la BD Club_Futbol => pon tu contraseña
			connection = DriverManager.getConnection ("jdbc:mysql://localhost:3306/Club_Futbol","ramon","libro");
			System.out.println ("Conexión establecida!!");*/
		
			// Crear la tabla EQUIPO
			createEQUIPO (connection, "Club_Futbol");	
			
			// Crear la tabla JUGADORES
			createJUGADORES (connection, "Club_Futbol");	
			
			// Insertar datos en las tablas EQUIPO y JUGADORES
			cargaEQUIPO (connection, "Club_Futbol");
			cargaJUGADORES (connection, "Club_Futbol");
			
			// Mostrar la tabla EQUIPO
			// verEQUIPO (connection, "Club_Futbol");	
			System.out.println ("\nEquipo antes de cambiar\n");
			verEQUIPO2 (connection, "Club_Futbol");
			
			// Modificar el equipo
			// Cambia el estadio del TEAM_ID = 1 al de ALBORAN
			modificaEQUIPO (connection, "Club_Futbol");
			
			System.out.println ("\nEquipo después de cambiar\n");
			verEQUIPO (connection, "Club_Futbol");	
			
			// Incrementar la edad de los jugadores en 5 años
			modificaEdadJugadores (connection, "Club_Futbol", 5);
			
			// Insertar en la última fila de la tabla JUGADORES
			insertaJUGADOR (connection, "Club_Futbol", 12, 2, "Fernando", 5, 25);			
						
		} catch (SQLException e) {
			// Mostrar errores			
			printSQLException(e); // Mostrar el error SQL producido 
			System.out.println ("Error en la BD");
			e.printStackTrace();		
		} catch (ClassNotFoundException cE) {
            System.out.println("Error no se ha encontrado la clase para el controlador JDBC: " + cE.toString());
        }		
	
	} // fin main

}

/* 
Resultado de la ejecución de JDBC_RAMA.java en Windows
======================================================

Conexi├│n establecida!!

Equipo antes de cambiar

Equipo: ESTEPONA
Estadio: MONTERROSO
Poblaci├│n: ESTEPONA
Provincia: MALAGA
**********************************************
Equipo: ALCORCON
Estadio: SANTO  DOMINGO
Poblaci├│n: ALCORCON
Provincia: MADRID
**********************************************
Equipo: PORCUNA
Estadio: SAN CRISTOBAL
Poblaci├│n: PORCUNA
Provincia: JAEN
**********************************************

Equipo despu├®s de cambiar

Equipo: ESTEPONA
Estadio: ALBORAN
Poblaci├│n: ESTEPONA
Provincia: MALAGA
**********************************************
Equipo: ALCORCON
Estadio: SANTO  DOMINGO
Poblaci├│n: ALCORCON
Provincia: MADRID
**********************************************
Equipo: PORCUNA
Estadio: SAN CRISTOBAL
Poblaci├│n: PORCUNA
Provincia: JAEN
**********************************************
Presione una tecla para continuar . . .
    
 */
 
 /* Ejecución en MySQL 
  
  ramon@amd-mint ~ $ mysql -u root -p
Enter password: 
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 38
Server version: 5.5.37-0ubuntu0.12.04.1 (Ubuntu)

Copyright (c) 2000, 2014, Oracle and/or its affiliates. All rights reserved.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> CREATE DATABASE IF NOT EXISTS Club_Futbol;
Query OK, 1 row affected (0.00 sec)

mysql> use Club_Futbol;
Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A

Database changed
mysql> Select * from EQUIPO;
+---------+-----------+---------------+-----------+-----------+------------+
| TEAM_ID | EQ_NOMBRE | ESTADIO       | POBLACION | PROVINCIA | COD_POSTAL |
+---------+-----------+---------------+-----------+-----------+------------+
|       1 | ESTEPONA  | ALBORAN       | ESTEPONA  | MALAGA    | 29680      |
|       2 | ALCORCON  | SANTO	DOMINGO | ALCORCON  | MADRID    | 28924      |
|       3 | PORCUNA   | SAN CRISTOBAL | PORCUNA   | JAEN      | 23790      |
+---------+-----------+---------------+-----------+-----------+------------+
3 rows in set (0.00 sec)

mysql> Select * from JUGADORES;
+-----------+---------+----------------+--------+------+
| PLAYER_ID | TEAM_ID | NOMBRE         | DORSAL | EDAD |
+-----------+---------+----------------+--------+------+
|         1 |       1 | JOSE ANTONIO   |      1 |   47 |
|         2 |       1 | IGNACIO        |      2 |   67 |
|         3 |       1 | DIEGO          |      3 |   25 |
|         4 |       2 | TURRION        |      1 |   42 |
|         5 |       2 | LUIS ABEL      |      2 |   42 |
|         6 |       2 | ISAAC          |      3 |   45 |
|         7 |       3 | JUAN FRANCISCO |      1 |   38 |
|         8 |       3 | PARRA          |      2 |   42 |
|         9 |       3 | RAUL           |      3 |   24 |
|        12 |       2 | Fernando       |      5 |   25 |
+-----------+---------+----------------+--------+------+
10 rows in set (0.00 sec)

mysql> 

  
  
  */
