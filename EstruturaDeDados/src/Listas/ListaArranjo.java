/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Listas;

/**
 *
 * @author Ricardo
 */
public class ListaArranjo {

    protected int[] c;
    protected int cont;

    public ListaArranjo(int x) {
        this.cont = 0;
        this.c = new int[x];
    }

    public boolean find(int x) {
        for (int i = 0; i < this.cont; i++) {
            if (this.c[i] == x) {
                return true;
            }
        }
        return false;
    }

    public boolean add(int x) {
        //array esta cheio?
        if (this.c.length == this.cont) {
            return false;
        }
        //se a lista nao esta cheia prossegue
        //verifica se o numero já existe
        if (this.find(x)) {
            return false;
        }
        this.c[this.cont] = x;
        this.cont++;
        return true;

    }

    public boolean addEnd(int x) {
        return this.add(x);
    }

    public boolean addBegin(int x) {
        //array esta cheio?
        if (this.c.length == this.cont) {
            return false;
        }
        //se a lista nao esta cheia prossegue
        //verifica se o numero já existe
        if (this.find(x)) {
            return false;
        }
        //Desloca os elementos
        for (int i = this.cont; i > 0; i--) {
            this.c[i] = this.c[i - 1];
        }
        this.c[0] = x;
        this.cont++;
        return true;
    }

    public boolean remove(int x) {
        if (!this.find(x)) {
            return false;//se nao encontra o elemento retorna false
        }
        //passo 1: encontrar a posição
        int pos = 0;//posicao para apagar...
        for (int i = 0; i < this.cont; i++) {
            if (this.c[i] == x) {
                pos = i;
            }
        }
        //passo 2: deslocar elementos
        for (int i = pos; i < this.cont - 1; i++) {
            this.c[i] = this.c[i + 1];
        }
        //ultimo passo.. cont --
        this.cont--;
        return true;
    }

    public String toString() {
        if (this.cont == 0) {
            return "Lista vazia!";
        } else {
            String temp = "";
            for (int i = 0; i < this.cont; i++) {
                temp += this.c[i] + "; ";
            }
            return temp;
        }
    }
}
