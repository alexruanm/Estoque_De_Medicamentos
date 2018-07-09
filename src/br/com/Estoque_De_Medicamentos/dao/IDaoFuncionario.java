package br.com.Estoque_De_Medicamentos.dao;

import java.util.List;

import br.com.Estoque_De_Medicamentos.entidade.Cliente;
import br.com.Estoque_De_Medicamentos.entidade.Funcionario;
import br.com.Estoque_De_Medicamentos.exceptions.DaoException;

public interface IDaoFuncionario {
	
	 public void salvar(Funcionario funcionario)throws DaoException;
	 public void editar(Funcionario funcionario)throws DaoException;
	 public Funcionario buscarPorId(int id)throws DaoException;
	 public Funcionario buscarPorCpf(String cpf)throws DaoException;
	 public List<Funcionario> buscarPorBusca(String busca)throws DaoException;

}
