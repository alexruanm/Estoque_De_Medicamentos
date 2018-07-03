package br.com.Estoque_De_Medicamentos.dao;

import java.util.List;

import br.com.Estoque_De_Medicamentos.entidade.Administrador;
import br.com.Estoque_De_Medicamentos.exceptions.DaoException;


public interface IDaoAdministrador {
	
	 public void salvar(Administrador administrador);
	 public void editar(Administrador administrador);
	 public Administrador buscarPorId(int id)throws DaoException;
	 public Administrador buscarPorCpf(String cpf);
	 public List<Administrador> buscarPorBusca(String busca);

}
