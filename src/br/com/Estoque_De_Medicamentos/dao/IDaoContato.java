package br.com.Estoque_De_Medicamentos.dao;

import java.util.List;

import br.com.Estoque_De_Medicamentos.entidade.Cliente;
import br.com.Estoque_De_Medicamentos.entidade.Contato;
import br.com.Estoque_De_Medicamentos.exceptions.DaoException;

public interface IDaoContato {

	 public void salvar(Contato contato);
	 public void editar(Contato contato);
	 public Contato buscarPorId(int id) throws DaoException;
	
}
