package br.com.Estoque_De_Medicamentos.Businness;

import java.util.List;

import br.com.Estoque_De_Medicamentos.entidade.Venda;
import br.com.Estoque_De_Medicamentos.exceptions.BusinessException;


public interface IBusinessVenda {
	
	 public void salvar(Venda venda)throws BusinessException;
	 public void editar(Venda venda)throws BusinessException;
	 public Venda buscarPorId(int id)throws BusinessException;
	 public List<Venda> buscarPorBusca(String busca)throws BusinessException;

}
