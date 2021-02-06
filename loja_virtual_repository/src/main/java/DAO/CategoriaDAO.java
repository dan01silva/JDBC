package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Categoria;
import modelo.Produto;

public class CategoriaDAO {

	private Connection connection;

	public CategoriaDAO(Connection connection) {
		this.connection = connection;
	}

	public List<Categoria> listar() throws SQLException {
		List<Categoria> categorias = new ArrayList<>();

		String sql = "select ID, NOME from CATEGORIA";

		try (PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.execute();

			try (ResultSet rts = pst.getResultSet()) {
				while (rts.next()) {
					Categoria categoria = new Categoria(rts.getInt(1), rts.getString(2));
					categorias.add(categoria);
				}
			}
		}
		return categorias;
	}

	public List<Categoria> listarComProdutos() throws SQLException {
		Categoria ultima = null;
		List<Categoria> categorias = new ArrayList<>();

		String sql = "select ct.ID, ct.NOME, pt.id, pt.nome, pt.descricao from produto pt inner join categoria ct on pt.CATEGORIA_ID = ct.ID";

		try (PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.execute();

			try (ResultSet rts = pst.getResultSet()) {
				while (rts.next()) {
					if (ultima == null || !ultima.getNome().equals(rts.getString(2))) {
						Categoria categoria = new Categoria(rts.getInt(1), rts.getString(2));
						ultima = categoria;
						categorias.add(categoria);
					}
					Produto produto = new Produto(rts.getInt(3), rts.getString(4), rts.getString(5));
					ultima.adicionaProd(produto);
				}
			}
			return categorias;
		}
	}
}
