package br.com.Estoque_De_Medicamentos.Businness;

import java.util.List;

import br.com.Estoque_De_Medicamentos.dao.DaoProduto;
import br.com.Estoque_De_Medicamentos.dao.IDaoProduto;
import br.com.Estoque_De_Medicamentos.entidade.Produto;
import br.com.Estoque_De_Medicamentos.exceptions.BusinessException;

public class BusinessProduto implements IBusinessProduto {
	
	private IDaoProduto daoProduto;
	
	public BusinessProduto() {
		this.daoProduto= new DaoProduto();
	}

	@Override
	public Produto salvar(Produto produto) throws BusinessException {
		try {
			return this.daoProduto.salvar(produto);
		} catch (Exception e) {
			// TODO: handle exception
		}	
		return null;
	}

	@Override
	public void editar(Produto produto) throws BusinessException {
		try {
			this.daoProduto.editar(produto);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public Produto buscarPorId(int id) throws BusinessException {
		try {
			return this.daoProduto.buscarPorId(id);
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public List<Produto> buscarPorBusca(String busca) throws BusinessException {
		try {
			return this.daoProduto.buscarPorBusca(busca);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
