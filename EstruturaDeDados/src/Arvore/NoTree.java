package Arvore;

/**
 *
 * @author Bruno
 */
public class NoTree {

    private String info = "";
    private NoTree e = null;
    private NoTree d = null;

    public NoTree(String info) {
        this.info = info;
        this.e = null;
        this.d = null;
    }

    public String getInfo() {
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
