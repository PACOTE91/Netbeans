package Tema11;

import javax.swing.*;
import java.sql.*;
import java.util.InputMismatchException;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

public class prueba extends javax.swing.JFrame {


    /**
     *
     * @author PACOFENOY
     */


        static Connection con;
        static String horaLocal = TimeZone.getDefault().getID();


        /**
         * Creates new form Concesionario
         */
        public prueba() {
            initComponents();

        }

        String marca,modelo,color,anio,precio;

        public prueba(String marca,String modelo,String color,String anio,String precio ) {

            this.marca=marca;
            this.modelo=modelo;
            this.color=color;
            this.anio=anio;
            this.precio=precio;

        }
        /**
         *
         * @param matricula
         * @return
         */
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

        public static Concesionario devuelveregistro(String matricula) {
            int coincidencia = -1; //-1 No hay coincidencia de clave primaria
            //1 Hay coincidencia de clave primaria
            String compruebamatricula;
            Concesionario array []=new Concesionario[1];
            String mar,mod,col,an,prec;

            Concesionario coche [] = new Concesionario [0];

            try {
                // Llamada al constructor de la clase Statement con un objeto de la clase Connection
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM concesionario.coches");

                while (rs.next()) {
                    compruebamatricula = rs.getString(1);
                    if (compruebamatricula.equalsIgnoreCase(matricula)) {

                        mar = rs.getString(2);
                        mod = rs.getString(3);
                        col = rs.getString(4);
                        an = rs.getString(5);
                        prec = rs.getString(6);
                        //coche[0]=(mar,mod,col,an,prec);


                    }
                }
            } catch (SQLException se) {
                se.getMessage();
            }
            return null;

        }


        public void textonoeditable(){
            tmatricula.setEditable(false);
            tmarca.setEditable(false);
            tmodelo.setEditable(false);
            tcolor.setEditable(false);
            tanio.setEditable(false);
            tprecio.setEditable(false);
        }

