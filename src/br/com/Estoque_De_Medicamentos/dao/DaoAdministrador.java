package br.com.Estoque_De_Medicamentos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.Estoque_De_Medicamentos.entidade.Administrador;
import br.com.Estoque_De_Medicamentos.exceptions.BusinessException;
import br.com.Estoque_De_Medicamentos.exceptions.DaoException;
import br.com.Estoque_De_Medicamentos.fachada.Fachada;
import br.com.Estoque_De_Medicamentos.sql.ConexaoSQL;
import br.com.Estoque_De_Medicamentos.sql.SQLEstoque;


public class DaoAdministrador implements IDaoAdministrador{
	
	private Connection conexao;
	private PreparedStatement statement;
	
	@Override
	public void salvar(Administrador administrador)throws DaoException {
		Integer id_endereco;
		
		id_endereco = ConexaoSQL.getCurrentValorTabela("endereco");
		
		try {
			this.conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
			this.statement = conexao.prepareStatement(SQLEstoque.insert_Administrador_All);	
			
			statement.setString(1, administrador.getLogin());
            statement.setString(2, administrador.getSenha());
            statement.setString(3, administrador.getNome());
            statement.setString(4, administrador.getCpf());
            statement.setString(5, administrador.getCelular());
            statement.setInt(6, id_endereco);
            
            statement.executeUpdate();
            this.conexao.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
	}
	@Override
	public void editar(Administrador administrador) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Administrador buscarPorId(int id) throws DaoException {
	      try {
	    		this.conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
				this.statement = conexao.prepareStatement(SQLEstoque.insert_Administrador_All);	
	            this.statement.setInt(1, id);

	            ResultSet result = this.statement.executeQuery();
	            Administrador administrador= new Administrador();
	            if (result.next()) {
	            	
	            	administrador.setLogin(result.getString(1));
	            	administrador.setSenha(result.getString(2));
	                administrador.setNome(result.getString(3));
	                administrador.setCpf(result.getString(4));
	                administrador.setCelular(result.getString(5));
	                administrador.setEndereco(Fachada.getInstance().enderecoBuscarPorId(result.getInt(6)));
	            	                
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
	public Administrador buscarPorCpf(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Administrador> buscarPorBusca(String busca) throws DaoException{
		
		List<Administrador> administradores = new ArrayList<>();

		try {
			this.conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
			this.statement = conexao.prepareStatement("SELECT * FROM administrador");


			
			ResultSet result = this.statement.executeQuery();
			Administrador administrador;
			while (result.next()) {
				
				administrador=new Administrador();
				
				administrador.setLogin(result.getString(1));
            	administrador.setSenha(result.getString(2));
                administrador.setNome(result.getString(3));
                administrador.setCpf(result.getString(4));
                administrador.setCelular(result.getString(5));
                administrador.setEndereco(Fachada.getInstance().enderecoBuscarPorId(result.getInt(6)));
				
				administradores.add(administrador);
			}
		} catch (SQLException | BusinessException ex) {
			
			throw new DaoException("PROBLEMA AO CONSULTAR ADMINISTRADOR - CONTATE O PROFISSIONAL QUALIFICADO");
			
		}
		return administradores;
	}

}
