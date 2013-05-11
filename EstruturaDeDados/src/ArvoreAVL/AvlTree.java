package ArvoreAVL;

public class AvlTree {

    private AvlNode root = null;

    public AvlTree() {
        root = null;
    }

    public void clear() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public AvlNode getRootNode() { // é o getRaiz()
        return root;
    }

    /**
     * Retorna a altura da árvore
     */
    private static int height(AvlNode t) {
        return t == null ? -1 : t.height;
    }

    /**
     * Retorna o maior valor ente lhs e rhs.
     */
    private static int max(int lhs, int rhs) {
        return lhs > rhs ? lhs : rhs;
    }

    /**
     * Retorna o fator de balanceamento da árvore com raiz t
     */
    private int getFactor(AvlNode t) {
        return height(t.e) - height(t.d);
    }

    public boolean insert(int x) {
        root = insert(x, root);
        return true;
    }

    private AvlNode insert(int x, AvlNode t) {
        if (t == null) {
            t = new AvlNode(x, null, null);
        } else if (x < t.info) {
            t.e = insert(x, t.e);
        } else if (x > t.info) {
            t.d = insert(x, t.d);
        }
        t = balance(t);
        return t;
    }

    public AvlNode balance(AvlNode t) {
        if (getFactor(t) == 2) {
            if (getFactor(t.e) > 0) {
                t = doRightRotation(t);
            } else {
                t = doDoubleRightRotation(t);
            }
        } else if (getFactor(t) == -2) {
            if (getFactor(t.d) < 0) {
                t = doLeftRotation(t);
            } else {
                t = doDoubleLeftRotation(t);
            }
        }
        t.height = max(height(t.e), height(t.d)) + 1;
        return t;
    }

    /**
     * Faz Rotação simples a direita
     */
    private static AvlNode doRightRotation(AvlNode k2) {
        AvlNode k1 = k2.e;
        k2.e = k1.d;
        k1.d = k2;
        k2.height = max(height(k2.e), height(k2.d)) + 1;
        k1.height = max(height(k1.e), k2.height) + 1;
        return k1;
    }

    /**
     * Rotação simples à esquerda
     */
    private static AvlNode doLeftRotation(AvlNode k1) {
        AvlNode k2 = k1.d;
        k1.d = k2.e;
        k2.e = k1;
        k1.height = max(height(k1.e), height(k1.d)) + 1;
        k2.height = max(height(k2.d), k1.height) + 1;
        return k2;
    }

    /**
     * Rotação dupla à direita
     */
    private static AvlNode doDoubleRightRotation(AvlNode k3) {
        k3.e = doLeftRotation(k3.e);
        return doRightRotation(k3);
    }

    /**
     * Rotação dupla à esquerda
     */
    private static AvlNode doDoubleLeftRotation(AvlNode k1) {
        k1.d = doRightRotation(k1.d);
        return doLeftRotation(k1);
    }

    public AvlNode search(int el) {
        return search(root, el);
    }

    protected AvlNode search(AvlNode p, int el) {
        while (p != null) {
            /* se valor procuradp == chave do nó retorna referência ao nó */
            if (el == p.info) {
                return p;
            } /* se valor procurado < chave do nó, procurar na sub-árvore esquerda deste nó */ else if (el < p.info) {
                p = p.e;
            } /* se valor procurado > chave do nó, procurar na sub-árvore direita deste nó */ else {
                p = p.d;
            }
        }
        // caso chave não foi achada, retorna null  
        return null;
    }

    public void inorder() {
        inorder(root);
    }

    protected void inorder(AvlNode p) {
        if (p != null) {
            inorder(p.e);
            System.out.print(p.info + " - ");
            inorder(p.d);
        }
    }

    public void preorder() {
        preorder(root);
    }

    protected void preorder(AvlNode p) {
        if (p != null) {
            System.out.print(p.info + " ");
            preorder(p.e);
            preorder(p.d);
        }
    }

    public void postorder() {
        postorder(root);
    }

    protected void postorder(AvlNode p) {
        if (p != null) {
            postorder(p.e);
            postorder(p.d);
            System.out.print(p.info + " ");
        }
    }

    protected AvlNode searchFather(int el) {
        AvlNode p = root;
        AvlNode prev = null;
        while (p != null && !(p.info == el)) {  // acha o nó p com a chave el  
            prev = p;
            if (p.info < el) {
                p = p.d;
            } else {
                p = p.e;
            }
        }
        if (p != null && p.info == el) {
            return prev;
        }
        return null;
    }

    /* método de autoria de Leonardo Zandoná - 2006/2 */
    public void displayTree() {
        if (isEmpty()) {
            System.out.println("Árvore vazia!");
            return;
        }
        String separator = String.valueOf("  |__");
        System.out.println(this.root.info + "(" + root.height + ")");
        displaySubTree(root.e, separator);
        displaySubTree(root.d, separator);
    }

    private void displaySubTree(AvlNode node, String separator) {

        if (node != null) {

            AvlNode father = this.searchFather(node.info);
            if (node.equals(father.e) == true) {
                System.out.println(separator + node.info + "(" + node.height + ")" + " (ESQ)");
            } else {
                System.out.println(separator + node.info + "(" + node.height + ")" + " (DIR)");
            }
            displaySubTree(node.e, "     " + separator);
            displaySubTree(node.d, "     " + separator);
        }
    }

    public static void main(String args[]) {
        AvlTree t = new AvlTree();
        t.insert(1);
        t.insert(2);
        t.insert(3);
        t.insert(4);
        t.insert(5);
        t.insert(6);
        t.insert(7);
        t.insert(8);
        t.insert(9);
        t.displayTree();
    }
}// class  