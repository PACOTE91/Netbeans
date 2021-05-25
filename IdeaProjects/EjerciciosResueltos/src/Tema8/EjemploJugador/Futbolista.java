package Tema8.EjemploJugador;

/**
 * Class Futbolista
 */
public class Futbolista extends Jugador {

  //
  // Fields
  //

  private int num_goles = 0;
  
  //
  // Constructors
  //
  public Futbolista () { };
  
  public Futbolista (String nom, int dni2, int punt, int goles) {
	  super (nom, dni2, punt);
	  num_goles = goles;	  
  }
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of num_goles
   * @param newVar the new value of num_goles
   */
  public void setNum_goles ( int newVar ) {
    num_goles = newVar;
  }

  /**
   * Get the value of num_goles
   * @return the value of num_goles
   */
  public int getNum_goles ( ) {
    return num_goles;
  }

  //
  // Other methods
  //

  /**
   * @return       double
   */
   
  /* (será la valoración inicial del jugador establecida en la clase Jugador   + número de goles) / 2 */
  public double valorar(  )
  {
	  return (super.valorar() + num_goles) / 2.0;
  }


  /**
   * @return       String
   */
  public String toString(  )
  {
	  return super.toString() + ", número de goles = " + num_goles;
  }


}
