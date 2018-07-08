package br.com.Estoque_De_Medicamentos.fachada;

import java.util.List;

import br.com.Estoque_De_Medicamentos.entidade.Administrador;
import br.com.Estoque_De_Medicamentos.entidade.Endereco;
import br.com.Estoque_De_Medicamentos.entidade.Contato;
import br.com.Estoque_De_Medicamentos.entidade.Cliente;
import br.com.Estoque_De_Medicamentos.exceptions.BusinessException;
import br.com.Estoque_De_Medicamentos.exceptions.DaoException;

import java.util.List;


public interface IFachada  {
	
	 public void administradorSalvar(Administrador administrador);
	 public void administradorEditar(Administrador administrador);
	 public Administrador administradorBuscarPorId(int id)throws DaoException;
	 public Administrador administradorBuscarPorCpf(String cpf);
	 public List<Administrador> administradorBuscarPorBusca(String busca);
	 
	 public void clienteSalvar(Cliente cliente);	 
	 public void clienteEditar(Cliente cliente);	 
	 public Cliente clienteBuscarPorId(int id) throws DaoException;
	 public Cliente clienteBuscarPorCpf(String cpf);
	 public List<Cliente> clienteBuscarPorBusca(String busca);
	 
	 public void contatoSalvar(Contato contato);
	 public void contatoEditar(Contato contato);
	 public Contato contatoBuscarPorId(int id) throws DaoException;
	 
	 public void enderecoSalvar(Endereco endereco);
	 public void enderecoEditar(Endereco endereco);
	 public Endereco enderecoBuscarPorId(int id) throws DaoException;


}
