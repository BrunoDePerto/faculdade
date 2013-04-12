package Listas;
public class Nodo {
    private int info;
    private Nodo next;
        public Nodo(int info, Nodo next){
        this.info=info;
        this.next=next;
    }
        public Nodo(int info){
        this(info,null);
    }
    public Nodo getNext() {
        return next;
    }
    public void setNext(Nodo next) {
        this.next = next;
    }
    public int getInfo(){
        return this.info;
    }
}
