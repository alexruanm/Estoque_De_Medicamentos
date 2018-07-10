package br.com.Estoque_De_Medicamentos.entidade;

import java.util.List;

public class Contato {
	private Integer id;
	private String descricao;
	private Cliente cliente;
	private List<Contato> contatos;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


}
