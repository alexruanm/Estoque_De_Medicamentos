package br.com.Estoque_De_Medicamentos.entidade;

import java.sql.Date;

public class Venda {

	private Integer id;
	private String comprador;
	private String vendedor;
	private Date dataComprar;
	private ItemVenda itemVenda;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getComprador() {
		return comprador;
	}
	public void setComprador(String comprador) {
		this.comprador = comprador;
	}
	public String getVendedor() {
		return vendedor;
	}
	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}
	public Date getDataComprar() {
		return dataComprar;
	}
	public void setDataComprar(Date dataComprar) {
		this.dataComprar = dataComprar;
	}
	public ItemVenda getItemVenda() {
		return itemVenda;
	}
	public void setItemVenda(ItemVenda itemVenda) {
		this.itemVenda = itemVenda;
	}
	

	
	
}
