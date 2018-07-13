package br.com.Estoque_De_Medicamentos.controllerView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.text.html.HTMLEditorKit.Parser;

import br.com.Estoque_De_Medicamentos.entidade.Cliente;
import br.com.Estoque_De_Medicamentos.entidade.Contato;
import br.com.Estoque_De_Medicamentos.entidade.Endereco;
import br.com.Estoque_De_Medicamentos.entidade.MascarasFX;
import br.com.Estoque_De_Medicamentos.exceptions.BusinessException;
import br.com.Estoque_De_Medicamentos.exceptions.ValidacaoException;
import br.com.Estoque_De_Medicamentos.fachada.Fachada;
import br.com.Estoque_De_Medicamentos.view.Mensagens;
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
    private TextField cepTextFild;

    @FXML
    void actionEvento(ActionEvent event) throws ValidacaoException{
    	
    	// Metodo para salvar cliente
    	if(event.getSource()==btnAdd) {
    		if(nomeTextFild.getText().equals("")||cpfTextFild.getText().equals("")||cidadeTextFild.getText().equals("")||
    				ruaTextFild.getText().equals("")||comboUF==null||telefone1TextFild.getText().equals("")||
    				cepTextFild.getText().equals("")||numeroTextFild.getText().equals("")||emailTextFild.getText().equals("")) {
    			Mensagens.mensagem("Todos os Campos Obrigatorios Não Estão Preenchidos");
    			
    		}else {
    			Endereco endereco=new Endereco();
    			endereco.setCep(cepTextFild.getText());
    			endereco.setCidade(cidadeTextFild.getText());
    			endereco.setNumero(Integer.parseInt(numeroTextFild.getText()));
    			endereco.setRua(ruaTextFild.getText());
    			endereco.setUf(comboUF.getSelectionModel().getSelectedItem());

    			Cliente cliente= new Cliente();
    			cliente.setCpf(cpfTextFild.getText());
    			cliente.setNome(nomeTextFild.getText());
    			
    			
    			try {
					Fachada.getInstance().enderecoSalvar(endereco);
					Fachada.getInstance().clienteSalvar(cliente);
					
					if(!emailTextFild.getText().equals("")) {
	    				Fachada.getInstance().contatoSalvar(new Contato(emailTextFild.getText(), "Email"));
	    			}
		            if(!telefone1TextFild.getText().equals("")) {
		            	Fachada.getInstance().contatoSalvar(new Contato(telefone1TextFild.getText(), "Telefone 01"));
	    			}
		            if(!telefone2TextFild.getText().equals("")) {
		            	Fachada.getInstance().contatoSalvar(new Contato(telefone2TextFild.getText(), "Telefone 02"));
		            }
				} catch (BusinessException e) {
				
					e.printStackTrace();
				}
    			
    		}
    		
    	}
    	//fim do Metodo para salvar cliente

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		MascarasFX.mascaraCPF(cpfTextFild);
		MascarasFX.mascaraTelefone(telefone1TextFild);
		MascarasFX.mascaraTelefone(telefone2TextFild);
		MascarasFX.mascaraEmail(emailTextFild);
		MascarasFX.mascaraNumeroInteiro(numeroTextFild);
		MascarasFX.mascaraCEP(cepTextFild);
		
		carregarComboBox();
		
	}
    

	public void carregarComboBox() {
    	
    	ObservableList<String> listaCerta=FXCollections.observableArrayList("AC","AL","AP",
    			"AM","BA","CE","DF","ES","GO","MA","MT","MS","MG","PA","PB","PR","PE","PI",
    			"RJ","RN","RS","RO","RR","SC","SP","SE","TO");
    	comboUF.setItems(listaCerta);
    	
    }







    

}
