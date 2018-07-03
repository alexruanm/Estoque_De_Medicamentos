package br.com.Estoque_De_Medicamentos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import br.com.Estoque_De_Medicamentos.entidade.ItemVenda;
import br.com.Estoque_De_Medicamentos.sql.ConexaoSQL;
import br.com.Estoque_De_Medicamentos.sql.SQLEstoque;



public class DaoItemVenda implements IDaoItemVenda{
	
	private Connection conexao;
	private PreparedStatement statement;
	
	@Override
	public void salvar(ItemVenda itemVenda) {
		
		try {
			this.conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
			this.statement = conexao.prepareStatement(SQLEstoque.insert_ItemVenda_All);	
			
			statement.setString(1, itemVenda.getProdutos_comprados());
			statement.setDouble(2, itemVenda.getValor_da_compra());

            statement.executeUpdate();
            this.conexao.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
		
	}
	@Override
	public void editar(ItemVenda itemVenda) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ItemVenda buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ItemVenda buscarPorCpf(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ItemVenda> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
