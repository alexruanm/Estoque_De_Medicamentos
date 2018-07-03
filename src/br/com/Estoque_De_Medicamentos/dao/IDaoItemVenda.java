package br.com.Estoque_De_Medicamentos.dao;

import java.util.List;

import br.com.Estoque_De_Medicamentos.entidade.Cliente;
import br.com.Estoque_De_Medicamentos.entidade.ItemVenda;

public interface IDaoItemVenda {
	
	 public void salvar(ItemVenda itemVenda);
	 public void editar(ItemVenda itemVenda);
	 public ItemVenda buscarPorId(int id);
	 public ItemVenda buscarPorCpf(String cpf);
	 public List<ItemVenda> buscarPorBusca(String busca);

}
