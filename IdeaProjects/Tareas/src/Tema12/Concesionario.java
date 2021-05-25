
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;

/**
 * @author PACOFENOY
 */
public class Concesionario extends javax.swing.JFrame {

    private static String usuario;
    private static String pass;



    /**
     * Metodo que conecta con la base de datos MySQL
     *
     * @return Devuelve los datos de conexion con la BD, se expecifican puertos, usuarios, contraseña...
     */
    public static Connection conectarMySQL() {
        Connection con = null;
        String horaLocal = TimeZone.getDefault().getID();


        do{

            try{

                if(usuario==null){
                    usuario = JOptionPane.showInputDialog(null,"Introduce tu usuario","Introduce tu usuario", JOptionPane.PLAIN_MESSAGE);

                }else if(pass==null){
                    pass = JOptionPane.showInputDialog(null,"Introduce tu usuario","Introduce tu usuario", JOptionPane.PLAIN_MESSAGE);
                }else if(pass!=null && usuario!=null){
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario?serverTimezone=" +
                            horaLocal, usuario, pass);

                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error conectar con la Base de Datos");
                JOptionPane.showMessageDialog(null, e);

                int respuesta = JOptionPane.showConfirmDialog(null, "¿Quieres salir o intentar con otros datos? (1º opcion salir, 2ª continuar)");

                if (respuesta == 0) {
                    System.exit(0);
                } else {
                    usuario = null;
                    pass = null;
                }

            }

        } while (con == null);

        return con;
    }

    /**
     * Creates new form Concesionario
     */
    public Concesionario() {
        initComponents();

    }

    /**
     * Este metodo se usa para ficheros de texto que añaden registros y comprueba que en la linea que está leyendo
     * no se encuentra una matrícula ya registrada
     * @param trozo REcibe de parámetro la línea de texto que se está leyendo
     * @return Devuelve -1 si en esa linea encuentra un fragmento de texto coincidente con la matricula
     */
    public static int compruebaduplicadostexto(String trozo) {
        int coincidencia = -1; //-1 No hay coincidencia de clave primaria
        //1 Hay coincidencia de clave primaria
        String compruebamatricula;

        try {
            Statement st = conectarMySQL().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM concesionario.coches");
            while (rs.next()) {
                compruebamatricula = rs.getString(1);
                if (trozo.contains(compruebamatricula)) {
                    coincidencia = 1;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return coincidencia;

    }

    /**
     * Este metodo establece el total de registros para un campo pasado por parametro
     * @param campo Campo de texto que queremos establecer el valor total
     */
    public void actualizarcampo(javax.swing.JTextField campo) {
        campo.setText(Integer.toString(totalregistros()));
    }

    /**
     * Este metodo seleciona un archivo de forma gráfica, lo procesa y añade uno a uno los registros a nuestra BD
     * además llama al metodo compruebaduplicados que nos devuelve si hay coincidencias de registros reptidos
     */
    public static void escogerarchivo() {
        Scanner entrada = null;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(fileChooser);
        String linea;
        try {
            Statement stmt = conectarMySQL().createStatement();
            String ruta = fileChooser.getSelectedFile().getAbsolutePath();
            File f = new File(ruta);
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
                    JOptionPane.showMessageDialog(null, "Error, no se puede añadir el registro: [ " + linea + " ] , ya existe esta clave primeria", "Clave primaria repetida", JOptionPane.ERROR_MESSAGE);
                }
            } // fin while


        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "No se ha selecionado ningun archivo", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
        } catch (NoSuchElementException e) {
            JOptionPane.showMessageDialog(null, "Error de sintaxis en el archivo", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException throwables) {
            JOptionPane.showMessageDialog(null, "Error en la Base de datos", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error, archivo , no encontrado", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error de entrada / salida", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e, "Mensaje de error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Este metodo a traves de un contador devuelve el total de registros de nuestra BD
     * @return Suma de registros
     */

    public static int totalregistros() {
        int contador = 0;
        try {

            String sentencia = "SELECT * FROM concesionario.coches ";
            Statement st = conectarMySQL().createStatement();
            ResultSet rs = st.executeQuery(sentencia);

            while (rs.next()) {
                contador++;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return contador;
    } // cierra buscar

    /**
     * Este metodo comprueba que no exista una matrícula (clave primaria) en nuestra BD
     * @param matricula
     * @return -1 Si no hay coincidencia y 1 si existe coincidencia
     */
    public static int compruebaregistro(String matricula) {
        int coincidencia = -1; //-1 No hay coincidencia de clave primaria
        //1 Hay coincidencia de clave primaria
        String compruebamatricula;
        try {
            Statement st = conectarMySQL().createStatement();


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


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tmatricula = new javax.swing.JTextField();
        tmarca = new javax.swing.JTextField();
        tmodelo = new javax.swing.JTextField();
        tcolor = new javax.swing.JTextField();
        tanio = new javax.swing.JTextField();
        tprecio = new javax.swing.JTextField();
        bsiguiente = new javax.swing.JButton();
        bborrar = new javax.swing.JButton();
        binsertar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        ttotal = new javax.swing.JTextField();
        bborrar1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Concesionario");
        jLabel1.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Matrícula:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Marca:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Modelo:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Color:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Año:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Precio");

        tmatricula.setBackground(new java.awt.Color(204, 204, 204));
        tmatricula.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tmatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tmatriculaActionPerformed(evt);
            }
        });

        tmarca.setBackground(new java.awt.Color(204, 204, 204));
        tmarca.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tmarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tmarcaActionPerformed(evt);
            }
        });

        tmodelo.setBackground(new java.awt.Color(204, 204, 204));
        tmodelo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tmodelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tmodeloActionPerformed(evt);
            }
        });

