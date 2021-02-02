package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import loja_virtual_repository.ConnectionFactory;
import modelo.Produto;

public class ProdutoDAO {// Data Access Object - CLASSE DAO (persistência)
	private Connection connection;

	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}

	public void salvar(Produto produto) throws Exception {
		try (Connection conn = new ConnectionFactory().recuperarConexao()) {

			String isertSql = " INSERT INTO PRODUTO(NOME,DESCRICAO) VALUE(? , ?) ";
			try (PreparedStatement pst = conn.prepareStatement(isertSql, Statement.RETURN_GENERATED_KEYS)) {
				pst.setString(1, produto.getNome());
				pst.setString(2, produto.getDescricao());

				pst.execute();

				try (ResultSet rts = pst.getGeneratedKeys()) {
					while (rts.next()) {
						produto.setId(rts.getInt(1));
					}
				}
			}
		}
	}

	public List<Produto> listar() throws SQLException {
		List<Produto> produtos = new ArrayList<Produto>();
		String isertSql = " INSERT INTO PRODUTO(NOME,DESCRICAO) VALUE(? , ?)";

		try (PreparedStatement pst = connection.prepareStatement(isertSql)) {
			pst.execute();

			try (ResultSet rts = pst.getResultSet()) {
				while (rts.next()) {
					Produto novoProduto = new Produto(rts.getInt(1), rts.getString(2), rts.getString(3));
					produtos.add(novoProduto);
				}
			}
		}
		return produtos;
	}
}