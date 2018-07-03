package br.com.Estoque_De_Medicamentos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import br.com.Estoque_De_Medicamentos.entidade.Produto;
import br.com.Estoque_De_Medicamentos.sql.ConexaoSQL;
import br.com.Estoque_De_Medicamentos.sql.SQLEstoque;

public class DaoProduto implements IDaoProduto {

	private Connection conexao;
	private PreparedStatement statement;
	
	@Override
	public void salvar(Produto produto) {
		Integer id_item_produto;
		
		id_item_produto = ConexaoSQL.getCurrentValorTabela("item_produto");
		
		
		try {
			this.conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
			this.statement = conexao.prepareStatement(SQLEstoque.insert_Produto_All);	
			
			statement.setString(1, produto.getFornecedor());
			statement.setDate(2, produto.getData_entrega());
			statement.setInt(3, produto.getQuantidade());
			statement.setInt(4, id_item_produto);
            statement.executeUpdate();
            this.conexao.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
		
	}
	@Override
	public void editar(Produto produto) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Produto buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Produto> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}
}
