package br.com.Estoque_De_Medicamentos.dao;

import java.sql.Connection;
import java.sql.Date;
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
	public Produto salvar(Produto produto)throws DaoException {
		
		Produto produtoR= buscarPorNomeETipo(produto.getNome(), produto.getTipo());
		System.out.println(produtoR.toString());
		
		if(produtoR.getId()!=null) {
			return produtoR;
		}
		produtoR= new Produto();
		
		try {
			this.conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
			this.statement = conexao.prepareStatement(SQLEstoque.insert_Produto_All);	
			
			statement.setString(1, produto.getNome());
			statement.setString(2, produto.getTipo());
	
            statement.executeUpdate();
            this.conexao.close();
            
            produtoR.setNome(produto.getNome());
            produtoR.setTipo(produto.getTipo());
            produtoR.setId(ConexaoSQL.getCurrentValorTabela("produto"));
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
		return produtoR;
	}
	@Override
	public void editar(Produto produto) throws DaoException{
		try {
			this.conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
			this.statement = conexao.prepareStatement(SQLEstoque.update_Produto_All);	
			
			statement.setString(1, produto.getNome());
			statement.setString(2, produto.getTipo());
			
			statement.setInt(3, produto.getId());
						
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
            	produto.setNome(result.getString(2));
            	produto.setTipo(result.getString(3));
      
            	                
            } else {
                throw new DaoException("PRODUTO NÃO EXISTE");
            }
            this.conexao.close();
            return produto;

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DaoException("PROBLEMA AO CONSULTAR PRODUTO - CONTATE O ADMINISTRADOR");
        }
	}
	@Override
	public List<Produto> buscarPorBusca(String busca) throws DaoException{
		return null;
//		List<Produto> produtos = new ArrayList<>();

//		try {
//			this.conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
//			this.statement = conexao.prepareStatement("SELECT * FROM produto");
//	
//			ResultSet result = this.statement.executeQuery();
//			Produto produto;
//			while (result.next()) {
//				
//				produto=new Produto();
//				
//				produto.setId(result.getInt(1));
//            	produto.setFornecedor(result.getString(2));
//            	produto.setOrigem(result.getString(3));
//            	produto.setData_entrega(result.getDate(4));
//            	produto.setQuantidade(result.getInt(5));
//            	produto.setItemProduto(Fachada.getInstance().itemProdutoBuscarPorId(result.getInt(6)));
//				
//				produtos.add(produto);
//			}
//		} catch (SQLException | BusinessException ex) {
//			
//			throw new DaoException("PROBLEMA AO CONSULTAR PRODUTO - CONTATE O ADMINISTRADOR");
//			
//		}
//		return produtos;

	}
	@Override
	public Produto buscarPorNomeETipo(String nome, String tipo) throws DaoException {
		try {
    		this.conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
			this.statement = conexao.prepareStatement("SELECT * FROM produto where nome  = '" + nome + "' and tipo = '"+tipo+"'");	

            ResultSet result = this.statement.executeQuery();
            Produto produto= new Produto();
            if (result.next()) {
            	
            	produto.setId(result.getInt(1));
            	produto.setNome(result.getString(2));
            	produto.setTipo(result.getString(3));
	                
            }          
            this.conexao.close();
            return produto;

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DaoException("PROBLEMA AO CONSULTAR PRODUTO - CONTATE O ADMINISTRADOR");
        }
	}
}
