package TabelaHash;


public class NodoHash {

    private Object index;
    private Object valor;
    private NodoHash next;

    public NodoHash(Object index, Object valor, NodoHash next) {
        this.index = index;
        this.valor = valor;
        this.next = next;
    }

    public NodoHash(Object index, Object valor) {
        this(index, valor, null);
    }

    public NodoHash getNext() {
        return next;
    }

    public void setNext(NodoHash next) {
        this.next = next;
    }

    public Object getIndex() {
        return this.index;
    }
    
    public Object getValor(){
        return this.valor;
    }
}
