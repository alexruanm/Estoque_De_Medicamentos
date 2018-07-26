package br.com.Estoque_De_Medicamentos.sql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import br.com.Estoque_De_Medicamentos.entidade.Administrador;
import br.com.Estoque_De_Medicamentos.entidade.Funcionario;
import br.com.Estoque_De_Medicamentos.exceptions.BusinessException;
import br.com.Estoque_De_Medicamentos.exceptions.DaoException;
import br.com.Estoque_De_Medicamentos.fachada.Fachada;
import javafx.scene.control.DatePicker;

public class SQLEstoque {
	
	public static String url="jdbc:postgresql://localhost:5432/EstoqueMedicamento";
	public static String usuario="postgres";
	public static String senha="postgres";
	
	
	
	
	// SQL Endereco
	public static final String insert_Endereco_All="insert into endereco (uf, cidade, rua, numero,cep) "
			+ "values (?,?,?,?,?) ";
	public static final String update_Endereco_All="UPDATE endereco SET uf= ?, cidade= ?, rua= ?, numero= ?,cep=?  WHERE id = ?";
	
	
	
	// SQL Produto
	public static final String insert_Produto_All="insert into produto (nome,tipo) "
			+ "values (?,?) ";
	public static final String update_Produto_All="UPDATE produto SET nome= ?,tipo=?, WHERE id = ?";
	
	
	
	// SQL Item Produto
	public static final String insert_ItemProduto_All="insert into item_produto"
			+ " (nome," + 
			"  data_entrada,data_fabricao,data_validade," + 
			"  quantidade,valor," + 
			"  id_produto,"
			+ "id_fornecedor) "
			+ "values (?,?,?,?,?,?,?,?) ";
	public static final String update_ItemProduto_All="UPDATE item_produto SET nome=?,data_entrada = ?, data_fabricao=?,data_validade=?,quantidade=?,valor=? WHERE id = ?";
	
	
	
	// SQL Venda
	public static final String insert_Venda_All="insert into venda (comprador,vendedor, data_comprar,id_item_venda) "
			+ "values (?,?,?,?) ";
	public static final String update_Venda_All="UPDATE venda SET comprador=?,vendedor = ?, data_comprar=?,id_item_venda=? WHERE id = ?";
	
	

	// SQL Item Venda
	public static final String insert_ItemVenda_All="insert into item_venda (produtos_comprados," + 
			"  valor_da_compra) "
			+ "values (?,?) ";
	public static final String update_ItemVenda_All="UPDATE item_venda SET produtos_comprados=?,valor_da_compra = ? WHERE id = ?";
	
	
	
	// SQL Cliente
	public static final String insert_Cliente_All="insert into cliente (nome," + 
			"  cpf," + 
			"  id_endereco) "
			+ "values (?,?,?) ";
	public static final String update_Cliente_All="UPDATE cliente SET nome=?,cpf = ?, id_endereco=? WHERE id = ?";
	
	
	
	// SQL Funcionario
	public static final String insert_Funcionario_All="insert into funcionario (login," + 
			"  senha," + 
			"  nome," + 
			"  cpf,funcao,telefone," + 
			"  id_endereco) "
			+ "values (?,?,?,?,?,?,?) ";
	public static final String update_Funcionario_All="UPDATE funcionario SET login=?,senha = ?, nome=?,cpf=?,funcao=?,telefone=?,id_endereco=? WHERE id = ?";
	
	
	
	
	// SQL Administrador
	public static final String insert_Administrador_All="insert into administrador (login,senha,nome,cpf,id_endereco) " + 
			" values (?,?,?,?,?,?) ";
	public static final String update_Administrador_All="UPDATE administrador SET login=?,senha = ?, nome=?,cpf=?,id_endereco=? WHERE id = ?";
	
	
	
	
	// SQL Contato
	public static final String insert_Contato_All="insert into contato (descricao,tipo,id_cliente) "
			+ "values (?,?,?) ";
	public static final String update_Contato_All="UPDATE contato SET descricao=?,tipo=?,id_cliente = ? WHERE id = ?";
	
	
	// SQL Fornecedor
		public static final String insert_Fornecedor_All="insert into fornecedor (nome,cnpj) "
				+ "values (?,?) ";
		public static final String update_Fornecedor_All="UPDATE fornecedor SET nome=?,cnpj=? WHERE id = ?";
	
	
	
	public static Object loginSenha(String login, String senha) throws DaoException {
		
		Connection conexao;
		PreparedStatement statement;

		try {
			conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement("SELECT * FROM administrador WHERE login ='"+ login + "'And senha='" +senha+"'" );

			ResultSet result = statement.executeQuery();
			Administrador administrador;
		
			if(result.next()) {
				
				administrador=new Administrador();
	
				administrador.setId(result.getInt(1));
				administrador.setLogin(result.getString(2));
            	administrador.setSenha(result.getString(3));
                administrador.setNome(result.getString(4));
                administrador.setCpf(result.getString(5));
                administrador.setEndereco(Fachada.getInstance().enderecoBuscarPorId(result.getInt(6)));
 
                return administrador;
				
			}
		} catch (SQLException | BusinessException ex) {
			
			throw new DaoException("PROBLEMA AO CONSULTAR ADMINISTRADOR - CONTATE O PROFISSIONAL QUALIFICADO");
			
		}
		
		try {
			conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement("SELECT * FROM funcionario WHERE login ='"+ login + "'And senha='" +senha+"'" );

			ResultSet result = statement.executeQuery();
			Funcionario funcionario;
			if(result.next()) {
				
				funcionario=new Funcionario();
				
				funcionario.setId(result.getInt(1));
				funcionario.setLogin(result.getString(2));
				funcionario.setSenha(result.getString(3));
				funcionario.setNome(result.getString(4));
				funcionario.setCpf(result.getString(5));
				funcionario.setEndereco(Fachada.getInstance().enderecoBuscarPorId(result.getInt(6)));
                
                return funcionario;
				
			}
		} catch (SQLException | BusinessException ex) {
			
			throw new DaoException("PROBLEMA AO CONSULTAR ADMINISTRADOR - CONTATE O PROFISSIONAL QUALIFICADO");
			
		}
		return null;

	}
    public static java.util.Date toDate(DatePicker datePicker) {
        if(datePicker.getValue() == null){
            return null;
        }
        LocalDate ld = datePicker.getValue();
        Instant instant = ld.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
       java.util.Date date = Date.from(instant);

        return date;
    }
    public static LocalDate toLocalDate(java.util.Date date) {
        Instant instant = Instant.ofEpochMilli(date.getTime());
        LocalDate localDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
        return localDate;
    }
	
}
