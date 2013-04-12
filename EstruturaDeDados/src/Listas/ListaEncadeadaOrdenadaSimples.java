package Listas;

public class ListaEncadeadaOrdenadaSimples extends ListaEncadeadaSimples {

    public ListaEncadeadaOrdenadaSimples() {
        super();
    }

    public boolean add(int info) {
        //Caso a lista esteja vazia...
        if (super.isEmpty()) {
            //this.first=new Nodo(info);
            //this.last=this.first;
            Nodo n = new Nodo(info);
            super.first = n;
            super.last = n;
            return true;
        }
//        //se a lista tem um elemento só... entao first = last
//        if (super.first == super.last) {
//            if (info == super.first.getInfo()) {//se for IGUAL....
//                //ENTAO NAO INSERE
//                return false;
//            } else {
//                if (info < super.first.getInfo()) {//insiro ANTES
//                    Nodo n = new Nodo(info);
//                    n.setNext(super.first);
//                    super.first = n;
//                    return true;
//                } else {//insere depois... 
//                    Nodo n = new Nodo(info);
//                    n.setNext(null);//linha é opcional... n next já é nulo...
//                    super.last = n;
//                    super.first.setNext(n);
//                    return true;
//                }
//            }
//        } 
        
        //demais casos... ou seja, quando a lista tem 1 ou mais elementos...
        //primeiro vou percorrer a lista...
        Nodo temp = super.first;
        Nodo tempPrev = null;
        while (temp != null) {
            if(info==temp.getInfo()){
                return false;//GARANTE que não insira número duplicados...
            }
            if (info < temp.getInfo()) { //se info for menor que nó atual entao...
                if (temp == super.first) {//será que o nó atual é o primeiro da lista?
                    //entao insere no início da lista...
                    Nodo n = new Nodo(info);
                    n.setNext(super.first);
                    super.first = n;
                    return true;
                }//MAS se o nó temp não é o primeiro... entao...
                Nodo n = new Nodo(info);
                tempPrev.setNext(n);
                n.setNext(temp);
                return true;
            }
            tempPrev = temp;
            temp = temp.getNext();
        }
        //se esse codigo abaixo chegar a ser executado é porque o número
        //que voce esta tentando inserir é maior que todos da lista... entao...
        //INSERE NO FIM...
        Nodo n = new Nodo(info);
        super.last.setNext(n);
        super.last = n;
        return true;
    }
}
