package Arvore;

/**
 *
 * @author Bruno
 */
public class Tree {

    private NoTree raiz;

    public Tree() {
        this.raiz = null;
    }

    public boolean add(int info) {
        if (this.isEmpty()) {
            this.raiz = new NoTree(info);
            return true;
        }
        //se esta aqui é pq a arvore nao esta vazia
        NoTree temp = this.raiz;
        while (temp != null) {
            //nao deixa inserir numeros duplicados
            if (info == temp.getInfo()) {
                return false;
            }
            //antes de ir para esquerda verifica se existe
            if (info < temp.getInfo()) {
                //insere aqui mesmo
                if (temp.getE() == null) {
                    temp.setE(new NoTree(info));
                    return true;
                }
                //se nao for nulo, avança!!!
                temp = temp.getE();
            } else {
                //antes de ir para direita verifica se existe
                if (temp.getD() == null) {
                    temp.setD(new NoTree(info));
                    return true;
                }
                //se nao for nulo, avança!!!
                temp = temp.getD();
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return this.raiz == null;
    }

    public void inOrder() {
        this.inOrder(this.raiz);
    }

    private void inOrder(NoTree temp) {
        if (temp != null) {
            this.inOrder(temp.getE());
            System.out.print(temp.getInfo() + " ; ");
            this.inOrder(temp.getD());
        }
    }

    public void preOrder() {
        this.preOrder(raiz);
    }

    private void preOrder(NoTree temp) {
        if (temp != null) {
            System.out.print(temp.getInfo() + " ; ");
            this.preOrder(temp.getE());
            this.preOrder(temp.getD());
        }
    }

    public void posOrder() {
        this.posOrder(raiz);
    }

    private void posOrder(NoTree temp) {
        if (temp != null) {
            this.posOrder(temp.getE());
            this.posOrder(temp.getD());
            System.out.print(temp.getInfo() + " ; ");
        }
    }

    @Override
    public String toString() {
        String[] linha = new String[10];
        int i = 0;
        String[] retorno = toString(raiz, linha, i);
        String ret = "";
        for (String string : retorno) {
            if (string != null) {
                ret += string + "\n";
            }
        }

        return ret;
    }

    private String[] toString(NoTree temp, String[] linha, int i) {
        if (temp != null) {
            if (linha[i] != null) {
                linha[i] += temp.getInfo() + " ; ";
            } else {
                linha[i] = temp.getInfo() + " ; ";
            }
            i++;
            this.toString(temp.getE(), linha, i);
            this.toString(temp.getD(), linha, i);
            i--;
        }
        return linha;
    }
}
