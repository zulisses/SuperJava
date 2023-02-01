package controller;

import baseClasses.Operacoes.Compra;
import baseClasses.Operacoes.Venda;
import baseClasses.Pessoas.Cliente;
import baseClasses.Pessoas.Fornecedor;
import baseClasses.Pessoas.Funcionario;
import baseClasses.Produtos.Item;
import baseClasses.Produtos.Produto;
import dados.Supermercado;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class RelatoriosController implements Initializable {

    @FXML
    private TableColumn<Funcionario, String> tcFuncionarioCpf;

    @FXML
    private TableColumn<Compra, String> tcCompraFornecedor;

    @FXML
    private TableView<Produto> tvProduto;

    @FXML
    private TableColumn<Funcionario, String> tcFuncionarioNascimento;

    @FXML
    private TableColumn<Cliente, String> tcClienteUf;

    @FXML
    private TableColumn<Funcionario, String> tcFuncionarioBairro;

    @FXML
    private TableColumn<Produto, String> tcProdutoValorCompra;

    @FXML
    private TableColumn<Funcionario, String> tcFuncionarioHoras;

    @FXML
    private TableColumn<Produto, String> tcProdutoId;

    @FXML
    private TableColumn<Venda, String> tcVendaFormaPagamento;

    @FXML
    private TableColumn<Cliente, String> tcClienteNascimento;

    @FXML
    private TableColumn<Cliente, String> tcClienteRua;

    @FXML
    private Tab tEstoque;

    @FXML
    private TableColumn<Produto, String> tcProdutoNome;

    @FXML
    private TableColumn<Cliente, String> tcClienteSexo;

    @FXML
    private TableColumn<Fornecedor, String> tcFornecedorTelefone;

    @FXML
    private TableColumn<Venda, String> tcVendaData;

    @FXML
    private TableView<Funcionario> tvFuncionario;

    @FXML
    private TableColumn<Cliente, String> tcClienteTelefone;

    @FXML
    private Tab tVenda;

    @FXML
    private TableColumn<Item, String> tcEstoqueNome;

    @FXML
    private TableColumn<Fornecedor, String> tcFornecedorrazaoSocial;

    @FXML
    private TableColumn<Fornecedor, String> tcFornecedorUf;

    @FXML
    private TableColumn<Fornecedor, String> tcFornecedorId;

    @FXML
    private TableColumn<Funcionario, String> tcFuncionarioUf;

    @FXML
    private TableColumn<Funcionario, String> tcFuncionarioEmail;

    @FXML
    private TableColumn<Cliente, String> tcClienteNome;

    @FXML
    private TableColumn<Funcionario, String> tcFuncionarioNumero;

    @FXML
    private TableColumn<Item, String> tcEstoqueValor;

    @FXML
    private TableColumn<Funcionario, String> tcFuncionarioId;

    @FXML
    private TableColumn<Compra, String> tcCompraId;

    @FXML
    private TableColumn<Funcionario, String> tcFuncionarioCidade;

    @FXML
    private Tab tProduto;

    @FXML
    private TableColumn<Fornecedor, String> tcFornecedorNomeFantasia;

    @FXML
    private TableColumn<Item, String> tcEstoqueMarca;

    @FXML
    private TableColumn<Venda, String> tcVendaId;

    @FXML
    private TableColumn<Cliente, String> tcClienteNumero;

    @FXML
    private TableColumn<Fornecedor, String> tcFornecedorRamo;

    @FXML
    private TableColumn<Compra, String> tcCompraDesconto;

    @FXML
    private TableColumn<Funcionario, String> tcFuncionarioNome;

    @FXML
    private TableColumn<Fornecedor, String> tcFornecedorCnpj;

    @FXML
    private TableView<Item> tvEstoque;

    @FXML
    private TableColumn<Venda, String> tcVendaCliente;

    @FXML
    private TableColumn<Venda, String> tcVendaFuncionario;

    @FXML
    private TableColumn<Venda, String> tcVendaDesconto;

    @FXML
    private TableColumn<Funcionario, String> tcFuncionarioSexo;

    @FXML
    private TableColumn<Item, String> tcEstoqueId;

    @FXML
    private TableView<Cliente> tvCliente;

    @FXML
    private TableColumn<Cliente, String> tcClienteCidade;

    @FXML
    private TableColumn<Funcionario, String> tcFuncionarioTelefone;

    @FXML
    private TableColumn<Cliente, String> tcClienteLimite;

    @FXML
    private TableColumn<Item, String> tcEstoqueSubTotal;

    @FXML
    private TableColumn<Venda, String> tcVendaValorTotal;

    @FXML
    private TableColumn<Fornecedor, String> tcFornecedorBairro;

    @FXML
    private TableColumn<Funcionario, String> tcFuncionarioSalario;

    @FXML
    private TableColumn<Compra, String> tcCompraFuncionario;

    @FXML
    private TableColumn<Funcionario, String> tcFuncionarioCargo;

    @FXML
    private TableColumn<Item, String> tcEstoqueQuantidade;

    @FXML
    private TableView<Fornecedor> tvFornecedor;

    @FXML
    private TableView<Venda> tvVenda;

    @FXML
    private TableColumn<Cliente, String> tcClienteEmail;

    @FXML
    private TableColumn<Fornecedor, String> tcFornecedorEmail;

    @FXML
    private Tab tCompra;

    @FXML
    private TableColumn<Compra, String> tcCompraFormaPagamento;

    @FXML
    private TableColumn<Compra, String> tcCompraValorTotal;

    @FXML
    private Tab tFornecedor;

    @FXML
    private Tab tCliente;

    @FXML
    private TableColumn<Fornecedor, String> tcFornecedorCidade;

    @FXML
    private TableView<Compra> tvCompra;

    @FXML
    private TableColumn<Produto, String> tcProdutoValorPromocao;

    @FXML
    private Tab tFuncionario;

    @FXML
    private TableColumn<Cliente, String> tcClienteCpf;

    @FXML
    private TableColumn<Cliente, String> tcClienteBairro;

    @FXML
    private TableColumn<Fornecedor, String> tcFornecedorNumero;

    @FXML
    private TableColumn<Produto, String> tcProdutoMarca;

    @FXML
    private TableColumn<Compra, String> tcCompraData;

    @FXML
    private TableColumn<Fornecedor, String> tcFornecedorRua;

    @FXML
    private TableColumn<Produto, String> tcProdutoValorVenda;

    @FXML
    private TableColumn<Cliente, String> tcClienteId;

    @FXML
    private TableColumn<Funcionario, String> tcFuncionarioRua;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inicializaTabelaCliente();
        inicializaTabelaFornecedor();
        inicializaTabelaFuncionario();
        inicializaTabelaProduto();
        inicializaTabelaEstoque();
        inicializaTabelaCompra();
        inicializaTabelaVenda();
    }

    private void inicializaTabelaCliente() {
        tvCliente.refresh();

        tcClienteId.setCellValueFactory(new PropertyValueFactory("id"));
        tcClienteNome.setCellValueFactory(new PropertyValueFactory("nome"));
        tcClienteCpf.setCellValueFactory(new PropertyValueFactory("cpf"));
        tcClienteSexo.setCellValueFactory((param) -> {
            if (param.getValue().getSexo() == 'M') {
                return new SimpleStringProperty("Masculino");
            } else {
                return new SimpleStringProperty("Feminino");
            }
        });
        tcClienteNascimento.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getDataNascimeto().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
        tcClienteLimite.setCellValueFactory((param) -> new SimpleStringProperty(String.format("R$ %.2f", param.getValue().getLimiteCredito())));
        tcClienteEmail.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getContato().getEmail()));
        tcClienteTelefone.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getContato().getTelefone()));
        tcClienteUf.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getEndereco().getUf()));
        tcClienteCidade.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getEndereco().getCidade()));
        tcClienteBairro.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getEndereco().getBairro()));
        tcClienteRua.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getEndereco().getRua()));
        tcClienteNumero.setCellValueFactory((param) -> new SimpleStringProperty(Integer.toString(param.getValue().getEndereco().getNumero())));

        tvCliente.setItems(FXCollections.observableArrayList(Supermercado.clientes));
    }

    private void inicializaTabelaFornecedor() {
        tvFornecedor.refresh();

        tcFornecedorId.setCellValueFactory(new PropertyValueFactory("id"));
        tcFornecedorrazaoSocial.setCellValueFactory(new PropertyValueFactory("razaoSocial"));
        tcFornecedorNomeFantasia.setCellValueFactory(new PropertyValueFactory("nomeFantasia"));
        tcFornecedorCnpj.setCellValueFactory(new PropertyValueFactory("cnpj"));
        tcFornecedorRamo.setCellValueFactory(new PropertyValueFactory("ramoAtividade"));
        tcFornecedorEmail.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getContato().getEmail()));
        tcFornecedorTelefone.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getContato().getTelefone()));
        tcFornecedorUf.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getEndereco().getUf()));
        tcFornecedorCidade.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getEndereco().getCidade()));
        tcFornecedorBairro.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getEndereco().getBairro()));
        tcFornecedorRua.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getEndereco().getRua()));
        tcFornecedorNumero.setCellValueFactory((param) -> new SimpleStringProperty(Integer.toString(param.getValue().getEndereco().getNumero())));

        tvFornecedor.setItems(FXCollections.observableArrayList(Supermercado.fornecedores));
    }

    private void inicializaTabelaFuncionario() {
        tvFuncionario.refresh();

        tcFuncionarioId.setCellValueFactory(new PropertyValueFactory("id"));
        tcFuncionarioNome.setCellValueFactory(new PropertyValueFactory("nome"));
        tcFuncionarioCpf.setCellValueFactory(new PropertyValueFactory("cpf"));
        tcFuncionarioSexo.setCellValueFactory((param) -> {
            if (param.getValue().getSexo() == 'M') {
                return new SimpleStringProperty("Masculino");
            } else {
                return new SimpleStringProperty("Feminino");
            }
        });
        tcFuncionarioNascimento.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getDataNascimeto().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
        tcFuncionarioCargo.setCellValueFactory(new PropertyValueFactory("cargo"));
        tcFuncionarioHoras.setCellValueFactory((param) -> new SimpleStringProperty(Integer.toString(param.getValue().getCargaHoraria())));
        tcFuncionarioSalario.setCellValueFactory((param) -> new SimpleStringProperty(String.format("R$ %.2f", param.getValue().getSalario())));
        tcFuncionarioEmail.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getContato().getEmail()));
        tcFuncionarioTelefone.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getContato().getTelefone()));
        tcFuncionarioUf.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getEndereco().getUf()));
        tcFuncionarioCidade.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getEndereco().getCidade()));
        tcFuncionarioBairro.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getEndereco().getBairro()));
        tcFuncionarioRua.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getEndereco().getRua()));
        tcFuncionarioNumero.setCellValueFactory((param) -> new SimpleStringProperty(Integer.toString(param.getValue().getEndereco().getNumero())));

        tvFuncionario.setItems(FXCollections.observableArrayList(Supermercado.funcionarios));
    }

    private void inicializaTabelaProduto() {
        tvProduto.refresh();

        tcProdutoId.setCellValueFactory(new PropertyValueFactory("id"));
        tcProdutoNome.setCellValueFactory(new PropertyValueFactory("nome"));
        tcProdutoMarca.setCellValueFactory(new PropertyValueFactory("marca"));
        tcProdutoValorCompra.setCellValueFactory((param) -> new SimpleStringProperty(String.format("R$ %.2f", param.getValue().getValorCompra())));
        tcProdutoValorVenda.setCellValueFactory((param) -> new SimpleStringProperty(String.format("R$ %.2f", param.getValue().getValorVenda())));
        tcProdutoValorPromocao.setCellValueFactory((param) -> new SimpleStringProperty(String.format("R$ %.2f", param.getValue().getValorPromocao())));

        tvProduto.setItems(FXCollections.observableArrayList(Supermercado.produtos));
    }

    private void inicializaTabelaEstoque() {
        tvEstoque.refresh();

        tcEstoqueId.setCellValueFactory(new PropertyValueFactory("id"));
        tcEstoqueNome.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getProduto().getNome()));
        tcEstoqueMarca.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getProduto().getMarca()));
        tcEstoqueQuantidade.setCellValueFactory(new PropertyValueFactory("qtd"));
        tcEstoqueValor.setCellValueFactory((param) -> new SimpleStringProperty(String.format("R$ %.2f", param.getValue().getValorUtilizado())));
        tcEstoqueSubTotal.setCellValueFactory((param) -> new SimpleStringProperty(String.format("R$ %.2f", param.getValue().getSubTotal())));

        tvEstoque.setItems(FXCollections.observableArrayList(Supermercado.estoque.getItens()));
    }

    private void inicializaTabelaCompra() {
        tvCompra.refresh();

        tcCompraId.setCellValueFactory(new PropertyValueFactory("id"));
        tcCompraFuncionario.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getFuncionario().getNome()));
        tcCompraFornecedor.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getFornecedor().getNomeFantasia()));
        tcCompraData.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getDataOperacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
        tcCompraFormaPagamento.setCellValueFactory((param) -> {
            switch (param.getValue().getFormaPagamento()) {
                case 'v':
                    return new SimpleStringProperty("Dinheiro");

                case 'p':
                    return new SimpleStringProperty("Prazo");

                case 'c':
                    return new SimpleStringProperty("Credito");

                case 'd':
                    return new SimpleStringProperty("Debito");
                default:
                    return null;
            }
        });
        tcCompraDesconto.setCellValueFactory((param) -> new SimpleStringProperty(String.format("%.2f", param.getValue().getPorcentagemDesconto())));
        tcCompraValorTotal.setCellValueFactory((param) -> new SimpleStringProperty(String.format("R$ %.2f", param.getValue().getValorTotal())));

        tvCompra.setItems(FXCollections.observableArrayList(Supermercado.compras));
    }

    private void inicializaTabelaVenda() {
        tvVenda.refresh();

        tcVendaId.setCellValueFactory(new PropertyValueFactory("id"));
        tcVendaFuncionario.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getFuncionario().getNome()));
        tcVendaCliente.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getCliente().getNome()));
        tcVendaData.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getDataOperacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
        tcVendaFormaPagamento.setCellValueFactory((param) -> {
            switch (param.getValue().getFormaPagamento()) {
                case 'v':
                    return new SimpleStringProperty("Dinheiro");

                case 'p':
                    return new SimpleStringProperty("Prazo");

                case 'c':
                    return new SimpleStringProperty("Credito");

                case 'd':
                    return new SimpleStringProperty("Debito");
                default:
                    return null;
            }
        });
        tcVendaDesconto.setCellValueFactory((param) -> new SimpleStringProperty(String.format("%.2f", param.getValue().getPorcentagemDesconto())));
        tcVendaValorTotal.setCellValueFactory((param) -> new SimpleStringProperty(String.format("R$ %.2f", param.getValue().getValorTotal())));

        tvVenda.setItems(FXCollections.observableArrayList(Supermercado.vendas));
    }
}
