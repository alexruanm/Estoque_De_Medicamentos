package br.com.Estoque_De_Medicamentos.dao;

import java.util.List;

import br.com.Estoque_De_Medicamentos.entidade.Cliente;
import br.com.Estoque_De_Medicamentos.entidade.Produto;
import br.com.Estoque_De_Medicamentos.exceptions.DaoException;

public interface IDaoProduto {
	
	 public Produto salvar(Produto produto)throws DaoException;
	 public void editar(Produto produto)throws DaoException;
	 public Produto buscarPorId(int id)throws DaoException;
	 public List<Produto> buscarPorBusca(String busca)throws DaoException;
	 public Produto buscarPorNomeETipo(String nome, String tipo)throws DaoException;

}
