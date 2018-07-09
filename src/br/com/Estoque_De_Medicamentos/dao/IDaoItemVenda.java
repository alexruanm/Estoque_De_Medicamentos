package br.com.Estoque_De_Medicamentos.dao;

import java.util.List;

import br.com.Estoque_De_Medicamentos.entidade.Cliente;
import br.com.Estoque_De_Medicamentos.entidade.ItemVenda;
import br.com.Estoque_De_Medicamentos.exceptions.DaoException;

public interface IDaoItemVenda {
	
	 public void salvar(ItemVenda itemVenda)throws DaoException;
	 public void editar(ItemVenda itemVenda)throws DaoException;
	 public ItemVenda buscarPorId(int id)throws DaoException;

}
