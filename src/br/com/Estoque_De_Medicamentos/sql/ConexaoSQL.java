package br.com.Estoque_De_Medicamentos.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;




public class ConexaoSQL {
	
	  public static final String NOME_BD_CONNECTION_POSTGRESS = "POSTGRES";
	  public static final String NOME_BD_CONNECTION_MYSQL = "MYSQL";
	  private static Connection conexao = null;
	
	 public static synchronized Connection getConnectionInstance(String bd) {
	        try {
	            if (conexao == null || conexao.isClosed()) {

	                switch (bd) {
	                    case NOME_BD_CONNECTION_POSTGRESS: {

	                        conexao = DriverManager.getConnection(
	                                SQLEstoque.url,
	                                SQLEstoque.usuario,
	                                SQLEstoque.senha
	                               
	                        );
	                        System.out.println("Conexão Realizada Com Sucesso");
	                    }
	                    break;
	                    case NOME_BD_CONNECTION_MYSQL:
	                        break;
	                }

	            }
	            
	        } catch (SQLException ex) {
//	            Logger.getLogger(SQLConnection.class.getName()).log(Level.SEVERE, null, ex);
	            ex.printStackTrace();
	        }
	        return conexao;

	    }
		public static int getCurrentValorTabela(String nomeTabela) {
			
			int id = 0;
			try {
				Connection conexao = ConexaoSQL.getConnectionInstance(ConexaoSQL.NOME_BD_CONNECTION_POSTGRESS);
				PreparedStatement statement = conexao.prepareStatement("select * from " + nomeTabela + " order by id desc limit 1");
				ResultSet result = statement.executeQuery();
				result.next();
				id = result.getInt(1);

			} catch (Exception ex) {
				ex.printStackTrace();
				
			}
			return id;
		}

}
