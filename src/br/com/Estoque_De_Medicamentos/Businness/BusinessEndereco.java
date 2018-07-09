package br.com.Estoque_De_Medicamentos.Businness;

import br.com.Estoque_De_Medicamentos.dao.DaoEndereco;
import br.com.Estoque_De_Medicamentos.dao.IDaoEndereco;
import br.com.Estoque_De_Medicamentos.entidade.Endereco;
import br.com.Estoque_De_Medicamentos.exceptions.BusinessException;
import br.com.Estoque_De_Medicamentos.exceptions.DaoException;

public class BusinessEndereco implements IBusinessEndereco{
	
	private IDaoEndereco endereco;

	public BusinessEndereco() {
		this.endereco = new DaoEndereco();
	}

	@Override
	public void salvar(Endereco endereco) throws BusinessException {
		try {
			this.endereco.salvar(endereco);		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void editar(Endereco endereco)  throws BusinessException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public Endereco buscarPorId(int id)  throws BusinessException {
		try {
			return this.endereco.buscarPorId(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
