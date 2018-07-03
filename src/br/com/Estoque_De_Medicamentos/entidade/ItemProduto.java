package br.com.Estoque_De_Medicamentos.entidade;

import java.sql.Date;

public class ItemProduto {
	
	private Integer id;
	private String nome;
	private Date data_fabricacao;
	private Date validade;
	private double preco;
	
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
	public void setData_fabricacao(Date data_fabricacao) {
		this.data_fabricacao = data_fabricacao;
	}
	public Date getValidade() {
		return validade;
	}
	public void setValidade(Date validade) {
		this.validade = validade;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}

}
