package br.com.Estoque_De_Medicamentos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.Estoque_De_Medicamentos.entidade.Administrador;
import br.com.Estoque_De_Medicamentos.entidade.Contato;
import br.com.Estoque_De_Medicamentos.exceptions.BusinessException;
import br.com.Estoque_De_Medicamentos.exceptions.DaoException;
import br.com.Estoque_De_Medicamentos.fachada.Fachada;
import br.com.Estoque_De_Medicamentos.sql.ConexaoSQL;
import br.com.Estoque_De_Medicamentos.sql.SQLEstoque;

public class DaoContato implements IDaoContato{

	private Connection conexao;
	private PreparedStatement statement;
	
	@Override
	public void salvar(Contato contato)throws DaoException {
        Integer id_cliente;
		
		id_cliente = ConexaoSQL.getCurrentValorTabela("cliente");
		try {
			this.conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
			this.statement = conexao.prepareStatement(SQLEstoque.insert_Contato_All);	
			
            statement.setString(1, contato.getDescricao());
            statement.setInt(2,id_cliente );
       
            statement.executeUpdate();
            this.conexao.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		// TODO Auto-generated method stub
		
	}

	@Override
	public void editar(Contato contato)throws DaoException {
		try {
			this.conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
			this.statement = conexao.prepareStatement(SQLEstoque.update_Contato_All);	
			
			 statement.setString(1, contato.getDescricao());
	         statement.setInt(2,contato.getCliente().getId() );
	         
	         statement.setInt(3, contato.getId());
						
			statement.executeUpdate();
			statement.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("Erro ao Atualizar  Contato");
		}
		
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
	            	contato.setDescricao(result.getString(1));
	            	contato.setCliente(Fachada.getInstance().clienteBuscarPorId(result.getInt(2)));
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
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
	}


}
