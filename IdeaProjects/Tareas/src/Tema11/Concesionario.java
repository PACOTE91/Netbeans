package Tema11;

import java.io.*;
import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TimeZone;


public class Concesionario {

    static String horaLocal = TimeZone.getDefault().getID();
    static Connection con;

    static {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario?serverTimezone=" +
                    horaLocal, "root", "1234");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void inserta () throws SQLException {
        PreparedStatement insert = null;
        Scanner str = new Scanner(System.in);
        boolean s;
        boolean e;

        try {


            System.out.println("Vamos a introducir un nuevo registro");
            System.out.println("************************************");
            System.out.println("Introduce matricula");
            String matricula = str.next();

            if (compruebaregistro(matricula) == -1) {
                System.err.println("Esta matrícula aún no esta registrada, continuemos...");
                System.out.println();
                System.out.println("Introduce marca");
                String marca = str.next();
                System.out.println("Introduce modelo");
                String modelo = str.next();
                System.out.println("Introduce color");
                String color = str.next();
                int anio = 0;
                do {
                    System.out.println("Introduce año");
                    s=false;
                    try {
                        anio = str.nextInt();
                    } catch (Exception ex) {
                        System.err.println("Error en la entrada del año");
                        str.nextLine();
                        s=true;

                    }
                } while (s);

                int precio = 0;
                do {
                    System.out.println("Introduce precio (sin decimales)");
                    e=false;
                    try {
                        precio = str.nextInt();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        System.err.println("Error en la entrada del precio");
                        str.nextLine();
                        e=true;
                    }
                } while (e);
                insert = con.prepareStatement("INSERT INTO coches VALUES (?,?,?,?,?,?)");
                insert.setString(1, matricula);
                insert.setString(2, marca);
                insert.setString(3, modelo);
                insert.setString(4, color);
                insert.setInt(5, anio);
                insert.setInt(6, precio);
                insert.executeUpdate();
                System.out.println("Vehículo con matrícula: " + matricula + " añadido");
            } else {
                System.err.println("Ya hay registros con esa matrícula");
            }

        } catch (SQLException ex) {
            // Mostrar el error SQL producido
            System.err.println(ex);
        } catch (InputMismatchException ex){
            System.err.println("Error en la entrada de datos");


        } finally {
            // Cerrar el objeto Statement => al cerrar puede lanzar una excepcion tipo SQLException
            if (insert != null) {
                insert.close();
            }
        }

    }
    public static void cargadesdearchivo (String nombrefichero) throws SQLException {
        try (Statement stmt = con.createStatement()) {

            // Abrir el fichero de texto para lectura usando un Buffer
            File f = new File(nombrefichero);

            FileReader fr = new FileReader(f);

            BufferedReader br = new BufferedReader(fr);

            // Lectura del fichero línea a línea con BufferedReader
            String linea;

            //Muestra el total de registros que hay recorriendo la tabla con un rs.next()
            System.out.println("Elementos en la base de datos antes de la inserccion: " + totalregistros() + "\n");
            pausa(); //Realiza una pausa de 2 segundos para podr visualizar la linea

            System.out.println("*****************************");
            while ((linea = br.readLine()) != null) {

                // Definir que los trozos o tokens están separados por espacios en blanco
                StringTokenizer trozo = new StringTokenizer(linea);

                //Llama al método comprueba duplicados, con un metodo contains busca coincidencias de una matrícula en la variable "linea"
                if (compruebaduplicadostexto(linea) == -1) {


                    // Crear la cadena que va a insertar los datos en la tabla COCHE
                    String comando = "Insert INTO concesionario.coches Values (" +
                            "'" + trozo.nextToken() + "'," + // Matricula
                            "'" + trozo.nextToken() + "'," + // Marca
                            "'" + trozo.nextToken() + "'," + // Modelo
                            "'" + trozo.nextToken() + "'," + // Color
                            "" + trozo.nextToken() + "," +   // Año
                            "" + trozo.nextToken() + ")";    // Precio
                    System.out.println("Registro añadido satisfactoriamente");
                    System.out.println("*****************************");
                    // Ejecutar el comando SQL que inserta los datos en la tabla
                    stmt.executeUpdate(comando);
                    pausa();

                } else {
                    System.err.println("Error, no se puede añadir el registro: [ " + linea + " ] , ya existe esta clave primeria");
                    System.out.println("********************************************************************************\n\n");
                    pausa();
                }
            } // fin while
            System.out.println("Elementos en la base de datos después de la inserccion: " + totalregistros() + "\n");
            pausa();


            // Cerrar el fichero
            fr.close();

        } catch (FileNotFoundException e) {
            System.err.println("Fichero no encontrado " + nombrefichero);

        } catch (IOException e) {
            System.err.println("Error de E/S " + nombrefichero);
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println(e);

        }

    } // fin cargaTablaCoches
    public static int compruebaduplicadostexto (String trozo) {
        int coincidencia = -1; //-1 No hay coincidencia de clave primaria
                               //1 Hay coincidencia de clave primaria
        String compruebamatricula;
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM concesionario.coches");
            while (rs.next()) {
                compruebamatricula = rs.getString(1);
                if (trozo.contains(compruebamatricula)) {
                    coincidencia = 1;
                }
            }
        } catch (SQLException se) {
            se.getMessage();
        }
        return coincidencia;

    }


    public static int compruebaregistro(String matricula) {
        int coincidencia = -1; //-1 No hay coincidencia de clave primaria
        //1 Hay coincidencia de clave primaria
        String compruebamatricula;
        try {
            // Llamada al constructor de la clase Statement con un objeto de la clase Connection
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM concesionario.coches");
            while (rs.next()) {
                compruebamatricula = rs.getString(1);
                if (compruebamatricula.equalsIgnoreCase(matricula)) {
                    coincidencia = 1;
                }
            }
        } catch (SQLException se) {
            se.getMessage();
        }
        return coincidencia;

    }

    public static void muestra() throws SQLException {
        Scanner str = new Scanner(System.in);
        String car;
        Statement st = con.createStatement();
        String consulta = "Select * From concesionario.coches";
        try {
            // Llamada al constructor de la clase Statement con un objeto de la clase Connection
            st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            String matricula, marca, modelo, color, anio, precio;

            rs.next();
            matricula = rs.getString(1);
            marca = rs.getString(2);
            modelo = rs.getString(3);
            color = rs.getString(4);
            anio = rs.getString(5);
            precio = rs.getString(6);

            System.out.println("Hay un total de: " + totalregistros());

            System.out.println("#####################################");
            System.out.println("##  Matricula: " + matricula);
            System.out.println("##  Marca: " + marca);
            System.out.println("##  Modelo: " + modelo);
            System.out.println("##  Color: " + color);
            System.out.println("##  Año: " + anio);
            System.out.println("##  Precio: " + precio);
            System.out.println("#####################################");


            System.out.println("¿Quieres mostrar el siguiente registro? (S/N)");
            car = str.next();

            while (car.equals("S") || car.equals("s")) {
                if (!rs.next()) {
                    System.err.println("##################################");
                    System.err.println("No hay mas registros para mostrar");
                    System.err.println("##################################");
                    break;

                } else {

                    matricula = rs.getString(1);
                    marca = rs.getString(2);
                    modelo = rs.getString(3);
                    color = rs.getString(4);
                    anio = rs.getString(5);
                    precio = rs.getString(6);
                    System.out.println("#####################################");
                    System.out.println("##  Matricula: " + matricula);
                    System.out.println("##  Marca: " + marca);
                    System.out.println("##  Modelo: " + modelo);
                    System.out.println("##  Color: " + color);
                    System.out.println("##  Año: " + anio);
                    System.out.println("##  Precio: " + precio);
                    System.out.println("#####################################");
                    System.out.println("¿Quieres mostrar el siguiente registro? (S/N)");
                    car = str.next();
                }
            }


        } catch (SQLException e) {
            // Mostrar el error SQL producido
            System.out.println(e);


        }catch (InputMismatchException e){
            System.err.println("Error en la entrada de datos");
        }finally {
            // Cerrar el objeto Statement => al cerrar puede lanzar una excepcion tipo SQLException
            st.close();
        }
    }

    public static int totalregistros() {
        int contador = 0;
        try {

            String sentencia = "SELECT * FROM concesionario.coches ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sentencia);

            while (rs.next()) {
                contador++;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return contador;
    } // cierra buscar

    public static void pausa() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {
        }
    }

    public static void eliminarcoche() {
        String sentencia = "DELETE FROM concesionario.coches WHERE Matricula = ?";
        String horaLocal = TimeZone.getDefault().getID();
        Scanner str=new Scanner(System.in);
        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario?serverTimezone=" +
                    horaLocal, "root", "1234");
            PreparedStatement stmt = con.prepareStatement(sentencia);
            System.out.println("Introduce una matricula a eliminar");
            String coche = str.next();

            if (compruebaregistro(coche) == 1) {

                System.out.println("Se ha encontrado un registro con la matricula: " + coche);
                System.out.println("Eliminando...");
                stmt.setString(1, coche.toUpperCase());
                stmt.executeUpdate();
                System.out.println("Vehículo con matrícula: " + coche + " eliminado\n\n");
            } else {
                System.err.println("###################################");
                System.err.println("ERROR!!!!!!!!");
                System.err.println("No hay registros con esa matrícula");
                System.err.println("###################################\n");
            }

        } catch (SQLIntegrityConstraintViolationException err) {
            err.getMessage();
            System.out.println("Error clave duplicada");
        } catch (SQLException se) {
            se.getMessage();
        }
    }

    public static void menu() {

        boolean repetir;
        Scanner str = new Scanner(System.in);
        int opcion=0;
        boolean salir = false;
        do {
            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("MENU");
                System.out.println("1. Muestra registros");
                System.out.println("2. Insertar");
                System.out.println("3. Borrar");
                System.out.println("4. Carga desde archivo");
                System.out.println("5. Salir");
                System.out.println("*********************");
                System.out.println("Introduce una opcion");

                do {
                    repetir=false;
                    try {
                        opcion = str.nextInt();
                    } catch (Exception e) {
                        System.err.println("Error en la entrada de datos");
                        System.out.println("Introduce la opcion nuevamente");
                        str.nextLine();
                        repetir=true;
                    }
                } while (repetir);


                switch (opcion) {
                    case 1 : muestra();
                    case 2 : inserta();
                    case 3 : eliminarcoche();
                    case 4 : cargadesdearchivo("coches2.txt");
                    case 5 : salir = true;
                }


            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }  catch (InputMismatchException e){
                System.err.println("Error de entrada en los datos");

            }
        } while (!salir);

    }

    public static void main(String[] args) {
        menu();
    }
}
