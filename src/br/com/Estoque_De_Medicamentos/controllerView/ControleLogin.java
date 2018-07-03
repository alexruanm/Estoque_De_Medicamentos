package br.com.Estoque_De_Medicamentos.controllerView;

import br.com.Estoque_De_Medicamentos.App.App;
import br.com.Estoque_De_Medicamentos.entidade.Tela;
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
    	
    	if(event.getSource() == logarBnt)
			App.changeStage(Tela.menu);
    	if(event.getSource() == sairBnt)
			System.exit(0);

    }

}
