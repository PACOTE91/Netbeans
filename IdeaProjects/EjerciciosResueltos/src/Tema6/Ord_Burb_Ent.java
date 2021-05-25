package Tema6;

public class Ord_Burb_Ent {
    public static void burbuja_asc(int[] v) {
        int i;
        int j;
        int aux;
        int n_elem = v.length;
        boolean ordenado = false;

        for (i = 1; i < n_elem && !ordenado; i++) {
            ordenado = true;
            for (j = 0; j < n_elem - i; j++)
                if (v[j] > v[j + 1]) {
                    aux = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = aux;
                    ordenado = false;
                }
        }
    }
}
