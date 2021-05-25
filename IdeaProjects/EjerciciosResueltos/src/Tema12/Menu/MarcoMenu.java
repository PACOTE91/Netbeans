package Tema12.Menu;// Fig. 22.5: MarcoMenu.java
// Demostración de los menús.
import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;

public class MarcoMenu extends JFrame 
{
   private final Color valoresColores[] = { Color.BLACK, Color.BLUE, Color.RED, Color.GREEN };   
   private JRadioButtonMenuItem elementosColores[]; // elementos del menú colores
   private JRadioButtonMenuItem fuentes[]; // vector con los elementos del submenú fuentes
   private JCheckBoxMenuItem elementosEstilos[]; // vector con los elementos del submenu estilos
   private JLabel mostrarJLabel; // muestra texto de ejemplo
   private ButtonGroup fuentesButtonGroup; // administra elementos del menú fuentes
   private ButtonGroup coloresButtonGroup; // administra elementos del menú colores
   private int estilo; // se utiliza para crear el estilo para la fuente
   
   private int vector[]; // vector que usa el menú Vector

   // el constructor con un argumento establece la GUI
   public MarcoMenu(int v[])
   {
      // Llamada al constructor de la superclase
      // crea una ventana de título "Uso de objetos JMenu"
      super( "Uso de objetos JMenu" );
      
      // copia del parámetro del vector
      vector = v;

      // ======= MENU ARCHIVO ========
      JMenu menuArchivo = new JMenu( "Archivo" ); // crea el menú archivo
      menuArchivo.setMnemonic( 'A' ); // establece el nemónico a A => Al pulsar Alt + A

      // SUBMENU "Acerca de..." dentro del menú Archivo
      JMenuItem elementoAcercaDe = new JMenuItem( "Acerca de..." );
      elementoAcercaDe.setMnemonic( 'c' ); // establece el nemónico a c
      menuArchivo.add( elementoAcercaDe ); // agrega el elemento elementoAcercaDe al menú archivo
      
      // Clase anónima para el manejador de eventos de "Acerca de..."
      elementoAcercaDe.addActionListener(

         new ActionListener() // clase interna anónima
         {  
            // muestra cuadro de diálogo de mensaje cuando el usuario selecciona Acerca de...
            public void actionPerformed( ActionEvent evento )
            {
               JOptionPane.showMessageDialog( MarcoMenu.this,
                  "Este es un ejemplo\ndel uso de menus",
                  "Acerca de", JOptionPane.PLAIN_MESSAGE );
            } // fin del método actionPerformed
         } // fin de la clase interna anónima
      ); // fin de la llamada a addActionListener
 
      // ========= SUBMENU "Salir" dentro del menú Archivo ==========
      JMenuItem elementoSalir = new JMenuItem( "Salir" ); // crea el elemento salir
      elementoSalir.setMnemonic( 'S' ); // establece el nemónico a s
      menuArchivo.add( elementoSalir ); // agrega elemento salir al menú archivo
      elementoSalir.addActionListener(

         new ActionListener() // clase interna anónima
         {  
            // termina la aplicación cuando el usuario hace clic en elementoSalir
            public void actionPerformed( ActionEvent evento )
            {
               System.exit( 0 ); // sale de la aplicación
            } // fin del método actionPerformed
         } // fin de la clase interna anónima
      ); // fin de la llamada a addActionListener

      // ===== BARRA DE MENUS ======
      JMenuBar barra = new JMenuBar(); // crea la barra de menús
      setJMenuBar( barra ); // agrega la barra de menús a la aplicación
      barra.add( menuArchivo ); // agrega el menú archivo a la barra de menús

      // ===== MENU FORMATO =======
      JMenu menuFormato = new JMenu( "Formato" ); // crea el menú formato
      menuFormato.setMnemonic( 'F' ); // establece el nemónico a F

      // vector con los colores
      String colores[] = { "Negro", "Azul", "Rojo", "Verde" };

      // ===== SUBMENU "Color" dentro del menu Formato =====
      JMenu menuColor = new JMenu( "Color" ); // crea el menú color
      menuColor.setMnemonic( 'C' ); // establece el nemónico a C

      // AÑADIR las opciones del submenu "Color"
      // crea los elementos de menú de los botones de opción para los colores
      elementosColores = new JRadioButtonMenuItem[ colores.length ];
      // Un ButtonGroup agrupa a varios RadioButton
      coloresButtonGroup = new ButtonGroup(); // administra los colores
      ManejadorElementos manejadorElementos = new ManejadorElementos(); // manejador para colores

      // crea los elementos de menu del botón de opción color
      for ( int i = 0; i < colores.length; i++ ) 
      {
         elementosColores[i] = new JRadioButtonMenuItem( colores[i] ); // crea elemento
         menuColor.add( elementosColores [i] ); // agrega elemento al submenú color
         coloresButtonGroup.add( elementosColores[i] ); // lo agrega al grupo
         // Al JRadioButtonMenuItem número i le añade el manejador
         elementosColores[i].addActionListener( manejadorElementos );
      } // fin de for

      elementosColores[ 0 ].setSelected( true ); // selecciona el primer elemento de Color

      menuFormato.add( menuColor ); // agrega el menú color al menú formato
      menuFormato.addSeparator(); // agrega un separador en el menú formato

      // Vector con los nombres de las fuentes
      String nombresFuentes[] = { "Serif", "Monospaced", "SansSerif", "Arial" };
      
      // ====== SUBMENU Fuente dentro del menú Formato ======
      JMenu menuFuente = new JMenu( "Fuente" ); // crea el menú fuente
      menuFuente.setMnemonic( 'u' ); // establece el nemónico a u

      // crea elementos de menú de botones de opción para los nombres de las fuentes
      fuentes = new JRadioButtonMenuItem[ nombresFuentes.length ];
      // Un ButtonGroup agrupa a varios RadioButton
      fuentesButtonGroup = new ButtonGroup(); // administra los nombres de las fuentes

      // crea elementos de menú de botones de opción de Fuente
      for ( int i = 0; i < fuentes.length; i++ ) 
      {
         fuentes[i] = new JRadioButtonMenuItem( nombresFuentes [i] );
         menuFuente.add( fuentes[i] ); // agrega fuente al menú fuente
         fuentesButtonGroup.add( fuentes[i] ); // agrega al grupo de botones
         fuentes[i].addActionListener( manejadorElementos ); // agrega el manejador
      } // fin de for

      fuentes[ 0 ].setSelected( true ); // selecciona el primer elemento del menú Fuente
      menuFuente.addSeparator(); // agrega barra separadura al menú fuente

      String nombresEstilos[] = { "Negrita", "Cursiva" }; // nombres de los estilos
      elementosEstilos = new JCheckBoxMenuItem[ nombresEstilos.length ];
      ManejadorEstilos manejadorEstilos = new ManejadorEstilos(); // manejador de estilos

      // crea elementos de menú de la casilla de verificación de estilo
      for ( int i = 0; i < nombresEstilos.length; i++ ) 
      {
         elementosEstilos[i] = new JCheckBoxMenuItem( nombresEstilos[i] ); // para el estilo
         menuFuente.add( elementosEstilos[i] ); // agrega al menú fuente
         elementosEstilos[i].addItemListener( manejadorEstilos ); // manejador
      } // fin de for

      menuFormato.add( menuFuente ); // agrega el menú Fuente al menú Formato
      barra.add( menuFormato ); // agrega el menú Formato a la barra de menús
      
      // ====== MENU VECTOR ====== 
      JMenu menuVector = new JMenu( "Vector" ); // crea el menú Vector
      menuVector.setMnemonic( 'V' ); // establece el nemónico a V => Al pulsar Alt + V

      // ====== SUBMENU "Contenido del vector" dentro del menú Vector ======
      JMenuItem elementoContenido = new JMenuItem( "Contenido del vector" );
      elementoContenido.setMnemonic( 't' ); // establece el nemónico a t
      menuVector.add( elementoContenido ); // agrega elementoContenido al menú Vector      
      
      // Manejador de eventos del submenu Contenido del vector
      ManejadorContenido manejadorContenido = new ManejadorContenido(vector);
      elementoContenido.addActionListener (manejadorContenido);
      
      // ====== SUBMENU "Vector Ordenado" dentro del menú Vector ======
      JMenuItem elementoOrdenado = new JMenuItem( "Vector Ordenado" );
      elementoOrdenado.setMnemonic( 'O' ); // establece el nemónico a O
      menuVector.add( elementoOrdenado ); // agrega elementoOrdenado al menú Vector
      
      // Manejador de eventos del submenu Ordenado del vector
      ManejadorOrdenado manejadorOrdenado = new ManejadorOrdenado(vector);
      elementoOrdenado.addActionListener (manejadorOrdenado);
      
      // agrega el menú Vector a la barra de menús      
      barra.add ( menuVector ); 
      
 
      // FIN Menu Vector ********************
     
      // establece la etiqueta para mostrar el texto
      mostrarJLabel = new JLabel( "Texto de ejemplo", SwingConstants.CENTER );
      mostrarJLabel.setForeground( valoresColores[ 0 ] );
      mostrarJLabel.setFont( new Font( "Serif", Font.PLAIN, 72 ) );

      getContentPane().setBackground( Color.CYAN ); // establece el color de fondo
      add( mostrarJLabel, BorderLayout.CENTER ); // agrega mostrarJLabel
   } // fin del constructor de MarcoMenu

