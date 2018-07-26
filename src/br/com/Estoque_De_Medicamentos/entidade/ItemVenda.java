package br.com.Estoque_De_Medicamentos.entidade;

import java.util.Date;
import java.util.List;

public class ItemVenda {
	
	private Integer id;
	private ItemProduto produtos_comprados;
	private double valor_da_compra;
	private Date data_da_comprar;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getValor_da_compra() {
		return valor_da_compra;
	}
	public void setValor_da_compra(double valor_da_compra) {
		this.valor_da_compra = valor_da_compra;
	}
	

}
