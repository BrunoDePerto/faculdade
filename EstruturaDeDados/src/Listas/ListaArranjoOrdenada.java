package Listas;

public class ListaArranjoOrdenada extends ListaArranjo {

    public ListaArranjoOrdenada(int x) {
        super(x);
    }

    @Override
    public boolean add(int x) {
        //array esta cheio?
        if (super.c.length == super.cont) {
            return false;
        }
        //se a lista nao esta cheia prossegue

        //verifica se o numero já existe
        if (this.find(x)) {
            return false;
        }
        //se lista vazia...
        if (super.cont == 0) {
            super.c[0] = x;
            this.cont++;
            return true;
        }

        //Numero nao existe entao insere em ordem...
        for (int i = 0; i < super.cont; i++) {
            if (super.c[i] > x) {
                //"i" marca a posição onde quero inserir
                //passo 1: deslocar elementos
                for (int j = super.cont; j > i; j--) {
                    super.c[j] = super.c[j - 1];
                }
                //passo 2: incluir o novo número na posição "i"
                super.c[i] = x;
                this.cont++;
                return true;
            }
        }//se sair desse for sem incluir... é porque 
        //o número é o maior até agora... entao inclui 
        //no final da lista...
        super.c[super.cont] = x;
        this.cont++;
        return true;
    }
}//fim da classe
