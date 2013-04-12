package Ordenacao;

public class ED2 {

    public static void main(String args[]) {
        char[] a = {'c', 'b', 'd', 'a', 't'};

        //BubbleSort.sort(a);
        //InsertSort.sort(a);
        //SelectionSort.sort(a);
        QuickSort.sort(a);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
