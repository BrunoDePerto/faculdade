package Arvore;

/**
 *
 * @author Bruno
 */
public class ED03 {
    
    public static void main(String args[]){
        
        Tree t = new Tree();
        t.add(5);
        t.add(11);
        t.add(2);
        t.add(7);
        t.add(5);
        t.add(-3);
        t.add(-7);
        t.add(-1);
        t.add(69);
        t.add(4);
        t.add(80);
        System.out.println("preOrdem");
        t.preOrder();
        System.out.println("");
        System.out.println("inOrder: ");
        t.inOrder();
        System.out.println("");
        System.out.println("posOrdem");
        t.posOrder();
        System.out.println(t);
    }
}
