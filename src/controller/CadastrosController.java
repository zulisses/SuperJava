package controller;

import baseClasses.Contato;
import baseClasses.Endereco;
import baseClasses.Pessoas.Cliente;
import baseClasses.Pessoas.Fornecedor;
import baseClasses.Pessoas.Funcionario;
import baseClasses.Produtos.Produto;
import dados.Supermercado;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CadastrosController implements Initializable {

    private static final ArrayList<String> ufs = new ArrayList<>(Arrays.asList("AC", "AL", "AP", "AM", "BA", "CE",
            "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS",
            "RO", "RR", "SC", "SP", "SE", "TO"));

    private Cliente cliente;
    private Fornecedor fornecedor;
    private Funcionario funcionario;
    private Produto produto;
    private boolean novoOuEditar; //true - novo / false - editar

    @FXML
    private TextField tfProdutoNome;

    @FXML
    private TextField tfFuncionarioNome;

    @FXML
    private TextField tfClienteTelefone;

    @FXML
    private TextField tfFornecedorEmail;

    @FXML
    private AnchorPane apClientePessoaFisica;

    @FXML
    private TextField tfFornecedorId;

    @FXML
    private ToggleGroup tgFuncionarioSexo;

    @FXML
    private AnchorPane apFornecedorId;

    @FXML
    private TextField tfFuncionarioTelefone;

    @FXML
    private ComboBox<String> cbClienteUf;

    @FXML
    private TextField tfProdutoId;

    @FXML
    private TextField tfFornecedorNomeFantasia;

    @FXML
    private TextField tfFuncionarioSalario;

    @FXML
    private RadioButton rbFuncionarioSexoMasculino;

    @FXML
    private AnchorPane apProdutosValores;

    @FXML
    private AnchorPane apFuncionarioOutros;

    @FXML
    private AnchorPane apProdutoId;

    @FXML
    private TextField tfClienteBairro;

    @FXML
    private TextField tfClienteNome;

    @FXML
    private TextField tfFuncionarioEmail;

    @FXML
    private Button bClienteSair;

    @FXML
    private AnchorPane apClienteOutros;

    @FXML
    private TextField tfClienteRua;

    @FXML
    private DatePicker dpClienteDataNascimento;

    @FXML
    private Button bFornecedorSair;

    @FXML
    private AnchorPane apFuncionarioId;

    @FXML
    private Button bFornecedorNovo;

    @FXML
    private RadioButton rbFuncionarioSexoFeminino;

    @FXML
    private TextField tfProdutoValorPromocao;

    @FXML
    private AnchorPane apClienteEndereco;

    @FXML
    private DatePicker dpFuncionarioDataNascimento;

    @FXML
    private AnchorPane apFornecedorPessoaJuridica;

    @FXML
    private TextField tfFuncionarioRua;

    @FXML
    private Button bProdutoNovo;

    @FXML
    private Tab tProduto;

    @FXML
    private TextField tfFornecedorTelefone;

    @FXML
    private Button bProdutoEditar;

    @FXML
    private Button bFuncionarioSalvar;

    @FXML
    private TextField tfClienteCidade;

    @FXML
    private Button bClienteLimpar;

    @FXML
    private Button bClienteEditar;

    @FXML
    private Button bProdutoLimpar;

    @FXML
    private TextField tfClienteNumero;

    @FXML
    private Button bFuncionarioSair;

    @FXML
    private Button bFuncionarioLimpar;

    @FXML
    private TextField tfClienteLimiteCredito;

    @FXML
    private TextField tfClienteId;

    @FXML
    private Button bClienteSalvar;

    @FXML
    private ComboBox<String> cbFuncionarioUf;

    @FXML
    private Button bProdutoSalvar;

    @FXML
    private RadioButton rbClienteSexoFeminino;

    @FXML
    private AnchorPane apProdutosInformacoes;

    @FXML
    private TextField tfFuncionarioCidade;

    @FXML
    private TextField tfFuncionarioNumero;

    @FXML
    private TextField tfProdutoValorCompra;

    @FXML
    private Button bClienteNovo;

    @FXML
    private AnchorPane apFornecedorEndereco;

    @FXML
    private AnchorPane apFuncionarioEndereco;

    @FXML
    private Button bFuncionarioEditar;

    @FXML
    private TextField tfFornecedorRazaoSocial;

    @FXML
    private TextField tfFuncionarioCpf;

    @FXML
    private AnchorPane apFornecedorContato;

    @FXML
    private TextField tfFornecedorBairro;

    @FXML
    private AnchorPane apFornecedorOutros;

    @FXML
    private TextField tfFornecedorRamoAtividade;

    @FXML
    private Tab tfuncionario;

    @FXML
    private AnchorPane apFuncionarioContato;

    @FXML
    private TextField tfFuncionarioCargo;

    @FXML
    private TextField tfFuncionarioCargaHoraria;

    @FXML
    private AnchorPane apClienteContato;

    @FXML
    private ToggleGroup tgClienteSexo;

    @FXML
    private TextField tfFornecedorCnpj;

    @FXML
    private ComboBox<String> cbFornecedorUf;

    @FXML
    private TextField tfFuncionarioBairro;

    @FXML
    private TextField tfProdutoMarca;

    @FXML
    private Tab tFornecedor;

    @FXML
    private Tab tCliente;

    @FXML
    private RadioButton rbClienteSexoMasculino;

    @FXML
    private TextField tfClienteEmail;

    @FXML
    private TextField tfFornecedorRua;

    @FXML
    private AnchorPane apFuncionarioPessoaFisica;

    @FXML
    private TextField tfProdutoValorVenda;

    @FXML
    private TextField tfFornecedorNumero;

    @FXML
    private Button bFornecedorEditar;

    @FXML
    private Button bProdutoSair;

    @FXML
    private TextField tfFornecedorCidade;

    @FXML
    private Button bFornecedorLimpar;

    @FXML
    private Button bFuncionarioNovo;

    @FXML
    private AnchorPane apClienteId;

    @FXML
    private TextField tfClienteCpf;

    @FXML
    private Button bFornecedorSalvar;

    @FXML
    private Button bFuncionarioCancelar;

    @FXML
    private Button bProdutoCancelar;

    @FXML
    private Button bFornecedorCancelar;

    @FXML
    private Button bClienteCancelar;

    @FXML
    private TextField tfFuncionarioId;

    @FXML
    private Button bClienteExcluir;

    @FXML
    private Button bFornecedorExcluir;

    @FXML
    private Button bFuncionarioExcluir;

    @FXML
    private Button bProdutoExcluir;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inicializaComboBox();
    }

    @FXML
    void clienteNovo(ActionEvent event) {
        if (cliente == null) {
            cliente = new Cliente();
        }
        tfClienteId.setText(Integer.toString(cliente.getId()));
        desbloquearCamposCliente(true);
        novoOuEditar = true;
    }

    @FXML
    void clienteEditar(ActionEvent event) {
        cliente = inputCliente();
        if (cliente == null) {
            return;
        }

        mostraCamposCliente();
        desbloquearCamposCliente(true);
        bClienteExcluir.setDisable(false);
        novoOuEditar = false;
    }

    @FXML
    void clienteLimpar(ActionEvent event) {
        ArrayList<AnchorPane> aux = new ArrayList<>(Arrays.asList(apClienteContato, apClienteEndereco, apClientePessoaFisica, apClienteOutros));
        limparCampos(aux);
    }

    @FXML
    void clienteCancelar(ActionEvent event) {
        desbloquearCamposCliente(false);
        ArrayList<AnchorPane> aux = new ArrayList<>(Arrays.asList(apClienteId, apClienteContato, apClienteEndereco, apClientePessoaFisica, apClienteOutros));
        limparCampos(aux);
    }

    @FXML
    void clienteSalvar(ActionEvent event) {
        try {
            verificaESetCamposCliente();

            if (novoOuEditar) {
                Supermercado.clientes.add(cliente);
            } else {
                for (int i = 0; i < Supermercado.clientes.size(); i++) {
                    if (cliente.equals(Supermercado.clientes.get(i))) {
                        Supermercado.clientes.get(i).set(cliente);
                    }
                }
            }
            cliente = null;
            this.clienteCancelar(event);
            geraMensagemSucesso("Cliente salvo com sucesso!");
        } catch (IOException e) {
            geraMensagemAlerta(e.getMessage());
        }
    }

    @FXML
    void clienteExcluir(ActionEvent event) {
        clienteCancelar(event);

        Supermercado.clientes.remove(cliente);
    }

    @FXML
    void fornecedorNovo(ActionEvent event) {
        if (fornecedor == null) {
            fornecedor = new Fornecedor();
        }
        tfFornecedorId.setText(Integer.toString(fornecedor.getId()));
        desbloquearCamposFornecedor(true);
        novoOuEditar = true;
    }

    @FXML
    void fornecedorEditar(ActionEvent event) {
        fornecedor = inputFornecedor();
        if (fornecedor == null) {
            return;
        }

        mostraCamposFornecedor();
        desbloquearCamposFornecedor(true);
        bFornecedorExcluir.setDisable(false);
        novoOuEditar = false;

    }

    @FXML
    void fornecedorLimpar(ActionEvent event) {
        ArrayList<AnchorPane> aux = new ArrayList<>(Arrays.asList(apFornecedorContato, apFornecedorEndereco, apFornecedorPessoaJuridica, apFornecedorOutros));
        limparCampos(aux);
    }

    @FXML
    void fornecedorCancelar(ActionEvent event) {
        desbloquearCamposFornecedor(false);
        ArrayList<AnchorPane> aux = new ArrayList<>(Arrays.asList(apFornecedorId, apFornecedorContato, apFornecedorEndereco, apFornecedorPessoaJuridica, apFornecedorOutros));
        limparCampos(aux);
    }

    @FXML
    void fornecedorSalvar(ActionEvent event) {
        try {
            verificaESerCamposFornecedor();

            if (novoOuEditar) {
                Supermercado.fornecedores.add(fornecedor);
            } else {
                for (int i = 0; i < Supermercado.fornecedores.size(); i++) {
                    if (fornecedor.equals(Supermercado.fornecedores.get(i))) {
                        Supermercado.fornecedores.get(i).set(fornecedor);
                    }
                }
            }
            geraMensagemSucesso("Fornecedor salvo com sucesso!");

            fornecedor = null;
            this.fornecedorCancelar(event);
        } catch (IOException e) {
            geraMensagemAlerta(e.getMessage());
        }
    }

    @FXML
    void fornecedorExcluir(ActionEvent event) {
        fornecedorCancelar(event);

        Supermercado.fornecedores.remove(fornecedor);
    }

    @FXML
    void funcionarioNovo(ActionEvent event) {
        if (funcionario == null) {
            funcionario = new Funcionario();
        }
        tfFuncionarioId.setText(Integer.toString(funcionario.getId()));
        desbloquearCamposFuncionario(true);
        novoOuEditar = true;
    }

    @FXML
    void funcionarioEditar(ActionEvent event) {
        funcionario = inputFuncionario();
        if (funcionario == null) {
            return;
        }

        mostraCamposFuncionario();
        desbloquearCamposFuncionario(true);
        bFuncionarioExcluir.setDisable(false);
        novoOuEditar = false;
    }

    @FXML
    void funcionarioLimpar(ActionEvent event) {
        ArrayList<AnchorPane> aux = new ArrayList<>(Arrays.asList(apFuncionarioContato, apFuncionarioEndereco, apFuncionarioPessoaFisica, apFuncionarioOutros));
        limparCampos(aux);
    }

    @FXML
    void funcionarioCancelar(ActionEvent event) {
        desbloquearCamposFuncionario(false);
        ArrayList<AnchorPane> aux = new ArrayList<>(Arrays.asList(apFuncionarioId, apFuncionarioContato, apFuncionarioEndereco, apFuncionarioPessoaFisica, apFuncionarioOutros));
        limparCampos(aux);
    }

    @FXML
    void funcionarioSalvar(ActionEvent event) {
        try {
            verificaESetCamposFuncionario();
            if (novoOuEditar) {
                Supermercado.funcionarios.add(funcionario);
            } else {
                for (int i = 0; i < Supermercado.funcionarios.size(); i++) {
                    if (funcionario.equals(Supermercado.funcionarios.get(i))) {
                        Supermercado.funcionarios.get(i).set(funcionario);
                    }
                }

            }
            geraMensagemSucesso("Funcionario salvo com sucesso!");

            funcionario = null;
            this.funcionarioCancelar(event);
        } catch (IOException e) {
            geraMensagemAlerta(e.getMessage());
        }
    }

    @FXML
    void funcionarioExcluir(ActionEvent event) {
        funcionarioCancelar(event);

        Supermercado.funcionarios.remove(funcionario);
    }

    @FXML
    void produtoNovo(ActionEvent event) {
        if (produto == null) {
            produto = new Produto();
        }
        tfProdutoId.setText(Integer.toString(produto.getId()));
        desbloquearCamposProdutos(true);
        novoOuEditar = true;
    }

    @FXML
    void produtoEditar(ActionEvent event) {
        produto = inputProduto();
        if (produto == null) {
            return;
        }

        Supermercado.estoque.addProduto(produto);
        mostraCamposProduto();
        desbloquearCamposProdutos(true);
        bProdutoExcluir.setDisable(false);
        novoOuEditar = false;
    }

    @FXML
    void produtoLimpar(ActionEvent event) {
        ArrayList<AnchorPane> aux = new ArrayList<>(Arrays.asList(apProdutosInformacoes, apProdutosValores));
        limparCampos(aux);
    }

    @FXML
    void produtoCancelar(ActionEvent event) {
        desbloquearCamposProdutos(false);
        ArrayList<AnchorPane> aux = new ArrayList<>(Arrays.asList(apProdutoId, apProdutosInformacoes, apProdutosValores));
        limparCampos(aux);
    }

    @FXML
    void produtoSalvar(ActionEvent event) {
        try {
            verificaESetCamposProduto();
            if (novoOuEditar) {
                Supermercado.produtos.add(produto);
            } else {
                for (int i = 0; i < Supermercado.produtos.size(); i++) {
                    if (produto.equals(Supermercado.produtos.get(i))) {
                        Supermercado.produtos.get(i).set(produto);
                    }
                }
            }
            Supermercado.estoque.addProduto(produto);

            produto = null;
            this.produtoCancelar(event);
            geraMensagemSucesso("Produto salvo com sucesso!");
        } catch (IOException e) {
            geraMensagemAlerta(e.getMessage());
        }
    }

    @FXML
    void produtoExcluir(ActionEvent event) {
        produtoCancelar(event);

        Supermercado.produtos.remove(produto);
        Supermercado.estoque.removeProduto(produto);
    }

    @FXML
    void sair(ActionEvent event) {
        Stage stage = (Stage) bClienteSair.getScene().getWindow();
        stage.close();
    }

    private void inicializaComboBox() {
        cbClienteUf.setItems(FXCollections.observableArrayList(ufs));
        cbFornecedorUf.setItems(FXCollections.observableArrayList(ufs));
        cbFuncionarioUf.setItems(FXCollections.observableArrayList(ufs));
    }

    private void desbloquearCamposCliente(boolean desbloquear) {
        ArrayList<AnchorPane> aux = new ArrayList<>(Arrays.asList(apClienteContato, apClienteEndereco, apClientePessoaFisica, apClienteOutros));
        desbloquearCampos(aux, !desbloquear);
        bClienteCancelar.setDisable(!desbloquear);
        bClienteEditar.setDisable(desbloquear);
        bClienteLimpar.setDisable(!desbloquear);
        bClienteNovo.setDisable(desbloquear);
        bClienteSalvar.setDisable(!desbloquear);
        bClienteExcluir.setDisable(true);

        tFornecedor.setDisable(desbloquear);
        tfuncionario.setDisable(desbloquear);
        tProduto.setDisable(desbloquear);
    }

    private void desbloquearCamposFornecedor(boolean desbloquear) {
        ArrayList<AnchorPane> aux = new ArrayList<>(Arrays.asList(apFornecedorContato, apFornecedorEndereco, apFornecedorPessoaJuridica, apFornecedorOutros));
        desbloquearCampos(aux, !desbloquear);
        bFornecedorCancelar.setDisable(!desbloquear);
        bFornecedorEditar.setDisable(desbloquear);
        bFornecedorLimpar.setDisable(!desbloquear);
        bFornecedorNovo.setDisable(desbloquear);
        bFornecedorSalvar.setDisable(!desbloquear);
        bFornecedorExcluir.setDisable(true);

        tCliente.setDisable(desbloquear);
        tfuncionario.setDisable(desbloquear);
        tProduto.setDisable(desbloquear);
    }

    private void desbloquearCamposFuncionario(boolean desbloquear) {
        ArrayList<AnchorPane> aux = new ArrayList<>(Arrays.asList(apFuncionarioContato, apFuncionarioEndereco, apFuncionarioPessoaFisica, apFuncionarioOutros));
        desbloquearCampos(aux, !desbloquear);
        bFuncionarioCancelar.setDisable(!desbloquear);
        bFuncionarioEditar.setDisable(desbloquear);
        bFuncionarioLimpar.setDisable(!desbloquear);
        bFuncionarioNovo.setDisable(desbloquear);
        bFuncionarioSalvar.setDisable(!desbloquear);
        bFuncionarioExcluir.setDisable(true);

        tCliente.setDisable(desbloquear);
        tFornecedor.setDisable(desbloquear);
        tProduto.setDisable(desbloquear);
    }

    private void desbloquearCamposProdutos(boolean desbloquear) {
        ArrayList<AnchorPane> aux = new ArrayList<>(Arrays.asList(apProdutosInformacoes, apProdutosValores));
        desbloquearCampos(aux, !desbloquear);
        bProdutoCancelar.setDisable(!desbloquear);
        bProdutoEditar.setDisable(desbloquear);
        bProdutoLimpar.setDisable(!desbloquear);
        bProdutoNovo.setDisable(desbloquear);
        bProdutoSalvar.setDisable(!desbloquear);
        bProdutoExcluir.setDisable(true);

        tCliente.setDisable(desbloquear);
        tFornecedor.setDisable(desbloquear);
        tfuncionario.setDisable(desbloquear);
    }

    private void limparCampos(ArrayList<AnchorPane> list) {
        for (AnchorPane ap : list) {
            ObservableList<Node> aux = ap.getChildren();
            for (Node n : aux) {
                if (n instanceof TextField) {
                    ((TextField) n).setText("");
                } else if (n instanceof ComboBox) {
                    ((ComboBox) n).getSelectionModel().clearSelection();
                } else if (n instanceof DatePicker) {
                    ((DatePicker) n).setValue(null);
                } else if (n instanceof RadioButton) {
                    ((RadioButton) n).setSelected(false);
                }
            }
        }
    }

    private void desbloquearCampos(ArrayList<AnchorPane> list, boolean desbloqueado) {
        for (AnchorPane ap : list) {
            ObservableList<Node> aux = ap.getChildren();
            for (Node n : aux) {
                n.setDisable(desbloqueado);
            }
        }
    }

    private void verificaESetCamposCliente() throws IOException {
        String email = Contato.validaEmail(tfClienteEmail.getText());
        String telefone = Contato.validaTelefone(tfClienteTelefone.getText());
        String ufAux = cbClienteUf.getSelectionModel().getSelectedItem();
        if (ufAux == null) {
            ufAux = "";
        }
        String uf = Endereco.validaUf(ufAux);
        String cidade = Endereco.validaCidade(tfClienteCidade.getText());
        String bairro = Endereco.validaBairro(tfClienteBairro.getText());
        int numero = Endereco.validaNumero(tfClienteNumero.getText());
        String rua = Endereco.validaRua(tfClienteRua.getText());
        String nome = Cliente.validaNome(tfClienteNome.getText());
        String aux = "";
        if (rbClienteSexoMasculino.isSelected()) {
            aux = "M";
        } else if (rbClienteSexoFeminino.isSelected()) {
            aux = "F";
        }
        char sexo = Cliente.validaSexo(aux);
        String cpf = Cliente.validaCpf(tfClienteCpf.getText());
        LocalDate dataNascimento = Cliente.validaDataNascimento(dpClienteDataNascimento.getValue());
        double limiteCredito = Cliente.validaLimiteCredito(tfClienteLimiteCredito.getText());

        cliente.set(new Endereco(uf, cidade, bairro, rua, numero), new Contato(email, telefone), nome, cpf, dataNascimento, sexo, limiteCredito);
    }

    private void verificaESerCamposFornecedor() throws IOException {
        String email = Contato.validaEmail(tfFornecedorEmail.getText());
        String telefone = Contato.validaTelefone(tfFornecedorTelefone.getText());
        String ufAux = cbFornecedorUf.getSelectionModel().getSelectedItem();
        if (ufAux == null) {
            ufAux = "";
        }
        String uf = Endereco.validaUf(ufAux);
        String cidade = Endereco.validaCidade(tfFornecedorCidade.getText());
        String bairro = Endereco.validaBairro(tfFornecedorBairro.getText());
        int numero = Endereco.validaNumero(tfFornecedorNumero.getText());
        String rua = Endereco.validaRua(tfFornecedorRua.getText());
        String razaoSocial = Fornecedor.validaRazaoSocial(tfFornecedorRazaoSocial.getText());
        String cnpj = Fornecedor.validaCpf(tfFornecedorCnpj.getText());
        String nomeFantasia = Fornecedor.validaNomeFantasia(tfFornecedorNomeFantasia.getText());
        String RamoAtividade = Fornecedor.validaRamoAtividade(tfFornecedorRamoAtividade.getText());

        fornecedor.set(new Endereco(uf, cidade, bairro, rua, numero), new Contato(email, telefone), razaoSocial, nomeFantasia, cnpj, RamoAtividade);
    }

    private void verificaESetCamposFuncionario() throws IOException {
        String email = Contato.validaEmail(tfFuncionarioEmail.getText());
        String telefone = Contato.validaTelefone(tfFuncionarioTelefone.getText());
        String ufAux = cbFuncionarioUf.getSelectionModel().getSelectedItem();
        if (ufAux == null) {
            ufAux = "";
        }
        String uf = Endereco.validaUf(ufAux);
        String cidade = Endereco.validaCidade(tfFuncionarioCidade.getText());
        String bairro = Endereco.validaBairro(tfFuncionarioBairro.getText());
        int numero = Endereco.validaNumero(tfFuncionarioNumero.getText());
        String rua = Endereco.validaRua(tfFuncionarioRua.getText());
        String nome = Funcionario.validaNome(tfFuncionarioNome.getText());
        String aux = "";
        if (rbFuncionarioSexoMasculino.isSelected()) {
            aux = "M";
        } else if (rbFuncionarioSexoFeminino.isSelected()) {
            aux = "F";
        }
        char sexo = Funcionario.validaSexo(aux);
        String cpf = Funcionario.validaCpf(tfFuncionarioCpf.getText());
        LocalDate dataNascimento = Funcionario.validaDataNascimento(dpFuncionarioDataNascimento.getValue());
        String cargo = Funcionario.validaCargo(tfFuncionarioCargo.getText());
        double cargaHoraria = Funcionario.validaCargaHoraria(tfFuncionarioCargaHoraria.getText());
        double salario = Funcionario.validaSalario(tfFuncionarioSalario.getText());

        funcionario.set(new Endereco(uf, cidade, bairro, rua, numero), new Contato(email, telefone), nome, cpf, dataNascimento, sexo, cargo, numero, salario);
    }

    private void verificaESetCamposProduto() throws IOException {
        String nome = Produto.validaNome(tfProdutoNome.getText());
        String marca = Produto.validaMarca(tfProdutoMarca.getText());
        double valorCompra = Produto.validaValorCompra(tfProdutoValorCompra.getText());
        double valorVenda = Produto.validaValorVenda(tfProdutoValorVenda.getText());
        double valorPromocao = Produto.validaValorPromocao(tfProdutoValorPromocao.getText());

        produto.set(nome, marca, valorCompra, valorVenda, valorPromocao);

    }

    private void mostraCamposCliente() {
        tfClienteId.setText(Integer.toString(cliente.getId()));
        tfClienteEmail.setText(cliente.getContato().getEmail());
        tfClienteTelefone.setText(cliente.getContato().getTelefone());
        cbClienteUf.getSelectionModel().select(cliente.getEndereco().getUf());
        tfClienteCidade.setText(cliente.getEndereco().getCidade());
        tfClienteBairro.setText(cliente.getEndereco().getBairro());
        tfClienteNumero.setText(Integer.toString(cliente.getEndereco().getNumero()));
        tfClienteRua.setText(cliente.getEndereco().getRua());
        tfClienteNome.setText(cliente.getNome());

        if (cliente.getSexo() == 'M') {
            rbClienteSexoMasculino.setSelected(true);
            rbClienteSexoFeminino.setSelected(false);
        } else {
            rbClienteSexoMasculino.setSelected(false);
            rbClienteSexoFeminino.setSelected(true);
        }

        tfClienteCpf.setText(cliente.getCpf());
        dpClienteDataNascimento.setValue(cliente.getDataNascimeto());
        tfClienteLimiteCredito.setText(Double.toString(cliente.getLimiteCredito()));
    }

    private void mostraCamposFornecedor() {
        tfFornecedorId.setText(Integer.toString(fornecedor.getId()));
        tfFornecedorEmail.setText(fornecedor.getContato().getEmail());
        tfFornecedorTelefone.setText(fornecedor.getContato().getTelefone());
        cbFornecedorUf.getSelectionModel().select(fornecedor.getEndereco().getUf());
        tfFornecedorCidade.setText(fornecedor.getEndereco().getCidade());
        tfFornecedorBairro.setText(fornecedor.getEndereco().getBairro());
        tfFornecedorNumero.setText(Integer.toString(fornecedor.getEndereco().getNumero()));
        tfFornecedorRua.setText(fornecedor.getEndereco().getRua());
        tfFornecedorRazaoSocial.setText(fornecedor.getRazaoSocial());
        tfFornecedorCnpj.setText(fornecedor.getCnpj());
        tfFornecedorNomeFantasia.setText(fornecedor.getNomeFantasia());
        tfFornecedorRamoAtividade.setText(fornecedor.getRamoAtividade());
    }

    private void mostraCamposFuncionario() {
        tfFuncionarioId.setText(Integer.toString(funcionario.getId()));
        tfFuncionarioEmail.setText(funcionario.getContato().getEmail());
        tfFuncionarioTelefone.setText(funcionario.getContato().getTelefone());
        cbFuncionarioUf.getSelectionModel().select(funcionario.getEndereco().getUf());
        tfFuncionarioCidade.setText(funcionario.getEndereco().getCidade());
        tfFuncionarioBairro.setText(funcionario.getEndereco().getBairro());
        tfFuncionarioNumero.setText(Integer.toString(funcionario.getEndereco().getNumero()));
        tfFuncionarioRua.setText(funcionario.getEndereco().getRua());
        tfFuncionarioNome.setText(funcionario.getNome());

        if (funcionario.getSexo() == 'M') {
            rbFuncionarioSexoMasculino.setSelected(true);
            rbFuncionarioSexoFeminino.setSelected(false);
        } else {
            rbFuncionarioSexoMasculino.setSelected(false);
            rbFuncionarioSexoFeminino.setSelected(true);
        }

        tfFuncionarioCpf.setText(funcionario.getCpf());
        dpFuncionarioDataNascimento.setValue(funcionario.getDataNascimeto());
        tfFuncionarioCargo.setText(funcionario.getCargo());
        tfFuncionarioCargaHoraria.setText(Integer.toString(funcionario.getCargaHoraria()));
        tfFuncionarioSalario.setText(Double.toString(funcionario.getSalario()));
    }

    private void mostraCamposProduto() {
        tfProdutoId.setText(Integer.toString(produto.getId()));
        tfProdutoNome.setText(produto.getNome());
        tfProdutoMarca.setText(produto.getMarca());
        tfProdutoValorCompra.setText(Double.toString(produto.getValorCompra()));
        tfProdutoValorVenda.setText(Double.toString(produto.getValorVenda()));
        tfProdutoValorPromocao.setText(Double.toString(produto.getValorPromocao()));
    }

    private void geraMensagemAlerta(String mensagem) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);

        alerta.setTitle("Error");
        alerta.setHeaderText("Relatorio: ");
        alerta.setContentText(mensagem);

        ButtonType okButton = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        alerta.getButtonTypes().setAll(okButton);

        alerta.initModality(Modality.APPLICATION_MODAL);

        alerta.showAndWait();
    }

    private void geraMensagemSucesso(String mensagem) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);

        alerta.setTitle("Informação");
        alerta.setHeaderText("Sucesso");
        alerta.setContentText(mensagem);

        ButtonType okButton = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        alerta.getButtonTypes().setAll(okButton);

        alerta.initModality(Modality.APPLICATION_MODAL);

        alerta.showAndWait();
    }

    private Cliente inputCliente() {
        Cliente cliente = null;

        ArrayList<String> aux = new ArrayList<>();
        Supermercado.clientes.forEach((c) -> aux.add(c.getNome()));

        ChoiceDialog<String> dialog = new ChoiceDialog<>("", aux);
        dialog.setTitle("Cliente");
        dialog.setContentText("Selecione o nome do cliente:");

        Optional<String> result = dialog.showAndWait();

        if (result.isPresent()) {
            try {
                cliente = (Cliente) Supermercado.where("cliente", "nome", result.get());
                if (cliente == null) {
                    throw new IOException();
                }
            } catch (IOException e) {
                return inputCliente();
            }
        }

        return cliente;
    }

    private Fornecedor inputFornecedor() {
        Fornecedor fornecedor = null;

        ArrayList<String> aux = new ArrayList<>();
        Supermercado.fornecedores.forEach((c) -> aux.add(c.getNomeFantasia()));

        ChoiceDialog<String> dialog = new ChoiceDialog<>("", aux);
        dialog.setTitle("Fornecedor");
        dialog.setContentText("Selecione a razão social do fornecedor:");

        Optional<String> result = dialog.showAndWait();

        if (result.isPresent()) {
            try {
                fornecedor = (Fornecedor) Supermercado.where("fornecedor", "nome fantasia", result.get());
                if (fornecedor == null) {
                    throw new IOException();
                }
            } catch (IOException e) {
                return inputFornecedor();
            }
        }

        return fornecedor;
    }

    private Funcionario inputFuncionario() {
        Funcionario funcionario = null;

        ArrayList<String> aux = new ArrayList<>();
        Supermercado.funcionarios.forEach((c) -> aux.add(c.getNome()));

        ChoiceDialog<String> dialog = new ChoiceDialog<>("", aux);
        dialog.setTitle("Funcionario");
        dialog.setContentText("Selecione o nome do funcionario:");

        Optional<String> result = dialog.showAndWait();

        if (result.isPresent()) {
            try {
                funcionario = (Funcionario) Supermercado.where("funcionario", "nome", result.get());
                if (funcionario == null) {
                    throw new IOException();
                }
            } catch (IOException e) {
                return inputFuncionario();
            }
        }

        return funcionario;
    }

    private Produto inputProduto() {
        Produto produto = null;

        ArrayList<String> aux = new ArrayList<>();
        Supermercado.produtos.forEach((c) -> aux.add(c.getNome()));

        ChoiceDialog<String> dialog = new ChoiceDialog<>("", aux);
        dialog.setTitle("Produto");
        dialog.setContentText("Selecione o nome do produto:");

        Optional<String> result = dialog.showAndWait();

        if (result.isPresent()) {
            try {
                produto = (Produto) Supermercado.where("produto", "nome", result.get());
                if (produto == null) {
                    throw new IOException();
                }
            } catch (IOException e) {
                return inputProduto();
            }
        }

        return produto;
    }
}
