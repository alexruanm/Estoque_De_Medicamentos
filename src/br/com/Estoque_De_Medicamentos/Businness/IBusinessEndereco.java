package br.com.Estoque_De_Medicamentos.Businness;

import br.com.Estoque_De_Medicamentos.entidade.Endereco;
import br.com.Estoque_De_Medicamentos.exceptions.BusinessException;
import br.com.Estoque_De_Medicamentos.exceptions.DaoException;

public interface IBusinessEndereco {
	
	 public void salvar(Endereco endereco) throws BusinessException;
	 public void editar(Endereco endereco) throws BusinessException;
	 public Endereco buscarPorId(int id)  throws BusinessException;

}
