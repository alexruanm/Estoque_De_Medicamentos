package br.com.Estoque_De_Medicamentos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import br.com.Estoque_De_Medicamentos.entidade.Venda;
import br.com.Estoque_De_Medicamentos.sql.ConexaoSQL;
import br.com.Estoque_De_Medicamentos.sql.SQLEstoque;

public class DaoVenda implements IDaoVenda {
	
	private Connection conexao;
	private PreparedStatement statement;
	
	@Override
	public void salvar(Venda venda) {
		Integer id_Item_Venda;
		
		id_Item_Venda = ConexaoSQL.getCurrentValorTabela("item_venda");
	
		try {
			this.conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
			this.statement = conexao.prepareStatement(SQLEstoque.insert_Venda_All);	
			
			statement.setString(1, venda.getComprador());
            statement.setString(2, venda.getVendedor());
            statement.setDate(3, venda.getDataComprar());
            statement.setInt(4,id_Item_Venda);
            statement.executeUpdate();
            this.conexao.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
		
	}
	@Override
	public void editar(Venda venda) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Venda buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Venda buscarPorCpf(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Venda> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

}
