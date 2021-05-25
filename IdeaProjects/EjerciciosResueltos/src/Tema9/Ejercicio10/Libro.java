
package Tema9.Ejercicio10;

import java.io.*;

/**
* Clase que contiene los datos de un libro
*/
public class Libro {
    // constantes    
    // Tamaño máximo en bytes que puede ocupar el atributo titulo 
    public static final int maxCaracteresTitulo=100;
     // Tamaño máximo en bytes que pueden ocupar todos los atributos
    public static final int tamañoEnBytes =
        maxCaracteresTitulo+1  // título + \n
        +Integer.SIZE/8  // publicado
        +Double.SIZE/8  // precio
        +1;  // tamaño par
    
    // atributos    
    private int publicado; // año de publicación
    private double precio; // en euros
    private String titulo; // título del libro
    
    /**  Constructor al que se le pasan los datos del libro  */
    public Libro(String titulo, int publicado, double precio) {
        // asegurarse de que el titulo no supera maxCaracteresTítulo
        if (titulo.length()>maxCaracteresTitulo) 
            this.titulo =  titulo.substring(0,maxCaracteresTitulo);
        else 
            this.titulo=titulo;       
        
        this.publicado=publicado;
        this.precio=precio;
    }
    
    /** E: fich => fichero a leer
     * S: devuelve el objeto leido del archivo fich
     * recoge la excepción IOException de los métodos readInt, readDouble y readLine 
     * para controlar posibles errores de E/S en la lectura del fichero */     
    public static Libro leeDeFichero (RandomAccessFile fich) throws IOException, EOFException {
        // lee los tres datos, por orden
        int publi=fich.readInt();
        double prec=fich.readDouble();
        // Le quita los espacios en blanco al principio y al final
        String tit=fich.readLine().trim();
        // crea y retorna el libro
        return new Libro(tit,publi,prec);
    }
    
    /** Escribe en el fichero el objeto Fichero actual  
     * recoge la excepción IOException de los métodos writeInt, writeDouble y writeLine 
     * @param fich
     * @throws IOException 
     */
    public void escribeEnFichero (RandomAccessFile fich) throws IOException{
        // escribe los tres datos, por orden
        fich.writeInt(publicado);
        fich.writeDouble(precio);
        fich.writeBytes(titulo+'\n'); 
    }

    // métodos get 
    public String get_titulo () {
        return titulo;
    }

    public int get_publicado () {
        return publicado;
    }

    public double get_precio () {
        return precio;
    }

    // métodos set...
    public void setPublicado(int publicado) {
        this.publicado = publicado;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    

    /*---------*/
    /* EJER 10 */
    /*---------*/
    
    // redefine el método toString de la superclase Object
    @Override
    public String toString() {
        String aux = "";
        
        // comprobar si el libro está borrado
        if (titulo.equals ("") && precio == 0 && publicado == 0)         
            aux = "Libro Borrado....";
        else
            aux ="Título: \"" + titulo + "\". Año de publicación: " + publicado + ". Precio: " + precio;
        
        return aux;
    }

} // fin clase Libro


