package br.com.Estoque_De_Medicamentos.Businness;

import br.com.Estoque_De_Medicamentos.entidade.ItemProduto;
import br.com.Estoque_De_Medicamentos.exceptions.BusinessException;


public interface IBusinessItemProduto {
	
	
	 public void salvar(ItemProduto itemProduto, int id_fornecedor, int id_produto)throws BusinessException;
	 public void editar(ItemProduto itemProduto)throws BusinessException;
	 public ItemProduto buscarPorId(int id)throws BusinessException;

}
