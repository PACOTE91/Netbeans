package Tema8.EjemploJugador;

/**
 * Class Ciclista
 */
public class Ciclista extends Jugador {

  //
  // Fields
  //

  private int [] posicion_carreras;
  
  //
  // Constructors
  //
  public Ciclista () { };
  
  public Ciclista (String nom, int dni2, int punt, int[] pos) {
	  super (nom, dni2, punt);
	  posicion_carreras = pos;	  
  }
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of posicion_carreras_
   * @param newVar the new value of posicion_carreras_
   */
  public void setPosicion_carreras ( int [] newVar ) {
    posicion_carreras = newVar;
  }

  /**
   * Get the value of posicion_carreras_
   * @return the value of posicion_carreras_
   */
  public int [] getPosicion_carreras( ) {
    return posicion_carreras;
  }

  //
  // Other methods
  //

  /**
   * @return       double
   */
  public double valorar(  )
  {
	  double suma = 0;
	  
	  for (int ele : posicion_carreras) 
		suma += ele;  
	  
	  return suma / posicion_carreras.length;	  
  }


  /**
   * @return       String
   */
  public String toString(  )
  {
	  String cad = super.toString() + "\nPosición en las carreras: ";
	  
	  for (int ele : posicion_carreras) 
	    cad = cad + ele + " ,";
	    
	  return cad;
  }


}
