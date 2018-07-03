package br.com.Estoque_De_Medicamentos.dao;

import br.com.Estoque_De_Medicamentos.entidade.Endereco;
import br.com.Estoque_De_Medicamentos.exceptions.DaoException;

public interface IDaoEndereco {
	
	 public void salvar(Endereco endereco);
	 public void editar(Endereco endereco);
	 public Endereco buscarPorId(int id) throws DaoException;
	

}
