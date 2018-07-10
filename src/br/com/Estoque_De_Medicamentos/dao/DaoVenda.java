package br.com.Estoque_De_Medicamentos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
		try {
			this.conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
			this.statement = conexao.prepareStatement(SQLEstoque.update_Venda_All);	
			
			statement.setString(1, venda.getComprador());
            statement.setString(2, venda.getVendedor());
            statement.setDate(3, venda.getDataComprar());
            statement.setInt(4,venda.getItemVenda().getId());
            
            statement.setInt(5, venda.getId());
						
			statement.executeUpdate();
			statement.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("Erro ao Atualizar  Venda");
		}
		
	}
	@Override
	public Venda buscarPorId(int id)throws DaoException {
		try {
    		this.conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
			this.statement = conexao.prepareStatement(SQLEstoque.insert_Venda_All);	
            this.statement.setInt(1, id);

            ResultSet result = this.statement.executeQuery();
            Venda venda= new Venda();
            if (result.next()) {
            	
            	venda.setComprador(result.getString(1));
            	venda.setVendedor(result.getString(2));
            	venda.setDataComprar(result.getDate(3));
            	venda.setItemVenda(Fachada.getInstance().itemVendaBuscarPorId(result.getInt(4)));
            	                
            } else {
                throw new DaoException("Venda NÃO EXISTE");
            }
            this.conexao.close();
            return venda;

        } catch (SQLException | BusinessException ex) {
            ex.printStackTrace();
            throw new DaoException("PROBLEMA AO CONSULTAR ADMINISTRADOR - CONTATE O PROFISSIONAL QUALIFICADO");
        }
	}
	@Override
	public List<Venda> buscarPorBusca(String busca)throws DaoException {
		
		List<Venda> vendas = new ArrayList<>();

		try {
			this.conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
			this.statement = conexao.prepareStatement("SELECT * FROM venda");
	
			ResultSet result = this.statement.executeQuery();
			Venda venda;
			while (result.next()) {
				
				venda=new Venda();
				
		     	venda.setComprador(result.getString(1));
            	venda.setVendedor(result.getString(2));
            	venda.setDataComprar(result.getDate(3));
            	venda.setItemVenda(Fachada.getInstance().itemVendaBuscarPorId(result.getInt(4)));
				
				vendas.add(venda);
			}
		} catch (SQLException | BusinessException ex) {
			
			throw new DaoException("PROBLEMA AO CONSULTAR VENDAS - CONTATE O ADMINISTRADOR");
			
		}
		return vendas;
	}

}
