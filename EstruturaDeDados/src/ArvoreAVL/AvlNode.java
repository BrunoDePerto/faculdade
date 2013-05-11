package ArvoreAVL;

public class AvlNode {

    protected int height;       // Height  
    protected int info;
    protected AvlNode e, d;

    public AvlNode(int theElement) {
        this(theElement, null, null);
    }

    public AvlNode(int theElement, AvlNode lt, AvlNode rt) {
        info = theElement;
        e = lt;
        d = rt;
        height = 0;
    }
}
