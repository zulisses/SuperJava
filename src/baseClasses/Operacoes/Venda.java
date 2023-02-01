package baseClasses.Operacoes;

import baseClasses.Pessoas.Cliente;
import baseClasses.Pessoas.Funcionario;
import baseClasses.Produtos.ListaItens;
import java.io.IOException;
import java.time.LocalDate;

public class Venda extends Operacao {

    private Cliente cliente;
    private static int idAtualVenda = 1;

    public Venda() {
        super();
    }

    public Venda(ListaItens listaItens, char formaPagamento, Funcionario funcionario, LocalDate dataOperacao, Cliente cliente) {
        super(listaItens, formaPagamento, funcionario, dataOperacao);
        this.cliente = cliente;
    }

    public void set(ListaItens listaItens, char formaPagamento, Funcionario funcionario, LocalDate dataOperacao, Cliente cliente) {
        super.set(listaItens, formaPagamento, funcionario, dataOperacao);
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public void incrementaIdAtual() {
        idAtual = idAtualVenda;
        idAtualVenda++;
    }

    public static void validaCliente(Cliente cliente) throws IOException {
        if (cliente == null) {
            throw new IOException("Insira o cliente!");
        }
    }
}
