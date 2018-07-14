package br.com.Estoque_De_Medicamentos.Businness;

import java.util.List;

import br.com.Estoque_De_Medicamentos.dao.DaoFuncionario;
import br.com.Estoque_De_Medicamentos.dao.IDaoFuncionario;
import br.com.Estoque_De_Medicamentos.entidade.Funcionario;
import br.com.Estoque_De_Medicamentos.exceptions.BusinessException;

public class BusinessFuncionario implements IBusinessFuncionario{

	private IDaoFuncionario funcionario;
	
	public BusinessFuncionario() {
		this.funcionario= new DaoFuncionario();
	}
	@Override
	public void salvar(Funcionario funcionario) throws BusinessException {
		try {
			this.funcionario.salvar(funcionario);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void editar(Funcionario funcionario) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Funcionario buscarPorId(int id) throws BusinessException {
		try {
			this.funcionario.buscarPorId(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public Funcionario buscarPorCpf(String cpf) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> buscarPorBusca(String busca) throws BusinessException {
		try {
			this.funcionario.buscarPorBusca(busca);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
