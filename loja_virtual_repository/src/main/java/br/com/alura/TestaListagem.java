package br.com.alura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import factory.ConnectionFactory;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		System.out.println("Abrindo conexao");
		ConnectionFactory connectionFactory = new ConnectionFactory();

		Connection conn = connectionFactory.recuperarConexao();

		PreparedStatement pst = conn.prepareStatement("Select * from PRODUTO");//evitando sql INjection
		
		/**
		 *  O método devolve true quando o seu resultado é um java.sql.ResultSet
			e false caso contrário (update, delete, etc)
		 */
		boolean resultado = pst.execute();
		System.out.println(resultado);

		ResultSet rts = pst.getResultSet();// retortando resultados da lista

		while (rts.next()) {
			Integer id = rts.getInt("id");
			String nome = rts.getString("nome");
			String descricao = rts.getString("descricao");
			System.out.println("id > " + id + " nome > " + nome + " descição > " + descricao);
		}

		System.out.println("Fechando conexao");
		conn.close();

	}

}
