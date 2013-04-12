package Listas;

public class Pilha {

    ListaEncadeadaSimples lista = new ListaEncadeadaSimples();

    public boolean push(int info) {//insere na pilha...
        return this.lista.addBegin(info);
    }
    
    public int pop() {//retirar da pilha...
        return this.lista.removeBegin();
    }
    
    
}
