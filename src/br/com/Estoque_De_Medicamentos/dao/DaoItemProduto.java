package br.com.Estoque_De_Medicamentos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import br.com.Estoque_De_Medicamentos.entidade.Cliente;
import br.com.Estoque_De_Medicamentos.entidade.ItemProduto;
import br.com.Estoque_De_Medicamentos.sql.ConexaoSQL;
import br.com.Estoque_De_Medicamentos.sql.SQLEstoque;

public class DaoItemProduto implements IDaoItemProduto {
	
	private Connection conexao;
	private PreparedStatement statement;
	
	@Override
	public void salvar(ItemProduto itemProduto) {
		
		try {
			this.conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
			this.statement = conexao.prepareStatement(SQLEstoque.insert_ItemProduto_All);	
			
			statement.setString(1, itemProduto.getNome());
			statement.setDate(2, itemProduto.getValidade());
			statement.setDate(3, itemProduto.getData_fabricacao());
			statement.setDouble(4, itemProduto.getPreco());
         
            statement.executeUpdate();
            this.conexao.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
		
	}
	@Override
	public void editar(ItemProduto itemProduto) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ItemProduto buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Cliente> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
