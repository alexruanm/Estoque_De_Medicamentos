package br.com.Estoque_De_Medicamentos.dao;

import java.util.List;

import br.com.Estoque_De_Medicamentos.entidade.Cliente;
import br.com.Estoque_De_Medicamentos.entidade.ItemProduto;

public interface IDaoItemProduto {
	
	 public void salvar(ItemProduto itemProduto);
	 public void editar(ItemProduto itemProduto);
	 public ItemProduto buscarPorId(int id);
	 public List<Cliente> buscarPorBusca(String busca);

}
