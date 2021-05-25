package Tema11;/* 1.) Basándote en la clase JDBC_RAMA, esta clase se debe haber ejecutado
 * una sola vez para tener creada la BD Club_Futbol y sus tablas 
 * (entre ellas la tabla JUGADORES), crea una nueva clase denominada ejer1 
 * e incluye un método denominado verJUGADORES que 
 * permita realizar cualquier consulta sencilla sobre la tabla JUGADORES, por ejemplo: 

a) Mostrar el contenido de la tabla JUGADORES.

b) Mostrar el contenido de la tabla jugadores ordenada por el Nombre del jugador.

c) Mostrar los jugadores cuyo número de equipo sea el 2

Pista: el método puede recibir la consulta a realizar, así luego puedes llamar el método con la consulta a),  luego realizar una segunda llamada con la consulta b) y otra para la consulta c) */

import java.sql.*;
import java.util.TimeZone;

public class ejer1 {

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


	// Mostrar los jugadores de la tabla JUGADORES
	// el método puede generar una excepción o error de tipo SQL => throws	
	public static void verJUGADORES (Connection con, String consulta) throws SQLException {
		
		// el objeto de stmt de la clase Statement servirá para enviar órdenes SQL
		Statement stmt = null;		
		                  
		try {
			// Llamada al constructor de la clase Statement con un objeto de la clase Connection
			stmt = con.createStatement();
			
			// El acceso a los datos se realiza mediante ResultSet y se denomina cursor.
			// No hay que confundir con los cursores de BD. 
			// Este cursor es un puntero a una zona de memoria 
			// donde residen los datos recuperados con el comando SQL
			
			// Ejecutar sentencias Select o de consulta
			ResultSet rs = stmt.executeQuery (consulta);
			
			// Mostrar todas las filas de la tabla JUGADORES
			while ( rs.next() ) {
				int num_jugador = rs.getInt ("PLAYER_ID");
				System.out.println ("Número de jugador: " + num_jugador);
				
				int num_equipo = rs.getInt ("TEAM_ID");
				System.out.println ("Número de equipo: " + num_equipo);
				
				String nombre = rs.getString ("NOMBRE");
				System.out.println ("Nombre del jugador: " + nombre);
				
				int dorsal = rs.getInt ("DORSAL");
				System.out.println ("Dorsal: " + dorsal);
				
				int edad = rs.getInt ("EDAD");
				System.out.println ("Edad: " + edad);			
				
				System.out.println ("**********************************************");
			}
		
		} catch (SQLException e) {
			// Mostrar el error SQL producido 
			printSQLException(e);
			
		} finally {
			// Cerrar el objeto Statement
			stmt.close();
		}
	
	} // fin verJUGADORES
	
	
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
			
			// Intentar la conexión con la BD Club_Futbol => PON TU usuario CONTRASEÑA de tu usuario
			// este usuario debe tener todos los privilegios en la BD	
			// Aquí se realiza con el usuario "ramon" y la contraseña "libro" 
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Club_Futbol?serverTimezone=" + horaLocal, "ramon", "libro");
			System.out.println("\nConexión establecida!!\n");			
					
			
			// Mostrar la tabla JUGADORES			
			System.out.println ("\nListado de jugadores:\n");			
			// cadena con la consulta SQL que será lanzada posteriormente
			String consulta = "Select * From Club_Futbol.JUGADORES";
			verJUGADORES (connection, consulta);
			
			// Mostrar la tabla JUGADORES	ordenada por el nombre
			System.out.println ("\nListado de jugadores ordenados por el nombre:\n");			
			// cadena con la consulta SQL que será lanzada posteriormente
			consulta = "Select * From Club_Futbol.JUGADORES Order By NOMBRE";
			verJUGADORES (connection, consulta);
			
			// Mostrar los jugadores cuyo número de equipo sea el 2
			System.out.println ("\nListado de jugadores cuyo equipo es el 2:\n");			
			// cadena con la consulta SQL que será lanzada posteriormente
			consulta = "Select * From Club_Futbol.JUGADORES Where TEAM_ID = 2";
			verJUGADORES (connection, consulta);
						
						
		} catch (SQLException e) {
			// Mostrar el error SQL producido 
			printSQLException(e);		
		} catch (ClassNotFoundException cE) {
            System.out.println("Error no se ha encontrado la clase para el controlador JDBC: " + cE.toString());
        }	
	
	} // fin main

} // fin clase ejer1


