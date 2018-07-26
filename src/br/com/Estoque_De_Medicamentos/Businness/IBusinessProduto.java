package br.com.Estoque_De_Medicamentos.Businness;

import java.util.List;

import br.com.Estoque_De_Medicamentos.entidade.Produto;
import br.com.Estoque_De_Medicamentos.exceptions.BusinessException;


public interface IBusinessProduto {
	
	 public Produto salvar(Produto produto)throws BusinessException;
	 public void editar(Produto produto)throws BusinessException;
	 public Produto buscarPorId(int id)throws BusinessException;
	 public List<Produto> buscarPorBusca(String busca)throws BusinessException;

}
