package br.com.Estoque_De_Medicamentos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.Estoque_De_Medicamentos.entidade.Administrador;
import br.com.Estoque_De_Medicamentos.entidade.Produto;
import br.com.Estoque_De_Medicamentos.exceptions.BusinessException;
import br.com.Estoque_De_Medicamentos.exceptions.DaoException;
import br.com.Estoque_De_Medicamentos.fachada.Fachada;
import br.com.Estoque_De_Medicamentos.sql.ConexaoSQL;
import br.com.Estoque_De_Medicamentos.sql.SQLEstoque;

public class DaoProduto implements IDaoProduto {

	private Connection conexao;
	private PreparedStatement statement;
	
	@Override
	public void salvar(Produto produto)throws DaoException {
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
	public void editar(Produto produto) throws DaoException{
		// TODO Auto-generated method stub
		
	}
	@Override
	public Produto buscarPorId(int id) throws DaoException{
		try {
    		this.conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
			this.statement = conexao.prepareStatement(SQLEstoque.insert_Produto_All);	
            this.statement.setInt(1, id);

            ResultSet result = this.statement.executeQuery();
            Produto produto= new Produto();
            if (result.next()) {
            	
            	produto.setFornecedor(result.getString(1));
            	produto.setData_entrega(result.getDate(2));
            	produto.setQuantidade(result.getInt(3));
            	produto.setItemProduto(result.getInt(4));
            	                
            } else {
                throw new DaoException("ADMINISTRADOR NÃO EXISTE");
            }
            this.conexao.close();
            return administrador;

        } catch (SQLException | BusinessException ex) {
            ex.printStackTrace();
            throw new DaoException("PROBLEMA AO CONSULTAR ADMINISTRADOR - CONTATE O PROFISSIONAL QUALIFICADO");
        }
	}
	@Override
	public List<Produto> buscarPorBusca(String busca) throws DaoException{
		// TODO Auto-generated method stub
		return null;
	}
}