   // clase interna para manejar los eventos de acción de los elementos de menú
   private class ManejadorElementos implements ActionListener 
   {
      // procesa las selecciones de color y fuente
      public void actionPerformed( ActionEvent evento )
      {
         // procesa la selección del color
         boolean salir=false;
         for ( int i = 0; i < elementosColores.length && !salir; i++ )
         {
            if ( elementosColores [i].isSelected() ) 
            {
               mostrarJLabel.setForeground( valoresColores [i] );
               salir = true;
            } // fin de if
         } // fin de for

         // procesa la selección de fuente
         salir = false;
         for ( int i = 0; i < fuentes.length && !salir; i++ )
         {
            if ( evento.getSource() == fuentes [i] ) 
            {
               mostrarJLabel.setFont(new Font( fuentes [i].getText(), estilo, 72 ) );
               salir = true;
            } // fin de if
         } // fin de for

         repaint(); // vuelve a dibujar la aplicación
      } // fin del método actionPerformed
   } // fin de la clase ManejadorElementos

   // clase interna para manejar los eventos de los elementos de menú de las casillas de verificación
   private class ManejadorEstilos implements ItemListener 
   {
      // procesa las selecciones de estilo de las fuentes
      public void itemStateChanged( ItemEvent e )
      {
         estilo = 0; // inicializa el estilo

         // comprueba la selección de negrita
         if ( elementosEstilos[ 0 ].isSelected() )
            estilo += Font.BOLD; // agrega negrita al estilo

         // comprueba la selección de cursiva
         if ( elementosEstilos[ 1 ].isSelected() )
            estilo += Font.ITALIC; // agrega cursiva al estilo

         mostrarJLabel.setFont( new Font( mostrarJLabel.getFont().getName(), estilo, 72 ) );
         repaint(); // vuelve a dibujar la aplicación
      } // fin del método itemStateChanged
   } // fin de la clase ManejadorEstilos
   
