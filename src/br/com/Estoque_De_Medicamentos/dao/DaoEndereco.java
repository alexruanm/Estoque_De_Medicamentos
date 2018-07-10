package br.com.Estoque_De_Medicamentos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import br.com.Estoque_De_Medicamentos.entidade.Endereco;
import br.com.Estoque_De_Medicamentos.exceptions.DaoException;
import br.com.Estoque_De_Medicamentos.sql.ConexaoSQL;
import br.com.Estoque_De_Medicamentos.sql.SQLEstoque;


public class DaoEndereco implements IDaoEndereco{

	private Connection conexao;
	private PreparedStatement statement;
	
	@Override
	public void salvar(Endereco endereco) throws DaoException {
		try {
			this.conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
			this.statement = conexao.prepareStatement(SQLEstoque.insert_Endereco_All);	
			
            statement.setString(1, endereco.getBairro());
            statement.setString(2, endereco.getCidade());
            statement.setString(3, endereco.getRua());
            statement.setInt(4, endereco.getNumero());
            statement.executeUpdate();
            this.conexao.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		
	}

	@Override
	public void editar(Endereco endereco) throws DaoException {
		try {
			this.conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
			this.statement = conexao.prepareStatement(SQLEstoque.update_Endereco_All);	
			
		    statement.setString(1, endereco.getBairro());
            statement.setString(2, endereco.getCidade());
            statement.setString(3, endereco.getRua());
            statement.setInt(4, endereco.getNumero());
            
            statement.setInt(5, endereco.getId());
						
			statement.executeUpdate();
			statement.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("Erro ao Atualizar  Endereço");
		}
		
	}

	@Override
	public Endereco buscarPorId(int id) throws DaoException {
	      try {
	    		this.conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
				this.statement = conexao.prepareStatement(SQLEstoque.insert_Contato_All);	
	            this.statement.setInt(1, id);

	            ResultSet result = this.statement.executeQuery();
	            Endereco endereco= new Endereco();
	            
	            if (result.next()) {	  
	            	
	            	endereco.setBairro(result.getString(1));
	            	endereco.setCidade(result.getString(2));
	            	endereco.setRua(result.getString(3));
	            	endereco.setNumero(result.getInt(4));
	
	            } else {
	                throw new DaoException("Endereço não Exister");
	            }
	            this.conexao.close();
	            return endereco;

	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            
	        } catch (DaoException e) {
				// TODO Auto-generated catch block
				throw new DaoException("PROBLEMA AO CONSULTAR ENDEREÇO - Contate o ADM");
			}
		return null;
	}

}
