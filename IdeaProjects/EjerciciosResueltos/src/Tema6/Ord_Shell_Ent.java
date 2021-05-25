package Tema6;

public class Ord_Shell_Ent {
    public static void shell_asc(int[] v) {
        int distancia;
        int aux;
        boolean ordenado;
        int num_ele = v.length;
        distancia = num_ele / 2;
        while (distancia >= 1) {
            ordenado = false;
            while (!ordenado) {
                ordenado = true;
                for (int i = 0; i < num_ele-distancia; i++)
                    if (v[i]>v[i+distancia]) {
                        aux = v[i];
                        v[i] = v[i+distancia];
                        v[i + distancia] = aux;
                        ordenado = false;
                    }
            }
            distancia = distancia / 2;
        }

    }
}
