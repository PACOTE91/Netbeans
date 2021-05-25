package Tema6;

public class Busq_Seq_Caden {
    public static int buscar_secuencial (String[] cadenas, String cad)
    {
        int i, pos = -1;
        boolean encontrado = false;

        for (i=0; i < cadenas.length && !encontrado; i++)
            if (cadenas[i].equals(cad)) {
                encontrado = true;
                pos = i;
            }

        return pos;
    } /* fin buscar_secuencial */
}
