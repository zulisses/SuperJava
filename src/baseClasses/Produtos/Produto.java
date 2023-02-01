package baseClasses.Produtos;

import baseClasses.IdController;
import java.io.IOException;

public class Produto extends IdController {

    private String nome;
    private String marca;
    private double valorCompra;
    private double valorVenda;
    private double valorPromocao;
    private static int idAtualProduto = 1;

    public Produto() {
        super();
    }

    public Produto(String nome, String marca, double valorCompra, double valorVenda, double valorPromocao) {
        super();
        this.nome = nome;
        this.marca = marca;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
        this.valorPromocao = valorPromocao;
    }

    public void set(Produto produto) {
        this.nome = produto.getNome();
        this.marca = produto.getMarca();
        this.valorCompra = produto.getValorCompra();
        this.valorVenda = produto.getValorVenda();
        this.valorPromocao = produto.getValorPromocao();
    }

    public void set(String nome, String marca, double valorCompra, double valorVenda, double valorPromocao) {
        this.nome = nome;
        this.marca = marca;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
        this.valorPromocao = valorPromocao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public double getValorPromocao() {
        return valorPromocao;
    }

    public void setValorPromocao(double valorPromocao) {
        this.valorPromocao = valorPromocao;
    }

    @Override
    public void incrementaIdAtual() {
        idAtual = idAtualProduto;
        idAtualProduto++;
    }

    public static String validaNome(String nome) throws IOException {
        if (nome.isEmpty()) {
            throw new IOException("Insira o nome!");
        }
        return nome;
    }

    public static String validaMarca(String marca) throws IOException {
        if (marca.isEmpty()) {
            throw new IOException("Insira a marca!");
        }
        return marca;
    }

    public static double validaValorCompra(String valorCompra) throws IOException {
        if (valorCompra.isEmpty()) {
            throw new IOException("Insira o valor de compra!");
        }

        double aux;
        try {
            aux = Double.parseDouble(valorCompra);
        } catch (NumberFormatException e) {
            throw new IOException("Valor de Compra invalido!");
        }
        if (aux < 0) {
            throw new IOException("Valor de Compra invalido!");
        }
        return aux;
    }

    public static double validaValorVenda(String valorVenda) throws IOException {
        if (valorVenda.isEmpty()) {
            throw new IOException("Insira o valor de venda!");
        }

        double aux;
        try {
            aux = Double.parseDouble(valorVenda);
        } catch (NumberFormatException e) {
            throw new IOException("Valor de Venda invalido!");
        }
        if (aux < 0) {
            throw new IOException("Valor de Venda invalido!");
        }
        return aux;
    }

    public static double validaValorPromocao(String valorPromocao) throws IOException {
        if (valorPromocao.isEmpty()) {
            throw new IOException("Insira o valor de promoção!");
        }

        double aux;
        try {
            aux = Double.parseDouble(valorPromocao);
        } catch (NumberFormatException e) {
            throw new IOException("Valor de Promoção invalido!");
        }
        if (aux < 0) {
            throw new IOException("Valor de Promoção invalido!");
        }
        return aux;
    }
}
