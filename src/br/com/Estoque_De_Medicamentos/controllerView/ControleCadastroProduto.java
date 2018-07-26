package br.com.Estoque_De_Medicamentos.controllerView;

import java.net.URL;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ResourceBundle;

import br.com.Estoque_De_Medicamentos.entidade.Fornecedor;
import br.com.Estoque_De_Medicamentos.entidade.ItemProduto;
import br.com.Estoque_De_Medicamentos.entidade.MascarasFX;
import br.com.Estoque_De_Medicamentos.entidade.Produto;
import br.com.Estoque_De_Medicamentos.fachada.Fachada;
import br.com.Estoque_De_Medicamentos.sql.SQLEstoque;
import br.com.Estoque_De_Medicamentos.view.Mensagens;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class ControleCadastroProduto implements Initializable{


    @FXML
    private GridPane pane;

    @FXML
    private TextField cnpjTextFild;

    @FXML
    private TextField fornecedorTextFild;

    @FXML
    private TextField produtoTextFild;

    @FXML
    private TextField nomeProdutoTextFild;

    @FXML
    private DatePicker dataEntrada;

    @FXML
    private DatePicker dataFabricacao;

    @FXML
    private TextField valorTextFild;

    @FXML
    private TextField quantidadeTextFild;

    @FXML
    private DatePicker dataValidade;
    
    @FXML
    private TextField tipoTextFild;
    
    @FXML
    private ComboBox<String> tipoComboBox;

    @FXML
    private Button btnAdd;


    @FXML
    void actionEvento(ActionEvent event) throws ParseException {
    	
     	if(event.getSource()==btnAdd){
    		
    	   	if(valorTextFild.getText().equals("")||dataEntrada.getValue()==null||dataFabricacao==null||dataValidade.getValue()==null
        			||nomeProdutoTextFild.getText().equals("")||quantidadeTextFild.getText().equals("")
        			||produtoTextFild.getText().equals("")||fornecedorTextFild.getText().equals("")||tipoComboBox==null
        			||cnpjTextFild.getText().equals("")) {
       		Mensagens.mensagem("Preenchar Todos os Campos");
       		
        	}else {
        		
        		ItemProduto itemProduto= new ItemProduto();
       		
        		itemProduto.setData_fabricacao(SQLEstoque.toDate(dataFabricacao));
        		itemProduto.setData_entreda(SQLEstoque.toDate(dataEntrada));
        		itemProduto.setData_validade(SQLEstoque.toDate(dataValidade));
        		itemProduto.setNome(nomeProdutoTextFild.getText());
        		itemProduto.setValor(Double.parseDouble(valorTextFild.getText()));
        		itemProduto.setQuantidade(Integer.parseInt(quantidadeTextFild.getText()));
        	        		
        		Produto produto= new Produto();
        		
        		produto.setNome(produtoTextFild.getText());
        		produto.setTipo(tipoComboBox.getSelectionModel().getSelectedItem());
        		
        		Fornecedor fornecedor= new Fornecedor();
        		
        		fornecedor.setCnpj(cnpjTextFild.getText());
        		fornecedor.setNome(fornecedorTextFild.getText());
        		
        		
        		try {    
        			System.out.println(fornecedor.toString());
        			fornecedor=Fachada.getInstance().fornecedorSalvar(fornecedor);
        			System.out.println(fornecedor.toString());
        			System.out.println("1");
        			produto=Fachada.getInstance().produtoSalvar(produto);
        			System.out.println("2");
    				Fachada.getInstance().itemProdutoSalvar(itemProduto,fornecedor.getId(),
    						produto.getId());
    				System.out.println("item produto ok");
    				
    			} catch (Exception e) {
    				
    			}
        		
        		
        	}
    		
    	}
 

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		MascarasFX.mascaraData(dataEntrada);
		MascarasFX.mascaraData(dataValidade);
		MascarasFX.mascaraData(dataFabricacao);
		MascarasFX.mascaraNumeroInteiro(quantidadeTextFild);
		MascarasFX.mascaraNumero(valorTextFild);
		MascarasFX.mascaraCNPJ(cnpjTextFild);
		
		carregarComboBox();
		
	}
	
	public void carregarComboBox() {
    	
    	ObservableList<String> listaCerta=FXCollections.observableArrayList("De Marca","Similares","Genéricos");
    	tipoComboBox.setItems(listaCerta);
    	
    }


}