/*Posible resultado de ejecución, recuerda que la clase JDBC_RAMA
 * se debe haber ejecutado una sola vez para tener creada
 * la BD Club_Futbol y sus tablas 
 * (entre ellas la tabla JUGADORES)

Conexión establecida!!


Listado de jugadores:

Número de jugador: 1
Número de equipo: 1
Nombre del jugador: JOSE ANTONIO
Dorsal: 1
Edad: 47
**********************************************
Número de jugador: 2
Número de equipo: 1
Nombre del jugador: IGNACIO
Dorsal: 2
Edad: 67
**********************************************
Número de jugador: 3
Número de equipo: 1
Nombre del jugador: DIEGO
Dorsal: 3
Edad: 25
**********************************************
Número de jugador: 4
Número de equipo: 2
Nombre del jugador: TURRION
Dorsal: 1
Edad: 42
**********************************************
Número de jugador: 5
Número de equipo: 2
Nombre del jugador: LUIS ABEL
Dorsal: 2
Edad: 42
**********************************************
Número de jugador: 6
Número de equipo: 2
Nombre del jugador: ISAAC
Dorsal: 3
Edad: 45
**********************************************
Número de jugador: 7
Número de equipo: 3
Nombre del jugador: JUAN FRANCISCO
Dorsal: 1
Edad: 38
**********************************************
Número de jugador: 8
Número de equipo: 3
Nombre del jugador: PARRA
Dorsal: 2
Edad: 42
**********************************************
Número de jugador: 9
Número de equipo: 3
Nombre del jugador: RAUL
Dorsal: 3
Edad: 24
**********************************************
Número de jugador: 12
Número de equipo: 2
Nombre del jugador: Fernando
Dorsal: 5
Edad: 25
**********************************************

Listado de jugadores ordenados por el nombre:

Número de jugador: 3
Número de equipo: 1
Nombre del jugador: DIEGO
Dorsal: 3
Edad: 25
**********************************************
Número de jugador: 12
Número de equipo: 2
Nombre del jugador: Fernando
Dorsal: 5
Edad: 25
**********************************************
Número de jugador: 2
Número de equipo: 1
Nombre del jugador: IGNACIO
Dorsal: 2
Edad: 67
**********************************************
Número de jugador: 6
Número de equipo: 2
Nombre del jugador: ISAAC
Dorsal: 3
Edad: 45
**********************************************
Número de jugador: 1
Número de equipo: 1
Nombre del jugador: JOSE ANTONIO
Dorsal: 1
Edad: 47
**********************************************
Número de jugador: 7
Número de equipo: 3
Nombre del jugador: JUAN FRANCISCO
Dorsal: 1
Edad: 38
**********************************************
Número de jugador: 5
Número de equipo: 2
Nombre del jugador: LUIS ABEL
Dorsal: 2
Edad: 42
**********************************************
Número de jugador: 8
Número de equipo: 3
Nombre del jugador: PARRA
Dorsal: 2
Edad: 42
**********************************************
Número de jugador: 9
Número de equipo: 3
Nombre del jugador: RAUL
Dorsal: 3
Edad: 24
**********************************************
Número de jugador: 4
Número de equipo: 2
Nombre del jugador: TURRION
Dorsal: 1
Edad: 42
**********************************************

Listado de jugadores cuyo equipo es el 2:

Número de jugador: 4
Número de equipo: 2
Nombre del jugador: TURRION
Dorsal: 1
Edad: 42
**********************************************
Número de jugador: 5
Número de equipo: 2
Nombre del jugador: LUIS ABEL
Dorsal: 2
Edad: 42
**********************************************
Número de jugador: 6
Número de equipo: 2
Nombre del jugador: ISAAC
Dorsal: 3
Edad: 45
**********************************************
Número de jugador: 12
Número de equipo: 2
Nombre del jugador: Fernando
Dorsal: 5
Edad: 25
**********************************************


------------------
(program exited with code: 0)
Press return to continue
  */

 

