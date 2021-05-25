package Tema11;// Requisitos:

// MySQL instalado y configurado
// debe haber un usuario root (o similar) con contraseña y todos los privilegios

// Debes tener creada una Base de Datos vacia denominada Banco
// Instrucción MySQL a ejecutar para crearla: 
// create database if not exists Banco;


/* Para crear la función almacenada dimeCuantos() => devuelve el nº de filas de la tabla Cuentas 
   en MySQL ejecuta:
mysql> delimiter //
mysql> create Function Banco.dimeCuantos()
    -> returns int
    -> begin
    -> declare j int;
    -> select count(*) into j from Cuentas;
    -> return j;
    -> end //
Query OK, 0 rows affected (0.00 sec)

mysql> delimiter ;

ojo!! para ejecutar la  función en mySQL debe exister la tabla Cuentas 
=> se crea en este programa de java

mysql> Select dimeCuantos();
+---------------+
| dimeCuantos() |
+---------------+
|             5 |
+---------------+
1 row in set (0.00 sec)

mysql> use books;

mysql> Select Banco.dimeCuantos();
mysql> select Banco.dimeCuantos() from DUAL;



ASEGURATE QUE LA B.D ES LA DE Banco antes de crear el procedimiento almacenado
o pon el nombre Banco.cuentaCuentas3

mysql> use Banco;

* 
* 
******** Procedimientos almacenados ********

mysql> delimiter //
mysql> create procedure cuentaCuentas3(out c int)
    -> begin
    -> select count(*) into c from Banco.Cuentas;
    -> end //
Query OK, 0 rows affected (0.00 sec)

mysql> delimiter ;

*/

// El programa debes ejecutarlo una sola vez
// La segunda vez que lo ejecutas dará error ya que no se puede insertar datos con llave primaria repetida

import java.sql.*;
import java.util.TimeZone;

public class JDBC_RAMA2 {
	
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