   // Clase interna para el manejador de eventos de "Contenido del vector"
   private class ManejadorContenido implements ActionListener {
	   private int v[]; // vector de enteros
	   
	   // Constructor con parámetro
	   public ManejadorContenido (int vector[]) {
	     v = vector;
	   }
	   
	   // muestra cuadro de diálogo de mensaje cuando el usuario selecciona Contenido del Vector
	   public void actionPerformed( ActionEvent evento ) {            
       String cadena = "";
       
       for (int i=0; i<v.length; i++)
         cadena = cadena + v[i] + ", ";
            	 		
       JOptionPane.showMessageDialog( MarcoMenu.this, "Contenido del vector:\n"+cadena,
                                      "Acerca de", JOptionPane.PLAIN_MESSAGE );
     } // fin del método actionPerformed
            
   } // fin de la clase interna ManejadorContenido
   
   // Clase interna para el manejador de eventos de "Vector Ordenado"
   private class ManejadorOrdenado implements ActionListener {
	   private int v[]; // vector de enteros
	   
	   // Constructor con parámetro
	   public ManejadorOrdenado (int vector[]) {
	     v = vector;
	   }
	   
	   // muestra cuadro de diálogo de mensaje cuando el usuario selecciona "Vector Ordenado"
	   public void actionPerformed( ActionEvent evento ) {            
       String cadena = "";
       
       // Se muestra el vector ordenado pero no se ordena => se hace una copia antes
       int aux[] = new int [v.length];
       for (int i=0; i<v.length; i++)
         aux[i] = v[i];
       
       // ordenar el vector auxiliar
       ordenacion.burbuja (aux);       
       
       for (int i=0; i<aux.length; i++)
         cadena = cadena + aux[i] + ", ";
            	 		
       // mostrar en un cuadro de dialogo el vector ordenado auxiliar
       JOptionPane.showMessageDialog( MarcoMenu.this, "Contenido del vector ordenado:\n"+cadena,
                                      "Acerca de", JOptionPane.PLAIN_MESSAGE );
     } // fin del método actionPerformed
            
   } // fin de la clase interna ManejadorOrdenado


} // fin de la clase MarcoMenu



