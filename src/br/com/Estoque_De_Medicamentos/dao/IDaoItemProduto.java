package br.com.Estoque_De_Medicamentos.dao;

import java.util.List;

import br.com.Estoque_De_Medicamentos.entidade.Cliente;
import br.com.Estoque_De_Medicamentos.entidade.ItemProduto;
import br.com.Estoque_De_Medicamentos.exceptions.DaoException;

public interface IDaoItemProduto {
	
	 public void salvar(ItemProduto itemProduto)throws DaoException;
	 public void editar(ItemProduto itemProduto)throws DaoException;
	 public ItemProduto buscarPorId(int id)throws DaoException;
	

}
