package br.com.Estoque_De_Medicamentos.dao;

import java.util.List;

import br.com.Estoque_De_Medicamentos.entidade.Cliente;
import br.com.Estoque_De_Medicamentos.entidade.Funcionario;

public interface IDaoFuncionario {
	
	 public void salvar(Funcionario funcionario);
	 public void editar(Funcionario funcionario);
	 public Funcionario buscarPorId(int id);
	 public Funcionario buscarPorCpf(String cpf);
	 public List<Funcionario> buscarPorBusca(String busca);

}
