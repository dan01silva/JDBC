package loja_virtual_repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		System.out.println("Abrindo conexao");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/?useTimeZone=true&serverTimezone=UTC","admin", "admin@");

		System.out.println("Fechando conexao");
		conn.close();
	}
}
