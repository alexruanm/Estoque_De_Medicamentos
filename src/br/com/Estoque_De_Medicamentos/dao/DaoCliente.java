package br.com.Estoque_De_Medicamentos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.Estoque_De_Medicamentos.entidade.Cliente;
import br.com.Estoque_De_Medicamentos.exceptions.BusinessException;
import br.com.Estoque_De_Medicamentos.exceptions.DaoException;
import br.com.Estoque_De_Medicamentos.fachada.Fachada;
import br.com.Estoque_De_Medicamentos.sql.ConexaoSQL;
import br.com.Estoque_De_Medicamentos.sql.SQLEstoque;

public class DaoCliente implements IDaoCliente{

	private Connection conexao;
	private PreparedStatement statement;
	    
	@Override
	public void salvar(Cliente cliente) {
		
		Integer id_endereco;
		
		id_endereco = ConexaoSQL.getCurrentValorTabela("endereco");
		
		
		try {
			this.conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
			this.statement = conexao.prepareStatement(SQLEstoque.insert_Cliente_All);	
			
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getCpf());
            statement.setInt(3, id_endereco);
           

            statement.executeUpdate();
            this.conexao.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void editar(Cliente cliente)throws DaoException {
		try {
			this.conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
			this.statement = conexao.prepareStatement(SQLEstoque.update_Cliente_All);	
			
			statement.setString(1, cliente.getNome());
			statement.setString(2, cliente.getCpf());
			statement.setInt(3, cliente.getEndereco().getId());
			
			statement.setInt(4, cliente.getId());
						
			statement.executeUpdate();
			statement.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("Erro ao Atualizar  Cliente");
		}
		
	}

	@Override
	public Cliente buscarPorId(int id)throws DaoException {
	      try {
	    		this.conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
				this.statement = conexao.prepareStatement("SELECT * FROM cliente where id  = '" + id + "'");	

	            ResultSet result = this.statement.executeQuery();
	            Cliente cliente= new Cliente();
	            if (result.next()) {
	            	
	            	cliente.setId(result.getInt(1));
	            	cliente.setNome(result.getString(2));
	            	cliente.setCpf(result.getString(3));
	            	cliente.setEndereco(Fachada.getInstance().enderecoBuscarPorId(result.getInt(3)));

	            	                
	            } else {
	                throw new DaoException("ADMINISTRADOR NÃO EXISTE");
	            }
	            this.conexao.close();
	            return cliente;

	        } catch (SQLException | BusinessException ex) {
	            ex.printStackTrace();
	            throw new DaoException("PROBLEMA AO CONSULTAR ADMINISTRADOR - CONTATE O PROFISSIONAL QUALIFICADO");
	        }
	}

	@Override
	public Cliente buscarPorCpf(String cpf)throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> buscarPorBusca(String busca)throws DaoException {
		
		List<Cliente> clientes = new ArrayList<Cliente>();

		try {
			this.conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
			this.statement = conexao.prepareStatement("SELECT * FROM cliente");


			
			ResultSet result = this.statement.executeQuery();
			Cliente cliente;
			while (result.next()) {
				
				cliente=new Cliente();
				cliente.setId(result.getInt(1));
			   	cliente.setNome(result.getString(2));
            	cliente.setCpf(result.getString(3));
            	cliente.setEndereco(Fachada.getInstance().enderecoBuscarPorId(result.getInt(4)));
            	cliente.setContatos(Fachada.getInstance().contatobuscarPorIdCliente(cliente.getId()));
            	System.out.println(cliente.getEndereco().getCidade());
				clientes.add(cliente);
				
			}
			System.out.println(clientes);
			return clientes;
		} catch (SQLException | BusinessException ex) {
			
			throw new DaoException("PROBLEMA AO CONSULTAR Clientes - CONTATE O ADMINISTRADOR");
			
		}
		
	}

}
