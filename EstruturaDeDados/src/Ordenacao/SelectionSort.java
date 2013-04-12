package Ordenacao;

public class SelectionSort {

    public static char[] sort(char[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int menor = i;
            for (int j = i; j < a.length; j++) {
                if (a[j] < a[menor]) {//se for maior realiza a troca...
                    menor = j;
                }
            }
            char temp = a[menor];
            a[menor] = a[i];
            a[i] = temp;
        }
        return a;
    }
}
