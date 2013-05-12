/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ArvoreAVL;

/**
 *
 * @author Bruno
 */
public class TesteArvoreAVL {

    public TesteArvoreAVL() {
    }

    public static void main(String args[]) {
        int quantidade = 1000000;
        for (int i = 1; i < 11; i++) {
            TesteArvoreAVL testeArvoreAVL = new TesteArvoreAVL();
            //Tempo t1
            long t1 = System.currentTimeMillis();
            AvlTree avlTree = testeArvoreAVL.inserir(quantidade * i);
            //Tempo t2
            long t2 = System.currentTimeMillis();
            System.out.println("Tempo para inserir " + 
                    quantidade * i + " elementos em uma Arvore AVL: " + (t2 - t1) + " milisegundos");
            testeArvoreAVL.buscar(avlTree, 145);
            //Tempo t3
            long t3 = System.currentTimeMillis();
            System.out.println("Tempo para buscar um elemento em uma Arvore AVL com " + 
                    quantidade * i + " elementos: " + (t3 - t2) + " milisegundos");
        }

    }

    public AvlTree inserir(int quantidade) {
        AvlTree avlTree = new AvlTree();
        for (int i = 0; i < quantidade; i++) {
            avlTree.insert((int) (Math.random() * quantidade));
        }
        return avlTree;
    }

    public void buscar(AvlTree avlTree, int info) {
        avlTree.search(info);
    }
}
