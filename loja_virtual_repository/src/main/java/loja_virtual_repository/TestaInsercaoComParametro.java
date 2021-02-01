package loja_virtual_repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException{
		
		String nome = "mouse'";
		String descricao = "Mouse sem fio";
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection conn = connectionFactory.recuperarConexao();
		
		PreparedStatement pst = conn.prepareStatement("insert into produto(nome, descricao) VALUES ( ? , ?)", Statement.RETURN_GENERATED_KEYS);
		pst.setString(1, nome);
		pst.setString(2, descricao);
		
		pst.execute();
		
		ResultSet rts = pst.getGeneratedKeys();
		
		while (rts.next()) {
			Integer id = rts.getInt(1);	
			System.out.println(" O id criado foi: " + id);
		}
	} 
}
