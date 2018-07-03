package br.com.Estoque_De_Medicamentos.Businness;

import br.com.Estoque_De_Medicamentos.dao.DaoContato;
import br.com.Estoque_De_Medicamentos.dao.IDaoContato;
import br.com.Estoque_De_Medicamentos.entidade.Contato;
import br.com.Estoque_De_Medicamentos.exceptions.DaoException;

public class BusinessContato implements  IBusinessContato {
	
	private IDaoContato contato;
	
	public BusinessContato() {
		this.contato = new DaoContato();
	}

	@Override
	public void salvar(Contato contato) {
		this.contato.salvar(contato);		
	}

	@Override
	public void editar(Contato contato) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Contato buscarPorId(int id) throws DaoException {
		return this.contato.buscarPorId(id);
	}

}
