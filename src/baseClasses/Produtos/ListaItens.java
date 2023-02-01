package baseClasses.Produtos;

import java.util.ArrayList;

public class ListaItens {

    private ArrayList<Item> itens;

    public ListaItens() {
        super();
        itens = new ArrayList<>();
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }
}
