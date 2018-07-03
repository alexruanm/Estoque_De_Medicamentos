package br.com.Estoque_De_Medicamentos.entidade;

import java.sql.Date;

public class Produto {
	
	private Integer id;
	private String fornecedor;
	private Date data_entrega;
	private Integer quantidade; 
	private ItemProduto itemProduto;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}
	public Date getData_entrega() {
		return data_entrega;
	}
	public void setData_entrega(Date data_entrega) {
		this.data_entrega = data_entrega;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public ItemProduto getItemProduto() {
		return itemProduto;
	}
	public void setItemProduto(ItemProduto itemProduto) {
		this.itemProduto = itemProduto;
	}

}
