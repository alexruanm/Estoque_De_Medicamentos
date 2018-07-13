package br.com.Estoque_De_Medicamentos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import br.com.Estoque_De_Medicamentos.entidade.Funcionario;
import br.com.Estoque_De_Medicamentos.exceptions.BusinessException;
import br.com.Estoque_De_Medicamentos.exceptions.DaoException;
import br.com.Estoque_De_Medicamentos.fachada.Fachada;
import br.com.Estoque_De_Medicamentos.sql.ConexaoSQL;
import br.com.Estoque_De_Medicamentos.sql.SQLEstoque;

public class DaoFuncionario implements IDaoFuncionario{
	
	private Connection conexao;
	private PreparedStatement statement;
	
	@Override
	public void salvar(Funcionario funcionario) {
		
		Integer id_endereco;
		
		id_endereco = ConexaoSQL.getCurrentValorTabela("endereco");
		
		
		try {
			this.conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
			this.statement = conexao.prepareStatement(SQLEstoque.insert_Funcionario_All);	
			
			statement.setString(1, funcionario.getLogin());
            statement.setString(2, funcionario.getSenha());
            statement.setString(3, funcionario.getNome());
            statement.setString(4, funcionario.getCpf());
            statement.setInt(5, id_endereco);

            statement.executeUpdate();
            this.conexao.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
		
	}
	@Override
	public void editar(Funcionario funcionario)throws DaoException {
		try {
			this.conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
			this.statement = conexao.prepareStatement(SQLEstoque.update_Funcionario_All);	
			
			statement.setString(1, funcionario.getLogin());
            statement.setString(2, funcionario.getSenha());
            statement.setString(3, funcionario.getNome());
            statement.setString(4, funcionario.getCpf());
            statement.setInt(5, funcionario.getEndereco().getId());
 
            
            statement.setInt(6, funcionario.getId());
						
			statement.executeUpdate();
			statement.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("Erro ao Atualizar  Funcionário");
		}
		
	}
	@Override
	public Funcionario buscarPorId(int id) throws DaoException{
		try {
    		this.conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
			this.statement = conexao.prepareStatement("SELECT * FROM funcionario where id  = '" + id + "'");	

            ResultSet result = this.statement.executeQuery();
            Funcionario funcionario= new Funcionario();
            if (result.next()) {
            	
            	funcionario.setId(result.getInt(1));
            	funcionario.setLogin(result.getString(2));
            	funcionario.setSenha(result.getString(3));
            	funcionario.setNome(result.getString(4));
            	funcionario.setCpf(result.getString(5));
            	funcionario.setEndereco(Fachada.getInstance().enderecoBuscarPorId(result.getInt(6)));
            	                
            } else {
                throw new DaoException("FUNCIONARIO NÃO EXISTE");
            }
            this.conexao.close();
            return funcionario;

        } catch (SQLException | BusinessException ex) {
            ex.printStackTrace();
            throw new DaoException("PROBLEMA AO CONSULTAR ADMINISTRADOR - CONTATE O PROFISSIONAL QUALIFICADO");
        }
	}
	@Override
	public Funcionario buscarPorCpf(String cpf) throws DaoException{
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Funcionario> buscarPorBusca(String busca)throws DaoException {
		List<Funcionario> funcionarios = new ArrayList<>();

		try {
			this.conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
			this.statement = conexao.prepareStatement("SELECT * FROM funcionario");


			
			ResultSet result = this.statement.executeQuery();
			Funcionario funcionario;
			while (result.next()) {
				
				funcionario=new Funcionario();
				funcionario.setId(result.getInt(1));
				funcionario.setLogin(result.getString(2));
				funcionario.setSenha(result.getString(3));
				funcionario.setNome(result.getString(4));
				funcionario.setCpf(result.getString(5));
				funcionario.setEndereco(Fachada.getInstance().enderecoBuscarPorId(result.getInt(6)));
				
				funcionarios.add(funcionario);
			}
		} catch (SQLException | BusinessException ex) {
			
			throw new DaoException("PROBLEMA AO CONSULTAR ADMINISTRADOR - CONTATE O PROFISSIONAL QUALIFICADO");
			
		}
		return funcionarios;
	}

}
