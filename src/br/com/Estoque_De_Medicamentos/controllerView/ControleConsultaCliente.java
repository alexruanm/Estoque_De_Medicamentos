package br.com.Estoque_De_Medicamentos.controllerView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class ControleConsultaCliente {

    @FXML
    private GridPane pane;

    @FXML
    private TextField pesquisaTextField;

    @FXML
    private Button pesquisaTextFieldB;

    @FXML
    private TableView<?> tabela;

    @FXML
    private TableColumn<?, ?> comTID;

    @FXML
    private TableColumn<?, ?> comTNome;

    @FXML
    private TableColumn<?, ?> comTCPF;

    @FXML
    private TableColumn<?, ?> comTContato;

    @FXML
    void actionEvento(ActionEvent event) {

    }

}
