package controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TabPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PrincipalController {

    @FXML
    private MenuItem MIRelatorioFornecedor;

    @FXML
    private MenuItem MIRelatorioVenda;

    @FXML
    private MenuItem MIRelatorioCompra;

    @FXML
    private MenuItem MIOperacoesVenda;

    @FXML
    private Menu MRelatorios;

    @FXML
    private MenuItem MIRelatorioCliente;

    @FXML
    private MenuItem MIRelatorioProduto;

    @FXML
    private MenuItem MICadastroCliente;

    @FXML
    private MenuItem MICadastroProduto;

    @FXML
    private MenuBar MBPrincipal;

    @FXML
    private MenuItem MIOperacoesCompra;

    @FXML
    private MenuItem MICadastroFornecedor;

    @FXML
    private MenuItem MICadastroFuncionario;

    @FXML
    private MenuItem MIRelatorioEstoque;

    @FXML
    private Menu MOperacoes;

    @FXML
    private MenuItem MIRelatorioFuncionario;

    @FXML
    private Menu MCadastros;

    @FXML
    void cadastros(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/visual/Cadastros.fxml"));

        TabPane tpAux = ((TabPane) root.getChildrenUnmodifiable().get(0));
        if (event.getSource().equals(MICadastroCliente)) {
            tpAux.getSelectionModel().select(0);
        } else if (event.getSource().equals(MICadastroFornecedor)) {
            tpAux.getSelectionModel().select(1);
        } else if (event.getSource().equals(MICadastroFuncionario)) {
            tpAux.getSelectionModel().select(2);
        } else if (event.getSource().equals(MICadastroProduto)) {
            tpAux.getSelectionModel().select(3);
        }

        Scene scene = new Scene(root);

        Stage stage = new Stage();

        stage.setTitle("Cadastros");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.showAndWait();
    }

    @FXML
    void operacoes(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/visual/Operacoes.fxml"));

        TabPane tpAux = ((TabPane) root.getChildrenUnmodifiable().get(0));

        if (event.getSource().equals(MIOperacoesCompra)) {
            tpAux.getSelectionModel().select(0);
        } else if (event.getSource().equals(MIOperacoesVenda)) {
            tpAux.getSelectionModel().select(1);
        }

        Scene scene = new Scene(root);

        Stage stage = new Stage();

        stage.setTitle("Operacoes");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.showAndWait();
    }

    @FXML
    void relatorios(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/visual/Relatorios.fxml"));

        TabPane tpAux = ((TabPane) root.getChildrenUnmodifiable().get(0));

        if (event.getSource().equals(MIRelatorioCliente)) {
            tpAux.getSelectionModel().select(0);
        } else if (event.getSource().equals(MIRelatorioFornecedor)) {
            tpAux.getSelectionModel().select(1);
        } else if (event.getSource().equals(MIRelatorioFuncionario)) {
            tpAux.getSelectionModel().select(2);
        } else if (event.getSource().equals(MIRelatorioProduto)) {
            tpAux.getSelectionModel().select(3);
        } else if (event.getSource().equals(MIRelatorioEstoque)) {
            tpAux.getSelectionModel().select(4);
        } else if (event.getSource().equals(MIRelatorioCompra)) {
            tpAux.getSelectionModel().select(5);
        } else if (event.getSource().equals(MIRelatorioVenda)) {
            tpAux.getSelectionModel().select(6);
        }

        Scene scene = new Scene(root);

        Stage stage = new Stage();

        stage.setTitle("Relatorios");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.showAndWait();
    }
}
