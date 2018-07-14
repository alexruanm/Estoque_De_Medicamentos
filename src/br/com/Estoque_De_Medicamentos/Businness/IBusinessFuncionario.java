package br.com.Estoque_De_Medicamentos.Businness;

import java.util.List;

import br.com.Estoque_De_Medicamentos.entidade.Funcionario;
import br.com.Estoque_De_Medicamentos.exceptions.BusinessException;


public interface IBusinessFuncionario {
	
	 public void salvar(Funcionario funcionario)throws BusinessException;
	 public void editar(Funcionario funcionario)throws BusinessException;
	 public Funcionario buscarPorId(int id)throws BusinessException;
	 public Funcionario buscarPorCpf(String cpf)throws BusinessException;
	 public List<Funcionario> buscarPorBusca(String busca)throws BusinessException;

}
