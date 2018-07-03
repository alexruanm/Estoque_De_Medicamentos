package br.com.Estoque_De_Medicamentos.Businness;

import br.com.Estoque_De_Medicamentos.entidade.Contato;
import br.com.Estoque_De_Medicamentos.exceptions.DaoException;

public interface IBusinessContato {
	
	 public void salvar(Contato contato);
	 public void editar(Contato contato);
	 public Contato buscarPorId(int id) throws DaoException;

}
