package Arvore;

/**
 *
 * @author Bruno
 */
public class NoTree {

    private int info = 0;
    private NoTree e = null;
    private NoTree d = null;

    public NoTree(int info) {
        this.info = info;
        this.e = null;
        this.d = null;
    }

    public int getInfo() {
        return info;
    }

    public NoTree getE() {
        return e;
    }

    public void setE(NoTree e) {
        this.e = e;
    }

    public NoTree getD() {
        return d;
    }

    public void setD(NoTree d) {
        this.d = d;
    }
}
