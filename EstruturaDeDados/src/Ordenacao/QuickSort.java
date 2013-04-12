package Ordenacao;

public class QuickSort{

    public static char[] sort(char[] a) {
        return quick_sort(a, 0, a.length-1);
    }

    public static char[] quick_sort(char[] a, int ini, int fim) {
        int meio;
        if (ini < fim) {
            meio = partition(a, ini, fim);
            quick_sort(a, ini, meio);
            quick_sort(a, meio + 1, fim);
        }
        return a;
    }

    public static int partition(char[] a, int ini, int fim) {
        char pivo;
        int topo, i;
        pivo = a[ini];
        topo = ini;
        for (i = ini + 1; i <= fim; i++) {
            if (a[i] < pivo) {
                a[topo] = a[i];
                a[i] = a[topo + 1];
                topo++;
            }
        }
        a[topo] = pivo;
        return topo;
    }
}
