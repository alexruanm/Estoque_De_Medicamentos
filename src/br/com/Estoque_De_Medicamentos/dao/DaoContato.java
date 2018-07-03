package br.com.Estoque_De_Medicamentos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.Estoque_De_Medicamentos.entidade.Administrador;
import br.com.Estoque_De_Medicamentos.entidade.Contato;
import br.com.Estoque_De_Medicamentos.exceptions.DaoException;
import br.com.Estoque_De_Medicamentos.sql.ConexaoSQL;
import br.com.Estoque_De_Medicamentos.sql.SQLEstoque;

public class DaoContato implements IDaoContato{

	private Connection conexao;
	private PreparedStatement statement;
	
	@Override
	public void salvar(Contato contato) {
		try {
			this.conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
			this.statement = conexao.prepareStatement(SQLEstoque.insert_Contato_All);	
			
            statement.setString(1, contato.getTelefone01());
            statement.setString(2, contato.getTelefone02());
       
            statement.executeUpdate();
            this.conexao.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		// TODO Auto-generated method stub
		
	}

	@Override
	public void editar(Contato contato) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Contato buscarPorId(int id) throws DaoException {
	      try {
	    		this.conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
				this.statement = conexao.prepareStatement(SQLEstoque.insert_Contato_All);	
	            this.statement.setInt(1, id);

	            ResultSet result = this.statement.executeQuery();
	            Contato contato= new Contato();
	            if (result.next()) {	            	
	            	contato.setTelefone01(result.getString(1));
	            	contato.setTelefone02(result.getString(2));
	            } else {
	                throw new DaoException("Contato não Exister");
	            }
	            this.conexao.close();
	            return contato;

	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            
	        } catch (DaoException e) {
				// TODO Auto-generated catch block
				throw new DaoException("PROBLEMA AO CONSULTAR CONTATO - Contate o ADM");
			}
		return null;
	}


}
