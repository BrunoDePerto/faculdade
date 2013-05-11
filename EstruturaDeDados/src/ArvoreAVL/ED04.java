package ArvoreAVL;

public class ED04 {

    public static void main(String args[]) {
        
        AvlTree t = new AvlTree();
        t.insert(21);
        t.insert(26);
        t.insert(35);
        t.insert(14);
        t.insert(55);
        t.insert(16);
        t.insert(87);
        t.insert(88);
        t.insert(9);
        t.displayTree();
        
        
        //t.inorder();
    }
}