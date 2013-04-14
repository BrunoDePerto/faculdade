package Ordenacao;

public class Teste {

    public static void main(String args[]) {
        int tamanho = 1000;
        for (int i = 0; i < 7; i++) {
            teste(tamanho);
            tamanho*=10;
        }
        
    }

    private static void teste(int tamanho) {
        //BubbleSort
        char[] a = geraArray(tamanho);
        long t1 = System.currentTimeMillis();//Tempo inicial
        BubbleSort.sort(a);
        System.out.println("Tempo de execução do BulleSort para "
                + tamanho + " itens: "
                + (System.currentTimeMillis() - t1) / 1000 + " segundos.");

        //InsertSort
        a = geraArray(tamanho);
        t1 = System.currentTimeMillis();//Zera o tempo
        InsertSort.sort(a);
        System.out.println("Tempo de execução do InsertSort para "
                + tamanho + " itens: "
                + (System.currentTimeMillis() - t1) / 1000 + " segundos.");

        //SelectionSort
        a = geraArray(tamanho);
        t1 = System.currentTimeMillis();//Zera o tempo
        SelectionSort.sort(a);
        System.out.println("Tempo de execução do SelectionSort para "
                + tamanho + " itens: "
                + (System.currentTimeMillis() - t1) / 1000 + " segundos.");

        //MergeSort
        a = geraArray(tamanho);
        t1 = System.currentTimeMillis();//Zera o tempo
        MergeSort.sort(a);
        System.out.println("Tempo de execução do MergeSort para "
                + tamanho + " itens: "
                + (System.currentTimeMillis() - t1) / 1000 + " segundos.");

        //QuickSort
        a = geraArray(tamanho);
        t1 = System.currentTimeMillis();//Zera o tempo
        QuickSort.sort(a);
        System.out.println("Tempo de execução do QuickSort para "
                + tamanho + " itens: "
                + (System.currentTimeMillis() - t1) / 1000 + " segundos.");
    }

    private static char[] geraArray(int tamanho) {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVYWXZ";
        char[] a = new char[tamanho];
        for (int i = 0; i < tamanho; i++) {
            a[i] = letras.charAt(0 + (int) (Math.random() * 26));
        }
        return a;
    }
}
