package Teste;

import TabelaHash.TabelaHash;

public class TesteTabelaHash {

    public TesteTabelaHash() {
    }

    public static void main(String[] args) {
        int quantidade = 1000;
        for (int i = 0; i < 7; i++) {
            TesteTabelaHash testeTabelaHash = new TesteTabelaHash();
            //Tempo t1
            long t1 = System.currentTimeMillis();
            TabelaHash th = testeTabelaHash.inserir(quantidade);
            //Tempo t2
            long t2 = System.currentTimeMillis();
            System.out.println("Tempo para inserir "
                    + quantidade + " elementos em uma Tabela Hash: " + (t2 - t1) + " milisegundos");
            testeTabelaHash.buscar(th);
            //Tempo t3
            long t3 = System.currentTimeMillis();
            System.out.println("Tempo para buscar um elemento em uma Tabela Hash com "
                    + quantidade + " elementos: " + (t3 - t2) + " milisegundos");
            quantidade *= 10;
        }
    }

    public TabelaHash inserir(int quantidade) {
        TabelaHash th = new TabelaHash();
        char[] letras = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'w', 'x', 'y', 'z'};
        int aleatorio;
        for (int i = 0; i < quantidade; i++) {
            String palavra = "";
            for (int j = 1; j <= 10; j++) {
                aleatorio = (int) (Math.random() * (letras.length));
                palavra += letras[aleatorio];
            }
            th.add(palavra, palavra + palavra + palavra);
        }
        return th;
    }
    public void buscar(TabelaHash th) {
        th.find("teste");
    }
}
