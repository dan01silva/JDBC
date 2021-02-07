package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.CategoriaDAO;
import factory.ConnectionFactory;
import modelo.Categoria;

public class CategoriaController {
	
	private CategoriaDAO categoriaDAO;
	
	public CategoriaController() {
		Connection conn = new ConnectionFactory().recuperarConexao();
		this.categoriaDAO = new CategoriaDAO(conn);
	}
	
	

	public List<Categoria> listar(){
			return this.categoriaDAO.listar();
	}
}
