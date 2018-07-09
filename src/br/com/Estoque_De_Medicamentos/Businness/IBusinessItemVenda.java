package br.com.Estoque_De_Medicamentos.Businness;

import br.com.Estoque_De_Medicamentos.entidade.ItemVenda;
import br.com.Estoque_De_Medicamentos.exceptions.BusinessException;


public interface IBusinessItemVenda {
	
	 public void salvar(ItemVenda itemVenda)throws BusinessException;
	 public void editar(ItemVenda itemVenda)throws BusinessException;
	 public ItemVenda buscarPorId(int id)throws BusinessException;

}
