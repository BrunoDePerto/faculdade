package Listas;

public class ED01 {

    public static void main(String[] args) {

        Pilha p = new Pilha();

        p.push(1);
        p.push(2);
        p.push(3);
        p.push(4);
        p.push(5);

        for (int i = 0; i < 5; i++) {
            System.out.println("" + p.pop());
        }
        System.out.println("------------");
        Fila f = new Fila();

        f.add(1);
        f.add(2);
        f.add(3);
        f.add(4);
        f.add(5);

        for (int i = 0; i < 5; i++) {
            System.out.println("" + f.remove());
        }


    }
}
