package br.com.Estoque_De_Medicamentos.Businness;

import br.com.Estoque_De_Medicamentos.dao.DaoItemVenda;
import br.com.Estoque_De_Medicamentos.dao.IDaoItemVenda;
import br.com.Estoque_De_Medicamentos.entidade.ItemVenda;
import br.com.Estoque_De_Medicamentos.exceptions.BusinessException;

public class BusinessItemVenda implements IBusinessItemVenda{
	
	private IDaoItemVenda daoItemVenda;
	
	public BusinessItemVenda() {
		this.daoItemVenda= new DaoItemVenda();
	}
	

	@Override
	public void salvar(ItemVenda itemVenda) throws BusinessException {
		try {
			this.daoItemVenda.salvar(itemVenda);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void editar(ItemVenda itemVenda) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ItemVenda buscarPorId(int id) throws BusinessException {
		try {
			return this.daoItemVenda.buscarPorId(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
