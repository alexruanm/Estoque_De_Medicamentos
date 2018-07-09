package br.com.Estoque_De_Medicamentos.sql;

public class SQLEstoque {
	
	public static String url="jdbc:postgresql://localhost:5432/EstoqueMedicamento";
	public static String usuario="postgres";
	public static String senha="postgres";
	
	
	// SQL Endereco
	public static final String insert_Endereco_All="insert into endereco (bairro, cidade, rua, numero) "
			+ "values (?,?,?,?) ";
	public static final String update_Endereco_All="UPDATE endereco SET bairro= ?, cidade= ?, rua= ?, numero= ? WHERE id = ?";
	
	
	// SQL Produto
	public static final String insert_Produto_All="insert into produto (fornecedor,"
			+ "data_entrega,"
			+ "quantidade,"
			+ "id_prod) "
			+ "values (?) ";
	
	// SQL Item Produto
	public static final String insert_ItemProduto_All="insert into item_produto"
			+ "nome," + 
			"  validade," + 
			"  data_fabricao," + 
			"  preco) "
			+ "values (?,?,?,?) ";
	
	// SQL Venda
	public static final String insert_Venda_All="insert into venda (comprador,vendedor, data_comprar,id_item_venda) "
			+ "values (?,?,?,?) ";
	public static final String update_Venda_All="UPDATE endereco SET comprador=?,vendedor = ?, data_comprar=?,id_item_venda=? WHERE id = ?";
	
	

	// SQL Item Venda
	public static final String insert_ItemVenda_All="insert into item_venda (produtos_comprados," + 
			"  valor_da_compra) "
			+ "values (?,?) ";
	
	// SQL Cliente
	public static final String insert_Cliente_All="insert into cliente (nome," + 
			"  cpf," + 
			"  endereco_cliente"
			+ "celular) "
			+ "values (?,?,?,?) ";
	
	// SQL Funcionario
	public static final String insert_Funcionario_All="insert into endereco (login," + 
			"  senha," + 
			"  nome," + 
			"  cpf," + 
			"  endereco_fun "
			+ "celular) "
			+ "values (?,?,?,?,?,?) ";
	
	// SQL Administrador
	public static final String insert_Administrador_All="insert into administrador (login," + 
			"senha," + 
			"nome," + 
			"cpf," + 
			"endereco_fun," + 
			"celular) " + 
			"values (?,?,?,?,?,?) ";
	// SQL Contato
	public static final String insert_Contato_All="insert into contato (descricao,id_cliente) "
			+ "values (?,?) ";
}
