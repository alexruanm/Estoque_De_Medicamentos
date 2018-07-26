package br.com.Estoque_De_Medicamentos.Businness;

import br.com.Estoque_De_Medicamentos.entidade.Fornecedor;
import br.com.Estoque_De_Medicamentos.exceptions.BusinessException;


public interface IBusinessFornecedor {
	
	 public Fornecedor salvar(Fornecedor fornecedor)throws BusinessException;
	 public void editar(Fornecedor fornecedor)throws BusinessException;
	 public Fornecedor buscarPorId(int id) throws BusinessException;
	 public Fornecedor buscarPorCNPJ(String cnpj) throws BusinessException;

}
