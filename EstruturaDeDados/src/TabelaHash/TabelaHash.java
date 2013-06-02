package TabelaHash;

public class TabelaHash {

    private ListaHash listas;

    public static void main(String[] args) {
        TabelaHash th = new TabelaHash();
        int n = 10000000;
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            th.add("Bruno", "É um cara legal");
//            th.add("Marihelly", "É mais legal ainda");
//            th.add("Francis", "É o cara mais legal do mundo");
//            th.add("Bola", "É redonda");
        }
        long t2 = System.currentTimeMillis();
        System.out.println("Tempo: " + (t2 - t1) + " para inserir: " + n + " elementos");
    }

    public TabelaHash() {
        listas = new ListaHash();
    }

    public char funcaoHash(String index) {
        index = index.toLowerCase();
        char posicao = index.charAt(0);
        return posicao;
    }

    public void add(String index, String valor) {
        find(index).add(index, valor);
    }

    public ListaHash find(String index) {
        NodoHash nhTemp = listas.find(funcaoHash(index));
        if (nhTemp == null) {
            listas.add(funcaoHash(index), new ListaHash());
            nhTemp = listas.find(funcaoHash(index));
        }
        return (ListaHash) nhTemp.getValor();
    }

    @Override
    public String toString() {
        String retorno = "";
        NodoHash nhTemp = (NodoHash) listas.first;
        while (nhTemp != null) {
            retorno += nhTemp.getValor();
            nhTemp = nhTemp.getNext();
        }
        return retorno;
    }
}
