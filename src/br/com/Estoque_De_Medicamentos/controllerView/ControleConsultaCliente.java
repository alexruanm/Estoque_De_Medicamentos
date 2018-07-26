package br.com.Estoque_De_Medicamentos.controllerView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.com.Estoque_De_Medicamentos.entidade.Cliente;
import br.com.Estoque_De_Medicamentos.fachada.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

public class ControleConsultaCliente {

    @FXML
    private GridPane pane;

    @FXML
    private TextField pesquisaTextField;

    @FXML
    private Button pesquisaTextFieldB;

    @FXML
    private TableView<br.com.Estoque_De_Medicamentos.Tabela.Entidade.Cliente> tabela;

    @FXML
    private TableColumn<br.com.Estoque_De_Medicamentos.Tabela.Entidade.Cliente, Integer> idColumn;

    @FXML
    private TableColumn<br.com.Estoque_De_Medicamentos.Tabela.Entidade.Cliente, String> nomeColumn;

    @FXML
    private TableColumn<br.com.Estoque_De_Medicamentos.Tabela.Entidade.Cliente, String> cpfColumn;

    @FXML
    private TableColumn<br.com.Estoque_De_Medicamentos.Tabela.Entidade.Cliente, String> contatoColumn;

    @FXML
    private Button cadastrarClienteB;

    @FXML
    private Button editarClienteB;

    @FXML
    void actionEvento(ActionEvent event) {
    	
    	
    	
    	if(event.getSource()==pesquisaTextFieldB) {
    		
    		try {
    			tabela.getItems().clear();
				List<Cliente> clientes= Fachada.getInstance().clienteBuscarPorBusca("");
				System.out.println(clientes);
				for(Cliente c: clientes) {
					
					tabela.getItems().add(new br.com.Estoque_De_Medicamentos.Tabela.Entidade.Cliente(c.getId(),c.getNome(),c.getCpf(),c.getContatos().get(0).getDescricao()));
				}
			} catch (br.com.Estoque_De_Medicamentos.exceptions.BusinessException e) {
				
				e.printStackTrace();
			}
    		
    	}
    	


    }

	@FXML
	public void initialize() {
		
		idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		nomeColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
		cpfColumn.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		contatoColumn.setCellValueFactory(new PropertyValueFactory<>("contato"));
	}

}
