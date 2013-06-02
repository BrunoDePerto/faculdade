package TabelaHash;

public class ListaHash {

    protected NodoHash first;
    protected NodoHash last;

    public ListaHash() {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty() {// éVazia???
        if (this.first == null) {
            return true;
        }
        return false;
    }

    public boolean add(Object index, Object valor) {
        if (this.isEmpty()) {
            NodoHash nh = new NodoHash(index, valor);
            this.first = nh;
            this.last = nh;
            return true;
        } else {
            NodoHash nh = new NodoHash(index, valor);
            this.last.setNext(nh);
            this.last = nh;
            return true;
        }
    }

    public boolean addEnd(Object index, Object valor) {
        return this.add(index, valor);
    }

    public boolean addBegin(Object index, Object valor) {
        if (this.isEmpty()) {
            //this.first=new Nodo(info);
            //this.last=this.first;
            NodoHash nh = new NodoHash(index, valor);
            this.first = nh;
            this.last = nh;
            return true;
        } else {
            NodoHash nh = new NodoHash(index, valor);
            nh.setNext(this.first);
            this.first = nh;
            return true;
        }
    }

    public NodoHash find(Object index) {
        if (this.isEmpty()) {
            return null;
        }
        NodoHash nhTemp = this.first;
        while (nhTemp != null) {
            if (nhTemp.getIndex() == index) {
                return nhTemp;
            }
            nhTemp = nhTemp.getNext();
        }
        return null;
    }

    public boolean remove(Object index) {
        if (this.isEmpty()) {
            return false;
        }
        NodoHash nhTemp = this.first; //nó atual
        NodoHash nhTempPrev = null;//nó anterior... 
        //caso a lista tenha 2 elementos ou MAIS... entao...
        if (this.first.getIndex() == index) {
            this.first = this.first.getNext();
            if (this.first == null) {//se first é nulo a lista só tem um elemento...
                this.last = null;
            }
            return true;
        }
        while (nhTemp != null) {
            if (nhTemp.getIndex() == index) {
                //aqui remove o elemento atual...
                nhTempPrev.setNext(nhTemp.getNext());
                //porém se o elemento excluído for o ultimo devemos atualizar o last...
                if (this.last == nhTemp) {
                    this.last = nhTempPrev;
                }
                return true;
            }
            nhTempPrev = nhTemp;
            nhTemp = nhTemp.getNext();
        }
        return false;
    }

    public Object removeEnd() {
        if (this.isEmpty()) {
            return null;
        }
        NodoHash nhTemp = this.first; //nó atual
        NodoHash nhTempPrev = null;//nó anterior... 
        //caso a lista tenha 2 elementos ou MAIS... entao...
        while (nhTemp != this.last) {
            nhTempPrev = nhTemp;
            nhTemp = nhTemp.getNext();
        }
        Object temp = this.last.getIndex();
        nhTempPrev.setNext(null);
        this.last = nhTempPrev;
        return temp;
    }

    public Object removeBegin() {
        if (this.isEmpty()) {
            return null;
        }
        Object temp = this.first.getIndex();
        this.first = this.first.getNext();
        return temp;
    }

    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "Lista vazia!";
        } else {
            String temp = "";
            NodoHash nhTemp = this.first;
            while (nhTemp != null) {
                temp += "Indice: " + nhTemp.getIndex();
                temp += " Valor: " + nhTemp.getValor();
                temp += "\n";
                nhTemp = nhTemp.getNext();
            }
            return temp;
        }
    }
}
