package br.com.Estoque_De_Medicamentos.dao;

import java.util.List;

import br.com.Estoque_De_Medicamentos.entidade.Cliente;
import br.com.Estoque_De_Medicamentos.exceptions.DaoException;



public interface IDaoCliente {
   
	 public void salvar(Cliente cliente)throws DaoException;
	 public void editar(Cliente cliente) throws DaoException;
	 public Cliente buscarPorId(int id) throws DaoException;
	 public Cliente buscarPorCpf(String cpf)throws DaoException;
	 public List<Cliente> buscarPorBusca(String busca)throws DaoException;
	 

}
