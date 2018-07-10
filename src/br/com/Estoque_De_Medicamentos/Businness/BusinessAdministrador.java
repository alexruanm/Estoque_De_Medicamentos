package br.com.Estoque_De_Medicamentos.Businness;

import java.util.List;

import br.com.Estoque_De_Medicamentos.dao.DaoAdministrador;
import br.com.Estoque_De_Medicamentos.dao.IDaoAdministrador;
import br.com.Estoque_De_Medicamentos.entidade.Administrador;
import br.com.Estoque_De_Medicamentos.exceptions.BusinessException;
import br.com.Estoque_De_Medicamentos.exceptions.DaoException;

public class BusinessAdministrador implements IBusinessAdministrador  {
	
	private IDaoAdministrador administrador;
	
	public BusinessAdministrador() {
		this.administrador = new DaoAdministrador() ;
	}

	@Override
	public void salvar(Administrador administrador) throws BusinessException {
		try {
			this.administrador.salvar(administrador);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void editar(Administrador administrador) throws BusinessException {
		try {
			this.administrador.editar(administrador);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public Administrador buscarPorId(int id) throws BusinessException {
		try {
			return this.administrador.buscarPorId(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public Administrador buscarPorCpf(String cpf) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Administrador> buscarPorBusca(String busca) throws BusinessException {
		try {
			return this.administrador.buscarPorBusca(busca);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
