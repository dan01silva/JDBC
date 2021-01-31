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
		 *  O m�todo devolve true quando o seu resultado � um java.sql.ResultSet
			e false caso contr�rio (update, delete, etc)
		 */
		boolean resultado = stm.execute("Select * from PRODUTO");
		System.out.println(resultado);

		ResultSet rts = stm.getResultSet();// retortando resultados da lista

		while (rts.next()) {
			Integer id = rts.getInt("id");
			String nome = rts.getString("nome");
			String descricao = rts.getString("descricao");
			System.out.println("id > " + id + " nome > " + nome + " desci��o > " + descricao);
		}

		System.out.println("Fechando conexao");
		conn.close();

	}

}
