package Tema8.EjemploJugador;

/**
 * Class Jugador_Basket
 */
public class Jugador_Basket extends Jugador {

  //
  // Fields
  //

  private int puntos_anotados = 0;
  private int tapones = 0;
  private int rebotes = 0;
  private int asistencias = 0;
  
  //
  // Constructors
  //
  public Jugador_Basket () { };
  
  
  public Jugador_Basket (String nomb, int dni2, int punt, int ptos_ano, int tapon, int rebo, int asis) {
	  super (nomb, dni2, punt);
	  puntos_anotados = ptos_ano;
	  tapones = tapon;
	  rebotes = rebo;
	  asistencias = asis;	  
  }
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of puntos_anotados
   * @param newVar the new value of puntos_anotados
   */
  public void setPuntos_anotados ( int newVar ) {
    puntos_anotados = newVar;
  }

  /**
   * Get the value of puntos_anotados
   * @return the value of puntos_anotados
   */
  public int getPuntos_anotados ( ) {
    return puntos_anotados;
  }

  /**
   * Set the value of tapones
   * @param newVar the new value of tapones
   */
  public void setTapones ( int newVar ) {
    tapones = newVar;
  }

  /**
   * Get the value of tapones
   * @return the value of tapones
   */
  public int getTapones ( ) {
    return tapones;
  }

  /**
   * Set the value of rebotes
   * @param newVar the new value of rebotes
   */
  public void setRebotes ( int newVar ) {
    rebotes = newVar;
  }

  /**
   * Get the value of rebotes
   * @return the value of rebotes
   */
  public int getRebotes ( ) {
    return rebotes;
  }

  /**
   * Set the value of asistencias
   * @param newVar the new value of asistencias
   */
  public void setAsistencias ( int newVar ) {
    asistencias = newVar;
  }

  /**
   * Get the value of asistencias
   * @return the value of asistencias
   */
  public int getAsistencias ( ) {
    return asistencias;
  }

  //
  // Other methods
  //

  /**
   * @return       double
   */
  public double valorar(  )
  {
	  return (super.valorar() + puntos_anotados + rebotes + asistencias + tapones) / 2;
  }


  /**
   * @return       String
   */
  public String toString(  )
  {
	  return super.toString() + "\n ptos anotados " + puntos_anotados + ", rebotes " + rebotes + 
	                            ", asistencias " + asistencias + ", tapones " + tapones;
  }


}
