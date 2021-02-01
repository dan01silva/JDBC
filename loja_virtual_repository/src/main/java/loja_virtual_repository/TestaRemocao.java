package loja_virtual_repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connection = new ConnectionFactory();
		Connection conn = connection.recuperarConexao();
		
		PreparedStatement pst = conn.prepareStatement("DELETE FROM PRODUTO WHERE id > ?");
		pst.setInt(1, 2);//definindo valor do atributo
		pst.execute();
		
		Integer linhasModif = pst.getUpdateCount();// return quantas linhas foran modificadas
		
		System.out.println("Qtd. de linhas modificadas: "+linhasModif);
	}

}
