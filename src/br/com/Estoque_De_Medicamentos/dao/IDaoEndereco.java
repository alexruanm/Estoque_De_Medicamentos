package br.com.Estoque_De_Medicamentos.dao;

import br.com.Estoque_De_Medicamentos.entidade.Endereco;
import br.com.Estoque_De_Medicamentos.exceptions.DaoException;

public interface IDaoEndereco {
	
	 public void salvar(Endereco endereco)throws DaoException;
	 public void editar(Endereco endereco)throws DaoException;
	 public Endereco buscarPorId(int id) throws DaoException;
	

}