        tcolor.setBackground(new java.awt.Color(204, 204, 204));
        tcolor.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tcolor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcolorActionPerformed(evt);
            }
        });

        tanio.setBackground(new java.awt.Color(204, 204, 204));
        tanio.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tanio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tanioActionPerformed(evt);
            }
        });

        tprecio.setBackground(new java.awt.Color(204, 204, 204));
        tprecio.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tprecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tprecioActionPerformed(evt);
            }
        });

        bsiguiente.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bsiguiente.setText("Mostrar registros");
        bsiguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bsiguiente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bsiguiente.setMargin(new java.awt.Insets(1, 1, 1, 1));
        bsiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsiguienteActionPerformed(evt);
            }
        });

        bborrar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bborrar.setLabel("Borrar registro");
        bborrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bborrarActionPerformed(evt);
            }
        });

        binsertar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        binsertar.setLabel("Insertar registro");
        binsertar.setName(""); // NOI18N
        binsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                binsertarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Total de vehículos:");

        ttotal.setEditable(false);
        ttotal.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        ttotal.setForeground(new java.awt.Color(255, 0, 0));
        ttotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ttotal.setBorder(null);
        ttotal.setDisabledTextColor(new java.awt.Color(240, 240, 240));
        ttotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ttotalActionPerformed(evt);
            }
        });

        bborrar1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bborrar1.setText("Limpiar ");
        bborrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bborrar1ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Reg. desde fichero");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addContainerGap())
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(76, 76, 76)
                                                                                .addComponent(tcolor, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(10, 10, 10)
                                                                                                .addComponent(jLabel6))
                                                                                        .addComponent(jLabel7))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(tprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(tanio, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(24, 24, 24)
                                                                                                .addComponent(jLabel3))
                                                                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(tmatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(tmarca, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(14, 14, 14)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jLabel4)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(10, 10, 10)
                                                                                                .addComponent(jLabel5)))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(tmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(ttotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(bborrar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(bborrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(binsertar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(bsiguiente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addContainerGap())))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(tmatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(tmarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(tmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(bsiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel8))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(binsertar)
                                                        .addComponent(ttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(15, 15, 15)
                                .addComponent(bborrar)
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(tcolor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel5))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(tanio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel7))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(tprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel6))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(bborrar1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())))
        );

        pack();
    }// </editor-fold>

    private void tmatriculaActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void tmarcaActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void tmodeloActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void tcolorActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void tanioActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void tprecioActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * Eete metodo muestra todos los registros que hay en la BD
     * @param evt
     */
    private void bsiguienteActionPerformed(java.awt.event.ActionEvent evt) {
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
                        respuesta = JOptionPane.showConfirmDialog(null, "¿Quieres mostrar el próximo registro?");
                        if (respuesta == 0) {
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

                        } else if (respuesta == 1) {
                            JOptionPane.showMessageDialog(null, "Has decidido no mostrar más registros");
                            salir = false;

                        } else if (respuesta == 2) {
                            tmatricula.setText("");
                            tmarca.setText("");
                            tmodelo.setText("");
                            tcolor.setText("");
                            tanio.setText("");
                            tprecio.setText("");
                            salir = false;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay más registros para mostrar");
                        bsiguiente.setEnabled(false);
                        salir = false;
                    }
                } while (salir);

            } catch (SQLException e) {
                // Mostrar el error SQL producido
                System.out.println(e);

            } finally {
                try {
                    // Cerrar el objeto Statement => al cerrar puede lanzar una excepcion tipo SQLException
                    st.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,ex);
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
    }
    /**
     * Este mmetodo tiene lugar al pulsar el botón "Insertar" e inserta registro en la BD
     * @param evt
     */
    private void binsertarActionPerformed(java.awt.event.ActionEvent evt) {
        int ano;
        int prec;
        String matricula;
        tmatricula.setEditable(true);
        PreparedStatement ps = null;

        try {

            actualizarcampo(ttotal);
            ps = conectarMySQL().prepareStatement("INSERT INTO coches VALUES (?,?,?,?,?,?)");

            if (tmatricula.getText().equals("")) {
                matricula = JOptionPane.showInputDialog("Introduce, una matrícula para añadir");

                if (tmatricula.getText()==null){
                    JOptionPane.showMessageDialog(null, "Error, no has introducido una matricula");

                }else{

                    if (compruebaregistro(matricula) == -1) {
                        //textoeditable();
                        JOptionPane.showMessageDialog(null, "No hay registros repetidos");
                        tmatricula.setText(matricula.toUpperCase());
                        JOptionPane.showMessageDialog(null, "Rellena los demás campos y pulsa de nuevo insertar");
                        tmatricula.setEditable(false);

                    } else if (compruebaregistro(matricula) == 1) {
                        JOptionPane.showMessageDialog(null, "ERROR!! Ya existe una matrícula igual en la Base de Datos");
                        tmatricula.setText("");
                    }

                }


            } else {
                ano = Integer.parseInt(tanio.getText());
                prec = Integer.parseInt(tprecio.getText());
                ps = conectarMySQL().prepareStatement("INSERT INTO coches VALUES (?,?,?,?,?,?)");
                ps.setString(1, tmatricula.getText());

                if (tmarca.getText() == null) {
                    JOptionPane.showMessageDialog(null, "ERROR!! Valor de la Marca nulo");
                }
                if (tmodelo.getText() == null) {
                    JOptionPane.showMessageDialog(null, "ERROR!! Valor del Modelo nulo");
                }
                if (tcolor.getText() == null) {
                    JOptionPane.showMessageDialog(null, "ERROR!! Valor del Color nulo");
                } else {
                    ps.setString(1, tmatricula.getText());
                    ps.setString(2, tmarca.getText());
                    ps.setString(3, tmodelo.getText());
                    ps.setString(4, tcolor.getText());
                    ps.setInt(5, ano);
                    ps.setInt(6, prec);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Registro de * " + tmatricula.getText() + " insertado");
                    actualizarcampo(ttotal);
                }
            }

        } catch (SQLException ex) {
            // Mostrar el error SQL producido
            JOptionPane.showMessageDialog(null, ex, "Error de SQL", JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException ex) {
        // Mostrar el error SQL producido
        JOptionPane.showMessageDialog(null, ex, "Error de parámetro nulo", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error en la entrada de datos numericos", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Cerrar el objeto Statement => al cerrar puede lanzar una excepcion tipo SQLException
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,ex);
                }
            }
        }

    }

    /**
     * Este metodo borra un registro de la base de datos
     * @param evt
     */
    private void bborrarActionPerformed(java.awt.event.ActionEvent evt) {

        String matricula;
        tmatricula.setEditable(true);
        PreparedStatement ps = null;
        int respuesta;


        try {
            actualizarcampo(ttotal);
            ps = conectarMySQL().prepareStatement("DELETE FROM concesionario.coches WHERE Matricula = ?");

            matricula = (String) JOptionPane.showInputDialog(null,"Introduce tu usuario","Introduce tu usuario", JOptionPane.PLAIN_MESSAGE);


            if (compruebaregistro(matricula) == 1) {
                //textoeditable();
                respuesta = JOptionPane.showConfirmDialog(null, "Hemos encontrado un registro coincidente... ¿Quieres eliminarlo?");

                if (respuesta == 0) {

                    ps.setString(1, matricula.toUpperCase());
                    ps.executeUpdate();
                    actualizarcampo(ttotal);
                } else {
                    JOptionPane.showMessageDialog(null, "Registros conservado...");
                    actualizarcampo(ttotal);
                }

            } else {
                JOptionPane.showMessageDialog(null, "ERROR!! No hay registros coincidentes");
            }

        } catch (SQLException ex) {
            // Mostrar el error SQL producido
            System.err.println(ex);
        } catch (InputMismatchException ex) {
            JOptionPane.showMessageDialog(null, "Error en la entrada de datos");


        } finally {
            // Cerrar el objeto Statement => al cerrar puede lanzar una excepcion tipo SQLException
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,ex);
                }
            }
        }
    }

    private void ttotalActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * Este metodo borra los campos
     * @param evt
     */
    private void bborrar1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        tcolor.setText("");
        tmarca.setText("");
        tmatricula.setText("");
        tmodelo.setText("");
        tprecio.setText("");
        tanio.setText("");
    }

    /**
     *
     * @param evt
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        escogerarchivo();
        actualizarcampo(ttotal);


    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Concesionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Concesionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Concesionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Concesionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Concesionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton bborrar;
    private javax.swing.JButton bborrar1;
    private javax.swing.JButton binsertar;
    private javax.swing.JButton bsiguiente;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField tanio;
    private javax.swing.JTextField tcolor;
    private javax.swing.JTextField tmarca;
    private javax.swing.JTextField tmatricula;
    private javax.swing.JTextField tmodelo;
    private javax.swing.JTextField tprecio;
    private javax.swing.JTextField ttotal;
    // End of variables declaration
}
