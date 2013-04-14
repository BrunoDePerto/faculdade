package Ordenacao;

public class MergeSort {

    public static char[] sort(char[] a) {
        char[] aTemp = new char[a.length];
        mergeSort(a, aTemp, 0, a.length-1);
        return a;
    }

    public static void mergeSort(char[] a, char[] aTemp, int esq, int dir) {
        if (esq < dir) {
            int meio = (esq + dir) / 2;
            mergeSort(a, aTemp, esq, meio);
            mergeSort(a, aTemp, meio + 1, dir);
            mesclar(a, aTemp, esq, meio + 1, dir);
        }
    }

    public static void mesclar(char[] a, char[] aAux, int posEsq, int posDir, int posFin) {
        int finIzq = posDir - 1;
        int posAux = posEsq;
        int numElementos = posFin - posEsq + 1;
        // Busca principal  
        while (posEsq <= finIzq && posDir <= posFin) {
            if (a[posEsq] < a[posDir]) {
                aAux[posAux++] = a[posEsq++];
            } else {
                aAux[posAux++] = a[posDir++];
            }
        }
        // Copia primeira metade  
        while (posEsq <= finIzq) {
            aAux[posAux++] = a[posEsq++];
        }
        // Copia segunda metade  
        while (posDir <= posFin) {
            aAux[posAux++] = a[posDir++];
        }
        // Copia vetor temporário no principal  
        for (int i = 0; i < numElementos; i++, posFin--) {
            a[posFin] = aAux[posFin];
        }

    }
}
