package br.com.Estoque_De_Medicamentos.Businness;

import java.util.List;

import br.com.Estoque_De_Medicamentos.dao.DaoCliente;
import br.com.Estoque_De_Medicamentos.dao.IDaoCliente;
import br.com.Estoque_De_Medicamentos.entidade.Cliente;

public class BusinessCliente implements IBusinessCliente {
	
	private IDaoCliente cliente;

	public BusinessCliente() {
		this.cliente = new DaoCliente();
	}

	@Override
	public void salvar(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editar(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente buscarPorCpf(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

}
