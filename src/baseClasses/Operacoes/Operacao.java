package baseClasses.Operacoes;

import baseClasses.Pessoas.Funcionario;
import baseClasses.Produtos.ListaItens;
import baseClasses.IdController;
import java.io.IOException;
import java.time.LocalDate;

public abstract class Operacao extends IdController {

    protected ListaItens listaItens;
    protected char formaPagamento;
    /*
    v - dinheiro (a vista)
    p - a prazo
    c - cartao de credito
    d - cartao de debito
     */
    protected Funcionario funcionario;
    protected LocalDate dataOperacao;
    protected double porcentagemDesconto;
    protected double valorTotal;

    public Operacao() {
        super();
    }

    public Operacao(ListaItens listaItens, char formaPagamento, Funcionario funcionario, LocalDate dataOperacao) {
        super();
        this.listaItens = listaItens;
        this.formaPagamento = formaPagamento;
        this.funcionario = funcionario;
        this.dataOperacao = dataOperacao;
    }

    public void set(ListaItens listaItens, char formaPagamento, Funcionario funcionario, LocalDate dataOperacao) {
        this.listaItens = listaItens;
        this.formaPagamento = formaPagamento;
        this.funcionario = funcionario;
        this.dataOperacao = dataOperacao;
    }

    public ListaItens getListaItens() {
        return listaItens;
    }

    public void setListaItens(ListaItens listaItens) {
        this.listaItens = listaItens;
    }

    public char getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(char formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public LocalDate getDataOperacao() {
        return dataOperacao;
    }

    public void setDataOperacao(LocalDate dataOperacao) {
        this.dataOperacao = dataOperacao;
    }

    public double getPorcentagemDesconto() {
        return porcentagemDesconto;
    }

    public void setPorcentagemDesconto(double porcentagemDesconto) {
        this.porcentagemDesconto = porcentagemDesconto;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public static void validaListaItens(ListaItens listaItens) throws IOException {
        if (listaItens.getItens().isEmpty()) {
            throw new IOException("Insira algum item na lista!");
        }
    }

    public static void validaFuncionario(Funcionario funcionario) throws IOException {
        if (funcionario == null) {
            throw new IOException("Insira o funcionario!");
        }
    }

    public static double validaPorcentagemDesconto(String porcentagemDesconto) throws IOException {
        if (porcentagemDesconto.isEmpty()) {
            throw new IOException("Insira a porcentagem de desconto!");
        }

        double aux;
        try {
            aux = Double.parseDouble(porcentagemDesconto);
        } catch (NumberFormatException e) {
            throw new IOException("Porcentagem invalida!");
        }
        if (aux <= 0 || aux >= 100) {
            throw new IOException("Porcentagem invalida!");
        }
        return aux;
    }
}
