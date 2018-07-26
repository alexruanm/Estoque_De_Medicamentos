package br.com.Estoque_De_Medicamentos.entidade;

import java.util.List;

public class Fornecedor {
	
	private Integer id;
	private String nome;
	private String cnpj;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the cnpj
	 */
	public String getCnpj() {
		return cnpj;
	}
	/**
	 * @param cnpj the cnpj to set
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	/**
	 * @return the produtos
	 */

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Fornecedor Nome: "+getNome()+"\nCNPJ: "+getCnpj();
	}
	

}
