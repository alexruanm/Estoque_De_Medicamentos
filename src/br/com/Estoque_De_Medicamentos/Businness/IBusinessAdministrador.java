package br.com.Estoque_De_Medicamentos.Businness;

import java.util.List;

import br.com.Estoque_De_Medicamentos.entidade.Administrador;
import br.com.Estoque_De_Medicamentos.exceptions.BusinessException;
import br.com.Estoque_De_Medicamentos.exceptions.DaoException;

public interface IBusinessAdministrador {
	
	 public void salvar(Administrador administrador) throws BusinessException;
	 public void editar(Administrador administrador) throws BusinessException;
	 public Administrador buscarPorId(int id) throws BusinessException;
	 public Administrador buscarPorCpf(String cpf) throws BusinessException;
	 public List<Administrador> buscarPorBusca(String busca) throws BusinessException;

}
