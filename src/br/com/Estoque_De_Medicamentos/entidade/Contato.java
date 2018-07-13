package br.com.Estoque_De_Medicamentos.entidade;

import java.util.List;

public class Contato {
	
	private Integer id;
	private String descricao;
	private String tipo;
	
	
	public Contato(String descricao, String tipo) {
		super();
		this.descricao = descricao;
		this.tipo = tipo;
	}
	public Contato() {
		
	}
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
