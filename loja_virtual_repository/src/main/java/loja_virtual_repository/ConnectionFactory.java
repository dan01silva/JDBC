package loja_virtual_repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection recuperarConexao() throws SQLException{
		
		/**
		 * Crianco conexao, na URI deve conter, endereço do banco, ip da onde vai rodar,e NOME DO BANCO! configurações de time zona opcional
		 */
		return  DriverManager.getConnection("jdbc:mysql://localhost/loja_virtual?useTimeZone=true&serverTimezone=UTC","admin", "admin@");
	}
}
