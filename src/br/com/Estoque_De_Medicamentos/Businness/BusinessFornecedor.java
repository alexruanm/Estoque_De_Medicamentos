package br.com.Estoque_De_Medicamentos.Businness;

import br.com.Estoque_De_Medicamentos.dao.DaoFornecedor;
import br.com.Estoque_De_Medicamentos.dao.IDaoFornecedor;
import br.com.Estoque_De_Medicamentos.entidade.Fornecedor;
import br.com.Estoque_De_Medicamentos.exceptions.BusinessException;

public class BusinessFornecedor implements IBusinessFornecedor {
	
	private IDaoFornecedor daoFornecedor= new DaoFornecedor();

	@Override
	public Fornecedor salvar(Fornecedor fornecedor) throws BusinessException {
		try {
			return daoFornecedor.salvar(fornecedor);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
		
	}

	@Override
	public void editar(Fornecedor fornecedor) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Fornecedor buscarPorId(int id) throws BusinessException {
		try {
			return daoFornecedor.buscarPorId(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public Fornecedor buscarPorCNPJ(String cnpj) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
