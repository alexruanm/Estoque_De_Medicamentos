package br.com.Estoque_De_Medicamentos.controllerView;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.Estoque_De_Medicamentos.entidade.Cliente;
import br.com.Estoque_De_Medicamentos.entidade.Contato;
import br.com.Estoque_De_Medicamentos.entidade.Endereco;
import br.com.Estoque_De_Medicamentos.entidade.Funcionario;
import br.com.Estoque_De_Medicamentos.entidade.MascarasFX;
import br.com.Estoque_De_Medicamentos.exceptions.BusinessException;
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

public class ControleCadastroFuncionario implements Initializable {

    @FXML
    private GridPane pane;

    @FXML
    private Button btnAdd;

    @FXML
    private TextField nomeTextFild;

    @FXML
    private TextField cpfTextFild;

    @FXML
    private TextField emailTextFild;

    @FXML
    private TextField telefone1TextFild;

    @FXML
    private TextField loginTextFild;

    @FXML
    private TextField funcaoTextFild;

    @FXML
    private TextField senhaTextFild;

    @FXML
    private TextField senhaNovamenteTextFild;

    @FXML
    private TextField cidadeTextFild;

    @FXML
    private ComboBox<String> comboUF;

    @FXML
    private TextField ruaTextFild;

    @FXML
    private TextField numeroTextFild;

    @FXML
    private TextField cepTextFild;

    
    @FXML
    void actionEvento(ActionEvent event) {
    	
    	// Metodo para salvar Funcionário
    	if(event.getSource()==btnAdd) {
    		if(nomeTextFild.getText().equals("")||cpfTextFild.getText().equals("")||cidadeTextFild.getText().equals("")||
    				ruaTextFild.getText().equals("")||comboUF==null||telefone1TextFild.getText().equals("")||
    				cepTextFild.getText().equals("")||numeroTextFild.getText().equals("")||loginTextFild.getText().equals("")
    				||senhaTextFild.getText().equals("")||senhaNovamenteTextFild.getText().equals("")) {
    			Mensagens.mensagem("Todos os Campos Obrigatorios Não Estão Preenchidos");
    			
    		}else {
    			if(!senhaTextFild.getText().equals(senhaNovamenteTextFild.getText())) {
    				Mensagens.mensagem("A senhas não Conferem");
    			}else {
    				Endereco endereco=new Endereco();
        			endereco.setCep(cepTextFild.getText());
        			endereco.setCidade(cidadeTextFild.getText());
        			endereco.setNumero(Integer.parseInt(numeroTextFild.getText()));
        			endereco.setRua(ruaTextFild.getText());
        			endereco.setUf(comboUF.getSelectionModel().getSelectedItem());

        			Funcionario funcionario= new Funcionario();
        			funcionario.setCpf(cpfTextFild.getText());
        			funcionario.setNome(nomeTextFild.getText());
        			funcionario.setFuncao(funcaoTextFild.getText());
        			funcionario.setLogin(loginTextFild.getText());
        			funcionario.setSenha(senhaTextFild.getText());
        			funcionario.setFuncao(funcaoTextFild.getText());
        			funcionario.setTelefone(telefone1TextFild.getText());
    		
        			try {
    					Fachada.getInstance().enderecoSalvar(endereco);
    					System.out.println("Salvo endereco");
    					Fachada.getInstance().funcionarioSalvar(funcionario);
    					System.out.println("Salvo funcionario");

    				} catch (BusinessException e) {
    				
    					e.printStackTrace();
    				}
        			Mensagens.mensagem("Funcionário Cadastrado com Sucesso!!!");
    				
    			}
    			
    			
    		}
    		
    	}
    	// fim do Metodo para salvar Funcionário

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		MascarasFX.mascaraCPF(cpfTextFild);
		MascarasFX.mascaraTelefone(telefone1TextFild);
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
