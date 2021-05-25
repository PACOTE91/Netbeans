package Tema6;

public class Busq_Bin_Float {
    public static int b_binaria_asc(float[] v, float valor_busc) {
        int izquierda = 0;
        int derecha = v.length - 1;
        int pos;
        int mitad;

        mitad = (izquierda + derecha) / 2;
        while (v[mitad] != valor_busc && izquierda <= derecha) {
            if (valor_busc > v[mitad])
                izquierda = mitad + 1;
            else
                derecha = mitad - 1;
            mitad = (izquierda + derecha) / 2;
        }

        if (v[mitad] == valor_busc)
            pos = mitad;
        else
            pos = -1;

        return pos;
    }
}
