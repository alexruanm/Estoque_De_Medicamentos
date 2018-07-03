package br.com.Estoque_De_Medicamentos.dao;

import java.util.List;

import br.com.Estoque_De_Medicamentos.entidade.Cliente;
import br.com.Estoque_De_Medicamentos.entidade.Venda;

public interface IDaoVenda {
	
	 public void salvar(Venda venda);
	 public void editar(Venda venda);
	 public Venda buscarPorId(int id);
	 public Venda buscarPorCpf(String cpf);
	 public List<Venda> buscarPorBusca(String busca);

}
