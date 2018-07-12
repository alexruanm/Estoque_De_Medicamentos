package br.com.Estoque_De_Medicamentos.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.Estoque_De_Medicamentos.entidade.Administrador;
import br.com.Estoque_De_Medicamentos.entidade.Funcionario;
import br.com.Estoque_De_Medicamentos.exceptions.BusinessException;
import br.com.Estoque_De_Medicamentos.exceptions.DaoException;
import br.com.Estoque_De_Medicamentos.fachada.Fachada;

public class SQLEstoque {
	
	public static String url="jdbc:postgresql://localhost:5432/EstoqueMedicamento";
	public static String usuario="postgres";
	public static String senha="postgres";
	
	
	
	
	// SQL Endereco
	public static final String insert_Endereco_All="insert into endereco (bairro, cidade, rua, numero) "
			+ "values (?,?,?,?) ";
	public static final String update_Endereco_All="UPDATE endereco SET bairro= ?, cidade= ?, rua= ?, numero= ? WHERE id = ?";
	
	
	
	// SQL Produto
	public static final String insert_Produto_All="insert into produto (fornecedor,"
			+ "data_entrega,"
			+ "quantidade,"
			+ "id_prod) "
			+ "values (?,?,?,?) ";
	public static final String update_Produto_All="UPDATE produto SET fornecedor= ?, data_entrega= ?, quantidade= ?, id_prod= ? WHERE id = ?";
	
	
	
	// SQL Item Produto
	public static final String insert_ItemProduto_All="insert into item_produto"
			+ "nome," + 
			"  validade," + 
			"  data_fabricao," + 
			"  preco) "
			+ "values (?,?,?,?) ";
	public static final String update_ItemProduto_All="UPDATE item_produto SET nome=?,validade = ?, data_fabricao=?,preco=? WHERE id = ?";
	
	
	
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
			"  endereco_cliente) "
			+ "values (?,?,?) ";
	public static final String update_Cliente_All="UPDATE cliente SET nome=?,cpf = ?, endereco_cliente=? WHERE id = ?";
	
	
	
	// SQL Funcionario
	public static final String insert_Funcionario_All="insert into endereco (login," + 
			"  senha," + 
			"  nome," + 
			"  cpf," + 
			"  endereco_fun "
			+ "celular) "
			+ "values (?,?,?,?,?,?) ";
	public static final String update_Funcionario_All="UPDATE funcionario SET login=?,senha = ?, nome=?,cpf=?,endereco_fun=?,celular=? WHERE id = ?";
	
	
	
	
	// SQL Administrador
	public static final String insert_Administrador_All="insert into administrador (login,senha,nome,cpf,endereco_fun,celular) " + 
			" values (?,?,?,?,?,?) ";
	public static final String update_Administrador_All="UPDATE administrador SET login=?,senha = ?, nome=?,cpf=?,endereco_fun=?,celular=? WHERE id = ?";
	
	
	
	
	// SQL Contato
	public static final String insert_Contato_All="insert into contato (descricao,,tipo,id_cliente) "
			+ "values (?,?,?) ";
	public static final String update_Contato_All="UPDATE contato SET descricao=?,tipo=?,id_cliente = ? WHERE id = ?";
	
	
	
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
                administrador.setCelular(result.getString(7));
 
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
				
				funcionario.setId(result.getInt(0));
				funcionario.setLogin(result.getString(1));
				funcionario.setSenha(result.getString(2));
				funcionario.setNome(result.getString(3));
				funcionario.setCpf(result.getString(4));
				funcionario.setCelular(result.getString(5));
				funcionario.setEndereco(Fachada.getInstance().enderecoBuscarPorId(result.getInt(6)));
                
                return funcionario;
				
			}
		} catch (SQLException | BusinessException ex) {
			
			throw new DaoException("PROBLEMA AO CONSULTAR ADMINISTRADOR - CONTATE O PROFISSIONAL QUALIFICADO");
			
		}
		return null;

	}
	
}
