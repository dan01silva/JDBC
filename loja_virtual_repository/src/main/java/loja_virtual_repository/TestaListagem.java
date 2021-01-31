package loja_virtual_repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		System.out.println("Abrindo conexao");
		ConnectionFactory connectionFactory = new ConnectionFactory();

		Connection conn = connectionFactory.recuperarConexao();

		Statement stm = conn.createStatement();
		
		/**
		 *  O método devolve true quando o seu resultado é um java.sql.ResultSet
			e false caso contrário (update, delete, etc)
		 */
		boolean resultado = stm.execute("Select * from PRODUTO");
		System.out.println(resultado);

		ResultSet rts = stm.getResultSet();// retortando resultados da lista

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
