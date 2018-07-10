package br.com.Estoque_De_Medicamentos.App;

import java.io.IOException;

import br.com.Estoque_De_Medicamentos.dao.DaoEndereco;
import br.com.Estoque_De_Medicamentos.entidade.Administrador;
import br.com.Estoque_De_Medicamentos.entidade.Endereco;
import br.com.Estoque_De_Medicamentos.entidade.Tela;
import br.com.Estoque_De_Medicamentos.exceptions.BusinessException;
import br.com.Estoque_De_Medicamentos.exceptions.DaoException;
import br.com.Estoque_De_Medicamentos.fachada.Fachada;
import br.com.Estoque_De_Medicamentos.sql.ConexaoSQL;
import br.com.Estoque_De_Medicamentos.sql.SQLEstoque;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {

	   static Stage stage;
		
		static Pane menu, cadastroFuncionario,cadastroCliente,cadastroProduto,venda,
		consultaCliente,consultaProduto,login;
		
	    static Scene sceneMenu,sceneLogin;
	    
		@SuppressWarnings("static-access")
		@Override
		public void start(Stage stage) {
			
	        this.stage = stage;
			
			try {
		        menu= FXMLLoader.load(getClass().getResource("../view/Menu.fxml"));
				cadastroFuncionario = FXMLLoader.load(getClass().getResource("../view/CadastroFuncionario.fxml"));
				cadastroCliente = FXMLLoader.load(getClass().getResource("../view/CadastroCliente.fxml"));
				cadastroProduto = FXMLLoader.load(getClass().getResource("../view/CadastroProduto.fxml"));
				venda = FXMLLoader.load(getClass().getResource("../view/Venda.fxml"));
				consultaCliente= FXMLLoader.load(getClass().getResource("../view/ConsultaCliente.fxml"));
				consultaProduto= FXMLLoader.load(getClass().getResource("../view/ConsultaProduto.fxml"));
				login= FXMLLoader.load(getClass().getResource("../view/Login.fxml"));
				
			} catch (Exception e) {
				// TODO: handle exception
			}

				
			    sceneLogin=new Scene(login, 540, 380);
				sceneMenu = new Scene(menu);
				
				
//				this.stage.setScene(sceneMenu);
//				if(Tela.login) {
//					
//				}
				
//				stage.centerOnScreen();
				changeStage(Tela.login);
				this.stage.show();
			
				
				
			
		
		
		
		
		}
	public static void changeStage(Tela tela)
	{
		switch (tela) {
		case menu:
			
			stage.setScene(sceneMenu);
			stage.setResizable(true);
			stage.centerOnScreen();	
			stage.show();
			break;
		case login:
			stage.setScene(sceneLogin);
			stage.setResizable(false);
			stage.centerOnScreen();				
			stage.show();

		default:
			break;
		}
	}
	
	public static Pane changePane(Tela tela)
	{
		switch (tela) {
		
		case cadastroFuncionario:
			return cadastroFuncionario;
		case cadastroCliente:
			return cadastroCliente;
		case cadastroProduto:
			return cadastroProduto;
		case venda: 
		    return venda;
		case consultaCliente:
			return consultaCliente;
		case consultaProduto:
			return consultaProduto;

		default:
			System.err.println("Valor N�o Correspondente");
			break;
		}
		
		return new Pane();
	}
	
	public static void main(String[] args) {

		launch(args);
		
		

	}

}
