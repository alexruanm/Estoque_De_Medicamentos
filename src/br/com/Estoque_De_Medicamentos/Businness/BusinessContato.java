package br.com.Estoque_De_Medicamentos.Businness;

import java.util.List;

import br.com.Estoque_De_Medicamentos.dao.DaoContato;
import br.com.Estoque_De_Medicamentos.dao.IDaoContato;
import br.com.Estoque_De_Medicamentos.entidade.Contato;
import br.com.Estoque_De_Medicamentos.exceptions.BusinessException;
import br.com.Estoque_De_Medicamentos.exceptions.DaoException;

public class BusinessContato implements  IBusinessContato {
	
	private IDaoContato contato;
	
	public BusinessContato() {
		this.contato = new DaoContato();
	}

	@Override
	public void salvar(Contato contato) throws BusinessException {
		try {
			this.contato.salvar(contato);	
		} catch (Exception e) {
			// TODO: handle exception
		}
			
	}

	@Override
	public void editar(Contato contato) throws BusinessException {
		try {
			this.contato.editar(contato);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public List<Contato> buscarPorIdCliente(int id) throws BusinessException {
		try {
			return this.contato.buscarPorIdCliente(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
