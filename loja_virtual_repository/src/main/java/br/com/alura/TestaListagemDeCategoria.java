package br.com.alura;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import DAO.CategoriaDAO;
import factory.ConnectionFactory;
import modelo.Categoria;
import modelo.Produto;

public class TestaListagemDeCategoria {

	public static void main(String[] args) throws SQLException {

		try (Connection conn = new ConnectionFactory().recuperarConexao()) {
			CategoriaDAO categoriaDAO = new CategoriaDAO(conn);
			List<Categoria> listaCategorias = categoriaDAO.listarComProdutos();

			listaCategorias.stream().forEach(ct -> {
				System.out.println(ct.getNome());
					for (Produto produto : ct.getProdutos()) {
						System.out.println(ct.getNome() + " : " + produto.getNome());
					}
			});
		}
	}
}