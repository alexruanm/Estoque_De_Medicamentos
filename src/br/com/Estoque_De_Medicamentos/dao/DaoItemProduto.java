package br.com.Estoque_De_Medicamentos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.Estoque_De_Medicamentos.entidade.Administrador;
import br.com.Estoque_De_Medicamentos.entidade.Cliente;
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
	public void salvar(ItemProduto itemProduto) throws DaoException{
		
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
	public void editar(ItemProduto itemProduto)throws DaoException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ItemProduto buscarPorId(int id)throws DaoException {
		try {
    		this.conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
			this.statement = conexao.prepareStatement(SQLEstoque.insert_ItemProduto_All);	
            this.statement.setInt(1, id);

            ResultSet result = this.statement.executeQuery();
            ItemProduto itemProduto= new ItemProduto();
            if (result.next()) {
            	
            	itemProduto.setNome(result.getString(1));
            	itemProduto.setValidade(result.getDate(2));
            	itemProduto.setData_fabricacao(result.getDate(3));
            	itemProduto.setPreco(result.getDouble(4));
                
                
            	                
            } else {
                throw new DaoException("ADMINISTRADOR NÃO EXISTE");
            }
            this.conexao.close();
            return itemProduto;

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DaoException("PROBLEMA AO CONSULTAR ADMINISTRADOR - CONTATE O PROFISSIONAL QUALIFICADO");
        }
	}

	

}
