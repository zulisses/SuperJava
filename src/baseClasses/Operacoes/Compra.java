package baseClasses.Operacoes;

import baseClasses.Pessoas.Fornecedor;
import baseClasses.Pessoas.Funcionario;
import baseClasses.Produtos.ListaItens;
import java.io.IOException;
import java.time.LocalDate;

public class Compra extends Operacao {

    private Fornecedor fornecedor;
    private static int idAtualCompra = 1;

    public Compra() {
        super();
    }

    public Compra(ListaItens listaItens, char formaPagamento, Funcionario funcionario, LocalDate dataOperacao, Fornecedor fornecedor) {
        super(listaItens, formaPagamento, funcionario, dataOperacao);
        this.fornecedor = fornecedor;
    }

    public void set(ListaItens listaItens, char formaPagamento, Funcionario funcionario, LocalDate dataOperacao, Fornecedor fornecedor) {
        super.set(listaItens, formaPagamento, funcionario, dataOperacao);
        this.fornecedor = fornecedor;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public void incrementaIdAtual() {
        idAtual = idAtualCompra;
        idAtualCompra++;
    }

    public static void validaFornecedor(Fornecedor fornecedor) throws IOException {
        if (fornecedor == null) {
            throw new IOException("Insira o fornecedor!");
        }
    }
}
