package br.com.Estoque_De_Medicamentos.fachada;

import java.util.List;

import br.com.Estoque_De_Medicamentos.Businness.BusinessAdministrador;
import br.com.Estoque_De_Medicamentos.Businness.BusinessCliente;
import br.com.Estoque_De_Medicamentos.Businness.BusinessContato;
import br.com.Estoque_De_Medicamentos.Businness.BusinessEndereco;
import br.com.Estoque_De_Medicamentos.Businness.IBusinessAdministrador;
import br.com.Estoque_De_Medicamentos.Businness.IBusinessCliente;
import br.com.Estoque_De_Medicamentos.Businness.IBusinessContato;
import br.com.Estoque_De_Medicamentos.Businness.IBusinessEndereco;
import br.com.Estoque_De_Medicamentos.entidade.Administrador;
import br.com.Estoque_De_Medicamentos.entidade.Cliente;
import br.com.Estoque_De_Medicamentos.entidade.Contato;
import br.com.Estoque_De_Medicamentos.entidade.Endereco;
import br.com.Estoque_De_Medicamentos.exceptions.DaoException;


public class Fachada implements IFachada{
	
	   private IBusinessAdministrador businessAdministrador;
	   private IBusinessCliente businessCliente;
	   private IBusinessContato businessContato;
	   private IBusinessEndereco businessEndereco;

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
	  	  businessContato= new BusinessContato();
		  businessEndereco = new BusinessEndereco();
	   }

	@Override
	public void administradorSalvar(Administrador administrador) {
		 businessAdministrador.salvar(administrador);		
	}

	@Override
	public void administradorEditar(Administrador administrador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Administrador administradorBuscarPorId(int id) throws DaoException {
		return businessAdministrador.buscarPorId(id);
	}

	@Override
	public Administrador administradorBuscarPorCpf(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Administrador> administradorBuscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clienteSalvar(Cliente cliente) {
		businessCliente.salvar(cliente);
		
	}

	@Override
	public void clienteEditar(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente clienteBuscarPorId(int id) throws DaoException {
		return businessCliente.buscarPorId(id);
	}

	@Override
	public Cliente clienteBuscarPorCpf(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> clienteBuscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void contatoSalvar(Contato contato) {
		businessContato.salvar(contato);
		
	}

	@Override
	public void contatoEditar(Contato contato) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Contato contatoBuscarPorId(int id) throws DaoException {
		return businessContato.buscarPorId(id);
	}

	@Override
	public void enderecoSalvar(Endereco endereco) {
		businessEndereco.salvar(endereco);	
	}

	@Override
	public void enderecoEditar(Endereco endereco) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Endereco enderecoBuscarPorId(int id) throws DaoException {
		return businessEndereco.buscarPorId(id);
	}

}
