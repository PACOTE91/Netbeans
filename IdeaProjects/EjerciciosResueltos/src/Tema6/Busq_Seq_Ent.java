package Tema6;

public class Busq_Seq_Ent {
    public static int buscar_secuencial (int[] v, int ele)
    {
        int i, pos = -1;
        boolean encontrado = false;

        /* !encontrado es igual que encontrado == false */
        for (i=0; i < v.length && !encontrado; i++)
            if (v[i] == ele) {
                // se ha encontrado el elemento ele en el vector
                encontrado = true;
                pos = i;
            }

        return pos;
    } /* fin buscar_secuencial */
}
