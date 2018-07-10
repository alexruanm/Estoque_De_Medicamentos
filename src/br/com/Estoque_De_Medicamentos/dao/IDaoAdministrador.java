package br.com.Estoque_De_Medicamentos.dao;

import java.util.List;

import br.com.Estoque_De_Medicamentos.entidade.Administrador;
import br.com.Estoque_De_Medicamentos.exceptions.DaoException;


public interface IDaoAdministrador {
	
	 public void salvar(Administrador administrador)throws DaoException;
	 public void editar(Administrador administrador)throws DaoException;
	 public Administrador buscarPorId(int id)throws DaoException;
	 public Administrador buscarPorCpf(String cpf)throws DaoException;
	 public List<Administrador> buscarPorBusca(String busca) throws DaoException;
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

}
