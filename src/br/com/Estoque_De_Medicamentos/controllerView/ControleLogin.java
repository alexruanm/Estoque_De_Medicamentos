package br.com.Estoque_De_Medicamentos.controllerView;

import br.com.Estoque_De_Medicamentos.App.App;
import br.com.Estoque_De_Medicamentos.entidade.Administrador;
import br.com.Estoque_De_Medicamentos.entidade.Funcionario;
import br.com.Estoque_De_Medicamentos.entidade.Tela;
import br.com.Estoque_De_Medicamentos.exceptions.DaoException;
import br.com.Estoque_De_Medicamentos.sql.SQLEstoque;
import br.com.Estoque_De_Medicamentos.view.Mensagens;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ControleLogin {

    @FXML
    private Button logarBnt;

    @FXML
    private Button sairBnt;

    @FXML
    private PasswordField senhaField;

    @FXML
    private TextField loginField;

    @FXML
    void actionEvento(ActionEvent event) {
    	
    	Object object = null;
    
    	if(event.getSource() == logarBnt) {
    		if(loginField.getText().equals("")||senhaField.getText().equals("")) {
    			
    			Mensagens.mensagem("Campo Login ou Senha Vazio");

	    	}else {
	    		try {
					object=SQLEstoque.loginSenha(loginField.getText(), senhaField.getText());
				} catch (DaoException e) {
					e.printStackTrace();
				}
	    	     if(object==null) {
	    	    	 Mensagens.mensagem("Login ou Senha Invalidos");
	    	     }else if(object.getClass()==Administrador.class) {
	    	    	 Mensagens.mensagem("Administrador Logado com Sucesso");
	    	    	 App.changeStage(Tela.menu);
	    	     }else if(object.getClass()==Funcionario.class) {
	    	    	 Mensagens.mensagem("Funcionário Logado com Sucesso");
	    	    	 App.changeStage(Tela.menu);
	    	     }
	    	}
    	}	
    
    	if(event.getSource() == sairBnt)
			System.exit(0);

    }

}
