package br.com.Estoque_De_Medicamentos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.Estoque_De_Medicamentos.entidade.Funcionario;
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
		try {
			this.conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
			this.statement = conexao.prepareStatement(SQLEstoque.update_Produto_All);	
			
			statement.setString(1, produto.getFornecedor());
			statement.setDate(2, produto.getData_entrega());
			statement.setInt(3, produto.getQuantidade());
			statement.setInt(4, produto.getItemProduto().getId());
			
			statement.setInt(5, produto.getId());
						
			statement.executeUpdate();
			statement.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("Erro ao Atualizar Produto");
		}
		
	}
	@Override
	public Produto buscarPorId(int id) throws DaoException{
		try {
    		this.conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
			this.statement = conexao.prepareStatement("SELECT * FROM produto where id  = '" + id + "'");	

            ResultSet result = this.statement.executeQuery();
            Produto produto= new Produto();
            if (result.next()) {
            	
            	produto.setId(result.getInt(1));
            	produto.setFornecedor(result.getString(2));
            	produto.setData_entrega(result.getDate(3));
            	produto.setQuantidade(result.getInt(4));
            	produto.setItemProduto(Fachada.getInstance().itemProdutoBuscarPorId(result.getInt(5)));
            	                
            } else {
                throw new DaoException("ADMINISTRADOR NÃO EXISTE");
            }
            this.conexao.close();
            return produto;

        } catch (SQLException | BusinessException ex) {
            ex.printStackTrace();
            throw new DaoException("PROBLEMA AO CONSULTAR ADMINISTRADOR - CONTATE O PROFISSIONAL QUALIFICADO");
        }
	}
	@Override
	public List<Produto> buscarPorBusca(String busca) throws DaoException{
		
		List<Produto> produtos = new ArrayList<>();

		try {
			this.conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
			this.statement = conexao.prepareStatement("SELECT * FROM produto");
	
			ResultSet result = this.statement.executeQuery();
			Produto produto;
			while (result.next()) {
				
				produto=new Produto();
				
				produto.setId(result.getInt(1));
            	produto.setFornecedor(result.getString(2));
            	produto.setData_entrega(result.getDate(3));
            	produto.setQuantidade(result.getInt(4));
            	produto.setItemProduto(Fachada.getInstance().itemProdutoBuscarPorId(result.getInt(5)));
				
				produtos.add(produto);
			}
		} catch (SQLException | BusinessException ex) {
			
			throw new DaoException("PROBLEMA AO CONSULTAR PRODUTO - CONTATE O ADMINISTRADOR");
			
		}
		return produtos;

	}
}
