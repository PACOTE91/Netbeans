package Tema6;

public class Busq_Bin_Cad {
    public static int b_binaria_asc (String[] v, String cad_buscada)
    {
        int izquierda=0, derecha=v.length-1, posicion, mitad;
        mitad = (izquierda + derecha) / 2;

        while (!v[mitad].equals(cad_buscada) && izquierda <= derecha) {
            if (cad_buscada.compareTo (v[mitad]) > 0)
                izquierda = mitad +1;
            else
                derecha = mitad -1;

            mitad = (izquierda + derecha) / 2;
        }

        if ( v[mitad].equals(cad_buscada) )
            posicion = mitad;
        else
            posicion = -1;

        return posicion;
    }
}