	// Crea la tabla Cuentas
	// el método puede generar una excepción o error de tipo SQL => throws	
	public static void createCuentas(Connection con, String BDNombre) throws SQLException {
	
		/* El motor de almacenamiento se encarga de almacenar, manejar y recuperar información 
		 * de una tabla. Los motores más conocidos son MyISAM e InnoDB. 
		 *  Si necesitamos transacciones, claves foráneas y bloqueos, tendremos que escoger InnoDB. 
		 * Por el contrario, escogeremos MyISAM en aquellos casos en los que predominen 
		 * las consultas SELECT a la base de datos. */
		 
		// cadena que define la tabla de tipo InnoDB para que admita transacciones
		String createString = "create table IF NOT EXISTS " + BDNombre + ".Cuentas " +
			"(num_cuenta integer NOT NULL," +
			"saldo double NOT NULL," +
			"PRIMARY KEY (num_cuenta)) ENGINE=InnoDB";
			
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
			// Cerrar el objeto Statement
			stmt.close();
		}
		
	} // fin createCuentas

	// Insertar filas en la tabla Cuentas
	// el método puede generar una excepción o error de tipo SQL => throws
	public static void cargaCuentas (Connection con, String BDNombre) throws	SQLException {
		
		// el objeto de stmt de la clase Statement servirá para enviar órdenes SQL
		Statement stmt = null;
		
		try {
			// Llamada al constructor de la clase Statement con un objeto de la clase Connection
			stmt = con.createStatement();
			
			// Ejecutar sentencias DDL (Data Definition Language) 
			// en este caso se inserta las filas o registros de la BD
			stmt.executeUpdate("INSERT INTO " + BDNombre + ".Cuentas VALUES (1,3000)");
			stmt.executeUpdate("INSERT INTO " + BDNombre + ".Cuentas VALUES (2,2500)");
			stmt.executeUpdate("INSERT INTO " + BDNombre + ".Cuentas VALUES (5,5000)");
			stmt.executeUpdate("INSERT INTO " + BDNombre + ".Cuentas VALUES (4,200)");
			stmt.executeUpdate("INSERT INTO " + BDNombre + ".Cuentas VALUES (3,300)");			
			
		} catch (SQLException e) {
			// Mostrar el error SQL producido 
			printSQLException(e);
			
		} finally {
			// Cerrar el objeto Statement => puede generar la excepcion SQLException
			stmt.close();
		}
		
	} // fin cargaCuentas

	// Realiza una Transacción => movimiento de dinero desde la cuentaA a la cuentaB
	// el método puede generar una excepción o error de tipo SQL => throws
	// pag 247 del libro de RA-MA
	public static void transaccion (Connection con, String BD, int cuentaA, int cuentaB, int cantidad) 	
			throws	SQLException {
		
		// el objeto de stmt de la clase Statement servirá para enviar órdenes SQL
		Statement stmt = null;

		// quita 'cantidad' del saldo de la cuenta A
		String actualizaA = "update " + BD + ".Cuentas" + " set saldo = saldo - " + cantidad + 
		                    " where num_cuenta = " + cuentaA;

		// añade 'cantidad' al saldo de la cuenta B
		String actualizaB = "update " + BD + ".Cuentas" + " set saldo = saldo + " + cantidad + 
		                    " where num_cuenta = " + cuentaB;
		
		// Puedes probarlo asi para provocar que falle y que el rollback se ejecute:
		//String actualizaB = "update " + BD + ".Cuentas" + " set saldo = saldo + " + cantidad + " where num_cuentaZZZ = " + cuentaB;
		                    
		
		try {
			// No se producen cambios en la BD cuando se ejecutan las sentencias SQL
			con.setAutoCommit (false);

			// Llamada al constructor de la clase Statement con un objeto de la clase Connection
			stmt = con.createStatement();
			
			// Ejecutar sentencias DDL (Data Definition Language) 
			// en este caso actualizar el valor de dos cuentas
			stmt.executeUpdate (actualizaA);
			stmt.executeUpdate (actualizaB);			

		} catch (SQLException e) {
			// Mostrar el error SQL producido 
			printSQLException(e);
			
			// hay que comprobar que el error no se ha producido por no establecer la conexión
			if (con != null) {
				try {
					System.err.println ("Roll Back (vuelta atrás) de la transacción");
					
					// establecer la vuelta atrás o Roll Back de la transacción
					con.rollback();
									
				} catch (SQLException ex) {
					// Mostrar el error SQL producido 
					printSQLException(ex);
				}
			}
			
		} finally {
			// Cerrar el objeto Statement => puede generar la excepcion SQLException
			stmt.close();
			
			// Ahora es seguro que se han realizado las 2 sentencias SQL actualizaA y actualizaB
			// hay que hacerlas efectivas con el commit
			con.setAutoCommit (true);
		}
	
	} // fin transaccion
	
	// Ejecuta la función almacenada dimeCuantos() para obtener el nº de cuentas de la tabla Cuentas
	// el método puede generar una excepción o error de tipo SQL => throws
	// ejemplo parecido al de la página 247 del libro de RA-MA
	public static void getCuentas (Connection con) throws	SQLException {
		
		// el objeto de stmt de la clase Statement servirá para enviar órdenes SQL
		Statement stmt = null;
		
		try {
			// Llamada al constructor de la clase Statement con un objeto de la clase Connection
			stmt = con.createStatement();
			
			// El acceso a los datos se realiza mediante ResultSet y se denomina cursor.
			// No hay que confundir con los cursores de BD. 
			// Este cursor es un puntero a una zona de memoria 
			// donde residen los datos recuperados con el comando SQL
			
			// Ejecutar sentencias Select o de consulta => ejecuta la función almacenada			
			ResultSet rs = stmt.executeQuery ("select Banco.dimeCuantos() from DUAL");
			
			// También funciona así:
			// ResultSet rs = stmt.executeQuery ("select Banco.dimeCuantos()");			

			// si lo haces sobre la tabla Cuentas te mostrará tantos resultados como filas tenga la tabla cuentas			
			// ResultSet rs = stmt.executeQuery ("select dimeCuantos() from Banco.Cuentas");
			
			// Mostrar el resultado de la ejecución de la función almacenada
			while ( rs.next() ) {
				String numero_cuentas = rs.getString (1);
				System.out.println ("Existen " + numero_cuentas + " cuentas en el banco");
			}
		
		} catch (SQLException e) {
			// Mostrar el error SQL producido 
			printSQLException(e);
			
		} finally {
			// Cerrar el objeto Statement => puede generar la excepcion SQLException
			stmt.close();
		}		
		
	} // fin getCuentas
	
	
	// Cuenta el nº de cuentas con un procedimiento almacenado de la BD Banco
	// el método puede generar una excepción o error de tipo SQL => throws
	public static void getCuentasProc (Connection con) throws SQLException {	
		
		try {
			// La clase CallableStatement es usada para llamar a procedimientos almacenados
			CallableStatement cs = con.prepareCall ("{call cuentaCuentas3(?)}");
			
			// registrar el parámetro de salida => de tipo entero
			cs.registerOutParameter	(1,Types.INTEGER);
			
			// ejecutar el procedimiento almacenado
			cs.execute();
			int numero = cs.getInt(1);
			
			System.out.println ("Existen " + numero + " cuentas en el banco");			
			
		} catch (SQLException e) {
			// Mostrar el error SQL producido 
			printSQLException(e);
		}
		
	} // fin getCuentasProc
	
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
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Banco?serverTimezone=" + horaLocal,
													"root", "1234");
			System.out.println("\nConexión establecida!!\n");							
			
			
			// Crear la tabla Cuentas
			createCuentas (connection, "Banco");	
			
			// Insertar datos en las tabla Cuentas	
			cargaCuentas (connection, "Banco"); 		
			
			// Mover 100 € de la cuenta 1 a la cuenta 3
			transaccion (connection, "Banco", 1, 3, 100);
			
			
			// Obtener el nº de cuentas del banco con una función de usuario
			getCuentas (connection);			
			
			// Obtener el nº de cuentas del banco con un procedimiento almacenado		
			getCuentasProc (connection);
						
		} catch (SQLException e) {
			// Mostrar errores			
			printSQLException(e); // Mostrar el error SQL producido 
			System.out.println ("Error en la BD");
			e.printStackTrace();		
		} catch (ClassNotFoundException cE) {
            System.out.println("Error no se ha encontrado la clase para el controlador JDBC: " + cE.toString());
        }		
	
	} // fin main

} // fin clase JDBC_RAMA2



