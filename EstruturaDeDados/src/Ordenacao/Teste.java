package Ordenacao;

public class Teste {

    public static void main(String args[]) {
        int tamanho = 1000;
        for (int i = 0; i < 7; i++) {
            teste(tamanho);
            tamanho *= 10;
        }
    }

    private static void teste(int tamanho) {
        //BubbleSort
        char[] a = geraArray(tamanho);
        long t1 = System.currentTimeMillis();//Tempo inicial
        if (tamanho < 1000000) {
            BubbleSort.sort(a);
            System.out.println("Tempo de execução do BulleSort para "
                    + tamanho + " itens: "
                    + (System.currentTimeMillis() - t1) / 100 + " décimo de segundo.");
        } else {
            System.out.println("Tempo de execução do BulleSort para "
                    + tamanho + " itens: maior que 10 minutos");
        }

        //InsertSort
        if (tamanho < 10000000) {
            a = geraArray(tamanho);
            t1 = System.currentTimeMillis();//Zera o tempo
            InsertSort.sort(a);
            System.out.println("Tempo de execução do InsertSort para "
                    + tamanho + " itens: "
                    + (System.currentTimeMillis() - t1) / 100 + " décimo de segundo.");
        } else {
            System.out.println("Tempo de execução do InsertSort para "
                    + tamanho + " itens: maior que 10 minutos");
        }

        //SelectionSort
        if (tamanho < 1000000) {
            a = geraArray(tamanho);
            t1 = System.currentTimeMillis();//Zera o tempo
            SelectionSort.sort(a);
            System.out.println("Tempo de execução do SelectionSort para "
                    + tamanho + " itens: "
                    + (System.currentTimeMillis() - t1) / 100 + " décimo de segundo.");
        } else {
            System.out.println("Tempo de execução do SelectionSort para "
                    + tamanho + " itens: maior que 10 minutos");
        }

        //MergeSort
        a = geraArray(tamanho);
        t1 = System.currentTimeMillis();//Zera o tempo
        MergeSort.sort(a);
        System.out.println("Tempo de execução do MergeSort para "
                + tamanho + " itens: "
                + (System.currentTimeMillis() - t1) / 100 + " décimo de segundo.");
        
        
        //QuickSort
        a = geraArray(tamanho);
        System.out.println("Começou");
        t1 = System.currentTimeMillis();//Zera o tempo
        QuickSort.sort(a);
        System.out.println("Tempo de execução do QuickSort para "
                + tamanho + " itens: "
                + (System.currentTimeMillis() - t1) / 100 + " décimo de segundo.");
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
