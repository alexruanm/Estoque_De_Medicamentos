package br.com.Estoque_De_Medicamentos.entidade;

public class ItemVenda {
	
	private Integer id;
	private String produtos_comprados;
	private double valor_da_compra;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProdutos_comprados() {
		return produtos_comprados;
	}
	public void setProdutos_comprados(String produtos_comprados) {
		this.produtos_comprados = produtos_comprados;
	}
	public double getValor_da_compra() {
		return valor_da_compra;
	}
	public void setValor_da_compra(double valor_da_compra) {
		this.valor_da_compra = valor_da_compra;
	}

}
