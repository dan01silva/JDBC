package loja_virtual_repository;

import java.sql.SQLException;

public class TestaPoolDeConexoes {

	public static void main(String[] args) throws Exception {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		for (int i = 0; i <= 20; i++) {
			connectionFactory.recuperarConexao();
			System.out.println("Conex�o de n�mero: " + i);
		}
	}
}
