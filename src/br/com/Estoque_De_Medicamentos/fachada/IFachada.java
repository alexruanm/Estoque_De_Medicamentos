package br.com.Estoque_De_Medicamentos.fachada;

import java.util.List;

import br.com.Estoque_De_Medicamentos.entidade.Administrador;
import br.com.Estoque_De_Medicamentos.entidade.Endereco;
import br.com.Estoque_De_Medicamentos.entidade.Funcionario;
import br.com.Estoque_De_Medicamentos.entidade.ItemProduto;
import br.com.Estoque_De_Medicamentos.entidade.ItemVenda;
import br.com.Estoque_De_Medicamentos.entidade.Produto;
import br.com.Estoque_De_Medicamentos.entidade.Venda;
import br.com.Estoque_De_Medicamentos.exceptions.BusinessException;
import br.com.Estoque_De_Medicamentos.exceptions.DaoException;
import br.com.Estoque_De_Medicamentos.entidade.Contato;
import br.com.Estoque_De_Medicamentos.entidade.Cliente;



import java.util.List;


public interface IFachada  {
	
	 public void administradorSalvar(Administrador administrador)throws BusinessException;
	 public void administradorEditar(Administrador administrador)throws BusinessException;
	 public Administrador administradorBuscarPorId(int id)throws BusinessException;
	 public Administrador administradorBuscarPorCpf(String cpf)throws BusinessException;
	 public List<Administrador> administradorBuscarPorBusca(String busca)throws BusinessException;
	 
	 public void clienteSalvar(Cliente cliente)throws BusinessException;	 
	 public void clienteEditar(Cliente cliente)throws BusinessException;	 
	 public Cliente clienteBuscarPorId(int id) throws BusinessException;
	 public Cliente clienteBuscarPorCpf(String cpf)throws BusinessException;
	 public List<Cliente> clienteBuscarPorBusca(String busca)throws BusinessException;
	 
	 public void contatoSalvar(Contato contato)throws BusinessException;
	 public void contatoEditar(Contato contato)throws BusinessException;
	 public Contato contatoBuscarPorId(int id) throws BusinessException;
	 
	 public void enderecoSalvar(Endereco endereco)throws BusinessException;
	 public void enderecoEditar(Endereco endereco)throws BusinessException;
	 public Endereco enderecoBuscarPorId(int id) throws BusinessException;
	 
	 public void itemProdutoSalvar(ItemProduto itemProduto)throws BusinessException;
	 public void itemProdutoEditar(ItemProduto itemProduto)throws BusinessException;
	 public ItemProduto itemProdutoBuscarPorId(int id)throws BusinessException;
	 
	 public void itemVendaSalvar(ItemVenda itemVenda)throws BusinessException;
	 public void itemVendaEditar(ItemVenda itemVenda)throws BusinessException;
	 public ItemVenda itemVendaBuscarPorId(int id)throws BusinessException;
	 
	 public void produtoSalvar(Produto produto)throws BusinessException;
	 public void produtoEditar(Produto produto)throws BusinessException;
	 public Produto produtoBuscarPorId(int id)throws BusinessException;
	 public List<Produto> produtoBuscarPorBusca(String busca)throws BusinessException;
	 
	 public void vendaSalvar(Venda venda)throws BusinessException;
	 public void vendaEditar(Venda venda)throws BusinessException;
	 public Venda vendaBuscarPorId(int id)throws BusinessException;
	 public List<Venda> vendaBuscarPorBusca(String busca)throws BusinessException;
	 
	 public void funcionarioSalvar(Funcionario funcionario)throws BusinessException;
	 public void funcionarioEditar(Funcionario funcionario)throws BusinessException;
	 public Funcionario funcionarioBuscarPorId(int id)throws BusinessException;
	 public Funcionario funcionarioBuscarPorCpf(String cpf)throws BusinessException;
	 public List<Funcionario> funcionarioBuscarPorBusca(String busca)throws BusinessException;


}
