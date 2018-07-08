package br.com.Estoque_De_Medicamentos.Businness;

import java.util.List;

import br.com.Estoque_De_Medicamentos.entidade.Cliente;
import br.com.Estoque_De_Medicamentos.exceptions.BusinessException;
import br.com.Estoque_De_Medicamentos.exceptions.DaoException;

public interface IBusinessCliente {
	
	 public void salvar(Cliente cliente)throws BusinessException;
	 public void editar(Cliente cliente)throws BusinessException;
	 public Cliente buscarPorId(int id)throws BusinessException;
	 public Cliente buscarPorCpf(String cpf)throws BusinessException;
	 public List<Cliente> buscarPorBusca(String busca)throws BusinessException;

}
