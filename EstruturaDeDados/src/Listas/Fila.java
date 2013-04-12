package Listas;

public class Fila {
    
    ListaEncadeadaSimples lista = new ListaEncadeadaSimples();

    public boolean add(int info) {//insere na pilha...
        return this.lista.addEnd(info);
    }
    
    public int remove() {//retirar da pilha...
        return this.lista.removeBegin();
    }
    
    
}
