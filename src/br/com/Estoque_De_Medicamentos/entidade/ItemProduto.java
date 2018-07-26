package br.com.Estoque_De_Medicamentos.entidade;

import java.util.Date;

public class ItemProduto {
	
	private Integer id;
	private String nome;
	private Date data_entreda;
	private Date data_fabricacao;
	private Date data_validade;
	private Integer quantidade;
	private double valor;
	private Fornecedor fornecedor;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getData_fabricacao() {
		return data_fabricacao;
	}
	public void setData_fabricacao(Date date) {
		this.data_fabricacao = date;
	}
	/**
	 * @return the data_entreda
	 */
	public Date getData_entreda() {
		return data_entreda;
	}
	/**
	 * @param data_entreda the data_entreda to set
	 */
	public void setData_entreda(Date data_entreda) {
		this.data_entreda = data_entreda;
	}
	/**
	 * @return the data_validade
	 */
	public Date getData_validade() {
		return data_validade;
	}
	/**
	 * @param data_validade the data_validade to set
	 */
	public void setData_validade(Date data_validade) {
		this.data_validade = data_validade;
	}
	/**
	 * @return the quantidade
	 */
	public Integer getQuantidade() {
		return quantidade;
	}
	/**
	 * @param quantidade the quantidade to set
	 */
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	/**
	 * @return the valor
	 */
	public double getValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}
	/**
	 * @return the fornecedor
	 */
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	/**
	 * @param fornecedor the fornecedor to set
	 */
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}


}
