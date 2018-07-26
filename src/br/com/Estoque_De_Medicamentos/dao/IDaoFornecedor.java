package br.com.Estoque_De_Medicamentos.dao;

import br.com.Estoque_De_Medicamentos.entidade.Fornecedor;
import br.com.Estoque_De_Medicamentos.exceptions.DaoException;

public interface IDaoFornecedor {

	 public Fornecedor salvar(Fornecedor fornecedor)throws DaoException;
	 public void editar(Fornecedor fornecedor)throws DaoException;
	 public Fornecedor buscarPorId(int id) throws DaoException;
	 public Fornecedor buscarPorCNPJ(String cnpj) throws DaoException;
	 
}
