package br.com.Estoque_De_Medicamentos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import br.com.Estoque_De_Medicamentos.entidade.Funcionario;
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
            statement.setString(6, funcionario.getCelular());
            statement.executeUpdate();
            this.conexao.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
		
	}
	@Override
	public void editar(Funcionario funcionario) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Funcionario buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Funcionario buscarPorCpf(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Funcionario> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

}
