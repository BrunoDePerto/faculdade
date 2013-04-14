package Ordenacao;

public class InsertSort {

    public static char[] sort(char[] a) {

        for (int i = 0; i < a.length; i++) {
            char pivo = a[i];
            for (int j = i - 1; j >= 0 && a[j] > pivo; j--) {
                a[j + 1] = a[j];
                a[j] = pivo;
            }
        }
        return a;
    }
}
