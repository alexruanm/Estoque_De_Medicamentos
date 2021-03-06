package br.com.Estoque_De_Medicamentos.entidade;

import java.util.List;

public class Administrador {
	
	private Integer id;
	private String login;
	private String senha;
	private String nome;
	private String cpf;
	private Endereco endereco;

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
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

	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Nome: "+ getNome() +"\n Cpf: "+getCpf()+"\n Login: "+getLogin()+"\n";
	}
}
