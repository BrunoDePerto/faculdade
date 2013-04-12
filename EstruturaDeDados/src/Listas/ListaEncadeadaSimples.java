package Listas;

public class ListaEncadeadaSimples {

    protected Nodo first;
    protected Nodo last;

    public ListaEncadeadaSimples() {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty() {// éVazia???
        if (this.first == null) {
            return true;
        }
        return false;
    }

    public boolean add(int info) {
        if (this.isEmpty()) {
            //this.first=new Nodo(info);
            //this.last=this.first;
            Nodo n = new Nodo(info);
            this.first = n;
            this.last = n;
            return true;
        } else {
            Nodo n = new Nodo(info);
            this.last.setNext(n);
            this.last = n;
            return true;
        }
    }

    public boolean addEnd(int info) {
        return this.add(info);
    }

    public boolean addBegin(int info) {
        if (this.isEmpty()) {
            //this.first=new Nodo(info);
            //this.last=this.first;
            Nodo n = new Nodo(info);
            this.first = n;
            this.last = n;
            return true;
        } else {
            Nodo n = new Nodo(info);
            n.setNext(this.first);
            this.first = n;
            return true;
        }
    }

    public boolean find(int x) {
        if (this.isEmpty()) {
            return false;
        }
        Nodo noTemp = this.first;
        while (noTemp != null) {
            if (noTemp.getInfo() == x) {
                return true;
            }
            noTemp = noTemp.getNext();
        }
        return false;
    }

    public boolean remove(int x) {
        if (this.isEmpty()) {
            return false;
        }
        Nodo noTemp = this.first; //nó atual
        Nodo noTempPrev = null;//nó anterior... 
        //caso a lista tenha 2 elementos ou MAIS... entao...
        if (this.first.getInfo() == x) {
            this.first = this.first.getNext();
            if (this.first == null) {//se first é nulo a lista só tem um elemento...
                this.last = null;
            }
            return true;
        }
        while (noTemp != null) {
            if (noTemp.getInfo() == x) {
                //aqui remove o elemento atual...
                noTempPrev.setNext(noTemp.getNext());
                //porém se o elemento excluído for o ultimo devemos atualizar o last...
                if (this.last == noTemp) {
                    this.last = noTempPrev;
                }
                return true;
            }
            noTempPrev = noTemp;
            noTemp = noTemp.getNext();
        }
        return false;
    }

    public int removeEnd() {
        if (this.isEmpty()) {
            return 0;
        }
        Nodo noTemp = this.first; //nó atual
        Nodo noTempPrev = null;//nó anterior... 
        //caso a lista tenha 2 elementos ou MAIS... entao...
        while (noTemp != this.last) {
            noTempPrev = noTemp;
            noTemp = noTemp.getNext();
        }
        int temp = this.last.getInfo();
        noTempPrev.setNext(null);
        this.last = noTempPrev;
        return temp;
    }

    public int removeBegin() {
        if (this.isEmpty()) {
            return 0;
        }
        int temp = this.first.getInfo();
        this.first = this.first.getNext();
        return temp;
    }

    public String toString() {
        if (this.isEmpty()) {
            return "Lista vazia!";
        } else {
            String temp = "";
            Nodo noTemp = this.first;
            while (noTemp != null) {
                temp += noTemp.getInfo() + "; ";
                noTemp = noTemp.getNext();
            }
            return temp;
        }
    }
}
