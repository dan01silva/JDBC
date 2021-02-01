package loja_virtual_repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		try (Connection conn = connectionFactory.recuperarConexao();) {
			System.out.println("Auto commit Estado Atual: " + conn.getAutoCommit());
			System.out.println("Desligando Auto Commit...");
			conn.setAutoCommit(false);

			try (PreparedStatement pst = conn.prepareStatement("insert into produto(nome, descricao) VALUES ( ? , ?)",
					Statement.RETURN_GENERATED_KEYS);
			// com isso não precisamos mais dar o close no Statement
			) {

				adicionarVariavel("Smart TV", "45 polegadas", pst);
				adicionarVariavel("Rádio", "Rádio de Pilha", pst);
				adicionarVariavel("Mackbook", "PC Apple", pst);

				conn.commit();

				pst.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ROLLBACK EXECUTADO");
				conn.rollback();// desfazedo toda as inserções caso de erro
			}
		}
	}

	public static void adicionarVariavel(String nome, String descricao, PreparedStatement pst) throws SQLException {
		pst.setString(1, nome);
		pst.setString(2, descricao);
		if (nome.equals("Rádio")) {
			throw new RuntimeException("Não foi possivel adicionar o produto ");
		}
		pst.execute();

		try (ResultSet rts = pst.getGeneratedKeys()) {

			while (rts.next()) {
				Integer id = rts.getInt(1);
				System.out.println(" O id criado foi: " + id);
			}
		}
	}
}
