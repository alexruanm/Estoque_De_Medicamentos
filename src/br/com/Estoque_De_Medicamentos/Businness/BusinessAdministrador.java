package br.com.Estoque_De_Medicamentos.Businness;

import java.util.List;

import br.com.Estoque_De_Medicamentos.dao.DaoAdministrador;
import br.com.Estoque_De_Medicamentos.dao.IDaoAdministrador;
import br.com.Estoque_De_Medicamentos.entidade.Administrador;
import br.com.Estoque_De_Medicamentos.exceptions.DaoException;

public class BusinessAdministrador implements IBusinessAdministrador  {
	
	private IDaoAdministrador administrador;
	
	public BusinessAdministrador() {
		this.administrador = new DaoAdministrador() ;
	}

	@Override
	public void salvar(Administrador administrador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editar(Administrador administrador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Administrador buscarPorId(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Administrador buscarPorCpf(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Administrador> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

}
