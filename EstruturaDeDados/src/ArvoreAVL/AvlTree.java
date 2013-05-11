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

    public boolean insert(int info) {
        root = insert(info, root);
        return true;
    }

    private AvlNode insert(int info, AvlNode no) {
        if (no == null) {
            no = new AvlNode(info, null, null);
        } else if (info < no.info) {
            no.e = insert(info, no.e);
        } else if (info > no.info) {
            no.d = insert(info, no.d);
        }
        no = balance(no);
        return no;
    }

    public AvlNode balance(AvlNode no) {
        if (getFactor(no) == 2) {
            if (getFactor(no.e) > 0) {
                no = doRightRotation(no);
            } else {
                no = doDoubleRightRotation(no);
            }
        } else if (getFactor(no) == -2) {
            if (getFactor(no.d) < 0) {
                no = doLeftRotation(no);
            } else {
                no = doDoubleLeftRotation(no);
            }
        }
        no.height = max(height(no.e), height(no.d)) + 1;
        return no;
    }

    /**
     * Faz Rotação simples a direita
     */
    private static AvlNode doRightRotation(AvlNode no2) {
        AvlNode no1 = no2.e;
        no2.e = no1.d;
        no1.d = no2;
        no2.height = max(height(no2.e), height(no2.d)) + 1;
        no1.height = max(height(no1.e), no2.height) + 1;
        return no1;
    }

    /**
     * Rotação simples à esquerda
     */
    private static AvlNode doLeftRotation(AvlNode no1) {
        AvlNode no2 = no1.d;
        no1.d = no2.e;
        no2.e = no1;
        no1.height = max(height(no1.e), height(no1.d)) + 1;
        no2.height = max(height(no2.d), no1.height) + 1;
        return no2;
    }

    /**
     * Rotação dupla à direita
     */
    private static AvlNode doDoubleRightRotation(AvlNode no3) {
        no3.e = doLeftRotation(no3.e);
        return doRightRotation(no3);
    }

    /**
     * Rotação dupla à esquerda
     */
    private static AvlNode doDoubleLeftRotation(AvlNode no1) {
        no1.d = doRightRotation(no1.d);
        return doLeftRotation(no1);
    }

    public AvlNode search(int info) {
        return search(root, info);
    }

    protected AvlNode search(AvlNode no, int info) {
        while (no != null) {
            /* se valor procuradp == chave do nó retorna referência ao nó */
            if (info == no.info) {
                return no;
            } /* se valor procurado < chave do nó, procurar na sub-árvore esquerda deste nó */ else if (info < no.info) {
                no = no.e;
            } /* se valor procurado > chave do nó, procurar na sub-árvore direita deste nó */ else {
                no = no.d;
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

    protected void preorder(AvlNode no) {
        if (no != null) {
            System.out.print(no.info + " ");
            preorder(no.e);
            preorder(no.d);
        }
    }

    public void postorder() {
        postorder(root);
    }

    protected void postorder(AvlNode no) {
        if (no != null) {
            postorder(no.e);
            postorder(no.d);
            System.out.print(no.info + " ");
        }
    }

    protected AvlNode searchFather(int info) {
        AvlNode no = root;
        AvlNode noPrev = null;
        while (no != null && !(no.info == info)) {  // acha o nó p com a chave el  
            noPrev = no;
            if (no.info < info) {
                no = no.d;
            } else {
                no = no.e;
            }
        }
        if (no != null && no.info == info) {
            return noPrev;
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

    private void displaySubTree(AvlNode no, String separacao) {

        if (no != null) {

            AvlNode father = this.searchFather(no.info);
            if (no.equals(father.e) == true) {
                System.out.println(separacao + no.info + "(" + no.height + ")" + " (ESQ)");
            } else {
                System.out.println(separacao + no.info + "(" + no.height + ")" + " (DIR)");
            }
            displaySubTree(no.e, "     " + separacao);
            displaySubTree(no.d, "     " + separacao);
        }
    }

}// class  