package Listas;

public class TesteDePerformance {

    public static void main(String args[]) {
        ListaArranjo lista = new ListaArranjo(100000);
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            lista.add(i);
        //    System.out.println(lista);
        }
        long t2 = System.currentTimeMillis();
        //System.out.println("Inicia exclusão");
//        for (int i = 10; i > 0; i--) {
        for (int i = 0; i < 100000; i++) {
            lista.remove(i);
        //    System.out.println(lista);
        }
        long t3 = System.currentTimeMillis();
        System.out.println("Para inserir: " + (t2 - t1));

        System.out.println("Para excluir: " + (t3 - t2));

    }
}