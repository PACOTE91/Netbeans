package Tema8.EjemploJugador;

/**
 * Class Jugador
 */
public class Jugador {

  //
  // Fields
  //

  private String Nombre;
  private int DNI;
  private int Puntuacion;
  
  //
  // Constructors
  //
  public Jugador () { };
  
  
  public Jugador (String nom, int dni2, int punt) {
	  Nombre = nom;
	  DNI = dni2;
	  Puntuacion = punt;	  
  }
  
  
  //
  // Methods
  //

  

  //
  // Accessor methods
  //

  /**
   * Set the value of Nombre
   * @param newVar the new value of Nombre
   */
  public void setNombre ( String newVar ) {
    Nombre = newVar;
  }

  /**
   * Get the value of Nombre
   * @return the value of Nombre
   */
  public String getNombre ( ) {
    return Nombre;
  }

  /**
   * Set the value of DNI
   * @param newVar the new value of DNI
   */
  public void setDNI ( int newVar ) {
    DNI = newVar;
  }

  /**
   * Get the value of DNI
   * @return the value of DNI
   */
  public int getDNI ( ) {
    return DNI;
  }

  /**
   * Set the value of Puntuacion
   * @param newVar the new value of Puntuacion
   */
  public void setPuntuacion ( int newVar ) {
    Puntuacion = newVar;
  }

  /**
   * Get the value of Puntuacion
   * @return the value of Puntuacion
   */
  public int getPuntuacion ( ) {
    return Puntuacion;
  }

  //
  // Other methods
  //

  /**
   * @return       double
   */
  public double valorar(  )
  {
	  return getPuntuacion();
  }


  /**
   * @return       String
   */
  public String toString(  )  
  {
	  return "\n Nombre = " + Nombre + ", DNI = " + DNI + ", puntuación = " + Puntuacion;
  }


}
