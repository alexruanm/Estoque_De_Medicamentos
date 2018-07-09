package br.com.Estoque_De_Medicamentos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.Estoque_De_Medicamentos.entidade.Administrador;
import br.com.Estoque_De_Medicamentos.entidade.Venda;
import br.com.Estoque_De_Medicamentos.exceptions.BusinessException;
import br.com.Estoque_De_Medicamentos.exceptions.DaoException;
import br.com.Estoque_De_Medicamentos.fachada.Fachada;
import br.com.Estoque_De_Medicamentos.sql.ConexaoSQL;
import br.com.Estoque_De_Medicamentos.sql.SQLEstoque;

public class DaoVenda implements IDaoVenda {
	
	private Connection conexao;
	private PreparedStatement statement;
	
	@Override
	public void salvar(Venda venda)throws DaoException {
		Integer id_Item_Venda;
		
		id_Item_Venda = ConexaoSQL.getCurrentValorTabela("item_venda");
	
		try {
			this.conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
			this.statement = conexao.prepareStatement(SQLEstoque.insert_Venda_All);	
			
			statement.setString(1, venda.getComprador());
            statement.setString(2, venda.getVendedor());
            statement.setDate(3, venda.getDataComprar());
            statement.setInt(4,id_Item_Venda);
            statement.executeUpdate();
            this.conexao.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
		
	}
	@Override
	public void editar(Venda venda) throws DaoException{
		// TODO Auto-generated method stub
		
	}
	@Override
	public Venda buscarPorId(int id)throws DaoException {
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
	public List<Venda> buscarPorBusca(String busca)throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
