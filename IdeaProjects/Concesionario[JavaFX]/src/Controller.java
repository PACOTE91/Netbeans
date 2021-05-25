

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class Controller extends Application implements Initializable {

    private static String usuario;
    private static String pass;
    Stage stage = new Stage();





    @FXML
    private Button bsiguiente;
    @FXML
    private Button bborrar;
    @FXML
    private Button binsertar;
    @FXML
    private Button blimpia;
    @FXML
    private Button bfichero;
    @FXML
    private TextField ttotal;
    @FXML
    private TextField tmatricula;
    @FXML
    private TextField tmarca;
    @FXML
    private TextField tmodelo;
    @FXML
    private TextField tcolor;
    @FXML
    private TextField tanio;
    @FXML
    private TextField tprecio;


    public static Connection conectarMySQL() throws Exception {
        Connection con = null;
        String horaLocal = TimeZone.getDefault().getID();


        do {

            try {

                if (usuario==null) {
                    mostrarmensaje("Advertencia","","Aún no has iniciado sesión en la base de datos... Introduce tus datos de acceso");

                    TextInputDialog tid = new TextInputDialog();
                    tid.setHeaderText(null);
                    tid.setTitle("Inicio sesión MySQL");
                    tid.setContentText("Introduce tu usuario MySQL");
                    Optional<String> loginusuario = tid.showAndWait();
                    usuario=loginusuario.get();



                } else if (pass == null) {
                    TextInputDialog tid = new TextInputDialog();
                    tid.setHeaderText(null);
                    tid.setTitle("Inicio sesión MySQL");
                    tid.setContentText("Introduce tu contraseña MySQL");
                    Optional<String> loginpass = tid.showAndWait();
                    pass=loginpass.get();
                    if (pass.equals("")) {
                        mostrarmensaje("Casilla vacía","","No has introducido nada en el campo contraseña");
                        break;
                    }

                } else {
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario?serverTimezone=" +
                            horaLocal, usuario, pass);

                    java.util.Date fecha = new Date();

                    System.out.println("Acceso a la base de datos");
                    System.out.println(fecha.toString());
                    System.out.println("Inicio de sesion con usuario: "+usuario);
                    System.out.println("**************************************");

                }

            } catch (SQLException e) {
                mostrarAlertaError(e.toString());

                try {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Confirmación");
                    alert.setContentText("Quieres intentar con otros datos?");
                    Optional<ButtonType> action = alert.showAndWait();


                    if (action.get() == ButtonType.OK) {
                        usuario = null;
                        pass = null;
                    } else {
                        mostrarAlertaError("No se ha establecido ninguna conexión con MySQL");
                        con=null;
                        break;
                    }
                } catch (Exception exception) {
                    mostrarAlertaError(exception.toString());
                }

            }

        } while (con == null);


            return con;

    }

    public static int compruebaduplicadostexto(String trozo) {
        int coincidencia = -1; //-1 No hay coincidencia de clave primaria
        //1 Hay coincidencia de clave primaria
        String compruebamatricula;

        try {
            Statement st = null;
            try {
                st = conectarMySQL().createStatement();
            } catch (Exception e) {
                mostrarAlertaError("Error con la Base de Datos, comprueba aceso o credenciales");
            }
            ResultSet rs = st.executeQuery("SELECT * FROM concesionario.coches");
            while (rs.next()) {
                compruebamatricula = rs.getString(1);
                if (trozo.contains(compruebamatricula)) {
                    coincidencia = 1;
                }
            }
        } catch (SQLException throwables) {
            mostrarAlertaError(throwables.toString());
        }

        return coincidencia;

    }

    public void actualizarcampo(TextField campo) {
        try {
            campo.setText(String.valueOf(totalregistros()));
        } catch (Exception e) {
            mostrarAlertaError(e.toString());
        }
    }

    public static void escogerarchivo() {
        Stage stage = new Stage();
        Scanner entrada = null;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar archivo texto");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Todos archivos", "*.*"),
                new FileChooser.ExtensionFilter("Archivo de texto plano (.txt)", "*.txt"),
                new FileChooser.ExtensionFilter("Archivo excel", "*.xls")
        );

        String linea;
        try {
            Statement stmt = conectarMySQL().createStatement();
            File f = fileChooser.showOpenDialog(stage);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);


            while ((linea = br.readLine()) != null) {

                // Definir que los trozos o tokens están separados por espacios en blanco
                StringTokenizer trozo = new StringTokenizer(linea);

                //Llama al metodo comprueba duplicados, con un metodo contains busca coincidencias de una matrícula en la variable "linea"
                if (compruebaduplicadostexto(linea) == -1) {
                    // Crear la cadena que va a insertar los datos en la tabla COCHE
                    String comando = "Insert INTO concesionario.coches Values (" +
                            "'" + trozo.nextToken() + "'," + // Matricula
                            "'" + trozo.nextToken() + "'," + // Marca
                            "'" + trozo.nextToken() + "'," + // Modelo
                            "'" + trozo.nextToken() + "'," + // Color
                            "" + trozo.nextToken() + "," +   // Año
                            "" + trozo.nextToken() + ")";    // Precio
                    // Ejecutar el comando SQL que inserta los datos en la tabla
                    stmt.executeUpdate(comando);

                } else {
                    mostrarAlertaError("Error, no se puede añadir el registro: [ " + linea + " ] , ya existe esta clave primeria");
                }
            } // fin while


        } catch (NullPointerException e) {
            mostrarAlertaError("No se ha selecionado ningun archivo");
        } catch (NoSuchElementException e) {
            mostrarAlertaError("Error de sintaxis en el archivo");
        } catch (SQLException throwables) {
            mostrarAlertaError("Error en la Base de datos");
        } catch (FileNotFoundException e) {
            mostrarAlertaError("Error, archivo , no encontrado");
        } catch (IOException e) {
            mostrarAlertaError("Error de entrada / salida");
        } catch (Exception e) {
            mostrarAlertaError("Error: " + e);
        }
    }

    public static int totalregistros() throws Exception {
        int resul=0;
        try {

            /*Procedimiento creado en MySQL
            CREATE procedure totalregistros (out total int)
            SELECT count(*) INTO total FROM concesionario.coches*/

            CallableStatement cs = conectarMySQL().prepareCall("CALL totalregistros (?)");
            cs.registerOutParameter("total", Types.INTEGER);
            cs.execute();
            resul = (cs.getInt("total"));


        } catch (SQLException ex) {
            mostrarAlertaError(ex.toString());
        }
        return resul;
    } // cierra buscar

    public static int compruebaregistro(String matricula) {
        int coincidencia = -1; //-1 No hay coincidencia de clave primaria
        //1 Hay coincidencia de clave primaria
        String compruebamatricula;
        try {
            Statement st = null;
            try {
                st = conectarMySQL().createStatement();
            } catch (Exception e) {
                mostrarAlertaError("Error con las credenciales de la base de datos, o de conexion");
            }


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


    @FXML
    private void btnborrarregistro(ActionEvent event) {

        String matricula="";
        tmatricula.setEditable(true);
        PreparedStatement ps = null;
        int respuesta;


        try {
            actualizarcampo(ttotal);
            ps = conectarMySQL().prepareStatement("DELETE FROM concesionario.coches WHERE Matricula = ?");

            TextInputDialog tid = new TextInputDialog();
            tid.setHeaderText(null);
            tid.setTitle("Matrícula");
            tid.setContentText("Introduce matrícula para borrar");
            Optional<String> matri = tid.showAndWait();
            if (matri.isPresent()) {
                matricula = matri.get();
            }

            if (compruebaregistro(matricula) == 1) {
                //textoeditable();
                Alert dialogoConfirmacion = new Alert(Alert.AlertType.CONFIRMATION);
                dialogoConfirmacion.setTitle("Diálogo de confirmación");
                dialogoConfirmacion.setHeaderText("Registro encontrado");
                dialogoConfirmacion.setContentText("Hemos encontrado un registro coincidente... ¿Quieres eliminarlo?");
                Optional<ButtonType> opciones = dialogoConfirmacion.showAndWait();

                if (opciones.get() == ButtonType.OK) {

                    ps.setString(1, matricula.toUpperCase());
                    ps.executeUpdate();
                    actualizarcampo(ttotal);
                } else if (opciones.get() == ButtonType.CANCEL) {
                    mostrarmensaje("Eliminación datos","No se han eliminado datos","Registro conservado");
                    actualizarcampo(ttotal);
                }

            } else {
                mostrarAlertaError("ERROR!! Ya existe la matrícula");
            }

        } catch (SQLException ex) {
            // Mostrar el error SQL producido
            mostrarAlertaError(ex.toString());
        } catch (InputMismatchException ex) {
            mostrarAlertaError("Error en la entrada de datos");
        } catch (Exception e) {
            mostrarAlertaError(e.toString());
        } finally {
            // Cerrar el objeto Statement => al cerrar puede lanzar una excepcion tipo SQLException
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    mostrarAlertaError(ex.toString());
                }
            }
        }
    }

    @FXML
    private void btninsertarregistro(ActionEvent event) {
        int ano;
        int prec;
        String matricula = null;
        tmatricula.setEditable(true);
        PreparedStatement ps = null;


        try {

            actualizarcampo(ttotal);
            ps = conectarMySQL().prepareStatement("INSERT INTO coches VALUES (?,?,?,?,?,?)");

            if (tmatricula.getText().equals("")) {
                TextInputDialog tid = new TextInputDialog();
                tid.setHeaderText(null);
                tid.setTitle("Matrícula");
                tid.setContentText("Introduce matrícula para insertar");
                Optional<String> matri = tid.showAndWait();
                matricula=matri.get();

                if (tmatricula.equals("")) {
                    mostrarAlertaError("Error, no has introducido una matricula");
                } else {
                    if (compruebaregistro(matricula) == -1) {
                        mostrarmensaje("","No hay registros repetidos","Introduce el resto de datos y pulsa insertar nuevamente");
                        actualizarcampo(ttotal);
                        tmatricula.setText(matricula.toUpperCase());
                        tmatricula.setEditable(false);
                    }
                }

            } else {

                ps = conectarMySQL().prepareStatement("INSERT INTO coches VALUES (?,?,?,?,?,?)");
                ps.setString(1, tmatricula.getText());

                if (tmarca.getText().equals("") || tmodelo.getText().equals("") || tcolor.getText().equals("")) {
                    mostrarAlertaError("ERROR!! Alguno de los parámetros es nulo");

                } else {
                    ano = Integer.parseInt(tanio.getText());
                    prec = Integer.parseInt(tprecio.getText());
                    ps.setString(1, tmatricula.getText());
                    ps.setString(2, tmarca.getText());
                    ps.setString(3, tmodelo.getText());
                    ps.setString(4, tcolor.getText());
                    ps.setInt(5, ano);
                    ps.setInt(6, prec);
                    ps.executeUpdate();
                    mostrarmensaje("Inserción","Has insertado un registro","Registro de * " + tmatricula.getText() + " * insertado");
                    actualizarcampo(ttotal);
                }
            }

        } catch (SQLException ex) {
            // Mostrar el error SQL producido
            mostrarAlertaError("Error de SQL");
        } catch (NullPointerException ex) {
            mostrarAlertaError("Error de parámetro nulo");
        } catch (NumberFormatException ex) {
            mostrarAlertaError("Error en la entrada de datos numericos");
        } catch (Exception e) {
            mostrarAlertaError(e.toString());
        } finally {
            // Cerrar el objeto Statement => al cerrar puede lanzar una excepcion tipo SQLException
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    mostrarAlertaError(ex.toString());
                }
            }
        }

    }

    @FXML
    private void btnmostrarregistros(ActionEvent event) {
        try {
            int respuesta;
            boolean salir = false;
            String matricula, marca, modelo, color, anio, precio;
            Statement st = conectarMySQL().createStatement();
            try {
                String consulta = "Select * From concesionario.coches";
                ResultSet rs = st.executeQuery(consulta);
                totalregistros();
                actualizarcampo(ttotal);
                int contador=0;
                do {

                    if (rs.next()) {
                        matricula = rs.getString(1);
                        tmatricula.setText(matricula);
                        marca = rs.getString(2);
                        tmarca.setText(marca);
                        modelo = rs.getString(3);
                        tmodelo.setText(modelo);
                        color = rs.getString(4);
                        tcolor.setText(color);
                        anio = rs.getString(5);
                        tanio.setText(anio);
                        precio = rs.getString(6);
                        tprecio.setText(precio);
                        contador ++;
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setHeaderText("Confirmación");
                        alert.setTitle("Aceptar para mostrar el siguiente registro");
                        alert.setContentText("Mostrando registro "+contador+" de "+totalregistros());
                        Optional<ButtonType> action = alert.showAndWait();


                        if (action.get() == ButtonType.OK) {
                            matricula = rs.getString(1);
                            tmatricula.setText(matricula);
                            marca = rs.getString(2);
                            tmarca.setText(marca);
                            modelo = rs.getString(3);
                            tmodelo.setText(modelo);
                            color = rs.getString(4);
                            tcolor.setText(color);
                            anio = rs.getString(5);
                            tanio.setText(anio);
                            precio = rs.getString(6);
                            tprecio.setText(precio);
                            salir = true;

                        } else {
                            mostrarmensaje("Mostrando registros","","Has decidido no mostrar mas registros");
                            salir = false;

                        }
                    } else {
                        mostrarmensaje("Mostrando registros","Has llegado al registro "+totalregistros()+" de "+totalregistros(),
                                "No hay mas registros para mostrar");
                        actualizarcampo(ttotal);
                        bsiguiente.setDisable(true);
                        salir = false;
                    }
                } while (salir);

            } catch (SQLException e) {
                // Mostrar el error SQL producido
                mostrarAlertaError(e.toString());

            } finally {
                try {
                    // Cerrar el objeto Statement => al cerrar puede lanzar una excepcion tipo SQLException
                    st.close();
                } catch (SQLException ex) {
                    mostrarAlertaError(ex.toString());                }
            }

        } catch (Exception ex) {
                    mostrarAlertaError(ex.toString());
        }
    }

    @FXML
    private void btnfichero(ActionEvent event) throws Exception {
        // TODO add your handling code here:
        escogerarchivo();
        actualizarcampo(ttotal);


    }

    private static void mostrarAlertaError(String tipoerror) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText(tipoerror);
        alert.showAndWait();
    }

    private static void mostrarmensaje(String cabecera, String cuerpo, String descripcion) {
        Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
        dialogoInfo.setTitle(cabecera);
        dialogoInfo.setHeaderText(cuerpo);
        dialogoInfo.setContentText(descripcion);
        dialogoInfo.showAndWait();
    }

    @FXML
    private void btnlimpiar(ActionEvent event) {
        // TODO add your handling code here:
        tcolor.setText("");
        tmarca.setText("");
        tmatricula.setText("");
        tmodelo.setText("");
        tprecio.setText("");
        tanio.setText("");


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
