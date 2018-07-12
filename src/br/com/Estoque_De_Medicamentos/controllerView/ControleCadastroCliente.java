package br.com.Estoque_De_Medicamentos.controllerView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class ControleCadastroCliente implements Initializable {

    @FXML
    private GridPane pane;

    @FXML
    private Button btnAdd;

    @FXML
    private TextField nomeTextFild;

    @FXML
    private TextField cpfTextFild;

    @FXML
    private TextField cidadeTextFild;

    @FXML
    private ComboBox<String> comboUF;

    @FXML
    private TextField ruaTextFild;

    @FXML
    private TextField telefone1TextFild;

    @FXML
    private TextField telefone2TextFild;

    @FXML
    private TextField emailTextFild;
    
    @FXML
    private TextField numeroTextFild;

    @FXML
    void actionEvento(ActionEvent event) {
    	if(event.getSource()==btnAdd) {
    		System.out.println(comboUF.getSelectionModel().getSelectedItem());
    	}

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		carregarComboBox();
		
	}
    

	public void carregarComboBox() {
    	
    	ObservableList<String> listaCerta=FXCollections.observableArrayList("AC","AL","Ap",
    			"AM","BA","CE","DF","ES","GO","MA","MT","MS","MG","PA","PB","PR","PE","PI",
    			"RJ","RN","RS","RO","RR","SC","SP","SE","TO");
    	comboUF.setItems(listaCerta);
    	
    }







    

}
