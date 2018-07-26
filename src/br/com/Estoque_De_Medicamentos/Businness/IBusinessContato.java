package br.com.Estoque_De_Medicamentos.Businness;

import java.util.List;

import br.com.Estoque_De_Medicamentos.entidade.Contato;
import br.com.Estoque_De_Medicamentos.exceptions.BusinessException;
import br.com.Estoque_De_Medicamentos.exceptions.DaoException;

public interface IBusinessContato {
	
	 public void salvar(Contato contato) throws BusinessException;
	 public void editar(Contato contato) throws BusinessException;
	 public List<Contato> buscarPorIdCliente(int id)  throws BusinessException;

}
