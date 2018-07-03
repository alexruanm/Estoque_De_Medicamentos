package br.com.Estoque_De_Medicamentos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import br.com.Estoque_De_Medicamentos.entidade.Administrador;
import br.com.Estoque_De_Medicamentos.exceptions.DaoException;
import br.com.Estoque_De_Medicamentos.sql.ConexaoSQL;
import br.com.Estoque_De_Medicamentos.sql.SQLEstoque;


public class DaoAdministrador implements IDaoAdministrador{
	
	private Connection conexao;
	private PreparedStatement statement;
	
	@Override
	public void salvar(Administrador administrador) {
		Integer id_endereco, id_contato;
		
		id_endereco = ConexaoSQL.getCurrentValorTabela("endereco");
		id_contato = ConexaoSQL.getCurrentValorTabela("contato");
		
		try {
			this.conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
			this.statement = conexao.prepareStatement(SQLEstoque.insert_Administrador_All);	
			
			statement.setString(1, administrador.getLogin());
            statement.setString(2, administrador.getSenha());
            statement.setString(3, administrador.getNome());
            statement.setString(4, administrador.getCpf());
            statement.setInt(5, id_endereco);
            statement.setInt(6, id_contato);
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
//	                administrador.setEndereco(endereco);
//	                administrador.setContato(contato);
	                
	            } else {
	                throw new DaoException("ADMINISTRADOR NÃO EXISTE");
	            }
	            this.conexao.close();
	            return administrador;

	        } catch (SQLException ex) {
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
	public List<Administrador> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

}