        public void textoeditable(){
            tmatricula.setEditable(false);
            tmarca.setEditable(true);
            tmodelo.setEditable(true);
            tcolor.setEditable(true);
            tanio.setEditable(true);
            tprecio.setEditable(true);
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

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            jLabel1.setBackground(new java.awt.Color(0, 0, 0));
            jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
            jLabel1.setForeground(new java.awt.Color(255, 0, 0));
            jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel1.setText("Concesionario");
            jLabel1.setOpaque(true);

            jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            jLabel2.setText("Matr??cula:");

            jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            jLabel3.setText("Marca:");

            jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            jLabel4.setText("Modelo:");

            jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            jLabel5.setText("Color:");

            jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            jLabel6.setText("A??o:");

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
            bsiguiente.setText("Siguiente");
            bsiguiente.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    bsiguienteActionPerformed(evt);
                }
            });

            bborrar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
            bborrar.setText("Borrar");
            bborrar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    bborrarActionPerformed(evt);
                }
            });

            binsertar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
            binsertar.setText("Insertar");
            binsertar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    binsertarActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                    .addGap(26, 26, 26)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel2)
                                                            .addComponent(jLabel3)
                                                            .addComponent(jLabel4)
                                                            .addComponent(jLabel5)
                                                            .addComponent(jLabel6)
                                                            .addComponent(jLabel7))
                                                    .addGap(18, 18, 18)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(tmatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(tmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(tmarca, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(tprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(tanio, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(tcolor, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(bsiguiente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(bborrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(binsertar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addContainerGap())
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel1)
                                    .addGap(26, 26, 26)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(jLabel2)
                                                            .addComponent(tmatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(jLabel3)
                                                            .addComponent(tmarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(bsiguiente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(jLabel4)
                                                            .addComponent(tmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(jLabel5)
                                                            .addComponent(tcolor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(jLabel6)
                                                            .addComponent(tanio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(jLabel7)
                                                            .addComponent(tprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGap(29, 29, 29))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addComponent(binsertar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(bborrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGap(30, 30, 30))))
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

        private void bsiguienteActionPerformed(java.awt.event.ActionEvent evt) {
            try {
                String car;
                String matricula, marca, modelo, color, anio, precio;
                String horaLocal = TimeZone.getDefault().getID();
                Connection con;
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario?serverTimezone=" +
                        horaLocal, "root", "1234");
                Statement st = con.createStatement();

                try {
                    JOptionPane.showMessageDialog(null, "Conexion a base de datos satisfactoria");
                    String consulta = "Select * From concesionario.coches";
                    // Llamada al constructor de la clase Statement con un objeto de la clase Connection
                    ResultSet rs = st.executeQuery(consulta);
                    if(rs.next()){
                        matricula = rs.getString(1);
                        tmatricula.setText(matricula);
                        tmatricula.setEditable(false);
                        marca = rs.getString(2);
                        tmarca.setText(marca);
                        tmarca.setEditable(false);
                        modelo = rs.getString(3);
                        tmodelo.setText(modelo);
                        tmodelo.setEditable(false);
                        color = rs.getString(4);
                        tcolor.setText(color);
                        tcolor.setEditable(false);
                        anio = rs.getString(5);
                        tanio.setText(anio);
                        tanio.setEditable(false);
                        precio = rs.getString(6);
                        tprecio.setText(precio);
                        tprecio.setEditable(false);
                    }else{
                        bsiguiente.setEnabled(false);
                    }



                } catch (SQLException e) {
                    // Mostrar el error SQL producido
                    System.out.println(e);

                }finally {

                    try {
                        // Cerrar el objeto Statement => al cerrar puede lanzar una excepcion tipo SQLException
                        st.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Concesionario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            } catch (SQLException ex) {
                Logger.getLogger(Concesionario.class.getName()).log(Level.SEVERE, null,ex);

            }

        }

        private void binsertarActionPerformed(java.awt.event.ActionEvent evt) {

            String car;
            String matricula = null, marca, modelo, color;
            int anio, precio;
            String horaLocal = TimeZone.getDefault().getID();
            Connection con;
            tmatricula.setEditable(true);
            PreparedStatement ps=null;
            ResultSet rs=null;




            try {

                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario?serverTimezone=" +
                        horaLocal, "root", "1234");

                ps = con.prepareStatement("INSERT INTO coches VALUES (?,?,?,?,?,?)");

                matricula = JOptionPane.showInputDialog("Introduce, una matr??cula para a??adir");


                if (compruebaregistro(matricula) == -1) {
                    textoeditable();
                    JOptionPane.showMessageDialog(null, "No hay registros repetidos");
                    tmatricula.setText(matricula);
                    /*ps.setString(1, matricula);
                    ps.setString(2, marca);
                    ps.setString(3, modelo);
                    ps.setString(4, color);
                    ps.setInt(5, anio);
                    ps.setInt(6, precio);
                    ps.executeUpdate();
                    */
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR!! Ya existe una matr??cula igual en la Base de Datos");
                    textonoeditable();
                }

            } catch (SQLException ex) {
                // Mostrar el error SQL producido
                System.err.println(ex);
            } catch (InputMismatchException ex){
                JOptionPane.showMessageDialog(null,"Error en la entrada de datos");


            } finally {
                // Cerrar el objeto Statement => al cerrar puede lanzar una excepcion tipo SQLException
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Concesionario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        }

        private void bborrarActionPerformed(java.awt.event.ActionEvent evt) {

            String matricula = null, marca, modelo, color;
            int anio, precio;
            tmatricula.setEditable(true);
            PreparedStatement ps=null;
            ResultSet rs=null;


            try {

                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario?serverTimezone=" +
                        horaLocal, "root", "1234");

                ps = con.prepareStatement("DELETE FROM concesionario.coches WHERE Matricula = ?");

                matricula = JOptionPane.showInputDialog("Introduce, una matr??cula para ELIMINAR");


                if (compruebaregistro(matricula) == 1) {
                    textoeditable();
                    JOptionPane.showMessageDialog(null, "Hay un registro coincidente, para eliminar");
                    tmatricula.setText(matricula);
                    /*ps.setString(1, matricula);
                    ps.setString(2, marca);
                    ps.setString(3, modelo);
                    ps.setString(4, color);
                    ps.setInt(5, anio);
                    ps.setInt(6, precio);
                    ps.executeUpdate();
                    */
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR!! Ya existe una matr??cula igual en la Base de Datos");
                    textonoeditable();
                }

            } catch (SQLException ex) {
                // Mostrar el error SQL producido
                System.err.println(ex);
            } catch (InputMismatchException ex){
                JOptionPane.showMessageDialog(null,"Error en la entrada de datos");


            } finally {
                // Cerrar el objeto Statement => al cerrar puede lanzar una excepcion tipo SQLException
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Concesionario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }




        /**
         * @param args the command line arguments
         */
        public static void main(String args[]) {
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
             * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
             */

                }



        // Variables declaration - do not modify
        private javax.swing.JButton bborrar;
        private javax.swing.JButton binsertar;
        private javax.swing.JButton bsiguiente;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JLabel jLabel7;
        private javax.swing.JTextField tanio;
        private javax.swing.JTextField tcolor;
        private javax.swing.JTextField tmarca;
        private javax.swing.JTextField tmatricula;
        private javax.swing.JTextField tmodelo;
        private javax.swing.JTextField tprecio;
        // End of variables declaration
    }


