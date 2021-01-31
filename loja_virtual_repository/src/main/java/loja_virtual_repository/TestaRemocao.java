package loja_virtual_repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connection = new ConnectionFactory();
		Connection conn = connection.recuperarConexao();
		
		Statement stm = conn.createStatement();
		
		stm.execute("DELETE FROM PRODUTO WHERE id > 2");
		
		Integer linhasModif = stm.getUpdateCount();// return quantas linhas foran modificadas
		
		System.out.println("Qtd. de linhas modificadas: "+linhasModif);
	}

}
