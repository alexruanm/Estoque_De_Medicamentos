package br.com.Estoque_De_Medicamentos.controllerView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ControleConsultaProduto {

    @FXML
    private TextField pesquisaTextField;

    @FXML
    private Button pesquisaTextFieldB;

    @FXML
    private TableView<?> tabela;

    @FXML
    private TableColumn<?, ?> idColumn;

    @FXML
    private TableColumn<?, ?> produtoColumn;

    @FXML
    private TableColumn<?, ?> quantColmn;

    @FXML
    private TableColumn<?, ?> precoColumn;

    @FXML
    private Button cadastrarProduto;

    @FXML
    private Button editarProduto;

    @FXML
    void actionEvento(ActionEvent event) {

    }

}
