package Tema6;

public class Ord_Quicksort_Asc {
    public static void quicksort_asc (int[] v, int izq, int der) {

        int pivote=v[izq];
        int i=izq;
        int j=der;
        int aux;

        while(i<j){
            while(v[i]<=pivote && i<j)
                i++;
            while(v[j]>pivote)
                j--;
            if (i<j) {
                aux= v[i];
                v[i]=v[j];
                v[j]=aux;
            }
        }
        v[izq]=v[j];
        v[j]=pivote;
        if(izq<j-1)
            quicksort_asc(v,izq,j-1);
        if(j+1 <der)
            quicksort_asc(v,j+1,der);
    }
}
