package br.com.Estoque_De_Medicamentos.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.Estoque_De_Medicamentos.entidade.ItemProduto;
import br.com.Estoque_De_Medicamentos.exceptions.BusinessException;
import br.com.Estoque_De_Medicamentos.exceptions.DaoException;
import br.com.Estoque_De_Medicamentos.fachada.Fachada;
import br.com.Estoque_De_Medicamentos.sql.ConexaoSQL;
import br.com.Estoque_De_Medicamentos.sql.SQLEstoque;

public class DaoItemProduto implements IDaoItemProduto {
	
	private Connection conexao;
	private PreparedStatement statement;
	
	@Override
	public void salvar(ItemProduto itemProduto, int id_fornecedor, int id_produto) throws DaoException{
		
		
		try {
			this.conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
			this.statement = conexao.prepareStatement(SQLEstoque.insert_ItemProduto_All);	
			
			statement.setString(1, itemProduto.getNome());
			statement.setDate(2, new Date(itemProduto.getData_entreda().getTime())) ;
			statement.setDate(3, new Date(itemProduto.getData_fabricacao().getTime())) ;
			statement.setDate(4, new Date(itemProduto.getData_validade().getTime())) ;
			statement.setInt(5, itemProduto.getQuantidade());
			statement.setDouble(6, itemProduto.getValor());
			statement.setInt(7, id_produto);
			statement.setInt(8, id_fornecedor);
			
         
            statement.executeUpdate();
            this.conexao.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
		
	}
	@Override
	public void editar(ItemProduto itemProduto)throws DaoException {
		try {
			this.conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
			this.statement = conexao.prepareStatement(SQLEstoque.update_ItemProduto_All);	
			
			statement.setString(1, itemProduto.getNome());
			statement.setDate(2, new Date(itemProduto.getData_entreda().getTime())) ;
			statement.setDate(3, new Date(itemProduto.getData_fabricacao().getTime())) ;
			statement.setDate(4, new Date(itemProduto.getData_validade().getTime())) ;
			statement.setInt(5, itemProduto.getQuantidade());
			statement.setDouble(6, itemProduto.getValor());
			
			statement.setInt(7, itemProduto.getId());
						
			statement.executeUpdate();
			statement.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("Erro ao Atualizar  Item Produto");
		}
		
	}
	@Override
	public ItemProduto buscarPorId(int id)throws DaoException {
		try {
    		this.conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
			this.statement = conexao.prepareStatement("SELECT * FROM item_produto where id  = '" + id + "'");	

            ResultSet result = this.statement.executeQuery();
            ItemProduto itemProduto= new ItemProduto();
            if (result.next()) {
            	
            	itemProduto.setId(result.getInt(1));
            	itemProduto.setNome(result.getString(2));
            	itemProduto.setData_entreda(result.getDate(3));
            	itemProduto.setData_fabricacao(result.getDate(4));
            	itemProduto.setData_validade(result.getDate(5));
            	itemProduto.setQuantidade(result.getInt(6));
            	itemProduto.setValor(result.getDouble(7));
            	itemProduto.setFornecedor(Fachada.getInstance().fornecedorBuscarPorId(result.getInt(9)));
                   
            	                
            } else {
                throw new DaoException("ITEM PRODUTO NÃO EXISTER");
            }
            this.conexao.close();
            return itemProduto;

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DaoException("PROBLEMA AO CONSULTAR ADMINISTRADOR - CONTATE O PROFISSIONAL QUALIFICADO");
        } catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	

}
