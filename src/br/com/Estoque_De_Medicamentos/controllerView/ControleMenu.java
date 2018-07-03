package br.com.Estoque_De_Medicamentos.controllerView;

import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;

import br.com.Estoque_De_Medicamentos.App.App;
import br.com.Estoque_De_Medicamentos.entidade.Tela;
import br.com.Estoque_De_Medicamentos.view.Mensagens;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class ControleMenu {

	@FXML
    private AnchorPane menu;
	 
    @FXML
    private MenuButton menuVenda;

    @FXML
    private MenuItem ItemVenda;

    @FXML
    private MenuButton menuCadastro;

    @FXML
    private MenuItem ItemProduto;

    @FXML
    private MenuItem ItemCliente;

    @FXML
    private MenuItem ItemFuncionario;

    @FXML
    private MenuButton menuConsulta;

    @FXML
    private MenuItem ItemConsultaCliente;

    @FXML
    private MenuItem ItemConsultaProduto;

    @FXML
    private MenuButton menuRelatorio;

    @FXML
    private MenuItem ItemRelaVF;

    @FXML
    private MenuItem ItemRelaCC;

    @FXML
    private MenuItem ItemRelaSP;

    @FXML
    private MenuItem ItemRelaEP;

    @FXML
    private MenuButton menuOpcao;

    @FXML
    private MenuItem ItemSair;

    @FXML
    private AnchorPane pane;

    @FXML
    void actionItem(ActionEvent event) {

    	if(event.getSource() == ItemFuncionario)
			atualizarTela(App.changePane(Tela.cadastroFuncionario));
    	if(event.getSource() == ItemCliente)
			atualizarTela(App.changePane(Tela.cadastroCliente));
    	if(event.getSource() == ItemProduto)
			atualizarTela(App.changePane(Tela.cadastroProduto));
    	if(event.getSource()==ItemVenda)
    		atualizarTela(App.changePane(Tela.venda));
    	if(event.getSource()==ItemConsultaCliente)
    		atualizarTela(App.changePane(Tela.consultaCliente));
    	if(event.getSource()==ItemConsultaProduto)
    		atualizarTela(App.changePane(Tela.consultaProduto));
    	if(event.getSource() == ItemSair)
			System.exit(0);
    	
    		
    }
	@SuppressWarnings("static-access")
	public void atualizarTela(Pane paneNovo)
	{	
		pane.setBottomAnchor(paneNovo, 0.0);
		pane.setTopAnchor(paneNovo, 0.0);
		pane.setLeftAnchor(paneNovo, 0.0);
		pane.setRightAnchor(paneNovo, 0.0);
		
		pane.getChildren().setAll(paneNovo);
	}
	
	public void initialize(URL arg0, ResourceBundle arg1) {

				
		
	}

}
