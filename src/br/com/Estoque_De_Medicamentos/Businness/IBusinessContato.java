package br.com.Estoque_De_Medicamentos.Businness;

import br.com.Estoque_De_Medicamentos.entidade.Contato;
import br.com.Estoque_De_Medicamentos.exceptions.BusinessException;
import br.com.Estoque_De_Medicamentos.exceptions.DaoException;

public interface IBusinessContato {
	
	 public void salvar(Contato contato) throws BusinessException;
	 public void editar(Contato contato) throws BusinessException;
	 public Contato buscarPorId(int id)  throws BusinessException;

}
