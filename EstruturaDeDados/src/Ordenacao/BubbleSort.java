package Ordenacao;

public class BubbleSort {

    public static char[] sort(char[] a) {
        for (int i = a.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {//se for maior realiza a troca...
                    char temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        return a;
    }
}
