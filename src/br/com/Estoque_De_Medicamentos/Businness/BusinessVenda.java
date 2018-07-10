package br.com.Estoque_De_Medicamentos.Businness;

import java.util.List;

import br.com.Estoque_De_Medicamentos.dao.DaoVenda;
import br.com.Estoque_De_Medicamentos.dao.IDaoVenda;
import br.com.Estoque_De_Medicamentos.entidade.Venda;
import br.com.Estoque_De_Medicamentos.exceptions.BusinessException;

public class BusinessVenda implements IBusinessVenda {
	
	private IDaoVenda daoVenda;
	
	public BusinessVenda() {
		this.daoVenda = new DaoVenda();
	}

	@Override
	public void salvar(Venda venda) throws BusinessException {
		try {
			this.daoVenda.salvar(venda);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void editar(Venda venda) throws BusinessException {
        try {
        	this.daoVenda.editar(venda);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public Venda buscarPorId(int id) throws BusinessException {
        try {
			return this.daoVenda.buscarPorId(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<Venda> buscarPorBusca(String busca) throws BusinessException {
        try {
        	return this.daoVenda.buscarPorBusca(busca);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
