package br.com.Estoque_De_Medicamentos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.Estoque_De_Medicamentos.entidade.Cliente;
import br.com.Estoque_De_Medicamentos.entidade.Fornecedor;
import br.com.Estoque_De_Medicamentos.exceptions.BusinessException;
import br.com.Estoque_De_Medicamentos.exceptions.DaoException;
import br.com.Estoque_De_Medicamentos.fachada.Fachada;
import br.com.Estoque_De_Medicamentos.sql.ConexaoSQL;
import br.com.Estoque_De_Medicamentos.sql.SQLEstoque;

public class DaoFornecedor implements IDaoFornecedor{
	
	private Connection conexao;
	private PreparedStatement statement;

	@Override
	public Fornecedor salvar(Fornecedor fornecedor) throws DaoException {

		Fornecedor fornecedorR = buscarPorCNPJ(fornecedor.getCnpj());
		if(fornecedorR.getId()!=null) {
			return fornecedorR;
		}
		fornecedorR=new Fornecedor();
		
		try {
			this.conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
			this.statement = conexao.prepareStatement(SQLEstoque.insert_Fornecedor_All);	
            statement.setString(1, fornecedor.getNome());
            statement.setString(2, fornecedor.getCnpj());
            
            statement.executeUpdate();
            this.conexao.close();
            
            fornecedorR.setCnpj(fornecedor.getCnpj());
            fornecedorR.setNome(fornecedor.getNome());
            fornecedorR.setId(ConexaoSQL.getCurrentValorTabela("fornecedor"));
            return fornecedorR;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return fornecedorR;
		
	
		
		
	}

	@Override
	public void editar(Fornecedor fornecedor) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Fornecedor buscarPorId(int id) throws DaoException {
	      try {
	    		this.conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
				this.statement = conexao.prepareStatement("SELECT * FROM fornecedor where id  = '" + id + "'");	

	            ResultSet result = this.statement.executeQuery();
	            Fornecedor fornecedor= new Fornecedor();
	            if (result.next()) {
	            	
	            	fornecedor.setId(result.getInt(1));
	            	fornecedor.setNome(result.getString(2));
	            	fornecedor.setCnpj(result.getString(3));

	            	                
	            } else {
	                throw new DaoException("FORNECEDOR NÃO EXISTE");
	            }
	            this.conexao.close();
	            return fornecedor;

	        } catch (SQLException  ex) {
	            ex.printStackTrace();
	            throw new DaoException("PROBLEMA AO CONSULTAR FORNECEDOR - CONTATE O ADMINISTRADOR");
	        }
	
	}

	@Override
	public Fornecedor buscarPorCNPJ(String cnpj) throws DaoException {
	      try {
	    		this.conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
	    		this.statement = conexao.prepareStatement("SELECT * FROM fornecedor WHERE cnpj = '" + cnpj + "'");
				
	            ResultSet result = this.statement.executeQuery();
	            Fornecedor fornecedor= new Fornecedor();
	            
	            if (result.next()) {
	            	fornecedor.setId(result.getInt(1));
	            	fornecedor.setNome(result.getString(2));
	            	fornecedor.setCnpj(result.getString(3));

	            	                
	            } 
	        
	            this.conexao.close();	     
	            return fornecedor;

	        } catch (SQLException  ex) {
	            ex.printStackTrace();
	            throw new DaoException("PROBLEMA AO CONSULTAR FORNECEDOR - CONTATE O ADMINISTRADOR");
	        }
	}

}
