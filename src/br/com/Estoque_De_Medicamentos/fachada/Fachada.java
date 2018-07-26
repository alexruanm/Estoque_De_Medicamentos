package br.com.Estoque_De_Medicamentos.fachada;

import java.util.List;

import br.com.Estoque_De_Medicamentos.Businness.BusinessAdministrador;
import br.com.Estoque_De_Medicamentos.Businness.BusinessCliente;
import br.com.Estoque_De_Medicamentos.Businness.BusinessContato;
import br.com.Estoque_De_Medicamentos.Businness.BusinessEndereco;
import br.com.Estoque_De_Medicamentos.Businness.BusinessFornecedor;
import br.com.Estoque_De_Medicamentos.Businness.BusinessFuncionario;
import br.com.Estoque_De_Medicamentos.Businness.BusinessItemProduto;
import br.com.Estoque_De_Medicamentos.Businness.BusinessItemVenda;
import br.com.Estoque_De_Medicamentos.Businness.BusinessProduto;
import br.com.Estoque_De_Medicamentos.Businness.BusinessVenda;
import br.com.Estoque_De_Medicamentos.Businness.IBusinessAdministrador;
import br.com.Estoque_De_Medicamentos.Businness.IBusinessCliente;
import br.com.Estoque_De_Medicamentos.Businness.IBusinessContato;
import br.com.Estoque_De_Medicamentos.Businness.IBusinessEndereco;
import br.com.Estoque_De_Medicamentos.Businness.IBusinessFornecedor;
import br.com.Estoque_De_Medicamentos.Businness.IBusinessFuncionario;
import br.com.Estoque_De_Medicamentos.Businness.IBusinessItemProduto;
import br.com.Estoque_De_Medicamentos.Businness.IBusinessItemVenda;
import br.com.Estoque_De_Medicamentos.Businness.IBusinessProduto;
import br.com.Estoque_De_Medicamentos.Businness.IBusinessVenda;
import br.com.Estoque_De_Medicamentos.entidade.Administrador;
import br.com.Estoque_De_Medicamentos.entidade.Cliente;
import br.com.Estoque_De_Medicamentos.entidade.Contato;
import br.com.Estoque_De_Medicamentos.entidade.Endereco;
import br.com.Estoque_De_Medicamentos.entidade.Fornecedor;
import br.com.Estoque_De_Medicamentos.entidade.Funcionario;
import br.com.Estoque_De_Medicamentos.entidade.ItemProduto;
import br.com.Estoque_De_Medicamentos.entidade.ItemVenda;
import br.com.Estoque_De_Medicamentos.entidade.Produto;
import br.com.Estoque_De_Medicamentos.entidade.Venda;
import br.com.Estoque_De_Medicamentos.exceptions.BusinessException;



public class Fachada implements IFachada{
	
	   private IBusinessAdministrador businessAdministrador;
	   private IBusinessCliente businessCliente;
	   private IBusinessContato businessContato;
	   private IBusinessEndereco businessEndereco;
	   private IBusinessItemProduto businessItemProduto;
	   private IBusinessItemVenda businessItemVenda;
	   private IBusinessProduto businessProduto; 
	   private IBusinessVenda businessVenda;
	   private IBusinessFuncionario businessFuncionario;
	   private IBusinessFornecedor businessFornecedor;

	   private static Fachada fachada;

	   public static Fachada getInstance() {
	        if (fachada == null) {
	            fachada = new Fachada();
	        }
	        return fachada;
	   }

	   private Fachada() {
		   
	      businessAdministrador= new BusinessAdministrador();
	  	  businessCliente= new BusinessCliente();
	  	  businessFuncionario= new BusinessFuncionario();
	  	  businessContato= new BusinessContato();
		  businessEndereco = new BusinessEndereco();
		  businessItemProduto= new BusinessItemProduto();
		  businessItemVenda= new BusinessItemVenda();
		  businessProduto= new BusinessProduto();
		  businessVenda = new BusinessVenda();
		  businessFornecedor = new BusinessFornecedor();
	   }

	@Override
	public void administradorSalvar(Administrador administrador)throws BusinessException {
		 businessAdministrador.salvar(administrador);		
	}

	@Override
	public void administradorEditar(Administrador administrador)throws BusinessException {
		 businessAdministrador.editar(administrador);
		
	}

