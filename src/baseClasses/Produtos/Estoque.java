package baseClasses.Produtos;

import java.util.ArrayList;

public class Estoque {

    private ArrayList<Item> itens;

    public Estoque() {
        super();
        itens = new ArrayList<>();
    }

    public ArrayList<Item> getItens() {
        return (ArrayList<Item>) itens.clone();
    }

    public boolean verificaEstoque(Produto produto, int qtd) {
        for (int i = 0; i < itens.size(); i++) {
            if (produto.equals(itens.get(i).getProduto())) {
                return itens.get(i).getQtd() >= qtd;
            }
        }
        return false;
    }

    public void addProduto(Produto produto) {
        int index = -1;
        for (int i = 0; i < itens.size(); i++) {
            if (itens.get(i).getProduto().equals(produto)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            itens.add(new Item(0, produto, produto.getValorCompra()));
            itens.get(itens.size() - 1).setId(produto.getId());
        } else {
            itens.get(index).setProduto(produto);
        }
    }

    public void removeProduto(Produto produto) {
        itens.remove(produto);
    }

    public void removeItens(ArrayList<Item> itens) {
        for (int i = 0; i < this.itens.size(); i++) {
            for (int j = 0; j < itens.size(); j++) {
                if (this.itens.get(i).equals(itens.get(j))) {
                    this.itens.get(i).setQtd(this.itens.get(i).getQtd() - itens.get(j).getQtd());
                }
            }
            this.itens.get(i).setSubTotal();
        }
    }

    public void addItens(ArrayList<Item> itens) {
        for (int i = 0; i < this.itens.size(); i++) {
            for (int j = 0; j < itens.size(); j++) {
                if (this.itens.get(i).equals(itens.get(j))) {
                    this.itens.get(i).setQtd(this.itens.get(i).getQtd() + itens.get(j).getQtd());
                }
            }
            this.itens.get(i).setSubTotal();
        }
    }

    public void removeItem(Item item) {
        for (int i = 0; i < this.itens.size(); i++) {
            if (this.itens.get(i).equals(item)) {
                this.itens.get(i).setQtd(this.itens.get(i).getQtd() - item.getQtd());
            }

            this.itens.get(i).setSubTotal();
        }
    }

    public void addItem(Item item) {
        for (int i = 0; i < this.itens.size(); i++) {
            if (this.itens.get(i).equals(item)) {
                this.itens.get(i).setQtd(this.itens.get(i).getQtd() + item.getQtd());
            }

            this.itens.get(i).setSubTotal();
        }
    }
}
