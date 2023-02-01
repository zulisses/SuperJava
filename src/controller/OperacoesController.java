package controller;

import baseClasses.Operacoes.Compra;
import baseClasses.Operacoes.Venda;
import baseClasses.Pessoas.Cliente;
import baseClasses.Pessoas.Fornecedor;
import baseClasses.Pessoas.Funcionario;
import baseClasses.Produtos.Item;
import baseClasses.Produtos.ListaItens;
import baseClasses.Produtos.Produto;
import dados.Supermercado;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class OperacoesController implements Initializable {

    private Funcionario funcionarioCompra;
    private Funcionario funcionarioVenda;
    private Fornecedor fornecedorCompra;
    private Cliente clienteVenda;
    private ListaItens listaCompra;
    private ListaItens listaVenda;
    private Compra compra;
    private Venda venda;

    @FXML
    private Button bVendaInformacoesCancelar;

    @FXML
    private Button bCompraInformacoesCancelar;

    @FXML
    private Button bVendaCancelar;

    @FXML
    private TableView<Item> tvVendaItens;

    @FXML
    private Button bCompraSair;

    @FXML
    private ComboBox<String> cbVendaCliente;

    @FXML
    private TableColumn<Item, String> tcCompraMarca;

    @FXML
    private AnchorPane apVendaControle;

    @FXML
    private AnchorPane apCompraInformacoes;

    @FXML
    private AnchorPane apCompraListaItens;

    @FXML
    private TableColumn<Item, String> tcVendaNome;

    @FXML
    private Tab tVenda;

    @FXML
    private TableColumn<Item, String> tcCompraValor;

    @FXML
    private Button bVendaFinalizarVenda;

    @FXML
    private Button bCompraSalvar;

    @FXML
    private Button bCompraExcluir;

    @FXML
    private Button bCompraIniciarCompra;

    @FXML
    private Button bCompraEditar;

    @FXML
    private TableColumn<Item, String> tcCompraId;

    @FXML
    private AnchorPane apVendaInformacoes;

    @FXML
    private ComboBox<String> cbVendaFuncionario;

    @FXML
    private AnchorPane apVenda;

    @FXML
    private AnchorPane apVendaValorTotal;

    @FXML
    private Button bVendaEditar;

    @FXML
    private TableColumn<Item, String> tcVendaValor;

    @FXML
    private TableColumn<Item, String> tcVendaId;

    @FXML
    private Button bVendaExcluir;

    @FXML
    private Button bVendaSair;

    @FXML
    private TableColumn<Item, String> tcVendaMarca;

    @FXML
    private ComboBox<String> cbCompraFornecedor;

    @FXML
    private Button bCompraNovoItem;

    @FXML
    private AnchorPane apCompra;

    @FXML
    private TableColumn<Item, String> tcCompraQuantidade;

    @FXML
    private AnchorPane apVendaListaItens;

    @FXML
    private Button bVendaNovoItem;

    @FXML
    private TableColumn<Item, String> tcVendaQuantidade;

    @FXML
    private Button bVendaIniciarVenda;

    @FXML
    private CheckBox cbVendaAplicaPromocao;

    @FXML
    private AnchorPane apCompraControle;

    @FXML
    private Button bCompraFinalizarCompra;

    @FXML
    private Tab tCompra;

    @FXML
    private TextField tfVendaValorTotal;

    @FXML
    private ComboBox<String> cbCompraFuncionario;

    @FXML
    private CheckBox cbVendaAplicaDesconto;

    @FXML
    private TableColumn<Item, String> tcCompraNome;

    @FXML
    private TableColumn<Item, String> tcVendaSubTotal;

    @FXML
    private TableColumn<Item, String> tcCompraSubTotal;

    @FXML
    private CheckBox cbCompraAplicaDesconto;

    @FXML
    private TextField tfCompraValorTotal;

    @FXML
    private Button bCompraCancelar;

    @FXML
    private AnchorPane apCompraValorTotal;

    @FXML
    private TabPane tp;

    @FXML
    private TableView<Item> tvCompraItens;

    @FXML
    private Button bVendaSalvar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listaCompra = new ListaItens();
        listaVenda = new ListaItens();
        inicializaComboBox();
    }

    @FXML
    void compraIniciaCompra(ActionEvent event) {
        if (compra == null) {
            compra = new Compra();
        }
        desbloquearCamposCompraInformacoes(true);
    }

    @FXML
    void compraSalvar(ActionEvent event) {
        String aux1 = cbCompraFuncionario.getSelectionModel().getSelectedItem();
        String aux2 = cbCompraFornecedor.getSelectionModel().getSelectedItem();

        funcionarioCompra = (Funcionario) Supermercado.where("funcionario", "nome", aux1);
        fornecedorCompra = (Fornecedor) Supermercado.where("fornecedor", "nome fantasia", aux2);

        try {
            Compra.validaFuncionario(funcionarioCompra);
            Compra.validaFornecedor(fornecedorCompra);
            desbloquearCamposCompra(true);
            Item.setIdAtualItem(1);
        } catch (IOException e) {
            geraMensagemAlerta(e.getMessage());
        }
    }

    @FXML
    void compraInformacoesCancelar(ActionEvent event) {
        desbloquearCamposCompraInformacoes(false);
        limparCampos(new ArrayList<>(Arrays.asList(apCompraInformacoes)));
        funcionarioCompra = null;
        fornecedorCompra = null;
    }

    @FXML
    void compraCancelar(ActionEvent event) {
        desbloquearCamposCompra(false);
        limparCampos(new ArrayList<>(Arrays.asList(apCompraListaItens, apCompraValorTotal)));
        listaCompra.getItens().clear();
    }

    @FXML
    void compraNovoItem(ActionEvent event) {
        Item item = null;

        Produto produto = inputProduto();
        if (produto == null) {
            return;
        }

        int qtd = inputQtd();
        if (qtd == 0) {
            return;
        }

        item = new Item(qtd, produto, produto.getValorCompra());

        listaCompra.getItens().add(item);
        Supermercado.estoque.addItem(item);

        atualizaListaCompra();
        atualizaCompraValorTotal();
    }

    @FXML
    void compraExcluir(ActionEvent event) {
        int i = tvCompraItens.getSelectionModel().getSelectedIndex();
        if (i == -1) {
            geraMensagemAlerta("Selecione um item a ser excluido!");
            return;
        }
        Item item = (Item) tvCompraItens.getItems().get(i);

        listaCompra.getItens().remove(item);
        atualizaListaCompra();
        atualizaCompraValorTotal();
    }

    @FXML
    void compraEditar(ActionEvent event) {
        int i = tvCompraItens.getSelectionModel().getSelectedIndex();
        if (i == -1) {
            geraMensagemAlerta("Selecione um item a ser editado!");
            return;
        }
        Item item = (Item) tvCompraItens.getItems().get(i);

        int qtd = inputQtd();

        if (qtd == 0) {
            return;
        }

        listaCompra.getItens().forEach((t) -> {
            if (t.getId() == item.getId()) {
                t.setQtd(qtd);
                t.setSubTotal();
            }
        });
        atualizaListaCompra();
        atualizaCompraValorTotal();
    }

    @FXML
    void compraFinalizarCompra(ActionEvent event) {
        try {
            verificaESetCamposCompra();

            Supermercado.compras.add(compra);

            compra = null;
            compraCancelar(event);
            compraInformacoesCancelar(event);
            geraMensagemSucesso("Compra realizada com sucesso!");
        } catch (IOException e) {
            if (!e.getMessage().equals("")) {
                geraMensagemAlerta(e.getMessage());
            }
        }
    }

    @FXML
    void compraAplicarDesconto(ActionEvent event) {
        double porcentagemDesconto = 0;
        if (cbCompraAplicaDesconto.isSelected()) {
            porcentagemDesconto = inputProcentagemDesconto();
        }

        if (porcentagemDesconto == 0) {
            cbCompraAplicaDesconto.setSelected(false);
        }

        compra.setPorcentagemDesconto(porcentagemDesconto);
        atualizaCompraValorTotal();
    }

    @FXML
    void vendaIniciaVenda(ActionEvent event) {
        if (venda == null) {
            venda = new Venda();
        }
        desbloquerCamposVendaInformacoes(true);
    }

    @FXML
    void vendaSalvar(ActionEvent event) {
        String aux1 = cbVendaFuncionario.getSelectionModel().getSelectedItem();
        String aux2 = cbVendaCliente.getSelectionModel().getSelectedItem();

        funcionarioVenda = (Funcionario) Supermercado.where("funcionario", "nome", aux1);
        clienteVenda = (Cliente) Supermercado.where("cliente", "nome", aux2);

        try {
            Venda.validaFuncionario(funcionarioVenda);
            Venda.validaCliente(clienteVenda);
            desbloquarCamposVenda(true);
            Item.setIdAtualItem(1);
        } catch (IOException e) {
            geraMensagemAlerta(e.getMessage());
        }
    }

    @FXML
    void vendaInformacoesCancelar(ActionEvent event) {
        desbloquerCamposVendaInformacoes(false);
        limparCampos(new ArrayList<>(Arrays.asList(apVendaInformacoes)));
        funcionarioVenda = null;
        clienteVenda = null;
    }

    @FXML
    void vendaCancelar(ActionEvent event) {
        desbloquarCamposVenda(false);
        limparCampos(new ArrayList<>(Arrays.asList(apVendaListaItens, apVendaValorTotal)));
        listaVenda.getItens().clear();
    }

    @FXML
    void vendaNovoItem(ActionEvent event) {
        Item item = null;

        Produto produto = inputProduto();
        if (produto == null) {
            return;
        }
        int qtd = inputQtd();

        if (qtd == 0) {
            return;
        }

        if (!Supermercado.estoque.verificaEstoque(produto, qtd)) {
            geraMensagemAlerta("Não tem " + produto.getNome() + " no estoque!");
            vendaNovoItem(event);
            return;
        }

        if (cbVendaAplicaPromocao.isSelected()) {
            item = new Item(qtd, produto, produto.getValorPromocao());
        } else {
            item = new Item(qtd, produto, produto.getValorVenda());
        }

        listaVenda.getItens().add(item);
        Supermercado.estoque.removeItem(item);

        atualizaListaVenda();
        atualizaVendaValorTotal();
    }

    @FXML
    void vendaExcluir(ActionEvent event) {
        int i = tvVendaItens.getSelectionModel().getSelectedIndex();
        if (i == -1) {
            geraMensagemAlerta("Selecione um item a ser excluido!");
            return;
        }
        Item item = (Item) tvVendaItens.getItems().get(i);

        listaVenda.getItens().remove(item);
        atualizaListaVenda();
        atualizaVendaValorTotal();
    }

    @FXML
    void vendaEditar(ActionEvent event) {
        int i = tvVendaItens.getSelectionModel().getSelectedIndex();
        if (i == -1) {
            geraMensagemAlerta("Selecione um item a ser editado!");
            return;
        }
        Item item = (Item) tvVendaItens.getItems().get(i);

        int qtd = inputQtd();

        if (qtd == 0) {
            return;
        }

        item.setQtd(qtd);
        listaVenda.getItens().forEach((t) -> {
            if (t.getId() == item.getId()) {
                t.setQtd(qtd);
            }
        });
        atualizaListaVenda();
        atualizaVendaValorTotal();
    }

    @FXML
    void vendaFinalizarVenda(ActionEvent event) {
        try {
            verificaESetCamposVenda();

            Supermercado.vendas.add(venda);

            venda = null;
            vendaCancelar(event);
            vendaInformacoesCancelar(event);
            geraMensagemSucesso("Venda realizada com sucesso!");
        } catch (IOException e) {
            if (!e.getMessage().equals("")) {
                geraMensagemAlerta(e.getMessage());
            }
        }
    }

    @FXML
    void vendaAplicarDesconto(ActionEvent event) {
        double porcentagemDesconto = 0;
        if (cbVendaAplicaDesconto.isSelected()) {
            porcentagemDesconto = inputProcentagemDesconto();
        }

        if (porcentagemDesconto == 0) {
            cbVendaAplicaDesconto.setSelected(false);
        }

        venda.setPorcentagemDesconto(porcentagemDesconto);
        atualizaVendaValorTotal();
    }

    @FXML
    void sair(ActionEvent event) {
        Stage stage = (Stage) bCompraSair.getScene().getWindow();
        stage.close();
    }

    private void inicializaComboBox() {
        ArrayList<String> aux = new ArrayList<>();
        Supermercado.funcionarios.forEach((c) -> aux.add(c.getNome()));
        cbCompraFuncionario.setItems(FXCollections.observableArrayList(aux));
        cbVendaFuncionario.setItems(FXCollections.observableArrayList(aux));

        aux.clear();
        Supermercado.fornecedores.forEach((c) -> aux.add(c.getNomeFantasia()));
        cbCompraFornecedor.setItems(FXCollections.observableArrayList(aux));

        aux.clear();
        Supermercado.clientes.forEach((c) -> aux.add(c.getNome()));
        cbVendaCliente.setItems(FXCollections.observableArrayList(aux));
    }

    private void desbloquearCampos(ArrayList<AnchorPane> list, boolean desbloqueado) {
        for (AnchorPane ap : list) {
            ObservableList<Node> aux = ap.getChildren();
            for (Node n : aux) {
                n.setDisable(desbloqueado);
            }
        }
    }

    private void desbloquearCamposCompraInformacoes(boolean desbloquear) {
        ArrayList<AnchorPane> aux = new ArrayList<>(Arrays.asList(apCompraInformacoes));
        desbloquearCampos(aux, !desbloquear);
        tVenda.setDisable(desbloquear);
        bCompraIniciarCompra.setDisable(desbloquear);
    }

    private void desbloquerCamposVendaInformacoes(boolean desbloquear) {
        ArrayList<AnchorPane> aux = new ArrayList<>(Arrays.asList(apVendaInformacoes));
        desbloquearCampos(aux, !desbloquear);
        tCompra.setDisable(desbloquear);
        bVendaIniciarVenda.setDisable(desbloquear);
    }

    private void desbloquearCamposCompra(boolean desbloquear) {
        ArrayList<AnchorPane> aux = new ArrayList<>(Arrays.asList(apCompraListaItens, apCompraValorTotal));
        desbloquearCampos(aux, !desbloquear);

        aux.clear();
        aux.add(apCompraInformacoes);
        desbloquearCampos(aux, desbloquear);

        cbCompraAplicaDesconto.setDisable(!desbloquear);
        bCompraNovoItem.setDisable(!desbloquear);
        bCompraExcluir.setDisable(!desbloquear);
        bCompraEditar.setDisable(!desbloquear);
        bCompraFinalizarCompra.setDisable(!desbloquear);
        bCompraCancelar.setDisable(!desbloquear);
    }

    private void desbloquarCamposVenda(boolean desbloquear) {
        ArrayList<AnchorPane> aux = new ArrayList<>(Arrays.asList(apVendaListaItens, apVendaValorTotal));
        desbloquearCampos(aux, !desbloquear);

        aux.clear();
        aux.add(apVendaInformacoes);
        desbloquearCampos(aux, desbloquear);

        cbVendaAplicaPromocao.setDisable(!desbloquear);
        cbVendaAplicaDesconto.setDisable(!desbloquear);
        bVendaNovoItem.setDisable(!desbloquear);
        bVendaExcluir.setDisable(!desbloquear);
        bVendaEditar.setDisable(!desbloquear);
        bVendaFinalizarVenda.setDisable(!desbloquear);
        bVendaCancelar.setDisable(!desbloquear);
    }

    private void limparCampos(ArrayList<AnchorPane> list) {
        for (AnchorPane ap : list) {
            ObservableList<Node> aux = ap.getChildren();
            for (Node n : aux) {
                if (n instanceof TextField) {
                    ((TextField) n).setText("R$ 0,00");
                } else if (n instanceof ComboBox) {
                    ((ComboBox) n).getSelectionModel().clearSelection();
                } else if (n instanceof TableView) {
                    ((TableView) n).getItems().clear();
                }
            }
        }
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

    private void atualizaListaCompra() {
        tvCompraItens.refresh();

        tcCompraId.setCellValueFactory(new PropertyValueFactory("id"));
        tcCompraNome.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getProduto().getNome()));
        tcCompraMarca.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getProduto().getMarca()));
        tcCompraQuantidade.setCellValueFactory(new PropertyValueFactory<>("qtd"));
        tcCompraValor.setCellValueFactory((param) -> new SimpleStringProperty(String.format("%.2f", param.getValue().getValorUtilizado())));
        tcCompraSubTotal.setCellValueFactory((param) -> new SimpleStringProperty(String.format("%.2f", param.getValue().getSubTotal())));

        tvCompraItens.setItems(FXCollections.observableArrayList(listaCompra.getItens()));
    }

    private void atualizaListaVenda() {
        tvVendaItens.refresh();

        tcVendaId.setCellValueFactory(new PropertyValueFactory("id"));
        tcVendaNome.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getProduto().getNome()));
        tcVendaMarca.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getProduto().getMarca()));
        tcVendaQuantidade.setCellValueFactory(new PropertyValueFactory<>("qtd"));
        tcVendaValor.setCellValueFactory((param) -> new SimpleStringProperty(String.format("%.2f", param.getValue().getValorUtilizado())));
        tcVendaSubTotal.setCellValueFactory((param) -> new SimpleStringProperty(String.format("%.2f", param.getValue().getSubTotal())));

        tvVendaItens.setItems(FXCollections.observableArrayList(listaVenda.getItens()));
    }

    private int inputQtd() {
        int qtd = 0;

        TextInputDialog dialog = new TextInputDialog();

        dialog.setTitle("Quantidade");
        dialog.setHeaderText("Insira a quantidade: ");
        dialog.setContentText("Quantidade: ");

        Optional<String> result = dialog.showAndWait();

        if (result.isPresent()) {
            try {
                qtd = Item.validaQtd(result.get());
            } catch (IOException e) {
                return inputQtd();
            }
        }
        return qtd;
    }

    private Produto inputProduto() {
        Produto produto = null;

        ArrayList<String> aux = new ArrayList<>();
        Supermercado.produtos.forEach((c) -> aux.add(c.getNome()));

        ChoiceDialog<String> dialog = new ChoiceDialog<>("", aux);
        dialog.setTitle("Produto");
        dialog.setHeaderText("Selecione o nome do produto: ");
        dialog.setContentText("Nome: ");

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

    private double inputProcentagemDesconto() {
        double porcentagemDesconto = 0;

        TextInputDialog dialog = new TextInputDialog();

        dialog.setTitle("Porcentagem");
        dialog.setHeaderText("Insira a porcentagem de desconto:");
        dialog.setContentText("porcentagem de desconto:");

        Optional<String> result = dialog.showAndWait();

        if (result.isPresent()) {
            try {
                porcentagemDesconto = Compra.validaPorcentagemDesconto(result.get());
            } catch (IOException e) {
                return inputProcentagemDesconto();
            }
        }

        return porcentagemDesconto;
    }

    private char inputFormaPagamento() {
        char formaPagamento = ' ';

        ArrayList<String> aux = new ArrayList<>(Arrays.asList("Credito", "Debito", "Dinheiro", "Prazo"));

        ChoiceDialog<String> dialog = new ChoiceDialog<>("", aux);
        dialog.setTitle("Forma de Pagamento");
        dialog.setContentText("Selecione a forma de pagamento:");

        Optional<String> result = dialog.showAndWait();

        if (result.isPresent()) {
            switch (result.get()) {
                case "Credito":
                    formaPagamento = 'c';

                    nomeNinja();

                    break;
                case "Debito":
                    formaPagamento = 'd';
                    break;

                case "Dinheiro":
                    formaPagamento = 'v';
                    break;

                case "Prazo":
                    formaPagamento = 'p';
                    break;
                default:
                    return inputFormaPagamento();
            }
        }
        return formaPagamento;
    }

    private void nomeNinja() {
        Alert alerta = new Alert(Alert.AlertType.NONE);

        alerta.setTitle("Nome Ninja");
        alerta.setHeaderText("Descubra seu nome ninja!!!\nEnvie as informaçõs para: \n(31) 99063-9003");

        ButtonType okButton = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        alerta.getButtonTypes().setAll(okButton);
        Image image = new Image(getClass().getResource("/imagens/nomeNinja.png").toExternalForm());
        ImageView imageView = new ImageView(image);
        alerta.setGraphic(imageView);

        alerta.initModality(Modality.APPLICATION_MODAL);

        alerta.showAndWait();
    }

    private void atualizaCompraValorTotal() {
        double valorTotal = 0;
        for (Item i : listaCompra.getItens()) {
            valorTotal += i.getSubTotal();
        }
        valorTotal *= (1 - compra.getPorcentagemDesconto() / 100);
        compra.setValorTotal(valorTotal);
        tfCompraValorTotal.setText("R$ " + String.format("%.2f", valorTotal));
    }

    private void atualizaVendaValorTotal() {
        double valorTotal = 0;
        for (Item i : listaVenda.getItens()) {
            valorTotal += i.getSubTotal();
        }
        valorTotal *= (1 - venda.getPorcentagemDesconto() / 100);
        venda.setValorTotal(valorTotal);
        tfVendaValorTotal.setText("R$ " + String.format("%.2f", valorTotal));
    }

    private void verificaESetCamposCompra() throws IOException {
        char aux = inputFormaPagamento();
        if (aux == ' ') {
            throw new IOException("");
        }

        Compra.validaListaItens(listaCompra);
        compra.set(listaCompra, aux, funcionarioCompra, LocalDate.now(), fornecedorCompra);
    }

    private void verificaESetCamposVenda() throws IOException {
        char aux = inputFormaPagamento();
        if (aux == ' ') {
            throw new IOException("");
        }

        Compra.validaListaItens(listaVenda);
        venda.set(listaVenda, aux, funcionarioVenda, LocalDate.now(), clienteVenda);
    }
}
