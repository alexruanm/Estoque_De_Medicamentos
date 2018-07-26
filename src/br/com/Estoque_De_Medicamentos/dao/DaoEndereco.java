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
			
            statement.setString(1, endereco.getUf());
            statement.setString(2, endereco.getCidade());
            statement.setString(3, endereco.getRua());
            statement.setInt(4, endereco.getNumero());
            statement.setString(5, endereco.getCep());
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
			
		    statement.setString(1, endereco.getUf());
            statement.setString(2, endereco.getCidade());
            statement.setString(3, endereco.getRua());
            statement.setInt(4, endereco.getNumero());
            statement.setString(5, endereco.getCep());
            
            statement.setInt(6, endereco.getId());
						
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
				this.statement = conexao.prepareStatement("SELECT * FROM endereco where id  = '" + id + "'");	

	            ResultSet result = this.statement.executeQuery();
	            Endereco endereco= new Endereco();
	            
	            if (result.next()) {	  
	            	
	            	endereco.setId(result.getInt(1));
	            	endereco.setUf(result.getString(2));
	            	endereco.setCidade(result.getString(3));
	            	endereco.setRua(result.getString(4));
	            	endereco.setNumero(result.getInt(5));
	            	endereco.setCep(result.getString(6));
	
	            } else {
	                System.out.println("Endereço não Exister");
	            }
	            this.conexao.close();
	            return endereco;

	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            
	        }
		return null;
	}

}
