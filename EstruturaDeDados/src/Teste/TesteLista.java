package Teste;

import Listas.ListaArranjo;
import Listas.ListaArranjoOrdenada;
import Listas.ListaEncadeadaSimples;

public class TesteLista {

    public static void main(String args[]) {
        int elementos = 1000;
        for (int i = 0; i < 7; i++) {
            ListaArranjo lista = new ListaArranjoOrdenada(elementos);
            //ListaEncadeadaSimples lista = new ListaEncadeadaSimples();
            long t1 = System.currentTimeMillis();
            for (int j = 0; j < elementos; j++) {
                lista.add(j);
            }
            long t2 = System.currentTimeMillis();
            System.out.println("Para inserir " + elementos
                    + " elementos em uma lista com Arranjo, demorou: " + (t2 - t1));
            for (int j = 0; j < elementos; j++) {
                lista.find(999999999);
            }
            long t3 = System.currentTimeMillis();
            System.out.println("Para buscar " + elementos
                    + " elementos em uma lista com Arranjo, demorou: " + (t3 - t2));
            elementos *= 10;
        }
    }
}