	@Override
	public Administrador administradorBuscarPorId(int id) throws BusinessException {
		return businessAdministrador.buscarPorId(id);
	}

	@Override
	public Administrador administradorBuscarPorCpf(String cpf)throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Administrador> administradorBuscarPorBusca(String busca)throws BusinessException {
		return businessAdministrador.buscarPorBusca(busca);
	}

	@Override
	public void clienteSalvar(Cliente cliente)throws BusinessException {		
		businessCliente.salvar(cliente);		
	}

	@Override
	public void clienteEditar(Cliente cliente)throws BusinessException {
		businessCliente.editar(cliente);
		
	}

	@Override
	public Cliente clienteBuscarPorId(int id) throws BusinessException {
		return businessCliente.buscarPorId(id);
	}

	@Override
	public Cliente clienteBuscarPorCpf(String cpf) throws BusinessException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> clienteBuscarPorBusca(String busca)throws BusinessException {
		return businessCliente.buscarPorBusca(busca);
	}

	@Override
	public void contatoSalvar(Contato contato) throws BusinessException{
		businessContato.salvar(contato);
		
	}

	@Override
	public void contatoEditar(Contato contato)throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Contato> contatobuscarPorIdCliente(int id) throws BusinessException {
		return businessContato.buscarPorIdCliente(id);
	}

	@Override
	public void enderecoSalvar(Endereco endereco) throws BusinessException{
		businessEndereco.salvar(endereco);	
	}

	@Override
	public void enderecoEditar(Endereco endereco)throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Endereco enderecoBuscarPorId(int id) throws BusinessException {
		return businessEndereco.buscarPorId(id);
	}

	@Override
	public void itemProdutoSalvar(ItemProduto itemProduto, int id_fornecedor, int id_produto) throws BusinessException {
		businessItemProduto.salvar(itemProduto,id_fornecedor,id_produto);
		
	}

	@Override
	public void itemProdutoEditar(ItemProduto itemProduto) throws BusinessException {
		businessItemProduto.editar(itemProduto);
		
	}

	@Override
	public ItemProduto itemProdutoBuscarPorId(int id) throws BusinessException {
		return businessItemProduto.buscarPorId(id);
	}

	@Override
	public void itemVendaSalvar(ItemVenda itemVenda) throws BusinessException {
		businessItemVenda.salvar(itemVenda);
		
	}

	@Override
	public void itemVendaEditar(ItemVenda itemVenda) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ItemVenda itemVendaBuscarPorId(int id) throws BusinessException {
		return businessItemVenda.buscarPorId(id);
	}

	@Override
	public Produto produtoSalvar(Produto produto) throws BusinessException {
		return businessProduto.salvar(produto);
		
	}

	@Override
	public void produtoEditar(Produto produto) throws BusinessException {
		businessProduto.editar(produto);
		
	}

	@Override
	public Produto produtoBuscarPorId(int id) throws BusinessException {
		return businessProduto.buscarPorId(id);
	}

	@Override
	public List<Produto> produtoBuscarPorBusca(String busca) throws BusinessException {
		return businessProduto.buscarPorBusca(busca);
	}

	@Override
	public void vendaSalvar(Venda venda) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vendaEditar(Venda venda) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Venda vendaBuscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Venda> vendaBuscarPorBusca(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void funcionarioSalvar(Funcionario funcionario) throws BusinessException {
		businessFuncionario.salvar(funcionario);
		
	}

	@Override
	public void funcionarioEditar(Funcionario funcionario) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Funcionario funcionarioBuscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessFuncionario.buscarPorId(id);
	}

	@Override
	public Funcionario funcionarioBuscarPorCpf(String cpf) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> funcionarioBuscarPorBusca(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return businessFuncionario.buscarPorBusca(busca);
	}

	@Override
	public Fornecedor fornecedorSalvar(Fornecedor fornecedor) throws BusinessException {
		return businessFornecedor.salvar(fornecedor);
		
	}

	@Override
	public void editar(Fornecedor fornecedor) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Fornecedor fornecedorBuscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessFornecedor.buscarPorId(id);
	}

	@Override
	public Fornecedor buscarPorCNPJ(String cnpj) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
