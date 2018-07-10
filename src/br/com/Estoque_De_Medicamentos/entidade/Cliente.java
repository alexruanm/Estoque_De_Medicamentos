package br.com.Estoque_De_Medicamentos.entidade;

import java.util.List;

public class Cliente {
	
	private Integer id;
	private String nome;
	private String cpf;
	private String celular;
	private Endereco endereco;
	private List<Contato> contatos;
	
	
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public List<Contato> getContatos() {
		return contatos;
	}
	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Nome: "+ getNome() +"\n Cpf: "+getCpf()+"\n";
	}

}
