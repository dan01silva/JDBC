package br.com.alura;

import java.sql.SQLException;

import factory.ConnectionFactory;

public class TestaPoolDeConexoes {

	public static void main(String[] args) throws Exception {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		for (int i = 0; i <= 20; i++) {
			connectionFactory.recuperarConexao();
			System.out.println("Conexão de número: " + i);
		}
	}
}
