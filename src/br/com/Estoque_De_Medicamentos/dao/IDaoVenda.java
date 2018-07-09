package br.com.Estoque_De_Medicamentos.dao;

import java.util.List;

import br.com.Estoque_De_Medicamentos.entidade.Cliente;
import br.com.Estoque_De_Medicamentos.entidade.Venda;
import br.com.Estoque_De_Medicamentos.exceptions.DaoException;

public interface IDaoVenda {
	
	 public void salvar(Venda venda)throws DaoException;
	 public void editar(Venda venda)throws DaoException;
	 public Venda buscarPorId(int id)throws DaoException;
	 public List<Venda> buscarPorBusca(String busca)throws DaoException;

}
