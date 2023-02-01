package baseClasses.Produtos;

import baseClasses.IdController;
import java.io.IOException;
import java.util.Objects;

public class Item extends IdController {

    private int qtd;
    private Produto produto;
    private double subTotal;
    private double valorUtilizado;
    private static int idAtualItem = 1;

    public Item() {
        super();
    }

    public Item(int qtd, Produto produto, double valorUtilizado) {
        super();
        this.qtd = qtd;
        this.produto = produto;
        this.valorUtilizado = valorUtilizado;
        this.subTotal = qtd * valorUtilizado;
    }

    public void set(int qtd, Produto produto, double valorUtilizado) {
        this.qtd = qtd;
        this.produto = produto;
        this.valorUtilizado = valorUtilizado;
        this.subTotal = qtd * valorUtilizado;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal() {
        this.subTotal = this.qtd * this.valorUtilizado;
    }

    public double getValorUtilizado() {
        return valorUtilizado;
    }

    public void setValorUtilizado(double valorUtilizado) {
        this.valorUtilizado = valorUtilizado;
    }

    public static int getIdAtualItem() {
        return idAtualItem;
    }

    public static void setIdAtualItem(int idAtualItem) {
        Item.idAtualItem = idAtualItem;
    }

    @Override
    public void incrementaIdAtual() {
        idAtual = idAtualItem;
        idAtualItem++;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        return Objects.equals(this.produto, other.produto);
    }

    public static int validaQtd(String qtd) throws IOException {
        if (qtd.isEmpty()) {
            throw new IOException("Insira a quantidade!");
        }

        int aux;
        try {
            aux = Integer.parseInt(qtd);
        } catch (NumberFormatException e) {
            throw new IOException("Quantidade invalida!");
        }
        if (aux <= 0) {
            throw new IOException("Quantidade invalida!");
        }
        return aux;
    }
}
