package br.com.Estoque_De_Medicamentos.Businness;

import java.util.List;

import br.com.Estoque_De_Medicamentos.dao.DaoCliente;
import br.com.Estoque_De_Medicamentos.dao.IDaoCliente;
import br.com.Estoque_De_Medicamentos.entidade.Cliente;
import br.com.Estoque_De_Medicamentos.exceptions.BusinessException;
import br.com.Estoque_De_Medicamentos.exceptions.DaoException;

public class BusinessCliente implements IBusinessCliente {
	
	private IDaoCliente cliente;

	public BusinessCliente() {
		this.cliente = new DaoCliente();
	}

	@Override
	public void salvar(Cliente cliente)throws BusinessException {
		try {
			this.cliente.salvar(cliente);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

	@Override
	public void editar(Cliente cliente)throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente buscarPorId(int id)throws BusinessException{
		try {
			return this.cliente.buscarPorId(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}

	@Override
	public Cliente buscarPorCpf(String cpf)throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> buscarPorBusca(String busca)throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