/* ******* EJECUCIÓN en MySQL ********
 
mysql> create database if not exists Banco;
Query OK, 1 row affected (0.00 sec)

mysql> delimiter //
mysql> create Function Banco.dimeCuantos()
    returns int
    begin
    declare j int;
    select count(*) into j from Cuentas;
    return j;
    end //
Query OK, 0 rows affected (0.01 sec)

mysql> delimiter ;

* 
* FIJATE QUE LA B.D ACTUAL ES Club_Futbol y no Banco
* por eso da error
* 

mysql> Select dimeCuantos();
ERROR 1305 (42000): FUNCTION Club_Futbol.dimeCuantos does not exist
* 


MAL CREADA EL PROCEDIMIENTO ALMACENADO YA QUE LO HACE SOBRE LA B.D DE Club_Futbol y no Banco

mysql> delimiter //
mysql> create procedure cuentaCuentas(out c int)
    -> begin
    -> select count(*) into c from Banco.Cuentas;
    -> end //
Query OK, 0 rows affected (0.00 sec)

mysql> delimiter ;
mysql> Select dimeCuantos();
ERROR 1305 (42000): FUNCTION Club_Futbol.dimeCuantos does not exist
mysql> use Club_Futbol;
Database changed
mysql> Select dimeCuantos();
ERROR 1305 (42000): FUNCTION Club_Futbol.dimeCuantos does not exist
mysql> Use Banco;
Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A

Database changed
mysql> Select dimeCuantos();
+---------------+
| dimeCuantos() |
+---------------+
|             5 |
+---------------+
1 row in set (0.00 sec)

mysql> Select dimeCuantos() from dual;
+---------------+
| dimeCuantos() |
+---------------+
|             5 |
+---------------+
1 row in set (0.00 sec)



HAY QUE ASEGURARSE DE CREAR EL PROCEDIMIENTO ALMACENADO EN LA B.D Banco

mysql> use Banco;
Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A

Database changed
* 
* AHORA SI SE CREA BIEN EL PROCEDIMIENTO ALMACENADO 
*
mysql> delimiter //
mysql> create procedure cuentaCuentas3(out c int)
       begin
       select count(*) into c from Banco.Cuentas;
       end //
Query OK, 0 rows affected (0.00 sec)

mysql> delimiter ;
mysql> 
* 
* 

Consultar documentación oficial de la versión de la BD de MySQL que uses

http://dev.mysql.com/doc/connector-j/en/connector-j-usagenotes-statements-callable.html#connector-j-examples-output-param
 
http://dev.mysql.com/doc/refman/5.6/en/index.html


*/
